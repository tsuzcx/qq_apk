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
    if (this.a.a != null)
    {
      this.a.a.a();
      super.a(paramInt, paramLong);
    }
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(AVHelper.a(this.a).jdField_a_of_type_JavaLangString)) && (this.a.a != null)) {
        this.a.a.a("OnMemberInfo", AVHelper.a(this.a).jdField_a_of_type_Int, AVHelper.a(this.a).jdField_a_of_type_JavaLangString, 3, 0L);
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
    if (((DoutuHelper)AVHelper.a(this.a).a(115)).a != null) {
      ((DoutuHelper)AVHelper.a(this.a).a(115)).a.interruptAnimation();
    }
    if ((AVHelper.a(this.a).jdField_a_of_type_Int != 3000) && (AVHelper.a(this.a).jdField_a_of_type_Int != 1) && ((AVHelper.a(this.a).jdField_a_of_type_JavaLangString.equals(paramString1)) || ((paramInt == 1006) && (AVHelper.a(this.a).jdField_a_of_type_JavaLangString.equals(paramString2)))) && (this.a.a != null))
    {
      if (AVHelper.a(this.a).getAVNotifyCenter().a(String.valueOf(paramString1))) {
        return;
      }
      this.a.a.a(paramInt, paramString1, paramString2);
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
    if ((AVHelper.a(this.a).jdField_a_of_type_Int == paramInt1) && (Long.parseLong(AVHelper.a(this.a).jdField_a_of_type_JavaLangString) == paramLong1)) {
      if ((paramLong2 != 1L) && (paramLong2 != 2L) && (paramLong2 != 35L) && (paramLong2 != 42L) && (paramLong2 != 43L) && (paramLong2 != 41L) && (paramLong2 != 40L))
      {
        if (paramLong2 == 3L)
        {
          QQToast.a(AVHelper.a(this.a).getApp(), AVHelper.a(this.a).getString(2131695594), 1).b(AVHelper.a(this.a).b());
          return;
        }
        if (paramLong2 == 4L)
        {
          QQToast.a(AVHelper.a(this.a).getApp(), AVHelper.a(this.a).getString(2131695591), 1).b(AVHelper.a(this.a).b());
          return;
        }
        if (paramLong2 == 8L)
        {
          QQToast.a(AVHelper.a(this.a).getApp(), AVHelper.a(this.a).getString(2131695590), 1).b(AVHelper.a(this.a).b());
          return;
        }
        if (paramLong2 == 7L)
        {
          localObject = String.valueOf(paramLong1);
          String str = AVHelper.a(this.a).getCurrentAccountUin();
          if (paramInt2 == 10)
          {
            VideoMsgTools.a(AVHelper.a(this.a), 1, 59, false, (String)localObject, str, false, null, false, paramInt2, new Object[0]);
            return;
          }
          if (paramInt2 == 2) {
            VideoMsgTools.a(AVHelper.a(this.a), 1, 60, false, (String)localObject, str, false, null, false, paramInt2, new Object[0]);
          }
        }
      }
      else
      {
        localObject = AVHelper.a(this.a).getString(2131695636);
        if (paramLong2 == 2L) {
          localObject = AVHelper.a(this.a).getString(2131695637);
        } else if (paramLong2 == 35L) {
          localObject = AVHelper.a(this.a).getString(2131695638);
        }
        if ((paramLong2 != 41L) && (paramLong2 != 40L))
        {
          if (paramLong2 == 42L) {
            localObject = AVHelper.a(this.a).getString(2131695639);
          } else if (paramLong2 == 43L) {
            localObject = AVHelper.a(this.a).getString(2131695640);
          }
        }
        else {
          localObject = AVHelper.a(this.a).getString(2131695641);
        }
        DialogUtil.a(AVHelper.a(this.a), 230, null, (String)localObject, 2131695421, 2131720247, new AVHelper.MyAVObserver.1(this), null).show();
      }
    }
  }
  
  protected void a(long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    super.a(paramLong1, paramInt, paramLong2, paramString);
    if ((AVHelper.a(this.a).jdField_a_of_type_Int == paramInt) && (Long.parseLong(AVHelper.a(this.a).jdField_a_of_type_JavaLangString) == paramLong1)) {
      DialogUtil.a(AVHelper.a(this.a), 230, null, paramString, 2131695421, 2131720247, new AVHelper.MyAVObserver.2(this), null).show();
    }
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    if ((AVHelper.a(this.a).jdField_a_of_type_JavaLangString.equals(paramString)) && (this.a.a != null))
    {
      paramString = this.a.a;
      boolean bool = false;
      if ((paramString.a(new Object[0]) != null) && (AVHelper.a(this.a).isVideoChatting()))
      {
        paramString = this.a.a;
        if (AVHelper.a(this.a).getAVNotifyCenter().g() == 2) {
          bool = true;
        }
        paramString.a(bool);
      }
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (AVHelper.a(this.a).d() != 4) {
      return;
    }
    if ((AVHelper.a(this.a).jdField_a_of_type_JavaLangString.equals(paramString1)) && (this.a.a != null))
    {
      Object localObject = this.a.a;
      boolean bool = false;
      if ((((VideoStatusTipsBar)localObject).a(new Object[0]) != null) && (!AVHelper.a(this.a).getAVNotifyCenter().k()))
      {
        TextView localTextView = (TextView)this.a.a.a(new Object[0]).findViewById(2131378560);
        int i = AVHelper.a(this.a).getAVNotifyCenter().e();
        if (localTextView != null)
        {
          localTextView.setVisibility(0);
          if ((AVHelper.a(this.a).jdField_a_of_type_Int != 3000) && (AVHelper.a(this.a).jdField_a_of_type_Int != 1))
          {
            if (i == 2) {
              localObject = AVHelper.a(this.a).getString(2131695954);
            } else if (i == 1) {
              localObject = AVHelper.a(this.a).getString(2131695371);
            } else {
              localObject = "";
            }
            i = AVHelper.a(this.a).getResources().getColor(2131167064);
            this.a.a.a(null, (String)localObject, i, paramString1, 0);
          }
          else
          {
            i = UITools.b(AVHelper.a(this.a).jdField_a_of_type_Int);
            long l = Long.parseLong(paramString1);
            l = AVHelper.a(this.a).getAVNotifyCenter().a(i, l);
            String.format(AVHelper.a(this.a).getString(2131689905), new Object[] { Long.valueOf(l) });
          }
          localTextView.setText(paramString2);
        }
        paramString1 = this.a.a;
        if (AVHelper.a(this.a).getAVNotifyCenter().g() == 2) {
          bool = true;
        }
        paramString1.a(bool);
      }
    }
  }
  
  protected void b(int paramInt, long paramLong)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
    super.b(paramInt, paramLong);
  }
  
  protected void b(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(AVHelper.a(this.a).jdField_a_of_type_JavaLangString)) && (this.a.a != null)) {
        this.a.a.a("OnMemberJoin", AVHelper.a(this.a).jdField_a_of_type_Int, AVHelper.a(this.a).jdField_a_of_type_JavaLangString, 1, paramLong2);
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
      if ((paramLong1 == Long.parseLong(AVHelper.a(this.a).jdField_a_of_type_JavaLangString)) && (this.a.a != null)) {
        this.a.a.a("OnMemberQuit", AVHelper.a(this.a).jdField_a_of_type_Int, AVHelper.a(this.a).jdField_a_of_type_JavaLangString, 2, paramLong2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVHelper.MyAVObserver
 * JD-Core Version:    0.7.0.1
 */