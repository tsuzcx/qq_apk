import android.util.Property;

class bpgw
  extends Property<bpgv, Integer>
{
  bpgw(bpgv parambpgv, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpgv parambpgv)
  {
    if (parambpgv != null) {
      return Integer.valueOf(bpgv.a(parambpgv));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bpgv parambpgv, Integer paramInteger)
  {
    if (parambpgv != null) {
      bpgv.a(parambpgv, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgw
 * JD-Core Version:    0.7.0.1
 */