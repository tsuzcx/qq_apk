import android.util.Property;

class bkmw
  extends Property<bkmo, Float>
{
  bkmw(bkmo parambkmo, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bkmo parambkmo)
  {
    if (parambkmo != null) {
      return Float.valueOf(bkmo.d(parambkmo));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bkmo parambkmo, Float paramFloat)
  {
    if (parambkmo != null) {
      bkmo.c(parambkmo, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmw
 * JD-Core Version:    0.7.0.1
 */