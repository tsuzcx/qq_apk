import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

public class asgs
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
  
  public static asgs a(ashh paramashh)
  {
    asgs localasgs = new asgs();
    localasgs.jdField_a_of_type_Long = paramashh.jdField_a_of_type_Long;
    localasgs.jdField_a_of_type_JavaLangString = paramashh.jdField_b_of_type_JavaLangString;
    localasgs.jdField_b_of_type_JavaLangString = paramashh.d;
    if (paramashh.jdField_a_of_type_Asgn != null)
    {
      localasgs.jdField_b_of_type_Long = paramashh.jdField_a_of_type_Asgn.jdField_a_of_type_Long;
      Object localObject;
      if ((paramashh.jdField_a_of_type_Asgn.jdField_b_of_type_JavaUtilArrayList != null) && (!paramashh.jdField_a_of_type_Asgn.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject = (ashs)paramashh.jdField_a_of_type_Asgn.jdField_b_of_type_JavaUtilArrayList.get(0);
        localasgs.d = ((ashs)localObject).jdField_a_of_type_JavaLangString;
        localasgs.jdField_c_of_type_Long = ((ashs)localObject).jdField_a_of_type_Long;
        localasgs.jdField_c_of_type_JavaLangString = ((ashs)localObject).jdField_b_of_type_JavaLangString;
      }
      localasgs.jdField_a_of_type_Int = paramashh.jdField_a_of_type_Asgn.jdField_c_of_type_Int;
      localasgs.e = paramashh.jdField_a_of_type_Asgn.jdField_b_of_type_JavaLangString;
      localasgs.jdField_b_of_type_Int = paramashh.jdField_a_of_type_Asgn.jdField_a_of_type_Int;
      if (paramashh.jdField_a_of_type_Asgn.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localasgs.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramashh.jdField_a_of_type_Asgn.jdField_a_of_type_JavaUtilArrayList.size());
        localObject = paramashh.jdField_a_of_type_Asgn.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ashr localashr = (ashr)((Iterator)localObject).next();
          localasgs.jdField_a_of_type_JavaUtilArrayList.add(localashr.jdField_a_of_type_JavaLangString);
        }
      }
      localasgs.f = paramashh.jdField_a_of_type_Asgn.g;
      localasgs.g = paramashh.jdField_a_of_type_Asgn.h;
      localasgs.jdField_c_of_type_Int = paramashh.jdField_a_of_type_Asgn.jdField_b_of_type_Int;
      localasgs.jdField_a_of_type_Int = paramashh.jdField_a_of_type_Asgn.jdField_c_of_type_Int;
      localasgs.h = paramashh.jdField_a_of_type_Asgn.jdField_c_of_type_JavaLangString;
      localasgs.i = paramashh.jdField_a_of_type_Asgn.f;
    }
    return localasgs;
  }
  
  public static ashh a(asgs paramasgs)
  {
    ashh localashh = new ashh();
    localashh.jdField_b_of_type_JavaLangString = paramasgs.jdField_a_of_type_JavaLangString;
    localashh.jdField_b_of_type_Int = 0;
    localashh.jdField_a_of_type_Long = paramasgs.jdField_a_of_type_Long;
    localashh.d = paramasgs.jdField_b_of_type_JavaLangString;
    localashh.jdField_a_of_type_Asgn = new asgn();
    localashh.jdField_a_of_type_Asgn.jdField_a_of_type_Long = paramasgs.jdField_b_of_type_Long;
    localashh.jdField_a_of_type_Asgn.jdField_b_of_type_JavaUtilArrayList = new ArrayList(1);
    Object localObject = new ashs(paramasgs.jdField_c_of_type_JavaLangString, paramasgs.d, paramasgs.jdField_c_of_type_Long);
    localashh.jdField_a_of_type_Asgn.jdField_b_of_type_JavaUtilArrayList.add(localObject);
    localashh.jdField_a_of_type_Asgn.jdField_b_of_type_JavaLangString = paramasgs.e;
    localashh.jdField_a_of_type_Asgn.jdField_a_of_type_Int = paramasgs.jdField_b_of_type_Int;
    if (paramasgs.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localashh.jdField_a_of_type_Asgn.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramasgs.jdField_a_of_type_JavaUtilArrayList.size());
      localObject = paramasgs.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ashr localashr = new ashr();
        localashr.jdField_a_of_type_JavaLangString = str;
        localashh.jdField_a_of_type_Asgn.jdField_a_of_type_JavaUtilArrayList.add(localashr);
      }
    }
    localashh.jdField_a_of_type_Asgn.g = paramasgs.f;
    localashh.jdField_a_of_type_Asgn.jdField_b_of_type_Int = paramasgs.jdField_c_of_type_Int;
    localashh.jdField_a_of_type_Asgn.h = paramasgs.g;
    localashh.jdField_a_of_type_Asgn.jdField_c_of_type_Int = paramasgs.jdField_a_of_type_Int;
    localashh.jdField_a_of_type_Asgn.jdField_c_of_type_JavaLangString = paramasgs.h;
    localashh.jdField_a_of_type_Asgn.f = paramasgs.i;
    return localashh;
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
 * Qualified Name:     asgs
 * JD-Core Version:    0.7.0.1
 */