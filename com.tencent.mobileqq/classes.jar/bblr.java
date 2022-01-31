import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bblr
{
  String a;
  public List<bblt> a;
  
  public bblr()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bblr a()
  {
    bblr localbblr = new bblr();
    localbblr.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbblr.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbblr;
  }
  
  public bblt a(int paramInt)
  {
    return (bblt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Deprecated
  public void a(int paramInt, String paramString)
  {
    bblt localbblt = new bblt();
    localbblt.jdField_a_of_type_Int = paramInt;
    localbblt.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList.add(localbblt);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    bblt localbblt = new bblt();
    localbblt.jdField_a_of_type_Int = paramInt1;
    localbblt.jdField_a_of_type_JavaLangString = paramString;
    localbblt.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(localbblt);
  }
  
  public void a(bblt parambblt)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambblt);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bblt[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bblt[] arrayOfbblt = new bblt[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbblt);
      return arrayOfbblt;
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
        bblt localbblt = (bblt)localIterator.next();
        localStringBuilder.append(" " + localbblt.jdField_a_of_type_JavaLangString + "\n");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblr
 * JD-Core Version:    0.7.0.1
 */