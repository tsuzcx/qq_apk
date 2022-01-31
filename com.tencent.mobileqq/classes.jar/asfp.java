import java.util.ArrayList;

public class asfp
{
  public int a;
  public String a;
  public ArrayList<asfq> a;
  private boolean a;
  public int b = -1;
  public int c;
  public int d;
  
  private int a(asfq paramasfq1, asfq paramasfq2)
  {
    int i = Math.abs(paramasfq2.jdField_a_of_type_Int - paramasfq1.jdField_a_of_type_Int);
    int j = Math.abs(paramasfq2.b - paramasfq1.b);
    return (int)Math.ceil(Math.sqrt(i * i + j * j));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)) {
      return 0;
    }
    asfq localasfq1 = (asfq)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    asfq localasfq2 = (asfq)this.jdField_a_of_type_JavaUtilArrayList.get(1);
    int i = localasfq2.jdField_a_of_type_Int - localasfq1.jdField_a_of_type_Int;
    int j = localasfq2.b - localasfq1.b;
    double d1 = Math.sqrt(i * i + j * j);
    float f = (float)(Math.asin(j / d1) / 3.141592653589793D * 180.0D);
    if (localasfq2.jdField_a_of_type_Int < localasfq1.jdField_a_of_type_Int) {
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
        ((asfq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int = ((int)(((asfq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int * paramFloat));
        ((asfq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b = ((int)(((asfq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b * paramFloat));
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
    return a((asfq)this.jdField_a_of_type_JavaUtilArrayList.get(0), (asfq)this.jdField_a_of_type_JavaUtilArrayList.get(2));
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 4)) {
      return 0;
    }
    return a((asfq)this.jdField_a_of_type_JavaUtilArrayList.get(0), (asfq)this.jdField_a_of_type_JavaUtilArrayList.get(3));
  }
  
  public String toString()
  {
    return "PicOcrResult{text='" + this.jdField_a_of_type_JavaLangString + '\'' + ", confidence=" + this.jdField_a_of_type_Int + ", coorPoints=" + this.jdField_a_of_type_JavaUtilArrayList + ", arc=" + a() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfp
 * JD-Core Version:    0.7.0.1
 */