import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bguh
{
  String a;
  public List<bguj> a;
  
  public bguh()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bguh a()
  {
    bguh localbguh = new bguh();
    localbguh.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbguh.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbguh;
  }
  
  public bguj a(int paramInt)
  {
    return (bguj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  @Deprecated
  public void a(int paramInt, String paramString)
  {
    bguj localbguj = new bguj();
    localbguj.jdField_a_of_type_Int = paramInt;
    localbguj.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList.add(localbguj);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    bguj localbguj = new bguj();
    localbguj.jdField_a_of_type_Int = paramInt1;
    localbguj.jdField_a_of_type_JavaLangString = paramString;
    localbguj.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(localbguj);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    bguj localbguj = new bguj();
    localbguj.jdField_a_of_type_Int = paramInt1;
    localbguj.jdField_a_of_type_JavaLangString = paramString;
    localbguj.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(paramInt3, localbguj);
  }
  
  public void a(bguj parambguj)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambguj);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bguj[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bguj[] arrayOfbguj = new bguj[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbguj);
      return arrayOfbguj;
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
        bguj localbguj = (bguj)localIterator.next();
        localStringBuilder.append(" " + localbguj.jdField_a_of_type_JavaLangString + "\n");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguh
 * JD-Core Version:    0.7.0.1
 */