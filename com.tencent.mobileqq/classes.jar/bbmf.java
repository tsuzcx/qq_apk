import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbmf
{
  String a;
  public List<bbmh> a;
  
  public bbmf()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bbmf a()
  {
    bbmf localbbmf = new bbmf();
    localbbmf.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbbmf.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbbmf;
  }
  
  public bbmh a(int paramInt)
  {
    return (bbmh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Deprecated
  public void a(int paramInt, String paramString)
  {
    bbmh localbbmh = new bbmh();
    localbbmh.jdField_a_of_type_Int = paramInt;
    localbbmh.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList.add(localbbmh);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    bbmh localbbmh = new bbmh();
    localbbmh.jdField_a_of_type_Int = paramInt1;
    localbbmh.jdField_a_of_type_JavaLangString = paramString;
    localbbmh.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(localbbmh);
  }
  
  public void a(bbmh parambbmh)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambbmh);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bbmh[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bbmh[] arrayOfbbmh = new bbmh[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbbmh);
      return arrayOfbbmh;
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
        bbmh localbbmh = (bbmh)localIterator.next();
        localStringBuilder.append(" " + localbbmh.jdField_a_of_type_JavaLangString + "\n");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmf
 * JD-Core Version:    0.7.0.1
 */