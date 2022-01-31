import java.util.ArrayList;

public class bbbv
  extends bbbz
{
  public int a;
  public String a;
  public ArrayList<bawy> a;
  public byte[] a;
  public ArrayList<bawy> b;
  public byte[] b;
  
  public bbbv()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" urlParam:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" msgUkey:");
    localStringBuilder.append(this.jdField_b_of_type_ArrayOfByte);
    localStringBuilder.append(" ipList:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append(" mIpv6List:");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList);
    localStringBuilder.append(" resId:");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfByte);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbv
 * JD-Core Version:    0.7.0.1
 */