import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;

public class bmbq
{
  private static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -2147483648;
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((paramView == null) || (paramMotionEvent == null)) {
      bool = false;
    }
    float f1;
    float f2;
    int i;
    int j;
    int k;
    int m;
    do
    {
      return bool;
      f1 = paramMotionEvent.getRawX();
      f2 = paramMotionEvent.getRawY();
      paramMotionEvent = new int[2];
      paramView.getLocationOnScreen(paramMotionEvent);
      i = paramMotionEvent[0];
      j = paramMotionEvent[1];
      k = paramView.getMeasuredWidth();
      m = paramView.getMeasuredHeight();
    } while ((f2 >= j) && (f2 <= m + j) && (f1 >= i) && (f1 <= k + i));
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty("8.4.8"))) {}
    label186:
    for (;;)
    {
      return false;
      String[] arrayOfString1 = paramString1.split("\\.");
      String[] arrayOfString2 = paramString2.split("\\.");
      paramString1 = "8.4.8".split("\\.");
      int i = Math.min(arrayOfString1.length, Math.min(arrayOfString2.length, paramString1.length));
      paramString2 = a(arrayOfString1, i);
      arrayOfString1 = a(arrayOfString2, i);
      paramString1 = a(paramString1, i);
      i = 0;
      for (;;)
      {
        if (i >= paramString1.length) {
          break label186;
        }
        int j = a(paramString1[i]);
        if ((paramString2.length <= i) || (arrayOfString1.length <= i)) {
          break;
        }
        int k = a(paramString2[i]);
        int m = a(arrayOfString1[i]);
        if (j < 0) {
          break;
        }
        if (((j >= k) && (j < m)) || ((j < k) && (j >= m))) {
          return true;
        }
        if ((j != k) && (j != m)) {
          break;
        }
        if (i == paramString1.length - 1) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static String[] a(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString.length > paramInt) {
      return (String[])Arrays.copyOf(paramArrayOfString, paramInt);
    }
    return paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbq
 * JD-Core Version:    0.7.0.1
 */