package com.tencent.av.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;

class QAVNotification$NotifyData
{
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  
  private QAVNotification$NotifyData(QAVNotification paramQAVNotification)
  {
    a(null);
  }
  
  QAVNotification$NotifyData(QAVNotification paramQAVNotification, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.d = paramString4;
  }
  
  private void a(NotifyData paramNotifyData)
  {
    if (paramNotifyData != null)
    {
      this.jdField_a_of_type_JavaLangString = paramNotifyData.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Int = paramNotifyData.jdField_a_of_type_Int;
      this.jdField_c_of_type_JavaLangString = paramNotifyData.jdField_c_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramNotifyData.jdField_b_of_type_JavaLangString;
      this.d = paramNotifyData.d;
      this.jdField_b_of_type_Int = paramNotifyData.jdField_b_of_type_Int;
      this.jdField_c_of_type_Int = paramNotifyData.jdField_c_of_type_Int;
      this.jdField_a_of_type_Boolean = paramNotifyData.jdField_a_of_type_Boolean;
      return;
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.d = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    return (i == 47) || (i == 42) || (i == 48) || (i == 44);
  }
  
  private boolean a(NotifyData paramNotifyData)
  {
    return (paramNotifyData != null) && ((!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramNotifyData.jdField_a_of_type_JavaLangString)) || ((this.jdField_a_of_type_Int != paramNotifyData.jdField_a_of_type_Int) && (paramNotifyData.a())));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NotifyData{sessionId[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("], id[");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("], type[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], uinType[");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("], name[");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("], extraName[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], head[");
    boolean bool;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], isHide[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("]}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QAVNotification.NotifyData
 * JD-Core Version:    0.7.0.1
 */