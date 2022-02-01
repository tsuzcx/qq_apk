package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.av.redpacket.AVRedPacketManager;
import lue;
import lui;
import lun;
import luv;

public class RedPacketGameSmallScreenView
  extends View
{
  public Paint a;
  public Vibrator a;
  public lun a;
  public boolean a;
  public lue[] a;
  public lui[] a;
  public luv[] a;
  
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
    if (this.jdField_a_of_type_ArrayOfLue != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLue.length)
      {
        if (this.jdField_a_of_type_ArrayOfLue[i] != null) {
          this.jdField_a_of_type_ArrayOfLue[i].b();
        }
        this.jdField_a_of_type_ArrayOfLue[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLue = null;
    if (this.jdField_a_of_type_Lun != null) {
      this.jdField_a_of_type_Lun.b();
    }
    this.jdField_a_of_type_Lun = null;
    if (this.jdField_a_of_type_ArrayOfLuv != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLuv.length)
      {
        if (this.jdField_a_of_type_ArrayOfLuv[i] != null) {
          this.jdField_a_of_type_ArrayOfLuv[i].a();
        }
        this.jdField_a_of_type_ArrayOfLuv[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLuv = null;
    if (this.jdField_a_of_type_ArrayOfLui != null)
    {
      i = j;
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
        if (i >= this.jdField_a_of_type_ArrayOfLue.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLue[i].a(paramLong);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLui.length)
      {
        this.jdField_a_of_type_ArrayOfLui[j].a(paramLong);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lun.a(paramLong);
  }
  
  public void a(Context paramContext)
  {
    setId(2131373454);
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
        if (i >= this.jdField_a_of_type_ArrayOfLui.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLui[i].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLue.length)
      {
        this.jdField_a_of_type_ArrayOfLue[j].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lun.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
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
        if (i >= this.jdField_a_of_type_ArrayOfLue.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLue[i].b(paramInt1, paramInt2, paramInt3, paramInt4);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLui.length)
      {
        this.jdField_a_of_type_ArrayOfLui[j].b(paramInt1, paramInt2, paramInt3, paramInt4);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lun.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAVRedPacketManager(AVRedPacketManager paramAVRedPacketManager, boolean paramBoolean)
  {
    int j = 0;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfLue = new lue[2];
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLue.length)
      {
        this.jdField_a_of_type_ArrayOfLue[i] = new lue();
        this.jdField_a_of_type_ArrayOfLue[i].b(i);
        this.jdField_a_of_type_ArrayOfLue[i].jdField_a_of_type_Long = (i * 2000 + l);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfLue[0].jdField_a_of_type_Luv = new luv(paramAVRedPacketManager.a("qav_redpacket_emoji_6.png"));
      this.jdField_a_of_type_ArrayOfLue[1].jdField_a_of_type_Luv = new luv(paramAVRedPacketManager.a("qav_redpacket_emoji_9.png"));
      this.jdField_a_of_type_ArrayOfLuv = new luv[6];
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLuv.length)
      {
        this.jdField_a_of_type_ArrayOfLuv[i] = new luv(paramAVRedPacketManager.a("qav_redpacket_focus_" + i * 6 + ".png"));
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfLui = new lui[2];
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfLui.length)
      {
        this.jdField_a_of_type_ArrayOfLui[i] = new lui(this.jdField_a_of_type_ArrayOfLue[i]);
        this.jdField_a_of_type_ArrayOfLui[i].c = this.jdField_a_of_type_ArrayOfLuv;
        i += 1;
      }
    }
    this.jdField_a_of_type_Lun = new lun();
    this.jdField_a_of_type_Lun.jdField_a_of_type_Luv = new luv(paramAVRedPacketManager.a("qav_redpacket_hb_smallscreen.png"));
    this.jdField_a_of_type_Lun.a(255);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    this.jdField_a_of_type_Lun.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_AndroidOsVibrator.vibrate(200L);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameSmallScreenView
 * JD-Core Version:    0.7.0.1
 */