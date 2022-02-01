package com.tencent.mobileqq.auto.engine.loader;

import java.io.Serializable;

public class ASPluginBean
  implements Serializable
{
  public static final String TYPE_DEBUG = "TYPE_DEBUG";
  public static final String TYPE_NATIVE = "TYPE_NATIVE";
  public static final String TYPE_NET = "TYPE_NET";
  public static final long serialVersionUID = -2250766705698539904L;
  private String mBusinessKey;
  private String mConfigJsonPath;
  private String mCookie;
  private int mCrashCount;
  private boolean mIsInvalid;
  private boolean mIsReady;
  private long mManagerFileLength;
  private String mManagerFileUrl;
  private String mPluginMangerApkPath;
  private String mPluginZipPath;
  private String mQua;
  private int mSupportMinHostVersion;
  private int mSupportMinPluginVersion;
  private String mType;
  private String mUUid;
  private long mUin;
  private String mUnzipPath;
  private int mVersionCode;
  private long mZipFileLength;
  private String mZipFileUrl;
  
  public String getBusinessKey()
  {
    return this.mBusinessKey;
  }
  
  public String getConfigJsonPath()
  {
    return this.mConfigJsonPath;
  }
  
  public String getCookie()
  {
    return this.mCookie;
  }
  
  public int getCrashCount()
  {
    return this.mCrashCount;
  }
  
  public long getManagerFileLength()
  {
    return this.mManagerFileLength;
  }
  
  public String getManagerFileUrl()
  {
    return this.mManagerFileUrl;
  }
  
  public String getPluginMangerApkPath()
  {
    return this.mPluginMangerApkPath;
  }
  
  public String getPluginZipPath()
  {
    return this.mPluginZipPath;
  }
  
  public String getQua()
  {
    return this.mQua;
  }
  
  public int getSupportMinHostVersion()
  {
    return this.mSupportMinHostVersion;
  }
  
  public int getSupportMinPluginVersion()
  {
    return this.mSupportMinPluginVersion;
  }
  
  public String getType()
  {
    return this.mType;
  }
  
  public String getUUid()
  {
    return this.mUUid;
  }
  
  public long getUin()
  {
    return this.mUin;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public long getZipFileLength()
  {
    return this.mZipFileLength;
  }
  
  public String getZipFileUrl()
  {
    return this.mZipFileUrl;
  }
  
  public boolean isInvalid()
  {
    return this.mIsInvalid;
  }
  
  public boolean isReady()
  {
    return this.mIsReady;
  }
  
  public ASPluginBean setBusinessKey(String paramString)
  {
    this.mBusinessKey = paramString;
    return this;
  }
  
  public ASPluginBean setConfigJsonPath(String paramString)
  {
    this.mConfigJsonPath = paramString;
    return this;
  }
  
  public ASPluginBean setCookie(String paramString)
  {
    this.mCookie = paramString;
    return this;
  }
  
  public ASPluginBean setCrashCount(int paramInt)
  {
    this.mCrashCount = paramInt;
    return this;
  }
  
  public ASPluginBean setInvalid(boolean paramBoolean)
  {
    this.mIsInvalid = paramBoolean;
    return this;
  }
  
  public ASPluginBean setManagerFileLength(long paramLong)
  {
    this.mManagerFileLength = paramLong;
    return this;
  }
  
  public ASPluginBean setManagerFileUrl(String paramString)
  {
    this.mManagerFileUrl = paramString;
    return this;
  }
  
  public ASPluginBean setPluginMangerApkPath(String paramString)
  {
    this.mPluginMangerApkPath = paramString;
    return this;
  }
  
  public ASPluginBean setPluginZipPath(String paramString)
  {
    this.mPluginZipPath = paramString;
    return this;
  }
  
  public ASPluginBean setQua(String paramString)
  {
    this.mQua = paramString;
    return this;
  }
  
  public ASPluginBean setReady(boolean paramBoolean)
  {
    this.mIsReady = paramBoolean;
    return this;
  }
  
  public ASPluginBean setSupportMinHostVersion(int paramInt)
  {
    this.mSupportMinHostVersion = paramInt;
    return this;
  }
  
  public void setSupportMinPluginVersion(int paramInt)
  {
    this.mSupportMinPluginVersion = paramInt;
  }
  
  public ASPluginBean setType(String paramString)
  {
    this.mType = paramString;
    return this;
  }
  
  public ASPluginBean setUUid(String paramString)
  {
    this.mUUid = paramString;
    return this;
  }
  
  public ASPluginBean setUin(long paramLong)
  {
    this.mUin = paramLong;
    return this;
  }
  
  public ASPluginBean setUnZipPath(String paramString)
  {
    this.mUnzipPath = paramString;
    return this;
  }
  
  public ASPluginBean setVersionCode(int paramInt)
  {
    this.mVersionCode = paramInt;
    return this;
  }
  
  public ASPluginBean setZipFileLength(long paramLong)
  {
    this.mZipFileLength = paramLong;
    return this;
  }
  
  public ASPluginBean setZipFileUrl(String paramString)
  {
    this.mZipFileUrl = paramString;
    return this;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ASPluginBean{");
    localStringBuffer.append("mBusinessKey='");
    localStringBuffer.append(this.mBusinessKey);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mVersionCode=");
    localStringBuffer.append(this.mVersionCode);
    localStringBuffer.append(", mPluginZipPath='");
    localStringBuffer.append(this.mPluginZipPath);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mPluginMangerApkPath='");
    localStringBuffer.append(this.mPluginMangerApkPath);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mConfigJsonPath='");
    localStringBuffer.append(this.mConfigJsonPath);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mType='");
    localStringBuffer.append(this.mType);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mCrashCount=");
    localStringBuffer.append(this.mCrashCount);
    localStringBuffer.append(", mSupportMinHostVersion=");
    localStringBuffer.append(this.mSupportMinHostVersion);
    localStringBuffer.append(", mSupportMinPluginVersion=");
    localStringBuffer.append(this.mSupportMinPluginVersion);
    localStringBuffer.append(", mQua='");
    localStringBuffer.append(this.mQua);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mCookie='");
    localStringBuffer.append(this.mCookie);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mIsInvalid=");
    localStringBuffer.append(this.mIsInvalid);
    localStringBuffer.append(", mZipFileUrl='");
    localStringBuffer.append(this.mZipFileUrl);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mManagerFileUrl='");
    localStringBuffer.append(this.mManagerFileUrl);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mZipFileLength=");
    localStringBuffer.append(this.mZipFileLength);
    localStringBuffer.append(", mManagerFileLength=");
    localStringBuffer.append(this.mManagerFileLength);
    localStringBuffer.append(", mIsReady=");
    localStringBuffer.append(this.mIsReady);
    localStringBuffer.append(", mUin=");
    localStringBuffer.append(this.mUin);
    localStringBuffer.append(", mUnzipPath='");
    localStringBuffer.append(this.mUnzipPath);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.ASPluginBean
 * JD-Core Version:    0.7.0.1
 */