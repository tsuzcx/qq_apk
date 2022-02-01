package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.av.redpacket.AVRedPacketManager;
import lui;
import lum;
import lur;
import luz;

public class RedPacketGameSmallScreenView
  extends View
{
  public Paint a;
  public Vibrator a;
  public lur a;
  public boolean a;
  public lui[] a;
  public lum[] a;
  public luz[] a;
  
  public RedPacketGameSmallScreenView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    a(paramContext);
  }
  
  public RedPacketGameSmallScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    a(paramContext);
  }
  
  public RedPacketGameSmallScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    a(paramContext);
  }
  
  public void a()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_ArrayOfLui != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLui.length)
      {
        if (this.jdField_a_of_type_ArrayOfLui[i] != null) {
          this.jdField_a_of_type_ArrayOfLui[i].b();
        }
        this.jdField_a_of_type_ArrayOfLui[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLui = null;
    if (this.jdField_a_of_type_Lur != null) {
      this.jdField_a_of_type_Lur.b();
    }
    this.jdField_a_of_type_Lur = null;
    if (this.jdField_a_of_type_ArrayOfLuz != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLuz.length)
      {
        if (this.jdField_a_of_type_ArrayOfLuz[i] != null) {
          this.jdField_a_of_type_ArrayOfLuz[i].a();
        }
        this.jdField_a_of_type_ArrayOfLuz[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLuz = null;
    if (this.jdField_a_of_type_ArrayOfLum != null)
    {
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfLum.length)
      {
        if (this.jdField_a_of_type_ArrayOfLum[i] != null) {
          this.jdField_a_of_type_ArrayOfLum[i].b();
        }
        this.jdField_a_of_type_ArrayOfLum[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLum = null;
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
        if (i >= this.jdField_a_of_type_ArrayOfLui.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLui[i].a(paramLong);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLum.length)
      {
        this.jdField_a_of_type_ArrayOfLum[j].a(paramLong);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lur.a(paramLong);
  }
  
  public void a(Context paramContext)
  {
    setId(2131373494);
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
        if (i >= this.jdField_a_of_type_ArrayOfLum.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLum[i].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLui.length)
      {
        this.jdField_a_of_type_ArrayOfLui[j].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lur.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    long l = System.currentTimeMillis();
    a(l);
    a(paramCanvas, l);
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
        if (i >= this.jdField_a_of_type_ArrayOfLui.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLui[i].b(paramInt1, paramInt2, paramInt3, paramInt4);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLum.length)
      {
        this.jdField_a_of_type_ArrayOfLum[j].b(paramInt1, paramInt2, paramInt3, paramInt4);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lur.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAVRedPacketManager(AVRedPacketManager paramAVRedPacketManager, boolean paramBoolean)
  {
    int j = 0;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfLui = new lui[2];
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLui.length)
      {
        this.jdField_a_of_type_ArrayOfLui[i] = new lui();
        this.jdField_a_of_type_ArrayOfLui[i].b(i);
        this.jdField_a_of_type_ArrayOfLui[i].jdField_a_of_type_Long = (i * 2000 + l);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfLui[0].jdField_a_of_type_Luz = new luz(paramAVRedPacketManager.a("qav_redpacket_emoji_6.png"));
      this.jdField_a_of_type_ArrayOfLui[1].jdField_a_of_type_Luz = new luz(paramAVRedPacketManager.a("qav_redpacket_emoji_9.png"));
      this.jdField_a_of_type_ArrayOfLuz = new luz[6];
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLuz.length)
      {
        this.jdField_a_of_type_ArrayOfLuz[i] = new luz(paramAVRedPacketManager.a("qav_redpacket_focus_" + i * 6 + ".png"));
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfLum = new lum[2];
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfLum.length)
      {
        this.jdField_a_of_type_ArrayOfLum[i] = new lum(this.jdField_a_of_type_ArrayOfLui[i]);
        this.jdField_a_of_type_ArrayOfLum[i].c = this.jdField_a_of_type_ArrayOfLuz;
        i += 1;
      }
    }
    this.jdField_a_of_type_Lur = new lur();
    this.jdField_a_of_type_Lur.jdField_a_of_type_Luz = new luz(paramAVRedPacketManager.a("qav_redpacket_hb_smallscreen.png"));
    this.jdField_a_of_type_Lur.a(255);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    this.jdField_a_of_type_Lur.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_AndroidOsVibrator.vibrate(200L);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameSmallScreenView
 * JD-Core Version:    0.7.0.1
 */