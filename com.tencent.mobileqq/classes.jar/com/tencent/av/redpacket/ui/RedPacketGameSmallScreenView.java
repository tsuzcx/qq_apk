package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.av.redpacket.AVRedPacketManager;
import lkj;
import lkn;
import lks;
import lla;

public class RedPacketGameSmallScreenView
  extends View
{
  public Paint a;
  public Vibrator a;
  public lks a;
  public boolean a;
  public lkj[] a;
  public lkn[] a;
  public lla[] a;
  
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
    if (this.jdField_a_of_type_ArrayOfLkj != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLkj.length)
      {
        if (this.jdField_a_of_type_ArrayOfLkj[i] != null) {
          this.jdField_a_of_type_ArrayOfLkj[i].b();
        }
        this.jdField_a_of_type_ArrayOfLkj[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLkj = null;
    if (this.jdField_a_of_type_Lks != null) {
      this.jdField_a_of_type_Lks.b();
    }
    this.jdField_a_of_type_Lks = null;
    if (this.jdField_a_of_type_ArrayOfLla != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLla.length)
      {
        if (this.jdField_a_of_type_ArrayOfLla[i] != null) {
          this.jdField_a_of_type_ArrayOfLla[i].a();
        }
        this.jdField_a_of_type_ArrayOfLla[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLla = null;
    if (this.jdField_a_of_type_ArrayOfLkn != null)
    {
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfLkn.length)
      {
        if (this.jdField_a_of_type_ArrayOfLkn[i] != null) {
          this.jdField_a_of_type_ArrayOfLkn[i].b();
        }
        this.jdField_a_of_type_ArrayOfLkn[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLkn = null;
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
        if (i >= this.jdField_a_of_type_ArrayOfLkj.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLkj[i].a(paramLong);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLkn.length)
      {
        this.jdField_a_of_type_ArrayOfLkn[j].a(paramLong);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lks.a(paramLong);
  }
  
  public void a(Context paramContext)
  {
    setId(2131306751);
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
        if (i >= this.jdField_a_of_type_ArrayOfLkn.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLkn[i].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLkj.length)
      {
        this.jdField_a_of_type_ArrayOfLkj[j].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lks.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
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
        if (i >= this.jdField_a_of_type_ArrayOfLkj.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLkj[i].b(paramInt1, paramInt2, paramInt3, paramInt4);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLkn.length)
      {
        this.jdField_a_of_type_ArrayOfLkn[j].b(paramInt1, paramInt2, paramInt3, paramInt4);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lks.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAVRedPacketManager(AVRedPacketManager paramAVRedPacketManager, boolean paramBoolean)
  {
    int j = 0;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfLkj = new lkj[2];
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLkj.length)
      {
        this.jdField_a_of_type_ArrayOfLkj[i] = new lkj();
        this.jdField_a_of_type_ArrayOfLkj[i].b(i);
        this.jdField_a_of_type_ArrayOfLkj[i].jdField_a_of_type_Long = (i * 2000 + l);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfLkj[0].jdField_a_of_type_Lla = new lla(paramAVRedPacketManager.a("qav_redpacket_emoji_6.png"));
      this.jdField_a_of_type_ArrayOfLkj[1].jdField_a_of_type_Lla = new lla(paramAVRedPacketManager.a("qav_redpacket_emoji_9.png"));
      this.jdField_a_of_type_ArrayOfLla = new lla[6];
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLla.length)
      {
        this.jdField_a_of_type_ArrayOfLla[i] = new lla(paramAVRedPacketManager.a("qav_redpacket_focus_" + i * 6 + ".png"));
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfLkn = new lkn[2];
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfLkn.length)
      {
        this.jdField_a_of_type_ArrayOfLkn[i] = new lkn(this.jdField_a_of_type_ArrayOfLkj[i]);
        this.jdField_a_of_type_ArrayOfLkn[i].c = this.jdField_a_of_type_ArrayOfLla;
        i += 1;
      }
    }
    this.jdField_a_of_type_Lks = new lks();
    this.jdField_a_of_type_Lks.jdField_a_of_type_Lla = new lla(paramAVRedPacketManager.a("qav_redpacket_hb_smallscreen.png"));
    this.jdField_a_of_type_Lks.a(255);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    this.jdField_a_of_type_Lks.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_AndroidOsVibrator.vibrate(200L);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameSmallScreenView
 * JD-Core Version:    0.7.0.1
 */