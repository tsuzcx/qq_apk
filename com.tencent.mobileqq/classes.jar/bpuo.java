import android.util.Property;

class bpuo
  extends Property<bpuh, Float>
{
  bpuo(bpuh parambpuh, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bpuh parambpuh)
  {
    return Float.valueOf(bpuh.c(parambpuh));
  }
  
  public void a(bpuh parambpuh, Float paramFloat)
  {
    bpuh.b(parambpuh, paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpuo
 * JD-Core Version:    0.7.0.1
 */