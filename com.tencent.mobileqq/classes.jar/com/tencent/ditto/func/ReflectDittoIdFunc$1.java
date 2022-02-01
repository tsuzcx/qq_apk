package com.tencent.ditto.func;

import android.view.MotionEvent;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoArea.ClickListener;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.DittoUIEngine.IReporter;
import com.tencent.ditto.utils.DittoLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectDittoIdFunc$1
  implements DittoArea.ClickListener
{
  ReflectDittoIdFunc$1(ReflectDittoIdFunc paramReflectDittoIdFunc, DittoAreaView paramDittoAreaView) {}
  
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
      ReflectDittoIdFunc.access$000(this.this$0).invoke(this.val$view, new Object[] { paramDittoArea, paramMotionEvent, paramObject });
      return;
    }
    catch (IllegalAccessException paramMotionEvent)
    {
      DittoLog.e("DITTO_UI", "getClickListener dittoArea:" + paramDittoArea.getId(), paramMotionEvent);
      throw new RuntimeException(paramMotionEvent.getMessage());
    }
    catch (InvocationTargetException paramMotionEvent)
    {
      DittoLog.e("DITTO_UI", "getClickListener dittoArea:" + paramDittoArea.getId(), paramMotionEvent);
      if ((paramMotionEvent.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramMotionEvent.getCause());
      }
      throw new RuntimeException(paramMotionEvent.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.func.ReflectDittoIdFunc.1
 * JD-Core Version:    0.7.0.1
 */