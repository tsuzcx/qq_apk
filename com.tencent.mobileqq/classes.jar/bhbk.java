import java.io.IOException;
import java.nio.ByteBuffer;

public class bhbk
{
  public final int a;
  public final long a;
  public String a;
  public final int b;
  public final long b;
  public final int c;
  public final long c;
  public final int d;
  public final long d;
  public final long e;
  public final long f;
  
  private bhbk(ByteBuffer paramByteBuffer, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IOException("Unexpected elf class: " + paramInt);
    case 1: 
      this.jdField_a_of_type_Int = paramByteBuffer.getInt();
      this.jdField_b_of_type_Int = paramByteBuffer.getInt();
      this.jdField_a_of_type_Long = paramByteBuffer.getInt();
      this.jdField_b_of_type_Long = paramByteBuffer.getInt();
      this.jdField_c_of_type_Long = paramByteBuffer.getInt();
      this.jdField_d_of_type_Long = paramByteBuffer.getInt();
      this.jdField_c_of_type_Int = paramByteBuffer.getInt();
      this.jdField_d_of_type_Int = paramByteBuffer.getInt();
      this.e = paramByteBuffer.getInt();
    }
    for (this.f = paramByteBuffer.getInt();; this.f = paramByteBuffer.getLong())
    {
      this.jdField_a_of_type_JavaLangString = null;
      return;
      this.jdField_a_of_type_Int = paramByteBuffer.getInt();
      this.jdField_b_of_type_Int = paramByteBuffer.getInt();
      this.jdField_a_of_type_Long = paramByteBuffer.getLong();
      this.jdField_b_of_type_Long = paramByteBuffer.getLong();
      this.jdField_c_of_type_Long = paramByteBuffer.getLong();
      this.jdField_d_of_type_Long = paramByteBuffer.getLong();
      this.jdField_c_of_type_Int = paramByteBuffer.getInt();
      this.jdField_d_of_type_Int = paramByteBuffer.getInt();
      this.e = paramByteBuffer.getLong();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhbk
 * JD-Core Version:    0.7.0.1
 */