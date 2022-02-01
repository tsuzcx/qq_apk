import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aysa
{
  public aypi a;
  public String a;
  public List<aysb> a;
  public aypi b;
  public List<ayse> b;
  
  public aysa()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public aysa(List<aysb> paramList, aypi paramaypi1, List<ayse> paramList1, String paramString, aypi paramaypi2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Aypi = paramaypi1;
    this.jdField_b_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Aypi = paramaypi2;
  }
  
  public List<aysb> a(boolean paramBoolean)
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
      aysb localaysb = (aysb)localIterator.next();
      if (!localaysb.a) {
        localArrayList.add(localaysb);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysa
 * JD-Core Version:    0.7.0.1
 */