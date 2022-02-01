import android.util.Property;

class bpue
  extends Property<bpud, Integer>
{
  bpue(bpud parambpud, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpud parambpud)
  {
    if (parambpud != null) {
      return Integer.valueOf(bpud.a(parambpud));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bpud parambpud, Integer paramInteger)
  {
    if (parambpud != null) {
      bpud.a(parambpud, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpue
 * JD-Core Version:    0.7.0.1
 */