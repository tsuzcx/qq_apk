import java.nio.ByteBuffer;

public abstract class bcmy
{
  protected volatile bcmx a;
  
  protected bcmy(bcmx parambcmx)
  {
    this.a = parambcmx;
  }
  
  protected bcmz a(bcmz parambcmz, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    bcmz localbcmz = parambcmz;
    if (parambcmz == null) {
      localbcmz = new bcmz();
    }
    if (localbcmz.jdField_a_of_type_JavaNioByteBuffer == null) {
      localbcmz.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(paramInt3);
    }
    if (paramInt2 >= paramInt3)
    {
      localbcmz.jdField_a_of_type_Boolean = true;
      localbcmz.jdField_a_of_type_JavaNioByteBuffer.position(0);
      localbcmz.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte);
      localbcmz.b = paramInt2;
    }
    do
    {
      do
      {
        return localbcmz;
      } while (0L != (localbcmz.jdField_a_of_type_Long & paramInt4));
      localbcmz.jdField_a_of_type_JavaNioByteBuffer.position(paramInt1);
      localbcmz.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte);
      localbcmz.b += paramInt2;
      localbcmz.jdField_a_of_type_Long |= paramInt4;
    } while (localbcmz.b < paramInt3);
    localbcmz.jdField_a_of_type_Boolean = true;
    return localbcmz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmy
 * JD-Core Version:    0.7.0.1
 */