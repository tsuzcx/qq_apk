package com.tencent.mobileqq.bubble;

import adwu;
import adwv;
import amci;
import amcj;
import amck;
import amcl;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.reflect.Field;

public class ChatXListView
  extends FPSXListView
{
  private static int jdField_c_of_type_Int = 100;
  private static int d = jdField_c_of_type_Int;
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int;
  private amci jdField_a_of_type_Amci;
  private amcj jdField_a_of_type_Amcj;
  public amck a;
  private amcl jdField_a_of_type_Amcl;
  private DashPathEffect jdField_a_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(new float[] { 2.0F, 6.0F }, 0.0F);
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
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
    if ((d == jdField_c_of_type_Int) && ((paramContext instanceof Activity))) {
      ThreadManager.post(new ChatXListView.1(this, paramContext), 5, null, true);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    label7:
    Object localObject1;
    do
    {
      break label7;
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!BaseChatItemLayout.jdField_a_of_type_Boolean));
      localObject1 = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(15);
    } while ((localObject1 == null) || (!((AIOLongShotHelper)localObject1).a()));
    int i = 0;
    int j;
    Object localObject2;
    View localView;
    if (i < getChildCount())
    {
      j = getFirstVisiblePosition() + i;
      localObject2 = getAdapter().getItem(j);
      localView = getChildAt(i);
      if (!(localObject2 instanceof ChatMessage)) {
        a(paramCanvas, localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      }
      for (;;)
      {
        label117:
        i += 1;
        break;
        if (((AIOLongShotHelper)localObject1).a((ChatMessage)localObject2)) {
          break label165;
        }
        a(paramCanvas, localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      }
      label165:
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-5196865);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(this.jdField_a_of_type_AndroidGraphicsDashPathEffect);
      if (j - 1 < 0) {
        break label782;
      }
      localObject2 = getAdapter().getItem(j - 1);
      if (!(localObject2 instanceof ChatMessage)) {
        break label782;
      }
    }
    label782:
    for (boolean bool1 = ((AIOLongShotHelper)localObject1).a((ChatMessage)localObject2);; bool1 = false)
    {
      if (j + 1 < getAdapter().getCount())
      {
        localObject2 = getAdapter().getItem(j + 1);
        if (!(localObject2 instanceof ChatMessage)) {}
      }
      for (boolean bool2 = ((AIOLongShotHelper)localObject1).a((ChatMessage)localObject2);; bool2 = false)
      {
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(localView.getLeft() + 1, localView.getTop() + 1);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localView.getLeft() + 1, localView.getTop() + localView.getHeight() / 2);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(localView.getRight() - 1, localView.getTop() + 1);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localView.getRight() - 1, localView.getTop() + localView.getHeight() / 2);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        if (!bool1)
        {
          this.jdField_a_of_type_AndroidGraphicsPath.reset();
          this.jdField_a_of_type_AndroidGraphicsPath.moveTo(localView.getLeft() + 1, localView.getTop() + 1);
          this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localView.getRight() - 1, localView.getTop() + 1);
          paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(localView.getLeft() + 1, localView.getTop() + localView.getHeight() / 2);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localView.getLeft() + 1, localView.getBottom() - 1);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(localView.getRight() - 1, localView.getTop() + localView.getHeight() / 2);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localView.getRight() - 1, localView.getBottom() - 1);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        if (bool2) {
          break label117;
        }
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(localView.getLeft() + 1, localView.getBottom() - 1);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localView.getRight() - 1, localView.getBottom() - 1);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        break label117;
        if (getChildCount() <= 0) {
          break;
        }
        localObject1 = getChildAt(getChildCount() - 1);
        if (((View)localObject1).getBottom() >= getBottom()) {
          break;
        }
        a(paramCanvas, ((View)localObject1).getLeft(), ((View)localObject1).getBottom(), ((View)localObject1).getRight(), getBottom());
        return;
      }
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1711474714);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(null);
    paramCanvas.drawRect(paramInt1, paramInt2, paramInt3, paramInt4, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private int c()
  {
    try
    {
      Field localField = AbsListView.class.getDeclaredField("mSelectionBottomPadding");
      localField.setAccessible(true);
      int i = localField.getInt(this);
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("XListView", 1, "getSelectionBottomPadding: ", localException);
    }
    return 0;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (BaseChatItemLayout.jdField_a_of_type_Boolean)
      {
        Object localObject = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(15);
        if ((localObject == null) || (!((AIOLongShotHelper)localObject).a())) {
          break;
        }
        int i = 0;
        while (i < getChildCount())
        {
          localObject = getAdapter().getItem(getFirstVisiblePosition() + i);
          if ((localObject instanceof ChatMessage))
          {
            View localView = getChildAt(i);
            ((ChatMessage)localObject).setViewHeight(localView.getHeight());
          }
          i += 1;
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XListView", 2, "onDisableLayoutChanged() called with: mHasPendingLayout = [" + this.jdField_c_of_type_Boolean + "]");
      }
      if (this.jdField_c_of_type_Boolean) {
        requestLayout();
      }
    }
  }
  
  public void a()
  {
    this.mListPadding.bottom = (c() + getPaddingBottom());
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      if ((localView.getTag() != null) && ((localView.getTag() instanceof adwu)) && (((adwu)localView.getTag()).a()))
      {
        Rect localRect = new Rect();
        localView.getGlobalVisibleRect(localRect);
        if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          return true;
        }
      }
      i -= 1;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int k = paramMotionEvent.getAction();
    if (this.jdField_a_of_type_Amci != null)
    {
      if (k != 0) {
        break label57;
      }
      if ((this.jdField_a_of_type_Float != -1.0F) || (!this.jdField_a_of_type_Amci.s())) {}
    }
    for (this.jdField_a_of_type_Float = paramMotionEvent.getY();; this.jdField_a_of_type_Float = -1.0F)
    {
      label57:
      do
      {
        do
        {
          return super.dispatchTouchEvent(paramMotionEvent);
        } while ((k != 1) && (k != 3) && (k != 2));
        float f = paramMotionEvent.getY();
        if (this.jdField_a_of_type_Float - f > d)
        {
          int i = j;
          if ((paramMotionEvent.getFlags() & 0x2) != 0)
          {
            i = j;
            if (paramMotionEvent.getToolType(0) == 0) {
              i = 1;
            }
          }
          if ((!adwv.jdField_a_of_type_Boolean) && (i == 0))
          {
            this.jdField_a_of_type_Amci.aH();
            this.jdField_a_of_type_Float = -1.0F;
          }
        }
      } while ((k != 1) && (k != 3));
      this.jdField_a_of_type_Amci.aI();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    a(paramCanvas);
  }
  
  public boolean isInEditMode()
  {
    return true;
  }
  
  public void offsetChildrenTopAndBottom(int paramInt)
  {
    super.offsetChildrenTopAndBottom(paramInt);
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.r(paramInt);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Rect localRect = new Rect();
    paramAccessibilityNodeInfo.getBoundsInScreen(localRect);
    localRect.bottom -= this.mListPadding.bottom;
    paramAccessibilityNodeInfo.setBoundsInScreen(localRect);
    if (QLog.isColorLevel()) {
      QLog.d("XListView", 2, "onInitializeAccessibilityNodeInfo() called with: info = [" + paramAccessibilityNodeInfo + "]");
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Amcl != null) && (this.jdField_a_of_type_Amcl.a(paramMotionEvent))) {
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      if (adwv.jdField_a_of_type_Boolean) {
        return false;
      }
      if (a(paramMotionEvent))
      {
        adwv.jdField_a_of_type_Boolean = true;
        return false;
      }
    }
    else
    {
      adwv.jdField_a_of_type_Boolean = false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = true;
    }
    do
    {
      return;
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      c();
    } while (this.jdField_a_of_type_Amcj == null);
    this.jdField_a_of_type_Amcj.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      setMeasuredDimension(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    do
    {
      return;
      super.onMeasure(paramInt1, paramInt2);
    } while (this.jdField_a_of_type_Amck == null);
    this.jdField_a_of_type_Amck.a();
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt2 - paramInt4;
    if ((paramInt1 != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.r(-paramInt1);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Amcl != null) && (this.jdField_a_of_type_Amcl.b(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChatPie(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void setDisableLayout(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      c(paramBoolean);
    }
  }
  
  public void setOnLayoutListener(amcj paramamcj)
  {
    this.jdField_a_of_type_Amcj = paramamcj;
  }
  
  public void setOnMeasureListener(amck paramamck)
  {
    this.jdField_a_of_type_Amck = paramamck;
  }
  
  public void setOnTouchEventConsumer(amcl paramamcl)
  {
    this.jdField_a_of_type_Amcl = paramamcl;
  }
  
  public void setShowPanelListener(amci paramamci)
  {
    this.jdField_a_of_type_Amci = paramamci;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.ChatXListView
 * JD-Core Version:    0.7.0.1
 */