package com.tencent.av.wtogether.util;

public class WatchTogetherDataReportHelper$WTFilePlayInfo
{
  public int a;
  public String a;
  public int b;
  
  public WatchTogetherDataReportHelper$WTFilePlayInfo(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WTFilePlayInfo{mVideoKey: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mVideoDurationMs: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mVideoPlayTimeMs: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WatchTogetherDataReportHelper.WTFilePlayInfo
 * JD-Core Version:    0.7.0.1
 */