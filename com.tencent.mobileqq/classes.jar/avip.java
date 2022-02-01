import java.util.ArrayList;

public class avip
{
  public int a;
  public String a;
  public ArrayList<aviq> a;
  private boolean a;
  public int b = -1;
  public int c;
  public int d;
  
  private int a(aviq paramaviq1, aviq paramaviq2)
  {
    int i = Math.abs(paramaviq2.jdField_a_of_type_Int - paramaviq1.jdField_a_of_type_Int);
    int j = Math.abs(paramaviq2.b - paramaviq1.b);
    return (int)Math.ceil(Math.sqrt(i * i + j * j));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)) {
      return 0;
    }
    aviq localaviq1 = (aviq)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    aviq localaviq2 = (aviq)this.jdField_a_of_type_JavaUtilArrayList.get(1);
    int i = localaviq2.jdField_a_of_type_Int - localaviq1.jdField_a_of_type_Int;
    int j = localaviq2.b - localaviq1.b;
    double d1 = Math.sqrt(i * i + j * j);
    float f = (float)(Math.asin(j / d1) / 3.141592653589793D * 180.0D);
    if (localaviq2.jdField_a_of_type_Int < localaviq1.jdField_a_of_type_Int) {
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
        ((aviq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int = ((int)(((aviq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int * paramFloat));
        ((aviq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b = ((int)(((aviq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b * paramFloat));
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
    return a((aviq)this.jdField_a_of_type_JavaUtilArrayList.get(0), (aviq)this.jdField_a_of_type_JavaUtilArrayList.get(2));
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 4)) {
      return 0;
    }
    return a((aviq)this.jdField_a_of_type_JavaUtilArrayList.get(0), (aviq)this.jdField_a_of_type_JavaUtilArrayList.get(3));
  }
  
  public int d()
  {
    return ((aviq)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
  }
  
  public int e()
  {
    return ((aviq)this.jdField_a_of_type_JavaUtilArrayList.get(3)).jdField_a_of_type_Int;
  }
  
  public int f()
  {
    return ((aviq)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b;
  }
  
  public int g()
  {
    return ((aviq)this.jdField_a_of_type_JavaUtilArrayList.get(3)).b;
  }
  
  public String toString()
  {
    return "PicOcrResult{text='" + this.jdField_a_of_type_JavaLangString + '\'' + ", confidence=" + this.jdField_a_of_type_Int + ", coorPoints=" + this.jdField_a_of_type_JavaUtilArrayList + ", arc=" + a() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avip
 * JD-Core Version:    0.7.0.1
 */