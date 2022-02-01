import com.qq.taf.jce.HexUtil;
import java.util.ArrayList;

public class bfbx
  extends bfbw
{
  public int a;
  public String a;
  public ArrayList<bewy> a;
  public boolean a;
  public byte[] a;
  public String b;
  public ArrayList<bewy> b = new ArrayList();
  public String c;
  
  public bfbx()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" mUkey:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mIpList:").append(this.jdField_a_of_type_JavaUtilArrayList.toString());
    localStringBuilder.append(" mIpv6List:").append(this.b.toString());
    localStringBuilder.append(" md5:").append(HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfbx
 * JD-Core Version:    0.7.0.1
 */