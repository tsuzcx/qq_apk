import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdpi
{
  String a;
  public List<bdpk> a;
  
  public bdpi()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bdpi a()
  {
    bdpi localbdpi = new bdpi();
    localbdpi.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbdpi.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbdpi;
  }
  
  public bdpk a(int paramInt)
  {
    return (bdpk)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Deprecated
  public void a(int paramInt, String paramString)
  {
    bdpk localbdpk = new bdpk();
    localbdpk.jdField_a_of_type_Int = paramInt;
    localbdpk.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList.add(localbdpk);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    bdpk localbdpk = new bdpk();
    localbdpk.jdField_a_of_type_Int = paramInt1;
    localbdpk.jdField_a_of_type_JavaLangString = paramString;
    localbdpk.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(localbdpk);
  }
  
  public void a(bdpk parambdpk)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambdpk);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bdpk[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bdpk[] arrayOfbdpk = new bdpk[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbdpk);
      return arrayOfbdpk;
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
        bdpk localbdpk = (bdpk)localIterator.next();
        localStringBuilder.append(" " + localbdpk.jdField_a_of_type_JavaLangString + "\n");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpi
 * JD-Core Version:    0.7.0.1
 */