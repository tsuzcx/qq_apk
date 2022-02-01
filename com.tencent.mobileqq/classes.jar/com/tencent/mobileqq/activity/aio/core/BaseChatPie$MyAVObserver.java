package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import aqwt;
import bfur;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import lmt;
import mum;

class BaseChatPie$MyAVObserver
  extends lmt
{
  private BaseChatPie$MyAVObserver(BaseChatPie paramBaseChatPie) {}
  
  public void onAudioChatting(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioObserver", 2, "OnAudioChatting uinType: " + paramInt + ", peerUin: " + paramString1);
    }
    if (this.this$0.mComboUIManager != null) {
      this.this$0.mComboUIManager.d();
    }
    if ((this.this$0.sessionInfo.curType != 3000) && (this.this$0.sessionInfo.curType != 1) && ((this.this$0.sessionInfo.curFriendUin.equals(paramString1)) || ((paramInt == 1006) && (this.this$0.sessionInfo.curFriendUin.equals(paramString2)))) && (this.this$0.mVideoStatusBar != null))
    {
      if (this.this$0.app.getAVNotifyCenter().a(String.valueOf(paramString1))) {
        return;
      }
      this.this$0.mVideoStatusBar.a(paramInt, paramString1, paramString2);
    }
    super.onAudioChatting(paramInt, paramString1, paramString2);
  }
  
  public void onGroupSecurityLimit(long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    super.onGroupSecurityLimit(paramLong1, paramInt, paramLong2, paramString);
    if ((this.this$0.sessionInfo.curType == paramInt) && (Long.valueOf(this.this$0.sessionInfo.curFriendUin).longValue() == paramLong1)) {
      bfur.a(this.this$0.mContext, 230, null, paramString, 2131694952, 2131719509, new BaseChatPie.MyAVObserver.2(this), null).show();
    }
  }
  
  public void onManagerForbiddenOpenRoom(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    super.onManagerForbiddenOpenRoom(paramLong1, paramInt1, paramLong2, paramInt2);
    QLog.d("OnManagerForbiddenOpenRoom", 2, " avtype:" + paramInt2);
    String str1;
    if ((this.this$0.sessionInfo.curType == paramInt1) && (Long.valueOf(this.this$0.sessionInfo.curFriendUin).longValue() == paramLong1))
    {
      if ((paramLong2 != 1L) && (paramLong2 != 2L) && (paramLong2 != 35L) && (paramLong2 != 42L) && (paramLong2 != 43L) && (paramLong2 != 41L) && (paramLong2 != 40L)) {
        break label312;
      }
      str1 = this.this$0.mContext.getString(2131695165);
      if (paramLong2 != 2L) {
        break label234;
      }
      str1 = this.this$0.mContext.getString(2131695166);
    }
    label233:
    label234:
    String str2;
    label312:
    do
    {
      do
      {
        break label233;
        break label233;
        if ((paramLong2 == 41L) || (paramLong2 == 40L)) {
          str1 = this.this$0.mContext.getString(2131695170);
        }
        for (;;)
        {
          bfur.a(this.this$0.mContext, 230, null, str1, 2131694952, 2131719509, new BaseChatPie.MyAVObserver.1(this), null).show();
          return;
          if (paramLong2 != 35L) {
            break;
          }
          str1 = this.this$0.mContext.getString(2131695167);
          break;
          if (paramLong2 == 42L) {
            str1 = this.this$0.mContext.getString(2131695168);
          } else if (paramLong2 == 43L) {
            str1 = this.this$0.mContext.getString(2131695169);
          }
        }
        if (paramLong2 == 3L)
        {
          QQToast.a(this.this$0.app.getApp(), this.this$0.mContext.getString(2131695127), 1).b(this.this$0.getTitleBarHeight());
          return;
        }
        if (paramLong2 == 4L)
        {
          QQToast.a(this.this$0.app.getApp(), this.this$0.mContext.getString(2131695124), 1).b(this.this$0.getTitleBarHeight());
          return;
        }
        if (paramLong2 == 8L)
        {
          QQToast.a(this.this$0.app.getApp(), this.this$0.mContext.getString(2131695123), 1).b(this.this$0.getTitleBarHeight());
          return;
        }
      } while (paramLong2 != 7L);
      str1 = String.valueOf(paramLong1);
      str2 = this.this$0.app.getCurrentAccountUin();
      if (paramInt2 == 10)
      {
        VideoMsgTools.a(this.this$0.app, 1, 59, false, str1, str2, false, null, false, paramInt2, new Object[0]);
        return;
      }
    } while (paramInt2 != 2);
    VideoMsgTools.a(this.this$0.app, 1, 60, false, str1, str2, false, null, false, paramInt2, new Object[0]);
  }
  
  public void onMeetingCancel(int paramInt, long paramLong)
  {
    if (this.this$0.mVideoStatusBar != null) {
      this.this$0.mVideoStatusBar.b();
    }
    super.onMeetingCancel(paramInt, paramLong);
  }
  
  public void onMeetingReady(int paramInt, long paramLong)
  {
    if (this.this$0.mVideoStatusBar != null)
    {
      this.this$0.mVideoStatusBar.a();
      super.onMeetingReady(paramInt, paramLong);
    }
  }
  
  public void onMemberInfo(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(this.this$0.sessionInfo.curFriendUin)) && (this.this$0.mVideoStatusBar != null)) {
        this.this$0.mVideoStatusBar.a("OnMemberInfo", this.this$0.sessionInfo.curType, this.this$0.sessionInfo.curFriendUin, 3, 0L);
      }
      super.onMemberInfo(paramInt, paramLong1, paramLong2);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioObserver", 2, "OnMemberInfo", localNumberFormatException);
        }
      }
    }
  }
  
  public void onMemberJoin(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(this.this$0.sessionInfo.curFriendUin)) && (this.this$0.mVideoStatusBar != null)) {
        this.this$0.mVideoStatusBar.a("OnMemberJoin", this.this$0.sessionInfo.curType, this.this$0.sessionInfo.curFriendUin, 1, paramLong2);
      }
      super.onMemberJoin(paramInt, paramLong1, paramLong2);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioObserver", 2, "OnMemberJoin", localNumberFormatException);
        }
      }
    }
  }
  
  public void onMemberQuit(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(this.this$0.sessionInfo.curFriendUin)) && (this.this$0.mVideoStatusBar != null)) {
        this.this$0.mVideoStatusBar.a("OnMemberQuit", this.this$0.sessionInfo.curType, this.this$0.sessionInfo.curFriendUin, 2, paramLong2);
      }
      super.onMemberQuit(paramInt, paramLong1, paramLong2);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioObserver", 2, "OnMemberQuit", localNumberFormatException);
        }
      }
    }
  }
  
  public void onSmallScreenStateChange(String paramString)
  {
    boolean bool = false;
    super.onSmallScreenStateChange(paramString);
    if ((this.this$0.sessionInfo.curFriendUin.equals(paramString)) && (this.this$0.mVideoStatusBar != null) && (this.this$0.mVideoStatusBar.a(new Object[0]) != null) && (this.this$0.app.isVideoChatting()))
    {
      paramString = this.this$0.mVideoStatusBar;
      if (this.this$0.app.getAVNotifyCenter().g() == 2) {
        bool = true;
      }
      paramString.a(bool);
    }
  }
  
  public void onUpdateTime(String paramString1, String paramString2)
  {
    boolean bool = false;
    super.onUpdateTime(paramString1, paramString2);
    if (this.this$0.mCurrentAIOState != 4) {}
    while ((!this.this$0.sessionInfo.curFriendUin.equals(paramString1)) || (this.this$0.mVideoStatusBar == null) || (this.this$0.mVideoStatusBar.a(new Object[0]) == null) || (this.this$0.app.getAVNotifyCenter().k())) {
      return;
    }
    TextView localTextView = (TextView)this.this$0.mVideoStatusBar.a(new Object[0]).findViewById(2131378474);
    int i = this.this$0.app.getAVNotifyCenter().e();
    String str;
    if (localTextView != null)
    {
      localTextView.setVisibility(0);
      str = "";
      if ((this.this$0.sessionInfo.curType == 3000) || (this.this$0.sessionInfo.curType == 1))
      {
        i = mum.b(this.this$0.sessionInfo.curType);
        long l = Long.valueOf(paramString1).longValue();
        l = this.this$0.app.getAVNotifyCenter().a(i, l);
        String.format(this.this$0.mContext.getString(2131689919), new Object[] { Long.valueOf(l) });
        localTextView.setText(paramString2);
      }
    }
    else
    {
      paramString1 = this.this$0.mVideoStatusBar;
      if (this.this$0.app.getAVNotifyCenter().g() == 2) {
        bool = true;
      }
      paramString1.a(bool);
      return;
    }
    if (i == 2) {
      str = this.this$0.mContext.getString(2131695479);
    }
    for (;;)
    {
      i = this.this$0.mContext.getResources().getColor(2131167020);
      this.this$0.mVideoStatusBar.a(null, str, i, paramString1, 0);
      break;
      if (i == 1) {
        str = this.this$0.mContext.getString(2131694902);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.MyAVObserver
 * JD-Core Version:    0.7.0.1
 */