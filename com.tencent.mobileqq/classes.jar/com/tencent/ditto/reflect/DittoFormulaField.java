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
      double d1 = this.ratio;
      double d2 = Double.parseDouble(this.value.getValue(paramObject).toString());
      if ("-".equals(this.operator)) {}
      for (int i = -1;; i = 1)
      {
        double d3 = i * this.offset;
        return Double.valueOf((d3 + d2) * d1);
      }
      return "0";
    }
    catch (Throwable paramObject)
    {
      DittoLog.e("DittoFormulaField", "err parse value " + this.formula);
    }
  }
  
  public void setValue(Object paramObject, String paramString)
  {
    DittoLog.e("DITTO_UI", "cannot set a value of formula:" + this.formula, new RuntimeException());
  }
  
  public void setValue(Object paramObject, boolean paramBoolean)
  {
    DittoLog.e("DITTO_UI", "cannot set a value of formula:" + this.formula, new RuntimeException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoFormulaField
 * JD-Core Version:    0.7.0.1
 */