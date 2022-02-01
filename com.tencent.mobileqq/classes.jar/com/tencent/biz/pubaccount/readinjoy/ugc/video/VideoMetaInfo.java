package com.tencent.biz.pubaccount.readinjoy.ugc.video;

public class VideoMetaInfo
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  private VideoMetaInfo(VideoMetaInfo.Builder paramBuilder)
  {
    this.jdField_a_of_type_JavaLangString = VideoMetaInfo.Builder.a(paramBuilder);
    this.jdField_b_of_type_JavaLangString = VideoMetaInfo.Builder.b(paramBuilder);
    this.c = VideoMetaInfo.Builder.c(paramBuilder);
    this.d = VideoMetaInfo.Builder.d(paramBuilder);
    this.jdField_a_of_type_Long = VideoMetaInfo.Builder.a(paramBuilder);
    this.e = VideoMetaInfo.Builder.e(paramBuilder);
    this.jdField_b_of_type_Long = VideoMetaInfo.Builder.b(paramBuilder);
  }
  
  public static VideoMetaInfo.Builder a()
  {
    return new VideoMetaInfo.Builder(null);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoMetaInfo
 * JD-Core Version:    0.7.0.1
 */