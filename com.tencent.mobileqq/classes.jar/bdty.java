import java.nio.ByteBuffer;

public abstract class bdty
{
  protected volatile bdtx a;
  
  protected bdty(bdtx parambdtx)
  {
    this.a = parambdtx;
  }
  
  protected bdtz a(bdtz parambdtz, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    bdtz localbdtz = parambdtz;
    if (parambdtz == null) {
      localbdtz = new bdtz();
    }
    if (localbdtz.jdField_a_of_type_JavaNioByteBuffer == null) {
      localbdtz.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(paramInt3);
    }
    if (paramInt2 >= paramInt3)
    {
      localbdtz.jdField_a_of_type_Boolean = true;
      localbdtz.jdField_a_of_type_JavaNioByteBuffer.position(0);
      localbdtz.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte);
      localbdtz.b = paramInt2;
    }
    do
    {
      do
      {
        return localbdtz;
      } while (0L != (localbdtz.jdField_a_of_type_Long & paramInt4));
      localbdtz.jdField_a_of_type_JavaNioByteBuffer.position(paramInt1);
      localbdtz.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte);
      localbdtz.b += paramInt2;
      localbdtz.jdField_a_of_type_Long |= paramInt4;
    } while (localbdtz.b < paramInt3);
    localbdtz.jdField_a_of_type_Boolean = true;
    return localbdtz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdty
 * JD-Core Version:    0.7.0.1
 */