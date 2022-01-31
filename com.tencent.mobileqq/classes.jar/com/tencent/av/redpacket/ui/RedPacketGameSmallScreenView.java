package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.av.redpacket.AVRedPacketManager;
import lva;
import lve;
import lvj;
import lvr;

public class RedPacketGameSmallScreenView
  extends View
{
  public Paint a;
  public Vibrator a;
  public lvj a;
  public boolean a;
  public lva[] a;
  public lve[] a;
  public lvr[] a;
  
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
    if (this.jdField_a_of_type_ArrayOfLva != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLva.length)
      {
        if (this.jdField_a_of_type_ArrayOfLva[i] != null) {
          this.jdField_a_of_type_ArrayOfLva[i].b();
        }
        this.jdField_a_of_type_ArrayOfLva[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLva = null;
    if (this.jdField_a_of_type_Lvj != null) {
      this.jdField_a_of_type_Lvj.b();
    }
    this.jdField_a_of_type_Lvj = null;
    if (this.jdField_a_of_type_ArrayOfLvr != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLvr.length)
      {
        if (this.jdField_a_of_type_ArrayOfLvr[i] != null) {
          this.jdField_a_of_type_ArrayOfLvr[i].a();
        }
        this.jdField_a_of_type_ArrayOfLvr[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLvr = null;
    if (this.jdField_a_of_type_ArrayOfLve != null)
    {
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfLve.length)
      {
        if (this.jdField_a_of_type_ArrayOfLve[i] != null) {
          this.jdField_a_of_type_ArrayOfLve[i].b();
        }
        this.jdField_a_of_type_ArrayOfLve[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfLve = null;
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
        if (i >= this.jdField_a_of_type_ArrayOfLva.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLva[i].a(paramLong);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLve.length)
      {
        this.jdField_a_of_type_ArrayOfLve[j].a(paramLong);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lvj.a(paramLong);
  }
  
  public void a(Context paramContext)
  {
    setId(2131372455);
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
        if (i >= this.jdField_a_of_type_ArrayOfLve.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLve[i].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLva.length)
      {
        this.jdField_a_of_type_ArrayOfLva[j].a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lvj.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
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
        if (i >= this.jdField_a_of_type_ArrayOfLva.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfLva[i].b(paramInt1, paramInt2, paramInt3, paramInt4);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfLve.length)
      {
        this.jdField_a_of_type_ArrayOfLve[j].b(paramInt1, paramInt2, paramInt3, paramInt4);
        j += 1;
      }
    }
    this.jdField_a_of_type_Lvj.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAVRedPacketManager(AVRedPacketManager paramAVRedPacketManager, boolean paramBoolean)
  {
    int j = 0;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfLva = new lva[2];
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLva.length)
      {
        this.jdField_a_of_type_ArrayOfLva[i] = new lva();
        this.jdField_a_of_type_ArrayOfLva[i].b(i);
        this.jdField_a_of_type_ArrayOfLva[i].jdField_a_of_type_Long = (i * 2000 + l);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfLva[0].jdField_a_of_type_Lvr = new lvr(paramAVRedPacketManager.a("qav_redpacket_emoji_6.png"));
      this.jdField_a_of_type_ArrayOfLva[1].jdField_a_of_type_Lvr = new lvr(paramAVRedPacketManager.a("qav_redpacket_emoji_9.png"));
      this.jdField_a_of_type_ArrayOfLvr = new lvr[6];
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfLvr.length)
      {
        this.jdField_a_of_type_ArrayOfLvr[i] = new lvr(paramAVRedPacketManager.a("qav_redpacket_focus_" + i * 6 + ".png"));
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfLve = new lve[2];
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfLve.length)
      {
        this.jdField_a_of_type_ArrayOfLve[i] = new lve(this.jdField_a_of_type_ArrayOfLva[i]);
        this.jdField_a_of_type_ArrayOfLve[i].c = this.jdField_a_of_type_ArrayOfLvr;
        i += 1;
      }
    }
    this.jdField_a_of_type_Lvj = new lvj();
    this.jdField_a_of_type_Lvj.jdField_a_of_type_Lvr = new lvr(paramAVRedPacketManager.a("qav_redpacket_hb_smallscreen.png"));
    this.jdField_a_of_type_Lvj.a(255);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    this.jdField_a_of_type_Lvj.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_AndroidOsVibrator.vibrate(200L);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameSmallScreenView
 * JD-Core Version:    0.7.0.1
 */