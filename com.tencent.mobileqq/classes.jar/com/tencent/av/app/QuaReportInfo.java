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
    for (;;)
    {
      try
      {
        paramString = paramString.split("_");
        if (paramString[0].equals("null"))
        {
          this.selfUin = null;
          if (paramString[1].equals("null"))
          {
            this.peerUin = null;
            this.busytype = Integer.valueOf(paramString[2]).intValue();
            this.uintype = Integer.valueOf(paramString[3]).intValue();
            return this;
          }
        }
        else
        {
          this.selfUin = paramString[0];
          continue;
        }
        this.peerUin = paramString[1];
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QuaReportInfo", 2, "deserialization failed! exception = " + paramString);
        }
        return null;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.selfUin != null)
    {
      str = this.selfUin;
      localStringBuilder = localStringBuilder.append(str).append("_");
      if (this.peerUin == null) {
        break label82;
      }
    }
    label82:
    for (String str = this.peerUin;; str = "null")
    {
      return str + "_" + this.busytype + "_" + this.uintype;
      str = "null";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.QuaReportInfo
 * JD-Core Version:    0.7.0.1
 */