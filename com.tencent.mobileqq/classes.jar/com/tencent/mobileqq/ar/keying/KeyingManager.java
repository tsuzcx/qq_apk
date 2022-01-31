package com.tencent.mobileqq.ar.keying;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class KeyingManager
{
  public static KeyingBase a(KeyingParams paramKeyingParams, int paramInt)
  {
    if (paramKeyingParams == null) {
      throw new RuntimeException("params can not be null!");
    }
    Object localObject;
    switch (paramKeyingParams.jdField_a_of_type_Int)
    {
    default: 
      localObject = new NoneKey(paramInt);
    }
    for (;;)
    {
      QLog.i("KeyingManager", 1, "getKeying keying: " + localObject + "  params: " + paramKeyingParams.toString());
      return localObject;
      localObject = new ColorDifferenceKey(paramInt);
      continue;
      localObject = new SeriouslyChromaKey(paramInt);
      continue;
      localObject = new GreenScreenChromaKey(paramInt);
      continue;
      localObject = new HighQualityChromaKey(paramInt);
      continue;
      if (TextUtils.isEmpty(paramKeyingParams.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = new CustomizeKey(paramInt, paramKeyingParams.jdField_a_of_type_JavaLangString);
    }
    throw new RuntimeException("fragmentShader can not be empty!");
  }
  
  public static KeyingParams a(int paramInt)
  {
    return new KeyingParams(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.KeyingManager
 * JD-Core Version:    0.7.0.1
 */