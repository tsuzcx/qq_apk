import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class bapp
{
  static int jdField_a_of_type_Int = 2131699959;
  static int[] jdField_a_of_type_ArrayOfInt = { 1001, 1002, 1003, 1004 };
  static int[] b;
  static int[] c;
  static int[] d;
  static int[] e;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public int e;
  public int f;
  
  static
  {
    jdField_b_of_type_ArrayOfInt = new int[] { -8293377, -42646, -35897, -16725252 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131693938, 2131721415, 2131720213, 2131699956 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2130845748, 2130845751, 2130845750, 2130845749 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131699955, 2131699964, 2131699958, 2131699957 };
  }
  
  public static Drawable a(Context paramContext, bapp parambapp)
  {
    switch (parambapp.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 1001: 
      return paramContext.getResources().getDrawable(2130845748);
    case 1004: 
      return paramContext.getResources().getDrawable(2130845749);
    case 1003: 
      return paramContext.getResources().getDrawable(2130845750);
    }
    return paramContext.getResources().getDrawable(2130845751);
  }
  
  public static ArrayList<bapp> a()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      bapp localbapp = new bapp();
      localbapp.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i];
      localbapp.jdField_c_of_type_Int = i;
      localbapp.jdField_d_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localbapp.jdField_a_of_type_JavaLangString = alud.a(jdField_c_of_type_ArrayOfInt[i]);
      localbapp.jdField_e_of_type_Int = jdField_d_of_type_ArrayOfInt[i];
      localbapp.jdField_b_of_type_JavaLangString = alud.a(jdField_e_of_type_ArrayOfInt[i]);
      localArrayList.add(localbapp);
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.f + alud.a(jdField_a_of_type_Int) + this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(@Nullable bapp parambapp)
  {
    if (parambapp == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = parambapp.jdField_a_of_type_Boolean;
    this.f = parambapp.f;
    this.jdField_a_of_type_JavaUtilArrayList = parambapp.jdField_a_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapp
 * JD-Core Version:    0.7.0.1
 */