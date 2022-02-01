package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.graphics.Bitmap;

public class GeneratePicArgs
{
  private static boolean[] j = new boolean[5];
  public String a;
  public String b;
  public Bitmap c;
  public Bitmap d;
  public boolean e;
  public int f;
  public boolean g;
  public boolean h;
  public boolean i = false;
  
  public GeneratePicArgs(String paramString)
  {
    this.a = paramString;
  }
  
  public static void a(int[] paramArrayOfInt)
  {
    int k = 0;
    while (k < 5)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length == 5))
      {
        boolean[] arrayOfBoolean = j;
        int n = arrayOfBoolean[k];
        int m;
        if (paramArrayOfInt[k] > 0) {
          m = 1;
        } else {
          m = 0;
        }
        arrayOfBoolean[k] = (n | m);
      }
      else
      {
        j[k] = false;
      }
      k += 1;
    }
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 4)) {
      return j[paramInt];
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs
 * JD-Core Version:    0.7.0.1
 */