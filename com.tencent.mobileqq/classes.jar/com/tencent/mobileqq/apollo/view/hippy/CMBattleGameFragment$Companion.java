package com.tencent.mobileqq.apollo.view.hippy;

import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/view/hippy/CMBattleGameFragment$Companion;", "", "()V", "HIPPY_DOMAIN", "", "KEY_GAME_DATA", "KEY_GAME_STYLE", "KEY_GET_GAME_DATA", "KEY_NIGHT_MODE", "KEY_SCENE_ID", "KEY_THEME_CHANGE", "KEY_UIN", "KEY_USER_NAME", "LOAD_HIPPY_TIME_OUT", "", "LOCAL_BUNDLE", "MSG_TIME_OUT", "", "TAG", "generateOpenHippyInfo", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "appInterface", "Lcom/tencent/mobileqq/app/QQAppInterface;", "sceneId", "cmGameStyle", "preloadHippy", "", "curType", "setInitParams", "jsonParam", "Lorg/json/JSONObject;", "gameStyle", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMBattleGameFragment$Companion
{
  @JvmStatic
  @Nullable
  public final OpenHippyInfo a(@NotNull QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "appInterface");
    OpenHippyInfo localOpenHippyInfo = new OpenHippyInfo();
    localOpenHippyInfo.bundleName = "minigameEntry";
    localOpenHippyInfo.domain = "qzone.qq.com";
    localOpenHippyInfo.isPreload = true;
    localOpenHippyInfo.processName = "main";
    JSONObject localJSONObject = new JSONObject();
    ((Companion)this).a(localJSONObject, paramQQAppInterface, paramInt1, paramInt2);
    localOpenHippyInfo.url = localJSONObject.toString();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("hippy url=");
      paramQQAppInterface.append(localOpenHippyInfo.url);
      QLog.d("CMBattleGameFragment", 2, paramQQAppInterface.toString());
    }
    return localOpenHippyInfo;
  }
  
  @JvmStatic
  public final void a(@NotNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "appInterface");
    int i = ApolloPanelUtil.a(paramInt);
    paramInt = ApolloPanelUtil.b(paramInt);
    paramQQAppInterface = ((Companion)this).a(paramQQAppInterface, i, paramInt);
    boolean bool = ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage(paramQQAppInterface);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("preloadHippy sceneId=");
      paramQQAppInterface.append(i);
      paramQQAppInterface.append(", cmGameStyle=");
      paramQQAppInterface.append(paramInt);
      paramQQAppInterface.append(", isPreload=");
      paramQQAppInterface.append(bool);
      QLog.d("CMBattleGameFragment", 2, paramQQAppInterface.toString());
    }
  }
  
  @JvmStatic
  public final void a(@NotNull JSONObject paramJSONObject, @NotNull QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonParam");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "appInterface");
    try
    {
      paramJSONObject.put("currentUin", paramQQAppInterface.getCurrentUin());
      paramJSONObject.put("userName", paramQQAppInterface.getCurrentNickname());
      paramJSONObject.put("sceneId", paramInt1);
      paramJSONObject.put("cmBattleGameStyle", paramInt2);
      paramJSONObject.put("isNightMode", ThemeUtil.isNowThemeIsNight(null, false, null));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("CMBattleGameFragment", 1, "setInitParams error! ", (Throwable)paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.hippy.CMBattleGameFragment.Companion
 * JD-Core Version:    0.7.0.1
 */