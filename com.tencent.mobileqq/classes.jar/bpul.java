import android.util.Property;

class bpul
  extends Property<bpuh, Integer>
{
  bpul(bpuh parambpuh, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpuh parambpuh)
  {
    if (parambpuh != null) {
      return Integer.valueOf(bpuh.b(parambpuh));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bpuh parambpuh, Integer paramInteger)
  {
    if (parambpuh != null) {
      bpuh.b(parambpuh, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpul
 * JD-Core Version:    0.7.0.1
 */