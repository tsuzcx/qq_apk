package com.b.a.a;

import android.os.Handler;
import android.os.Looper;
import com.b.a.n.a;
import java.util.LinkedHashMap;

public final class j
{
  private static j b;
  private LinkedHashMap<String, n.a> a = new LinkedHashMap();
  
  public static j a()
  {
    try
    {
      if (b == null) {
        b = new j();
      }
      j localj = b;
      return localj;
    }
    finally {}
  }
  
  public final void a(String paramString, int paramInt)
  {
    try
    {
      if (this.a == null) {
        this.a = new LinkedHashMap();
      }
      boolean bool = this.a.containsKey(paramString);
      if (!bool) {
        return;
      }
      n.a locala = (n.a)this.a.get(paramString);
      new Handler(Looper.getMainLooper()).post(new j.1(this, locala, paramInt, paramString));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.a.j
 * JD-Core Version:    0.7.0.1
 */