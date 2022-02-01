import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bmkz
{
  private int jdField_a_of_type_Int;
  private List<bmla> jdField_a_of_type_JavaUtilList = new ArrayList(9);
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[9];
  private List<HashMap<Integer, Float>> b = new ArrayList();
  
  public bmkz()
  {
    b();
  }
  
  private bmla a(int paramInt)
  {
    return (bmla)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
  
  public bmgl a(int paramInt)
  {
    return a(paramInt).a();
  }
  
  public bmgo a(int paramInt)
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
      ((bmla)this.jdField_a_of_type_JavaUtilList.get(i)).a();
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
  
  public void a(int paramInt, bmgl parambmgl)
  {
    a(paramInt).a(parambmgl);
  }
  
  public void a(int paramInt1, bmgo parambmgo, int paramInt2)
  {
    a(paramInt1).a(parambmgo, paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
  }
  
  public void a(int paramInt1, String paramString, float paramFloat, int paramInt2)
  {
    ((bmla)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).a(paramString, paramFloat, paramInt2);
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt).a();
  }
  
  public int b(int paramInt)
  {
    return a(paramInt).b();
  }
  
  public String b(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
    int i = 0;
    while (i < 9)
    {
      this.jdField_a_of_type_JavaUtilList.add(new bmla());
      this.b.add(new HashMap());
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = "";
      i += 1;
    }
  }
  
  public void b(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((bmla)this.jdField_a_of_type_JavaUtilList.get(i)).a(((bmla)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(), ((bmla)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(), ((bmla)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a());
      ((HashMap)this.b.get(i)).put(Integer.valueOf(((bmla)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a()), Float.valueOf(((bmla)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a()));
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
  
  public boolean c(int paramInt)
  {
    return a(paramInt).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkz
 * JD-Core Version:    0.7.0.1
 */