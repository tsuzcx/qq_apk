package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qqsettingme.api.IAvatarLayoutApi;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;

public class AvatarLayoutApiImpl
  implements IAvatarLayoutApi
{
  public void putAvatar(View paramView1, View paramView2, boolean paramBoolean)
  {
    ((AvatarLayout)paramView1).a(0, paramView2, paramBoolean);
  }
  
  public void setFaceDrawable(View paramView, AppInterface paramAppInterface, Drawable paramDrawable, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    ((AvatarLayout)paramView).setFaceDrawable(paramAppInterface, paramDrawable, 1, paramString, 200, paramBoolean1, paramBoolean2, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.impl.AvatarLayoutApiImpl
 * JD-Core Version:    0.7.0.1
 */