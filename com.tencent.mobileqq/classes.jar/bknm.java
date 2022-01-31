import android.util.Property;

class bknm
  extends Property<bknf, Float>
{
  bknm(bknf parambknf, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bknf parambknf)
  {
    return Float.valueOf(bknf.c(parambknf));
  }
  
  public void a(bknf parambknf, Float paramFloat)
  {
    bknf.b(parambknf, paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknm
 * JD-Core Version:    0.7.0.1
 */