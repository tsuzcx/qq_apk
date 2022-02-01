package com.tencent.biz.publicAccountImageCollection;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import java.net.URL;

public abstract interface PublicAccountImageDownListener
{
  public abstract void a(URL paramURL, int paramInt);
  
  public abstract void a(URL paramURL, CloseableBitmap paramCloseableBitmap);
  
  public abstract void a(URL paramURL, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener
 * JD-Core Version:    0.7.0.1
 */