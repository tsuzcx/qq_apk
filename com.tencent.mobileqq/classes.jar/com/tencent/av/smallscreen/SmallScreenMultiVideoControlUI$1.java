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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.MobileQQ;

class SmallScreenMultiVideoControlUI$1
  extends GAudioUIObserver
{
  SmallScreenMultiVideoControlUI$1(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI) {}
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.a.d != 1) {}
    do
    {
      return;
      if (paramInt2 == 102)
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().Z = true;
        return;
      }
    } while (paramInt2 != 103);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j) {}
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().Z = false;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onInviteUserNotice --> Count = " + paramInt + " ,firstName = " + paramString);
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onDestroyUI");
    }
    super.a(paramLong);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenMultiVideoControlUI.1.1(this, paramLong), 1500L);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    label205:
    VideoViewInfo localVideoViewInfo;
    switch (paramInt1)
    {
    default: 
    case 96: 
    case 97: 
    case 98: 
    case 90: 
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.w("SmallScreenMultiVideoControlUI", 1, "onGaOperationResult, EV_GA_SDK_REQUEST_VIDEO_SUC, info[" + paramLong3 + "], seq[" + paramLong1 + "]");
          }
          if (paramLong3 == 1L)
          {
            this.a.a("onGaOperationResult");
            this.a.o();
            this.a.a(paramLong1, this.a.jdField_a_of_type_ComTencentAvVideoController.a().c);
            return;
          }
        } while (paramLong3 != 0L);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenMultiVideoControlUI", 2, "request video failed");
        }
        this.a.a(paramLong2, paramInt1, false, -1);
        return;
      } while (paramLong3 != 3L);
      ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
      paramInt1 = 0;
      if (paramInt1 < localArrayList.size())
      {
        localVideoViewInfo = (VideoViewInfo)localArrayList.get(paramInt1);
        if ((paramLong2 != localVideoViewInfo.jdField_a_of_type_Long) || (localVideoViewInfo.jdField_a_of_type_Int != 1)) {
          break;
        }
      }
      break;
    }
    for (boolean bool = localVideoViewInfo.jdField_a_of_type_Boolean;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(105), Boolean.valueOf(bool), Long.valueOf(paramLong1) });
      this.a.o();
      return;
      paramInt1 += 1;
      break label205;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "go on stage failed");
      }
      if (this.a.d != 2) {
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SmallScreenMultiVideoControlUI", 2, "Go Off Stage-->roomMode=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().K + " isBeBan" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().ac + " isPressSpeaking=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().Y + " isOnlyManagerCanOnStage=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().Z);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onCreateRoomSuc-->GroupID=" + paramLong2);
    }
    this.a.f();
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().an = true;
    if (this.a.c == 1) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.a());
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onVideoSrcTypeChange-->mGroupId=" + this.a.a() + " userUin=" + paramLong2 + " groupUin=" + paramLong1 + " videoSrcType=" + paramInt1 + " relationType" + paramInt2);
    }
    if (paramLong1 != this.a.a()) {}
    while (paramInt2 != 1) {
      return;
    }
    this.a.a(paramLong2, 10, false, paramInt1);
    if ((paramInt1 == 2) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().k))
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(111), Boolean.valueOf(true) });
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(111), Boolean.valueOf(false) });
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "onMemberBanOrCancelBanAudio, groupUin[" + paramLong1 + "], userUin[" + paramLong2 + "], relationType[" + paramInt + "], bBan[" + paramBoolean + "], seq[" + l + "]");
    }
    if ((this.a.a() != paramLong1) || (paramLong2 != this.a.jdField_a_of_type_Long) || (paramInt != 1)) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().ac = true;
    } while (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().j);
    this.a.b(l);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, this.a.jdField_a_of_type_ComTencentAvVideoController.a().d, 1, false);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "onMemberVideoOut, groupId[" + paramLong2 + "], friendUin[" + paramLong3 + "], videoSrcType[" + paramInt + "], seq[" + paramLong1 + "]");
    }
    if (paramLong3 == this.a.jdField_a_of_type_Long) {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j) {
        this.a.b(paramLong1);
      }
    }
    for (;;)
    {
      this.a.a(paramLong3, 6, false, 73);
      return;
      VideoViewInfo localVideoViewInfo = new VideoViewInfo();
      localVideoViewInfo.jdField_a_of_type_Long = paramLong3;
      localVideoViewInfo.jdField_a_of_type_Int = paramInt;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localVideoViewInfo);
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean)
  {
    if (this.a.d != 1) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.size() == 0)
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong1, "onMemberPPTInOrOut", false, false);
        this.a.o();
        this.a.a(false, false, false);
        return;
      }
      if ((!NetworkUtil.h((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().b() == -1) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().as)) {
        break;
      }
    } while (this.a.e >= 4);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
    this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable.a = "onMemberPPTInOrOut";
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
    return;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong1, "onMemberPPTInOrOut", true, true);
    this.a.o();
    this.a.a(true, true, true);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onGroupSecurityLimit-->groupid=" + paramLong1 + " info=" + paramLong2 + " strMsg=" + paramString);
    }
    if (this.a.d != 1) {}
    do
    {
      do
      {
        return;
      } while (paramLong1 != this.a.a());
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 33);
      localIntent.putExtra("relationId", paramLong1);
      localIntent.putExtra("uinType", this.a.c);
      localIntent.putExtra("info", paramLong2);
      localIntent.putExtra("strMsg", paramString);
      localIntent.putExtra("MultiAVType", this.a.jdField_a_of_type_ComTencentAvVideoController.a().D);
      localIntent.putExtra("from", "SmallScreenMultiVideoControlUI1");
      paramString = (SmallScreenService)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramString != null)
      {
        localIntent.setPackage(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        paramString.sendBroadcast(localIntent);
        paramString.stopSelf();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenMultiVideoControlUI", 2, "onGroupSecurityLimit-->can not get the activity");
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().J) {
      if (this.a.a() != paramLong1) {
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenMultiVideoControlUI", 2, "onMemberLeave,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.a.a() + " ,isQQUser = " + paramBoolean);
        }
      }
    }
    while (paramLong2 == this.a.jdField_a_of_type_Long)
    {
      return;
      super.a(paramLong1, paramLong2, paramBoolean);
      this.a.a(paramLong2, 1, true, 71);
      return;
    }
    this.a.v();
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (this.a.a() != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "onMemberJoin,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.a.a() + " ,isQQUser = " + paramBoolean2);
      }
      return;
    }
    this.a.a(paramLong2, 0, paramBoolean1, 70);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramLong == 0L) || (paramLong == this.a.jdField_a_of_type_Long)) {
      return;
    }
    this.a.c(paramBoolean1);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2, paramInt);
    if (paramBoolean1) {}
    for (paramInt = 42;; paramInt = 43)
    {
      this.a.a(paramLong, 2, paramBoolean2, paramInt);
      return;
    }
  }
  
  public void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
  }
  
  public void a(String paramString, String[] paramArrayOfString)
  {
    super.a(paramString, paramArrayOfString);
    int i = paramArrayOfString.length;
    if (i < 1) {
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayOfString, String.valueOf(this.a.a()), this.a.d);
    if (i == 1) {
      this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695503);
    }
    for (;;)
    {
      this.a.a(Long.valueOf(paramString).longValue(), 82, true, -1);
      return;
      String.format(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131695502), new Object[] { Integer.valueOf(i) });
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onServiceConnected");
    }
    super.b();
    if (this.a.a() != 0L)
    {
      int i = this.a.c;
      Object localObject = String.valueOf(this.a.a());
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject);
      if ((this.a.jdField_a_of_type_ArrayOfLong != null) && (this.a.jdField_a_of_type_ArrayOfLong.length == 0) && (this.a.c == 3000) && (this.a.b == 0))
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a((String)localObject);
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (localObject != null))
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject);
          this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject, false);
        }
      }
    }
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.a.d != 1) {
      return;
    }
    switch (paramInt2)
    {
    case 102: 
    case 103: 
    case 105: 
    case 106: 
    default: 
      return;
    case 101: 
      this.a.jdField_a_of_type_ComTencentAvVideoController.a("SmallScreenMultiVideoControlUI.onSpeakModeChanged", this.a.a(), false);
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().Y = true;
      return;
    case 108: 
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().K = 108;
      return;
    case 107: 
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().K = 107;
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().K = 104;
  }
  
  public void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onInviteSomeoneEnter-->firstUin=" + paramLong + " length=" + paramInt);
    }
    super.b(paramLong, paramInt);
    this.a.a(paramLong, 68, true, -1);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    long l = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "onGroupVideoChatClosed, relationId[" + paramLong + "], curGroupId[" + l + "]");
    }
    if (l != paramLong) {}
    do
    {
      do
      {
        return;
      } while (this.a.d != 1);
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 32);
      localIntent.putExtra("relationId", paramLong);
      localIntent.putExtra("uinType", this.a.c);
      localIntent.putExtra("closeType", paramInt1);
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("from", "SmallScreenMultiVideoControlUI2");
      SmallScreenService localSmallScreenService = (SmallScreenService)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localSmallScreenService != null)
      {
        localIntent.setPackage(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        localSmallScreenService.sendBroadcast(localIntent);
        this.a.d(true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenMultiVideoControlUI", 2, "onGroupVideoChatClosed-->can not get the activity");
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onEnterRoomSuc-->GroupID=" + paramLong2);
    }
    this.a.f();
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenMultiVideoControlUI.1.AutoCheckVideoRunnable(this), 500L);
  }
  
  public void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.a.d != 1) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().ad = true;
  }
  
  public void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    int i;
    if (paramBoolean1) {
      i = 7;
    }
    for (int j = 78;; j = 79)
    {
      this.a.a(paramLong2, i, false, j);
      return;
      i = 8;
    }
  }
  
  @SuppressLint({"NewApi"})
  public void c(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onFirstFrameDataComeIn");
    }
    paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, paramInt);
    if ((paramInt != -1) && (((VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(paramInt)).jdField_a_of_type_Boolean)) {}
    this.a.b("onFirstFrameDataComeIn");
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    super.c(paramLong1, paramLong2);
    this.a.a(paramLong2, 5, false, 72);
  }
  
  public void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.a.d != 1) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().ad = false;
    } while (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().j);
  }
  
  public void d() {}
  
  public void d(long paramLong, int paramInt)
  {
    boolean bool = true;
    if (paramLong == this.a.jdField_a_of_type_Long) {
      return;
    }
    if (paramInt == 1) {}
    for (;;)
    {
      this.a.c(bool);
      return;
      if (paramInt != 0) {
        break;
      }
      bool = false;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onUpdatePstnInfo --> Start");
    }
    Object localObject = (SmallScreenService)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        break label62;
      }
      ((SmallScreenRelativeLayout)localObject).post(new SmallScreenMultiVideoControlUI.1.2(this));
    }
    label62:
    while (!QLog.isColorLevel())
    {
      return;
      localObject = ((SmallScreenService)localObject).a(1);
      break;
    }
    QLog.e("SmallScreenMultiVideoControlUI", 2, "onUpdatePstnInfo-->Can not get AVActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.1
 * JD-Core Version:    0.7.0.1
 */