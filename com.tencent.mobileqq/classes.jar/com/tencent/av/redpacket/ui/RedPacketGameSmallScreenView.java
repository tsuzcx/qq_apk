package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.av.redpacket.AVRedPacketManager;
import lxc;
import lxg;
import lxl;
import lxt;

public class RedPacketGameSmallScreenView
  extends View
{
  public Paint a;
  public Vibrator a;
  public lxl a;
  public boolean a;
  public lxc[] a;
  public lxg[] a;
  public lxt[] a;
  
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
    if (this.jdField_a_of_type_ArrayOfLxc != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLxc.length)
      {
        if (this.jdField_a_of_type_ArrayOfLxc[i] != null) {
          this.jdField_a_of_type_ArrayOfLxc[i].b();
        }
        this.jdField_a_of_type_ArrayOfLxc[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLxc = null;
    if (this.jdField_a_of_type_Lxl != null) {
      this.jdField_a_of_type_Lxl.b();
    }
    this.jdField_a_of_type_Lxl = null;
    if (this.jdField_a_of_type_ArrayOfLxt != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLxt.length)
      {
        if (this.jdField_a_of_type_ArrayOfLxt[i] != null) {
          this.jdField_a_of_type_ArrayOfLxt[i].a();
        }
        this.jdField_a_of_type_ArrayOfLxt[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLxt = null;
    if (this.jdField_a_of_type_ArrayOfLxg != null)
    {
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfLxg.length)
      {
        if (this.jdField_a_of_type_ArrayOfLxg[i] != null) {
          this.jdField_a_of_type_ArrayOfLxg[i].b();
        }
        this.jdField_a_of_type_ArrayOfLxg[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLxg = null;
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
        if (i >= this.jdField_a_of_type_ArrayOfLxc.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLxc[i].a(paramLong);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLxg.length)
      {
        this.jdField_a_of_type_ArrayOfLxg[j].a(paramLong);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lxl.a(paramLong);
  }
  
  public void a(Context paramContext)
  {
    setId(2131372839);
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
        if (i >= this.jdField_a_of_type_ArrayOfLxg.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLxg[i].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLxc.length)
      {
        this.jdField_a_of_type_ArrayOfLxc[j].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lxl.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
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
        if (i >= this.jdField_a_of_type_ArrayOfLxc.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLxc[i].b(paramInt1, paramInt2, paramInt3, paramInt4);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLxg.length)
      {
        this.jdField_a_of_type_ArrayOfLxg[j].b(paramInt1, paramInt2, paramInt3, paramInt4);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lxl.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAVRedPacketManager(AVRedPacketManager paramAVRedPacketManager, boolean paramBoolean)
  {
    int j = 0;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfLxc = new lxc[2];
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLxc.length)
      {
        this.jdField_a_of_type_ArrayOfLxc[i] = new lxc();
        this.jdField_a_of_type_ArrayOfLxc[i].b(i);
        this.jdField_a_of_type_ArrayOfLxc[i].jdField_a_of_type_Long = (i * 2000 + l);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfLxc[0].jdField_a_of_type_Lxt = new lxt(paramAVRedPacketManager.a("qav_redpacket_emoji_6.png"));
      this.jdField_a_of_type_ArrayOfLxc[1].jdField_a_of_type_Lxt = new lxt(paramAVRedPacketManager.a("qav_redpacket_emoji_9.png"));
      this.jdField_a_of_type_ArrayOfLxt = new lxt[6];
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLxt.length)
      {
        this.jdField_a_of_type_ArrayOfLxt[i] = new lxt(paramAVRedPacketManager.a("qav_redpacket_focus_" + i * 6 + ".png"));
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfLxg = new lxg[2];
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfLxg.length)
      {
        this.jdField_a_of_type_ArrayOfLxg[i] = new lxg(this.jdField_a_of_type_ArrayOfLxc[i]);
        this.jdField_a_of_type_ArrayOfLxg[i].c = this.jdField_a_of_type_ArrayOfLxt;
        i += 1;
      }
    }
    this.jdField_a_of_type_Lxl = new lxl();
    this.jdField_a_of_type_Lxl.jdField_a_of_type_Lxt = new lxt(paramAVRedPacketManager.a("qav_redpacket_hb_smallscreen.png"));
    this.jdField_a_of_type_Lxl.a(255);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    this.jdField_a_of_type_Lxl.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_AndroidOsVibrator.vibrate(200L);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameSmallScreenView
 * JD-Core Version:    0.7.0.1
 */