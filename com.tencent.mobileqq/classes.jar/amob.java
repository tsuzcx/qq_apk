import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Random;

public class amob
{
  public static int a;
  private static Paint a;
  public static Random a;
  
  static
  {
    jdField_a_of_type_Int = 12;
    jdField_a_of_type_JavaUtilRandom = new Random();
    jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  public static float a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      jdField_a_of_type_AndroidGraphicsPaint.setTextSize(36.0F);
      return jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString) / 36.0F;
    }
    return 1.0F;
  }
  
  private static boolean a(int paramInt)
  {
    return ((paramInt >= 19968) && (paramInt <= 40959)) || (paramInt == 65292) || (paramInt == 12290) || (paramInt == 65281) || (paramInt == 8220) || (paramInt == 8221) || (paramInt == 65288) || (paramInt == 65289) || (paramInt == 126) || (paramInt == 65311);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label37;
      }
      if (!a(paramString.codePointAt(i))) {
        break;
      }
      i += 1;
    }
    label37:
    return true;
  }
  
  private static boolean b(String paramString, ArrayList<Pair<String, Float>> paramArrayList)
  {
    paramString = paramString.trim();
    int j = -1;
    boolean bool = true;
    int i = 0;
    if (i < paramString.length())
    {
      String str;
      if (a(paramString.codePointAt(i)))
      {
        str = paramString.substring(i, i + 1);
        paramArrayList.add(new Pair(str, Float.valueOf(a(str))));
      }
      for (;;)
      {
        i += 1;
        break;
        int k = j;
        if (j == -1) {
          k = i;
        }
        if (i + 1 < paramString.length())
        {
          j = k;
          if (!a(paramString.codePointAt(i + 1))) {}
        }
        else
        {
          str = paramString.substring(k, i + 1);
          paramArrayList.add(new Pair(str, Float.valueOf(a(str))));
          j = -1;
        }
        bool = false;
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amob
 * JD-Core Version:    0.7.0.1
 */