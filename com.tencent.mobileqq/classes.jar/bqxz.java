import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public class bqxz
  implements bqya
{
  public static final int[] a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "#000000", "#FFFFFF", "#DF382C", "#F09A37", "#83D754", "#3478F6", "#7ED5F8", "#F7E368", "#E8519C" };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130846785, 2130846783, 2130846786, 2130846784, 2130846789, 2130846788, 2130846792, 2130846787, 2130846790 };
  }
  
  public static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return Color.parseColor(jdField_a_of_type_ArrayOfJavaLangString[2]);
    }
    return Color.parseColor(jdField_a_of_type_ArrayOfJavaLangString[1]);
  }
  
  public void a(@NonNull ArrayList<bqyb> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      paramArrayList.add(new bqyb(paramContext.getResources().getDrawable(jdField_a_of_type_ArrayOfInt[i]), 0, jdField_a_of_type_ArrayOfJavaLangString[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqxz
 * JD-Core Version:    0.7.0.1
 */