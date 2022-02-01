package com.tencent.mobileqq.avatar.dynamicavatar;

import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import mqq.util.WeakReference;

class SelectCoverActivity$CoverTransProcessorHandler
  extends TransProcessorHandler
{
  WeakReference<QQAppInterface> a;
  WeakReference<SelectCoverActivity> b;
  
  SelectCoverActivity$CoverTransProcessorHandler(QQAppInterface paramQQAppInterface, SelectCoverActivity paramSelectCoverActivity)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramSelectCoverActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    SelectCoverActivity localSelectCoverActivity = (SelectCoverActivity)this.b.get();
    if ((localQQAppInterface == null) || (localSelectCoverActivity == null)) {
      return;
    }
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1003: 
      SelectCoverActivity.a(localQQAppInterface, localSelectCoverActivity, localFileMsg);
      return;
    }
    SelectCoverActivity.a(localSelectCoverActivity, localFileMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.CoverTransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */