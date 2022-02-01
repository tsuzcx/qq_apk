package com.tencent.mobileqq.apollo.sdk;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.aioChannel.ChannelConst;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl.HardwareInfo;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.statistics.trace.TraceMappingIml;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class CmShowSpriteActionScript
  extends CmShowSpriteAioScript
{
  public CmShowSpriteActionScript(int paramInt, CmShowSpriteContext paramCmShowSpriteContext, CmShowScriptManager paramCmShowScriptManager)
  {
    super(paramInt, paramCmShowSpriteContext, paramCmShowScriptManager);
  }
  
  public CmShowSpriteActionScript(int paramInt, String paramString, CmShowSpriteContext paramCmShowSpriteContext, CmShowScriptManager paramCmShowScriptManager)
  {
    super(paramInt, paramString, paramCmShowSpriteContext, paramCmShowScriptManager);
  }
  
  private HandleResult a(String paramString, ApolloRender paramApolloRender)
  {
    try
    {
      paramString = new JSONObject(paramString);
      float f1 = (float)paramString.optDouble("x");
      float f2 = (float)paramString.optDouble("y");
      float f3 = (float)paramString.optDouble("w");
      float f4 = (float)paramString.optDouble("h");
      float f5 = (float)paramString.optDouble("bX");
      float f6 = (float)paramString.optDouble("bY");
      float f7 = (float)paramString.optDouble("bW");
      float f8 = (float)paramString.optDouble("bH");
      float f9 = (float)paramString.optDouble("gX");
      float f10 = (float)paramString.optDouble("gY");
      float f11 = (float)paramString.optDouble("gW");
      float f12 = (float)paramString.optDouble("gH");
      ApolloRender.AABBCallback(f1, f2, f3, f4, paramString.optString("name"), paramString.optString("extendString"), f5, f6, f7, f8, f9, f10, f11, f12, paramString.optInt("dispose"));
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleBoundingListUpdate exception = " + paramString.toString());
      }
    }
  }
  
  private HandleResult b()
  {
    HandleResult localHandleResult = new HandleResult();
    localHandleResult.jdField_b_of_type_Boolean = true;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      QQAppInterface localQQAppInterface = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
      if (localQQAppInterface != null)
      {
        localJSONObject.put("is3DBetaTester", SpriteUtil.a(localQQAppInterface));
        localHandleResult.jdField_a_of_type_JavaLangString = localJSONObject.toString();
      }
      return localHandleResult;
    }
    catch (Exception localException)
    {
      QLog.e("CmShow_SpriteActionScript", 1, localException, new Object[0]);
    }
    return localHandleResult;
  }
  
  private HandleResult d(String paramString)
  {
    try
    {
      QLog.d("CmShow_SpriteActionScript", 1, new Object[] { "handleJsError mSpriteFrom:", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.e) });
      paramString = new JSONObject(paramString).optString("data");
      TraceReportUtil.a(SpriteUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.e), 1000, 50, new Object[] { paramString });
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleJsError:", paramString);
      }
    }
  }
  
  private HandleResult e(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      TraceReportUtil.a(paramString.optInt("featureId"), paramString.optString("receiveUin"));
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceBegin:", paramString);
    }
    return null;
  }
  
  private HandleResult f(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) {
        return null;
      }
      int i = new JSONObject(paramString).optInt("featureId");
      if ((i == SpriteUtil.b(1)) || (i == SpriteUtil.b(2))) {
        TraceReportUtil.a(i, null, new int[] { TraceMappingIml.a(i, false, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_b_of_type_Int, -1, true) });
      }
      TraceReportUtil.b(i);
      if ((i == SpriteUtil.b(1)) || (i == SpriteUtil.b(2)))
      {
        TraceReportUtil.a(SpriteUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.e), false);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceEnd:", paramString);
    }
    return null;
  }
  
  private HandleResult g(String paramString)
  {
    long l2 = 0L;
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) {
        return null;
      }
      Object localObject = new JSONObject(paramString);
      int k = ((JSONObject)localObject).optInt("featureId");
      int m = ((JSONObject)localObject).optInt("spanId");
      paramString = ((JSONObject)localObject).optString("msg");
      long l3 = ((JSONObject)localObject).optLong("timestamp");
      localObject = ((JSONObject)localObject).optString("spanDesc");
      long l1 = l2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int j = ApolloUtilImpl.getSpriteSpanExtKey(m);
        i = j;
        l1 = l2;
        if (j > 0)
        {
          l1 = ApolloUtilImpl.getFirstIntegerFromStr((String)localObject);
          i = j;
        }
      }
      TraceReportUtil.a(k, null, m, -100, l3, i, l1, new Object[] { paramString });
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceSpanBegin:", paramString);
    }
    return null;
  }
  
  private HandleResult h(String paramString)
  {
    long l2 = 0L;
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) {
        return null;
      }
      Object localObject = new JSONObject(paramString);
      int k = ((JSONObject)localObject).optInt("featureId");
      int m = ((JSONObject)localObject).optInt("spanId");
      int n = ((JSONObject)localObject).optInt("errCode");
      paramString = ((JSONObject)localObject).optString("msg");
      long l3 = ((JSONObject)localObject).optLong("timestamp");
      localObject = ((JSONObject)localObject).optString("spanDesc");
      long l1 = l2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int j = ApolloUtilImpl.getSpriteSpanExtKey(m);
        i = j;
        l1 = l2;
        if (j > 0)
        {
          l1 = ApolloUtilImpl.getFirstIntegerFromStr((String)localObject);
          i = j;
        }
      }
      TraceReportUtil.a(k, null, m, n, l3, i, l1, new Object[] { paramString });
      if ((n == 57) && (!c()))
      {
        f();
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceSpanEnd:", paramString);
    }
    return null;
  }
  
  private HandleResult i(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("featureId");
      int j = paramString.optInt("spanId");
      String str = paramString.optString("msg");
      TraceReportUtil.a(i, j, -100, paramString.optLong("timestamp"), new Object[] { str });
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceLog:", paramString);
    }
    return null;
  }
  
  private HandleResult j(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.e != 0) {
        return null;
      }
      ApolloUtilImpl.showTipsToast(new JSONObject(paramString).optString("text"));
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private HandleResult k(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("uinList");
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        a(paramString.optString(i), true);
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
  }
  
  private HandleResult l(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.e != 0) {
        return null;
      }
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("status");
      int j = paramString.optInt("whiteHeight");
      if (QLog.isColorLevel())
      {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[handleSpriteStatus], status:", Integer.valueOf(i), ",whiteHeight:", Integer.valueOf(j) });
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private HandleResult m(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.e != 0) {
        return null;
      }
      new JSONObject(paramString).optInt("status");
      paramString = this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager;
      if (paramString != null) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private HandleResult n(String paramString)
  {
    int i;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.optInt("taskId");
      j = paramString.optInt("status");
      paramString = paramString.optString("uin");
      if (!QLog.isColorLevel()) {
        break label137;
      }
      QLog.d("CmShow_SpriteActionScript.callback", 2, new Object[] { "taskId:", Integer.valueOf(i), ",status:", Integer.valueOf(j) });
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
      break label164;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback.a(paramString, i);
      break label164;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback.a(paramString, i, j);
        break label164;
        label137:
        switch (j)
        {
        }
      }
    }
    label164:
    return null;
  }
  
  private HandleResult o(String paramString)
  {
    label137:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONObject localJSONObject = new JSONObject();
        if ("pet".equals(paramString.getString("config_name")))
        {
          paramString = new JSONArray();
          Object localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
          if (localObject != null)
          {
            localObject = (ApolloManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
            if (((ApolloManagerServiceImpl)localObject).mPetConfig == null) {
              break label137;
            }
            paramString = new JSONArray(((ApolloManagerServiceImpl)localObject).mPetConfig);
            localJSONObject.put("petConfig", paramString);
            paramString = new HandleResult();
            paramString.jdField_b_of_type_Boolean = true;
            paramString.jdField_a_of_type_JavaLangString = localJSONObject.toString();
            return paramString;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleGetLocalData error:", paramString);
      }
      return null;
    }
  }
  
  private HandleResult p(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      j = paramString.optInt("from");
      if (!QLog.isColorLevel()) {
        break label192;
      }
      QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "handlePlayAction from:", Integer.valueOf(j) });
    }
    catch (JSONException paramString)
    {
      label71:
      Object localObject;
      paramString.printStackTrace();
      return null;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a();
    if (paramString != null)
    {
      paramString.a();
      return null;
      if (j == 0)
      {
        paramString = paramString.optString("uinList");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new JSONArray(paramString);
          paramString = new ArrayList();
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject).length())
      {
        String str = ((JSONArray)localObject).optString(i);
        if (!TextUtils.isEmpty(str)) {
          paramString.add(str);
        }
      }
      else
      {
        if (paramString.size() != 0)
        {
          localObject = SpriteUtil.a(((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp());
          if (localObject != null)
          {
            ((SpriteRscBuilder)localObject).a(paramString);
            return null;
            label192:
            if (j == 1) {
              break;
            }
            if (j != 2) {
              break label71;
            }
            break;
          }
        }
        return null;
      }
      i += 1;
    }
  }
  
  private HandleResult q(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      j = paramString.optInt("from");
      if (j != 0) {
        break label187;
      }
      localObject = paramString.optString("url");
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a() == null))
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleOnApolloClick mSpriteContent is nil");
        return null;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label132;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a().a() == null)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleOnApolloClick activity is nil");
        return null;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "Exception:", paramString);
      return null;
    }
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).openWebViewActivity(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a().a(), (String)localObject);
    return null;
    label132:
    paramString = paramString.optString("gameId");
    if (!TextUtils.isEmpty(paramString)) {
      i = Integer.parseInt(paramString);
    }
    if (i > 0)
    {
      ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a(), i, 333002, "message", 1);
      return null;
    }
    QLog.e("CmShow_SpriteActionScript", 1, "handleOnApolloClick gameStr is nil");
    return null;
    label187:
    i = paramString.optInt("apolloStatus");
    int k = paramString.optInt("clickPart");
    paramString = paramString.optString("apolloId");
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "handleOnApolloClick", ",from:", Integer.valueOf(j), ",apolloStatus:", Integer.valueOf(i), ",clickPart:", Integer.valueOf(k), "apolloId:", paramString });
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a();
    if (localObject != null) {
      ((ISpriteDrawerInfoCallback)localObject).a(i, k, paramString);
    }
    return null;
  }
  
  public HandleResult a()
  {
    for (;;)
    {
      HandleResult localHandleResult;
      int i;
      try
      {
        QQAppInterface localQQAppInterface = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
        if (localQQAppInterface == null) {
          return null;
        }
        localHandleResult = new HandleResult();
        localHandleResult.jdField_b_of_type_Boolean = true;
        localJSONObject = new JSONObject();
        if ((1 != localQQAppInterface.getALLGeneralSettingRing()) || (((!CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_a_of_type_Int, 2)) || (1 != localQQAppInterface.getTroopGeneralSettingRing())) && (((!CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_a_of_type_Int, 1)) && (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_a_of_type_Int != -2)) || (localQQAppInterface.isRingerVibrate()) || (localQQAppInterface.isRingEqualsZero()) || (!localQQAppInterface.isCallIdle()) || (MediaPlayerManager.a(localQQAppInterface).a()) || ((localQQAppInterface.getCheckPttListener() != null) && (localQQAppInterface.getCheckPttListener().i())) || (localQQAppInterface.isVideoChatting())))) {
          break label241;
        }
        if (localQQAppInterface.getCheckPtvListener() == null) {
          break label252;
        }
        if (localQQAppInterface.getCheckPtvListener().j()) {
          break label241;
        }
      }
      catch (Throwable localThrowable)
      {
        JSONObject localJSONObject;
        QLog.e("CmShow_SpriteActionScript", 1, localThrowable, new Object[0]);
        return null;
      }
      localJSONObject.put("isAllowed", i);
      localHandleResult.jdField_a_of_type_JavaLangString = localJSONObject.toString();
      if (QLog.isColorLevel())
      {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "isAllowPlayAudio:", Integer.valueOf(i) });
        return localHandleResult;
        label241:
        SpriteUtil.b(localThrowable);
        i = 0;
      }
      else
      {
        return localHandleResult;
        label252:
        i = 1;
      }
    }
  }
  
  public HandleResult a(long paramLong, String paramString1, String paramString2)
  {
    IApolloRenderView localIApolloRenderView = a();
    if ((localIApolloRenderView == null) || (localIApolloRenderView.getLuaState() != paramLong)) {}
    do
    {
      do
      {
        return null;
        if ((!paramString1.startsWith("apollo_")) || (paramString1.startsWith("cs.")) || (paramString1.endsWith(".local")) || (ChannelConst.a(paramString1))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CmShow_SpriteActionScript", 2, "ssoCmdRule, [aio],cmd:" + paramString1);
      return null;
      if ("cs.script_action_status_notify.local".equals(paramString1)) {
        return n(paramString2);
      }
      if ("cs.script_change_panel_status.local".equals(paramString1)) {
        return m(paramString2);
      }
      if ("cs.script_get_dress_data.local".equals(paramString1)) {
        return k(paramString2);
      }
      if ("cs.script_sprite_status_change.local".equals(paramString1)) {
        return l(paramString2);
      }
      if ("cs.script_get_show_action.local".equals(paramString1)) {
        return a(paramString2);
      }
      if ("cs.script_is_allow_play_audio.local".equals(paramString1)) {
        return a();
      }
      if ("cs.script_show_barrage.local".equals(paramString1)) {
        return b(paramString2);
      }
      if ("cs.script_send_action_msg.local".equals(paramString1)) {
        return c(paramString2);
      }
      if ("cs.script_show_toast.local".equals(paramString1)) {
        return j(paramString2);
      }
      if ("cs.script_get_config.local".equals(paramString1)) {
        return o(paramString2);
      }
      if ("cs.script_play_action.local".equals(paramString1)) {
        return p(paramString2);
      }
      if ("cs.script_action_apollo_click.local".equals(paramString1)) {
        return q(paramString2);
      }
      if ("cs.script_update_boundinglist.local".equals(paramString1)) {
        return a(paramString2, localIApolloRenderView.getRenderImpl().a());
      }
      if ("cs.get_cm3D_state.local".equals(paramString1)) {
        return b();
      }
      if ("cs.trace_begin.local".equals(paramString1)) {
        return e(paramString2);
      }
      if ("cs.trace_end.local".equals(paramString1)) {
        return f(paramString2);
      }
      if ("cs.trace_span_begin.local".equals(paramString1)) {
        return g(paramString2);
      }
      if ("cs.trace_span_end.local".equals(paramString1)) {
        return h(paramString2);
      }
      if ("cs.trace_log.local".equals(paramString1)) {
        return i(paramString2);
      }
    } while (("cs.script_sprite_model_change_notify.local".equals(paramString1)) || (!"cs.xy_error_info.local".equals(paramString1)));
    return d(paramString2);
  }
  
  public HandleResult a(String paramString)
  {
    HandleResult localHandleResult;
    JSONObject localJSONObject1;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.e != 0) {
        return null;
      }
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray1 = new JSONArray(paramString.optString("uinList"));
      JSONArray localJSONArray2 = new JSONArray();
      localHandleResult = new HandleResult();
      localHandleResult.jdField_b_of_type_Boolean = true;
      localJSONObject1 = new JSONObject();
      int j = paramString.optInt("type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[handleGetShowAction] type:", Integer.valueOf(j) });
      }
      CmShowSpriteRscBuilder localCmShowSpriteRscBuilder = this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager.a();
      if (localCmShowSpriteRscBuilder != null)
      {
        int i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject = localJSONArray1.optString(i);
          localJSONObject2.put("uin", localObject);
          if (j == 1) {
            localJSONObject2.put("petPath", localCmShowSpriteRscBuilder.a(new JSONArray(paramString.optString("actionList"))));
          }
          for (;;)
          {
            localJSONArray2.put(localJSONObject2);
            i += 1;
            break;
            localObject = localCmShowSpriteRscBuilder.a((String)localObject);
            localJSONObject2.put("path", ((Pair)localObject).first);
            localJSONObject2.put("actionType", ((Pair)localObject).second);
          }
        }
      }
      localJSONObject1.put("path", localJSONArray2);
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localHandleResult.jdField_a_of_type_JavaLangString = localJSONObject1.toString();
    return localHandleResult;
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[notifyUsrOperation], status:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", paramInt);
      ApolloUtilImpl.getCmdChannel().callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a().getLuaState(), 0, "sc.script_notify_user_operation.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[init], width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2), ",vHeight:", Integer.valueOf(paramInt3), ",aioType:", Integer.valueOf(paramInt4), "friendUin:", paramString, ",spriteFrom:", Integer.valueOf(paramInt5) });
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) {
          return;
        }
        Object localObject = ApolloUtilImpl.getHardwareInfo();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("platform", "android");
        if (!this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_b_of_type_Boolean) {
          break label896;
        }
        localJSONObject.put("panelStatus", i);
        if (localObject != null)
        {
          localJSONObject.put("phoneModel", ApolloUtilImpl.HardwareInfo.jdField_a_of_type_JavaLangString);
          localJSONObject.put("osVersion", ApolloUtilImpl.HardwareInfo.jdField_b_of_type_JavaLangString);
          localJSONObject.put("cpuType", ApolloUtilImpl.HardwareInfo.jdField_c_of_type_JavaLangString);
          localJSONObject.put("cpuNumber", ApolloUtilImpl.HardwareInfo.jdField_a_of_type_Int);
          localJSONObject.put("cpuFrequency", ApolloUtilImpl.HardwareInfo.jdField_a_of_type_Long);
          localJSONObject.put("freeMemory", ((ApolloUtilImpl.HardwareInfo)localObject).d);
          localJSONObject.put("totalMemory", ((ApolloUtilImpl.HardwareInfo)localObject).jdField_c_of_type_Long);
          localJSONObject.put("maxMemory", ((ApolloUtilImpl.HardwareInfo)localObject).jdField_b_of_type_Long);
        }
        localJSONObject.put("aioType", ApolloGameUtil.a(((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp(), paramInt4, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_a_of_type_JavaLangString));
        localJSONObject.put("friendUin", paramString);
        localJSONObject.put("width", paramInt1);
        localJSONObject.put("height", paramInt2);
        localJSONObject.put("vHeight", paramInt3);
        localJSONObject.put("screenW", DeviceInfoUtil.i());
        localJSONObject.put("screenH", DeviceInfoUtil.j());
        localJSONObject.put("qqVer", "8.5.5");
        localJSONObject.put("uin", this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_b_of_type_JavaLangString);
        localJSONObject.put("density", DeviceInfoUtil.a);
        localJSONObject.put("wait", "def/basic/action/1/action/action");
        localJSONObject.put("standup", "def/basic/action/4/action/action");
        localJSONObject.put("think", "def/basic/action/3/action/action");
        localJSONObject.put("sitdown", "def/basic/action/2/action/action");
        localJSONObject.put("isHide", 0);
        a(localJSONObject, paramInt5);
        paramString = new JSONArray();
        localObject = new int[7];
        Object tmp489_487 = localObject;
        tmp489_487[0] = 1;
        Object tmp493_489 = tmp489_487;
        tmp493_489[1] = 2;
        Object tmp497_493 = tmp493_489;
        tmp497_493[2] = 3;
        Object tmp501_497 = tmp497_493;
        tmp501_497[3] = 4;
        Object tmp505_501 = tmp501_497;
        tmp505_501[4] = 5;
        Object tmp509_505 = tmp505_501;
        tmp509_505[5] = 6;
        Object tmp514_509 = tmp509_505;
        tmp514_509[6] = 7;
        tmp514_509;
        paramInt4 = localObject.length;
        paramInt2 = 0;
        if (paramInt2 < paramInt4)
        {
          paramString.put(ApolloActionHelperImpl.getApolloRsc(1, Integer.valueOf(localObject[paramInt2]).intValue()));
          paramInt2 += 1;
          continue;
        }
        localJSONObject.put("defDress", paramString);
        localJSONObject.put("defRole", ApolloActionHelperImpl.getApolloRsc(0, 0));
        localJSONObject.put("from", paramInt5);
        localJSONObject.put("traceFeatureId", this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a());
        paramString = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/shader_code/");
        if (!paramString.isDirectory()) {
          break label871;
        }
        paramString = paramString.listFiles();
        if ((paramString != null) && (paramString.length > 0))
        {
          localObject = new JSONArray();
          paramInt2 = 0;
          if (paramInt2 < paramString.length)
          {
            ((JSONArray)localObject).put(paramString[paramInt2].getName());
            if (!QLog.isColorLevel()) {
              break label902;
            }
            QLog.i("CmShow_SpriteActionScript", 2, "init shaderCode name:" + paramString[paramInt2].getName());
            break label902;
          }
          localJSONObject.put("shaderCodes", localObject);
          if (QLog.isColorLevel()) {
            QLog.i("CmShow_SpriteActionScript", 1, "commonInit shaderCodes jsonArray:" + localObject);
          }
          paramString = new StringBuilder();
          paramString.append("if(commonInit){commonInit('").append(localJSONObject.toString()).append("');}");
          QLog.d("CmShow_SpriteActionScript", 1, "sava TraceReport CmShowStatUtil commitJS:(commonInit)");
          if ((paramInt1 != 0) && (paramInt3 != 0)) {
            break label883;
          }
          a(paramString.toString(), 0, true);
          if (!QLog.isColorLevel()) {
            break label895;
          }
          QLog.d("CmShow_SpriteActionScript", 2, localJSONObject.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "[getCommonInit], errInfo->", paramString);
        return;
      }
      QLog.i("CmShow_SpriteActionScript", 1, "commonInit shaderCodes file no exist");
      continue;
      label871:
      QLog.i("CmShow_SpriteActionScript", 1, "commonInit shaderCodes dir no exist");
      continue;
      label883:
      a(paramString.toString());
      continue;
      label895:
      return;
      label896:
      i = 1;
      continue;
      label902:
      paramInt2 += 1;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[notifySpriteClicked], clickPart:", Integer.valueOf(paramInt), ",url:", paramString1 });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("clickPart", paramInt);
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("url", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("apolloId", paramString2);
      }
      ApolloUtilImpl.getCmdChannel().callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a().getLuaState(), 0, "sc.script_on_sprite_single_clicked.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "[notifySpriteClicked],", paramString1);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a() == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a()) || (!this.jdField_a_of_type_Boolean))
    {
      QLog.w("CmShow_SpriteActionScript", 1, "[notifyDressReady], surfaceView is destroyed. return");
      return;
    }
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      int j = paramArrayOfInt.length;
      paramInt2 = 0;
      while (paramInt2 < j)
      {
        ((StringBuilder)localObject).append(Integer.valueOf(paramArrayOfInt[paramInt2])).append(",");
        paramInt2 += 1;
      }
      ((StringBuilder)localObject).append("]");
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[notifyDressReady], uin:", paramString, "dress:", localObject });
      }
      localObject = new JSONObject();
      JSONArray localJSONArray1 = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramString);
      JSONArray localJSONArray2 = new JSONArray();
      j = paramArrayOfInt.length;
      paramInt2 = i;
      while (paramInt2 < j)
      {
        localJSONArray2.put(ApolloActionHelperImpl.getApolloRsc(1, Integer.valueOf(paramArrayOfInt[paramInt2]).intValue()));
        paramInt2 += 1;
      }
      ApolloActionHelperImpl.attach3DInfoToJson(paramString, paramQQAppInterface, localJSONObject, null);
      localJSONObject.put("dress", localJSONArray2);
      localJSONObject.put("role", ApolloActionHelperImpl.getApolloRsc(0, paramInt1));
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a() != null) {}
      localJSONArray1.put(localJSONObject);
      ((JSONObject)localObject).put("dressInfo", localJSONArray1);
      ApolloUtilImpl.getCmdChannel().callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a().getLuaState(), 0, "sc.script_notify_dress_ready.local", ((JSONObject)localObject).toString());
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "[notifySpriteVisibility],", paramQQAppInterface);
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2;
    try
    {
      localObject2 = new File(ApolloConstant.jdField_a_of_type_JavaLangString + "/def/role/0/3D");
      localObject1 = new File(ApolloConstant.jdField_a_of_type_JavaLangString + "/def/role/0/3D/3DConfig.json");
      if (!((File)localObject2).exists())
      {
        QLog.w("CmShow_SpriteActionScript", 1, "3D dir NOT exist.");
        return;
      }
      if (!((File)localObject1).exists())
      {
        QLog.w("CmShow_SpriteActionScript", 1, "3DConfig NOT exist.");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramJSONObject, new Object[0]);
      return;
    }
    Object localObject1 = new JSONObject();
    if (new File((File)localObject2, "1/action.bin").exists()) {
      ((JSONObject)localObject1).put("wait", "def/role/0/3D/" + "1");
    }
    if (new File((File)localObject2, "4/action.bin").exists()) {
      ((JSONObject)localObject1).put("standup", "def/role/0/3D/" + "4");
    }
    if (new File((File)localObject2, "3/action.bin").exists()) {
      ((JSONObject)localObject1).put("think", "def/role/0/3D/" + "3");
    }
    if (new File((File)localObject2, "2/action.bin").exists()) {
      ((JSONObject)localObject1).put("sitdown", "def/role/0/3D/" + "2");
    }
    if (new File((File)localObject2, "android/skeleton/skeleton.bin").exists()) {
      ((JSONObject)localObject1).put("defRole", "def/role/0/3D/" + "android/skeleton");
    }
    if (new File((File)localObject2, "transformAction/3to2/action.bin").exists()) {
      ((JSONObject)localObject1).put("3to2DAction", "def/role/0/3D/" + "transformAction/3to2");
    }
    if ((new File((File)localObject2, "transformAction/2to3/action.atlas").exists()) && (new File((File)localObject2, "transformAction/2to3/action.png").exists()) && (new File((File)localObject2, "transformAction/2to3/action.json").exists())) {
      ((JSONObject)localObject1).put("2to3DAction", "def/role/0/3D/" + "transformAction/2to3");
    }
    if ((paramInt == 2) && (new File((File)localObject2, "friendcard/1/action.bin").exists()))
    {
      ((JSONObject)localObject1).put("friendcard_up", "def/role/0/3D/" + "friendcard/1");
      ((JSONObject)localObject1).put("friendcard_down", "def/role/0/3D/" + "friendcard/2");
    }
    if (new File((File)localObject2, "sayhi/1/action.bin").exists()) {
      ((JSONObject)localObject1).put("sayhi", "def/role/0/3D/" + "sayhi/1");
    }
    if (new File((File)localObject2, "bubble").exists()) {
      ((JSONObject)localObject1).put("bubble", "def/role/0/3D/" + "bubble");
    }
    Object localObject3 = new File((File)localObject2, "android/dress");
    int i;
    if (((File)localObject3).exists())
    {
      localObject2 = new JSONArray();
      localObject3 = ((File)localObject3).listFiles();
      i = localObject3.length;
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < i)
      {
        Object localObject4 = localObject3[paramInt];
        if ((localObject4 != null) && (localObject4.exists()) && (localObject4.isDirectory())) {
          ((JSONArray)localObject2).put("def/role/0/3D/" + "android/dress/" + localObject4.getName());
        }
      }
      else
      {
        ((JSONObject)localObject1).put("defDress", localObject2);
        paramJSONObject.put("3DObject", localObject1);
        return;
      }
      paramInt += 1;
    }
  }
  
  public HandleResult b(String paramString)
  {
    IApolloRenderView localIApolloRenderView;
    try
    {
      localIApolloRenderView = a();
      if (localIApolloRenderView == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      if (1 == paramString.optInt("isShow"))
      {
        localIApolloRenderView.bulkApolloBarrages("", new String(Base64Util.decode(paramString.optString("text").getBytes("utf-8"), 0)), true);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localIApolloRenderView.removeAllApolloBarrages(true);
    return null;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a() != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a().getRenderWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a().getInitHeight(), this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a().getRenderHeight(), this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.e);
    }
  }
  
  public HandleResult c(String paramString)
  {
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.e;
      if (i != 0) {}
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteActionScript
 * JD-Core Version:    0.7.0.1
 */