import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bhuk
{
  String a;
  public List<bhum> a;
  
  public bhuk()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bhuk a()
  {
    bhuk localbhuk = new bhuk();
    localbhuk.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbhuk.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbhuk;
  }
  
  public bhum a(int paramInt)
  {
    return (bhum)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    bhum localbhum = new bhum();
    localbhum.jdField_a_of_type_Int = paramInt;
    localbhum.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList.add(localbhum);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    bhum localbhum = new bhum();
    localbhum.jdField_a_of_type_Int = paramInt1;
    localbhum.jdField_a_of_type_JavaLangString = paramString;
    localbhum.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(localbhum);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    bhum localbhum = new bhum();
    localbhum.jdField_a_of_type_Int = paramInt1;
    localbhum.jdField_a_of_type_JavaLangString = paramString;
    localbhum.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(paramInt3, localbhum);
  }
  
  public void a(bhum parambhum)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambhum);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bhum[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bhum[] arrayOfbhum = new bhum[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbhum);
      return arrayOfbhum;
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
        bhum localbhum = (bhum)localIterator.next();
        localStringBuilder.append(" " + localbhum.jdField_a_of_type_JavaLangString + "\n");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhuk
 * JD-Core Version:    0.7.0.1
 */