import java.io.Closeable;
import java.io.InputStream;

public final class beiv
  implements Closeable
{
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private final long[] jdField_a_of_type_ArrayOfLong;
  private final InputStream[] jdField_a_of_type_ArrayOfJavaIoInputStream;
  
  private beiv(beip parambeip, String paramString, long paramLong, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
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
    return beip.a(a(paramInt));
  }
  
  public void close()
  {
    InputStream[] arrayOfInputStream = this.jdField_a_of_type_ArrayOfJavaIoInputStream;
    int j = arrayOfInputStream.length;
    int i = 0;
    while (i < j)
    {
      beiw.a(arrayOfInputStream[i]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beiv
 * JD-Core Version:    0.7.0.1
 */