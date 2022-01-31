import java.io.DataInputStream;
import java.io.DataOutputStream;

public class amnu
{
  protected byte a;
  protected int a;
  protected long a;
  protected String a;
  protected short a;
  protected boolean a;
  protected byte[] a;
  public String b;
  protected String c;
  protected String d;
  protected String e = "";
  protected String f = "";
  
  public amnu(amnt paramamnt)
  {
    this.jdField_a_of_type_Byte = 3;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(DataInputStream paramDataInputStream)
  {
    this.jdField_a_of_type_Long = paramDataInputStream.readLong();
    this.jdField_a_of_type_JavaLangString = paramDataInputStream.readUTF();
    this.b = paramDataInputStream.readUTF();
    this.d = paramDataInputStream.readUTF();
    this.jdField_a_of_type_Byte = paramDataInputStream.readByte();
    this.c = paramDataInputStream.readUTF();
    this.e = paramDataInputStream.readUTF();
    this.jdField_a_of_type_Short = paramDataInputStream.readShort();
  }
  
  public void a(DataOutputStream paramDataOutputStream)
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    if (this.b == null) {
      this.b = "";
    }
    if (this.d == null) {
      this.d = "";
    }
    if (this.c == null) {
      this.c = "";
    }
    paramDataOutputStream.writeLong(this.jdField_a_of_type_Long);
    paramDataOutputStream.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramDataOutputStream.writeUTF(this.b);
    paramDataOutputStream.writeUTF(this.d);
    paramDataOutputStream.writeByte(this.jdField_a_of_type_Byte);
    paramDataOutputStream.writeUTF(this.c);
    paramDataOutputStream.writeUTF(this.e);
    paramDataOutputStream.writeShort(this.jdField_a_of_type_Short);
  }
  
  public void b(DataInputStream paramDataInputStream)
  {
    a(paramDataInputStream);
    this.f = paramDataInputStream.readUTF();
  }
  
  public void b(DataOutputStream paramDataOutputStream)
  {
    a(paramDataOutputStream);
    if (this.f == null) {
      this.f = "";
    }
    paramDataOutputStream.writeUTF(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amnu
 * JD-Core Version:    0.7.0.1
 */