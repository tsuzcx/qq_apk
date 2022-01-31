import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bljs
{
  private int jdField_a_of_type_Int;
  private List<bljt> jdField_a_of_type_JavaUtilList = new ArrayList(9);
  private List<HashMap<Integer, Float>> b = new ArrayList();
  
  public bljs()
  {
    b();
  }
  
  private bljt a(int paramInt)
  {
    return (bljt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public float a(int paramInt)
  {
    return a(paramInt).a();
  }
  
  public float a(int paramInt1, int paramInt2, float paramFloat)
  {
    if (!((HashMap)this.b.get(paramInt1)).containsKey(Integer.valueOf(paramInt2))) {
      return paramFloat;
    }
    return ((Float)((HashMap)this.b.get(paramInt1)).get(Integer.valueOf(paramInt2))).floatValue();
  }
  
  public int a(int paramInt)
  {
    return a(paramInt).a();
  }
  
  public blhb a(int paramInt)
  {
    return a(paramInt).a();
  }
  
  public String a(int paramInt)
  {
    return a(paramInt).a();
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      ((bljt)this.jdField_a_of_type_JavaUtilList.get(i)).a();
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 9) {
      throw new IllegalArgumentException("image count > max count 9");
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    a(paramInt).a(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    ((HashMap)this.b.get(paramInt1)).put(Integer.valueOf(paramInt2), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt, blhb paramblhb)
  {
    a(paramInt).a(paramblhb);
  }
  
  public void a(int paramInt1, String paramString, float paramFloat, int paramInt2)
  {
    ((bljt)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).a(paramString, paramFloat, paramInt2);
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt).a();
  }
  
  public int b(int paramInt)
  {
    return a(paramInt).b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
    int i = 0;
    while (i < 9)
    {
      this.jdField_a_of_type_JavaUtilList.add(new bljt());
      this.b.add(new HashMap());
      i += 1;
    }
  }
  
  public void b(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((bljt)this.jdField_a_of_type_JavaUtilList.get(i)).a(((bljt)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(), ((bljt)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(), ((bljt)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a());
      ((HashMap)this.b.get(i)).put(Integer.valueOf(((bljt)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a()), Float.valueOf(((bljt)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a()));
      i += 1;
    }
  }
  
  public boolean b(int paramInt)
  {
    return a(paramInt).b();
  }
  
  public void c(int paramInt)
  {
    a(paramInt).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljs
 * JD-Core Version:    0.7.0.1
 */