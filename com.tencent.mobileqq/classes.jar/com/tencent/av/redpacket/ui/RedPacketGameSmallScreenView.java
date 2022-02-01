package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.av.redpacket.AVRedPacketManager;

public class RedPacketGameSmallScreenView
  extends View
{
  public Paint a;
  public Vibrator a;
  public RedPacketGameParticleHbSmallScreen a;
  public boolean a;
  public RedPacketGameParticleEmojiSmallScreen[] a;
  public RedPacketGameParticleFocusSmallScreen[] a;
  public RedPacketGameSprite[] a;
  
  public RedPacketGameSmallScreenView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen = null;
    this.jdField_a_of_type_AndroidOsVibrator = null;
    this.jdField_a_of_type_Boolean = false;
    a(paramContext);
  }
  
  public RedPacketGameSmallScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen = null;
    this.jdField_a_of_type_AndroidOsVibrator = null;
    this.jdField_a_of_type_Boolean = false;
    a(paramContext);
  }
  
  public RedPacketGameSmallScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen = null;
    this.jdField_a_of_type_AndroidOsVibrator = null;
    this.jdField_a_of_type_Boolean = false;
    a(paramContext);
  }
  
  public void a()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen.length)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[i] != null) {
          this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[i].b();
        }
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen = null;
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen.b();
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen = null;
    if (this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite.length)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[i] != null) {
          this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[i].a();
        }
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = null;
    if (this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen != null)
    {
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen.length)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen[i] != null) {
          this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen[i].b();
        }
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen = null;
    if (this.jdField_a_of_type_AndroidOsVibrator != null) {
      this.jdField_a_of_type_AndroidOsVibrator.cancel();
    }
    this.jdField_a_of_type_AndroidOsVibrator = null;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
  }
  
  public void a(long paramLong)
  {
    int k = 0;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[i].a(paramLong);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen[j].a(paramLong);
        j += 1;
      }
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen.a(paramLong);
  }
  
  public void a(Context paramContext)
  {
    setId(2131374021);
  }
  
  public void a(Canvas paramCanvas, long paramLong)
  {
    int k = 0;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen[i].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[j].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        j += 1;
      }
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    long l = System.currentTimeMillis();
    a(l);
    a(paramCanvas, l);
    invalidate();
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = 0;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Boolean)
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[i].b(paramInt1, paramInt2, paramInt3, paramInt4);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen[j].b(paramInt1, paramInt2, paramInt3, paramInt4);
        j += 1;
      }
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAVRedPacketManager(AVRedPacketManager paramAVRedPacketManager, boolean paramBoolean)
  {
    int j = 0;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen = new RedPacketGameParticleEmojiSmallScreen[2];
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[i] = new RedPacketGameParticleEmojiSmallScreen();
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[i].b(i);
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[i].jdField_a_of_type_Long = (i * 2000 + l);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[0].jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_emoji_6.png"));
      this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[1].jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_emoji_9.png"));
      this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite[6];
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[i] = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_focus_" + i * 6 + ".png"));
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen = new RedPacketGameParticleFocusSmallScreen[2];
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen[i] = new RedPacketGameParticleFocusSmallScreen(this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleEmojiSmallScreen[i]);
        this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameParticleFocusSmallScreen[i].c = this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite;
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen = new RedPacketGameParticleHbSmallScreen();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_hb_smallscreen.png"));
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen.a(255);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleHbSmallScreen.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_AndroidOsVibrator.vibrate(200L);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameSmallScreenView
 * JD-Core Version:    0.7.0.1
 */