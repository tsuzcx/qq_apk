package com.tencent.av.utils.api;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=true)
public abstract interface IUIToolsApi
  extends QRouteApi
{
  public abstract void avLog(String paramString1, String paramString2);
  
  public abstract int avRalationType2DAVRelationType(int paramInt);
  
  public abstract int avRelationType2UinType(int paramInt);
  
  public abstract void cancelSetPermission(Activity paramActivity, AppInterface paramAppInterface);
  
  public abstract Bitmap captureFrameBySelf(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void clearPressSpeakerGuiderFlag(boolean paramBoolean);
  
  public abstract void clearSpeakerStatus(Context paramContext);
  
  public abstract void disableShowTips(int paramInt);
  
  public abstract Bitmap doBlur(Bitmap paramBitmap, Context paramContext, int paramInt, boolean paramBoolean);
  
  public abstract void doScreenShareReport(String paramString);
  
  public abstract void doScreenShareReport(String paramString, int paramInt);
  
  public abstract float dp2px(Context paramContext, float paramFloat);
  
  public abstract Bitmap drawBitmapCoverLayer(Bitmap paramBitmap, String paramString, boolean paramBoolean);
  
  public abstract boolean equals(String paramString1, String paramString2);
  
  public abstract String formatTime(long paramLong);
  
  public abstract Bitmap getBitmapFromResourceId(Context paramContext, int paramInt);
  
  public abstract float getMeasureTextWidth(TextView paramTextView);
  
  public abstract int getMobileQQLastSyncVersion();
  
  public abstract String getNameMaxMaseaured(Context paramContext, String paramString, TextView paramTextView, float paramFloat);
  
  public abstract Drawable getOvalDrawable(float paramFloat, Context paramContext);
  
  public abstract String getPhoneNumberByUinInMainThread(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract boolean getPressSpeakerGuiderFlag(boolean paramBoolean);
  
  public abstract SharedPreferences getQavSP(AppInterface paramAppInterface);
  
  public abstract float getScreenBrightness();
  
  public abstract float getScreenDensity(Context paramContext);
  
  public abstract int getScreenHeight(Context paramContext);
  
  public abstract int getScreenWidth(Context paramContext);
  
  public abstract String getTimeDesc(String paramString);
  
  public abstract boolean gotoSetting(Activity paramActivity);
  
  public abstract boolean hasSmartBar();
  
  public abstract boolean isEnableShowTips(int paramInt);
  
  public abstract boolean isFeatureSupportRounedScreen(Activity paramActivity);
  
  public abstract boolean isFirstTimeShowUserGuideForFace(AppInterface paramAppInterface);
  
  public abstract boolean isNeedShowSVIPDialog();
  
  public abstract boolean isVIPPayProcessExist(Context paramContext);
  
  public abstract void openPermissionActivity(Activity paramActivity);
  
  public abstract void printStacktrace(String paramString);
  
  public abstract float px2dp(Context paramContext, float paramFloat);
  
  public abstract void recordHasShowSVIPDialog();
  
  public abstract void setAccText(View paramView, String paramString);
  
  public abstract void setAccText(View paramView, String paramString, int paramInt);
  
  public abstract void setFirstTimeShowUserGuideForFace(AppInterface paramAppInterface);
  
  public abstract void setScreenBrightness(Activity paramActivity, float paramFloat);
  
  @TargetApi(11)
  public abstract void setViewAlpha(View paramView, float paramFloat);
  
  public abstract boolean startRing(AppInterface paramAppInterface, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener);
  
  public abstract Bitmap takeScreenShot(Activity paramActivity);
  
  public abstract int uinType2AVRelationType(int paramInt);
  
  public abstract int uinType2MultiAVType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.api.IUIToolsApi
 * JD-Core Version:    0.7.0.1
 */