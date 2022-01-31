import android.util.Property;

class bkms
  extends Property<bkmo, Integer>
{
  bkms(bkmo parambkmo, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bkmo parambkmo)
  {
    if (parambkmo != null) {
      return Integer.valueOf(bkmo.b(parambkmo));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bkmo parambkmo, Integer paramInteger)
  {
    if (parambkmo != null) {
      bkmo.b(parambkmo, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkms
 * JD-Core Version:    0.7.0.1
 */