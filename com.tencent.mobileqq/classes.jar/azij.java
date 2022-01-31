import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class azij
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  long jdField_a_of_type_Long = 0L;
  List<azik> jdField_a_of_type_JavaUtilList = new LinkedList();
  int d = jdField_a_of_type_Int;
  
  static int a(azij paramazij)
  {
    if ((paramazij == null) || (paramazij.jdField_a_of_type_JavaUtilList == null)) {
      return 0;
    }
    return paramazij.jdField_a_of_type_JavaUtilList.size();
  }
  
  static String a(azij paramazij)
  {
    if ((paramazij == null) || (paramazij.jdField_a_of_type_JavaUtilList == null) || (paramazij.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("names=");
    paramazij = paramazij.jdField_a_of_type_JavaUtilList.iterator();
    int i = 1;
    if (paramazij.hasNext())
    {
      azik localazik = (azik)paramazij.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localazik.jdField_a_of_type_JavaLangString);
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  static boolean a(azij paramazij)
  {
    return (paramazij != null) && (paramazij.a());
  }
  
  boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      azik localazik = (azik)localIterator.next();
      if ((localazik == null) || (TextUtils.isEmpty(localazik.jdField_a_of_type_JavaLangString)) || (localazik.jdField_a_of_type_Azih == null)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean b(azij paramazij)
  {
    if (paramazij == null) {}
    while ((this.d != paramazij.d) || (paramazij.jdField_a_of_type_JavaUtilList.size() != this.jdField_a_of_type_JavaUtilList.size())) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramazij.jdField_a_of_type_JavaUtilList.size()) {
        break label94;
      }
      azik localazik = (azik)paramazij.jdField_a_of_type_JavaUtilList.get(i);
      if (!((azik)this.jdField_a_of_type_JavaUtilList.get(i)).a(localazik)) {
        break;
      }
      i += 1;
    }
    label94:
    return true;
  }
  
  public String toString()
  {
    return "LoadParam{mCallType=" + this.d + "mLoadItems=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azij
 * JD-Core Version:    0.7.0.1
 */