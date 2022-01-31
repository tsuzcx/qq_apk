package com.tencent.gdtad.api.motivevideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class GdtMvAppBtnView
  extends TextView
{
  protected float a;
  protected int a;
  protected Paint a;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public boolean a;
  private boolean b;
  
  public GdtMvAppBtnView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 100;
  }
  
  private void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void a()
  {
    a(false);
    b();
  }
  
  public void a(String paramString)
  {
    try
    {
      int i = Color.parseColor("#00CAFC");
      setSingleLine(false);
      setLines(1);
      setText(paramString);
      a();
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b()
  {
    Drawable localDrawable = null;
    int i = 0;
    if (this.b) {
      if (this.jdField_a_of_type_Boolean)
      {
        localDrawable = getResources().getDrawable(2130839790);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839789);
      }
    }
    while (this.jdField_a_of_type_Boolean)
    {
      setBackgroundDrawable(localDrawable);
      return;
      i = getResources().getColor(2131165403);
      continue;
      if (this.jdField_a_of_type_Boolean) {
        localDrawable = getResources().getDrawable(2130839789);
      } else {
        i = getResources().getColor(2131165411);
      }
    }
    setBackgroundColor(i);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b)
    {
      float f = getWidth() / this.jdField_a_of_type_Int * this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f, getHeight());
      if (this.jdField_a_of_type_Boolean)
      {
        int i = paramCanvas.save();
        if ((paramCanvas.clipRect(0.0F, 0.0F, f, getHeight())) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, getWidth(), getHeight());
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        paramCanvas.restoreToCount(i);
      }
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      return;
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      continue;
      if (!this.jdField_a_of_type_Boolean) {}
    }
  }
  
  public void setDownloadingUI(String paramString)
  {
    a(true);
    b();
    setText(paramString);
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_a_of_type_Float = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvAppBtnView
 * JD-Core Version:    0.7.0.1
 */