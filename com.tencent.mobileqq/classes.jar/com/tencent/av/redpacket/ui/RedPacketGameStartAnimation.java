package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.av.redpacket.AVRedPacketManager;

public class RedPacketGameStartAnimation
{
  public RedPacketGameParticle[] a = new RedPacketGameParticle[8];
  
  public RedPacketGameStartAnimation(Context paramContext)
  {
    this.a[0] = new RedPacketGameParticleLightBg();
    this.a[1] = new RedPacketGameParticleHb(paramContext);
    this.a[2] = new RedPacketGameParticleCd();
    this.a[3] = new RedPacketGameParticleTips1();
    this.a[4] = new RedPacketGameParticle3();
    this.a[5] = new RedPacketGameParticle2();
    this.a[6] = new RedPacketGameParticle1();
    this.a[7] = new RedPacketGameParticleGo();
  }
  
  public long a(long paramLong)
  {
    long l2;
    if (paramLong < this.a[0].jdField_a_of_type_Long)
    {
      l2 = this.a[0].jdField_a_of_type_Long;
      l1 = this.a[0].jdField_a_of_type_Long;
      l2 -= paramLong;
      paramLong = l1;
    }
    for (long l1 = l2;; l1 = 0L)
    {
      RedPacketGameParticle[] arrayOfRedPacketGameParticle = this.a;
      int j = arrayOfRedPacketGameParticle.length;
      int i = 0;
      while (i < j)
      {
        arrayOfRedPacketGameParticle[i].jdField_a_of_type_Long = paramLong;
        i += 1;
      }
      ((RedPacketGameParticleLightBg)this.a[0]).a = true;
      ((RedPacketGameParticleHb)this.a[1]).a = true;
      ((RedPacketGameParticleCd)this.a[2]).a = true;
      return l1;
    }
  }
  
  public void a()
  {
    RedPacketGameParticle[] arrayOfRedPacketGameParticle = this.a;
    int j = arrayOfRedPacketGameParticle.length;
    int i = 0;
    while (i < j)
    {
      arrayOfRedPacketGameParticle[i].b();
      i += 1;
    }
    this.a = null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RedPacketGameParticle[] arrayOfRedPacketGameParticle = this.a;
    int j = arrayOfRedPacketGameParticle.length;
    int i = 0;
    while (i < j)
    {
      arrayOfRedPacketGameParticle[i].b(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
  
  public void a(long paramLong)
  {
    this.a[0].jdField_a_of_type_Long = paramLong;
    this.a[1].jdField_a_of_type_Long = paramLong;
    this.a[2].jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    RedPacketGameParticle[] arrayOfRedPacketGameParticle = this.a;
    int j = arrayOfRedPacketGameParticle.length;
    int i = 0;
    while (i < j)
    {
      arrayOfRedPacketGameParticle[i].a(paramCanvas, paramPaint);
      i += 1;
    }
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    this.a[0].jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_light_bg.png"));
    this.a[2].jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_cd.png"));
    this.a[4].jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_3.png"));
    this.a[5].jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_2.png"));
    this.a[6].jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_1.png"));
    this.a[7].jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_go.png"));
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager paramAVRedPacketManager)
  {
    if (paramBoolean) {}
    for (this.a[3].jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = null;; this.a[3].jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = null)
    {
      ((RedPacketGameParticleHb)this.a[1]).a(paramBoolean, paramAVRedPacketManager);
      return;
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    RedPacketGameParticle[] arrayOfRedPacketGameParticle = this.a;
    int j = arrayOfRedPacketGameParticle.length;
    int i = 0;
    while (i < j)
    {
      arrayOfRedPacketGameParticle[i].a(paramLong);
      i += 1;
    }
    boolean bool1 = bool2;
    if (this.a[7].jdField_a_of_type_Long != 0L)
    {
      bool1 = bool2;
      if (paramLong - this.a[7].jdField_a_of_type_Long > 5564L) {
        bool1 = true;
      }
    }
    if (bool1) {
      this.a[7].jdField_a_of_type_Long = 0L;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameStartAnimation
 * JD-Core Version:    0.7.0.1
 */