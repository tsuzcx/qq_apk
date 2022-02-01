package com.tencent.ilive.uicomponent;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface UIBaseAdapter
{
  public abstract HttpInterface getHttp();
  
  public abstract ImageLoaderInterface getImageLoader();
  
  public abstract LogInterface getLog();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.UIBaseAdapter
 * JD-Core Version:    0.7.0.1
 */