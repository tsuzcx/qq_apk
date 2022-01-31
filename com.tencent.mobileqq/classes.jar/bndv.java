import android.util.Property;

class bndv
  extends Property<bnds, Float>
{
  bndv(bnds parambnds, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bnds parambnds)
  {
    if (parambnds != null) {
      return Float.valueOf(bnds.a(parambnds));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bnds parambnds, Float paramFloat)
  {
    if (parambnds != null) {
      bnds.a(parambnds, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndv
 * JD-Core Version:    0.7.0.1
 */