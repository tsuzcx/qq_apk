import java.io.File;

public abstract class aunh
  extends auno
{
  public int a;
  public long a;
  public Object a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public aunh()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_d_of_type_Int = 5;
  }
  
  public File a()
  {
    return ayog.a(b());
  }
  
  public String a()
  {
    return null;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      a("PicBaseInfo.check", "busiType invalid,busiType:" + this.jdField_a_of_type_Int);
      return false;
    }
    if (this.jdField_b_of_type_Int == -1)
    {
      a("PicBaseInfo.check", "uinType invalid,uinType:" + this.jdField_b_of_type_Int);
      return false;
    }
    if (this.c == null)
    {
      a("PicBaseInfo.check", "peerUin invalid,peerUin:" + this.c);
      return false;
    }
    return true;
  }
  
  abstract String b();
  
  public boolean b()
  {
    return a() != null;
  }
  
  public String c()
  {
    return ayog.d(b());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicBaseInfo");
    localStringBuilder.append("\n |-").append("localUUID:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("uniseq:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n |-").append("busiType:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-").append("selfUin:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("peerUin:").append(this.c);
    localStringBuilder.append("\n |-").append("secondId:").append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("md5:").append(this.f);
    localStringBuilder.append("\n |-").append("errInfo:").append(this.jdField_a_of_type_Aunp);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunh
 * JD-Core Version:    0.7.0.1
 */