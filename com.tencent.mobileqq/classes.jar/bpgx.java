import android.util.Property;

class bpgx
  extends Property<bpgv, Integer>
{
  bpgx(bpgv parambpgv, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpgv parambpgv)
  {
    if (parambpgv != null) {
      return Integer.valueOf(bpgv.b(parambpgv));
    }
    return Integer.valueOf(255);
  }
  
  public void a(bpgv parambpgv, Integer paramInteger)
  {
    if (parambpgv != null) {
      bpgv.b(parambpgv, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgx
 * JD-Core Version:    0.7.0.1
 */