import android.util.Property;

class bpuu
  extends Property<bput, Float>
{
  bpuu(bput parambput, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bput parambput)
  {
    if (parambput != null) {
      return Float.valueOf(bput.a(parambput));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bput parambput, Float paramFloat)
  {
    if (parambput != null) {
      bput.a(parambput, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpuu
 * JD-Core Version:    0.7.0.1
 */