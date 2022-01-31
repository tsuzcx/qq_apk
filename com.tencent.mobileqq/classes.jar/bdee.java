import java.io.Closeable;
import java.io.InputStream;

public final class bdee
  implements Closeable
{
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private final long[] jdField_a_of_type_ArrayOfLong;
  private final InputStream[] jdField_a_of_type_ArrayOfJavaIoInputStream;
  
  private bdee(bddy parambddy, String paramString, long paramLong, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ArrayOfJavaIoInputStream = paramArrayOfInputStream;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public InputStream a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfJavaIoInputStream[paramInt];
  }
  
  public String a(int paramInt)
  {
    return bddy.a(a(paramInt));
  }
  
  public void close()
  {
    InputStream[] arrayOfInputStream = this.jdField_a_of_type_ArrayOfJavaIoInputStream;
    int j = arrayOfInputStream.length;
    int i = 0;
    while (i < j)
    {
      bdef.a(arrayOfInputStream[i]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdee
 * JD-Core Version:    0.7.0.1
 */