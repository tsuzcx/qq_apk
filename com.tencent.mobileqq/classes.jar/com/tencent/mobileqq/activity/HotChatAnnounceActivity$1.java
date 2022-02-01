package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class HotChatAnnounceActivity$1
  extends HotChatObserver
{
  HotChatAnnounceActivity$1(HotChatAnnounceActivity paramHotChatAnnounceActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatAnnounceActivity", 2, "onSetUserCreateHotChatAnnounce.isSuccess=" + paramBoolean + ",result=" + paramInt + ", strErr=" + paramString2);
    }
    HotChatAnnounceActivity.a(this.a);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramString1 = ((HotChatManager)this.a.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(this.a.a);
      if (paramString1 != null)
      {
        paramString1.memo = this.a.d;
        paramString1.memoUrl = this.a.e;
        paramString1.memoShowed = false;
      }
      QQToast.a(this.a, 2, HardCodeUtil.a(2131705552), 0).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramString1 = HardCodeUtil.a(2131705555);
    if (paramInt == 1282) {
      paramString1 = HardCodeUtil.a(2131705560);
    }
    QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatAnnounceActivity", 2, "onSetHotChatAnnounce.isSuccess=" + paramBoolean + ",result=" + paramInt + ", strErr=" + paramString);
    }
    HotChatAnnounceActivity.a(this.a);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramArrayOfByte = ((HotChatManager)this.a.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(this.a.a);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.memo = this.a.d;
        paramArrayOfByte.memoUrl = this.a.e;
        paramArrayOfByte.memoShowed = false;
      }
      QQToast.a(this.a, 2, HardCodeUtil.a(2131705559), 0).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramArrayOfByte = HardCodeUtil.a(2131705553);
    if (paramInt == 1288) {
      paramArrayOfByte = HardCodeUtil.a(2131705557);
    }
    QQToast.a(this.a, 1, paramArrayOfByte, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HotChatAnnounceActivity.1
 * JD-Core Version:    0.7.0.1
 */