package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.doutu.combo.ComboUIManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$MyAVObserver
  extends AVObserver
{
  private BaseChatPie$MyAVObserver(BaseChatPie paramBaseChatPie) {}
  
  public void a(int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a();
      super.a(paramInt, paramLong);
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a("OnMemberInfo", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3, 0L);
      }
      super.a(paramInt, paramLong1, paramLong2);
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
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioObserver", 2, "OnAudioChatting uinType: " + paramInt + ", peerUin: " + paramString1);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager.d();
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) || ((paramInt == 1006) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString2)))) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(String.valueOf(paramString1))) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(paramInt, paramString1, paramString2);
    }
    super.a(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    super.a(paramLong1, paramInt1, paramLong2, paramInt2);
    QLog.d("OnManagerForbiddenOpenRoom", 2, " avtype:" + paramInt2);
    String str1;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramInt1) && (Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == paramLong1))
    {
      if ((paramLong2 != 1L) && (paramLong2 != 2L) && (paramLong2 != 35L) && (paramLong2 != 42L) && (paramLong2 != 43L) && (paramLong2 != 41L) && (paramLong2 != 40L)) {
        break label309;
      }
      str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695622);
      if (paramLong2 != 2L) {
        break label231;
      }
      str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695623);
    }
    label230:
    label231:
    String str2;
    label309:
    do
    {
      do
      {
        break label230;
        break label230;
        if ((paramLong2 == 41L) || (paramLong2 == 40L)) {
          str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695627);
        }
        for (;;)
        {
          DialogUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 230, null, str1, 2131695411, 2131720534, new BaseChatPie.MyAVObserver.1(this), null).show();
          return;
          if (paramLong2 != 35L) {
            break;
          }
          str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695624);
          break;
          if (paramLong2 == 42L) {
            str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695625);
          } else if (paramLong2 == 43L) {
            str1 = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695626);
          }
        }
        if (paramLong2 == 3L)
        {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.a.jdField_a_of_type_AndroidContentContext.getString(2131695583), 1).b(this.a.a());
          return;
        }
        if (paramLong2 == 4L)
        {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.a.jdField_a_of_type_AndroidContentContext.getString(2131695580), 1).b(this.a.a());
          return;
        }
        if (paramLong2 == 8L)
        {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.a.jdField_a_of_type_AndroidContentContext.getString(2131695579), 1).b(this.a.a());
          return;
        }
      } while (paramLong2 != 7L);
      str1 = String.valueOf(paramLong1);
      str2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramInt2 == 10)
      {
        VideoMsgTools.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 59, false, str1, str2, false, null, false, paramInt2, new Object[0]);
        return;
      }
    } while (paramInt2 != 2);
    VideoMsgTools.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 60, false, str1, str2, false, null, false, paramInt2, new Object[0]);
  }
  
  public void a(long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    super.a(paramLong1, paramInt, paramLong2, paramString);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramInt) && (Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == paramLong1)) {
      DialogUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 230, null, paramString, 2131695411, 2131720534, new BaseChatPie.MyAVObserver.2(this), null).show();
    }
  }
  
  public void a(String paramString)
  {
    boolean bool = false;
    super.a(paramString);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(new Object[0]) != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()))
    {
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().g() == 2) {
        bool = true;
      }
      paramString.a(bool);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    boolean bool = false;
    super.a(paramString1, paramString2);
    if (this.a.d != 4) {}
    while ((!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(new Object[0]) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().k())) {
      return;
    }
    TextView localTextView = (TextView)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(new Object[0]).findViewById(2131379197);
    int i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().e();
    String str;
    if (localTextView != null)
    {
      localTextView.setVisibility(0);
      str = "";
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        i = UITools.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        long l = Long.parseLong(paramString1);
        l = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(i, l);
        String.format(this.a.jdField_a_of_type_AndroidContentContext.getString(2131689990), new Object[] { Long.valueOf(l) });
        localTextView.setText(paramString2);
      }
    }
    else
    {
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().g() == 2) {
        bool = true;
      }
      paramString1.a(bool);
      return;
    }
    if (i == 2) {
      str = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695939);
    }
    for (;;)
    {
      i = this.a.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167041);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(null, str, i, paramString1, 0);
      break;
      if (i == 1) {
        str = this.a.jdField_a_of_type_AndroidContentContext.getString(2131695361);
      }
    }
  }
  
  public void b(int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.b();
    }
    super.b(paramInt, paramLong);
  }
  
  public void b(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a("OnMemberJoin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, paramLong2);
      }
      super.b(paramInt, paramLong1, paramLong2);
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
  
  public void c(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      if ((paramLong1 == Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a("OnMemberQuit", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 2, paramLong2);
      }
      super.c(paramInt, paramLong1, paramLong2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.MyAVObserver
 * JD-Core Version:    0.7.0.1
 */