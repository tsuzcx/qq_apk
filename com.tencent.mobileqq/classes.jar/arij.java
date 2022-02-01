import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

public class arij
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
  
  public static arij a(ariy paramariy)
  {
    arij localarij = new arij();
    localarij.jdField_a_of_type_Long = paramariy.jdField_a_of_type_Long;
    localarij.jdField_a_of_type_JavaLangString = paramariy.jdField_b_of_type_JavaLangString;
    localarij.jdField_b_of_type_JavaLangString = paramariy.d;
    if (paramariy.jdField_a_of_type_Arie != null)
    {
      localarij.jdField_b_of_type_Long = paramariy.jdField_a_of_type_Arie.jdField_a_of_type_Long;
      Object localObject;
      if ((paramariy.jdField_a_of_type_Arie.jdField_b_of_type_JavaUtilArrayList != null) && (!paramariy.jdField_a_of_type_Arie.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject = (arjj)paramariy.jdField_a_of_type_Arie.jdField_b_of_type_JavaUtilArrayList.get(0);
        localarij.d = ((arjj)localObject).jdField_a_of_type_JavaLangString;
        localarij.jdField_c_of_type_Long = ((arjj)localObject).jdField_a_of_type_Long;
        localarij.jdField_c_of_type_JavaLangString = ((arjj)localObject).jdField_b_of_type_JavaLangString;
      }
      localarij.jdField_a_of_type_Int = paramariy.jdField_a_of_type_Arie.jdField_c_of_type_Int;
      localarij.e = paramariy.jdField_a_of_type_Arie.jdField_b_of_type_JavaLangString;
      localarij.jdField_b_of_type_Int = paramariy.jdField_a_of_type_Arie.jdField_a_of_type_Int;
      if (paramariy.jdField_a_of_type_Arie.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localarij.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramariy.jdField_a_of_type_Arie.jdField_a_of_type_JavaUtilArrayList.size());
        localObject = paramariy.jdField_a_of_type_Arie.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          arji localarji = (arji)((Iterator)localObject).next();
          localarij.jdField_a_of_type_JavaUtilArrayList.add(localarji.jdField_a_of_type_JavaLangString);
        }
      }
      localarij.f = paramariy.jdField_a_of_type_Arie.g;
      localarij.g = paramariy.jdField_a_of_type_Arie.h;
      localarij.jdField_c_of_type_Int = paramariy.jdField_a_of_type_Arie.jdField_b_of_type_Int;
      localarij.jdField_a_of_type_Int = paramariy.jdField_a_of_type_Arie.jdField_c_of_type_Int;
      localarij.h = paramariy.jdField_a_of_type_Arie.jdField_c_of_type_JavaLangString;
      localarij.i = paramariy.jdField_a_of_type_Arie.f;
    }
    return localarij;
  }
  
  public static ariy a(arij paramarij)
  {
    ariy localariy = new ariy();
    localariy.jdField_b_of_type_JavaLangString = paramarij.jdField_a_of_type_JavaLangString;
    localariy.jdField_b_of_type_Int = 0;
    localariy.jdField_a_of_type_Long = paramarij.jdField_a_of_type_Long;
    localariy.d = paramarij.jdField_b_of_type_JavaLangString;
    localariy.jdField_a_of_type_Arie = new arie();
    localariy.jdField_a_of_type_Arie.jdField_a_of_type_Long = paramarij.jdField_b_of_type_Long;
    localariy.jdField_a_of_type_Arie.jdField_b_of_type_JavaUtilArrayList = new ArrayList(1);
    Object localObject = new arjj(paramarij.jdField_c_of_type_JavaLangString, paramarij.d, paramarij.jdField_c_of_type_Long);
    localariy.jdField_a_of_type_Arie.jdField_b_of_type_JavaUtilArrayList.add(localObject);
    localariy.jdField_a_of_type_Arie.jdField_b_of_type_JavaLangString = paramarij.e;
    localariy.jdField_a_of_type_Arie.jdField_a_of_type_Int = paramarij.jdField_b_of_type_Int;
    if (paramarij.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localariy.jdField_a_of_type_Arie.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramarij.jdField_a_of_type_JavaUtilArrayList.size());
      localObject = paramarij.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        arji localarji = new arji();
        localarji.jdField_a_of_type_JavaLangString = str;
        localariy.jdField_a_of_type_Arie.jdField_a_of_type_JavaUtilArrayList.add(localarji);
      }
    }
    localariy.jdField_a_of_type_Arie.g = paramarij.f;
    localariy.jdField_a_of_type_Arie.jdField_b_of_type_Int = paramarij.jdField_c_of_type_Int;
    localariy.jdField_a_of_type_Arie.h = paramarij.g;
    localariy.jdField_a_of_type_Arie.jdField_c_of_type_Int = paramarij.jdField_a_of_type_Int;
    localariy.jdField_a_of_type_Arie.jdField_c_of_type_JavaLangString = paramarij.h;
    localariy.jdField_a_of_type_Arie.f = paramarij.i;
    return localariy;
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
 * Qualified Name:     arij
 * JD-Core Version:    0.7.0.1
 */