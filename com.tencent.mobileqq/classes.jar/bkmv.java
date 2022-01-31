import android.util.Property;

class bkmv
  extends Property<bkmo, Float>
{
  bkmv(bkmo parambkmo, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bkmo parambkmo)
  {
    return Float.valueOf(bkmo.c(parambkmo));
  }
  
  public void a(bkmo parambkmo, Float paramFloat)
  {
    bkmo.b(parambkmo, paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmv
 * JD-Core Version:    0.7.0.1
 */