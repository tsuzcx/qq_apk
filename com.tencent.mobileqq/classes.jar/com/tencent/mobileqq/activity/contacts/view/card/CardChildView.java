package com.tencent.mobileqq.activity.contacts.view.card;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

@TargetApi(14)
public class CardChildView
  extends FrameLayout
{
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private boolean jdField_a_of_type_Boolean = true;
  
  public CardChildView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CardChildView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CardChildView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsRect != null)) {
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRect);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void setClipRecet(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setClipRectArea(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.card.CardChildView
 * JD-Core Version:    0.7.0.1
 */