package com.tencent.biz.pubaccount.readinjoy.common;

import java.io.Serializable;

public class ReadInJoyDoingSomething$AppConfigInfo
  implements Serializable
{
  public String appCode;
  public String appName;
  public String appPackageName;
  public String appPath;
  public boolean isAbsolutePath;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("appName = ").append(this.appName).append("\nappCode = ").append(this.appCode).append("\nappPackageName = ").append(this.appPackageName).append("\nappPath = ").append(this.appPath).append("\nisAbsolutePath = ");
    if (this.isAbsolutePath) {}
    for (String str = "1";; str = "0") {
      return str + "\n";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDoingSomething.AppConfigInfo
 * JD-Core Version:    0.7.0.1
 */