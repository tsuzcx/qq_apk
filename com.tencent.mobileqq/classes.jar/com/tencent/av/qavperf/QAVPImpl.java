package com.tencent.av.qavperf;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.qavperf.manager.QAVPFpsManager;
import com.tencent.av.qavperf.manager.QAVPMemoryManager;

public class QAVPImpl
  implements IQAVP
{
  private final QAVPFpsManager a;
  private final QAVPMemoryManager b;
  
  public QAVPImpl(VideoAppInterface paramVideoAppInterface)
  {
    this.a = new QAVPFpsManager(paramVideoAppInterface);
    this.b = new QAVPMemoryManager(paramVideoAppInterface);
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.b.a(paramSessionInfo);
  }
  
  public void b(SessionInfo paramSessionInfo)
  {
    this.a.a(paramSessionInfo);
  }
  
  public void c(SessionInfo paramSessionInfo)
  {
    this.b.b(paramSessionInfo);
  }
  
  public void d(SessionInfo paramSessionInfo)
  {
    this.a.b(paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qavperf.QAVPImpl
 * JD-Core Version:    0.7.0.1
 */