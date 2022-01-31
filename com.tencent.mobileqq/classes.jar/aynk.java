import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class aynk
{
  static int jdField_a_of_type_Int = 2131699592;
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
    jdField_c_of_type_ArrayOfInt = new int[] { 2131693820, 2131720857, 2131719669, 2131699589 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2130845307, 2130845310, 2130845309, 2130845308 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131699588, 2131699597, 2131699591, 2131699590 };
  }
  
  public static Drawable a(Context paramContext, aynk paramaynk)
  {
    switch (paramaynk.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 1001: 
      return paramContext.getResources().getDrawable(2130845307);
    case 1004: 
      return paramContext.getResources().getDrawable(2130845308);
    case 1003: 
      return paramContext.getResources().getDrawable(2130845309);
    }
    return paramContext.getResources().getDrawable(2130845310);
  }
  
  public static ArrayList<aynk> a()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      aynk localaynk = new aynk();
      localaynk.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i];
      localaynk.jdField_c_of_type_Int = i;
      localaynk.jdField_d_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localaynk.jdField_a_of_type_JavaLangString = ajya.a(jdField_c_of_type_ArrayOfInt[i]);
      localaynk.jdField_e_of_type_Int = jdField_d_of_type_ArrayOfInt[i];
      localaynk.jdField_b_of_type_JavaLangString = ajya.a(jdField_e_of_type_ArrayOfInt[i]);
      localArrayList.add(localaynk);
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.f + ajya.a(jdField_a_of_type_Int) + this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(@Nullable aynk paramaynk)
  {
    if (paramaynk == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramaynk.jdField_a_of_type_Boolean;
    this.f = paramaynk.f;
    this.jdField_a_of_type_JavaUtilArrayList = paramaynk.jdField_a_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aynk
 * JD-Core Version:    0.7.0.1
 */