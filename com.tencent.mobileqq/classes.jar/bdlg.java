public class bdlg
{
  public int a;
  public bdlq a;
  public Object a;
  
  public bdlg(int paramInt, bdlq parambdlq)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bdlq = parambdlq;
  }
  
  public static bdlg a(int paramInt, bdlq parambdlq)
  {
    return new bdlg(paramInt, parambdlq);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{RuntimeLoader@");
    if (this.jdField_a_of_type_Bdlq != null) {}
    for (Object localObject = Integer.valueOf(this.jdField_a_of_type_Bdlq.hashCode());; localObject = "=") {
      return localObject + this.jdField_a_of_type_Bdlq + " what=" + this.jdField_a_of_type_Int + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdlg
 * JD-Core Version:    0.7.0.1
 */