import android.util.Property;

class bpgh
  extends Property<bpge, Integer>
{
  bpgh(bpge parambpge, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpge parambpge)
  {
    if (parambpge != null) {
      return Integer.valueOf(bpge.a(parambpge));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bpge parambpge, Integer paramInteger)
  {
    if (parambpge != null) {
      bpge.a(parambpge, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgh
 * JD-Core Version:    0.7.0.1
 */