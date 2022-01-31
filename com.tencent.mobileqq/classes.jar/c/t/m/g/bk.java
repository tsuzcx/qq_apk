package c.t.m.g;

import android.text.TextUtils;

public abstract class bk
{
  private bk.a a;
  
  public bk(String paramString)
  {
    m.b();
    paramString = "halley_schedule_" + m.c() + "_" + m.i() + "_" + paramString + ".db";
    this.a = new bk.a(this, m.a(), paramString);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null)) {
        this.a.a(paramString, paramArrayOfByte);
      }
      return;
    }
    finally {}
  }
  
  public final byte[] a(String paramString)
  {
    try
    {
      paramString = this.a.a(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.bk
 * JD-Core Version:    0.7.0.1
 */