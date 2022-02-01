package com.tencent.av.business.manager.magicface;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MagicfacePlayer
{
  String a;
  String b;
  MagicfaceData c;
  MagicfaceBaseDecoder.MagicfaceRenderListener d;
  MagicfaceBaseDecoder.MagicPlayListener e;
  MagicfaceBaseDecoder.MagicPlayListener f;
  MagicfaceBaseDecoder.MagicPlayListener g = new MagicfacePlayer.1(this);
  private MagicfaceBaseDecoder h;
  private SoundPoolUtil i;
  
  public MagicfacePlayer()
  {
    a();
  }
  
  public void a()
  {
    if (this.h == null)
    {
      if (DeviceInfoUtil.L())
      {
        this.h = new MagicfaceNormalDecoder();
        AVLog.printErrorLog("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
        return;
      }
      this.h = new MagicfaceNormalDecoder();
      AVLog.printErrorLog("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
    }
  }
  
  public void a(long paramLong, String paramString, MagicfaceData paramMagicfaceData, MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener, MagicfaceBaseDecoder.MagicPlayListener paramMagicPlayListener)
  {
    if (this.h.d) {
      try
      {
        this.b = paramString;
        this.c = paramMagicfaceData;
        this.d = paramMagicfaceRenderListener;
        this.e = paramMagicPlayListener;
        this.h.b();
        return;
      }
      finally {}
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playMagicface, srcPath[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("AVMagicfacePlayer", 1, localStringBuilder.toString());
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("audio");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramMagicfaceData.s.src);
      this.a = localStringBuilder.toString();
      this.f = paramMagicPlayListener;
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
      if ((paramMagicfaceData.s.src != null) && (!paramMagicfaceData.s.src.equals("")) && (this.i == null)) {
        this.i = new SoundPoolUtil();
      }
      this.h.a(paramString);
      this.h.a(paramMagicfaceData);
      this.h.a(paramMagicfaceRenderListener);
      this.h.a(this.g);
      this.h.a();
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    SoundPoolUtil localSoundPoolUtil = this.i;
    if (localSoundPoolUtil != null) {
      localSoundPoolUtil.b(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("playSound soundSrc = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", loop = ");
    ((StringBuilder)localObject).append(paramInt);
    AVLog.printColorLog("AVMagicfacePlayer", ((StringBuilder)localObject).toString());
    localObject = this.i;
    if (localObject != null) {
      ((SoundPoolUtil)localObject).a(paramString, paramInt, 0);
    }
  }
  
  public boolean b()
  {
    return this.h.d;
  }
  
  public void c()
  {
    try
    {
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
      this.h.b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfacePlayer
 * JD-Core Version:    0.7.0.1
 */