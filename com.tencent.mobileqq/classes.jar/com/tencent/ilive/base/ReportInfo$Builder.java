package com.tencent.ilive.base;

public class ReportInfo$Builder
{
  private ReportInfo mReportInfo = null;
  
  public static Builder newBuilder()
  {
    Builder localBuilder = new Builder();
    localBuilder.mReportInfo = new ReportInfo(null);
    return localBuilder;
  }
  
  public String getFromId()
  {
    return ReportInfo.access$000(this.mReportInfo);
  }
  
  public String getSource()
  {
    return ReportInfo.access$100(this.mReportInfo);
  }
  
  public Builder setFromId(String paramString)
  {
    ReportInfo.access$002(this.mReportInfo, paramString);
    return this;
  }
  
  public Builder setSource(String paramString)
  {
    ReportInfo.access$102(this.mReportInfo, paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.ReportInfo.Builder
 * JD-Core Version:    0.7.0.1
 */