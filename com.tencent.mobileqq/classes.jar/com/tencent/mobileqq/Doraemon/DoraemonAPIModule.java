package com.tencent.mobileqq.Doraemon;

import android.support.annotation.NonNull;
import org.json.JSONObject;

public abstract class DoraemonAPIModule
{
  public DoraemonAPIManager a;
  
  protected void a() {}
  
  public final void a(DoraemonAPIManager paramDoraemonAPIManager)
  {
    this.a = paramDoraemonAPIManager;
    a();
  }
  
  public abstract boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback);
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIModule
 * JD-Core Version:    0.7.0.1
 */