package com.tencent.av.business.manager.magicface;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class MagicfaceBaseDecoder
{
  protected MagicfaceData a;
  WeakReference<MagicfaceBaseDecoder.MagicPlayListener> b;
  WeakReference<MagicfaceBaseDecoder.MagicfaceRenderListener> c;
  volatile boolean d = false;
  String e;
  Handler f = new Handler(Looper.getMainLooper());
  
  public MagicfaceBaseDecoder()
  {
    c();
  }
  
  public void a()
  {
    d();
    if (!this.d)
    {
      this.a.a();
      try
      {
        new Thread(new MagicfaceBaseDecoder.1(this)).start();
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startDecoder err:");
          localStringBuilder.append(localOutOfMemoryError.getMessage());
          QLog.e("MagicfaceBaseDecoder", 1, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(MagicfaceBaseDecoder.MagicPlayListener paramMagicPlayListener)
  {
    this.b = new WeakReference(paramMagicPlayListener);
  }
  
  public void a(MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    if (paramMagicfaceRenderListener != null)
    {
      this.c = new WeakReference(paramMagicfaceRenderListener);
      return;
    }
    this.c = null;
  }
  
  public void a(MagicfaceData paramMagicfaceData)
  {
    this.a = paramMagicfaceData;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (this.b != null) {
      this.f.post(new MagicfaceBaseDecoder.3(this, paramString, paramInt));
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.b != null) {
      this.f.post(new MagicfaceBaseDecoder.4(this, paramString, paramBoolean));
    }
  }
  
  public void b()
  {
    this.d = false;
    this.a.b();
  }
  
  protected void b(String paramString)
  {
    if (this.b != null) {
      this.f.post(new MagicfaceBaseDecoder.2(this, paramString));
    }
  }
  
  protected void c() {}
  
  protected void c(String paramString)
  {
    if (this.b != null) {
      this.f.post(new MagicfaceBaseDecoder.5(this, paramString));
    }
  }
  
  protected void d() {}
  
  public abstract int e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder
 * JD-Core Version:    0.7.0.1
 */