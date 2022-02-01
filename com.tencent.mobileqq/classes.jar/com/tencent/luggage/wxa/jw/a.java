package com.tencent.luggage.wxa.jw;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

final class a
{
  static final String[] a;
  
  static
  {
    LinkedList localLinkedList = new LinkedList();
    Field[] arrayOfField = ExifInterface.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      Field localField;
      if (i < j) {
        localField = arrayOfField[i];
      }
      try
      {
        if ((Modifier.isFinal(localField.getModifiers())) && (Modifier.isStatic(localField.getModifiers())) && (localField.getName().startsWith("TAG_"))) {
          localLinkedList.add((String)localField.get(null));
        }
        label80:
        i += 1;
        continue;
        a = (String[])localLinkedList.toArray(new String[localLinkedList.size()]);
        return;
      }
      catch (Exception localException)
      {
        break label80;
      }
    }
  }
  
  static void a(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2)
  {
    if (paramExifInterface1 != null)
    {
      if (paramExifInterface2 == null) {
        return;
      }
      String[] arrayOfString = a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str1 = arrayOfString[i];
        String str2 = paramExifInterface1.getAttribute(str1);
        if (str2 != null) {
          paramExifInterface2.setAttribute(str1, str2);
        }
        i += 1;
      }
      paramExifInterface2.saveAttributes();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jw.a
 * JD-Core Version:    0.7.0.1
 */