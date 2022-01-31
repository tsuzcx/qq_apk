package com.tencent.ditto;

import android.view.MotionEvent;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoArea.ClickListener;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.DittoUIEngine.IReporter;
import com.tencent.ditto.utils.DittoLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class DittoAreaView$2
  implements DittoArea.ClickListener
{
  DittoAreaView$2(DittoAreaView paramDittoAreaView, Method paramMethod) {}
  
  public void onClick(DittoArea paramDittoArea, MotionEvent paramMotionEvent, Object paramObject)
  {
    try
    {
      if (paramDittoArea.getCompassClickKey() != null) {
        DittoUIEngine.g().getReporter().compassReport(paramDittoArea.getCompassClickKey());
      }
      if (paramDittoArea.getTttReportArea() != -1) {
        this.val$view.reportTTTClick(paramDittoArea.getTttReportArea());
      }
      this.val$method.invoke(this.val$view, new Object[] { paramDittoArea, paramMotionEvent, paramObject });
      return;
    }
    catch (IllegalAccessException paramMotionEvent)
    {
      paramObject = new StringBuilder().append("getClickListener dittoArea:");
      if (paramDittoArea != null) {}
      for (paramDittoArea = paramDittoArea.getId();; paramDittoArea = "Null")
      {
        DittoLog.e("DITTO_UI", paramDittoArea, paramMotionEvent);
        throw new RuntimeException(paramMotionEvent.getMessage());
      }
    }
    catch (InvocationTargetException paramMotionEvent)
    {
      paramObject = new StringBuilder().append("getClickListener dittoArea:");
      if (paramDittoArea != null) {}
      for (paramDittoArea = paramDittoArea.getId();; paramDittoArea = "Null")
      {
        DittoLog.e("DITTO_UI", paramDittoArea, paramMotionEvent);
        if (!(paramMotionEvent.getCause() instanceof RuntimeException)) {
          break;
        }
        throw ((RuntimeException)paramMotionEvent.getCause());
      }
      throw new RuntimeException(paramMotionEvent.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.DittoAreaView.2
 * JD-Core Version:    0.7.0.1
 */