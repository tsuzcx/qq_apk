package com.tencent.av.business.manager.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.SessionInfo;

class VideoNodeReporter$SeesionRecord
{
  public int a;
  public long a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  long[] jdField_a_of_type_ArrayOfLong = new long[41];
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d = "KilledBySystem";
  
  VideoNodeReporter$SeesionRecord()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public String a()
  {
    String str1 = Build.MODEL;
    String str2 = String.valueOf(Build.VERSION.SDK_INT);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Android");
    localStringBuilder.append('|');
    localStringBuilder.append(str1);
    localStringBuilder.append('|');
    localStringBuilder.append(str2);
    localStringBuilder.append('|');
    localStringBuilder.append(str2);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('|');
    int i = this.jdField_b_of_type_Int;
    if (i != -1)
    {
      localStringBuilder.append(i);
      localStringBuilder.append('|');
    }
    else
    {
      localStringBuilder.append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[20]));
      localStringBuilder.append('|');
    }
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('|');
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt, long paramLong)
  {
    if ((paramInt >= 0) && (paramInt < 41))
    {
      if (paramLong == 1L) {
        this.jdField_a_of_type_ArrayOfLong[paramInt] = 1L;
      } else {
        this.jdField_a_of_type_ArrayOfLong[paramInt] = paramLong;
      }
      localStringBuilder = new StringBuilder();
      paramInt = 0;
      while (paramInt < 41)
      {
        if (paramInt != 14)
        {
          if (paramInt != 20)
          {
            if (paramInt != 29)
            {
              if (paramInt != 36)
              {
                localStringBuilder.append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[paramInt]));
                localStringBuilder.append('|');
              }
              else
              {
                if (this.jdField_b_of_type_Long > 0L) {
                  this.jdField_c_of_type_Long = ((System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L);
                }
                localStringBuilder.append(this.jdField_c_of_type_Long);
                localStringBuilder.append('|');
              }
            }
            else
            {
              localStringBuilder.append(this.d);
              localStringBuilder.append('|');
            }
          }
          else
          {
            localStringBuilder.append(0);
            localStringBuilder.append('|');
          }
        }
        else
        {
          if (this.jdField_a_of_type_ArrayOfLong[14] == 0L)
          {
            this.jdField_a_of_type_JavaLangString = VideoNodeReporter.a();
            this.jdField_a_of_type_ArrayOfLong[14] = 1L;
          }
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append('|');
        }
        paramInt += 1;
      }
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildBody report error:");
    localStringBuilder.append(paramInt);
    AVLog.printAllUserLog("VideoNodeReporter", localStringBuilder.toString());
    return null;
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString)
  {
    if (paramSessionInfo != null)
    {
      if (paramSessionInfo.l != -1) {
        this.jdField_a_of_type_Int = paramSessionInfo.l;
      }
      if (paramSessionInfo.d != 0) {
        this.jdField_b_of_type_Int = paramSessionInfo.d;
      }
      if (!TextUtils.isEmpty(paramSessionInfo.jdField_c_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramSessionInfo.jdField_c_of_type_JavaLangString;
      }
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_c_of_type_JavaLangString = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.SeesionRecord
 * JD-Core Version:    0.7.0.1
 */