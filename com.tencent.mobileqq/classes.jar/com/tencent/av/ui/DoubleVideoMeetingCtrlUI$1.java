package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class DoubleVideoMeetingCtrlUI$1
  extends GAudioUIObserver
{
  DoubleVideoMeetingCtrlUI$1(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b.X, 2, "onGAudioInviteResp");
    }
    AVActivity localAVActivity = (AVActivity)this.b.ak.get();
    if ((localAVActivity != null) && (!localAVActivity.isFinishing())) {
      localAVActivity.runOnUiThread(new DoubleVideoMeetingCtrlUI.1.1(this));
    }
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestory UI-->relationId = ");
      localStringBuilder.append(paramLong);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.b.i == paramLong) {
      this.b.b(true);
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyInviteUI-->GroupId = ");
      localStringBuilder.append(paramLong);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramLong == this.b.i)
    {
      super.a(paramLong);
      this.b.b(true);
    }
  }
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    if (this.b.V()) {
      return;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.b.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGaOperationResult, result[");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("], uin[");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("], info[");
      ((StringBuilder)localObject2).append(paramLong3);
      ((StringBuilder)localObject2).append("], groupId[");
      ((StringBuilder)localObject2).append(paramLong4);
      ((StringBuilder)localObject2).append("], relationType[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("], mCameraNum[");
      ((StringBuilder)localObject2).append(this.b.ac);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.b.am.k();
    switch (paramInt1)
    {
    default: 
    case 96: 
      if (paramLong3 == 1L)
      {
        if (((SessionInfo)localObject1).bz) {
          return;
        }
        this.b.e("onGaOperationResult->REQUEST_VIDEO_SUC");
        this.b.a(paramLong1, ((SessionInfo)localObject1).bi);
        return;
      }
      break;
    case 91: 
    case 92: 
      this.b.c(paramLong1, true);
      this.b.q(paramLong1);
      this.b.al.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
      return;
    case 90: 
      if (paramLong3 == 3L)
      {
        if (this.b.aA != null) {
          if (this.b.ac > 1) {
            this.b.aA.setViewVisibility(2131441310, 0);
          } else {
            this.b.aA.setViewVisibility(2131441310, 8);
          }
        }
        if ((!((SessionInfo)localObject1).H) || (this.b.c))
        {
          localObject2 = this.b;
          ((DoubleVideoMeetingCtrlUI)localObject2).c = false;
          ((DoubleVideoMeetingCtrlUI)localObject2).p(paramLong1);
          paramInt1 = ((SessionInfo)localObject1).b(this.b.k, 1);
          boolean bool;
          if (paramInt1 != -1) {
            bool = ((VideoViewInfo)((SessionInfo)localObject1).bi.get(paramInt1)).c;
          } else {
            bool = false;
          }
          this.b.al.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(bool), Long.valueOf(paramLong1) });
        }
        DoubleVideoMeetingCtrlUI.a(this.b, paramLong1);
        return;
      }
      if (paramLong3 == 2L) {}
      break;
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateRoomSuc-->relationId = ");
      localStringBuilder.append(paramLong2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramLong2 != this.b.i) {
      return;
    }
    this.b.a(paramLong1, true);
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMemberVideoOut, groupId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], friendUin[");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append("], videoSrcType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.b.a(paramLong1, paramLong2, paramLong3, 2);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMemberLeave, groupId[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], friendUin[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], isQQUser[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.b.a(l, paramLong1, paramLong2, 6);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMemberJoin, groupId[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], friendUin[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], isRfresh[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], isQQUser[");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramLong2 == this.b.i)
    {
      this.b.am.k().cm = 1;
      this.b.a(l, paramLong1, paramLong2, 5);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EnterRoomSuc-->GroupId = ");
      localStringBuilder.append(paramLong2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramLong2 == this.b.i) {
      this.b.G(paramLong1);
    }
    this.b.a(paramLong1, false);
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGaMemberShareSrcInOrOut, groupId[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], groupId[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], bIn[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], isPPT[");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramBoolean1) {
      this.b.a(l, paramLong1, paramLong2, 3);
    } else {
      this.b.a(l, paramLong1, paramLong2, 4);
    }
    this.b.b = paramBoolean2;
  }
  
  protected void c(long paramLong, int paramInt)
  {
    if (this.b.am == null) {
      return;
    }
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFirstFrameDataComeIn, uin[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], videoSrcType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    paramInt = this.b.am.k().b(paramLong, paramInt);
    if ((paramInt != -1) && (((VideoViewInfo)this.b.am.k().bi.get(paramInt)).c))
    {
      TipsUtil.b(this.b.al, 1036);
      TipsUtil.b(this.b.al, 1037);
    }
    DoubleVideoMeetingCtrlUI.b(this.b, l);
    this.b.f("OnFirstFrameDataComeIn");
  }
  
  protected void c(long paramLong1, long paramLong2)
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMemberVideoIn, groupId[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], friendUin[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.b.a(l, paramLong1, paramLong2, 1);
  }
  
  protected void d(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMeetingNotifyTimeout, relationId[");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVShare", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b.am.k();
    if ((paramLong2 == this.b.i) && (((SessionInfo)localObject).aN == paramLong2)) {
      this.b.a(paramLong1, (SessionInfo)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.1
 * JD-Core Version:    0.7.0.1
 */