import android.util.Property;

class bpup
  extends Property<bpuh, Float>
{
  bpup(bpuh parambpuh, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bpuh parambpuh)
  {
    if (parambpuh != null) {
      return Float.valueOf(bpuh.d(parambpuh));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bpuh parambpuh, Float paramFloat)
  {
    if (parambpuh != null) {
      bpuh.c(parambpuh, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpup
 * JD-Core Version:    0.7.0.1
 */