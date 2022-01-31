import android.util.Property;

class bkmt
  extends Property<bkmo, Integer>
{
  bkmt(bkmo parambkmo, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bkmo parambkmo)
  {
    if (parambkmo != null) {
      return Integer.valueOf(bkmo.c(parambkmo));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bkmo parambkmo, Integer paramInteger)
  {
    if (parambkmo != null) {
      bkmo.c(parambkmo, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmt
 * JD-Core Version:    0.7.0.1
 */