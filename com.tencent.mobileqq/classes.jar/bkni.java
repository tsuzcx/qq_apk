import android.util.Property;

class bkni
  extends Property<bknf, Float>
{
  bkni(bknf parambknf, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bknf parambknf)
  {
    if (parambknf != null) {
      return Float.valueOf(bknf.a(parambknf));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bknf parambknf, Float paramFloat)
  {
    if (parambknf != null) {
      bknf.a(parambknf, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkni
 * JD-Core Version:    0.7.0.1
 */