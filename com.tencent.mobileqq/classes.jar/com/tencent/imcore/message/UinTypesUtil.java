package com.tencent.imcore.message;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants.VALUE;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class UinTypesUtil
{
  @NonNull
  private static List<Integer> a(Field[] paramArrayOfField)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = paramArrayOfField[i];
      if (localField.getName().startsWith("UIN_TYPE_")) {
        try
        {
          localArrayList.add((Integer)localField.get(null));
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static int[] a()
  {
    List localList = a(AppConstants.VALUE.class.getFields());
    int[] arrayOfInt = new int[localList.size()];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = ((Integer)localList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.UinTypesUtil
 * JD-Core Version:    0.7.0.1
 */