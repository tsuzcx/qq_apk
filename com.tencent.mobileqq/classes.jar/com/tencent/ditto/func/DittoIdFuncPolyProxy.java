package com.tencent.ditto.func;

import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;

public abstract class DittoIdFuncPolyProxy
  implements DittoIdFuncPolyInf
{
  protected abstract DittoIdFuncPoly getIdFuncPoly();
  
  public void inflateArea(DittoAreaView paramDittoAreaView, DittoArea paramDittoArea, String paramString)
  {
    getIdFuncPoly().inflateArea(paramDittoAreaView, paramDittoArea, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.func.DittoIdFuncPolyProxy
 * JD-Core Version:    0.7.0.1
 */