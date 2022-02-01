package com.tencent.mobileqq.apollo.game.process.audio;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class CmAudioManager
  implements ICmGameAudioPlayer
{
  private CmGameNativeMethodHandler a;
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public int a(AppInterface paramAppInterface)
  {
    return 0;
  }
  
  public int a(IRenderRunner paramIRenderRunner, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
  {
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmAudioManager", 2, "pause all music");
    }
    if (CmGameAudioPlayer.a == null) {
      return;
    }
    synchronized (CmGameAudioPlayer.a)
    {
      Iterator localIterator = CmGameAudioPlayer.a.iterator();
      while (localIterator.hasNext())
      {
        CmGameAudioPlayer localCmGameAudioPlayer = (CmGameAudioPlayer)localIterator.next();
        if ((localCmGameAudioPlayer != null) && (localCmGameAudioPlayer.b() == d())) {
          localCmGameAudioPlayer.b(new JSONObject());
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, AppInterface paramAppInterface) {}
  
  public void a(int paramInt, String paramString) {}
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmAudioManager", 2, "resume all music");
    }
  }
  
  public void b(int paramInt, String paramString) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmAudioManager", 2, "destroy all music");
    }
    if (CmGameAudioPlayer.a != null) {
      synchronized (CmGameAudioPlayer.a)
      {
        Iterator localIterator = CmGameAudioPlayer.a.iterator();
        while (localIterator.hasNext())
        {
          CmGameAudioPlayer localCmGameAudioPlayer = (CmGameAudioPlayer)localIterator.next();
          if ((localCmGameAudioPlayer != null) && (localCmGameAudioPlayer.b() == d()))
          {
            localCmGameAudioPlayer.d();
            localIterator.remove();
          }
        }
      }
    }
    ??? = this.a;
    if (??? != null)
    {
      ((CmGameNativeMethodHandler)???).b();
      this.a = null;
    }
  }
  
  public void c(int paramInt, String paramString) {}
  
  public int d()
  {
    CmGameNativeMethodHandler localCmGameNativeMethodHandler = this.a;
    if (localCmGameNativeMethodHandler == null) {
      return 0;
    }
    return localCmGameNativeMethodHandler.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmAudioManager
 * JD-Core Version:    0.7.0.1
 */