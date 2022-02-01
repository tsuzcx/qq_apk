import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class bekd
{
  static int jdField_a_of_type_Int = 2131698984;
  static int[] jdField_a_of_type_ArrayOfInt = { 1001, 1003, 1002, 1005, 1004 };
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
    jdField_b_of_type_ArrayOfInt = new int[] { -8293377, -35897, -42646, -3243777, -16725252 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131693532, 2131718906, 2131720056, 2131698965, 2131698967 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2130846159, 2130846161, 2130846162, 2130844801, 2130846160 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131698964, 2131698980, 2131698998, 2131698966, 2131698968 };
  }
  
  public static Drawable a(Context paramContext, bekd parambekd)
  {
    switch (parambekd.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 1001: 
      return paramContext.getResources().getDrawable(2130846159);
    case 1004: 
      return paramContext.getResources().getDrawable(2130846160);
    case 1003: 
      return paramContext.getResources().getDrawable(2130846161);
    case 1002: 
      return paramContext.getResources().getDrawable(2130846162);
    }
    return paramContext.getResources().getDrawable(2130844801);
  }
  
  public static ArrayList<bekd> a()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      bekd localbekd = new bekd();
      localbekd.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i];
      localbekd.jdField_c_of_type_Int = i;
      localbekd.jdField_d_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localbekd.jdField_a_of_type_JavaLangString = anvx.a(jdField_c_of_type_ArrayOfInt[i]);
      localbekd.jdField_e_of_type_Int = jdField_d_of_type_ArrayOfInt[i];
      localbekd.jdField_b_of_type_JavaLangString = anvx.a(jdField_e_of_type_ArrayOfInt[i]);
      localArrayList.add(localbekd);
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.f + anvx.a(jdField_a_of_type_Int);
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(@Nullable bekd parambekd)
  {
    if (parambekd == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = parambekd.jdField_a_of_type_Boolean;
    this.f = parambekd.f;
    this.jdField_a_of_type_JavaUtilArrayList = parambekd.jdField_a_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekd
 * JD-Core Version:    0.7.0.1
 */