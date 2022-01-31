import android.util.Property;

class bkmr
  extends Property<bkmo, Integer>
{
  bkmr(bkmo parambkmo, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bkmo parambkmo)
  {
    if (parambkmo != null) {
      return Integer.valueOf(bkmo.a(parambkmo));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bkmo parambkmo, Integer paramInteger)
  {
    if (parambkmo != null) {
      bkmo.a(parambkmo, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmr
 * JD-Core Version:    0.7.0.1
 */