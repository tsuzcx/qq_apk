package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;

public class HWEditLocalVideoPlayer$Mp4VideoFragmentInfo
  extends VideoFragmentInfo
{
  private long a;
  public String a;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap = null;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  
  public HWEditLocalVideoPlayer$Mp4VideoFragmentInfo(int paramInt, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public Mp4VideoFragmentInfo a(Bitmap paramBitmap)
  {
    paramBitmap = new Mp4VideoFragmentInfo(this.jdField_a_of_type_Int, paramBitmap);
    paramBitmap.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_c_of_type_AndroidGraphicsBitmap;
    paramBitmap.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    paramBitmap.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    paramBitmap.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    paramBitmap.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
    paramBitmap.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    paramBitmap.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramBitmap.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_Boolean = false;
    return paramBitmap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Mp4VideoFragmentInfo{index=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", bitmap=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", mRevertFailed=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.Mp4VideoFragmentInfo
 * JD-Core Version:    0.7.0.1
 */