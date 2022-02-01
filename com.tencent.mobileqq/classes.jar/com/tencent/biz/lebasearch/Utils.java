package com.tencent.biz.lebasearch;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qlink.QQProxyForQlink;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.Object;>;
import org.json.JSONObject;

public class Utils
{
  public static final int BUSINESS_ID_TEMP_MSG_BOC = 111;
  public static final int BUSINNESS_ID_ALBUM = 5;
  public static final int BUSINNESS_ID_ANIME = 18;
  public static final int BUSINNESS_ID_CITY_SERVICE = 22;
  public static final int BUSINNESS_ID_CM_SHOW = 11;
  public static final int BUSINNESS_ID_CONFESS = 59;
  public static final int BUSINNESS_ID_EAT_AND_DRINK = 21;
  public static final int BUSINNESS_ID_FACE_TO_FACE_SEND = 30;
  public static final int BUSINNESS_ID_FACE_TO_FACE_WALLET = 33;
  public static final int BUSINNESS_ID_GAMES = 13;
  public static final int BUSINNESS_ID_INTERESTED_TRIBES = 12;
  public static final int BUSINNESS_ID_JINGDONG = 16;
  public static final int BUSINNESS_ID_MUSIC = 19;
  public static final int BUSINNESS_ID_MY_COMPUTER = 28;
  public static final int BUSINNESS_ID_MY_FAVORITES = 4;
  public static final int BUSINNESS_ID_MY_FILE = 6;
  public static final int BUSINNESS_ID_MY_OTHER_ACCOUNT = 40;
  public static final int BUSINNESS_ID_NEARBY = 10;
  public static final int BUSINNESS_ID_NEW_FRIEND = 41;
  public static final int BUSINNESS_ID_NOW_LIVE = 20;
  public static final int BUSINNESS_ID_ONE_GREETING = 44;
  public static final int BUSINNESS_ID_PAY = 32;
  public static final int BUSINNESS_ID_PENGUIN_COUNSELING = 26;
  public static final int BUSINNESS_ID_PERSONALITY_DRESS_UP = 3;
  public static final int BUSINNESS_ID_PHONE_CONTACTS = 8;
  public static final int BUSINNESS_ID_PUBLIC_ACCOUNT = 27;
  public static final int BUSINNESS_ID_QQ_DAREN = 7;
  public static final int BUSINNESS_ID_QQ_KANDIAN = 15;
  public static final int BUSINNESS_ID_QQ_MEMBER = 1;
  public static final int BUSINNESS_ID_QQ_PHONE = 29;
  public static final int BUSINNESS_ID_QQ_RED_ENVELOPES = 39;
  public static final int BUSINNESS_ID_QQ_STORY = 14;
  public static final int BUSINNESS_ID_QQ_WALLET = 2;
  public static final int BUSINNESS_ID_QQ_ZONE = 9;
  public static final int BUSINNESS_ID_READ = 17;
  public static final int BUSINNESS_ID_SAY_HELLO = 42;
  public static final int BUSINNESS_ID_SCAN = 31;
  public static final int BUSINNESS_ID_SERVER_ACCOUNT = 43;
  public static final int BUSINNESS_ID_SHOOT = 34;
  public static final int BUSINNESS_ID_SHOPPING_ACCOUNT = 36;
  public static final int BUSINNESS_ID_SPORTS = 24;
  public static final int BUSINNESS_ID_TENCENT_CLASSROOM = 25;
  public static final int BUSINNESS_ID_TENCENT_NEWS = 23;
  public static final int BUSINNESS_ID_TROOP_ASSITANT = 35;
  public static final int BUSINNESS_ID_TROOP_NOTIFACATION = 37;
  public static final int BUSINNESS_ID_YINGYONGBAO = 38;
  public static final String KEY_BUSINESS_ID = "fid";
  public static final String KEY_BUSINESS_URL = "funurl";
  public static final String KEY_ICON = "icurl";
  public static final String KEY_NEW_TASK = "newtask";
  public static final String TAG = "lebasearch.Utils";
  public static final int TYPE_SET_CLOSE = 2;
  public static final int TYPE_SET_OPEN = 1;
  
