package com.tencent.ditto.reflect;

import com.tencent.ditto.utils.DittoLog;

public class DittoStringValue
  extends DittoValue
{
  public String mString = null;
  
  public Object getValue(Object paramObject)
  {
    return this.mString;
  }
  
  public void setValue(Object paramObject, String paramString)
  {
    paramObject = new StringBuilder();
    paramObject.append("cannot set a value of string constant:");
    paramObject.append(this.mString);
    DittoLog.e("DITTO_UI", paramObject.toString(), new RuntimeException());
  }
  
  public void setValue(Object paramObject, boolean paramBoolean)
  {
    paramObject = new StringBuilder();
    paramObject.append("cannot set a value of string constant:");
    paramObject.append(this.mString);
    DittoLog.e("DITTO_UI", paramObject.toString(), new RuntimeException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoStringValue
 * JD-Core Version:    0.7.0.1
 */