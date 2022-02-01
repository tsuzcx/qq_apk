package com.tencent.mobileqq.apollo.view.hippy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@HippyNativeModule(name="CmBattleGameNativeModule")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/view/hippy/CmBattleGameNativeModule;", "Lcom/tencent/hippy/qq/module/QQBaseModule;", "hippyEngineContext", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "getCMBattleGameData", "", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "getChatPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "openMiniApp", "requestGameData", "appInterface", "Lcom/tencent/common/app/AppInterface;", "sceneId", "", "gameStyle", "dataListener", "Lcom/tencent/mobileqq/apollo/view/hippy/ICmBattleGameDataListener;", "requestGameDataInThread", "sendArkMsg", "sendNormalArkMsg", "chatPie", "sendUpdatableMsg", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmBattleGameNativeModule
  extends QQBaseModule
{
  public static final CmBattleGameNativeModule.Companion Companion = new CmBattleGameNativeModule.Companion(null);
  private static final String TAG = "CmBattleGameNativeModule";
  
  public CmBattleGameNativeModule(@NotNull HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private final BaseChatPie getChatPie()
  {
    Object localObject = QBaseActivity.sTopActivity;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "baseAct");
    localObject = ((QBaseActivity)localObject).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if ((localObject instanceof ChatFragment)) {
      return ((ChatFragment)localObject).k();
    }
    return null;
  }
  
  private final void requestGameData(AppInterface paramAppInterface, int paramInt1, int paramInt2, ICmBattleGameDataListener paramICmBattleGameDataListener)
  {
    ThreadManager.excute((Runnable)new CmBattleGameNativeModule.requestGameData.1(this, paramAppInterface, paramInt1, paramInt2, paramICmBattleGameDataListener), 128, null, false);
  }
  
  private final void requestGameDataInThread(AppInterface paramAppInterface, int paramInt1, int paramInt2, ICmBattleGameDataListener paramICmBattleGameDataListener)
  {
    List localList = CmBattleGameDataRequest.a.a(paramAppInterface);
    localList = CmBattleGameDataRequest.a.a(paramInt1, paramInt2, localList);
    if ((localList != null) && ((((Collection)localList).isEmpty() ^ true)) && (CmBattleGameDataRequest.a.a(paramAppInterface, paramInt1, paramInt2)))
    {
      paramICmBattleGameDataListener.a(localList);
      return;
    }
    CmBattleGameDataRequest.a.a(paramAppInterface, paramInt1, paramInt2, (ICmBattleGameDataListener)new CmBattleGameNativeModule.requestGameDataInThread.1(paramICmBattleGameDataListener, paramInt1, paramInt2, paramAppInterface));
  }
  
  private final void sendNormalArkMsg(HippyMap paramHippyMap, Promise paramPromise, BaseChatPie paramBaseChatPie)
  {
    Object localObject1 = paramHippyMap.getMap("arkMessage");
    if ((localObject1 != null) && (((HippyMap)localObject1).size() != 0))
    {
      String str1 = ((HippyMap)localObject1).getString("app");
      String str2 = ((HippyMap)localObject1).getString("view");
      String str3 = ((HippyMap)localObject1).getString("ver");
      String str4 = ((HippyMap)localObject1).getString("prompt");
      paramHippyMap = ((HippyMap)localObject1).get("meta");
      if ((paramHippyMap instanceof HippyMap)) {
        paramHippyMap = ((HippyMap)paramHippyMap).toJSONObject().toString();
      } else {
        paramHippyMap = ((HippyMap)localObject1).getString("meta");
      }
      Object localObject2 = ((HippyMap)localObject1).get("config");
      if ((localObject2 instanceof HippyMap)) {
        localObject1 = ((HippyMap)localObject2).toJSONObject().toString();
      } else {
        localObject1 = ((HippyMap)localObject1).getString("config");
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("forward_type", 27);
      ((Intent)localObject2).putExtra("is_ark_display_share", true);
      ((Intent)localObject2).putExtra("forward_ark_app_name", str1);
      ((Intent)localObject2).putExtra("forward_ark_app_view", str2);
      ((Intent)localObject2).putExtra("forward_ark_app_ver", str3);
      ((Intent)localObject2).putExtra("forward_ark_app_prompt", str4);
      ((Intent)localObject2).putExtra("forward_ark_app_meta", paramHippyMap);
      ((Intent)localObject2).putExtra("forward_ark_app_config", (String)localObject1);
      ((Intent)localObject2).putExtra("uintype", paramBaseChatPie.F());
      ((Intent)localObject2).putExtra("uin", paramBaseChatPie.ah.b);
      ((Intent)localObject2).putExtra("troop_uin", paramBaseChatPie.ah.c);
      localObject1 = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
      localObject1 = ((Activity)localObject1).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.resources");
      paramHippyMap = QQCustomArkDialog.AppInfo.a(str1, str2, str3, paramHippyMap, ((Resources)localObject1).getDisplayMetrics().scaledDensity, paramBaseChatPie.ah.c, null);
      paramHippyMap.putInt("key_req", 3);
      paramHippyMap.putInt("key_direct_show_uin_type", paramBaseChatPie.F());
      paramHippyMap.putString("key_direct_show_uin", paramBaseChatPie.ah.b);
      ((Intent)localObject2).putExtras(paramHippyMap);
      ForwardBaseOption.a(getActivity(), (Intent)localObject2, ForwardRecentTranslucentActivity.class, -1);
      paramPromise.resolve("send ark msg success!");
      return;
    }
    QLog.e("CmBattleGameNativeModule", 1, "arkMessage is null");
    paramPromise.reject("arkMessage is null");
  }
  
  private final void sendUpdatableMsg(HippyMap paramHippyMap, Promise paramPromise, BaseChatPie paramBaseChatPie)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @HippyMethod(name="getCMBattleGameData")
  public final void getCMBattleGameData(@Nullable HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    paramHippyMap = getChatPie();
    if (paramHippyMap == null)
    {
      paramPromise.reject("chatPie is null");
      return;
    }
    int i = ApolloPanelUtil.a(paramHippyMap.F());
    if (i == -1)
    {
      paramPromise.reject("sceneId is -1");
      return;
    }
    int j = ApolloPanelUtil.b(paramHippyMap.F());
    if (QLog.isColorLevel())
    {
      paramHippyMap = new StringBuilder();
      paramHippyMap.append("getCMBattleGameData sceneId=");
      paramHippyMap.append(i);
      paramHippyMap.append(", gameStyle=");
      paramHippyMap.append(j);
      QLog.d("CmBattleGameNativeModule", 2, paramHippyMap.toString());
    }
    paramHippyMap = getAppInterface();
    Intrinsics.checkExpressionValueIsNotNull(paramHippyMap, "appInterface");
    requestGameData(paramHippyMap, i, j, (ICmBattleGameDataListener)new CmBattleGameNativeModule.getCMBattleGameData.1(paramPromise));
  }
  
  @HippyMethod(name="openMiniApp")
  public final void openMiniApp(@NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    Object localObject = paramHippyMap.getString("url");
    int i = paramHippyMap.getInt("scene");
    if (QLog.isColorLevel())
    {
      paramHippyMap = new StringBuilder();
      paramHippyMap.append("openMiniApp:");
      paramHippyMap.append((String)localObject);
      paramHippyMap.append(", scene:");
      paramHippyMap.append(i);
      QLog.i("CmBattleGameNativeModule", 2, paramHippyMap.toString());
    }
    paramHippyMap = getActivity();
    if (paramHippyMap == null)
    {
      QLog.e("CmBattleGameNativeModule", 1, "openMiniApp activity is null");
      return;
    }
    try
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp((Context)paramHippyMap, (String)localObject, i, null);
      return;
    }
    catch (Exception paramHippyMap)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openMiniApp error: ");
      ((StringBuilder)localObject).append(paramHippyMap.getMessage());
      QLog.e("CmBattleGameNativeModule", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  @HippyMethod(name="sendArkMsg")
  public final void sendArkMsg(@Nullable HippyMap paramHippyMap, @NotNull Promise paramPromise)
  {
    Intrinsics.checkParameterIsNotNull(paramPromise, "promise");
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendArkMsg params=");
      ((StringBuilder)localObject1).append(paramHippyMap);
      QLog.d("CmBattleGameNativeModule", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramHippyMap != null) && (paramHippyMap.size() != 0))
    {
      localObject1 = getChatPie();
      if (localObject1 == null)
      {
        paramPromise.reject("chatPie is null");
        return;
      }
      CharSequence localCharSequence = (CharSequence)((BaseChatPie)localObject1).ah.b;
      Object localObject2 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication()");
      localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication().runtime");
      if (TextUtils.equals(localCharSequence, (CharSequence)((AppRuntime)localObject2).getAccount()))
      {
        QQToast.makeText((Context)getActivity(), (CharSequence)getActivity().getString(2131886678), 0).show();
        paramPromise.reject("cannot send to self");
        return;
      }
      if (paramHippyMap.getInt("cmBattleGameStyle") == 0) {}
      try
      {
        sendUpdatableMsg(paramHippyMap, paramPromise, (BaseChatPie)localObject1);
        return;
      }
      catch (Exception paramHippyMap)
      {
        QLog.e("CmBattleGameNativeModule", 1, "sendArkMsg error.", (Throwable)paramHippyMap);
        paramPromise.reject("send ark msg error!");
        return;
      }
      sendNormalArkMsg(paramHippyMap, paramPromise, (BaseChatPie)localObject1);
      return;
    }
    paramPromise.reject("params is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.hippy.CmBattleGameNativeModule
 * JD-Core Version:    0.7.0.1
 */