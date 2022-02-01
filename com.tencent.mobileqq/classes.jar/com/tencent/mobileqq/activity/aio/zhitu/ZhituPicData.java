package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

public class ZhituPicData
{
  public int a;
  @Nullable
  public Drawable a;
  public ZhituReportData a;
  @Nullable
  public ZhituTextManager.DrawTextParam a;
  public String a;
  public boolean a;
  @Nullable
  public Drawable b;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public String f;
  public String g;
  
  public void a(ZhituPicData paramZhituPicData)
  {
    this.jdField_a_of_type_JavaLangString = paramZhituPicData.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramZhituPicData.jdField_b_of_type_JavaLangString;
    this.c = paramZhituPicData.c;
    this.jdField_e_of_type_JavaLangString = paramZhituPicData.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramZhituPicData.jdField_a_of_type_Int;
    this.jdField_d_of_type_JavaLangString = paramZhituPicData.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_b_of_type_Boolean = paramZhituPicData.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData = paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam = paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam;
    this.jdField_a_of_type_Boolean = paramZhituPicData.jdField_a_of_type_Boolean;
    this.jdField_d_of_type_Boolean = paramZhituPicData.jdField_d_of_type_Boolean;
    this.jdField_e_of_type_Boolean = paramZhituPicData.jdField_e_of_type_Boolean;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramZhituPicData.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZhituPicData{url='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", originPath='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", drawTextParam=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam);
    localStringBuilder.append(", inCache=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", reqKey='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", idxInRes=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", pic_md5='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", drawable=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localStringBuilder.append(", originDrawable=");
    localStringBuilder.append(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    localStringBuilder.append(", isGif=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", reportData=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData
 * JD-Core Version:    0.7.0.1
 */