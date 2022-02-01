package com.tencent.mobileqq.ar.keying;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class KeyingManager
{
  public static KeyingBase a(KeyingParams paramKeyingParams, int paramInt)
  {
    if (paramKeyingParams != null)
    {
      int i = paramKeyingParams.jdField_a_of_type_Int;
      Object localObject;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                localObject = new NoneKey(paramInt);
              } else if (!TextUtils.isEmpty(paramKeyingParams.jdField_a_of_type_JavaLangString)) {
                localObject = new CustomizeKey(paramInt, paramKeyingParams.jdField_a_of_type_JavaLangString);
              } else {
                throw new RuntimeException("fragmentShader can not be empty!");
              }
            }
            else {
              localObject = new HighQualityChromaKey(paramInt);
            }
          }
          else {
            localObject = new GreenScreenChromaKey(paramInt);
          }
        }
        else {
          localObject = new SeriouslyChromaKey(paramInt);
        }
      }
      else {
        localObject = new ColorDifferenceKey(paramInt);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getKeying keying: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append("  params: ");
      localStringBuilder.append(paramKeyingParams.toString());
      QLog.i("KeyingManager", 1, localStringBuilder.toString());
      return localObject;
    }
    throw new RuntimeException("params can not be null!");
  }
  
  public static KeyingParams a(int paramInt)
  {
    return new KeyingParams(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.KeyingManager
 * JD-Core Version:    0.7.0.1
 */