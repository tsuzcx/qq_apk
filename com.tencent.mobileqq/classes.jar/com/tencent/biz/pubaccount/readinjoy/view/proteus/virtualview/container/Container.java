package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Container
  extends ViewGroup
  implements IContainer, IView
{
  private static final String TAG = "Container_TMTEST";
  protected ViewBase mView;
  private final Map<String, ViewBase> mViewIdMapping = new HashMap();
  
  public Container(Context paramContext)
  {
    super(paramContext);
  }
  
  public void attachViews()
  {
    attachViews(this.mView);
  }
  
  protected void attachViews(ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    View localView;
    do
    {
      for (;;)
      {
        return;
        if (!(paramViewBase instanceof Layout)) {
          break;
        }
        if (paramViewBase.getNativeView() != null)
        {
          localView = paramViewBase.getNativeView();
          if (localView != null) {
            addView(localView, new ViewGroup.LayoutParams(paramViewBase.getComLayoutParams().mLayoutWidth, paramViewBase.getComLayoutParams().mLayoutHeight));
          }
        }
        else
        {
          paramViewBase = ((Layout)paramViewBase).getSubViews();
          if (paramViewBase != null)
          {
            paramViewBase = paramViewBase.iterator();
            while (paramViewBase.hasNext()) {
              attachViews((ViewBase)paramViewBase.next());
            }
          }
        }
      }
      localView = paramViewBase.getNativeView();
    } while (localView == null);
    addView(localView, new ViewGroup.LayoutParams(paramViewBase.getComLayoutParams().mLayoutWidth, paramViewBase.getComLayoutParams().mLayoutHeight));
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mView != null)
    {
      this.mView.comLayout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
      layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void destroy()
  {
    this.mView.destroy();
    this.mView = null;
  }
  
  public void detachViews()
  {
    this.mViewIdMapping.clear();
    removeAllViews();
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (paramLayoutParams == null) {
      localLayoutParams = generateDefaultLayoutParams();
    }
    return localLayoutParams;
  }
  
  public int getComMeasuredHeight()
  {
    if (this.mView != null) {
      return this.mView.getComMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    if (this.mView != null) {
      return this.mView.getComMeasuredWidth();
    }
    return 0;
  }
  
  public View getHolderView()
  {
    return this;
  }
  
  public int getType()
  {
    return 0;
  }
  
  public Map<String, ViewBase> getViewIdMapping()
  {
    return this.mViewIdMapping;
  }
  
  public ViewBase getVirtualView()
  {
    return this.mView;
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    if (this.mView != null)
    {
      this.mView.measureComponent(paramInt1, paramInt2);
      setMeasuredDimension(this.mView.getComMeasuredWidth(), this.mView.getComMeasuredHeight());
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mView != null) {
      this.mView.onComLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    if (this.mView != null)
    {
      this.mView.onComMeasure(paramInt1, paramInt2);
      setMeasuredDimension(this.mView.getComMeasuredWidth(), this.mView.getComMeasuredHeight());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mView != null) && (this.mView.shouldDraw())) {
      this.mView.comDraw(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(paramBoolean, 0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void setVirtualView(ViewBase paramViewBase)
  {
    if (paramViewBase != null)
    {
      this.mView = paramViewBase;
      this.mView.setHoldView(this);
      if (this.mView.shouldDraw()) {
        setWillNotDraw(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container
 * JD-Core Version:    0.7.0.1
 */