package com.tencent.av.business.manager.magicface;

import com.tencent.av.AVLog;
import com.tencent.qphone.base.util.QLog;

class MagicfacePlayer$1
  implements MagicfaceBaseDecoder.MagicPlayListener
{
  MagicfacePlayer$1(MagicfacePlayer paramMagicfacePlayer) {}
  
  public void a(long paramLong, String arg3, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEndMagicPlay, id[");
    localStringBuilder.append(???);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("AVMagicfacePlayer", 1, localStringBuilder.toString());
    if (this.a.f != null) {
      this.a.f.a(paramLong, ???, paramInt);
    }
    synchronized (this.a)
    {
      if ((this.a.b != null) && (this.a.c != null)) {
        this.a.a(paramLong, this.a.b, this.a.c, this.a.d, this.a.e);
      }
      return;
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("play audio begin. id = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", repeat = ");
    localStringBuilder.append(paramBoolean);
    AVLog.printColorLog("AVMagicfacePlayer", localStringBuilder.toString());
    if (paramBoolean)
    {
      paramString = this.a;
      paramString.a(paramString.a, 100);
      return;
    }
    paramString = this.a;
    paramString.a(paramString.a, 1);
  }
  
  public void b(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("play video begin.");
    localStringBuilder.append(paramString);
    AVLog.printColorLog("AVMagicfacePlayer", localStringBuilder.toString());
    if (this.a.f != null) {
      this.a.f.b(paramLong, paramString);
    }
  }
  
  public void c(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("play audio end. id = ");
    localStringBuilder.append(paramString);
    AVLog.printColorLog("AVMagicfacePlayer", localStringBuilder.toString());
    paramString = this.a;
    paramString.a(paramString.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfacePlayer.1
 * JD-Core Version:    0.7.0.1
 */