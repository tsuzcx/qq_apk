import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azkt
{
  public azib a;
  public String a;
  public List<azku> a;
  public azib b;
  public List<azkx> b;
  
  public azkt()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public azkt(List<azku> paramList, azib paramazib1, List<azkx> paramList1, String paramString, azib paramazib2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Azib = paramazib1;
    this.jdField_b_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Azib = paramazib2;
  }
  
  public List<azku> a(boolean paramBoolean)
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
      azku localazku = (azku)localIterator.next();
      if (!localazku.a) {
        localArrayList.add(localazku);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkt
 * JD-Core Version:    0.7.0.1
 */