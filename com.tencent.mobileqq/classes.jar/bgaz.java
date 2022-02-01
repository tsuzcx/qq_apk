import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class bgaz
{
  String jdField_a_of_type_JavaLangString;
  List<bgbb> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bgaz a()
  {
    bgaz localbgaz = new bgaz();
    localbgaz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbgaz.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbgaz;
  }
  
  public bgbb a(int paramInt)
  {
    return (bgbb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    paramString = new bgbb(paramInt, paramString);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    paramString = new bgbb(paramInt1, paramString);
    paramString.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    paramString = new bgbb(paramInt1, paramString);
    paramString.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(paramInt3, paramString);
  }
  
  public void a(bgbb parambgbb)
  {
    if (parambgbb != null) {
      this.jdField_a_of_type_JavaUtilList.add(parambgbb);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bgbb[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bgbb[] arrayOfbgbb = new bgbb[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbgbb);
      return arrayOfbgbb;
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
        bgbb localbgbb = (bgbb)localIterator.next();
        localStringBuilder.append(" " + localbgbb.jdField_a_of_type_JavaLangString);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgaz
 * JD-Core Version:    0.7.0.1
 */