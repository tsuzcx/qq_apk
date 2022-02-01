import java.util.ArrayList;

public class atvv
{
  public int a;
  public String a;
  public ArrayList<atvw> a;
  private boolean a;
  public int b = -1;
  public int c;
  public int d;
  
  private int a(atvw paramatvw1, atvw paramatvw2)
  {
    int i = Math.abs(paramatvw2.jdField_a_of_type_Int - paramatvw1.jdField_a_of_type_Int);
    int j = Math.abs(paramatvw2.b - paramatvw1.b);
    return (int)Math.ceil(Math.sqrt(i * i + j * j));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)) {
      return 0;
    }
    atvw localatvw1 = (atvw)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    atvw localatvw2 = (atvw)this.jdField_a_of_type_JavaUtilArrayList.get(1);
    int i = localatvw2.jdField_a_of_type_Int - localatvw1.jdField_a_of_type_Int;
    int j = localatvw2.b - localatvw1.b;
    double d1 = Math.sqrt(i * i + j * j);
    float f = (float)(Math.asin(j / d1) / 3.141592653589793D * 180.0D);
    if (localatvw2.jdField_a_of_type_Int < localatvw1.jdField_a_of_type_Int) {
      if (f > 0.0F) {
        f = 180.0F - f;
      }
    }
    for (;;)
    {
      return Math.round(f);
      f = -(180.0F + f);
    }
  }
  
  public void a(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((atvw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int = ((int)(((atvw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int * paramFloat));
        ((atvw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b = ((int)(((atvw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b * paramFloat));
        i += 1;
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 4)) {
      return 0;
    }
    return a((atvw)this.jdField_a_of_type_JavaUtilArrayList.get(0), (atvw)this.jdField_a_of_type_JavaUtilArrayList.get(2));
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 4)) {
      return 0;
    }
    return a((atvw)this.jdField_a_of_type_JavaUtilArrayList.get(0), (atvw)this.jdField_a_of_type_JavaUtilArrayList.get(3));
  }
  
  public int d()
  {
    return ((atvw)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
  }
  
  public int e()
  {
    return ((atvw)this.jdField_a_of_type_JavaUtilArrayList.get(3)).jdField_a_of_type_Int;
  }
  
  public int f()
  {
    return ((atvw)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b;
  }
  
  public int g()
  {
    return ((atvw)this.jdField_a_of_type_JavaUtilArrayList.get(3)).b;
  }
  
  public String toString()
  {
    return "PicOcrResult{text='" + this.jdField_a_of_type_JavaLangString + '\'' + ", confidence=" + this.jdField_a_of_type_Int + ", coorPoints=" + this.jdField_a_of_type_JavaUtilArrayList + ", arc=" + a() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvv
 * JD-Core Version:    0.7.0.1
 */