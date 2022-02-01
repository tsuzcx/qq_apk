package com.tencent.av.business.manager.report;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.SessionInfo;

class VideoNodeReporter$SeesionRecord
{
  public long a = -1L;
  boolean b = false;
  String c;
  long[] d = new long[41];
  public int e = -1;
  public int f = -1;
  public String g;
  public String h;
  public long i;
  public long j;
  public String k = "KilledBySystem";
  
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
    localStringBuilder.append(this.h);
    localStringBuilder.append('|');
    localStringBuilder.append(this.g);
    localStringBuilder.append('|');
    int m = this.f;
    if (m != -1)
    {
      localStringBuilder.append(m);
      localStringBuilder.append('|');
    }
    else
    {
      localStringBuilder.append(String.valueOf(this.d[20]));
      localStringBuilder.append('|');
    }
    localStringBuilder.append(this.e);
    localStringBuilder.append('|');
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt, long paramLong)
  {
    if ((paramInt >= 0) && (paramInt < 41))
    {
      if (paramLong == 1L) {
        this.d[paramInt] = 1L;
      } else {
        this.d[paramInt] = paramLong;
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
                localStringBuilder.append(String.valueOf(this.d[paramInt]));
                localStringBuilder.append('|');
              }
              else
              {
                if (this.i > 0L) {
                  this.j = ((System.currentTimeMillis() - this.i) / 1000L);
                }
                localStringBuilder.append(this.j);
                localStringBuilder.append('|');
              }
            }
            else
            {
              localStringBuilder.append(this.k);
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
          if (this.d[14] == 0L)
          {
            this.c = VideoNodeReporter.c();
            this.d[14] = 1L;
          }
          localStringBuilder.append(this.c);
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
      if (paramSessionInfo.r != -1) {
        this.e = paramSessionInfo.r;
      }
      if (paramSessionInfo.g != 0) {
        this.f = paramSessionInfo.g;
      }
      if (!TextUtils.isEmpty(paramSessionInfo.s)) {
        this.g = paramSessionInfo.s;
      }
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.h = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.SeesionRecord
 * JD-Core Version:    0.7.0.1
 */