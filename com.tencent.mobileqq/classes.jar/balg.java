import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class balg
{
  static int jdField_a_of_type_Int = 2131699947;
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
    jdField_c_of_type_ArrayOfInt = new int[] { 2131693936, 2131721402, 2131720201, 2131699944 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2130845676, 2130845679, 2130845678, 2130845677 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131699943, 2131699952, 2131699946, 2131699945 };
  }
  
  public static Drawable a(Context paramContext, balg parambalg)
  {
    switch (parambalg.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 1001: 
      return paramContext.getResources().getDrawable(2130845676);
    case 1004: 
      return paramContext.getResources().getDrawable(2130845677);
    case 1003: 
      return paramContext.getResources().getDrawable(2130845678);
    }
    return paramContext.getResources().getDrawable(2130845679);
  }
  
  public static ArrayList<balg> a()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      balg localbalg = new balg();
      localbalg.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i];
      localbalg.jdField_c_of_type_Int = i;
      localbalg.jdField_d_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localbalg.jdField_a_of_type_JavaLangString = alpo.a(jdField_c_of_type_ArrayOfInt[i]);
      localbalg.jdField_e_of_type_Int = jdField_d_of_type_ArrayOfInt[i];
      localbalg.jdField_b_of_type_JavaLangString = alpo.a(jdField_e_of_type_ArrayOfInt[i]);
      localArrayList.add(localbalg);
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.f + alpo.a(jdField_a_of_type_Int) + this.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(@Nullable balg parambalg)
  {
    if (parambalg == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = parambalg.jdField_a_of_type_Boolean;
    this.f = parambalg.f;
    this.jdField_a_of_type_JavaUtilArrayList = parambalg.jdField_a_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     balg
 * JD-Core Version:    0.7.0.1
 */