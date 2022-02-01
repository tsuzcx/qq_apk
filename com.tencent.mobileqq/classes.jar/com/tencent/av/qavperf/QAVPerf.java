package com.tencent.av.qavperf;

import android.content.Context;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

public class QAVPerf
{
  private static volatile QAVPerf b;
  private final IQAVP a;
  
  private QAVPerf(VideoAppInterface paramVideoAppInterface)
  {
    this.a = new QAVPImpl(paramVideoAppInterface);
  }
  
  public static QAVPerf a(VideoAppInterface paramVideoAppInterface)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QAVPerf(paramVideoAppInterface);
        }
      }
      finally {}
    }
    return b;
  }
  
  private boolean a(Context paramContext)
  {
    return QAVPUtils.b(paramContext);
  }
  
  public void a(Context paramContext, SessionInfo paramSessionInfo)
  {
    if (a(paramContext)) {
      this.a.a(paramSessionInfo);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.a.c(paramSessionInfo);
  }
  
  public void b(Context paramContext, SessionInfo paramSessionInfo)
  {
    if (a(paramContext)) {
      this.a.b(paramSessionInfo);
    }
  }
  
  public void b(SessionInfo paramSessionInfo)
  {
    this.a.d(paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qavperf.QAVPerf
 * JD-Core Version:    0.7.0.1
 */