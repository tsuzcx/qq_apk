import android.util.Property;

class bkmu
  extends Property<bkmo, Float>
{
  bkmu(bkmo parambkmo, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bkmo parambkmo)
  {
    return Float.valueOf(bkmo.b(parambkmo));
  }
  
  public void a(bkmo parambkmo, Float paramFloat)
  {
    bkmo.a(parambkmo, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmu
 * JD-Core Version:    0.7.0.1
 */