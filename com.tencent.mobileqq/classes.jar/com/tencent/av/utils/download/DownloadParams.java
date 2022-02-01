package com.tencent.av.utils.download;

import java.util.HashMap;

public class DownloadParams
{
  public String a;
  public HashMap<String, String> b;
  public int c = 3;
  public int d = 5000;
  public int e = 60000;
  public DownloadResult f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUrl = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",mConnectionTimeout = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",mSocketTimeout = ");
    localStringBuilder.append(this.e);
    if (this.f != null)
    {
      localStringBuilder.append(",mResult.mIsSucc = ");
      localStringBuilder.append(this.f.f);
      localStringBuilder.append(",mResult.mFileLength = ");
      localStringBuilder.append(this.f.b);
      localStringBuilder.append(",mResult.mErrCode = ");
      localStringBuilder.append(this.f.d);
      localStringBuilder.append(",mResult.mErrStr = ");
      localStringBuilder.append(this.f.e);
      localStringBuilder.append(",mResult.mTryCount = ");
      localStringBuilder.append(this.f.g);
      localStringBuilder.append(",mResult.mCostTime = ");
      localStringBuilder.append(this.f.c);
      localStringBuilder.append("ms");
    }
    else
    {
      localStringBuilder.append(",mResult = null");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.download.DownloadParams
 * JD-Core Version:    0.7.0.1
 */