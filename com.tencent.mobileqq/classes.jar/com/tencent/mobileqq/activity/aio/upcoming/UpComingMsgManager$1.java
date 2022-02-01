package com.tencent.mobileqq.activity.aio.upcoming;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.colornote.data.ColorNote;

class UpComingMsgManager$1
  implements Handler.Callback
{
  UpComingMsgManager$1(UpComingMsgManager paramUpComingMsgManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((paramMessage.obj instanceof ColorNote))
      {
        paramMessage = (ColorNote)paramMessage.obj;
        UpComingMsgManager.a(this.a, paramMessage);
        UpComingMsgManager.b(this.a, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager.1
 * JD-Core Version:    0.7.0.1
 */