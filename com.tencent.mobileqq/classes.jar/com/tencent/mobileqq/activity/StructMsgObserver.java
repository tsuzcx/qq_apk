package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.Observable;
import java.util.Observer;
import ttr;
import tts;

public class StructMsgObserver
  implements Observer
{
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!WebAccelerator.a) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramObject instanceof MessageForStructing)) {
              break;
            }
            paramObject = (MessageForStructing)paramObject;
            paramObservable = paramObject.structingMsg;
          } while ((paramObject.isSend()) || (!WebAccelerator.a(paramObservable)));
          paramObject = paramObservable.mMsgUrl;
          str1 = paramObservable.currentAccountUin;
          str2 = paramObservable.uin;
          ThreadManager.post(new ttr(this, paramObject, paramObservable.uinType, str1, str2), 5, null, false);
          return;
        } while (!(paramObject instanceof MessageForText));
        paramObservable = (MessageForText)paramObject;
      } while ((paramObservable.isSend()) || (TextUtils.isEmpty(paramObservable.msg)));
      paramObject = WebAccelerator.c(paramObservable.msg);
    } while (TextUtils.isEmpty(paramObject));
    String str1 = paramObservable.frienduin;
    String str2 = paramObservable.selfuin;
    ThreadManager.post(new tts(this, paramObject, paramObservable.istroop, str2, str1), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.StructMsgObserver
 * JD-Core Version:    0.7.0.1
 */