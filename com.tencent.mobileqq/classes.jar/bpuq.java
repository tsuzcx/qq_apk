import android.util.Property;

class bpuq
  extends Property<bpuh, Integer>
{
  bpuq(bpuh parambpuh, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpuh parambpuh)
  {
    if (parambpuh != null) {
      return Integer.valueOf(bpuh.d(parambpuh));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bpuh parambpuh, Integer paramInteger)
  {
    if (parambpuh != null) {
      bpuh.d(parambpuh, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpuq
 * JD-Core Version:    0.7.0.1
 */