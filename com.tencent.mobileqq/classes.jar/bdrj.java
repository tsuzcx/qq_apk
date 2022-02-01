import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class bdrj
{
  static int jdField_a_of_type_Int = 2131698383;
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
    jdField_c_of_type_ArrayOfInt = new int[] { 2131693250, 2131719116, 2131718146, 2131698380 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2130846164, 2130846167, 2130846166, 2130846165 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131698379, 2131698388, 2131698382, 2131698381 };
  }
  
  public static Drawable a(Context paramContext, bdrj parambdrj)
  {
    switch (parambdrj.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 1001: 
      return paramContext.getResources().getDrawable(2130846164);
    case 1004: 
      return paramContext.getResources().getDrawable(2130846165);
    case 1003: 
      return paramContext.getResources().getDrawable(2130846166);
    }
    return paramContext.getResources().getDrawable(2130846167);
  }
  
  public static ArrayList<bdrj> a()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      bdrj localbdrj = new bdrj();
      localbdrj.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i];
      localbdrj.jdField_c_of_type_Int = i;
      localbdrj.jdField_d_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localbdrj.jdField_a_of_type_JavaLangString = anni.a(jdField_c_of_type_ArrayOfInt[i]);
      localbdrj.jdField_e_of_type_Int = jdField_d_of_type_ArrayOfInt[i];
      localbdrj.jdField_b_of_type_JavaLangString = anni.a(jdField_e_of_type_ArrayOfInt[i]);
      localArrayList.add(localbdrj);
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.f + anni.a(jdField_a_of_type_Int) + this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(@Nullable bdrj parambdrj)
  {
    if (parambdrj == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = parambdrj.jdField_a_of_type_Boolean;
    this.f = parambdrj.f;
    this.jdField_a_of_type_JavaUtilArrayList = parambdrj.jdField_a_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrj
 * JD-Core Version:    0.7.0.1
 */