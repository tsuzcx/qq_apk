import android.util.Property;

class bpvb
  extends Property<bpuy, Float>
{
  bpvb(bpuy parambpuy, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bpuy parambpuy)
  {
    if (parambpuy != null) {
      return Float.valueOf(bpuy.a(parambpuy));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bpuy parambpuy, Float paramFloat)
  {
    if (parambpuy != null) {
      bpuy.a(parambpuy, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpvb
 * JD-Core Version:    0.7.0.1
 */