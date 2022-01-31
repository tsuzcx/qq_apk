import android.util.Property;

class bkns
  extends Property<bknr, Float>
{
  bkns(bknr parambknr, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bknr parambknr)
  {
    if (parambknr != null) {
      return Float.valueOf(bknr.a(parambknr));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bknr parambknr, Float paramFloat)
  {
    if (parambknr != null) {
      bknr.a(parambknr, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkns
 * JD-Core Version:    0.7.0.1
 */