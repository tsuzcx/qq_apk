package com.tencent.biz.pubaccount.imagecollection.api;

import java.net.URL;

public abstract interface IPublicAccountImageDownListener
{
  public abstract void a(URL paramURL, int paramInt);
  
  public abstract void a(URL paramURL, Object paramObject);
  
  public abstract void a(URL paramURL, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener
 * JD-Core Version:    0.7.0.1
 */