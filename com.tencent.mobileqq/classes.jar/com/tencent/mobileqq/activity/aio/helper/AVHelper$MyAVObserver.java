package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.doutu.DoutuHelper;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AVHelper$MyAVObserver
  extends AVObserver
{
  private AVHelper$MyAVObserver(AVHelper paramAVHelper) {}
  
  protected void a(int paramInt, long paramLong)
  {
    if (this.b.a != null)
    {
      this.b.a.d();
      super.a(paramInt, paramLong);
    }
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(AVHelper.a(this.b).b)) && (this.b.a != null)) {
        this.b.a.a("OnMemberInfo", AVHelper.a(this.b).a, AVHelper.a(this.b).b, 3, 0L);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioObserver", 2, "OnMemberInfo", localNumberFormatException);
      }
    }
    super.a(paramInt, paramLong1, paramLong2);
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnAudioChatting uinType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", peerUin: ");
      localStringBuilder.append(paramString1);
      QLog.d("GAudioObserver", 2, localStringBuilder.toString());
    }
    if (((DoutuHelper)AVHelper.b(this.b).a(115)).a != null) {
      ((DoutuHelper)AVHelper.b(this.b).a(115)).a.interruptAnimation();
    }
    if ((AVHelper.a(this.b).a != 3000) && (AVHelper.a(this.b).a != 1) && ((AVHelper.a(this.b).b.equals(paramString1)) || ((paramInt == 1006) && (AVHelper.a(this.b).b.equals(paramString2)))) && (this.b.a != null))
    {
      if (AVHelper.c(this.b).getAVNotifyCenter().a(String.valueOf(paramString1))) {
        return;
      }
      this.b.a.a(paramInt, paramString1, paramString2);
    }
    super.a(paramInt, paramString1, paramString2);
  }
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    super.a(paramLong1, paramInt1, paramLong2, paramInt2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" avtype:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("OnManagerForbiddenOpenRoom", 2, ((StringBuilder)localObject).toString());
    if ((AVHelper.a(this.b).a == paramInt1) && (Long.parseLong(AVHelper.a(this.b).b) == paramLong1)) {
      if ((paramLong2 != 1L) && (paramLong2 != 2L) && (paramLong2 != 35L) && (paramLong2 != 42L) && (paramLong2 != 43L) && (paramLong2 != 41L) && (paramLong2 != 40L))
      {
        if (paramLong2 == 3L)
        {
          QQToast.makeText(AVHelper.c(this.b).getApp(), AVHelper.d(this.b).getString(2131893353), 1).show(AVHelper.b(this.b).v());
          return;
        }
        if (paramLong2 == 4L)
        {
          QQToast.makeText(AVHelper.c(this.b).getApp(), AVHelper.d(this.b).getString(2131893350), 1).show(AVHelper.b(this.b).v());
          return;
        }
        if (paramLong2 == 8L)
        {
          QQToast.makeText(AVHelper.c(this.b).getApp(), AVHelper.d(this.b).getString(2131893349), 1).show(AVHelper.b(this.b).v());
          return;
        }
        if (paramLong2 == 7L)
        {
          localObject = String.valueOf(paramLong1);
          String str = AVHelper.c(this.b).getCurrentAccountUin();
          if (paramInt2 == 10)
          {
            VideoMsgTools.a(AVHelper.c(this.b), 1, 59, false, (String)localObject, str, false, null, false, paramInt2, new Object[0]);
            return;
          }
          if (paramInt2 == 2) {
            VideoMsgTools.a(AVHelper.c(this.b), 1, 60, false, (String)localObject, str, false, null, false, paramInt2, new Object[0]);
          }
        }
      }
      else
      {
        localObject = AVHelper.d(this.b).getString(2131893395);
        if (paramLong2 == 2L) {
          localObject = AVHelper.d(this.b).getString(2131893396);
        } else if (paramLong2 == 35L) {
          localObject = AVHelper.d(this.b).getString(2131893397);
        }
        if ((paramLong2 != 41L) && (paramLong2 != 40L))
        {
          if (paramLong2 == 42L) {
            localObject = AVHelper.d(this.b).getString(2131893398);
          } else if (paramLong2 == 43L) {
            localObject = AVHelper.d(this.b).getString(2131893399);
          }
        }
        else {
          localObject = AVHelper.d(this.b).getString(2131893400);
        }
        DialogUtil.a(AVHelper.d(this.b), 230, null, (String)localObject, 2131893167, 2131917882, new AVHelper.MyAVObserver.1(this), null).show();
      }
    }
  }
  
  protected void a(long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    super.a(paramLong1, paramInt, paramLong2, paramString);
    if ((AVHelper.a(this.b).a == paramInt) && (Long.parseLong(AVHelper.a(this.b).b) == paramLong1)) {
      DialogUtil.a(AVHelper.d(this.b), 230, null, paramString, 2131893167, 2131917882, new AVHelper.MyAVObserver.2(this), null).show();
    }
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    if ((AVHelper.a(this.b).b.equals(paramString)) && (this.b.a != null))
    {
      paramString = this.b.a;
      boolean bool = false;
      if ((paramString.a(new Object[0]) != null) && (AVHelper.c(this.b).isVideoChatting()))
      {
        paramString = this.b.a;
        if (AVHelper.c(this.b).getAVNotifyCenter().B() == 2) {
          bool = true;
        }
        paramString.a(bool);
      }
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (AVHelper.b(this.b).F() != 4) {
      return;
    }
    if ((AVHelper.a(this.b).b.equals(paramString1)) && (this.b.a != null))
    {
      Object localObject = this.b.a;
      boolean bool = false;
      if ((((VideoStatusTipsBar)localObject).a(new Object[0]) != null) && (!AVHelper.c(this.b).getAVNotifyCenter().D()))
      {
        TextView localTextView = (TextView)this.b.a.a(new Object[0]).findViewById(2131447185);
        int i = AVHelper.c(this.b).getAVNotifyCenter().t();
        if (localTextView != null)
        {
          localTextView.setVisibility(0);
          if ((AVHelper.a(this.b).a != 3000) && (AVHelper.a(this.b).a != 1))
          {
            if (i == 2) {
              localObject = AVHelper.d(this.b).getString(2131893716);
            } else if (i == 1) {
              localObject = AVHelper.d(this.b).getString(2131893112);
            } else {
              localObject = "";
            }
            i = AVHelper.d(this.b).getResources().getColor(2131168002);
            this.b.a.a(null, (String)localObject, i, paramString1, 0);
          }
          else
          {
            i = UITools.b(AVHelper.a(this.b).a);
            long l = Long.parseLong(paramString1);
            l = AVHelper.c(this.b).getAVNotifyCenter().c(i, l);
            String.format(AVHelper.d(this.b).getString(2131886546), new Object[] { Long.valueOf(l) });
          }
          localTextView.setText(paramString2);
        }
        paramString1 = this.b.a;
        if (AVHelper.c(this.b).getAVNotifyCenter().B() == 2) {
          bool = true;
        }
        paramString1.a(bool);
      }
    }
  }
  
  protected void b(int paramInt, long paramLong)
  {
    if (this.b.a != null) {
      this.b.a.e();
    }
    super.b(paramInt, paramLong);
  }
  
  protected void b(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(AVHelper.a(this.b).b)) && (this.b.a != null)) {
        this.b.a.a("OnMemberJoin", AVHelper.a(this.b).a, AVHelper.a(this.b).b, 1, paramLong2);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioObserver", 2, "OnMemberJoin", localNumberFormatException);
      }
    }
    super.b(paramInt, paramLong1, paramLong2);
  }
  
  protected void c(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(AVHelper.a(this.b).b)) && (this.b.a != null)) {
        this.b.a.a("OnMemberQuit", AVHelper.a(this.b).a, AVHelper.a(this.b).b, 2, paramLong2);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioObserver", 2, "OnMemberQuit", localNumberFormatException);
      }
    }
    super.c(paramInt, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVHelper.MyAVObserver
 * JD-Core Version:    0.7.0.1
 */