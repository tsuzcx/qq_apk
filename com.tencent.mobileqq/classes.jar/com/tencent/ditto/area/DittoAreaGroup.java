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
    int j = 1073741824;
    int k = 0;
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2);
    switch (m)
    {
    default: 
      paramInt1 = k;
      paramInt2 = j;
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
      if (paramInt3 >= 0)
      {
        paramInt1 = paramInt3;
        paramInt2 = j;
      }
      else if (paramInt3 == -1)
      {
        paramInt1 = i;
        paramInt2 = j;
      }
      else
      {
        paramInt2 = j;
        paramInt1 = k;
        if (paramInt3 == -2) {
          if ((paramDittoArea != null) && ("yellowdiamond_container".equals(paramDittoArea.getId())))
          {
            paramInt2 = 0;
            paramInt1 = i;
          }
          else
          {
            paramInt2 = -2147483648;
            paramInt1 = i;
            continue;
            if (paramInt3 >= 0)
            {
              paramInt1 = paramInt3;
              paramInt2 = j;
            }
            else if (paramInt3 == -1)
            {
              paramInt2 = -2147483648;
              paramInt1 = i;
            }
            else
            {
              paramInt2 = j;
              paramInt1 = k;
              if (paramInt3 == -2)
              {
                paramInt2 = -2147483648;
                paramInt1 = i;
                continue;
                if (paramInt3 >= 0)
                {
                  paramInt1 = paramInt3;
                  paramInt2 = j;
                }
                else if (paramInt3 == -1)
                {
                  paramInt2 = 0;
                  paramInt1 = k;
                }
                else
                {
                  paramInt2 = j;
                  paramInt1 = k;
                  if (paramInt3 == -2)
                  {
                    paramInt2 = 0;
                    paramInt1 = k;
                  }
                }
              }
            }
          }
        }
      }
    }
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
    if ((paramMotionEvent.getAction() == 3) && (this.touchedArea != null))
    {
      this.touchedArea.dispatchTouchEvent(paramMotionEvent);
      this.touchedArea = null;
    }
    int i = this.mChildren.size() - 1;
    if (i >= 0)
    {
      DittoArea localDittoArea = (DittoArea)this.mChildren.get(i);
      if (localDittoArea.getVisibility() == 8) {}
      for (;;)
      {
        i -= 1;
        break;
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
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void dispatchTouchEventOutside()
  {
    int i = this.mChildren.size() - 1;
    if (i >= 0)
    {
      DittoArea localDittoArea = (DittoArea)this.mChildren.get(i);
      if ((localDittoArea == null) || (localDittoArea.getVisibility() == 8)) {}
      for (;;)
      {
        i -= 1;
        break;
        localDittoArea.dispatchTouchEventOutside();
      }
    }
  }
  
  public DittoArea findChildById(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.mChildren.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        DittoArea localDittoArea = (DittoArea)localIterator.next();
        localObject = localDittoArea;
        if (paramString.equals(localDittoArea.id)) {
          break;
        }
        if ((localDittoArea instanceof DittoAreaGroup))
        {
          localObject = ((DittoAreaGroup)localDittoArea).findChildById(paramString);
          if (localObject != null) {
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  public DittoArea findTarget(float paramFloat1, float paramFloat2)
  {
    int i;
    float f1;
    float f2;
    float f3;
    float f4;
    Iterator localIterator;
    if (super.findTarget(paramFloat1, paramFloat2) != null)
    {
      i = 1;
      if (i != 0)
      {
        f1 = getLeft();
        f2 = getPaddingLeft();
        f3 = getTop();
        f4 = getPaddingTop();
        localIterator = this.mChildren.iterator();
      }
    }
    else
    {
      label123:
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label125;
        }
        DittoArea localDittoArea = (DittoArea)localIterator.next();
        if (localDittoArea.getVisibility() == 0) {}
        for (localDittoArea = localDittoArea.findTarget(paramFloat1 - f1 - f2, paramFloat2 - f3 - f4);; localDittoArea = null)
        {
          if (localDittoArea == null) {
            break label123;
          }
          return localDittoArea;
          i = 0;
          break;
        }
      }
    }
    label125:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.area.DittoAreaGroup
 * JD-Core Version:    0.7.0.1
 */