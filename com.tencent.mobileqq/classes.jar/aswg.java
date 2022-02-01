import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

public class aswg
{
  public int a;
  public long a;
  public String a;
  public ArrayList<String> a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public static aswg a(aswv paramaswv)
  {
    aswg localaswg = new aswg();
    localaswg.jdField_a_of_type_Long = paramaswv.jdField_a_of_type_Long;
    localaswg.jdField_a_of_type_JavaLangString = paramaswv.jdField_b_of_type_JavaLangString;
    localaswg.jdField_b_of_type_JavaLangString = paramaswv.d;
    if (paramaswv.jdField_a_of_type_Aswb != null)
    {
      localaswg.jdField_b_of_type_Long = paramaswv.jdField_a_of_type_Aswb.jdField_a_of_type_Long;
      Object localObject;
      if ((paramaswv.jdField_a_of_type_Aswb.jdField_b_of_type_JavaUtilArrayList != null) && (!paramaswv.jdField_a_of_type_Aswb.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject = (asxg)paramaswv.jdField_a_of_type_Aswb.jdField_b_of_type_JavaUtilArrayList.get(0);
        localaswg.d = ((asxg)localObject).jdField_a_of_type_JavaLangString;
        localaswg.jdField_c_of_type_Long = ((asxg)localObject).jdField_a_of_type_Long;
        localaswg.jdField_c_of_type_JavaLangString = ((asxg)localObject).jdField_b_of_type_JavaLangString;
      }
      localaswg.jdField_a_of_type_Int = paramaswv.jdField_a_of_type_Aswb.jdField_c_of_type_Int;
      localaswg.e = paramaswv.jdField_a_of_type_Aswb.jdField_b_of_type_JavaLangString;
      localaswg.jdField_b_of_type_Int = paramaswv.jdField_a_of_type_Aswb.jdField_a_of_type_Int;
      if (paramaswv.jdField_a_of_type_Aswb.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localaswg.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramaswv.jdField_a_of_type_Aswb.jdField_a_of_type_JavaUtilArrayList.size());
        localObject = paramaswv.jdField_a_of_type_Aswb.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          asxf localasxf = (asxf)((Iterator)localObject).next();
          localaswg.jdField_a_of_type_JavaUtilArrayList.add(localasxf.jdField_a_of_type_JavaLangString);
        }
      }
      localaswg.f = paramaswv.jdField_a_of_type_Aswb.g;
      localaswg.g = paramaswv.jdField_a_of_type_Aswb.h;
      localaswg.jdField_c_of_type_Int = paramaswv.jdField_a_of_type_Aswb.jdField_b_of_type_Int;
      localaswg.jdField_a_of_type_Int = paramaswv.jdField_a_of_type_Aswb.jdField_c_of_type_Int;
      localaswg.h = paramaswv.jdField_a_of_type_Aswb.jdField_c_of_type_JavaLangString;
      localaswg.i = paramaswv.jdField_a_of_type_Aswb.f;
    }
    return localaswg;
  }
  
  public static aswv a(aswg paramaswg)
  {
    aswv localaswv = new aswv();
    localaswv.jdField_b_of_type_JavaLangString = paramaswg.jdField_a_of_type_JavaLangString;
    localaswv.jdField_b_of_type_Int = 0;
    localaswv.jdField_a_of_type_Long = paramaswg.jdField_a_of_type_Long;
    localaswv.d = paramaswg.jdField_b_of_type_JavaLangString;
    localaswv.jdField_a_of_type_Aswb = new aswb();
    localaswv.jdField_a_of_type_Aswb.jdField_a_of_type_Long = paramaswg.jdField_b_of_type_Long;
    localaswv.jdField_a_of_type_Aswb.jdField_b_of_type_JavaUtilArrayList = new ArrayList(1);
    Object localObject = new asxg(paramaswg.jdField_c_of_type_JavaLangString, paramaswg.d, paramaswg.jdField_c_of_type_Long);
    localaswv.jdField_a_of_type_Aswb.jdField_b_of_type_JavaUtilArrayList.add(localObject);
    localaswv.jdField_a_of_type_Aswb.jdField_b_of_type_JavaLangString = paramaswg.e;
    localaswv.jdField_a_of_type_Aswb.jdField_a_of_type_Int = paramaswg.jdField_b_of_type_Int;
    if (paramaswg.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localaswv.jdField_a_of_type_Aswb.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramaswg.jdField_a_of_type_JavaUtilArrayList.size());
      localObject = paramaswg.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        asxf localasxf = new asxf();
        localasxf.jdField_a_of_type_JavaLangString = str;
        localaswv.jdField_a_of_type_Aswb.jdField_a_of_type_JavaUtilArrayList.add(localasxf);
      }
    }
    localaswv.jdField_a_of_type_Aswb.g = paramaswg.f;
    localaswv.jdField_a_of_type_Aswb.jdField_b_of_type_Int = paramaswg.jdField_c_of_type_Int;
    localaswv.jdField_a_of_type_Aswb.h = paramaswg.g;
    localaswv.jdField_a_of_type_Aswb.jdField_c_of_type_Int = paramaswg.jdField_a_of_type_Int;
    localaswv.jdField_a_of_type_Aswb.jdField_c_of_type_JavaLangString = paramaswg.h;
    localaswv.jdField_a_of_type_Aswb.f = paramaswg.i;
    return localaswv;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Long == 2L;
  }
  
  @NonNull
  public String toString()
  {
    return String.format("uin:%s,nick:%s,dis:%d", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswg
 * JD-Core Version:    0.7.0.1
 */