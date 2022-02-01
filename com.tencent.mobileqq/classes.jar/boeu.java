import java.text.SimpleDateFormat;
import java.util.Locale;

public class boeu
  extends boev
{
  private SimpleDateFormat a;
  
  public boeu(float paramFloat)
  {
    super(paramFloat);
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("mm:ss", Locale.US);
  }
  
  public float a(long paramLong)
  {
    return (float)paramLong / 1000.0F / this.jdField_a_of_type_Float;
  }
  
  public long a(float paramFloat)
  {
    return Math.round(1000.0F * paramFloat * this.jdField_a_of_type_Float);
  }
  
  public String a(long paramLong)
  {
    return this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boeu
 * JD-Core Version:    0.7.0.1
 */