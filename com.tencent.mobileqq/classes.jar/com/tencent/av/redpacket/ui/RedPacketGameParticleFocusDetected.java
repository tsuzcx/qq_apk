package com.tencent.av.redpacket.ui;

import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class RedPacketGameParticleFocusDetected
  extends RedPacketGameParticleFrame
{
  public RedPacketGameParticleEmojiDetected a;
  public boolean a;
  public RedPacketGameSprite[] a;
  public int b;
  public RedPacketGameSprite[] b;
  public int c;
  
  public RedPacketGameParticleFocusDetected(RedPacketGameParticleEmojiDetected paramRedPacketGameParticleEmojiDetected)
  {
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite[6];
    this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite[10];
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected = paramRedPacketGameParticleEmojiDetected;
    this.jdField_c_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite;
    this.jdField_b_of_type_Long = 900L;
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    long l = this.jdField_a_of_type_Long;
    int i = 0;
    if (paramLong - l <= this.jdField_b_of_type_Long) {
      i = 255;
    }
    a(i);
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite.length) {
        break;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[i] = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_focus_detected_" + (i * 3 + 3) + ".png"));
      i += 1;
    }
    while (j < this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite.length)
    {
      this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[j] = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_focus_detected_big_" + j * 3 + ".png"));
      j += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!this.jdField_a_of_type_Boolean) {
        break label45;
      }
    }
    label45:
    for (RedPacketGameSprite[] arrayOfRedPacketGameSprite = this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite;; arrayOfRedPacketGameSprite = this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite)
    {
      this.jdField_c_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = arrayOfRedPacketGameSprite;
      this.jdField_b_of_type_Long = (this.jdField_c_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite.length * 150);
      return;
    }
  }
  
  public void b()
  {
    int j = 0;
    super.b();
    RedPacketGameSprite[] arrayOfRedPacketGameSprite = this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite;
    int k = arrayOfRedPacketGameSprite.length;
    int i = 0;
    RedPacketGameSprite localRedPacketGameSprite;
    while (i < k)
    {
      localRedPacketGameSprite = arrayOfRedPacketGameSprite[i];
      if (localRedPacketGameSprite != null) {
        localRedPacketGameSprite.a();
      }
      i += 1;
    }
    arrayOfRedPacketGameSprite = this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite;
    k = arrayOfRedPacketGameSprite.length;
    i = j;
    while (i < k)
    {
      localRedPacketGameSprite = arrayOfRedPacketGameSprite[i];
      if (localRedPacketGameSprite != null) {
        localRedPacketGameSprite.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = null;
    this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = null;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 500 / 750);
    this.jdField_c_of_type_Int = (paramInt1 * 500 / 750);
  }
  
  public void c()
  {
    Rect localRect = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected.a();
    int i = (localRect.left + localRect.right - this.jdField_b_of_type_Int) / 2;
    int j = (localRect.top + localRect.bottom - this.jdField_c_of_type_Int) / 2;
    int k = (localRect.left + localRect.right + this.jdField_b_of_type_Int) / 2;
    int m = localRect.top;
    a(i, j, k, (localRect.bottom + m + this.jdField_c_of_type_Int) / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameParticleFocusDetected
 * JD-Core Version:    0.7.0.1
 */