package com.tencent.ditto.func;

import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.utils.DittoLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDittoIdFunc
  implements DittoIdFunc
{
  private final Method clickMethod;
  private final Field field;
  private final Method longClickMethod;
  
  public ReflectDittoIdFunc(Field paramField, Method paramMethod1, Method paramMethod2)
  {
    this.field = paramField;
    this.clickMethod = paramMethod1;
    this.longClickMethod = paramMethod2;
  }
  
  public void inflate(DittoAreaView paramDittoAreaView, DittoArea paramDittoArea)
  {
    setValue(paramDittoAreaView, paramDittoArea);
    setClickListener(paramDittoAreaView, paramDittoArea);
    setLongClickListener(paramDittoAreaView, paramDittoArea);
  }
  
  public void setClickListener(DittoAreaView paramDittoAreaView, DittoArea paramDittoArea)
  {
    Method localMethod = this.clickMethod;
    if (localMethod == null) {
      return;
    }
    if (localMethod.getParameterTypes().length == 3)
    {
      this.clickMethod.setAccessible(true);
      paramDittoArea.clickListener = new ReflectDittoIdFunc.1(this, paramDittoAreaView);
      return;
    }
    throw new RuntimeException("arguments of event method must be (DittoArea, MotionEvent, Object)");
  }
  
  public void setLongClickListener(DittoAreaView paramDittoAreaView, DittoArea paramDittoArea)
  {
    Method localMethod = this.longClickMethod;
    if (localMethod == null) {
      return;
    }
    if (localMethod.getParameterTypes().length == 3)
    {
      this.longClickMethod.setAccessible(true);
      paramDittoArea.longClickListener = new ReflectDittoIdFunc.2(this, paramDittoAreaView);
      return;
    }
    throw new RuntimeException("arguments of event method must be (DittoArea, MotionEvent, Object)");
  }
  
  public void setValue(DittoAreaView paramDittoAreaView, DittoArea paramDittoArea)
  {
    Field localField = this.field;
    if (localField == null) {
      return;
    }
    localField.setAccessible(true);
    try
    {
      this.field.set(paramDittoAreaView, paramDittoArea);
      return;
    }
    catch (IllegalAccessException paramDittoAreaView)
    {
      DittoLog.e("DITTO_UI", "inflateErr: ", paramDittoAreaView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.func.ReflectDittoIdFunc
 * JD-Core Version:    0.7.0.1
 */