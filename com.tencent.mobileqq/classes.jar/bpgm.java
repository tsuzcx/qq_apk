import android.util.Property;

class bpgm
  extends Property<bpge, Float>
{
  bpgm(bpge parambpge, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bpge parambpge)
  {
    if (parambpge != null) {
      return Float.valueOf(bpge.d(parambpge));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bpge parambpge, Float paramFloat)
  {
    if (parambpge != null) {
      bpge.c(parambpge, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgm
 * JD-Core Version:    0.7.0.1
 */