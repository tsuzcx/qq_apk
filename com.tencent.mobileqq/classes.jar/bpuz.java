import android.util.Property;

class bpuz
  extends Property<bpuy, Integer>
{
  bpuz(bpuy parambpuy, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bpuy parambpuy)
  {
    if (parambpuy != null) {
      return Integer.valueOf(bpuy.a(parambpuy));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bpuy parambpuy, Integer paramInteger)
  {
    if (parambpuy != null) {
      bpuy.a(parambpuy, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpuz
 * JD-Core Version:    0.7.0.1
 */