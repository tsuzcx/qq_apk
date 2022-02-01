import android.util.Property;

class bpgi
  extends Property<bpge, Integer>
{
  bpgi(bpge parambpge, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpge parambpge)
  {
    if (parambpge != null) {
      return Integer.valueOf(bpge.b(parambpge));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bpge parambpge, Integer paramInteger)
  {
    if (parambpge != null) {
      bpge.b(parambpge, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgi
 * JD-Core Version:    0.7.0.1
 */