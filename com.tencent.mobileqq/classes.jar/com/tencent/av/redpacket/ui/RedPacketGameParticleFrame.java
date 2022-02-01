package com.tencent.av.redpacket.ui;

public abstract class RedPacketGameParticleFrame
  extends RedPacketGameParticle
{
  protected long b;
  protected RedPacketGameSprite[] c;
  
  public void a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    if (this.c != null)
    {
      int i = (int)((paramLong - l) % this.b * this.c.length / this.b);
      if ((i >= 0) && (i < this.c.length)) {
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.c[i];
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.c != null)
    {
      RedPacketGameSprite[] arrayOfRedPacketGameSprite = this.c;
      int j = arrayOfRedPacketGameSprite.length;
      int i = 0;
      while (i < j)
      {
        RedPacketGameSprite localRedPacketGameSprite = arrayOfRedPacketGameSprite[i];
        if (localRedPacketGameSprite != null) {
          localRedPacketGameSprite.a();
        }
        i += 1;
      }
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameParticleFrame
 * JD-Core Version:    0.7.0.1
 */