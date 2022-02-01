import android.util.Property;

class bqwp
  extends Property<bqwo, Float>
{
  bqwp(bqwo parambqwo, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bqwo parambqwo)
  {
    if (parambqwo != null) {
      return Float.valueOf(bqwo.a(parambqwo));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bqwo parambqwo, Float paramFloat)
  {
    if (parambqwo != null) {
      bqwo.a(parambqwo, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqwp
 * JD-Core Version:    0.7.0.1
 */