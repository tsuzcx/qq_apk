package com.tencent.apkupdate.logic.protocol.jce;

import java.io.Serializable;

public final class JceCmd
  implements Serializable
{
  public static final JceCmd Empty;
  public static final JceCmd GetAppUpdate = new JceCmd(3, 3, "GetAppUpdate");
  public static final JceCmd GetSettings;
  public static final JceCmd ReportApkFileInfo = new JceCmd(4, 4, "ReportApkFileInfo");
  public static final JceCmd ReportLog;
  public static final int _Empty = 0;
  public static final int _GetAppUpdate = 3;
  public static final int _GetSettings = 2;
  public static final int _ReportApkFileInfo = 4;
  public static final int _ReportLog = 1;
  private static JceCmd[] __values = new JceCmd[5];
  private String __T = new String();
  private int __value;
  
  static
  {
    Empty = new JceCmd(0, 0, "Empty");
    ReportLog = new JceCmd(1, 1, "ReportLog");
    GetSettings = new JceCmd(2, 2, "GetSettings");
  }
  
  private JceCmd(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static JceCmd convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      JceCmd[] arrayOfJceCmd = __values;
      if (i >= arrayOfJceCmd.length) {
        break;
      }
      if (arrayOfJceCmd[i].toString().equals(paramString)) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public final String toString()
  {
    return this.__T;
  }
  
  public final int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.JceCmd
 * JD-Core Version:    0.7.0.1
 */