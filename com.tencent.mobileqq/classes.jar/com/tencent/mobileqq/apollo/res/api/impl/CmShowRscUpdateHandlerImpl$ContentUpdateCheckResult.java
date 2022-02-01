package com.tencent.mobileqq.apollo.res.api.impl;

import android.text.TextUtils;
import java.io.File;

public class CmShowRscUpdateHandlerImpl$ContentUpdateCheckResult
{
  public int a;
  public long b;
  public String c;
  public int d;
  public int e;
  public String f;
  public boolean g;
  public byte[] h;
  public long i;
  public String j;
  public String k;
  public String l;
  public String m;
  public boolean n;
  public int o;
  public int p;
  public int q;
  
  public static String a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    if (paramString1.endsWith("/"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramLong);
      localStringBuilder.append("/");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static boolean a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (100 == paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/rsc_jsonConfig/");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString2);
      return new File(localStringBuilder.toString()).exists();
    }
    return false;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    if (100 == this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/rsc_jsonConfig/");
      localStringBuilder.append(a());
      localStringBuilder.append(File.separator);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String c()
  {
    if (100 == this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b());
      localStringBuilder.append(this.d);
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String d()
  {
    if (100 == this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b());
      localStringBuilder.append(this.d);
      localStringBuilder.append("_patch.zip");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String e()
  {
    if (100 == this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b());
      localStringBuilder.append(this.e);
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ContentUpdateCheckResult{");
    localStringBuffer.append("mBuzId=");
    localStringBuffer.append(this.a);
    localStringBuffer.append(", mItemId=");
    localStringBuffer.append(this.b);
    localStringBuffer.append(", mName='");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mVersion=");
    localStringBuffer.append(this.d);
    localStringBuffer.append(", mOldVersion=");
    localStringBuffer.append(this.e);
    localStringBuffer.append(", mDownloadFileUrl='");
    localStringBuffer.append(this.f);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mIsPatch=");
    localStringBuffer.append(this.g);
    localStringBuffer.append(", mPatchData=");
    if (this.h == null)
    {
      localStringBuffer.append("null");
    }
    else
    {
      localStringBuffer.append("mPatchData:");
      localStringBuffer.append(this.h);
    }
    localStringBuffer.append(", mPatchSize=");
    localStringBuffer.append(this.i);
    localStringBuffer.append(", mDownloadPatchFileUrl='");
    localStringBuffer.append(this.j);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mMd5='");
    localStringBuffer.append(this.k);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mDownloadFileName='");
    localStringBuffer.append(this.l);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mDownloadPatchFileName='");
    localStringBuffer.append(this.m);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mFlagWriteIntervalTs=");
    localStringBuffer.append(this.n);
    localStringBuffer.append(", mCheckServerInterval=");
    localStringBuffer.append(this.o);
    localStringBuffer.append(", mCheckRequestId=");
    localStringBuffer.append(this.p);
    localStringBuffer.append(", mDomainId=");
    localStringBuffer.append(this.q);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult
 * JD-Core Version:    0.7.0.1
 */