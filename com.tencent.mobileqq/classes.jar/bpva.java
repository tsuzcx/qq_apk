import android.util.Property;

class bpva
  extends Property<bpuy, Integer>
{
  bpva(bpuy parambpuy, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpuy parambpuy)
  {
    if (parambpuy != null) {
      return Integer.valueOf(bpuy.b(parambpuy));
    }
    return Integer.valueOf(255);
  }
  
  public void a(bpuy parambpuy, Integer paramInteger)
  {
    if (parambpuy != null) {
      bpuy.b(parambpuy, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpva
 * JD-Core Version:    0.7.0.1
 */