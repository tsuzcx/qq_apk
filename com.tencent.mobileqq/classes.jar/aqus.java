import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class aqus
{
  int jdField_a_of_type_Int;
  aqus jdField_a_of_type_Aqus;
  ArrayList<aqus> jdField_a_of_type_JavaUtilArrayList;
  HashMap<Integer, Object> jdField_a_of_type_JavaUtilHashMap;
  
  public aqus(int paramInt)
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
    localStringBuilder1.append(localStringBuilder2).append(aqur.a(this.jdField_a_of_type_Int)).append(":[\n");
    localStringBuilder1.append(localStringBuilder2).append("\tfields").append(":[\n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      String str = aqur.b(((Integer)localObject).intValue());
      localObject = this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      localStringBuilder1.append(localStringBuilder2).append("\t\t").append(str).append(":").append(localObject).append("\n");
    }
    localStringBuilder1.append(localStringBuilder2).append("\t]").append("\n");
    localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder1.append(((aqus)localIterator.next()).a(paramInt + 1));
    }
    localStringBuilder1.append(localStringBuilder2).append("]").append("\n");
    return localStringBuilder1.toString();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aqus a()
  {
    return this.jdField_a_of_type_Aqus;
  }
  
  public aqus a(aqus paramaqus)
  {
    this.jdField_a_of_type_Aqus = paramaqus;
    this.jdField_a_of_type_Aqus.a(this);
    return this;
  }
  
  public ArrayList<aqus> a()
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
  
  public void a(aqus paramaqus)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramaqus);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqus
 * JD-Core Version:    0.7.0.1
 */