import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class aspr
{
  int jdField_a_of_type_Int;
  aspr jdField_a_of_type_Aspr;
  ArrayList<aspr> jdField_a_of_type_JavaUtilArrayList;
  HashMap<Integer, Object> jdField_a_of_type_JavaUtilHashMap;
  
  public aspr(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder2.append("\t");
      i += 1;
    }
    localStringBuilder1.append(localStringBuilder2).append(aspq.a(this.jdField_a_of_type_Int)).append(":[\n");
    localStringBuilder1.append(localStringBuilder2).append("\tfields").append(":[\n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      String str = aspq.b(((Integer)localObject).intValue());
      localObject = this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      localStringBuilder1.append(localStringBuilder2).append("\t\t").append(str).append(":").append(localObject).append("\n");
    }
    localStringBuilder1.append(localStringBuilder2).append("\t]").append("\n");
    localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder1.append(((aspr)localIterator.next()).a(paramInt + 1));
    }
    localStringBuilder1.append(localStringBuilder2).append("]").append("\n");
    return localStringBuilder1.toString();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aspr a()
  {
    return this.jdField_a_of_type_Aspr;
  }
  
  public aspr a(aspr paramaspr)
  {
    this.jdField_a_of_type_Aspr = paramaspr;
    this.jdField_a_of_type_Aspr.a(this);
    return this;
  }
  
  public ArrayList<aspr> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public HashMap<Integer, Object> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public void a(aspr paramaspr)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramaspr);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspr
 * JD-Core Version:    0.7.0.1
 */