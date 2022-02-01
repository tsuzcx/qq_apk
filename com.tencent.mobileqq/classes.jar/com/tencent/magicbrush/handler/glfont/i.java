package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.gi.c.c;
import java.nio.FloatBuffer;

public class i
  implements IMBFontHandler
{
  private e a;
  private f b;
  private g c;
  private j d;
  private b e;
  private c f;
  private boolean g = false;
  
  private void a()
  {
    c.c.b("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
    Object localObject = this.a;
    if (localObject != null) {
      ((e)localObject).a();
    }
    localObject = this.c;
    if (localObject != null) {
      ((g)localObject).b();
    }
    this.g = true;
  }
  
  public void a(b paramb)
  {
    this.e = paramb;
    f localf = this.b;
    if (localf != null) {
      localf.a(paramb);
    }
  }
  
  public boolean checkAndFlushClearSignal()
  {
    boolean bool = this.g;
    this.g = false;
    return bool;
  }
  
  public int[] checkAndFlushDirtySignal()
  {
    e locale = this.a;
    if (locale != null) {
      return locale.c();
    }
    return null;
  }
  
  public FloatBuffer drawText(String paramString)
  {
    this.c.a(this.d);
    FloatBuffer localFloatBuffer2 = this.c.a(paramString);
    FloatBuffer localFloatBuffer1 = localFloatBuffer2;
    if (localFloatBuffer2 == null)
    {
      c.c.b("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.d });
      a();
      localFloatBuffer1 = this.c.a(paramString);
    }
    if (localFloatBuffer1 == null)
    {
      c.c.b("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.d });
      return null;
    }
    return localFloatBuffer1;
  }
  
  public void enableStroke(boolean paramBoolean)
  {
    this.d.d = paramBoolean;
  }
  
  public Bitmap getBitmapAtlas()
  {
    e locale = this.a;
    if (locale != null) {
      return locale.d();
    }
    return null;
  }
  
  public float getTextLineHeight(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return 0.0F;
      }
      if (this.b != null)
      {
        g localg = this.c;
        if (localg == null) {
          return 0.0F;
        }
        localg.a(this.d);
        return this.c.c(paramString);
      }
    }
    return 0.0F;
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init() called with: m_atlasWidth = [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], m_atlasHeight = [");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    c.c.b("MicroMsg.MBFontManagerImpl", localStringBuilder.toString(), new Object[0]);
    this.a = new e(paramInt1, paramInt2);
    this.b = new f(this.e);
    this.c = new g(this.a, this.f);
    this.d = new j(null, "normal", 20.0F, false, 0.0F, j.a.a);
  }
  
  public String loadFont(String paramString)
  {
    return this.b.c(paramString);
  }
  
  public float measureText(String paramString)
  {
    this.c.a(this.d);
    float f2 = this.c.b(paramString);
    float f1 = f2;
    if (f2 == -1.0F)
    {
      c.c.b("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.d });
      a();
      f1 = this.c.b(paramString);
    }
    if (f1 == -1.0F)
    {
      c.c.b("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.d });
      return 0.0F;
    }
    return f1;
  }
  
  public void release()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((e)localObject).b();
      this.a = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((f)localObject).a();
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((g)localObject).a();
      this.c = null;
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.d.e = paramFloat;
  }
  
  public void useFont(String paramString1, String paramString2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    j.a locala = j.a.a(paramBoolean1, paramBoolean2);
    this.d.a = this.b.a(paramString1, locala, paramString2);
    paramString1 = this.d;
    paramString1.b = paramString2;
    paramString1.c = paramFloat;
    paramString1.f = locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.i
 * JD-Core Version:    0.7.0.1
 */