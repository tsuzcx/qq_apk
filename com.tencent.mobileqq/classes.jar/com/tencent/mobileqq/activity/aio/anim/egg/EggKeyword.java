package com.tencent.mobileqq.activity.aio.anim.egg;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;

public class EggKeyword
{
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  
  public EggKeyword(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if ("face".equalsIgnoreCase(paramString)) {
      return 1;
    }
    return 0;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return false;
      }
      if (a() == 0) {
        return paramString.contains(this.jdField_a_of_type_JavaLangString);
      }
      bool1 = bool2;
      if (a() == 1)
      {
        bool1 = bool2;
        if (TextUtils.isDigitsOnly(this.jdField_a_of_type_JavaLangString))
        {
          int i = Integer.parseInt(this.jdField_a_of_type_JavaLangString);
          String str = "";
          if (QQSysFaceUtil.isEmoReady(i))
          {
            str = QQSysFaceUtil.getFaceString(QQSysFaceUtil.convertToLocal(i));
            bool1 = paramString.contains(str);
            paramString = new StringBuilder();
            paramString.append("");
            paramString.append("faceString: ");
            paramString.append(str);
            paramString.append(", resule: ");
            paramString.append(bool1);
            paramString = paramString.toString();
          }
          else
          {
            bool1 = false;
            paramString = str;
          }
          if (QLog.isColorLevel())
          {
            str = this.jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(i);
            localStringBuilder.append(", result: ");
            QLog.d("EggKeyword", 1, new Object[] { "[match] keyword: ", str, ", id: ", localStringBuilder.toString(), paramString });
          }
        }
      }
    }
    return bool1;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.egg.EggKeyword
 * JD-Core Version:    0.7.0.1
 */