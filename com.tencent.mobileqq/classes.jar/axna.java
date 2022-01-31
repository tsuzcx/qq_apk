import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class axna
{
  long jdField_a_of_type_Long = 0L;
  List<axnb> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  static String a(axna paramaxna)
  {
    if ((paramaxna == null) || (paramaxna.jdField_a_of_type_JavaUtilList == null) || (paramaxna.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("names=");
    paramaxna = paramaxna.jdField_a_of_type_JavaUtilList.iterator();
    int i = 1;
    if (paramaxna.hasNext())
    {
      axnb localaxnb = (axnb)paramaxna.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localaxnb.jdField_a_of_type_JavaLangString);
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
      axnb localaxnb = (axnb)localIterator.next();
      if ((localaxnb == null) || (TextUtils.isEmpty(localaxnb.jdField_a_of_type_JavaLangString)) || (localaxnb.jdField_a_of_type_Axmy == null)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(axna paramaxna)
  {
    if (paramaxna == null) {}
    while (paramaxna.jdField_a_of_type_JavaUtilList.size() != this.jdField_a_of_type_JavaUtilList.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramaxna.jdField_a_of_type_JavaUtilList.size()) {
        break label83;
      }
      axnb localaxnb = (axnb)paramaxna.jdField_a_of_type_JavaUtilList.get(i);
      if (!((axnb)this.jdField_a_of_type_JavaUtilList.get(i)).a(localaxnb)) {
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
 * Qualified Name:     axna
 * JD-Core Version:    0.7.0.1
 */