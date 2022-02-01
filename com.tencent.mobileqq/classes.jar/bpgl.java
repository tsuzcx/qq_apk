import android.util.Property;

class bpgl
  extends Property<bpge, Float>
{
  bpgl(bpge parambpge, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bpge parambpge)
  {
    return Float.valueOf(bpge.c(parambpge));
  }
  
  public void a(bpge parambpge, Float paramFloat)
  {
    bpge.b(parambpge, paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgl
 * JD-Core Version:    0.7.0.1
 */