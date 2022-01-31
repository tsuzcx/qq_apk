import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bakh
{
  String a;
  public List<bakj> a;
  
  public bakh()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bakh a()
  {
    bakh localbakh = new bakh();
    localbakh.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbakh.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbakh;
  }
  
  public bakj a(int paramInt)
  {
    return (bakj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Deprecated
  public void a(int paramInt, String paramString)
  {
    bakj localbakj = new bakj();
    localbakj.jdField_a_of_type_Int = paramInt;
    localbakj.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList.add(localbakj);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    bakj localbakj = new bakj();
    localbakj.jdField_a_of_type_Int = paramInt1;
    localbakj.jdField_a_of_type_JavaLangString = paramString;
    localbakj.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(localbakj);
  }
  
  public void a(bakj parambakj)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambakj);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bakj[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bakj[] arrayOfbakj = new bakj[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbakj);
      return arrayOfbakj;
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
        bakj localbakj = (bakj)localIterator.next();
        localStringBuilder.append(" " + localbakj.jdField_a_of_type_JavaLangString + "\n");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakh
 * JD-Core Version:    0.7.0.1
 */