package com.tencent.ditto.area;

import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import com.tencent.ditto.shell.LayoutAttrSet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DittoAreaGroup
  extends DittoArea
{
  private final List<DittoArea> mChildren = new ArrayList();
  private DittoArea touchedArea = null;
  
  public DittoAreaGroup(DittoHost paramDittoHost)
  {
    super(paramDittoHost);
  }
  
  public DittoAreaGroup(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    super(paramDittoHost, paramLayoutAttrSet);
  }
  
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3)
  {
    return getChildMeasureSpec(paramInt1, paramInt2, paramInt3, null);
  }
  
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, DittoArea paramDittoArea)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2);
    paramInt2 = 1073741824;
    if (i != -2147483648)
    {
      if (i != 0)
      {
        if (i != 1073741824) {
          break label139;
        }
        if (paramInt3 >= 0) {
          break label114;
        }
        if (paramInt3 == -1) {
          break label141;
        }
        if (paramInt3 != -2) {
          break label139;
        }
        if ((paramDittoArea == null) || (!"yellowdiamond_container".equals(paramDittoArea.getId()))) {
          break label124;
        }
      }
      else
      {
        if (paramInt3 >= 0) {
          break label114;
        }
        if (paramInt3 != -1) {
          break label101;
        }
      }
      for (;;)
      {
        paramInt1 = 0;
        paramInt2 = 0;
        break label141;
        label101:
        if (paramInt3 != -2) {
          break;
        }
      }
    }
    else
    {
      if (paramInt3 < 0) {
        break label119;
      }
    }
    label114:
    paramInt1 = paramInt3;
    break label141;
    label119:
    if (paramInt3 == -1) {}
    label124:
    while (paramInt3 == -2)
    {
      paramInt2 = -2147483648;
      break;
    }
    label139:
    paramInt1 = 0;
    label141:
    return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
  }
  
  private boolean inRange(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 >= paramFloat2) && (paramFloat1 <= paramFloat3);
  }
  
  public void addChild(DittoArea paramDittoArea)
  {
    addChild(paramDittoArea, null);
  }
  
  public void addChild(DittoArea paramDittoArea, LayoutAttrSet paramLayoutAttrSet)
  {
    if (paramLayoutAttrSet != null) {
      paramDittoArea.setLayoutAttr(paramLayoutAttrSet);
    }
    this.mChildren.add(paramDittoArea);
    paramDittoArea.mParent = new WeakReference(this);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    DittoArea localDittoArea;
    if (paramMotionEvent.getAction() == 3)
    {
      localDittoArea = this.touchedArea;
      if (localDittoArea != null)
      {
        localDittoArea.dispatchTouchEvent(paramMotionEvent);
        this.touchedArea = null;
      }
    }
    int i = this.mChildren.size() - 1;
    while (i >= 0)
    {
      localDittoArea = (DittoArea)this.mChildren.get(i);
      if (localDittoArea.getVisibility() != 8)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = getPaddingLeft();
        float f3 = paramMotionEvent.getY();
        float f4 = getPaddingTop();
        if ((inRange(f1 - f2, localDittoArea.mLeft, localDittoArea.mRight)) && (inRange(f3 - f4, localDittoArea.mTop, localDittoArea.mBottom)))
        {
          MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
          localMotionEvent.offsetLocation(-localDittoArea.mLeft - getPaddingLeft(), -localDittoArea.mTop - getPaddingTop());
          if (localDittoArea.dispatchTouchEvent(localMotionEvent))
          {
            localMotionEvent.recycle();
            if (paramMotionEvent.getAction() == 0) {
              this.touchedArea = localDittoArea;
            }
            return true;
          }
          localMotionEvent.recycle();
        }
        else if ((localDittoArea == this.touchedArea) && (paramMotionEvent.getAction() == 1))
        {
          this.touchedArea.dispatchTouchEventOutside();
          this.touchedArea = null;
        }
      }
      i -= 1;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void dispatchTouchEventOutside()
  {
    int i = this.mChildren.size() - 1;
    while (i >= 0)
    {
      DittoArea localDittoArea = (DittoArea)this.mChildren.get(i);
      if ((localDittoArea != null) && (localDittoArea.getVisibility() != 8)) {
        localDittoArea.dispatchTouchEventOutside();
      }
      i -= 1;
    }
  }
  
  public DittoArea findChildById(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.mChildren.iterator();
    while (localIterator.hasNext())
    {
      DittoArea localDittoArea = (DittoArea)localIterator.next();
      if (paramString.equals(localDittoArea.id)) {
        return localDittoArea;
      }
      if ((localDittoArea instanceof DittoAreaGroup))
      {
        localDittoArea = ((DittoAreaGroup)localDittoArea).findChildById(paramString);
        if (localDittoArea != null) {
          return localDittoArea;
        }
      }
    }
    return null;
  }
  
  public DittoArea findTarget(float paramFloat1, float paramFloat2)
  {
    int i;
    if (super.findTarget(paramFloat1, paramFloat2) != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      float f1 = getLeft();
      float f2 = getPaddingLeft();
      float f3 = getTop();
      float f4 = getPaddingTop();
      Iterator localIterator = this.mChildren.iterator();
      while (localIterator.hasNext())
      {
        DittoArea localDittoArea = (DittoArea)localIterator.next();
        if (localDittoArea.getVisibility() == 0) {
          localDittoArea = localDittoArea.findTarget(paramFloat1 - f1 - f2, paramFloat2 - f3 - f4);
        } else {
          localDittoArea = null;
        }
        if (localDittoArea != null) {
          return localDittoArea;
        }
      }
    }
    return null;
  }
  
  public DittoArea getChildAt(int paramInt)
  {
    return (DittoArea)this.mChildren.get(paramInt);
  }
  
  public int getChildCount()
  {
    return this.mChildren.size();
  }
  
  public List<DittoArea> getChildren()
  {
    return new ArrayList(this.mChildren);
  }
  
  public boolean isEmpty()
  {
    Iterator localIterator = this.mChildren.iterator();
    while (localIterator.hasNext()) {
      if (((DittoArea)localIterator.next()).getVisibility() == 0) {
        return false;
      }
    }
    return true;
  }
  
  public void measureChild(DittoArea paramDittoArea, int paramInt1, int paramInt2)
  {
    LayoutAttrSet localLayoutAttrSet = paramDittoArea.getLayoutAttr();
    paramDittoArea.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutAttrSet.width), getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localLayoutAttrSet.height));
  }
  
  public void measureChildWithMargins(DittoArea paramDittoArea, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutAttrSet localLayoutAttrSet = paramDittoArea.getLayoutAttr();
    paramDittoArea.measure(getChildMeasureSpec(paramInt1, localLayoutAttrSet.leftMargin + localLayoutAttrSet.rightMargin + paramInt2, localLayoutAttrSet.width), getChildMeasureSpec(paramInt3, localLayoutAttrSet.topMargin + localLayoutAttrSet.bottomMargin + paramInt4, localLayoutAttrSet.height));
  }
  
  public void measureChildren(int paramInt1, int paramInt2)
  {
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      DittoArea localDittoArea = (DittoArea)this.mChildren.get(i);
      if (localDittoArea.getVisibility() != 8) {
        measureChild(localDittoArea, paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    Iterator localIterator = this.mChildren.iterator();
    while (localIterator.hasNext())
    {
      DittoArea localDittoArea = (DittoArea)localIterator.next();
      if (localDittoArea.getVisibility() == 0)
      {
        paramCanvas.translate(localDittoArea.getLeft(), localDittoArea.getTop());
        localDittoArea.draw(paramCanvas);
        paramCanvas.translate(-localDittoArea.getLeft(), -localDittoArea.getTop());
      }
    }
    paramCanvas.restoreToCount(i);
  }
  
  public void removeAllChildren()
  {
    this.mChildren.clear();
    this.mHost.removeAccessibilityArea(this.mChildren);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.area.DittoAreaGroup
 * JD-Core Version:    0.7.0.1
 */