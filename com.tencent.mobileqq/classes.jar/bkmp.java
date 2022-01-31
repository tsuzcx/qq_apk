import android.util.Property;

class bkmp
  extends Property<bkmo, Float>
{
  bkmp(bkmo parambkmo, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bkmo parambkmo)
  {
    if (parambkmo != null) {
      return Float.valueOf(bkmo.a(parambkmo));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bkmo parambkmo, Float paramFloat)
  {
    if (parambkmo != null) {
      bkmo.a(parambkmo, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmp
 * JD-Core Version:    0.7.0.1
 */