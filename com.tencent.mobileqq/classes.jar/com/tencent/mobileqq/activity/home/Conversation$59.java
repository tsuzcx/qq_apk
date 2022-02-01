package com.tencent.mobileqq.activity.home;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.portal.ConversationHongBaoV2;

class Conversation$59
  implements DrawerFrame.IDrawerCallbacks
{
  Conversation$59(Conversation paramConversation) {}
  
  public void a(int paramInt)
  {
    if (this.a.t != null) {
      this.a.t.hideMenuPop();
    }
    if (this.a.w != null) {
      this.a.w.e();
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, float paramFloat) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.aa != null) {
      this.a.aa.q();
    }
    if (this.a.ab != null) {
      this.a.ab.l();
    }
    if (this.a.Z != null) {
      this.a.Z.g();
    }
    if (this.a.w != null) {
      this.a.w.f();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    Conversation.u(this.a);
    if (this.a.aa != null) {
      this.a.aa.r();
    }
    if (!this.a.Z.c) {
      Conversation.q(this.a);
    }
    if (this.a.Z != null) {
      this.a.Z.f();
    }
    if (this.a.ab != null) {
      this.a.ab.m();
    }
    if (this.a.w != null) {
      this.a.w.k();
    }
    if (this.a.al != null) {
      this.a.al.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.59
 * JD-Core Version:    0.7.0.1
 */