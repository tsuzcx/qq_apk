import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class bhjq
{
  String jdField_a_of_type_JavaLangString;
  List<bhjs> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bhjq a()
  {
    bhjq localbhjq = new bhjq();
    localbhjq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbhjq.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localbhjq;
  }
  
  public bhjs a(int paramInt)
  {
    return (bhjs)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    paramString = new bhjs(paramInt, paramString);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    paramString = new bhjs(paramInt1, paramString);
    paramString.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    paramString = new bhjs(paramInt1, paramString);
    paramString.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList.add(paramInt3, paramString);
  }
  
  public void a(bhjs parambhjs)
  {
    if (parambhjs != null) {
      this.jdField_a_of_type_JavaUtilList.add(parambhjs);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bhjs[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      bhjs[] arrayOfbhjs = new bhjs[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbhjs);
      return arrayOfbhjs;
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
        bhjs localbhjs = (bhjs)localIterator.next();
        localStringBuilder.append(" " + localbhjs.jdField_a_of_type_JavaLangString);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjq
 * JD-Core Version:    0.7.0.1
 */