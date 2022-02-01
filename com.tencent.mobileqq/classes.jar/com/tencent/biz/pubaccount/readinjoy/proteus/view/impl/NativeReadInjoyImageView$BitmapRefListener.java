package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class NativeReadInjoyImageView$BitmapRefListener
  implements PublicAccountImageDownListener
{
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, CloseableBitmap paramCloseableBitmap)
  {
    QLog.d("NativeReadInjoyImageView", 2, "setImageDrawable: url is " + paramURL);
    paramCloseableBitmap.a();
  }
  
  public void a(URL paramURL, Throwable paramThrowable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView.BitmapRefListener
 * JD-Core Version:    0.7.0.1
 */