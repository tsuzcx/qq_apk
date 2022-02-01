package com.tencent.ditto.func;

import android.view.MotionEvent;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoArea.LongClickListener;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.DittoUIEngine.IReporter;
import com.tencent.ditto.utils.DittoLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectDittoIdFunc$2
  implements DittoArea.LongClickListener
{
  ReflectDittoIdFunc$2(ReflectDittoIdFunc paramReflectDittoIdFunc, DittoAreaView paramDittoAreaView) {}
  
  public void onLongClick(DittoArea paramDittoArea, MotionEvent paramMotionEvent, Object paramObject)
  {
    try
    {
      if (paramDittoArea.getCompassClickKey() != null) {
        DittoUIEngine.g().getReporter().compassReport(paramDittoArea.getCompassClickKey());
      }
      ReflectDittoIdFunc.access$100(this.this$0).invoke(this.val$view, new Object[] { paramDittoArea, paramMotionEvent, paramObject });
      return;
    }
    catch (IllegalAccessException paramDittoArea)
    {
      DittoLog.e("DITTO_UI", "getLongClickListener", paramDittoArea);
      throw new RuntimeException(paramDittoArea.getMessage());
    }
    catch (InvocationTargetException paramDittoArea)
    {
      DittoLog.e("DITTO_UI", "getLongClickListener", paramDittoArea);
      throw new RuntimeException(paramDittoArea.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ditto.func.ReflectDittoIdFunc.2
 * JD-Core Version:    0.7.0.1
 */