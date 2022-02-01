package com.tencent.map.sdk.a;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class fc$a<T extends Enum<T>>
  extends ee<T>
{
  private final Map<String, T> a = new HashMap();
  private final Map<T, String> b = new HashMap();
  
  public fc$a(Class<T> paramClass)
  {
    try
    {
      Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
      int j = arrayOfEnum.length;
      int i = 0;
      while (i < j)
      {
        Enum localEnum = arrayOfEnum[i];
        String str = localEnum.name();
        SerializedName localSerializedName = (SerializedName)paramClass.getField(str).getAnnotation(SerializedName.class);
        if (localSerializedName != null) {
          str = localSerializedName.value();
        }
        this.a.put(str, localEnum);
        this.b.put(localEnum, str);
        i += 1;
      }
      return;
    }
    catch (NoSuchFieldException paramClass)
    {
      label125:
      break label125;
    }
    paramClass = new AssertionError();
    for (;;)
    {
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.a
 * JD-Core Version:    0.7.0.1
 */