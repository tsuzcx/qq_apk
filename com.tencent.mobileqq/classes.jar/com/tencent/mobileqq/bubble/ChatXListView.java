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
import java.util.ArrayList;
import java.util.Iterator;

public class ChatXListView
  extends FPSXListView
{
  private static int o = 100;
  private static int p = o;
  public ChatXListView.OnMeasureListener a;
  private BaseChatPie b;
  private Paint c = new Paint(1);
  private Path d = new Path();
  private boolean e = false;
  private DashPathEffect f = new DashPathEffect(new float[] { 2.0F, 6.0F }, 0.0F);
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private ArrayList<ChatXListView.OnLayoutListener> k = new ArrayList();
  private ChatXListView.OnTouchEventConsumer l;
  private boolean m = true;
  private ChatXListView.OnBottomOverScrollListener n;
  private float q = -1.0F;
  
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
    if ((p == o) && ((paramContext instanceof Activity))) {
      ThreadManager.post(new ChatXListView.1(this, paramContext), 5, null, true);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (!this.e) {
      return;
    }
    if (this.b == null) {
      return;
    }
    if (!BaseChatItemLayout.ad) {
      return;
    }
    Object localObject = (AIOLongShotHelper)this.b.q(15);
    if (localObject == null) {
      return;
    }
    if (!((AIOLongShotHelper)localObject).c()) {
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
    this.c.setColor(1711474714);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setPathEffect(null);
    paramCanvas.drawRect(paramInt1, paramInt2, paramInt3, paramInt4, this.c);
  }
  
  private void a(Canvas paramCanvas, AIOLongShotHelper paramAIOLongShotHelper)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      int i2 = getFirstVisiblePosition() + i1;
      Object localObject = getAdapter().getItem(i2);
      View localView = getChildAt(i1);
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
        this.c.setColor(-5196865);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(2.0F);
        this.c.setPathEffect(this.f);
        int i3 = i2 - 1;
        if (i3 >= 0)
        {
          localObject = getAdapter().getItem(i3);
          if ((localObject instanceof ChatMessage))
          {
            bool1 = paramAIOLongShotHelper.a((ChatMessage)localObject);
            break label202;
          }
        }
        boolean bool1 = false;
        label202:
        i2 += 1;
        if (i2 < getAdapter().getCount())
        {
          localObject = getAdapter().getItem(i2);
          if ((localObject instanceof ChatMessage))
          {
            bool2 = paramAIOLongShotHelper.a((ChatMessage)localObject);
            break label260;
          }
        }
        boolean bool2 = false;
        label260:
        this.d.reset();
        this.d.moveTo(localView.getLeft() + 1, localView.getTop() + 1);
        this.d.lineTo(localView.getLeft() + 1, localView.getTop() + localView.getHeight() / 2);
        paramCanvas.drawPath(this.d, this.c);
        this.d.reset();
        this.d.moveTo(localView.getRight() - 1, localView.getTop() + 1);
        this.d.lineTo(localView.getRight() - 1, localView.getTop() + localView.getHeight() / 2);
        paramCanvas.drawPath(this.d, this.c);
        if (!bool1)
        {
          this.d.reset();
          this.d.moveTo(localView.getLeft() + 1, localView.getTop() + 1);
          this.d.lineTo(localView.getRight() - 1, localView.getTop() + 1);
          paramCanvas.drawPath(this.d, this.c);
        }
        this.d.reset();
        this.d.moveTo(localView.getLeft() + 1, localView.getTop() + localView.getHeight() / 2);
        this.d.lineTo(localView.getLeft() + 1, localView.getBottom() - 1);
        paramCanvas.drawPath(this.d, this.c);
        this.d.reset();
        this.d.moveTo(localView.getRight() - 1, localView.getTop() + localView.getHeight() / 2);
        this.d.lineTo(localView.getRight() - 1, localView.getBottom() - 1);
        paramCanvas.drawPath(this.d, this.c);
        if (!bool2)
        {
          this.d.reset();
          this.d.moveTo(localView.getLeft() + 1, localView.getBottom() - 1);
          this.d.lineTo(localView.getRight() - 1, localView.getBottom() - 1);
          paramCanvas.drawPath(this.d, this.c);
        }
      }
      i1 += 1;
    }
  }
  
  private void a(MotionEvent paramMotionEvent, int paramInt)
  {
    float f1 = paramMotionEvent.getY();
    if (this.q - f1 > p)
    {
      int i3 = paramMotionEvent.getFlags();
      int i2 = 0;
      int i1 = i2;
      if ((i3 & 0x2) != 0)
      {
        i1 = i2;
        if (paramMotionEvent.getToolType(0) == 0) {
          i1 = 1;
        }
      }
      if ((!PttConstants.b) && (i1 == 0))
      {
        this.n.aN();
        this.q = -1.0F;
      }
    }
    if ((paramInt == 1) || (paramInt == 3))
    {
      this.n.aP();
      this.q = -1.0F;
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if ((this.q == -1.0F) && (this.n.aO())) {
      this.q = paramMotionEvent.getY();
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
        localStringBuilder.append(this.h);
        localStringBuilder.append("]");
        QLog.d("XListView", 2, localStringBuilder.toString());
      }
      if (this.h) {
        requestLayout();
      }
    }
  }
  
  private void f()
  {
    if (this.b == null) {
      return;
    }
    if (!BaseChatItemLayout.ad) {
      return;
    }
    Object localObject = (AIOLongShotHelper)this.b.q(15);
    if (localObject == null) {
      return;
    }
    if (!((AIOLongShotHelper)localObject).c()) {
      return;
    }
    int i1 = 0;
    while (i1 < getChildCount())
    {
      localObject = getAdapter().getItem(getFirstVisiblePosition() + i1);
      if ((localObject instanceof ChatMessage))
      {
        View localView = getChildAt(i1);
        ((ChatMessage)localObject).setViewHeight(localView.getHeight());
      }
      i1 += 1;
    }
  }
  
  private int getSelectionBottomPadding()
  {
    try
    {
      Field localField = AbsListView.class.getDeclaredField("mSelectionBottomPadding");
      localField.setAccessible(true);
      int i1 = localField.getInt(this);
      return i1;
    }
    catch (Exception localException)
    {
      QLog.e("XListView", 1, "getSelectionBottomPadding: ", localException);
    }
    return 0;
  }
  
  public void a(ChatXListView.OnLayoutListener paramOnLayoutListener)
  {
    if (!this.k.contains(paramOnLayoutListener)) {
      this.k.add(paramOnLayoutListener);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return this.m;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      Object localObject = getChildAt(i1);
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
      i1 -= 1;
    }
    return false;
  }
  
  public void b()
  {
    this.mListPadding.bottom = (getSelectionBottomPadding() + getPaddingBottom());
  }
  
  public void b(ChatXListView.OnLayoutListener paramOnLayoutListener)
  {
    this.k.remove(paramOnLayoutListener);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (this.n != null) {
      if (i1 == 0) {
        b(paramMotionEvent);
      } else if ((i1 == 1) || (i1 == 3) || (i1 == 2)) {
        a(paramMotionEvent, i1);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    a(paramCanvas);
  }
  
  public ChatXListView.OnBottomOverScrollListener getShowPanelListener()
  {
    return this.n;
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
      BaseChatPie localBaseChatPie = this.b;
      if (localBaseChatPie != null) {
        localBaseChatPie.n(paramInt);
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
    ChatXListView.OnTouchEventConsumer localOnTouchEventConsumer = this.l;
    if ((localOnTouchEventConsumer != null) && (localOnTouchEventConsumer.a(paramMotionEvent))) {
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      if (PttConstants.b) {
        return false;
      }
      if (a(paramMotionEvent))
      {
        PttConstants.b = true;
        return false;
      }
    }
    else
    {
      PttConstants.b = false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.g)
    {
      this.h = true;
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    f();
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((ChatXListView.OnLayoutListener)localIterator.next()).a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.g)
    {
      this.h = true;
      setMeasuredDimension(this.i, this.j);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    ChatXListView.OnMeasureListener localOnMeasureListener = this.a;
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
      BaseChatPie localBaseChatPie = this.b;
      if (localBaseChatPie != null) {
        localBaseChatPie.n(-paramInt1);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ChatXListView.OnTouchEventConsumer localOnTouchEventConsumer = this.l;
    if ((localOnTouchEventConsumer != null) && (localOnTouchEventConsumer.b(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChatPie(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  public void setDisableLayout(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      this.i = paramInt1;
      this.j = paramInt2;
      c(paramBoolean);
    }
  }
  
  public void setOnMeasureListener(ChatXListView.OnMeasureListener paramOnMeasureListener)
  {
    this.a = paramOnMeasureListener;
  }
  
  public void setOnTouchEventConsumer(ChatXListView.OnTouchEventConsumer paramOnTouchEventConsumer)
  {
    this.l = paramOnTouchEventConsumer;
  }
  
  public void setShouldPlayVideo(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setShowPanelListener(ChatXListView.OnBottomOverScrollListener paramOnBottomOverScrollListener)
  {
    this.n = paramOnBottomOverScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.ChatXListView
 * JD-Core Version:    0.7.0.1
 */