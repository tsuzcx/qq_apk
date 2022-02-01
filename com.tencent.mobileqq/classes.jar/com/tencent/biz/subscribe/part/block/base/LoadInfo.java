package com.tencent.biz.subscribe.part.block.base;

import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.SharePreferenceUtils;

public class LoadInfo
{
  private volatile boolean a = true;
  private volatile int b = 4;
  private String c = null;
  private String d = null;
  private COMM.StCommonExt e;
  private String f;
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(COMM.StCommonExt paramStCommonExt)
  {
    this.e = paramStCommonExt;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      SharePreferenceUtils.a(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache", paramString);
    }
    this.f = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    if (paramString != null) {
      SharePreferenceUtils.a(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache", paramString);
    }
    this.d = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      this.a = true;
      return;
    }
    this.a = false;
  }
  
  public boolean b()
  {
    return this.b != 4;
  }
  
  public boolean c()
  {
    return this.b == 1;
  }
  
  public boolean d()
  {
    return this.b == 2;
  }
  
  public boolean e()
  {
    return this.b == 3;
  }
  
  public COMM.StCommonExt f()
  {
    return this.e;
  }
  
  public COMM.StCommonExt g()
  {
    return this.e;
  }
  
  public String h()
  {
    if (this.f == null) {
      this.f = SharePreferenceUtils.a(BaseApplicationImpl.getContext(), "subscribe_ad_attachinfo_cache");
    }
    return this.f;
  }
  
  public String i()
  {
    if (this.d == null) {
      this.d = SharePreferenceUtils.a(BaseApplicationImpl.getContext(), "subscribe_ad_livePageInfo_cache");
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.LoadInfo
 * JD-Core Version:    0.7.0.1
 */