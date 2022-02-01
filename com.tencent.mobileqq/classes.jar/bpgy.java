import android.util.Property;

class bpgy
  extends Property<bpgv, Float>
{
  bpgy(bpgv parambpgv, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bpgv parambpgv)
  {
    if (parambpgv != null) {
      return Float.valueOf(bpgv.a(parambpgv));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bpgv parambpgv, Float paramFloat)
  {
    if (parambpgv != null) {
      bpgv.a(parambpgv, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgy
 * JD-Core Version:    0.7.0.1
 */