package com.tencent.gamecenter.wadl.api;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface IWadlService
  extends IInterface
{
  public abstract void a(IWadlServiceCallBack paramIWadlServiceCallBack);
  
  public abstract void a(String paramString, Bundle paramBundle);
  
  public abstract void b(IWadlServiceCallBack paramIWadlServiceCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IWadlService
 * JD-Core Version:    0.7.0.1
 */