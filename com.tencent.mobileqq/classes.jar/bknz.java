import android.util.Property;

class bknz
  extends Property<bknw, Float>
{
  bknz(bknw parambknw, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bknw parambknw)
  {
    if (parambknw != null) {
      return Float.valueOf(bknw.a(parambknw));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bknw parambknw, Float paramFloat)
  {
    if (parambknw != null) {
      bknw.a(parambknw, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknz
 * JD-Core Version:    0.7.0.1
 */