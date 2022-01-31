import com.tencent.qqprotect.qsec.QSecFramework;

class bhnd
  implements bhoa
{
  protected long a;
  
  public bhnd(bhmz parambhmz, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.jdField_a_of_type_Long != 0L) {
      QSecFramework.a(7L, this.jdField_a_of_type_Long, paramInt, 0L, paramArrayOfByte1, paramArrayOfByte2, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhnd
 * JD-Core Version:    0.7.0.1
 */