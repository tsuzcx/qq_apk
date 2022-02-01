import android.util.Property;

class bpgb
  extends Property<bpga, Integer>
{
  bpgb(bpga parambpga, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpga parambpga)
  {
    if (parambpga != null) {
      return Integer.valueOf(bpga.a(parambpga));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bpga parambpga, Integer paramInteger)
  {
    if (parambpga != null) {
      bpga.a(parambpga, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgb
 * JD-Core Version:    0.7.0.1
 */