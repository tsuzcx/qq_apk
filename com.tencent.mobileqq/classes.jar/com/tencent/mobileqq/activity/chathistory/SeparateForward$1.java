package com.tencent.mobileqq.activity.chathistory;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class SeparateForward$1
  extends FriendListObserver
{
  SeparateForward$1(SeparateForward paramSeparateForward) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    SeparateForward.a(this.a).removeMessages(1);
    if ((this.a.a != null) && (this.a.a.isShowing()))
    {
      this.a.a.dismiss();
      MultiMsgManager.a().d.clear();
      if ((paramBoolean) && (paramObject != null)) {
        MultiMsgManager.a().d.putAll((Map)paramObject);
      }
      Object localObject;
      if (MultiMsgManager.a().d.size() == 0)
      {
        localObject = (QBaseActivity)this.a.b.get();
        if (localObject != null) {
          QQToast.makeText(this.a.c.getApp(), 2131896472, 0).show(((QBaseActivity)localObject).getTitleBarHeight());
        }
      }
      else
      {
        this.a.a((Map)paramObject, MultiMsgManager.a().c);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetFriendNickBatch = ");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    QLog.e("SeparateForward", 1, new Object[] { "onGetFriendNickBatch timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SeparateForward.1
 * JD-Core Version:    0.7.0.1
 */