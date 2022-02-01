package com.tencent.av.redpacket.ui;

public class RedPacketGameParticleLightBg
  extends RedPacketGameParticle
{
  public boolean a;
  
  public RedPacketGameParticleLightBg()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(long paramLong)
  {
    long l = paramLong - this.jdField_a_of_type_Long;
    a((float)(paramLong - this.jdField_a_of_type_Long) / 50.0F);
    int j = 0;
    int i;
    if (l < 500L) {
      i = (int)(l * 255L / 500L);
    }
    for (;;)
    {
      a(i);
      return;
      if (((l >= 500L) && (l <= 5397L)) || (!this.jdField_a_of_type_Boolean))
      {
        i = 255;
      }
      else
      {
        i = j;
        if (l > 5397L)
        {
          i = j;
          if (l < 5564L)
          {
            i = j;
            if (this.jdField_a_of_type_Boolean) {
              i = (int)((l - 5564L) * 255L / -167L);
            }
          }
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1 * 5 / 1500, paramInt2 - paramInt1 * 752 / 750, paramInt1 * 1495 / 1500, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameParticleLightBg
 * JD-Core Version:    0.7.0.1
 */