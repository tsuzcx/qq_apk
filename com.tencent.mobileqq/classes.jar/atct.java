import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atct
{
  public int a;
  public List<atcs> a;
  
  public atct()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  public String toString()
  {
    if (a()) {
      localObject = "TPType:" + this.jdField_a_of_type_Int + "IPList:";
    }
    String str;
    Iterator localIterator;
    do
    {
      return localObject;
      str = "TPType:" + this.jdField_a_of_type_Int + "IPList:";
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject = str;
    } while (!localIterator.hasNext());
    Object localObject = (atcs)localIterator.next();
    if (localObject != null) {
      if (!TextUtils.isEmpty(((atcs)localObject).jdField_a_of_type_JavaLangString))
      {
        localObject = ((atcs)localObject).jdField_a_of_type_JavaLangString + ":" + ((atcs)localObject).jdField_a_of_type_Int + " ";
        label145:
        str = str + (String)localObject;
      }
    }
    for (;;)
    {
      break;
      localObject = ":" + ((atcs)localObject).jdField_a_of_type_Int + " ";
      break label145;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atct
 * JD-Core Version:    0.7.0.1
 */