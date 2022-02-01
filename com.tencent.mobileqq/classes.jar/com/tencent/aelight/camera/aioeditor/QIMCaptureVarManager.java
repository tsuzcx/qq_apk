package com.tencent.aelight.camera.aioeditor;

import com.tencent.aelight.camera.aioeditor.capture.IQIMManager;

public class QIMCaptureVarManager
  extends IQIMManager
{
  public int a = 2;
  private boolean b = false;
  private int c = 1;
  private String[] d = new String[2];
  private String[] e = new String[2];
  private int f = 0;
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    this.d[this.f] = paramString;
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void b(String paramString)
  {
    this.e[this.f] = paramString;
  }
  
  public boolean b()
  {
    return this.a == 14;
  }
  
  public void c() {}
  
  public boolean c(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if ((paramInt & this.c) != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < 2)) {
      this.f = paramInt;
    }
  }
  
  public void e(int paramInt)
  {
    this.d[paramInt] = null;
    this.e[paramInt] = null;
  }
  
  public String[] e()
  {
    return this.d;
  }
  
  public String[] f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager
 * JD-Core Version:    0.7.0.1
 */