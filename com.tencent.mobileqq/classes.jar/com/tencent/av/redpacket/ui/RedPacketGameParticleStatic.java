package com.tencent.av.redpacket.ui;

public class RedPacketGameParticleStatic
  extends RedPacketGameParticle
{
  public int b;
  public int c;
  public int d;
  public int e;
  
  public void a(long paramLong) {}
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = this.b * paramInt1 / 750;
    paramInt3 = this.c * paramInt1 / 750;
    a(paramInt2, paramInt3, this.d * paramInt1 / 750 + paramInt2, this.e * paramInt1 / 750 + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameParticleStatic
 * JD-Core Version:    0.7.0.1
 */