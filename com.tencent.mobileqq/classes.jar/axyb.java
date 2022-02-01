import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axyb
{
  public axvj a;
  public String a;
  public List<axyc> a;
  public axvj b;
  public List<axyf> b;
  
  public axyb()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public axyb(List<axyc> paramList, axvj paramaxvj1, List<axyf> paramList1, String paramString, axvj paramaxvj2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Axvj = paramaxvj1;
    this.jdField_b_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Axvj = paramaxvj2;
  }
  
  public List<axyc> a(boolean paramBoolean)
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
      axyc localaxyc = (axyc)localIterator.next();
      if (!localaxyc.a) {
        localArrayList.add(localaxyc);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyb
 * JD-Core Version:    0.7.0.1
 */