import android.util.Property;

class bpui
  extends Property<bpuh, Float>
{
  bpui(bpuh parambpuh, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bpuh parambpuh)
  {
    if (parambpuh != null) {
      return Float.valueOf(bpuh.a(parambpuh));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bpuh parambpuh, Float paramFloat)
  {
    if (parambpuh != null) {
      bpuh.a(parambpuh, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpui
 * JD-Core Version:    0.7.0.1
 */