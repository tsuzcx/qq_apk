import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class azms
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  long jdField_a_of_type_Long = 0L;
  List<azmt> jdField_a_of_type_JavaUtilList = new LinkedList();
  int d = jdField_a_of_type_Int;
  
  static int a(azms paramazms)
  {
    if ((paramazms == null) || (paramazms.jdField_a_of_type_JavaUtilList == null)) {
      return 0;
    }
    return paramazms.jdField_a_of_type_JavaUtilList.size();
  }
  
  static String a(azms paramazms)
  {
    if ((paramazms == null) || (paramazms.jdField_a_of_type_JavaUtilList == null) || (paramazms.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("names=");
    paramazms = paramazms.jdField_a_of_type_JavaUtilList.iterator();
    int i = 1;
    if (paramazms.hasNext())
    {
      azmt localazmt = (azmt)paramazms.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localazmt.jdField_a_of_type_JavaLangString);
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  static boolean a(azms paramazms)
  {
    return (paramazms != null) && (paramazms.a());
  }
  
  boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      azmt localazmt = (azmt)localIterator.next();
      if ((localazmt == null) || (TextUtils.isEmpty(localazmt.jdField_a_of_type_JavaLangString)) || (localazmt.jdField_a_of_type_Azmq == null)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean b(azms paramazms)
  {
    if (paramazms == null) {}
    while ((this.d != paramazms.d) || (paramazms.jdField_a_of_type_JavaUtilList.size() != this.jdField_a_of_type_JavaUtilList.size())) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramazms.jdField_a_of_type_JavaUtilList.size()) {
        break label94;
      }
      azmt localazmt = (azmt)paramazms.jdField_a_of_type_JavaUtilList.get(i);
      if (!((azmt)this.jdField_a_of_type_JavaUtilList.get(i)).a(localazmt)) {
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
 * Qualified Name:     azms
 * JD-Core Version:    0.7.0.1
 */