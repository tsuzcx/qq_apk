package com.tencent.mobileqq.Doraemon;

import org.json.JSONObject;

public abstract class DoraemonAPIModule
{
  protected DoraemonAPIManager a;
  
  protected void a() {}
  
  public final void a(DoraemonAPIManager paramDoraemonAPIManager)
  {
    this.a = paramDoraemonAPIManager;
    a();
  }
  
  public abstract boolean a(int paramInt, String paramString, JSONObject paramJSONObject, APICallback paramAPICallback);
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIModule
 * JD-Core Version:    0.7.0.1
 */