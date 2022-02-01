package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ETAnimator$1
  extends Handler
{
  ETAnimator$1(ETAnimator paramETAnimator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 2) {
      return;
    }
    IETEngine localIETEngine = ETSpace.a().d();
    if (localIETEngine == null)
    {
      QLog.e("ETAnimator", 1, "ETAnimator get animation engine is null ");
      return;
    }
    ETAnimator.DecorationHolder localDecorationHolder = (ETAnimator.DecorationHolder)paramMessage.obj;
    if (localDecorationHolder != null)
    {
      TextCellLayout localTextCellLayout = (TextCellLayout)ETAnimator.a(this.a).get();
      if (localTextCellLayout == null) {
        return;
      }
      Object localObject = localTextCellLayout.r();
      if (localObject != null)
      {
        paramMessage = (Message)localObject;
        if (!((Bitmap)localObject).isRecycled()) {}
      }
      else
      {
        localObject = localTextCellLayout.s();
        paramMessage = (Message)localObject;
        if (localObject == null) {
          return;
        }
      }
      int i = paramMessage.getWidth();
      int j = paramMessage.getHeight();
      if ((ETAnimator.d() != null) && ((ETAnimator.d().getWidth() < i) || (ETAnimator.d().getHeight() < j)))
      {
        ETAnimator.d().recycle();
        ETAnimator.a(null);
      }
      localObject = ETAnimator.d();
      boolean bool = false;
      if (localObject == null) {
        ETAnimator.a(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
      } else {
        ETAnimator.d().eraseColor(0);
      }
      localObject = localDecorationHolder.c.a(localIETEngine, false);
      if (localObject != null)
      {
        ((IETDecoration)localObject).gotoFrame(localDecorationHolder.a);
        localDecorationHolder.c.a(localIETEngine, ETAnimator.d(), (IETDecoration)localObject, true);
        ((IETDecoration)localObject).deleteDescriptor(localIETEngine);
        if (localTextCellLayout != null) {
          bool = localTextCellLayout.a(localDecorationHolder, localIETEngine, ETAnimator.d(), paramMessage);
        }
        if (bool) {
          ETAnimator.b(this.a).obtainMessage(1, localDecorationHolder).sendToTarget();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.ETAnimator.1
 * JD-Core Version:    0.7.0.1
 */