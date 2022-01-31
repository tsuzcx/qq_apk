import android.util.Property;

class bndc
  extends Property<bndb, Float>
{
  bndc(bndb parambndb, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bndb parambndb)
  {
    if (parambndb != null) {
      return Float.valueOf(bndb.a(parambndb));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bndb parambndb, Float paramFloat)
  {
    if (parambndb != null) {
      bndb.a(parambndb, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndc
 * JD-Core Version:    0.7.0.1
 */