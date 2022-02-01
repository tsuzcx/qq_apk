package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

class MultiIncomingCallUICtr$3
  extends GAudioUIObserver
{
  MultiIncomingCallUICtr$3(MultiIncomingCallUICtr paramMultiIncomingCallUICtr) {}
  
  protected void a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (this.b.t)
    {
      long l = AudioHelper.c();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroyInviteUI, groupId[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("], mPeerUin[");
        localStringBuilder.append(this.b.m);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(l);
        localStringBuilder.append("]");
        QLog.w("MultiIncomingCallUICtr", 1, localStringBuilder.toString());
      }
      if ((this.b.m != null) && (this.b.m.equals(String.valueOf(paramLong))))
      {
        this.b.a(l, paramInt);
        this.b.a();
      }
    }
    else if ((this.b.d == paramLong) || (0L == paramLong))
    {
      this.b.a();
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyInviteUI, groupId:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", reason:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", mGroupId:");
      localStringBuilder.append(this.b.d);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateRoomSuc-->GroupID=");
      localStringBuilder.append(paramLong2);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
    this.b.l.bv = true;
    if (this.b.g == 1) {
      this.b.c.a(paramLong2);
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyCloseGroupVideoInviteMsgBoxByInviteId-->GroupID=");
      localStringBuilder.append(paramLong);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
    if ((this.b.d == paramLong) && (this.b.x.equals(paramString))) {
      this.b.a();
    }
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterRoomSuc, groupId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.w("MultiIncomingCallUICtr", 1, localStringBuilder.toString());
    }
    this.b.c.a().postDelayed(new MultiIncomingCallUICtr.3.1(this, paramLong2), 500L);
    this.b.g();
    SmallScreenActivityPlugin.a(this.b.c).a(paramLong1, false);
    if (this.b.o != null) {
      this.b.o.c();
    }
    this.b.c.a().postDelayed(this.b.H, 1000L);
    TraeHelper.a().a(this.b.E);
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("groupId:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", memUin:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",invitedId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mInviterUin:");
      localStringBuilder.append(this.b.i);
      localStringBuilder.append(", mGroupId:");
      localStringBuilder.append(this.b.d);
      QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, localStringBuilder.toString());
    }
    if ((paramLong2 == this.b.i) && (paramLong1 == this.b.d)) {
      this.b.a();
    }
  }
  
  protected void d(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyCloseAllGroupVideoInviteMsgBox-->GroupID=");
      localStringBuilder.append(paramLong);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
    if (this.b.d != paramLong) {
      this.b.b(0);
    }
    this.b.a();
  }
  
  protected void e(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyCloseGroupVideoInviteMsgBox-->GroupID=");
      localStringBuilder.append(paramLong);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
    if (this.b.d == paramLong) {
      this.b.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr.3
 * JD-Core Version:    0.7.0.1
 */