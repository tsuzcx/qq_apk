import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class besc
{
  public long a;
  List<besd> a;
  
  public besc()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  static String a(besc parambesc)
  {
    if ((parambesc == null) || (parambesc.jdField_a_of_type_JavaUtilList == null) || (parambesc.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("names=");
    parambesc = parambesc.jdField_a_of_type_JavaUtilList.iterator();
    int i = 1;
    if (parambesc.hasNext())
    {
      besd localbesd = (besd)parambesc.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localbesd.jdField_a_of_type_JavaLangString);
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
      besd localbesd = (besd)localIterator.next();
      if ((localbesd == null) || (TextUtils.isEmpty(localbesd.jdField_a_of_type_JavaLangString)) || (localbesd.jdField_a_of_type_Besa == null)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(besc parambesc)
  {
    if (parambesc == null) {}
    while (parambesc.jdField_a_of_type_JavaUtilList.size() != this.jdField_a_of_type_JavaUtilList.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= parambesc.jdField_a_of_type_JavaUtilList.size()) {
        break label83;
      }
      besd localbesd = (besd)parambesc.jdField_a_of_type_JavaUtilList.get(i);
      if (!((besd)this.jdField_a_of_type_JavaUtilList.get(i)).a(localbesd)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     besc
 * JD-Core Version:    0.7.0.1
 */