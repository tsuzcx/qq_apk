import java.util.ArrayList;

public class aqnb
{
  public int a;
  public String a;
  public ArrayList<aqnc> a;
  private boolean a;
  public int b = -1;
  public int c;
  public int d;
  
  private int a(aqnc paramaqnc1, aqnc paramaqnc2)
  {
    int i = Math.abs(paramaqnc2.jdField_a_of_type_Int - paramaqnc1.jdField_a_of_type_Int);
    int j = Math.abs(paramaqnc2.b - paramaqnc1.b);
    return (int)Math.ceil(Math.sqrt(i * i + j * j));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)) {
      return 0;
    }
    aqnc localaqnc1 = (aqnc)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    aqnc localaqnc2 = (aqnc)this.jdField_a_of_type_JavaUtilArrayList.get(1);
    int i = localaqnc2.jdField_a_of_type_Int - localaqnc1.jdField_a_of_type_Int;
    int j = localaqnc2.b - localaqnc1.b;
    double d1 = Math.sqrt(i * i + j * j);
    float f = (float)(Math.asin(j / d1) / 3.141592653589793D * 180.0D);
    if (localaqnc2.jdField_a_of_type_Int < localaqnc1.jdField_a_of_type_Int) {
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
        ((aqnc)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int = ((int)(((aqnc)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int * paramFloat));
        ((aqnc)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b = ((int)(((aqnc)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b * paramFloat));
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
    return a((aqnc)this.jdField_a_of_type_JavaUtilArrayList.get(0), (aqnc)this.jdField_a_of_type_JavaUtilArrayList.get(2));
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (this.jdField_a_of_type_JavaUtilArrayList.size() < 4)) {
      return 0;
    }
    return a((aqnc)this.jdField_a_of_type_JavaUtilArrayList.get(0), (aqnc)this.jdField_a_of_type_JavaUtilArrayList.get(3));
  }
  
  public String toString()
  {
    return "PicOcrResult{text='" + this.jdField_a_of_type_JavaLangString + '\'' + ", confidence=" + this.jdField_a_of_type_Int + ", coorPoints=" + this.jdField_a_of_type_JavaUtilArrayList + ", arc=" + a() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqnb
 * JD-Core Version:    0.7.0.1
 */