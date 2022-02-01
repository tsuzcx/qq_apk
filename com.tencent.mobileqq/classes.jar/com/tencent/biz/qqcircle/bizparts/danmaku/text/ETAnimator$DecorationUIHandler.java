package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETFont;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ETAnimator$DecorationUIHandler
  extends Handler
{
  WeakReference<TextCellLayout> a;
  
  ETAnimator$DecorationUIHandler(TextCellLayout paramTextCellLayout, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramTextCellLayout);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TextCellLayout localTextCellLayout = (TextCellLayout)this.a.get();
    if (localTextCellLayout == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      paramMessage = (ETAnimator.DecorationHolder)paramMessage.obj;
      boolean bool2 = false;
      if ((paramMessage != null) && (localTextCellLayout.j().equals(paramMessage.d.toString())) && (localTextCellLayout.m != null) && (localTextCellLayout.m.currentFrameIndex() == paramMessage.a) && ((localTextCellLayout.q() instanceof ETPaint)) && (((ETPaint)localTextCellLayout.q()).c() != null) && (((ETPaint)localTextCellLayout.q()).c().getId() == paramMessage.c.a().getId()) && (((ETPaint)localTextCellLayout.q()).c().getSize() == paramMessage.c.a().getSize()))
      {
        boolean bool1;
        if ((localTextCellLayout.i) && (!localTextCellLayout.b())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (bool1)
        {
          localTextCellLayout.o();
          IETDecoration localIETDecoration = localTextCellLayout.m;
          if (localIETDecoration.nextFrame())
          {
            int j = localIETDecoration.getFrameDelay();
            int k = (int)(System.currentTimeMillis() - ETAnimator.DecorationHolder.a(paramMessage));
            i = j;
            if (k > 0)
            {
              i = j;
              if (k * 2 < j) {
                i = j - k;
              }
            }
            if (i <= 1) {
              sendEmptyMessage(0);
            } else {
              sendEmptyMessageDelayed(0, i);
            }
            bool1 = true;
          }
          else
          {
            localTextCellLayout.j = true;
            localTextCellLayout.a(200L);
            bool1 = bool2;
          }
        }
        localTextCellLayout.i = bool1;
        return;
      }
      QLog.e("ETAnimator", 1, "this textView reused!");
      localTextCellLayout.i = false;
      return;
    }
    paramMessage = ETAnimator.DecorationHolder.a(localTextCellLayout);
    if (paramMessage != null) {
      localTextCellLayout.l.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.ETAnimator.DecorationUIHandler
 * JD-Core Version:    0.7.0.1
 */