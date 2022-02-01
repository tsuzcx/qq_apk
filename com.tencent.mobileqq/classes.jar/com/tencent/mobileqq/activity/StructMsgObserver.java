package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.Observable;
import java.util.Observer;

public class StructMsgObserver
  implements Observer
{
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!WebAccelerator.a) {
      return;
    }
    String str1;
    String str2;
    if ((paramObject instanceof MessageForStructing))
    {
      paramObject = (MessageForStructing)paramObject;
      paramObservable = paramObject.structingMsg;
      if ((!paramObject.isSend()) && (WebAccelerator.a(paramObservable)))
      {
        paramObject = paramObservable.mMsgUrl;
        str1 = paramObservable.currentAccountUin;
        str2 = paramObservable.uin;
        ThreadManager.post(new StructMsgObserver.1(this, paramObject, paramObservable.uinType, str1, str2), 5, null, false);
      }
    }
    else if ((paramObject instanceof MessageForText))
    {
      paramObservable = (MessageForText)paramObject;
      if ((!paramObservable.isSend()) && (!TextUtils.isEmpty(paramObservable.msg)))
      {
        paramObject = WebAccelerator.c(paramObservable.msg);
        if (!TextUtils.isEmpty(paramObject))
        {
          str1 = paramObservable.frienduin;
          str2 = paramObservable.selfuin;
          ThreadManager.post(new StructMsgObserver.2(this, paramObject, paramObservable.istroop, str2, str1), 5, null, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.StructMsgObserver
 * JD-Core Version:    0.7.0.1
 */