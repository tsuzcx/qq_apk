import java.text.SimpleDateFormat;
import java.util.Date;

class azrk
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public azrk(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    int i;
    if (paramString1 == null)
    {
      i = 0;
      if (paramString2 != null) {
        break label67;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = (j + (i + 19 + 1) + 1);
      return;
      i = paramString1.getBytes().length;
      break;
      label67:
      j = paramString2.getBytes().length;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    Date localDate = new Date(this.jdField_a_of_type_Long);
    localStringBuilder.append(azri.a().format(localDate));
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azrk
 * JD-Core Version:    0.7.0.1
 */