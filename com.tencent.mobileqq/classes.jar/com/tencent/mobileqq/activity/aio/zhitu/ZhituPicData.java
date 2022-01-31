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
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public void a(ZhituPicData paramZhituPicData)
  {
    this.jdField_a_of_type_JavaLangString = paramZhituPicData.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramZhituPicData.jdField_b_of_type_JavaLangString;
    this.c = paramZhituPicData.c;
    this.e = paramZhituPicData.e;
    this.jdField_a_of_type_Int = paramZhituPicData.jdField_a_of_type_Int;
    this.d = paramZhituPicData.d;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_b_of_type_Boolean = paramZhituPicData.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData = paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam = paramZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam;
    this.jdField_a_of_type_Boolean = paramZhituPicData.jdField_a_of_type_Boolean;
  }
  
  public String toString()
  {
    return "ZhituPicData{url='" + this.jdField_a_of_type_JavaLangString + '\'' + ", path='" + this.jdField_b_of_type_JavaLangString + '\'' + ", originPath='" + this.c + '\'' + ", drawTextParam=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam + ", inCache=" + this.jdField_a_of_type_Boolean + ", reqKey='" + this.d + '\'' + ", idxInRes=" + this.jdField_a_of_type_Int + ", pic_md5='" + this.e + '\'' + ", drawable=" + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable + ", isGif=" + this.jdField_b_of_type_Boolean + ", reportData=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData
 * JD-Core Version:    0.7.0.1
 */