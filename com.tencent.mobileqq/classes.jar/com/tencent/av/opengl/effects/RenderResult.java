package com.tencent.av.opengl.effects;

public class RenderResult
{
  CameraFrame a;
  byte[] b;
  byte[] c;
  byte[] d;
  short e;
  short f;
  
  RenderResult()
  {
    a();
  }
  
  public void a()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = 0;
    this.f = 0;
  }
  
  public void a(CameraFrame paramCameraFrame, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    this.a = paramCameraFrame;
    this.b = paramArrayOfByte1;
    this.c = paramArrayOfByte2;
    this.d = paramArrayOfByte3;
    this.e = paramShort1;
    this.f = paramShort2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.RenderResult
 * JD-Core Version:    0.7.0.1
 */