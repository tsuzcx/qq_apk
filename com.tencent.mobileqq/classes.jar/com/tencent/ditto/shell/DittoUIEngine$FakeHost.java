package com.tencent.ditto.shell;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import java.util.List;

class DittoUIEngine$FakeHost
  implements DittoHost
{
  DittoUIEngine$FakeHost(DittoUIEngine paramDittoUIEngine) {}
  
  public View getContainerView()
  {
    return null;
  }
  
  public Context getContext()
  {
    return DittoUIEngine.access$000(DittoUIEngine.g());
  }
  
  public Object getCurrentViewModel()
  {
    return null;
  }
  
  public int getPaddingBottom()
  {
    return 0;
  }
  
  public int getPaddingLeft()
  {
    return 0;
  }
  
  public int getPaddingRight()
  {
    return 0;
  }
  
  public int getPaddingTop()
  {
    return 0;
  }
  
  public void handleSilentRequest(String paramString1, String paramString2, int paramInt, DittoArea paramDittoArea, MotionEvent paramMotionEvent) {}
  
  public void handleSilentUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent) {}
  
  public void handleUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent) {}
  
  public void invalidate() {}
  
  public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void invokeAreaClick(String paramString, MotionEvent paramMotionEvent) {}
  
  public void onContentDescriptionChanged(DittoArea paramDittoArea) {}
  
  public void postInvalidate() {}
  
  public void postInvalidateDelayed(long paramLong) {}
  
  public void removeAccessibilityArea(List<DittoArea> paramList) {}
  
  public void requestLayout() {}
  
  public void storageViewModel(boolean paramBoolean) {}
  
  public void turnOffHardwareAcceleration() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.shell.DittoUIEngine.FakeHost
 * JD-Core Version:    0.7.0.1
 */