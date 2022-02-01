package com.tencent.mobileqq.activity.aio.anim.egg;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;

public class EggKeyword
{
  private int a;
  private final String b;
  
  public EggKeyword(String paramString, int paramInt)
  {
    this.b = paramString;
    this.a = paramInt;
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
  
  public String a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public boolean b(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (TextUtils.isEmpty(this.b)) {
        return false;
      }
      if (b() == 0) {
        return paramString.contains(this.b);
      }
      bool1 = bool2;
      if (b() == 1)
      {
        bool1 = bool2;
        if (TextUtils.isDigitsOnly(this.b))
        {
          int i = Integer.parseInt(this.b);
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
            str = this.b;
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
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.egg.EggKeyword
 * JD-Core Version:    0.7.0.1
 */