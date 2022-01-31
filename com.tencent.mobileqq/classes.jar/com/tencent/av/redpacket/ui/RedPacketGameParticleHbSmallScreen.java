package com.tencent.av.redpacket.ui;

public class RedPacketGameParticleHbSmallScreen
  extends RedPacketGameParticle
{
  public int b;
  
  protected float a(int paramInt1, int paramInt2)
  {
    return this.b + paramInt1;
  }
  
  public void a(long paramLong)
  {
    paramLong -= this.a;
    float f2 = 0.0F;
    float f1 = f2;
    if (paramLong <= 3733L)
    {
      paramLong = paramLong * 3L % 2800L / 3L;
      if ((paramLong < 0L) || (paramLong >= 133L)) {
        break label65;
      }
      f1 = (float)(-3L * paramLong) / 100.0F;
    }
    for (;;)
    {
      a(f1);
      return;
      label65:
      if ((paramLong >= 133L) && (paramLong < 266L))
      {
        f1 = (float)(3L * paramLong) / 50.0F - 12.0F;
      }
      else if ((paramLong >= 266L) && (paramLong < 400L))
      {
        f1 = (float)(-3L * paramLong) / 50.0F + 20.0F;
      }
      else if ((paramLong >= 400L) && (paramLong < 533L))
      {
        f1 = (float)(3L * paramLong) / 50.0F - 28.0F;
      }
      else
      {
        f1 = f2;
        if (paramLong >= 533L)
        {
          f1 = f2;
          if (paramLong < 666L) {
            f1 = (float)(-3L * paramLong) / 100.0F + 20.0F;
          }
        }
      }
    }
  }
  
  protected float b(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = paramInt1 * 102 / 160;
    paramInt4 = paramInt1 * 140 / 160;
    this.b = (paramInt1 * 24 / 160);
    a((paramInt1 - paramInt3) / 2, (paramInt2 - paramInt4) / 2, (paramInt3 + paramInt1) / 2, (paramInt4 + paramInt2) / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameParticleHbSmallScreen
 * JD-Core Version:    0.7.0.1
 */