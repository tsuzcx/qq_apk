package com.tencent.biz.qqstory.takevideo.slideshow.core;

import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;

public class SlideShowProcessor$ConvertContext
  extends SlideShowProcessor.TaskContext
{
  public int a;
  public long a;
  public SlideItemInfo a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  private boolean e;
  
  public SlideShowProcessor$ConvertContext()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
  }
  
  public SlideShowProcessor$ConvertContext(long paramLong1, SlideItemInfo paramSlideItemInfo, int paramInt1, int paramInt2, long paramLong2, SlideShowProcessor.SlideShowProcessListener paramSlideShowProcessListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo = paramSlideItemInfo;
    this.jdField_a_of_type_JavaLangString = paramSlideItemInfo.b;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$SlideShowProcessListener = paramSlideShowProcessListener;
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.ConvertContext
 * JD-Core Version:    0.7.0.1
 */