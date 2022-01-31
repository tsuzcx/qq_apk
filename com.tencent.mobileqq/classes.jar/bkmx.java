import android.util.Property;

class bkmx
  extends Property<bkmo, Integer>
{
  bkmx(bkmo parambkmo, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bkmo parambkmo)
  {
    if (parambkmo != null) {
      return Integer.valueOf(bkmo.d(parambkmo));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bkmo parambkmo, Integer paramInteger)
  {
    if (parambkmo != null) {
      bkmo.d(parambkmo, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmx
 * JD-Core Version:    0.7.0.1
 */