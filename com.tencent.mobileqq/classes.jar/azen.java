import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azen
{
  public azbu a;
  public String a;
  public List<azeo> a;
  public azbu b;
  public List<azer> b;
  
  public azen()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public azen(List<azeo> paramList, azbu paramazbu1, List<azer> paramList1, String paramString, azbu paramazbu2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Azbu = paramazbu1;
    this.jdField_b_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Azbu = paramazbu2;
  }
  
  public List<azeo> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return localArrayList;
    }
    if (paramBoolean)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      return localArrayList;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      azeo localazeo = (azeo)localIterator.next();
      if (!localazeo.b) {
        localArrayList.add(localazeo);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azen
 * JD-Core Version:    0.7.0.1
 */