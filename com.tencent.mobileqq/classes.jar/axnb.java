import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class axnb
{
  static int jdField_a_of_type_Int = 2131633799;
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
    jdField_c_of_type_ArrayOfInt = new int[] { 2131628178, 2131654948, 2131653774, 2131633796 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2130845217, 2130845220, 2130845219, 2130845218 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131633795, 2131633800, 2131633798, 2131633797 };
  }
  
  public static Drawable a(Context paramContext, axnb paramaxnb)
  {
    switch (paramaxnb.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 1001: 
      return paramContext.getResources().getDrawable(2130845217);
    case 1004: 
      return paramContext.getResources().getDrawable(2130845218);
    case 1003: 
      return paramContext.getResources().getDrawable(2130845219);
    }
    return paramContext.getResources().getDrawable(2130845220);
  }
  
  public static ArrayList<axnb> a()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      axnb localaxnb = new axnb();
      localaxnb.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i];
      localaxnb.jdField_c_of_type_Int = i;
      localaxnb.jdField_d_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localaxnb.jdField_a_of_type_JavaLangString = ajjy.a(jdField_c_of_type_ArrayOfInt[i]);
      localaxnb.jdField_e_of_type_Int = jdField_d_of_type_ArrayOfInt[i];
      localaxnb.jdField_b_of_type_JavaLangString = ajjy.a(jdField_e_of_type_ArrayOfInt[i]);
      localArrayList.add(localaxnb);
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.f + ajjy.a(jdField_a_of_type_Int) + this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(@Nullable axnb paramaxnb)
  {
    if (paramaxnb == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramaxnb.jdField_a_of_type_Boolean;
    this.f = paramaxnb.f;
    this.jdField_a_of_type_JavaUtilArrayList = paramaxnb.jdField_a_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnb
 * JD-Core Version:    0.7.0.1
 */