  public static QQCustomDialog createPluginSetDialogForMain(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, long paramLong, String paramString1, String paramString2, Handler paramHandler)
  {
    Object localObject = (ILebaHelperService)paramQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
    if (localObject == null) {
      QLog.d("lebasearch.Utils", 1, "createPluginSetDialogForMain lebaHelperService == null");
    }
    localObject = new Utils.3(paramInt, (ILebaHelperService)localObject, paramQQAppInterface, paramLong, paramHandler);
    paramHandler = new Utils.4(paramHandler);
    if (!TextUtils.isEmpty(paramString2)) {
      paramQQAppInterface = paramString2;
    } else if (paramInt == 1) {
      paramQQAppInterface = paramContext.getResources().getString(2131696035, new Object[] { paramString1 });
    } else {
      paramQQAppInterface = paramContext.getString(2131696031, new Object[] { paramString1 });
    }
    int i;
    if (paramInt == 1) {
      i = 2131696027;
    } else {
      i = 2131696029;
    }
    if (paramInt == 1) {
      paramInt = 2131696032;
    } else {
      paramInt = 2131696030;
    }
    return DialogUtil.a((BaseActivity)paramContext, paramQQAppInterface, i, paramInt, (DialogInterface.OnClickListener)localObject, paramHandler);
  }
  
