package com.tencent.ditto.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.annoations.SourceCode.DittoJsonElement;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.DittoAreaEnv;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;
import java.lang.reflect.Constructor;
import java.util.List;

public class DittoBridgeArea
  extends DittoArea
  implements DittoHost
{
  @DittoJsonElement("内嵌View的类型, 如:android.widget.ImageView")
  public static final String VIEW_CLASS = "view";
  public View mContainedView;
  public Class mViewClass = null;
  
  public DittoBridgeArea(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    super(paramDittoHost, paramLayoutAttrSet);
    paramDittoHost = localObject;
    if (paramLayoutAttrSet.hasAttr("view")) {
      paramDittoHost = paramLayoutAttrSet.getAttr("view", null);
    }
    try
    {
      if (!TextUtils.isEmpty(paramDittoHost))
      {
        paramLayoutAttrSet = new ViewGroup.LayoutParams(paramLayoutAttrSet.width, paramLayoutAttrSet.height);
        this.mViewClass = DittoAreaEnv.findAreaClass(paramDittoHost);
        this.mContainedView = ((View)this.mViewClass.getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { DittoUIEngine.g().getContext(), null }));
        this.mContainedView.setLayoutParams(paramLayoutAttrSet);
        if ((this.mContainedView instanceof DittoAreaView)) {
          ((DittoAreaView)this.mContainedView).setHost(this);
        }
      }
      return;
    }
    catch (Exception paramDittoHost)
    {
      DittoLog.i("DittoBridgeArea:" + paramDittoHost.getMessage());
      this.mContainedView = new View(DittoUIEngine.g().getContext());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mContainedView != null) && (this.mContainedView.dispatchTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public View getContainedView()
  {
    return this.mContainedView;
  }
  
  public View getContainerView()
  {
    if (this.mHost != null) {
      return this.mHost.getContainerView();
    }
    return null;
  }
  
  public Object getCurrentViewModel()
  {
    if (this.mHost != null) {
      this.mHost.getCurrentViewModel();
    }
    return null;
  }
  
  public void handleSilentRequest(String paramString1, String paramString2, int paramInt, DittoArea paramDittoArea, MotionEvent paramMotionEvent)
  {
    if (this.mHost != null) {
      this.mHost.handleSilentRequest(paramString1, paramString2, paramInt, paramDittoArea, paramMotionEvent);
    }
  }
  
  public void handleSilentUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent)
  {
    if (this.mHost != null) {
      this.mHost.handleSilentUri(paramString, paramDittoArea, paramMotionEvent);
    }
  }
  
  public void handleUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent)
  {
    if (this.mHost != null) {
      this.mHost.handleUri(paramString, paramDittoArea, paramMotionEvent);
    }
  }
  
  public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mHost != null) {
      this.mHost.invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void invokeAreaClick(String paramString, MotionEvent paramMotionEvent)
  {
    if (this.mHost != null) {
      this.mHost.invokeAreaClick(paramString, paramMotionEvent);
    }
  }
  
  public void onContentDescriptionChanged(DittoArea paramDittoArea)
  {
    if (this.mHost != null) {
      this.mHost.onContentDescriptionChanged(paramDittoArea);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    this.mContainedView.draw(paramCanvas);
  }
  
  public void onLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mContainedView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    this.mContainedView.measure(paramInt1, paramInt2);
    setMeasuredDimension(this.mContainedView.getMeasuredWidth(), this.mContainedView.getMeasuredHeight());
  }
  
  public void postInvalidate()
  {
    if (this.mHost != null) {
      this.mHost.postInvalidate();
    }
  }
  
  public void postInvalidateDelayed(long paramLong)
  {
    if (this.mHost != null) {
      this.mHost.postInvalidateDelayed(paramLong);
    }
  }
  
  public void removeAccessibilityArea(List<DittoArea> paramList)
  {
    if (this.mHost != null) {
      this.mHost.removeAccessibilityArea(paramList);
    }
  }
  
  public void storageViewModel(boolean paramBoolean)
  {
    if (this.mHost != null) {
      this.mHost.storageViewModel(paramBoolean);
    }
  }
  
  public void turnOffHardwareAcceleration()
  {
    if (this.mHost != null) {
      this.mHost.turnOffHardwareAcceleration();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.widget.DittoBridgeArea
 * JD-Core Version:    0.7.0.1
 */