package com.etrump.mixlayout;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

public class ETTextView$DecorationHolder
{
  public WeakReference<ETTextView> a;
  public long b;
  public long c = 0L;
  public int d = -1;
  public ETLayout e;
  public Bitmap f;
  
  static DecorationHolder a(ETTextView paramETTextView)
  {
    if (ETTextView.access$600(paramETTextView) == null) {
      return null;
    }
    DecorationHolder localDecorationHolder = new DecorationHolder();
    localDecorationHolder.a = new WeakReference(paramETTextView);
    localDecorationHolder.b = paramETTextView.mMsgId;
    localDecorationHolder.e = paramETTextView.mLayout;
    localDecorationHolder.d = ETTextView.access$600(paramETTextView).currentFrameIndex();
    localDecorationHolder.f = ETTextView.access$400(paramETTextView).a();
    localDecorationHolder.c = System.currentTimeMillis();
    return localDecorationHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView.DecorationHolder
 * JD-Core Version:    0.7.0.1
 */