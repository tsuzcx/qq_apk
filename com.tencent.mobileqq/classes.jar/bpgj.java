import android.util.Property;

class bpgj
  extends Property<bpge, Integer>
{
  bpgj(bpge parambpge, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpge parambpge)
  {
    if (parambpge != null) {
      return Integer.valueOf(bpge.c(parambpge));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bpge parambpge, Integer paramInteger)
  {
    if (parambpge != null) {
      bpge.c(parambpge, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgj
 * JD-Core Version:    0.7.0.1
 */