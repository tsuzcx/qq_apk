package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;

final class p$a
  extends Thread
{
  private int a;
  private o b;
  private String c;
  private ContentValues d;
  private boolean e;
  private String[] f;
  private String g;
  private String[] h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String[] n;
  private int o;
  private String p;
  private byte[] q;
  
  public p$a(p paramp, int paramInt, o paramo)
  {
    this.a = paramInt;
    this.b = paramo;
  }
  
  public final void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.o = paramInt;
    this.p = paramString;
    this.q = paramArrayOfByte;
  }
  
  public final void a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.e = paramBoolean;
    this.c = paramString1;
    this.f = paramArrayOfString1;
    this.g = paramString2;
    this.h = paramArrayOfString2;
    this.i = paramString3;
    this.j = paramString4;
    this.k = paramString5;
    this.l = paramString6;
  }
  
  public final void run()
  {
    switch (this.a)
    {
    default: 
    case 6: 
      p.a(this.r, this.o, this.p, this.b);
      return;
    case 5: 
      p.a(this.r, this.o, this.b);
      return;
    case 4: 
      p.a(this.r, this.o, this.p, this.q, this.b);
      return;
    case 3: 
      Cursor localCursor = p.a(this.r, this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
      if (localCursor != null)
      {
        localCursor.close();
        return;
      }
      break;
    case 2: 
      p.a(this.r, this.c, this.m, this.n, this.b);
      return;
    case 1: 
      p.a(this.r, this.c, this.d, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.proguard.p.a
 * JD-Core Version:    0.7.0.1
 */