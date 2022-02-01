package com.tencent.mobileqq.app.message.hookparcel;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.tencent.mobileqq.app.message.RecordForTest;
import java.lang.reflect.ParameterizedType;

final class ParcelHooker$10
  implements ExclusionStrategy
{
  public boolean shouldSkipClass(Class<?> paramClass)
  {
    return false;
  }
  
  public boolean shouldSkipField(FieldAttributes paramFieldAttributes)
  {
    if ((!paramFieldAttributes.hasModifier(128)) && (!paramFieldAttributes.hasModifier(8)))
    {
      if (paramFieldAttributes.hasModifier(64)) {
        return true;
      }
      if ((!ParcelHooker.a(paramFieldAttributes.getDeclaredClass())) && (!ParcelHooker.a(paramFieldAttributes.getDeclaredClass().getComponentType())))
      {
        if (((paramFieldAttributes.getDeclaredType() instanceof ParameterizedType)) && (ParcelHooker.a(((ParameterizedType)paramFieldAttributes.getDeclaredType()).getActualTypeArguments()[0]))) {
          return false;
        }
        return paramFieldAttributes.getAnnotation(RecordForTest.class) == null;
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.hookparcel.ParcelHooker.10
 * JD-Core Version:    0.7.0.1
 */