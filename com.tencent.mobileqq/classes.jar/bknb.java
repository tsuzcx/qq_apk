import android.util.Property;

class bknb
  extends Property<bkna, Float>
{
  bknb(bkna parambkna, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bkna parambkna)
  {
    if (parambkna != null) {
      return Float.valueOf(bkna.a(parambkna));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bkna parambkna, Float paramFloat)
  {
    if (parambkna != null) {
      bkna.a(parambkna, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknb
 * JD-Core Version:    0.7.0.1
 */