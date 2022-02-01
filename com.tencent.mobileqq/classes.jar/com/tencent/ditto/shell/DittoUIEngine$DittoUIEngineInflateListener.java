package com.tencent.ditto.shell;

import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.reflect.DittoValue;
import java.util.Map;

public abstract interface DittoUIEngine$DittoUIEngineInflateListener
{
  public abstract void didInflatedArea(DittoArea paramDittoArea, String paramString);
  
  public abstract void setOutKVCSet(DittoArea paramDittoArea, Map<String, DittoValue> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.shell.DittoUIEngine.DittoUIEngineInflateListener
 * JD-Core Version:    0.7.0.1
 */