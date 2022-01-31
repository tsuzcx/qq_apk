import java.util.ArrayList;

public class aqmz
{
  public int a;
  public String a;
  public ArrayList<aqna> a;
  private boolean a;
  public int b = -1;
  public int c;
  public int d;
  
  private int a(aqna paramaqna1, aqna paramaqna2)
  {
    int i = Math.abs(paramaqna2.jdField_a_of_type_Int - paramaqna1.jdField_a_of_type_Int);
    int j = Math.abs(paramaqna2.b - paramaqna1.b);
    return (int)Math.ceil(Math.sqrt(i * i + j * j));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)) {
      return 0;
    }
    aqna localaqna1 = (aqna)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    aqna localaqna2 = (aqna)this.jdField_a_of_type_JavaUtilArrayList.get(1);
    int i = localaqna2.jdField_a_of_type_Int - localaqna1.jdField_a_of_type_Int;
    int j = localaqna2.b - localaqna1.b;
    double d1 = Math.sqrt(i * i + j * j);
    float f = (float)(Math.asin(j / d1) / 3.141592653589793D * 180.0D);
    if (localaqna2.jdField_a_of_type_Int < localaqna1.jdField_a_of_type_Int) {
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
        ((aqna)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int = ((int)(((aqna)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int * paramFloat));
        ((aqna)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b = ((int)(((aqna)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b * paramFloat));
        i += 1;
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_JavaUtilArrayList.size() < 4)) {
      return 0;
    }
    return a((aqna)this.jdField_a_of_type_JavaUtilArrayList.get(0), (aqna)this.jdField_a_of_type_JavaUtilArrayList.get(2));
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_JavaUtilArrayList.size() < 4)) {
      return 0;
    }
    return a((aqna)this.jdField_a_of_type_JavaUtilArrayList.get(0), (aqna)this.jdField_a_of_type_JavaUtilArrayList.get(3));
  }
  
  public String toString()
  {
    return "PicOcrResult{text='" + this.jdField_a_of_type_JavaLangString + '\'' + ", confidence=" + this.jdField_a_of_type_Int + ", coorPoints=" + this.jdField_a_of_type_JavaUtilArrayList + ", arc=" + a() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmz
 * JD-Core Version:    0.7.0.1
 */