package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;

public class GeneratePicArgs
{
  private static boolean[] a;
  public int a;
  public Bitmap a;
  public String a;
  public boolean a;
  public Bitmap b;
  public String b;
  public boolean b;
  public boolean c;
  public boolean d = false;
  
  static
  {
    jdField_a_of_type_ArrayOfBoolean = new boolean[5];
  }
  
  public GeneratePicArgs(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static void a(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < 5)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length == 5))
      {
        boolean[] arrayOfBoolean = jdField_a_of_type_ArrayOfBoolean;
        int k = arrayOfBoolean[i];
        int j;
        if (paramArrayOfInt[i] > 0) {
          j = 1;
        } else {
          j = 0;
        }
        arrayOfBoolean[i] = (k | j);
      }
      else
      {
        jdField_a_of_type_ArrayOfBoolean[i] = false;
      }
      i += 1;
    }
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 4)) {
      return jdField_a_of_type_ArrayOfBoolean[paramInt];
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs
 * JD-Core Version:    0.7.0.1
 */