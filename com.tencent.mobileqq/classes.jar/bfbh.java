import com.qq.taf.jce.HexUtil;

public class bfbh
  extends bfbf
{
  public int a;
  public long a;
  public String a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public byte[] b;
  public int c;
  public int d;
  public int e;
  public String f;
  public int g;
  public String g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" fromChatType:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" toChatType:").append(this.b);
    localStringBuilder.append(" fromBusiType:").append(this.c);
    localStringBuilder.append(" toBusiType:").append(this.d);
    localStringBuilder.append(" md5:").append(HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(" format:").append(this.j);
    localStringBuilder.append(" str_file_name:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" uint64_file_size:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" fileTime:").append(this.k);
    localStringBuilder.append(" uuid:").append(this.f);
    localStringBuilder.append(" fromUin:").append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfbh
 * JD-Core Version:    0.7.0.1
 */