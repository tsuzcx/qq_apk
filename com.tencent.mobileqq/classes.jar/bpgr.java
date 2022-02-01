import android.util.Property;

class bpgr
  extends Property<bpgq, Float>
{
  bpgr(bpgq parambpgq, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bpgq parambpgq)
  {
    if (parambpgq != null) {
      return Float.valueOf(bpgq.a(parambpgq));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bpgq parambpgq, Float paramFloat)
  {
    if (parambpgq != null) {
      bpgq.a(parambpgq, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgr
 * JD-Core Version:    0.7.0.1
 */