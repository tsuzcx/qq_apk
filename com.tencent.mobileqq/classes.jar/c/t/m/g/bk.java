package c.t.m.g;

import android.text.TextUtils;

public abstract class bk
{
  private bk.a a;
  
  public bk(String paramString)
  {
    m.b();
    StringBuilder localStringBuilder = new StringBuilder("halley_schedule_");
    localStringBuilder.append(m.c());
    localStringBuilder.append("_");
    localStringBuilder.append(m.i());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".db");
    paramString = localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.bk
 * JD-Core Version:    0.7.0.1
 */