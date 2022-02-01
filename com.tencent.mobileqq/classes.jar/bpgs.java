import android.util.Property;

class bpgs
  extends Property<bpgq, Integer>
{
  bpgs(bpgq parambpgq, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpgq parambpgq)
  {
    if (parambpgq != null) {
      return Integer.valueOf(bpgq.a(parambpgq));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bpgq parambpgq, Integer paramInteger)
  {
    if (parambpgq != null) {
      bpgq.a(parambpgq, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgs
 * JD-Core Version:    0.7.0.1
 */