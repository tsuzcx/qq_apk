package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.util.MqqWeakReferenceHandler;

class SimpleCheckableSlidingIndicator$2
  implements Handler.Callback
{
  SimpleCheckableSlidingIndicator$2(SimpleCheckableSlidingIndicator paramSimpleCheckableSlidingIndicator) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == SimpleCheckableSlidingIndicator.e)
    {
      if (this.a.getScrollX() == SimpleCheckableSlidingIndicator.a(this.a))
      {
        SimpleCheckableSlidingIndicator.b(this.a, SimpleCheckableSlidingIndicator.b);
        if (SimpleCheckableSlidingIndicator.b(this.a) != null) {
          SimpleCheckableSlidingIndicator.b(this.a).a(SimpleCheckableSlidingIndicator.c(this.a));
        }
        SimpleCheckableSlidingIndicator.d(this.a).removeMessages(SimpleCheckableSlidingIndicator.e);
        return false;
      }
      SimpleCheckableSlidingIndicator.b(this.a, SimpleCheckableSlidingIndicator.d);
      if (SimpleCheckableSlidingIndicator.b(this.a) != null) {
        SimpleCheckableSlidingIndicator.b(this.a).a(SimpleCheckableSlidingIndicator.c(this.a));
      }
      paramMessage = this.a;
      SimpleCheckableSlidingIndicator.c(paramMessage, paramMessage.getScrollX());
      SimpleCheckableSlidingIndicator.d(this.a).sendEmptyMessageDelayed(SimpleCheckableSlidingIndicator.e, 50L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator.2
 * JD-Core Version:    0.7.0.1
 */