package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;

public class UITools
  extends AVCoreUtil
{
  public static final UITools.MyViewAlphaOnTouchListener a = new UITools.MyViewAlphaOnTouchListener();
  public static boolean b = true;
  public static int c = -1;
  public static int d = -1;
  
  public static float a(Context paramContext, float paramFloat)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(paramContext, paramFloat);
  }
  
  public static float a(TextView paramTextView)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getMeasureTextWidth(paramTextView);
  }
  
  public static int a(int paramInt)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).uinType2MultiAVType(paramInt);
  }
  
  public static int a(Context paramContext)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getScreenWidth(paramContext);
  }
  
  public static SharedPreferences a(AppInterface paramAppInterface)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getQavSP(paramAppInterface);
  }
  
  public static Bitmap a(Context paramContext, int paramInt)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getBitmapFromResourceId(paramContext, paramInt);
  }
  
  public static Bitmap a(Bitmap paramBitmap, String paramString, boolean paramBoolean)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).drawBitmapCoverLayer(paramBitmap, paramString, paramBoolean);
  }
  
  public static Drawable a(float paramFloat, Context paramContext)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getOvalDrawable(paramFloat, paramContext);
  }
  
  public static String a(long paramLong)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).formatTime(paramLong);
  }
  
  public static String a(Context paramContext, String paramString, TextView paramTextView, float paramFloat)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getNameMaxMaseaured(paramContext, paramString, paramTextView, paramFloat);
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getPhoneNumberByUinInMainThread(paramBaseQQAppInterface, paramString);
  }
  
  public static String a(String paramString)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getTimeDesc(paramString);
  }
  
  public static void a(Activity paramActivity)
  {
    ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).openPermissionActivity(paramActivity);
  }
  
  @TargetApi(11)
  public static void a(View paramView, float paramFloat)
  {
    ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).setViewAlpha(paramView, paramFloat);
  }
  
  public static void a(View paramView, String paramString)
  {
    ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).setAccText(paramView, paramString);
  }
  
  public static void a(View paramView, String paramString, int paramInt)
  {
    ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).setAccText(paramView, paramString, paramInt);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).avLog(paramString1, paramString2);
  }
  
  public static boolean a()
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).hasSmartBar();
  }
  
  public static boolean a(boolean paramBoolean)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getPressSpeakerGuiderFlag(paramBoolean);
  }
  
  public static float b(Context paramContext, float paramFloat)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).px2dp(paramContext, paramFloat);
  }
  
  public static int b(int paramInt)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).uinType2AVRelationType(paramInt);
  }
  
  public static int b(Context paramContext)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getScreenHeight(paramContext);
  }
  
  public static void b(AppInterface paramAppInterface)
  {
    ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).setFirstTimeShowUserGuideForFace(paramAppInterface);
  }
  
  public static void b(boolean paramBoolean)
  {
    ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).clearPressSpeakerGuiderFlag(paramBoolean);
  }
  
  public static boolean b()
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).isNeedShowSVIPDialog();
  }
  
  public static boolean b(Activity paramActivity)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).gotoSetting(paramActivity);
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).equals(paramString1, paramString2);
  }
  
  public static String[] b(String paramString)
  {
    int i = paramString.indexOf(':');
    int j = paramString.lastIndexOf(':');
    if ((i >= 0) && (j >= 0)) {
      return paramString.substring(i - 2, j + 3).split(":");
    }
    return null;
  }
  
  public static float c(Context paramContext)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getScreenDensity(paramContext);
  }
  
  public static int c(int paramInt)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).avRelationType2UinType(paramInt);
  }
  
  public static void c()
  {
    ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).recordHasShowSVIPDialog();
  }
  
  public static boolean c(AppInterface paramAppInterface)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).isFirstTimeShowUserGuideForFace(paramAppInterface);
  }
  
  public static int d(int paramInt)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).avRalationType2DAVRelationType(paramInt);
  }
  
  public static void d(Context paramContext)
  {
    ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).clearSpeakerStatus(paramContext);
  }
  
  public static boolean e(int paramInt)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).isEnableShowTips(paramInt);
  }
  
  public static boolean e(Context paramContext)
  {
    return ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).isVIPPayProcessExist(paramContext);
  }
  
  public static void f(int paramInt)
  {
    ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).disableShowTips(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.UITools
 * JD-Core Version:    0.7.0.1
 */