import java.nio.ByteBuffer;

class bfgw
{
  public final int a;
  public final long a;
  public final long b;
  
  public bfgw(ByteBuffer paramByteBuffer)
  {
    this.jdField_a_of_type_Int = (paramByteBuffer.get() & 0xFFFF);
    this.jdField_a_of_type_Long = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.b = (paramByteBuffer.getInt() & 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgw
 * JD-Core Version:    0.7.0.1
 */