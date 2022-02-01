import android.util.Property;

class bpgk
  extends Property<bpge, Float>
{
  bpgk(bpge parambpge, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bpge parambpge)
  {
    return Float.valueOf(bpge.b(parambpge));
  }
  
  public void a(bpge parambpge, Float paramFloat)
  {
    bpge.a(parambpge, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgk
 * JD-Core Version:    0.7.0.1
 */