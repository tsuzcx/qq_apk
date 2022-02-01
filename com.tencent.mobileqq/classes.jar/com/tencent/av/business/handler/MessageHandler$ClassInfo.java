package com.tencent.av.business.handler;

import android.util.Log;

class MessageHandler$ClassInfo
{
  String a;
  Class<?> b;
  Class<?> c;
  
  void a(String paramString, long paramLong)
  {
    if ((this.c == null) || (this.b == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("check ClassInfo, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], ");
      localStringBuilder.append(this.a);
      Log.d(paramString, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.MessageHandler.ClassInfo
 * JD-Core Version:    0.7.0.1
 */