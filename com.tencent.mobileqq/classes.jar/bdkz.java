import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdkz
{
  String a;
  public List<bdlb> a;
  
  public bdkz()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bdkz a()
  {
    bdkz localbdkz = new bdkz();
    localbdkz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbdkz.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbdkz;
  }
  
  public bdlb a(int paramInt)
  {
    return (bdlb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Deprecated
  public void a(int paramInt, String paramString)
  {
    bdlb localbdlb = new bdlb();
    localbdlb.jdField_a_of_type_Int = paramInt;
    localbdlb.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList.add(localbdlb);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    bdlb localbdlb = new bdlb();
    localbdlb.jdField_a_of_type_Int = paramInt1;
    localbdlb.jdField_a_of_type_JavaLangString = paramString;
    localbdlb.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(localbdlb);
  }
  
  public void a(bdlb parambdlb)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambdlb);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bdlb[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bdlb[] arrayOfbdlb = new bdlb[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbdlb);
      return arrayOfbdlb;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bdlb localbdlb = (bdlb)localIterator.next();
        localStringBuilder.append(" " + localbdlb.jdField_a_of_type_JavaLangString + "\n");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkz
 * JD-Core Version:    0.7.0.1
 */