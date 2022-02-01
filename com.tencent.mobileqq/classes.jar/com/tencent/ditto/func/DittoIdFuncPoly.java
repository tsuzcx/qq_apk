package com.tencent.ditto.func;

import android.support.v4.util.ArrayMap;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DittoIdFuncPoly
  implements DittoIdFuncPolyInf
{
  private final Map<String, DittoIdFunc> idFuncMap;
  
  public DittoIdFuncPoly(Map<String, DittoIdFunc> paramMap)
  {
    this.idFuncMap = Collections.unmodifiableMap(paramMap);
  }
  
  public static DittoIdFuncPoly createReflectIdFuncPoly(Class<? extends DittoAreaView> paramClass)
  {
    HashMap localHashMap = new HashMap();
    ArrayMap localArrayMap = DittoAreaView.getFields(paramClass);
    paramClass = DittoAreaView.getMethods(paramClass);
    Object localObject = new HashSet(localArrayMap.keySet());
    ((Set)localObject).addAll(paramClass[0].keySet());
    ((Set)localObject).addAll(paramClass[1].keySet());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localHashMap.put(str, new ReflectDittoIdFunc((Field)localArrayMap.get(str), (Method)paramClass[0].get(str), (Method)paramClass[1].get(str)));
    }
    return new DittoIdFuncPoly(localHashMap);
  }
  
  public void inflateArea(DittoAreaView paramDittoAreaView, DittoArea paramDittoArea, String paramString)
  {
    paramString = (DittoIdFunc)this.idFuncMap.get(paramString);
    if (paramString != null) {
      paramString.inflate(paramDittoAreaView, paramDittoArea);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.func.DittoIdFuncPoly
 * JD-Core Version:    0.7.0.1
 */