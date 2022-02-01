package com.tencent.mobileqq.bubble;

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
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.item.PttConstants;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
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
  private static int jdField_d_of_type_Int = jdField_c_of_type_Int;
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int;
  private DashPathEffect jdField_a_of_type_AndroidGraphicsDashPathEffect = new DashPathEffect(new float[] { 2.0F, 6.0F }, 0.0F);
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ChatXListView.OnBottomOverScrollListener jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener;
  private ChatXListView.OnLayoutListener jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnLayoutListener;
  public ChatXListView.OnMeasureListener a;
  private ChatXListView.OnTouchEventConsumer jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnTouchEventConsumer;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean = true;
  
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
    if ((jdField_d_of_type_Int == jdField_c_of_type_Int) && ((paramContext instanceof Activity))) {
      ThreadManager.post(new ChatXListView.1(this, paramContext), 5, null, true);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return;
    }
    if (!BaseChatItemLayout.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(15);
    if (localObject == null) {
      return;
    }
    if (!((AIOLongShotHelper)localObject).a()) {
      return;
    }
    a(paramCanvas, (AIOLongShotHelper)localObject);
    if (getChildCount() > 0)
    {
      localObject = getChildAt(getChildCount() - 1);
      if (((View)localObject).getBottom() < getBottom()) {
        a(paramCanvas, ((View)localObject).getLeft(), ((View)localObject).getBottom(), ((View)localObject).getRight(), getBottom());
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
  
  private void a(Canvas paramCanvas, AIOLongShotHelper paramAIOLongShotHelper)
  {
    int i = 0;
    while (i < getChildCount())
    {
      int j = getFirstVisiblePosition() + i;
      Object localObject = getAdapter().getItem(j);
      View localView = getChildAt(i);
      if (!(localObject instanceof ChatMessage))
      {
        a(paramCanvas, localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      }
      else if (!paramAIOLongShotHelper.a((ChatMessage)localObject))
      {
        a(paramCanvas, localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      }
      else
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-5196865);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
        this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(this.jdField_a_of_type_AndroidGraphicsDashPathEffect);
        int k = j - 1;
        if (k >= 0)
        {
          localObject = getAdapter().getItem(k);
          if ((localObject instanceof ChatMessage))
          {
            bool1 = paramAIOLongShotHelper.a((ChatMessage)localObject);
            break label202;
          }
        }
        boolean bool1 = false;
        label202:
        j += 1;
        if (j < getAdapter().getCount())
        {
          localObject = getAdapter().getItem(j);
          if ((localObject instanceof ChatMessage))
          {
            bool2 = paramAIOLongShotHelper.a((ChatMessage)localObject);
            break label260;
          }
        }
        boolean bool2 = false;
        label260:
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
        if (!bool2)
        {
          this.jdField_a_of_type_AndroidGraphicsPath.reset();
          this.jdField_a_of_type_AndroidGraphicsPath.moveTo(localView.getLeft() + 1, localView.getBottom() - 1);
          this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localView.getRight() - 1, localView.getBottom() - 1);
          paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
      i += 1;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Float == -1.0F) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener.k())) {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
    }
  }
  
  private void a(MotionEvent paramMotionEvent, int paramInt)
  {
    float f = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Float - f > jdField_d_of_type_Int)
    {
      int k = paramMotionEvent.getFlags();
      int j = 0;
      int i = j;
      if ((k & 0x2) != 0)
      {
        i = j;
        if (paramMotionEvent.getToolType(0) == 0) {
          i = 1;
        }
      }
      if ((!PttConstants.jdField_a_of_type_Boolean) && (i == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener.ab();
        this.jdField_a_of_type_Float = -1.0F;
      }
    }
    if ((paramInt == 1) || (paramInt == 3))
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener.ac();
      this.jdField_a_of_type_Float = -1.0F;
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return;
    }
    if (!BaseChatItemLayout.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(15);
    if (localObject == null) {
      return;
    }
    if (!((AIOLongShotHelper)localObject).a()) {
      return;
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
  
  private void c(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDisableLayoutChanged() called with: mHasPendingLayout = [");
        localStringBuilder.append(this.jdField_c_of_type_Boolean);
        localStringBuilder.append("]");
        QLog.d("XListView", 2, localStringBuilder.toString());
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
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      Object localObject = getChildAt(i);
      if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof PttItemBuilder.Holder)))
      {
        localObject = (PttItemBuilder.Holder)((View)localObject).getTag();
        if (((PttItemBuilder.Holder)localObject).a())
        {
          Rect localRect = new Rect();
          ((PttItemBuilder.Holder)localObject).a(localRect);
          if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
            return true;
          }
        }
      }
      i -= 1;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener != null) {
      if (i == 0) {
        a(paramMotionEvent);
      } else if ((i == 1) || (i == 3) || (i == 2)) {
        a(paramMotionEvent, i);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
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
  
  public void offsetChildrenTopAndBottomWrap(int paramInt)
  {
    super.offsetChildrenTopAndBottomWrap(paramInt);
    if (paramInt != 0)
    {
      BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localBaseChatPie != null) {
        localBaseChatPie.i(paramInt);
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    Object localObject = new Rect();
    paramAccessibilityNodeInfo.getBoundsInScreen((Rect)localObject);
    ((Rect)localObject).bottom -= this.mListPadding.bottom;
    paramAccessibilityNodeInfo.setBoundsInScreen((Rect)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInitializeAccessibilityNodeInfo() called with: info = [");
      ((StringBuilder)localObject).append(paramAccessibilityNodeInfo);
      ((StringBuilder)localObject).append("]");
      QLog.d("XListView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ChatXListView.OnTouchEventConsumer localOnTouchEventConsumer = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnTouchEventConsumer;
    if ((localOnTouchEventConsumer != null) && (localOnTouchEventConsumer.a(paramMotionEvent))) {
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      if (PttConstants.jdField_a_of_type_Boolean) {
        return false;
      }
      if (a(paramMotionEvent))
      {
        PttConstants.jdField_a_of_type_Boolean = true;
        return false;
      }
    }
    else
    {
      PttConstants.jdField_a_of_type_Boolean = false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    c();
    ChatXListView.OnLayoutListener localOnLayoutListener = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnLayoutListener;
    if (localOnLayoutListener != null) {
      localOnLayoutListener.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      setMeasuredDimension(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    ChatXListView.OnMeasureListener localOnMeasureListener = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnMeasureListener;
    if (localOnMeasureListener != null) {
      localOnMeasureListener.a();
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt2 - paramInt4;
    if (paramInt1 != 0)
    {
      BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localBaseChatPie != null) {
        localBaseChatPie.i(-paramInt1);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ChatXListView.OnTouchEventConsumer localOnTouchEventConsumer = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnTouchEventConsumer;
    if ((localOnTouchEventConsumer != null) && (localOnTouchEventConsumer.b(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChatPie(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
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
  
  public void setOnLayoutListener(ChatXListView.OnLayoutListener paramOnLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnLayoutListener = paramOnLayoutListener;
  }
  
  public void setOnMeasureListener(ChatXListView.OnMeasureListener paramOnMeasureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnMeasureListener = paramOnMeasureListener;
  }
  
  public void setOnTouchEventConsumer(ChatXListView.OnTouchEventConsumer paramOnTouchEventConsumer)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnTouchEventConsumer = paramOnTouchEventConsumer;
  }
  
  public void setShouldPlayVideo(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setShowPanelListener(ChatXListView.OnBottomOverScrollListener paramOnBottomOverScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener = paramOnBottomOverScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.ChatXListView
 * JD-Core Version:    0.7.0.1
 */