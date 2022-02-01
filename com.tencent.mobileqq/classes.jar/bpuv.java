import android.util.Property;

class bpuv
  extends Property<bput, Integer>
{
  bpuv(bput parambput, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bput parambput)
  {
    if (parambput != null) {
      return Integer.valueOf(bput.a(parambput));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bput parambput, Integer paramInteger)
  {
    if (parambput != null) {
      bput.a(parambput, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpuv
 * JD-Core Version:    0.7.0.1
 */