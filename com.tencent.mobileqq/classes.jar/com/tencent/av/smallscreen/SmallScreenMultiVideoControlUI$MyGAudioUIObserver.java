package com.tencent.av.smallscreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.MobileQQ;

class SmallScreenMultiVideoControlUI$MyGAudioUIObserver
  extends GAudioUIObserver
{
  private SmallScreenMultiVideoControlUI$MyGAudioUIObserver(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI) {}
  
  protected void a(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.b.d != 1) {
      return;
    }
    if (paramInt2 == 102)
    {
      this.b.z.k().bc = true;
      return;
    }
    if (paramInt2 == 103)
    {
      boolean bool = this.b.z.k().H;
      this.b.z.k().bc = false;
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInviteUserNotice --> Count = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ,firstName = ");
      localStringBuilder.append(paramString);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onDestroyUI");
    }
    super.a(paramLong);
    this.b.y.a().postDelayed(new SmallScreenMultiVideoControlUI.MyGAudioUIObserver.1(this, paramLong), 1500L);
  }
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    Object localObject;
    switch (paramInt1)
    {
    default: 
    case 97: 
    case 98: 
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "request video failed");
      }
      this.b.a(paramLong2, paramInt1, false, -1);
      return;
    case 96: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGaOperationResult, EV_GA_SDK_REQUEST_VIDEO_SUC, info[");
        ((StringBuilder)localObject).append(paramLong3);
        ((StringBuilder)localObject).append("], seq[");
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append("]");
        QLog.w("SmallScreenMultiVideoControlUI", 1, ((StringBuilder)localObject).toString());
      }
      if (paramLong3 == 1L)
      {
        this.b.a("onGaOperationResult");
        this.b.q();
        localObject = this.b;
        ((SmallScreenMultiVideoControlUI)localObject).a(paramLong1, ((SmallScreenMultiVideoControlUI)localObject).z.k().bi);
        return;
      }
      return;
    case 93: 
    case 94: 
    case 95: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Go Off Stage-->roomMode=");
        ((StringBuilder)localObject).append(this.b.z.k().ba);
        ((StringBuilder)localObject).append(" isBeBan");
        ((StringBuilder)localObject).append(this.b.z.k().bf);
        ((StringBuilder)localObject).append(" isPressSpeaking=");
        ((StringBuilder)localObject).append(this.b.z.k().bb);
        ((StringBuilder)localObject).append(" isOnlyManagerCanOnStage=");
        ((StringBuilder)localObject).append(this.b.z.k().bc);
        QLog.d("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
        return;
      }
      break;
    case 91: 
    case 92: 
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "go on stage failed");
      }
      if (this.b.d == 2)
      {
        ReportController.b(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
        return;
      }
      break;
    case 90: 
      if (paramLong3 == 3L)
      {
        localObject = this.b.z.k().bi;
        paramInt1 = 0;
        while (paramInt1 < ((ArrayList)localObject).size())
        {
          VideoViewInfo localVideoViewInfo = (VideoViewInfo)((ArrayList)localObject).get(paramInt1);
          if ((paramLong2 == localVideoViewInfo.a) && (localVideoViewInfo.b == 1))
          {
            bool = localVideoViewInfo.c;
            break label464;
          }
          paramInt1 += 1;
        }
        boolean bool = false;
        label464:
        this.b.A.update(null, new Object[] { Integer.valueOf(105), Boolean.valueOf(bool), Long.valueOf(paramLong1) });
        this.b.q();
      }
      break;
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateRoomSuc-->GroupID=");
      localStringBuilder.append(paramLong2);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    this.b.f();
    this.b.z.k().bv = true;
    if (this.b.c == 1) {
      this.b.y.a(this.b.r());
    }
  }
  
  protected void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoSrcTypeChange-->mGroupId=");
      localStringBuilder.append(this.b.r());
      localStringBuilder.append(" userUin=");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" groupUin=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" videoSrcType=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" relationType");
      localStringBuilder.append(paramInt2);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    if (paramLong1 != this.b.r()) {
      return;
    }
    if (paramInt2 != 1) {
      return;
    }
    this.b.a(paramLong2, 10, false, paramInt1);
    if ((paramInt1 == 2) && (this.b.z.k().I))
    {
      this.b.y.a(new Object[] { Integer.valueOf(111), Boolean.valueOf(true) });
      return;
    }
    this.b.y.a(new Object[] { Integer.valueOf(111), Boolean.valueOf(false) });
  }
  
  protected void a(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMemberBanOrCancelBanAudio, groupUin[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], userUin[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], bBan[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("SmallScreenMultiVideoControlUI", 1, localStringBuilder.toString());
    }
    if ((this.b.r() == paramLong1) && (paramLong2 == this.b.f))
    {
      if (paramInt != 1) {
        return;
      }
      if (paramBoolean)
      {
        this.b.z.k().bf = true;
        if (this.b.z.k().H)
        {
          this.b.b(l);
          this.b.z.a(this.b.f, this.b.z.k().bi, this.b.z.k().bk, 1, false);
        }
      }
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMemberVideoOut, groupId[");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("], friendUin[");
      ((StringBuilder)localObject).append(paramLong3);
      ((StringBuilder)localObject).append("], videoSrcType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenMultiVideoControlUI", 1, ((StringBuilder)localObject).toString());
    }
    if (paramLong3 == this.b.f)
    {
      if (this.b.z.k().H) {
        this.b.b(paramLong1);
      }
    }
    else
    {
      localObject = new VideoViewInfo();
      ((VideoViewInfo)localObject).a = paramLong3;
      ((VideoViewInfo)localObject).b = paramInt;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      this.b.A.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    }
    this.b.a(paramLong3, 6, false, 73);
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean)
  {
    if (this.b.d != 1) {
      return;
    }
    if (paramBoolean)
    {
      if (this.b.z.k().bi.size() == 0)
      {
        this.b.z.k().a(paramLong1, "onMemberPPTInOrOut", false, false);
        this.b.q();
        this.b.a(false, false, false);
        return;
      }
      if ((!NetworkUtil.isWifiConnected((Context)this.b.x.get())) && (this.b.z.k().B() == -1) && (!this.b.z.k().bA))
      {
        this.b.z.k().a(paramLong1, "onMemberPPTInOrOut", true, true);
        this.b.q();
        this.b.a(true, true, true);
        return;
      }
      if (this.b.r >= 4) {
        return;
      }
      this.b.y.a().removeCallbacks(this.b.p);
      this.b.p.a = "onMemberPPTInOrOut";
      this.b.y.a().postDelayed(this.b.p, 1000L);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGroupSecurityLimit-->groupid=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" info=");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(" strMsg=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
    }
    if (this.b.d != 1) {
      return;
    }
    if (paramLong1 != this.b.r()) {
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("tencent.av.v2q.MultiVideo");
    ((Intent)localObject).putExtra("type", 33);
    ((Intent)localObject).putExtra("relationId", paramLong1);
    ((Intent)localObject).putExtra("uinType", this.b.c);
    ((Intent)localObject).putExtra("info", paramLong2);
    ((Intent)localObject).putExtra("strMsg", paramString);
    ((Intent)localObject).putExtra("MultiAVType", this.b.z.k().o);
    ((Intent)localObject).putExtra("from", "SmallScreenMultiVideoControlUI1");
    paramString = (SmallScreenService)this.b.x.get();
    if (paramString != null)
    {
      ((Intent)localObject).setPackage(this.b.y.getApplication().getPackageName());
      paramString.sendBroadcast((Intent)localObject);
      paramString.stopSelf();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "onGroupSecurityLimit-->can not get the activity");
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!this.b.z.k().am)
    {
      if (this.b.r() != paramLong1)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onMemberLeave,wrong group uin.GroupUin = ");
          localStringBuilder.append(paramLong1);
          localStringBuilder.append(" ,mGroupId = ");
          localStringBuilder.append(this.b.r());
          localStringBuilder.append(" ,isQQUser = ");
          localStringBuilder.append(paramBoolean);
          QLog.e("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
        }
        return;
      }
      super.a(paramLong1, paramLong2, paramBoolean);
      this.b.a(paramLong2, 1, true, 71);
      return;
    }
    if (paramLong2 != this.b.f) {
      this.b.x();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (this.b.r() != paramLong1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMemberJoin,wrong group uin.GroupUin = ");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(" ,mGroupId = ");
        localStringBuilder.append(this.b.r());
        localStringBuilder.append(" ,isQQUser = ");
        localStringBuilder.append(paramBoolean2);
        QLog.e("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
      }
      return;
    }
    this.b.a(paramLong2, 0, paramBoolean1, 70);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramLong != 0L)
    {
      if (paramLong == this.b.f) {
        return;
      }
      this.b.c(paramBoolean1);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2, paramInt);
    if (paramBoolean1) {
      paramInt = 42;
    } else {
      paramInt = 43;
    }
    this.b.a(paramLong, 2, paramBoolean2, paramInt);
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
  }
  
  protected void a(String paramString, String[] paramArrayOfString)
  {
    super.a(paramString, paramArrayOfString);
    int i = paramArrayOfString.length;
    if (i < 1) {
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    this.b.z.a(paramArrayOfString, String.valueOf(this.b.r()), this.b.d);
    if (i == 1) {
      this.b.w.getString(2131893273);
    } else {
      String.format(this.b.w.getString(2131893272), new Object[] { Integer.valueOf(i) });
    }
    this.b.a(Long.valueOf(paramString).longValue(), 82, true, -1);
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onServiceConnected");
    }
    super.b();
    if (this.b.r() != 0L)
    {
      int i = this.b.c;
      Object localObject = String.valueOf(this.b.r());
      this.b.y.b(i, (String)localObject);
      if ((this.b.e != null) && (this.b.e.length == 0) && (this.b.c == 3000) && (this.b.b == 0))
      {
        localObject = this.b.y.g((String)localObject);
        if ((this.b.z != null) && (localObject != null))
        {
          this.b.z.a((long[])localObject);
          this.b.z.a((long[])localObject, false);
        }
      }
    }
  }
  
  protected void b(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.b.d != 1) {
      return;
    }
    if (paramInt2 != 101)
    {
      if (paramInt2 != 104)
      {
        if (paramInt2 != 107)
        {
          if (paramInt2 != 108) {
            return;
          }
          this.b.z.k().ba = 108;
          return;
        }
        this.b.z.k().ba = 107;
        return;
      }
      this.b.z.k().ba = 104;
      return;
    }
    this.b.z.a("SmallScreenMultiVideoControlUI.onSpeakModeChanged", this.b.r(), false);
    this.b.z.k().bb = true;
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInviteSomeoneEnter-->firstUin=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" length=");
      localStringBuilder.append(paramInt);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    super.b(paramLong, paramInt);
    this.b.a(paramLong, 68, true, -1);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    long l = this.b.r();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGroupVideoChatClosed, relationId[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], curGroupId[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenMultiVideoControlUI", 1, ((StringBuilder)localObject).toString());
    }
    if (l != paramLong) {
      return;
    }
    if (this.b.d != 1) {
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("tencent.av.v2q.MultiVideo");
    ((Intent)localObject).putExtra("type", 32);
    ((Intent)localObject).putExtra("relationId", paramLong);
    ((Intent)localObject).putExtra("uinType", this.b.c);
    ((Intent)localObject).putExtra("closeType", paramInt1);
    ((Intent)localObject).putExtra("MultiAVType", paramInt2);
    ((Intent)localObject).putExtra("from", "SmallScreenMultiVideoControlUI2");
    SmallScreenService localSmallScreenService = (SmallScreenService)this.b.x.get();
    if (localSmallScreenService != null)
    {
      ((Intent)localObject).setPackage(this.b.y.getApplication().getPackageName());
      localSmallScreenService.sendBroadcast((Intent)localObject);
      this.b.d(true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "onGroupVideoChatClosed-->can not get the activity");
    }
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterRoomSuc-->GroupID=");
      localStringBuilder.append(paramLong2);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    this.b.f();
    this.b.y.a().postDelayed(new SmallScreenMultiVideoControlUI.MyGAudioUIObserver.AutoCheckVideoRunnable(this), 500L);
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.b.d != 1) {
      return;
    }
    this.b.z.k().bg = true;
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    int i;
    int j;
    if (paramBoolean1)
    {
      i = 7;
      j = 78;
    }
    else
    {
      i = 8;
      j = 79;
    }
    this.b.a(paramLong2, i, false, j);
  }
  
  @SuppressLint({"NewApi"})
  protected void c(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onFirstFrameDataComeIn");
    }
    paramInt = this.b.z.k().b(paramLong, paramInt);
    if (paramInt != -1) {
      boolean bool = ((VideoViewInfo)this.b.z.k().bi.get(paramInt)).c;
    }
    this.b.b("onFirstFrameDataComeIn");
  }
  
  protected void c(long paramLong1, long paramLong2)
  {
    super.c(paramLong1, paramLong2);
    this.b.a(paramLong2, 5, false, 72);
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.b.d != 1) {
      return;
    }
    this.b.z.k().bg = false;
    if (this.b.z.k().H) {}
  }
  
  protected void d() {}
  
  protected void d(long paramLong, int paramInt)
  {
    if (paramLong == this.b.f) {
      return;
    }
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 0) {
        bool = false;
      }
    }
    else {
      this.b.c(bool);
    }
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onUpdatePstnInfo --> Start");
    }
    Object localObject = (SmallScreenService)this.b.x.get();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((SmallScreenService)localObject).b(1);
    }
    if (localObject != null)
    {
      ((SmallScreenRelativeLayout)localObject).post(new SmallScreenMultiVideoControlUI.MyGAudioUIObserver.2(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "onUpdatePstnInfo-->Can not get AVActivity");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.MyGAudioUIObserver
 * JD-Core Version:    0.7.0.1
 */