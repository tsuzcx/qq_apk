public class bfgy
  implements Comparable<bfgy>
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public bfgy(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public int a(bfgy parambfgy)
  {
    if (this.jdField_b_of_type_Int < parambfgy.jdField_b_of_type_Int) {
      return -1;
    }
    if (this.jdField_b_of_type_Int > parambfgy.jdField_b_of_type_Int) {
      return 1;
    }
    return 0;
  }
  
  public String toString()
  {
    return "TroopHonor{id=" + this.jdField_a_of_type_Int + ", name='" + this.jdField_a_of_type_JavaLangString + '\'' + ", iconUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", priority='" + this.jdField_b_of_type_Int + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgy
 * JD-Core Version:    0.7.0.1
 */