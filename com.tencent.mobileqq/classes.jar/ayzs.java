import com.qq.taf.jce.HexUtil;
import java.util.ArrayList;

public class ayzs
  extends ayzr
{
  public int a;
  public String a;
  public ArrayList<ayuq> a;
  public byte[] a;
  public String b;
  public ArrayList<ayuq> b;
  public byte[] b;
  public String c;
  
  public ayzs()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" mUkey:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mIpList:").append(this.jdField_a_of_type_JavaUtilArrayList.toString());
    localStringBuilder.append(" mIpv6List:").append(this.jdField_b_of_type_JavaUtilArrayList.toString());
    localStringBuilder.append(" md5:").append(HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(" aesKey:").append(HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayzs
 * JD-Core Version:    0.7.0.1
 */