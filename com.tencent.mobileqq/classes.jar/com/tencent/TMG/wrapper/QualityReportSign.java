package com.tencent.TMG.wrapper;

public class QualityReportSign
{
  static final String Appid = "1253923588";
  static final String Bucket = "opensdkgz";
  public static final String TAG = "QualityReportSign";
  private static QualityReportSign s_instance = null;
  String mSign = null;
  
  public static QualityReportSign getInstance()
  {
    if (s_instance == null) {}
    try
    {
      if (s_instance == null) {
        s_instance = new QualityReportSign();
      }
      return s_instance;
    }
    finally {}
  }
  
  public String getCosSign()
  {
    if (this.mSign == null) {
      getSign("opensdkgz", new QualityReportSign.2(this));
    }
    return this.mSign;
  }
  
  public void getSign(String paramString, QualityReportSign.GetSignListener paramGetSignListener)
  {
    new Thread(new QualityReportSign.1(this, paramString, paramGetSignListener)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.wrapper.QualityReportSign
 * JD-Core Version:    0.7.0.1
 */