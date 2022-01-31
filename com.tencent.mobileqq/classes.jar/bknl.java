import android.util.Property;

class bknl
  extends Property<bknf, Float>
{
  bknl(bknf parambknf, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bknf parambknf)
  {
    return Float.valueOf(bknf.b(parambknf));
  }
  
  public void a(bknf parambknf, Float paramFloat)
  {
    bknf.a(parambknf, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknl
 * JD-Core Version:    0.7.0.1
 */