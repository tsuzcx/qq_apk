package com.tencent.mobileqq.activity.home;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeViewModel;
import com.tencent.mobileqq.app.FrameHelperActivity.QQSettingMeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.UpSideDownDrawable;

class Conversation$20
  implements FrameHelperActivity.QQSettingMeListener
{
  Conversation$20(Conversation paramConversation) {}
  
  public UpSideDownDrawable a(String paramString)
  {
    return ((DrawerBizFacade)this.a.Z.a().a()).c(paramString);
  }
  
  public void a()
  {
    this.a.Z.b();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration)
  {
    this.a.Z.a(paramConfiguration);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.a.Z.a(paramQQAppInterface);
  }
  
  public void a(String paramString, UpSideDownDrawable paramUpSideDownDrawable)
  {
    ((DrawerBizFacade)this.a.Z.a().a()).a(paramString, paramUpSideDownDrawable);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.Z.a(paramBoolean);
  }
  
  public void b()
  {
    this.a.Z.c();
  }
  
  public void c()
  {
    this.a.Z.d();
  }
  
  public ViewGroup d()
  {
    return this.a.Z.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.20
 * JD-Core Version:    0.7.0.1
 */