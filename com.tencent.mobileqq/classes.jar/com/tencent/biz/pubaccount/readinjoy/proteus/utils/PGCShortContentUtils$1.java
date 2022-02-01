package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import java.net.URL;

final class PGCShortContentUtils$1
  implements PublicAccountImageDownListener
{
  PGCShortContentUtils$1(Runnable paramRunnable) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, CloseableBitmap paramCloseableBitmap)
  {
    if (this.a != null) {
      this.a.run();
    }
  }
  
  public void a(URL paramURL, Throwable paramThrowable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.PGCShortContentUtils.1
 * JD-Core Version:    0.7.0.1
 */