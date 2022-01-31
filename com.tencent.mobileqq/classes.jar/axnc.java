import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class axnc
{
  long jdField_a_of_type_Long = 0L;
  List<axnd> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  static String a(axnc paramaxnc)
  {
    if ((paramaxnc == null) || (paramaxnc.jdField_a_of_type_JavaUtilList == null) || (paramaxnc.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("names=");
    paramaxnc = paramaxnc.jdField_a_of_type_JavaUtilList.iterator();
    int i = 1;
    if (paramaxnc.hasNext())
    {
      axnd localaxnd = (axnd)paramaxnc.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localaxnd.jdField_a_of_type_JavaLangString);
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      axnd localaxnd = (axnd)localIterator.next();
      if ((localaxnd == null) || (TextUtils.isEmpty(localaxnd.jdField_a_of_type_JavaLangString)) || (localaxnd.jdField_a_of_type_Axna == null)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(axnc paramaxnc)
  {
    if (paramaxnc == null) {}
    while (paramaxnc.jdField_a_of_type_JavaUtilList.size() != this.jdField_a_of_type_JavaUtilList.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramaxnc.jdField_a_of_type_JavaUtilList.size()) {
        break label83;
      }
      axnd localaxnd = (axnd)paramaxnc.jdField_a_of_type_JavaUtilList.get(i);
      if (!((axnd)this.jdField_a_of_type_JavaUtilList.get(i)).a(localaxnd)) {
        break;
      }
      i += 1;
    }
    label83:
    return true;
  }
  
  public String toString()
  {
    return "LoadParam{mLoadItems=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnc
 * JD-Core Version:    0.7.0.1
 */