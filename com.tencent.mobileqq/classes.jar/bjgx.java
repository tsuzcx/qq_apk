import java.io.IOException;
import java.nio.ByteBuffer;

public class bjgx
{
  public final int a;
  public final long a;
  public final int b;
  public final long b;
  public final long c;
  public final long d;
  public final long e;
  public final long f;
  
  private bjgx(ByteBuffer paramByteBuffer, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IOException("Unexpected elf class: " + paramInt);
    case 1: 
      this.jdField_a_of_type_Int = paramByteBuffer.getInt();
      this.jdField_a_of_type_Long = paramByteBuffer.getInt();
      this.jdField_b_of_type_Long = paramByteBuffer.getInt();
      this.c = paramByteBuffer.getInt();
      this.d = paramByteBuffer.getInt();
      this.e = paramByteBuffer.getInt();
      this.jdField_b_of_type_Int = paramByteBuffer.getInt();
      this.f = paramByteBuffer.getInt();
      return;
    }
    this.jdField_a_of_type_Int = paramByteBuffer.getInt();
    this.jdField_b_of_type_Int = paramByteBuffer.getInt();
    this.jdField_a_of_type_Long = paramByteBuffer.getLong();
    this.jdField_b_of_type_Long = paramByteBuffer.getLong();
    this.c = paramByteBuffer.getLong();
    this.d = paramByteBuffer.getLong();
    this.e = paramByteBuffer.getLong();
    this.f = paramByteBuffer.getLong();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjgx
 * JD-Core Version:    0.7.0.1
 */