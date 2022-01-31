package com.tencent.mobileqq.Doraemon;

import android.support.annotation.NonNull;

public abstract class DoraemonAPIModule
{
  public DoraemonAPIManager a;
  
  public void a() {}
  
  public void a(DoraemonAPIManager paramDoraemonAPIManager)
  {
    this.a = paramDoraemonAPIManager;
  }
  
  public abstract boolean a(int paramInt, String paramString, APIParam paramAPIParam, @NonNull APICallback paramAPICallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIModule
 * JD-Core Version:    0.7.0.1
 */