package com.tencent.mobileqq.activity.qqsettingme.api.impl;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean.Title;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils.VipIconTouchListener;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.theme.TintManager;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.util.DrawerCoverUtil;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QQSettingMeApiImpl
  implements IQQSettingMeApi
{
  public SpannableString addNamePlateOfKing(View paramView, Resources paramResources, long paramLong, int paramInt, boolean paramBoolean)
  {
    return QQSettingUtil.a(paramView, paramResources, paramLong, paramInt, paramBoolean);
  }
  
  public void checkAndGetSelfNickName(AppRuntime paramAppRuntime)
  {
    ((QQAppInterface)paramAppRuntime).checkAndGetSelfNickName();
  }
  
  public boolean checkUsePersonalCard(AppRuntime paramAppRuntime, Card paramCard)
  {
    return DrawerCoverUtil.a((QQAppInterface)paramAppRuntime, paramCard);
  }
  
  public Bitmap getBitmapFromCache(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean)
  {
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    return paramAppRuntime.getBitmapFromCache(paramAppRuntime.getFaceBitmapCacheKey(1, paramString, (byte)3, paramInt, 100, paramBoolean));
  }
  
  public QQSettingMeBizBean.Title getBusinessEntryText(JSONObject paramJSONObject, String paramString)
  {
    if ("d_vip_identity".equals(paramString))
    {
      paramString = new QQSettingMeBizBean.Title();
      paramString.a = "开通会员";
      paramString.b = "open vip";
      if (paramJSONObject == null) {
        return paramString;
      }
      JSONObject localJSONObject = paramJSONObject.optJSONObject("title");
      if (localJSONObject == null) {
        return paramString;
      }
      paramJSONObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramJSONObject == null) {
        return paramString;
      }
      int i = VipInfoHandler.a(paramJSONObject, paramJSONObject.getCurrentUin(), false);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              paramJSONObject = "";
            } else {
              paramJSONObject = "vip";
            }
          }
          else {
            paramJSONObject = "svip";
          }
        }
        else {
          paramJSONObject = "expiredvip";
        }
      }
      else {
        paramJSONObject = "generaluser";
      }
      paramJSONObject = localJSONObject.optJSONObject(paramJSONObject);
      if (paramJSONObject == null) {
        return paramString;
      }
      paramString.a = paramJSONObject.optString("zh");
      paramString.b = paramJSONObject.optString("en");
      return paramString;
    }
    return null;
  }
  
  public Integer getPlateColor(String paramString)
  {
    return TintManager.a().a(paramString);
  }
  
  public long getQQBigMemberId()
  {
    return 6L;
  }
  
  public int getStrokeVisible(String paramString, AppRuntime paramAppRuntime)
  {
    return VasFaceManager.a(paramString, (QQAppInterface)paramAppRuntime);
  }
  
  public View.OnTouchListener headVipReport(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = VipUtils.VipIconUtils.VipIconTouchListener.a((QQAppInterface)paramAppRuntime, paramString, "VIA_SETTINGME");
    paramAppRuntime.a();
    return paramAppRuntime;
  }
  
  public boolean isBigVipClub(int paramInt)
  {
    return VipUtils.a(paramInt);
  }
  
  public SpannableString parseQQLevel(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    return QQSettingUtil.a(paramResources, paramInt1, paramInt2, paramInt3);
  }
  
  public void setDrawable(AppRuntime paramAppRuntime, long paramLong, View paramView, String paramString, int paramInt)
  {
    paramAppRuntime = ((AvatarPendantManager)paramAppRuntime.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(paramLong);
    if (AvatarPendantUtil.a(paramLong))
    {
      paramAppRuntime.a(paramView, 2, PendantInfo.h, paramString, paramInt);
      return;
    }
    paramAppRuntime.a(paramView, 1, PendantInfo.h, paramString, paramInt);
  }
  
  public void setImageDrawableForDynamic(View paramView, Drawable paramDrawable)
  {
    ((DynamicAvatarView)paramView).setImageDrawable(paramDrawable);
  }
  
  public void setPlayAnimatinDelay(AppRuntime paramAppRuntime)
  {
    ((AvatarPendantManager)paramAppRuntime.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).b();
  }
  
  public void setTextForAnimation(View paramView, SpannableStringBuilder paramSpannableStringBuilder, TextView.BufferType paramBufferType)
  {
    ((AnimationTextView)paramView).setText(paramSpannableStringBuilder, paramBufferType);
  }
  
  public void setVipCardDrawable(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    VipUtils.a(paramResources, paramImageView, paramString, paramDrawable);
  }
  
  public void setVipExtIcon(Context paramContext, ImageView paramImageView, int paramInt)
  {
    VipUtils.VipIconUtils.a(paramContext, paramImageView, paramInt, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.impl.QQSettingMeApiImpl
 * JD-Core Version:    0.7.0.1
 */