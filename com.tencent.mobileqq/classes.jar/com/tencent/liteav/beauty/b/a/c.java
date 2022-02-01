package com.tencent.liteav.beauty.b.a;

import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.beauty.NativeLoad;

public class c
  extends h
{
  public boolean a()
  {
    NativeLoad.getInstance();
    this.a = NativeLoad.nativeLoadGLProgram(6);
    if ((this.a != 0) && (b())) {
      this.g = true;
    } else {
      this.g = false;
    }
    c();
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.c
 * JD-Core Version:    0.7.0.1
 */