package com.tencent.av.app;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class QuaReportInfo
  implements Serializable
{
  public int busytype;
  public String peerUin;
  public String selfUin;
  public int uintype;
  
  public QuaReportInfo toObject(String paramString)
  {
    try
    {
      paramString = paramString.split("_");
      if (paramString[0].equals("null")) {
        this.selfUin = null;
      } else {
        this.selfUin = paramString[0];
      }
      if (paramString[1].equals("null")) {
        this.peerUin = null;
      } else {
        this.peerUin = paramString[1];
      }
      this.busytype = Integer.valueOf(paramString[2]).intValue();
      this.uintype = Integer.valueOf(paramString[3]).intValue();
      return this;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deserialization failed! exception = ");
        localStringBuilder.append(paramString);
        QLog.e("QuaReportInfo", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.selfUin;
    String str1 = "null";
    if (localObject == null) {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    String str2 = this.peerUin;
    localObject = str1;
    if (str2 != null) {
      localObject = str2;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(this.busytype);
    localStringBuilder.append("_");
    localStringBuilder.append(this.uintype);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.QuaReportInfo
 * JD-Core Version:    0.7.0.1
 */