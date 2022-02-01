package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoInviteFloatBarUICtr$3
  extends GAudioUIObserver
{
  VideoInviteFloatBarUICtr$3(VideoInviteFloatBarUICtr paramVideoInviteFloatBarUICtr) {}
  
  protected void a(long paramLong, int paramInt)
  {
    super.a(paramLong);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyInviteUI-->reason=");
      localStringBuilder.append(paramInt);
      QLog.d("VideoInviteFloatBarUICtr", 2, localStringBuilder.toString());
    }
    if ((this.b.d == paramLong) || (0L == paramLong)) {
      this.b.a();
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateRoomSuc-->GroupID=");
      localStringBuilder.append(paramLong2);
      QLog.d("VideoInviteFloatBarUICtr", 2, localStringBuilder.toString());
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
      localStringBuilder.append("notifyCloseGroupVideoInviteMsgBoxByInviteId-->groupId=");
      localStringBuilder.append(paramLong);
      QLog.d("VideoInviteFloatBarUICtr", 2, localStringBuilder.toString());
    }
    if ((this.b.d == paramLong) && (this.b.y.equals(paramString))) {
      this.b.a();
    }
  }
  
  protected void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (String.valueOf(((VideoController.GAudioFriends)paramArrayList.next()).a).equalsIgnoreCase(this.b.c.getAccount())) {
        this.b.a();
      }
    }
  }
  
  protected void b()
  {
    super.b();
    this.b.a(false);
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
      QLog.w("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    }
    this.b.c.a().postDelayed(new VideoInviteFloatBarUICtr.3.1(this, paramLong2), 500L);
    this.b.s.p();
    SmallScreenActivityPlugin.a(this.b.c).a(paramLong1, false);
    if (this.b.o != null) {
      this.b.o.c();
    }
    TraeHelper.a().a(this.b.A);
    this.b.c.a().postDelayed(this.b.E, 1000L);
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
      QLog.d("VideoInviteFloatBarUICtr.troopgroup_vedio.invite", 2, localStringBuilder.toString());
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
      localStringBuilder.append("notifyCloseAllGroupVideoInviteMsgBox-->notifyByGroupId=");
      localStringBuilder.append(paramLong);
      QLog.d("VideoInviteFloatBarUICtr", 2, localStringBuilder.toString());
    }
    paramLong = this.b.d;
    this.b.a();
  }
  
  protected void e(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyCloseGroupVideoInviteMsgBox-->groupId=");
      localStringBuilder.append(paramLong);
      QLog.d("VideoInviteFloatBarUICtr", 2, localStringBuilder.toString());
    }
    if (this.b.d == paramLong) {
      this.b.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr.3
 * JD-Core Version:    0.7.0.1
 */