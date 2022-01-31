import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aswe
{
  private static List<float[]> a(float[][] paramArrayOfFloat)
  {
    int[] arrayOfInt = new int[8];
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramArrayOfFloat.length)
    {
      j = 1;
      for (;;)
      {
        if (j <= 7)
        {
          if (paramArrayOfFloat[i][0] < 360.0F * (j / 7.0F))
          {
            arrayOfInt[j] += 1;
            List localList = (List)localHashMap.get(Integer.valueOf(j));
            Object localObject = localList;
            if (localList == null) {
              localObject = new ArrayList();
            }
            ((List)localObject).add(paramArrayOfFloat[i]);
            localHashMap.put(Integer.valueOf(j), localObject);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    int k = -1;
    int j = 0;
    i = 1;
    while (i <= 7)
    {
      int m = j;
      if (arrayOfInt[i] > j)
      {
        m = arrayOfInt[i];
        k = i;
      }
      i += 1;
      j = m;
    }
    if (localHashMap.containsKey(Integer.valueOf(k))) {
      return (List)localHashMap.get(Integer.valueOf(k));
    }
    return new ArrayList();
  }
  
  private static void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramArrayOfFloat1[2] <= 0.15D)
    {
      paramArrayOfFloat2[0] = paramArrayOfFloat1[0];
      paramArrayOfFloat2[1] = paramArrayOfFloat1[1];
      paramArrayOfFloat1[2] += 0.7F;
    }
    for (;;)
    {
      if (paramArrayOfFloat2[1] > 0.5F) {
        paramArrayOfFloat2[1] -= 0.1F;
      }
      return;
      paramArrayOfFloat2[0] = paramArrayOfFloat1[0];
      paramArrayOfFloat2[1] = paramArrayOfFloat1[1];
      if (paramArrayOfFloat1[2] + 0.5D >= 1.0D) {
        paramArrayOfFloat1[2] -= 0.5F;
      } else {
        paramArrayOfFloat1[2] += 0.5F;
      }
    }
  }
  
  private static float[] a(List<float[]> paramList)
  {
    float[] arrayOfFloat;
    int i;
    if (paramList.size() > 4)
    {
      float f = 3.4028235E+38F;
      arrayOfFloat = null;
      i = 0;
      if (i < paramList.size())
      {
        if (((float[])paramList.get(i))[2] >= f) {
          break label135;
        }
        f = ((float[])paramList.get(i))[2];
        arrayOfFloat = (float[])paramList.get(i);
      }
    }
    label135:
    for (;;)
    {
      i += 1;
      break;
      if (arrayOfFloat[2] > 0.15D) {
        arrayOfFloat[2] -= 0.1F;
      }
      if (arrayOfFloat[1] > 0.5D) {
        arrayOfFloat[1] -= 0.1F;
      }
      return arrayOfFloat;
      paramList = (float[])paramList.get(0);
      paramList[2] = 0.15F;
      return paramList;
    }
  }
  
  public static int[] a(int paramInt)
  {
    float[] arrayOfFloat1 = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat1);
    float[] arrayOfFloat2 = new float[3];
    a(arrayOfFloat1, arrayOfFloat2);
    return new int[] { Color.HSVToColor(arrayOfFloat1), Color.HSVToColor(arrayOfFloat2) };
  }
  
  public static int[] a(Bitmap paramBitmap)
  {
    paramBitmap = a(a(a(b(paramBitmap))));
    float[] arrayOfFloat = new float[3];
    b(paramBitmap, arrayOfFloat);
    return new int[] { Color.HSVToColor(paramBitmap), Color.HSVToColor(arrayOfFloat) };
  }
  
  private static float[][] a(int[] paramArrayOfInt)
  {
    float[][] arrayOfFloat = new float[16][];
    int i = 0;
    while (i < 16)
    {
      arrayOfFloat[i] = new float[3];
      Color.colorToHSV(paramArrayOfInt[i], arrayOfFloat[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  private static void b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f4 = paramArrayOfFloat1[0];
    float f3 = paramArrayOfFloat1[1];
    float f1 = paramArrayOfFloat1[2];
    if (f1 <= 0.15D) {
      f1 += 0.7F;
    }
    for (;;)
    {
      float f2 = f3;
      if (f3 >= 0.5F) {
        f2 = f3 - 0.1F;
      }
      paramArrayOfFloat2[0] = f4;
      paramArrayOfFloat2[1] = f2;
      paramArrayOfFloat2[2] = f1;
      return;
      if (f1 <= 0.5D) {
        f1 += 0.5F;
      } else {
        f1 -= 0.5F;
      }
    }
  }
  
  private static int[] b(Bitmap paramBitmap)
  {
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, 4, 4, false);
    int[] arrayOfInt = new int[16];
    paramBitmap.getPixels(arrayOfInt, 0, 4, 0, 0, 4, 4);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aswe
 * JD-Core Version:    0.7.0.1
 */