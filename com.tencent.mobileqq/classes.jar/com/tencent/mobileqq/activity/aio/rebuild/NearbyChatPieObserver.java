package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class NearbyChatPieObserver
  extends MessageObserver
{
  private NearbyChatPie a;
  
  NearbyChatPieObserver(NearbyChatPie paramNearbyChatPie)
  {
    this.a = paramNearbyChatPie;
  }
  
  private void a(int paramInt)
  {
    if ((paramInt != 3) && (paramInt != 28) && (paramInt != 48)) {
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718364), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        paramString = this.a;
        paramString.m = true;
        paramString.a(262144, null, paramLong);
        if (this.a.E)
        {
          paramString = new Message();
          paramString.what = 39;
          paramString.obj = this.a.f;
          this.a.a().removeMessages(39);
          this.a.a().sendMessage(paramString);
        }
        ThreadManagerV2.excute(new NearbyChatPieObserver.1(this, paramBoolean, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("NEARBY_MSG_REPORT_SOURCE"), (INearbyCardManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
      }
    }
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.e(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramInt1 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel())
      {
        paramSendMessageHandler = this.a.b;
        paramString2 = new StringBuilder();
        paramString2.append("onUpdateSendMsgError uin ");
        paramString2.append(paramString1);
        paramString2.append(" type ");
        paramString2.append(paramInt1);
        paramString2.append(" uniseq ");
        paramString2.append(paramLong2);
        paramString2.append(" errorCode ");
        paramString2.append(paramInt2);
        QLog.d(paramSendMessageHandler, 2, paramString2.toString());
      }
      if (paramInt1 == 1009) {
        a(paramInt2);
      }
      this.a.e(196608);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramSendMessageHandler = this.a.b;
      paramString2 = new StringBuilder();
      paramString2.append("onUpdateSendMsgError exception uin ");
      paramString2.append(paramString1);
      paramString2.append(" type ");
      paramString2.append(paramInt1);
      paramString2.append(" uniseq ");
      paramString2.append(paramLong2);
      QLog.d(paramSendMessageHandler, 2, paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPieObserver
 * JD-Core Version:    0.7.0.1
 */