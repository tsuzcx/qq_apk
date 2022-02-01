package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.database.ReportWatchVideoEntry;

public class ReportWatchVideoManager$InnerVideoItem
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  
  public ReportWatchVideoManager$InnerVideoItem() {}
  
  public ReportWatchVideoManager$InnerVideoItem(String paramString1, String paramString2, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public ReportWatchVideoEntry a()
  {
    ReportWatchVideoEntry localReportWatchVideoEntry = new ReportWatchVideoEntry();
    localReportWatchVideoEntry.vid = this.jdField_a_of_type_JavaLangString;
    localReportWatchVideoEntry.videoUnionId = this.jdField_b_of_type_JavaLangString;
    localReportWatchVideoEntry.isLiveVideo = this.jdField_a_of_type_Boolean;
    localReportWatchVideoEntry.createTime = this.jdField_a_of_type_Long;
    localReportWatchVideoEntry.source = this.jdField_a_of_type_Int;
    localReportWatchVideoEntry.vidType = this.jdField_b_of_type_Int;
    return localReportWatchVideoEntry;
  }
  
  public void a(ReportWatchVideoEntry paramReportWatchVideoEntry)
  {
    this.jdField_a_of_type_JavaLangString = paramReportWatchVideoEntry.vid;
    this.jdField_b_of_type_JavaLangString = paramReportWatchVideoEntry.videoUnionId;
    this.jdField_a_of_type_Boolean = paramReportWatchVideoEntry.isLiveVideo;
    this.jdField_a_of_type_Long = paramReportWatchVideoEntry.createTime;
    this.jdField_a_of_type_Int = paramReportWatchVideoEntry.source;
    this.jdField_b_of_type_Int = paramReportWatchVideoEntry.vidType;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (InnerVideoItem)paramObject;
    return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
  }
  
  public String toString()
  {
    return "InnerVideoItem { mVid=" + this.jdField_a_of_type_JavaLangString + " mVideoUid=" + this.jdField_b_of_type_JavaLangString + " mIsLiveVideo=" + this.jdField_a_of_type_Boolean + " mCreateTime=" + this.jdField_a_of_type_Long + " mSource=" + this.jdField_a_of_type_Int + " mVidType=" + this.jdField_b_of_type_Int + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.ReportWatchVideoManager.InnerVideoItem
 * JD-Core Version:    0.7.0.1
 */