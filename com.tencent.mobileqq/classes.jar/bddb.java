import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class bddb
{
  static int jdField_a_of_type_Int = 2131698673;
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
    jdField_c_of_type_ArrayOfInt = new int[] { 2131693351, 2131718520, 2131719603, 2131698654, 2131698656 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2130846070, 2130846072, 2130846073, 2130844730, 2130846071 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131698653, 2131698669, 2131698687, 2131698655, 2131698657 };
  }
  
  public static Drawable a(Context paramContext, bddb parambddb)
  {
    switch (parambddb.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 1001: 
      return paramContext.getResources().getDrawable(2130846070);
    case 1004: 
      return paramContext.getResources().getDrawable(2130846071);
    case 1003: 
      return paramContext.getResources().getDrawable(2130846072);
    case 1002: 
      return paramContext.getResources().getDrawable(2130846073);
    }
    return paramContext.getResources().getDrawable(2130844730);
  }
  
  public static ArrayList<bddb> a()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      bddb localbddb = new bddb();
      localbddb.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i];
      localbddb.jdField_c_of_type_Int = i;
      localbddb.jdField_d_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localbddb.jdField_a_of_type_JavaLangString = amtj.a(jdField_c_of_type_ArrayOfInt[i]);
      localbddb.jdField_e_of_type_Int = jdField_d_of_type_ArrayOfInt[i];
      localbddb.jdField_b_of_type_JavaLangString = amtj.a(jdField_e_of_type_ArrayOfInt[i]);
      localArrayList.add(localbddb);
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.f + amtj.a(jdField_a_of_type_Int);
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(@Nullable bddb parambddb)
  {
    if (parambddb == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = parambddb.jdField_a_of_type_Boolean;
    this.f = parambddb.f;
    this.jdField_a_of_type_JavaUtilArrayList = parambddb.jdField_a_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddb
 * JD-Core Version:    0.7.0.1
 */