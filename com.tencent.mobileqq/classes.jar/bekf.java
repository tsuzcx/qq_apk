import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class bekf
{
  static int jdField_a_of_type_Int = 2131698485;
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
    jdField_c_of_type_ArrayOfInt = new int[] { 2131693262, 2131719285, 2131718279, 2131698482 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2130846179, 2130846182, 2130846181, 2130846180 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131698481, 2131698490, 2131698484, 2131698483 };
  }
  
  public static Drawable a(Context paramContext, bekf parambekf)
  {
    switch (parambekf.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 1001: 
      return paramContext.getResources().getDrawable(2130846179);
    case 1004: 
      return paramContext.getResources().getDrawable(2130846180);
    case 1003: 
      return paramContext.getResources().getDrawable(2130846181);
    }
    return paramContext.getResources().getDrawable(2130846182);
  }
  
  public static ArrayList<bekf> a()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      bekf localbekf = new bekf();
      localbekf.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i];
      localbekf.jdField_c_of_type_Int = i;
      localbekf.jdField_d_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localbekf.jdField_a_of_type_JavaLangString = anzj.a(jdField_c_of_type_ArrayOfInt[i]);
      localbekf.jdField_e_of_type_Int = jdField_d_of_type_ArrayOfInt[i];
      localbekf.jdField_b_of_type_JavaLangString = anzj.a(jdField_e_of_type_ArrayOfInt[i]);
      localArrayList.add(localbekf);
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.f + anzj.a(jdField_a_of_type_Int) + this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(@Nullable bekf parambekf)
  {
    if (parambekf == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = parambekf.jdField_a_of_type_Boolean;
    this.f = parambekf.f;
    this.jdField_a_of_type_JavaUtilArrayList = parambekf.jdField_a_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekf
 * JD-Core Version:    0.7.0.1
 */