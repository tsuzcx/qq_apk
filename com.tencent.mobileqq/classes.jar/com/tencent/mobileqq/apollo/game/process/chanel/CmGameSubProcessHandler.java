package com.tencent.mobileqq.apollo.game.process.chanel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtDeviceUtil;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.ads.CmGameBannerAds;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher.RedPacketInfo;
import com.tencent.mobileqq.apollo.game.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.game.process.download.CmGameSubRscHandler;
import com.tencent.mobileqq.apollo.game.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.game.process.ui.NativeUIManager;
import com.tencent.mobileqq.apollo.game.ranklist.CmGameUserInfo;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ChannelConst;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;

public class CmGameSubProcessHandler
  implements IRequestHandler
{
  public static int a = 1;
  public static int b = 2;
  public static int c = 3;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, CmGameUserInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private HashMap<String, Bitmap> b = new HashMap();
  private int d;
  private int e = 1;
  
  public CmGameSubProcessHandler(int paramInt, Activity paramActivity)
  {
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[onFirstFrameDrawn]");
    }
    Object localObject = CmGameUtil.a(this.jdField_d_of_type_Int);
    if (localObject == null) {
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    if (localObject != null)
    {
      long l2 = ((StartCheckParam)localObject).startT;
      if (l2 > 0L)
      {
        long l1 = System.currentTimeMillis();
        l2 = l1 - l2;
        l1 -= ((StartCheckParam)localObject).startCallEngine;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startApolloGame initGameCost: ");
        localStringBuilder.append(l1);
        localStringBuilder.append(", totalCost:");
        localStringBuilder.append(l2);
        QLog.i("cmgame_process.CmGameSubProcessHandler", 1, localStringBuilder.toString());
        if (l2 > 20000L)
        {
          QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "sth must be wrong because it's too long.");
          return;
        }
        int i = this.jdField_d_of_type_Int;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(l1);
        localStringBuilder.append("");
        VipUtils.a(null, "cmshow", "Apollo", "start_game_time_cost", 0, 0, new String[] { String.valueOf(i), String.valueOf(l2), localStringBuilder.toString() });
        ((StartCheckParam)localObject).startT = -1L;
      }
    }
  }
  
  private void a(long paramLong)
  {
    try
    {
      ApolloRender.stopGyroSensor();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localException, new Object[0]);
    }
  }
  
  private void a(long paramLong, int paramInt, CmGameLauncher.RedPacketInfo paramRedPacketInfo)
  {
    ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, paramInt, "cs.get_redPacket_result.local", paramRedPacketInfo.a());
    paramRedPacketInfo.jdField_b_of_type_Int = 0;
    paramRedPacketInfo.jdField_a_of_type_Boolean = false;
  }
  
  private void a(long paramLong, String paramString, DoraemonAPIManager paramDoraemonAPIManager)
  {
    if (paramDoraemonAPIManager == null) {
      return;
    }
    String str;
    if ("cs.get_app_friends.local".equals(paramString)) {
      str = "getAppFriends";
    } else if ("cs.get_user_info.local".equals(paramString)) {
      str = "getUserInfo";
    } else if ("cs.get_location.local".equals(paramString)) {
      str = "getLocation";
    } else if ("cs.get_city.local".equals(paramString)) {
      str = "getCity";
    } else {
      str = "";
    }
    if (TextUtils.isEmpty(str))
    {
      paramDoraemonAPIManager = new StringBuilder();
      paramDoraemonAPIManager.append("invalid cmd:");
      paramDoraemonAPIManager.append(paramString);
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, paramDoraemonAPIManager.toString());
      return;
    }
    paramDoraemonAPIManager.a(str, null, new CmGameSubProcessHandler.2(this, paramString, paramLong));
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    Object localObject = CmGameUtil.a(this.jdField_d_of_type_Int);
    if (localObject == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("[showBannerAds], launcher is null, mGameId:");
      paramString1.append(this.jdField_d_of_type_Int);
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, paramString1.toString());
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    if (localObject == null) {
      return;
    }
    ((CmGameBannerAds)localObject).a(paramLong, paramString1, paramString2);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[nofityApiRequestFailure], cmd:", paramString, ",code:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", paramInt);
      ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, paramInt, paramString, localJSONObject.toString());
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilRegexPattern == null)
    {
      localObject = CmGameUtil.a();
      if (localObject != null)
      {
        localObject = ((CmGameManager)localObject).a(this.jdField_d_of_type_Int);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isValidSsoCmd cmd:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", rule: ");
          localStringBuilder.append((String)localObject);
          QLog.w("cmgame_process.CmGameSubProcessHandler", 1, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile((String)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_JavaUtilRegexPattern;
    if (localObject == null) {
      return false;
    }
    boolean bool = ((Pattern)localObject).matcher(paramString).matches();
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ssoCmdRule,fail to match sso cmd, cmd:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", gameId: ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    Object localObject1;
    if ((!paramString1.startsWith("cs.")) && (!paramString1.endsWith(".local")) && (!ChannelConst.a(paramString1)) && (a(paramString1))) {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ssoCmdRule, [game],cmd:");
        ((StringBuilder)localObject1).append(paramString1);
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString2);
        paramString2 = new StringBuilder();
        paramString2.append("cmshow_game_");
        paramString2.append(this.jdField_d_of_type_Int);
        ((JSONObject)localObject2).put("from", paramString2.toString());
        if ("apollo_router_game.apollo_user_rankinglist_linkcmd_custom_ranking".equals(paramString1))
        {
          paramString2 = CmGameUtil.a(this.jdField_d_of_type_Int);
          if ((paramString2 != null) && (paramString2.a() != null) && (!TextUtils.isEmpty(paramString2.a().sessionUin)))
          {
            if (((JSONObject)localObject2).optInt("rankType", 0) != 0)
            {
              ((JSONObject)localObject2).put("rankType", ApolloUtilImpl.transStype2Rtype(paramString2.a().sessionType));
              ((JSONObject)localObject2).put("sessionId", Integer.parseInt(paramString2.a().sessionUin));
              paramString2 = CmGameUtil.a();
              if (paramString2 != null)
              {
                localObject1 = (TicketManager)paramString2.getManager(2);
                if (localObject1 != null)
                {
                  localObject1 = ((TicketManager)localObject1).getSkey(paramString2.getCurrentAccountUin());
                  paramString2 = (String)localObject1;
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    paramString2 = "";
                  }
                  ((JSONObject)localObject2).put("skey", paramString2);
                }
              }
            }
          }
          else {
            QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[isSSoRequest] lancher or sessionUin is null");
          }
        }
        localObject1 = ((JSONObject)localObject2).toString();
        if (!"apollo_router_game.game_ad_linkcmd_get_ad".equals(paramString1)) {
          break label359;
        }
        paramString2 = a((String)localObject1);
        bool = true;
        localObject2 = CmGameUtil.a();
        if (localObject2 != null)
        {
          ((CmGameSSoHandler)localObject2).a(paramString1, (String)localObject1, paramLong, 4, bool, paramString2);
          return true;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "errInfo->", paramString1);
      }
      return true;
      return false;
      label359:
      paramString2 = null;
      boolean bool = false;
    }
  }
  
  private byte[] a(String paramString)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return null;
    }
    try
    {
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
      Object localObject2 = new qq_ad_get.QQAdGet.UserInfo();
      ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(l);
      localQQAdGet.user_info.set((MessageMicro)localObject2);
      paramString = new JSONObject(paramString);
      localObject2 = new ArrayList();
      qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
      localPositionInfo.pos_id.set(paramString.optString("posid"));
      localPositionInfo.ad_count.set(paramString.optInt("count", 1));
      ((List)localObject2).add(localPositionInfo);
      localQQAdGet.position_info.set((List)localObject2);
      localObject1 = GdtDeviceUtil.a((Context)localObject1);
      localQQAdGet.device_info.set((MessageMicro)localObject1);
      localObject1 = new qq_ad_get.QQAdGet.ContextInfo();
      ((qq_ad_get.QQAdGet.ContextInfo)localObject1).article_id.set(paramString.optInt("game_id"));
      localQQAdGet.context_info.set((MessageMicro)localObject1);
      paramString = localQQAdGet.toByteArray();
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "getAdPacket error:", paramString);
    }
    return null;
  }
  
  private void b()
  {
    Activity localActivity = a();
    if (localActivity != null) {
      CmGameUtil.a(this.jdField_d_of_type_Int, localActivity);
    }
  }
  
  private void c()
  {
    Activity localActivity = a();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  private void c(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[handleReportEvent] reqData=", paramString });
    }
    int i = -1;
    try
    {
      Object localObject;
      int j;
      int k;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new JSONObject(paramString);
        if ((((JSONObject)localObject).has("mid")) && (((JSONObject)localObject).has("value")))
        {
          i = ((JSONObject)localObject).optInt("mid");
          j = ((JSONObject)localObject).optInt("value");
          k = ((JSONObject)localObject).optInt("failCode", 0);
          paramString = ((JSONObject)localObject).optJSONObject("extInfo");
          localObject = CmGameUtil.a();
        }
      }
      label168:
      try
      {
        CmGameUtil.a((AppInterface)localObject, i, j, this.jdField_d_of_type_Int, k, paramString);
        i = 0;
        break label168;
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, new Object[] { "[handleReportEvent] reqData invalid, reqData=", paramString });
        break label168;
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleReportEvent] reqData null");
      }
      catch (Exception paramString) {}
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleReportEvent] e=", paramString);
    }
    catch (Exception paramString) {}
    i = -1;
    ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, i, "cs.report_event.local", "{}");
  }
  
  private void d()
  {
    try
    {
      ApolloRender.cancelVibrate(this.jdField_d_of_type_Int);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localException, new Object[0]);
    }
  }
  
  private void d(long paramLong, String paramString)
  {
    Object localObject = CmGameUtil.a(this.jdField_d_of_type_Int);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("[checkFileCorrectness], launcher is null, mGameId:");
      paramString.append(this.jdField_d_of_type_Int);
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, paramString.toString());
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    if (localObject == null) {
      return;
    }
    ((CmGameSubRscHandler)localObject).b(paramLong, paramString);
  }
  
  private void d(String paramString) {}
  
  private void e(long paramLong, String paramString)
  {
    Object localObject = CmGameUtil.a(this.jdField_d_of_type_Int);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("[handleLoadSubpack], launcher is null, mGameId:");
      paramString.append(this.jdField_d_of_type_Int);
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, paramString.toString());
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    if (localObject == null) {
      return;
    }
    ((CmGameSubRscHandler)localObject).a(paramLong, paramString);
  }
  
  private void e(String paramString)
  {
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent();
    localBundle.putInt("apollo.game.invite.from", 4);
    localBundle.putInt("forward_type", 34);
    localBundle.putString("forward.apollo.redpacket_info", paramString);
    localIntent.putExtras(localBundle);
    paramString = a();
    if (paramString != null) {
      ForwardBaseOption.a(paramString, localIntent, 20180427);
    }
  }
  
  private void f(long paramLong, String paramString)
  {
    Object localObject = CmGameUtil.a(this.jdField_d_of_type_Int);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("[getUserInfo], launcher is null, mGameId:");
      paramString.append(this.jdField_d_of_type_Int);
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, paramString.toString());
      return;
    }
    CmGameInitParams localCmGameInitParams = ((CmGameLauncher)localObject).a();
    if (localCmGameInitParams == null) {
      return;
    }
    localObject = ((CmGameLauncher)localObject).a(localCmGameInitParams.appId, ((CmGameLauncher)localObject).a());
    if (localObject == null) {
      return;
    }
    if (localCmGameInitParams.accessTokenRet != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "login first, cmd:", paramString });
      }
      ((DoraemonAPIManager)localObject).a("login", null, new CmGameSubProcessHandler.1(this, paramString, paramLong, (DoraemonAPIManager)localObject, localCmGameInitParams));
      return;
    }
    a(paramLong, paramString, (DoraemonAPIManager)localObject);
  }
  
  private void f(String paramString) {}
  
  private void g(long paramLong, String paramString)
  {
    Object localObject1 = CmGameUtil.a(this.jdField_d_of_type_Int);
    if (localObject1 == null)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[hanldeGetRedPacketResult] luncher is null");
      return;
    }
    localObject1 = ((CmGameLauncher)localObject1).a();
    if (localObject1 == null) {
      return;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("score");
      ((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_Int = i;
      int j = ((CmGameLauncher.RedPacketInfo)localObject1).jdField_a_of_type_Int;
      boolean bool;
      Object localObject2;
      Object localObject3;
      if ((j <= 0) && (((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_Int < ((CmGameLauncher.RedPacketInfo)localObject1).jdField_a_of_type_Int))
      {
        a(paramLong, 0, (CmGameLauncher.RedPacketInfo)localObject1);
        bool = "0".equals(((CmGameLauncher.RedPacketInfo)localObject1).f);
        paramString = (IQWalletApi)QRoute.api(IQWalletApi.class);
        localObject2 = ((CmGameLauncher.RedPacketInfo)localObject1).jdField_b_of_type_JavaLangString;
        paramLong = ((CmGameLauncher.RedPacketInfo)localObject1).jdField_a_of_type_Long;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_Int);
        ((StringBuilder)localObject3).append("");
        paramString.reqReportHBGame((String)localObject2, paramLong, ((StringBuilder)localObject3).toString(), Integer.parseInt(((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_JavaLangString), bool, false, this.jdField_d_of_type_Int);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[hanldeGetRedPacketResult] score:");
        paramString.append(((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_Int);
        paramString.append("info.grabState:");
        paramString.append(((CmGameLauncher.RedPacketInfo)localObject1).jdField_b_of_type_Int);
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, paramString.toString());
      }
      if (((CmGameLauncher.RedPacketInfo)localObject1).jdField_b_of_type_Int == 3)
      {
        a(paramLong, 0, (CmGameLauncher.RedPacketInfo)localObject1);
        bool = "0".equals(((CmGameLauncher.RedPacketInfo)localObject1).f);
        paramString = (IQWalletApi)QRoute.api(IQWalletApi.class);
        localObject2 = ((CmGameLauncher.RedPacketInfo)localObject1).jdField_b_of_type_JavaLangString;
        paramLong = ((CmGameLauncher.RedPacketInfo)localObject1).jdField_a_of_type_Long;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_Int);
        ((StringBuilder)localObject3).append("");
        paramString.reqReportHBGame((String)localObject2, paramLong, ((StringBuilder)localObject3).toString(), Integer.parseInt(((CmGameLauncher.RedPacketInfo)localObject1).jdField_d_of_type_JavaLangString), bool, false, this.jdField_d_of_type_Int);
        return;
      }
      if (((CmGameLauncher.RedPacketInfo)localObject1).jdField_b_of_type_Int != 0)
      {
        ((CmGameLauncher.RedPacketInfo)localObject1).jdField_a_of_type_Boolean = true;
        return;
      }
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        paramString = (IQWalletApi)QRoute.api(IQWalletApi.class);
        localObject2 = CmGameUtil.a();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((CmGameLauncher.RedPacketInfo)localObject1).g);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.jdField_d_of_type_Int);
        ((StringBuilder)localObject4).append("");
        localObject4 = ((StringBuilder)localObject4).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        paramString.GrapHbWithParam((AppInterface)localObject2, (String)localObject3, (String)localObject4, localStringBuilder.toString(), new CmGameSubProcessHandler.3(this, null, paramLong));
      }
      ((CmGameLauncher.RedPacketInfo)localObject1).jdField_b_of_type_Int = 1;
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void g(String paramString)
  {
    AppInterface localAppInterface = CmGameUtil.a();
    if (localAppInterface != null) {
      ApolloGameBasicEventUtil.a(localAppInterface, paramString);
    }
  }
  
  private void h(long paramLong, String paramString)
  {
    Object localObject1 = CmGameUtil.a(this.jdField_d_of_type_Int);
    if (localObject1 == null) {
      return;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("score");
      paramString = ((CmGameLauncher)localObject1).a();
      if (paramString != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("gameScore:");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(",target:");
        ((StringBuilder)localObject1).append(paramString.jdField_a_of_type_Int);
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, ((StringBuilder)localObject1).toString());
        if ((paramString.jdField_a_of_type_Int > 0) && (i >= paramString.jdField_a_of_type_Int) && (paramString.jdField_b_of_type_Int == 0))
        {
          localObject1 = (IQWalletApi)QRoute.api(IQWalletApi.class);
          AppInterface localAppInterface = CmGameUtil.a();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString.g);
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.jdField_d_of_type_Int);
          ((StringBuilder)localObject3).append("");
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(i);
          localStringBuilder.append("");
          ((IQWalletApi)localObject1).GrapHbWithParam(localAppInterface, (String)localObject2, (String)localObject3, localStringBuilder.toString(), new CmGameSubProcessHandler.4(this, null, paramLong));
          paramString.jdField_b_of_type_Int = 1;
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void i(long paramLong, String paramString)
  {
    Object localObject = CmGameUtil.b(paramLong);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = CmGameUtil.a((int)paramLong);
    }
    if (paramString == null) {
      return;
    }
    localObject = paramString.a();
    if (localObject == null) {
      return;
    }
    paramString = paramString.a(((CmGameInitParams)localObject).appId, paramString.a());
    if (paramString == null)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 2, "fail to create DoraemonAPIManager.");
      return;
    }
    paramString.a("login", null, new CmGameSubProcessHandler.6(this, (CmGameInitParams)localObject, paramLong));
    try
    {
      paramString = new JSONObject();
      paramString.put("ret", 0);
      paramString.put("type", "complete");
      ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 0, "cs.xy_login.local", paramString.toString());
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  private void j(long paramLong, String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optJSONArray("pattern");
      int j = ((JSONObject)localObject).getInt("repeate");
      localObject = new long[paramString.length()];
      int i = 0;
      while (i < paramString.length())
      {
        localObject[i] = paramString.getLong(i);
        i += 1;
      }
      ApolloRender.vibrate(this.jdField_d_of_type_Int, paramLong, (long[])localObject, j);
      return;
    }
    catch (Exception paramString)
    {
      ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 6, "cs.xy_device_vibrate.local", "{}");
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  private void k(long paramLong, String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("interval");
      ApolloRender.startGyroSensor(this.jdField_d_of_type_Int, paramLong, i);
      return;
    }
    catch (Exception paramString)
    {
      ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 4, "cs.xy_device_gyro_sensor_start.local", "{}");
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public Activity a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public HandleResult a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[handleCmd], cmd:", paramString1 });
    }
    CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_d_of_type_Int);
    if ((localCmGameLauncher != null) && (!localCmGameLauncher.a()))
    {
      if (paramLong != localCmGameLauncher.a()) {
        return null;
      }
    }
    else
    {
      if (localCmGameLauncher == null) {
        break label665;
      }
      if (localCmGameLauncher.a() == null) {
        return null;
      }
      if (localCmGameLauncher.a().getLuaState() != paramLong)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "abandon it, not the same jsState.");
        }
        return null;
      }
    }
    if (a(paramString1, paramString2, paramLong)) {
      return new HandleResult();
    }
    if ("cs.join_room.local".equals(paramString1))
    {
      f(paramString2);
      return null;
    }
    if ("cs.make_room_min.local".equals(paramString1))
    {
      b();
      return null;
    }
    if ("cs.close_room.local".equals(paramString1))
    {
      c();
      return null;
    }
    if ("cs.report_data_2_compass.local".equals(paramString1))
    {
      g(paramString2);
      return null;
    }
    if ("cs.send_b2c_redpacket.local".equals(paramString1))
    {
      e(paramString2);
      return null;
    }
    if ("cs.qta_notify_test_result.local".equals(paramString1))
    {
      d(paramString2);
      return null;
    }
    if ("cs.first_frame_drawn.local".equals(paramString1))
    {
      a();
      return null;
    }
    if ("cs.apolloGameWebMessage.local".equals(paramString1))
    {
      ApolloGameBasicEventUtil.a(paramString2);
      return null;
    }
    if ("cs.enter_pubAccount_card.local".equals(paramString1))
    {
      c(paramString2);
      return null;
    }
    if ("cs.game_update_score.local".equals(paramString1))
    {
      h(paramLong, paramString2);
      return null;
    }
    if ("cs.get_redPacket_result.local".equals(paramString1))
    {
      g(paramLong, paramString2);
      return null;
    }
    if ("cs.fetch_cloud_signature.local".equals(paramString1))
    {
      a(paramString2, paramLong);
      return null;
    }
    if ("cs.closeWebview.local".equals(paramString1))
    {
      a(paramString2);
      return null;
    }
    if ("cs.apolloGameTargetWebMessage.local".equals(paramString1))
    {
      b(paramString2);
      return null;
    }
    if ((!"cs.get_user_info.local".equals(paramString1)) && (!"cs.get_app_friends.local".equals(paramString1)) && (!"cs.get_location.local".equals(paramString1)) && (!"cs.get_city.local".equals(paramString1)))
    {
      if ("cs.load_subpackage.local".equals(paramString1))
      {
        e(paramLong, paramString2);
        return null;
      }
      if ("cs.file_correctness_check.local".equals(paramString1))
      {
        d(paramLong, paramString2);
        return null;
      }
      if ("cs.preload_userInfoList.local".equals(paramString1))
      {
        a(paramLong, paramString2);
        return null;
      }
      if ((!"cs.game_ad_banner_load.local".equals(paramString1)) && (!"cs.game_ad_banner_show.local".equals(paramString1)) && (!"cs.game_ad_banner_close.local".equals(paramString1)) && (!"cs.game_ad_banner_resize.local".equals(paramString1)) && (!"cs.game_ad_banner_hide.local".equals(paramString1)))
      {
        if ("cs.xy_error_info.local".equals(paramString1))
        {
          b(paramLong, paramString2);
          return null;
        }
        if ("cs.xy_login.local".equals(paramString1))
        {
          i(paramLong, paramString2);
          return null;
        }
        if ("cs.xy_device_vibrate.local".equals(paramString1))
        {
          j(paramLong, paramString2);
          return null;
        }
        if ("cs.xy_device_vibrate_cancel.local".equals(paramString1))
        {
          d();
          return null;
        }
        if ("cs.xy_device_gyro_sensor_start.local".equals(paramString1))
        {
          k(paramLong, paramString2);
          return null;
        }
        if ("cs.xy_device_gyro_sensor_stop.local".equals(paramString1))
        {
          a(paramLong);
          return null;
        }
        if ("cs.report_event.local".equals(paramString1))
        {
          c(paramLong, paramString2);
          return null;
        }
      }
      else
      {
        a(paramLong, paramString1, paramString2);
        return null;
      }
    }
    else
    {
      f(paramLong, paramString1);
    }
    label665:
    return null;
  }
  
  public void a(long paramLong, String paramString)
  {
    Object localObject1 = CmGameUtil.a();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = CmGameUtil.a(this.jdField_d_of_type_Int);
      if (localObject2 == null)
      {
        paramString = new StringBuilder();
        paramString.append("[getUserInfo], launcher is null, mGameId:");
        paramString.append(this.jdField_d_of_type_Int);
        QLog.w("cmgame_process.CmGameSubProcessHandler", 1, paramString.toString());
        return;
      }
      localObject2 = ((CmGameLauncher)localObject2).a();
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject3 = new JSONObject(paramString).optJSONArray("openIdList");
        paramString = new JSONArray();
        i = 0;
        if (i < ((JSONArray)localObject3).length())
        {
          String str = ((JSONArray)localObject3).getString(i);
          if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
            break label262;
          }
          paramString.put(str);
          break label262;
        }
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("gameId", this.jdField_d_of_type_Int);
        ((JSONObject)localObject3).put("selfUid", ((CmGameInitParams)localObject2).openId);
        ((JSONObject)localObject3).put("selfKey", this.jdField_a_of_type_JavaLangString);
        ((JSONObject)localObject3).put("uidList", paramString);
        ((CmGameSSoHandler)localObject1).a("ltgame_native_api.batch_get_user_info", ((JSONObject)localObject3).toString(), paramLong, c, false, null);
        return;
      }
      catch (Exception paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("GET_OPENID_INFO send e=");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.e("cmgame_process.CmGameSubProcessHandler", 2, ((StringBuilder)localObject1).toString());
      }
      return;
      label262:
      i += 1;
    }
  }
  
  public void a(CmGameUserInfo paramCmGameUserInfo)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.put(paramCmGameUserInfo.c, paramCmGameUserInfo);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("taskId");
      paramString = CmGameUtil.a(this.jdField_d_of_type_Int);
      if (paramString != null)
      {
        paramString.a(i);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = CmGameUtil.a(this.jdField_d_of_type_Int);
    if (localObject == null) {
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    int j = 0;
    int i;
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.optInt("now");
      try
      {
        int k = paramString.optInt("delta");
        j = k;
      }
      catch (Throwable paramString) {}
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "get cloud errInfo->", paramString);
    }
    catch (Throwable paramString)
    {
      i = 0;
    }
    paramString = ApolloGameInterfaceProxy.a(i, j, (CmGameInitParams)localObject);
    ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 0, "cs.fetch_cloud_signature.local", paramString);
  }
  
  public void b(long paramLong, String paramString)
  {
    Object localObject2 = CmGameUtil.b(paramLong);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = CmGameUtil.a((int)paramLong);
    }
    if (localObject1 == null) {
      return;
    }
    localObject2 = ((CmGameLauncher)localObject1).a();
    if (localObject2 == null) {
      return;
    }
    try
    {
      CmGameInitParams localCmGameInitParams = ((CmGameLauncher)localObject1).a();
      if (localCmGameInitParams != null)
      {
        if (!localCmGameInitParams.isWhiteUsr) {
          return;
        }
        paramString = new JSONObject(paramString);
        paramString.put("action", "show");
        paramString.put("title", "JS Error");
        int i = ((CmGameLauncher)localObject1).a();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[game:");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("]");
        ((StringBuilder)localObject1).append(paramString.optString("data"));
        paramString.put("content", ((StringBuilder)localObject1).toString());
        ((NativeUIManager)localObject2).a("Dialog", "alert", "", paramString.toString());
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("taskId");
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_d_of_type_Int);
      if (localCmGameLauncher != null)
      {
        localCmGameLauncher.a(i, paramString);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void c(String paramString)
  {
    Object localObject = a();
    if (!TextUtils.isEmpty(paramString))
    {
      if (localObject == null) {
        return;
      }
      try
      {
        paramString = new JSONObject(paramString).getString("puin");
        localObject = new ActivityURIRequest((Context)localObject, "/pubaccount/detail");
        ((ActivityURIRequest)localObject).extra().putString("uin", paramString);
        ((ActivityURIRequest)localObject).extra().putString("report_src_param_type", "");
        ((ActivityURIRequest)localObject).extra().putString("report_src_param_name", "");
        ((ActivityURIRequest)localObject).setFlags(67108864);
        ((ActivityURIRequest)localObject).setRequestCode(9999);
        QRoute.startUri((URIRequest)localObject, null);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "ENTER_PUBACCOUNT_CARD error:", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameSubProcessHandler
 * JD-Core Version:    0.7.0.1
 */