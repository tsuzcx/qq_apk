import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atuo
{
  public int a;
  public List<atun> a;
  
  public atuo()
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
    Object localObject = (atun)localIterator.next();
    if (localObject != null) {
      if (!TextUtils.isEmpty(((atun)localObject).jdField_a_of_type_JavaLangString))
      {
        localObject = ((atun)localObject).jdField_a_of_type_JavaLangString + ":" + ((atun)localObject).jdField_a_of_type_Int + " ";
        label145:
        str = str + (String)localObject;
      }
    }
    for (;;)
    {
      break;
      localObject = ":" + ((atun)localObject).jdField_a_of_type_Int + " ";
      break label145;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atuo
 * JD-Core Version:    0.7.0.1
 */