  public static QQCustomDialog createPluginSetDialogForWeb(Context paramContext, TroopMemberApiClient paramTroopMemberApiClient, BusinessObserver paramBusinessObserver, int paramInt, long paramLong, String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramContext, 230);
    paramBusinessObserver = new Utils.1(paramInt, paramBusinessObserver, paramContext, paramTroopMemberApiClient, paramLong);
    paramTroopMemberApiClient = new TextView(paramContext);
    paramTroopMemberApiClient.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramTroopMemberApiClient.setTextSize(14.0F);
    paramTroopMemberApiClient.setTextColor(paramContext.getResources().getColor(2131165473));
    paramTroopMemberApiClient.setGravity(1);
    paramTroopMemberApiClient.setPadding((int)DisplayUtils.a(paramContext, 15.0F), (int)DisplayUtils.a(paramContext, 30.0F), (int)DisplayUtils.a(paramContext, 15.0F), (int)DisplayUtils.a(paramContext, 15.0F));
    if (paramInt == 1)
    {
      localQQCustomDialog.setPositiveButton(2131696027, paramBusinessObserver);
      localQQCustomDialog.setNegativeButton(2131696032, paramBusinessObserver);
      if (paramString2 != null) {
        paramContext = paramString2;
      } else {
        paramContext = paramContext.getResources().getString(2131696035, new Object[] { paramString1 });
      }
    }
    else
    {
      if (paramString2 != null) {
        paramContext = paramString2;
      } else {
        paramContext = paramContext.getString(2131696031, new Object[] { paramString1 });
      }
      localQQCustomDialog.setNegativeButton(2131696030, paramBusinessObserver);
      localQQCustomDialog.setPositiveButton(2131696029, paramBusinessObserver);
    }
    paramTroopMemberApiClient.setText(paramContext);
    localQQCustomDialog.addView(paramTroopMemberApiClient);
    return localQQCustomDialog;
  }
  
  public static boolean gotoF2fRedPacket(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    long l = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
    paramContext = new ActivityURIRequest(paramContext, "/qwallet/redpacket/QrcodeHbGuider");
    paramContext.extra().putLong("vacreport_key_seq", l);
    paramContext.extra().putString("appInfo", "");
    paramContext.setFlags(276824064);
    QRoute.startUri(paramContext, new Utils.5());
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext != null) && ((paramContext instanceof QQAppInterface))) {
      paramContext = (QQAppInterface)paramContext;
    } else {
      paramContext = null;
    }
    ReportController.b(paramContext, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.hongbao.click", 0, 0, "", "", "", "");
    return true;
  }
  
  public static boolean gotoFaceToFaceSend(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    QQProxyForQlink.a(paramContext, 14, null);
    return true;
  }
  
  public static boolean gotoFunctionActivity(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    int i;
    boolean bool;
    if (paramHashMap != null)
    {
      if ((paramHashMap.get("className") instanceof String)) {
        localObject = (String)paramHashMap.get("className");
      }
      if ((paramHashMap.get("fid") instanceof Integer)) {
        i = ((Integer)paramHashMap.get("fid")).intValue();
      } else {
        i = 0;
      }
      if ((paramHashMap.get("newtask") instanceof Boolean)) {
        bool = ((Boolean)paramHashMap.get("newtask")).booleanValue();
      } else {
        bool = true;
      }
    }
    else
    {
      bool = true;
      i = 0;
    }
    Object localObject = new Intent();
    if (i != 2) {
      if (i != 4) {
        if (i != 5) {
          if (i != 6) {
            if (i != 14) {
              if ((i != 15) && (i != 27)) {
                if (i != 28) {
                  paramHashMap = (HashMap<String, Object>)localObject;
                }
              }
            }
          }
        }
      }
    }
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        switch (i)
        {
        default: 
          paramHashMap = (HashMap<String, Object>)localObject;
          break;
        case 38: 
          ((Intent)localObject).setClass(paramContext, QZoneAppListActivity.class);
          paramHashMap = (HashMap<String, Object>)localObject;
          break;
        case 37: 
          paramHashMap = new Intent(paramContext, QPublicFragmentActivity.class);
          paramHashMap.putExtra("public_fragment_class", ((ILaunchTroopSysMsgUIUtilApi)QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).getFragmentNameForLaunch());
          paramHashMap.putExtra("_key_mode", 1);
          paramHashMap.putExtra("key_tab_mode", 2);
          break;
        case 36: 
          ((Intent)localObject).setClass(paramContext, EcshopWebActivity.class);
          ((Intent)localObject).putExtra("from_search", true);
          ((Intent)localObject).setFlags(67108864);
          paramHashMap = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramHashMap != null) && ((paramHashMap instanceof QQAppInterface)))
          {
            paramHashMap = (EcShopAssistantManager)((QQAppInterface)paramHashMap).getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
            if (paramHashMap != null) {
              paramHashMap.a((Intent)localObject, paramContext, -1);
            }
          }
          String str = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappecshopurl", "");
          paramHashMap = (HashMap<String, Object>)localObject;
          if (!TextUtils.isEmpty(str))
          {
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, str, 4003, null);
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("shopping_folder", "click", "search", "", "", "");
            return true;
          }
          break;
        case 35: 
          ((Intent)localObject).setClass(paramContext, TroopAssistantActivity.class);
          paramHashMap = (HashMap<String, Object>)localObject;
        }
        break;
      case 33: 
        gotoF2fRedPacket(paramContext, null);
        return true;
      case 32: 
        gotoPay(paramContext, null);
        return true;
      case 31: 
        gotoScan(paramContext, null);
        return true;
      }
      break;
    case 9: 
      paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
      paramHashMap.putExtra("key_business", 3);
      break;
    case 8: 
      paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
      paramHashMap.putExtra("key_business", 7);
      break;
      if (QFileAssistantUtils.a())
      {
        QFileAssistantUtils.a(paramContext, null);
        paramHashMap = (HashMap<String, Object>)localObject;
      }
      else
      {
        ((Intent)localObject).setClass(paramContext, LiteActivity.class);
        ((Intent)localObject).putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
        RecentUtil.a = true;
        RecentUtil.a((Intent)localObject);
        paramHashMap = (HashMap<String, Object>)localObject;
        break;
        paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
        if (i == 27) {
          paramHashMap.putExtra("tab_tab_index", 0);
        }
        paramHashMap.putExtra("key_business", 6);
        break;
        ((IWSManager)QRoute.api(IWSManager.class)).enterTrendsTabWs(paramContext, "from_search_trends_ws", false, null, null);
        return true;
        ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).openFileAssistant(paramContext, bool);
        paramHashMap = (HashMap<String, Object>)localObject;
        break;
        paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
        paramHashMap.putExtra("key_business", 5);
        break;
        paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
        paramHashMap.putExtra("key_business", 4);
        break;
        paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
        paramHashMap.putExtra("key_business", 2);
      }
      break;
    }
    if (i == 18) {
      paramHashMap = new JSONObject();
    }
    try
    {
      paramHashMap.put("newInstance", true);
    }
    catch (Exception localException)
    {
      label793:
      break label793;
    }
    if (QLog.isColorLevel()) {
      QLog.d("lebasearch.Utils", 2, "BUSINESS_ID_ANIME put newInstance is error");
    }
    paramContext = new ActivityURIRequest(paramContext, "/base/vipcomic");
    paramContext.extra().putString("options", paramHashMap.toString());
    if (bool) {
      paramContext.setFlags(276824064);
    }
    QRoute.startUri(paramContext, null);
    return true;
    if (bool) {
      paramHashMap.setFlags(276824064);
    }
    if (i == 10)
    {
      RouteUtils.a(paramContext, paramHashMap, "/nearby/activity");
      return true;
    }
    paramContext.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean gotoPay(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    long l = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "2", 0, null);
    paramHashMap = new Intent(paramContext, JumpActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=8&entry=2&seq=");
    localStringBuilder.append(l);
    paramHashMap.setData(Uri.parse(localStringBuilder.toString()));
    paramHashMap.setFlags(276824064);
    paramContext.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean gotoScan(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext()))
    {
      QLog.e("lebasearch.Utils", 2, "gotoScan method. QavCameraUsage.checkAVCameraUsed false.");
      return false;
    }
    paramHashMap = new Intent();
    paramHashMap.putExtra("from", "Conversation");
    paramHashMap.putExtra("leftViewText", paramContext.getString(2131690706));
    paramHashMap.putExtra("selfSet_leftViewText", paramContext.getString(2131690706));
    paramHashMap.setFlags(67108864);
    paramHashMap.setFlags(276824064);
    RouteUtils.a(paramContext, paramHashMap, "/qrscan/scanner");
    return true;
  }
  
  public static boolean gotoStoryBigVipPage(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    long l;
    if ((paramHashMap != null) && ((paramHashMap.get("uin") instanceof Long))) {
      try
      {
        l = Long.valueOf(((Long)paramHashMap.get("uin")).longValue()).longValue();
      }
      catch (NumberFormatException paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
    } else {
      l = 0L;
    }
    paramHashMap = QQStoryMemoriesActivity.a(paramContext, 24, l);
    paramHashMap.addFlags(268435456);
    paramContext.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean gotoWebView(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    Object localObject3 = null;
    Object localObject1;
    Object localObject2;
    if (paramHashMap != null)
    {
      if ((paramHashMap.get("url") instanceof String)) {
        localObject1 = (String)paramHashMap.get("url");
      } else {
        localObject1 = null;
      }
      if ((paramHashMap.get("url_model") instanceof String))
      {
        paramHashMap = (String)paramHashMap.get("url_model");
        localObject2 = localObject1;
      }
      else
      {
        paramHashMap = null;
        localObject2 = localObject1;
      }
    }
    else
    {
      paramHashMap = null;
      localObject2 = paramHashMap;
    }
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return false;
    }
    if (TextUtils.isEmpty(paramHashMap))
    {
      localObject1 = new Intent(paramContext, QQBrowserActivity.class);
    }
    else
    {
      localObject1 = localObject3;
      if (paramHashMap.equals("gameCenter"))
      {
        localObject1 = new Intent(paramContext, GameCenterActivity.class);
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_games");
      }
    }
    if (localObject1 == null) {
      return false;
    }
    ((Intent)localObject1).putExtra("url", (String)localObject2);
    ((Intent)localObject1).setFlags(276824064);
    paramContext.startActivity((Intent)localObject1);
    return true;
  }
  
  public static void sendPluginSetMessage(Context paramContext, TroopMemberApiClient paramTroopMemberApiClient, BusinessObserver paramBusinessObserver, long paramLong, boolean paramBoolean)
  {
    paramContext = new Handler(paramContext.getMainLooper());
    Bundle localBundle = new Bundle();
    localBundle.putLong("uiResId", paramLong);
    localBundle.putBoolean("isChecked", paramBoolean);
    paramContext.post(new Utils.2(paramTroopMemberApiClient, localBundle, paramBusinessObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.Utils
 * JD-Core Version:    0.7.0.1
 */