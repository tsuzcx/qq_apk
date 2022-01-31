import android.util.Property;

class bknc
  extends Property<bkna, Integer>
{
  bknc(bkna parambkna, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bkna parambkna)
  {
    if (parambkna != null) {
      return Integer.valueOf(bkna.a(parambkna));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bkna parambkna, Integer paramInteger)
  {
    if (parambkna != null) {
      bkna.a(parambkna, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknc
 * JD-Core Version:    0.7.0.1
 */