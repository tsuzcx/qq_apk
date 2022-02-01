package com.tencent.av.business.handler;

import android.util.Log;

class MessageHandler$ClassInfo
{
  Class<?> jdField_a_of_type_JavaLangClass;
  String jdField_a_of_type_JavaLangString;
  Class<?> b;
  
  void a(String paramString, long paramLong)
  {
    if ((this.b == null) || (this.jdField_a_of_type_JavaLangClass == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("check ClassInfo, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      Log.d(paramString, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.MessageHandler.ClassInfo
 * JD-Core Version:    0.7.0.1
 */