import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class beiu
{
  private long jdField_a_of_type_Long;
  private beis jdField_a_of_type_Beis;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  private beiu(beip parambeip, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfLong = new long[beip.a(parambeip)];
  }
  
  private IOException a(String[] paramArrayOfString)
  {
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }
  
  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != beip.a(this.jdField_a_of_type_Beip)) {
      throw a(paramArrayOfString);
    }
    int i = 0;
    try
    {
      while (i < paramArrayOfString.length)
      {
        this.jdField_a_of_type_ArrayOfLong[i] = Long.parseLong(paramArrayOfString[i]);
        i += 1;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw a(paramArrayOfString);
    }
  }
  
  public File a(int paramInt)
  {
    return new File(beip.a(this.jdField_a_of_type_Beip), this.jdField_a_of_type_JavaLangString + "." + paramInt);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      localStringBuilder.append(' ').append(l);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public File b(int paramInt)
  {
    return new File(beip.a(this.jdField_a_of_type_Beip), this.jdField_a_of_type_JavaLangString + "." + paramInt + ".tmp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beiu
 * JD-Core Version:    0.7.0.1
 */