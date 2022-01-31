import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class ayni
{
  static int jdField_a_of_type_Int = 2131699581;
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
    jdField_c_of_type_ArrayOfInt = new int[] { 2131693819, 2131720846, 2131719658, 2131699578 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2130845305, 2130845308, 2130845307, 2130845306 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131699577, 2131699586, 2131699580, 2131699579 };
  }
  
  public static Drawable a(Context paramContext, ayni paramayni)
  {
    switch (paramayni.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 1001: 
      return paramContext.getResources().getDrawable(2130845305);
    case 1004: 
      return paramContext.getResources().getDrawable(2130845306);
    case 1003: 
      return paramContext.getResources().getDrawable(2130845307);
    }
    return paramContext.getResources().getDrawable(2130845308);
  }
  
  public static ArrayList<ayni> a()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      ayni localayni = new ayni();
      localayni.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i];
      localayni.jdField_c_of_type_Int = i;
      localayni.jdField_d_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localayni.jdField_a_of_type_JavaLangString = ajyc.a(jdField_c_of_type_ArrayOfInt[i]);
      localayni.jdField_e_of_type_Int = jdField_d_of_type_ArrayOfInt[i];
      localayni.jdField_b_of_type_JavaLangString = ajyc.a(jdField_e_of_type_ArrayOfInt[i]);
      localArrayList.add(localayni);
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.f + ajyc.a(jdField_a_of_type_Int) + this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(@Nullable ayni paramayni)
  {
    if (paramayni == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramayni.jdField_a_of_type_Boolean;
    this.f = paramayni.f;
    this.jdField_a_of_type_JavaUtilArrayList = paramayni.jdField_a_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayni
 * JD-Core Version:    0.7.0.1
 */