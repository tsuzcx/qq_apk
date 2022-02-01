package com.etrump.mixlayout;

import android.os.Handler;
import android.os.Message;
import com.etrump.mixlayout.api.ETFontUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ETTextView$UpdateUIHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    ETTextView.DecorationHolder localDecorationHolder = (ETTextView.DecorationHolder)paramMessage.obj;
    if (localDecorationHolder == null) {
      return;
    }
    ETTextView localETTextView = (ETTextView)localDecorationHolder.a.get();
    if (localETTextView != null)
    {
      if (ETTextView.access$600(localETTextView) == null) {
        return;
      }
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i != 1) {
          return;
        }
        if (localETTextView.isViewVisible())
        {
          if ((ETTextView.access$400(localETTextView).a() == localDecorationHolder.f) && (localETTextView.mMsgId == localDecorationHolder.b) && (ETTextView.access$600(localETTextView) != null) && (ETTextView.access$600(localETTextView).currentFrameIndex() == localDecorationHolder.d) && (localETTextView.mFont != null) && (localETTextView.mFont.equals(localDecorationHolder.e.c)))
          {
            boolean bool1;
            if ((ETTextView.access$700(localETTextView)) && (ETTextView.access$800(localETTextView)) && (ETFontUtil.enableAnimation) && (!ETTextView.access$900(localETTextView))) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            boolean bool2 = bool1;
            if (bool1)
            {
              localETTextView.postInvalidate();
              paramMessage = ETTextView.access$600(localETTextView);
              if (paramMessage.nextFrame())
              {
                int j = paramMessage.getFrameDelay();
                int k = (int)(System.currentTimeMillis() - localDecorationHolder.c);
                i = j;
                if (k > 0) {
                  i = j - k;
                }
                paramMessage = obtainMessage(0, ETTextView.DecorationHolder.a(localETTextView));
                if (i <= 1) {
                  sendMessage(paramMessage);
                } else {
                  sendMessageDelayed(paramMessage, i);
                }
                bool2 = true;
              }
              else
              {
                localETTextView.shouldStartAnimation = false;
                localETTextView.postInvalidateDelayed(100L);
                if ((localETTextView.mAnimationListener != null) && (localETTextView.mFont != null)) {
                  localETTextView.mAnimationListener.a(localETTextView.mMessage, localETTextView.mFont.mFontId);
                }
                bool2 = false;
              }
            }
            ETTextView.access$702(localETTextView, bool2);
            return;
          }
          QLog.e("ETTextView", 2, "this textView reused!");
        }
      }
      else if ((localETTextView.isViewVisible()) && (ETTextView.mCreateDecorationHandler != null))
      {
        ETTextView.mCreateDecorationHandler.obtainMessage(2, ETTextView.DecorationHolder.a(localETTextView)).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView.UpdateUIHandler
 * JD-Core Version:    0.7.0.1
 */