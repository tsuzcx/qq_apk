package com.tencent.ditto.reflect;

import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.utils.DittoLog;

public class DittoFormulaField
  extends DittoValue
{
  private String formula;
  private float offset;
  private String operator;
  private float ratio;
  private DittoValue value;
  
  public DittoFormulaField(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.ratio = Float.parseFloat(paramString1);
    this.value = MustacheParser.parse(paramString2);
    this.offset = Float.parseFloat(paramString4);
    if ("dp".equals(paramString5)) {
      this.offset *= DittoUIEngine.g().getDensity();
    }
    this.operator = paramString3;
    this.formula = paramString6;
  }
  
  public Object getValue(Object paramObject)
  {
    try
    {
      d1 = this.ratio;
      d2 = Double.parseDouble(this.value.getValue(paramObject).toString());
      if (!"-".equals(this.operator)) {
        break label121;
      }
      i = -1;
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        double d1;
        double d2;
        float f1;
        float f2;
        double d3;
        continue;
        label121:
        int i = 1;
      }
    }
    f1 = i;
    f2 = this.offset;
    d3 = f1 * f2;
    Double.isNaN(d3);
    Double.isNaN(d1);
    return Double.valueOf(d1 * (d2 + d3));
    paramObject = new StringBuilder();
    paramObject.append("err parse value ");
    paramObject.append(this.formula);
    DittoLog.e("DittoFormulaField", paramObject.toString());
    return "0";
  }
  
  public void setValue(Object paramObject, String paramString)
  {
    paramObject = new StringBuilder();
    paramObject.append("cannot set a value of formula:");
    paramObject.append(this.formula);
    DittoLog.e("DITTO_UI", paramObject.toString(), new RuntimeException());
  }
  
  public void setValue(Object paramObject, boolean paramBoolean)
  {
    paramObject = new StringBuilder();
    paramObject.append("cannot set a value of formula:");
    paramObject.append(this.formula);
    DittoLog.e("DITTO_UI", paramObject.toString(), new RuntimeException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoFormulaField
 * JD-Core Version:    0.7.0.1
 */