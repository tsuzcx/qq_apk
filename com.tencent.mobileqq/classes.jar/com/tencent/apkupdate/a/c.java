package com.tencent.apkupdate.a;

import java.io.DataInputStream;

public final class c
{
  short a;
  short b;
  short c;
  short d;
  int e;
  int f;
  short g;
  byte[] h;
  
  public final void a(DataInputStream paramDataInputStream)
  {
    int i = paramDataInputStream.readShort();
    this.a = ((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
    i = paramDataInputStream.readShort();
    this.b = ((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
    i = paramDataInputStream.readShort();
    this.c = ((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
    i = paramDataInputStream.readShort();
    this.d = ((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
    this.e = a.a(paramDataInputStream.readInt());
    this.f = a.a(paramDataInputStream.readInt());
    i = paramDataInputStream.readShort();
    this.g = ((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
    i = this.g;
    this.h = new byte[i];
    paramDataInputStream.read(this.h, 0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.a.c
 * JD-Core Version:    0.7.0.1
 */