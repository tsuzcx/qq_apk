package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.apollo.utils.CrossEngineResManager.LoadListener;

@ServletImpl(a=CEResManager.class)
public abstract interface ICEResManager
{
  public abstract void a(CrossEngineResManager.LoadListener paramLoadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.ICEResManager
 * JD-Core Version:    0.7.0.1
 */