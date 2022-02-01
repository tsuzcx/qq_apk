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
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onSetUserCreateHotChatAnnounce.isSuccess=");
      paramString1.append(paramBoolean);
      paramString1.append(",result=");
      paramString1.append(paramInt);
      paramString1.append(", strErr=");
      paramString1.append(paramString2);
      QLog.i("HotChatAnnounceActivity", 2, paramString1.toString());
    }
    HotChatAnnounceActivity.a(this.a);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramString1 = ((HotChatManager)this.a.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(this.a.g);
      if (paramString1 != null)
      {
        paramString1.memo = this.a.k;
        paramString1.memoUrl = this.a.l;
        paramString1.memoShowed = false;
      }
      QQToast.makeText(this.a, 2, HardCodeUtil.a(2131903511), 0).show(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramString1 = HardCodeUtil.a(2131903514);
    if (paramInt == 1282) {
      paramString1 = HardCodeUtil.a(2131903519);
    }
    QQToast.makeText(this.a, 1, paramString1, 0).show(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onSetHotChatAnnounce.isSuccess=");
      paramArrayOfByte.append(paramBoolean);
      paramArrayOfByte.append(",result=");
      paramArrayOfByte.append(paramInt);
      paramArrayOfByte.append(", strErr=");
      paramArrayOfByte.append(paramString);
      QLog.i("HotChatAnnounceActivity", 2, paramArrayOfByte.toString());
    }
    HotChatAnnounceActivity.a(this.a);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramArrayOfByte = ((HotChatManager)this.a.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(this.a.g);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.memo = this.a.k;
        paramArrayOfByte.memoUrl = this.a.l;
        paramArrayOfByte.memoShowed = false;
      }
      QQToast.makeText(this.a, 2, HardCodeUtil.a(2131903518), 0).show(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    paramArrayOfByte = HardCodeUtil.a(2131903512);
    if (paramInt == 1288) {
      paramArrayOfByte = HardCodeUtil.a(2131903516);
    }
    QQToast.makeText(this.a, 1, paramArrayOfByte, 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HotChatAnnounceActivity.1
 * JD-Core Version:    0.7.0.1
 */