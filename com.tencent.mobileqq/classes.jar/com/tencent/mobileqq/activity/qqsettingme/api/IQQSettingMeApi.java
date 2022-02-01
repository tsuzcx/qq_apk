package com.tencent.mobileqq.activity.qqsettingme.api;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView.BufferType;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean.Title;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@QAPI(process={""})
public abstract interface IQQSettingMeApi
  extends QRouteApi
{
  public abstract void checkAndGetSelfNickName(AppRuntime paramAppRuntime);
  
  public abstract boolean checkUsePersonalCard(AppRuntime paramAppRuntime, Card paramCard);
  
  public abstract Bitmap getBitmapFromCache(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean);
  
  public abstract QQSettingMeBizBean.Title getBusinessEntryText(JSONObject paramJSONObject, String paramString);
  
  public abstract URLDrawable getGameCardIcon(View paramView, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract Integer getPlateColor(String paramString);
  
  public abstract long getQQBigMemberId();
  
  public abstract int getStrokeVisible(String paramString, AppRuntime paramAppRuntime);
  
  public abstract View.OnTouchListener headVipReport(AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean isBigVipClub(int paramInt);
  
  public abstract boolean isCanOpenHippy(String paramString);
  
  public abstract SpannableString parseQQLevel(Resources paramResources, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void setDrawable(AppRuntime paramAppRuntime, long paramLong, View paramView, String paramString, int paramInt);
  
  public abstract void setImageDrawableForDynamic(View paramView, Drawable paramDrawable);
  
  public abstract void setPlayAnimatinDelay(AppRuntime paramAppRuntime);
  
  public abstract void setTextForAnimation(View paramView, SpannableStringBuilder paramSpannableStringBuilder, TextView.BufferType paramBufferType);
  
  public abstract void setVipCardDrawable(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable);
  
  public abstract void setVipExtIcon(Context paramContext, ImageView paramImageView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
 * JD-Core Version:    0.7.0.1
 */