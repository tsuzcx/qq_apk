package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.app.SessionInfo;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.Map;

public class VoiceChangeDataReport
{
  public static String a = "VoiceChangeDataReport";
  static long b = 0L;
  static int c = 0;
  static int d = 0;
  static int e = 0;
  static boolean f = false;
  static boolean g = false;
  static boolean h = false;
  static boolean i = false;
  static String j = "0";
  static String k = "actAVFunChatVoiceChange";
  
  public static void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("typeid", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    localHashMap.put("duration", localStringBuilder.toString());
    UserAction.onUserAction(k, true, -1L, -1L, localHashMap, true);
    AVLog.printDebugLog(a, String.format("reportVoiceChange voiceType = %s, duration = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
  }
  
  public static void a(int paramInt, String paramString)
  {
    AVLog.printDebugLog(a, String.format("onConnected sessionType = %s, roomid = %s", new Object[] { Integer.valueOf(paramInt), paramString }));
    i = true;
    j = paramString;
    if ((paramInt != 1) && (paramInt != 3))
    {
      if ((paramInt == 2) || (paramInt == 4))
      {
        paramInt = c;
        if (paramInt != 0) {
          e = paramInt;
        }
        g = true;
      }
    }
    else
    {
      paramInt = c;
      if (paramInt != 0) {
        d = paramInt;
      }
      f = true;
    }
  }
  
  public static void a(SessionInfo paramSessionInfo)
  {
    if (h)
    {
      if (!i) {
        return;
      }
      StringBuilder localStringBuilder;
      if ((paramSessionInfo.g != 1) && (paramSessionInfo.g != 2))
      {
        if ((paramSessionInfo.g == 3) || (paramSessionInfo.g == 4)) {
          if (paramSessionInfo.o == 1)
          {
            if (f) {
              if (d == 0)
              {
                a("0X8007E67", "");
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(d);
                localStringBuilder.append("");
                a("0X8007E68", localStringBuilder.toString());
              }
            }
            if (g) {
              if (e == 0)
              {
                a("0X8007E69", "");
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(e);
                localStringBuilder.append("");
                a("0X8007E6A", localStringBuilder.toString());
              }
            }
          }
          else if (paramSessionInfo.o == 10)
          {
            if (f) {
              if (d == 0)
              {
                a("0X8007E63", "");
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(d);
                localStringBuilder.append("");
                a("0X8007E64", localStringBuilder.toString());
              }
            }
            if (g) {
              if (e == 0)
              {
                a("0X8007E65", "");
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(e);
                localStringBuilder.append("");
                a("0X8007E66", localStringBuilder.toString());
              }
            }
          }
        }
      }
      else
      {
        if (f) {
          if (d == 0)
          {
            a("0X8007DC3", "");
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(d);
            localStringBuilder.append("");
            a("0X8007DC2", localStringBuilder.toString());
          }
        }
        if (g) {
          if (e == 0)
          {
            a("0X8007DC5", "");
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(e);
            localStringBuilder.append("");
            a("0X8007DC4", localStringBuilder.toString());
          }
        }
      }
      a(paramSessionInfo, 0);
      h = false;
      i = false;
      j = "0";
    }
  }
  
  public static void a(SessionInfo paramSessionInfo, int paramInt)
  {
    AVLog.printDebugLog(a, String.format("updateReportData sessionType = %d, voiceType = %d", new Object[] { Integer.valueOf(paramSessionInfo.g), Integer.valueOf(paramInt) }));
    long l = System.currentTimeMillis();
    int m = c;
    if (m != 0) {
      a(m, (l - b) / 1000L);
    }
    c = paramInt;
    b = l;
    if ((paramSessionInfo.g != 1) && (paramSessionInfo.g != 3))
    {
      if ((paramSessionInfo.g == 2) || (paramSessionInfo.g == 4))
      {
        paramInt = c;
        if (paramInt != 0) {
          e = paramInt;
        }
        g = true;
      }
    }
    else
    {
      paramInt = c;
      if (paramInt != 0) {
        d = paramInt;
      }
      f = true;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    AVLog.printDebugLog(a, String.format("reportClickEvent key = %s, type = %s, roomid = %s", new Object[] { paramString1, paramString2, j }));
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, "", j, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeDataReport
 * JD-Core Version:    0.7.0.1
 */