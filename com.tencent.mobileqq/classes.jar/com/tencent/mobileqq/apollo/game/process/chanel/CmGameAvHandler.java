package com.tencent.mobileqq.apollo.game.process.chanel;

import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import com.tencent.qphone.base.util.QLog;

@Deprecated
public class CmGameAvHandler
  implements IRequestHandler
{
  public CmGameAvHandler(int paramInt) {}
  
  public int a()
  {
    return 0;
  }
  
  public HandleResult a(long paramLong, String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("handleCmd not expect cmd:");
    paramString2.append(paramString1);
    QLog.e("[cmshow]CmGameAvHandler", 1, paramString2.toString());
    return null;
  }
  
  public void a() {}
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameAvHandler
 * JD-Core Version:    0.7.0.1
 */