import android.util.Property;

class bpgn
  extends Property<bpge, Integer>
{
  bpgn(bpge parambpge, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpge parambpge)
  {
    if (parambpge != null) {
      return Integer.valueOf(bpge.d(parambpge));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bpge parambpge, Integer paramInteger)
  {
    if (parambpge != null) {
      bpge.d(parambpge, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgn
 * JD-Core Version:    0.7.0.1
 */