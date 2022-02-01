package com.tencent.mobileqq.auto.engine.loader.net;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="mBusinessKey,mVersion")
public class ASDataBaseInfo
  extends Entity
  implements Serializable, Cloneable
{
  public String mBusinessKey;
  public String mCookie;
  public boolean mIsInvalid;
  public boolean mIsReady;
  public long mManagerFileLength;
  public String mManagerFileUrl;
  public String mPluginManagerPath;
  public String mPluginZipPath;
  public String mQua;
  public long mUin;
  public int mVersion;
  public long mZipFileLength;
  public String mZipFileUrl;
  
  public String getBusinessKey()
  {
    return this.mBusinessKey;
  }
  
  public String getCookie()
  {
    return this.mCookie;
  }
  
  public long getManagerFileLength()
  {
    return this.mManagerFileLength;
  }
  
  public String getManagerFileUrl()
  {
    return this.mManagerFileUrl;
  }
  
  public String getPluginManagerPath()
  {
    return this.mPluginManagerPath;
  }
  
  public String getPluginZipPath()
  {
    return this.mPluginZipPath;
  }
  
  public String getQua()
  {
    return this.mQua;
  }
  
  public long getUin()
  {
    return this.mUin;
  }
  
  public int getVersion()
  {
    return this.mVersion;
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
  
  public void setBusinessKey(String paramString)
  {
    this.mBusinessKey = paramString;
  }
  
  public void setCookie(String paramString)
  {
    this.mCookie = paramString;
  }
  
  public void setIsInvalid(boolean paramBoolean)
  {
    this.mIsInvalid = paramBoolean;
  }
  
  public void setIsReady(boolean paramBoolean)
  {
    this.mIsReady = paramBoolean;
  }
  
  public void setManagerFileLength(long paramLong)
  {
    this.mManagerFileLength = paramLong;
  }
  
  public void setManagerFileUrl(String paramString)
  {
    this.mManagerFileUrl = paramString;
  }
  
  public void setPluginManagerPath(String paramString)
  {
    this.mPluginManagerPath = paramString;
  }
  
  public void setPluginZipPath(String paramString)
  {
    this.mPluginZipPath = paramString;
  }
  
  public void setQua(String paramString)
  {
    this.mQua = paramString;
  }
  
  public void setUin(long paramLong)
  {
    this.mUin = paramLong;
  }
  
  public void setVersion(int paramInt)
  {
    this.mVersion = paramInt;
  }
  
  public void setZipFileLength(long paramLong)
  {
    this.mZipFileLength = paramLong;
  }
  
  public void setZipFileUrl(String paramString)
  {
    this.mZipFileUrl = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ASDataBaseInfo{");
    localStringBuffer.append("mVersion=");
    localStringBuffer.append(this.mVersion);
    localStringBuffer.append(", mQua='");
    localStringBuffer.append(this.mQua);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mBusinessKey='");
    localStringBuffer.append(this.mBusinessKey);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mPluginZipPath='");
    localStringBuffer.append(this.mPluginZipPath);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mPluginManagerPath='");
    localStringBuffer.append(this.mPluginManagerPath);
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
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.net.ASDataBaseInfo
 * JD-Core Version:    0.7.0.1
 */