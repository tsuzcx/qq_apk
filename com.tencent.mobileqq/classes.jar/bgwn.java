import android.media.MediaDataSource;
import android.support.annotation.RequiresApi;

@RequiresApi(api=23)
class bgwn
  extends MediaDataSource
{
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public bgwn(bgwm parambgwm, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void close() {}
  
  public long getSize()
  {
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      return -1L;
    }
    return this.jdField_a_of_type_ArrayOfByte.length;
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ArrayOfByte == null) {}
    while ((paramLong < 0L) || (paramLong >= this.jdField_a_of_type_ArrayOfByte.length)) {
      return -1;
    }
    if (paramInt2 + paramLong < this.jdField_a_of_type_ArrayOfByte.length) {}
    for (long l = paramInt2;; l = this.jdField_a_of_type_ArrayOfByte.length - paramLong)
    {
      System.arraycopy(this.jdField_a_of_type_ArrayOfByte, (int)paramLong, paramArrayOfByte, paramInt1, (int)l);
      return (int)l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwn
 * JD-Core Version:    0.7.0.1
 */