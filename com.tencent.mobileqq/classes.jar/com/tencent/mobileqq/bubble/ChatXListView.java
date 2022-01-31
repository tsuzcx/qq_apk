package com.tencent.mobileqq.bubble;

import ablx;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fpsreport.FPSXListView;

public class ChatXListView
  extends FPSXListView
{
  private static int jdField_a_of_type_Int = 100;
  private static int b = jdField_a_of_type_Int;
  private float jdField_a_of_type_Float = -1.0F;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ChatXListView.OnBottomOverScrollListener jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener;
  
  public ChatXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ChatXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ChatXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    if ((b == jdField_a_of_type_Int) && ((paramContext instanceof Activity))) {
      ThreadManager.post(new ablx(this, paramContext), 5, null, true);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener != null)
    {
      if (i != 0) {
        break label52;
      }
      if ((this.jdField_a_of_type_Float != -1.0F) || (!this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener.n())) {}
    }
    for (this.jdField_a_of_type_Float = paramMotionEvent.getY();; this.jdField_a_of_type_Float = -1.0F)
    {
      label52:
      do
      {
        do
        {
          return super.dispatchTouchEvent(paramMotionEvent);
        } while ((i != 1) && (i != 3) && (i != 2));
        float f = paramMotionEvent.getY();
        if (this.jdField_a_of_type_Float - f > b)
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener.aw();
          this.jdField_a_of_type_Float = -1.0F;
        }
      } while ((i != 1) && (i != 3));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener.ax();
    }
  }
  
  public boolean isInEditMode()
  {
    return true;
  }
  
  public void offsetChildrenTopAndBottom(int paramInt)
  {
    super.offsetChildrenTopAndBottom(paramInt);
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n(paramInt);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt2 - paramInt4;
    if ((paramInt1 != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n(-paramInt1);
    }
  }
  
  public void setChatPie(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void setShowPanelListener(ChatXListView.OnBottomOverScrollListener paramOnBottomOverScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener = paramOnBottomOverScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.ChatXListView
 * JD-Core Version:    0.7.0.1
 */