import android.util.Property;

class bndi
  extends Property<bndb, Float>
{
  bndi(bndb parambndb, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bndb parambndb)
  {
    return Float.valueOf(bndb.c(parambndb));
  }
  
  public void a(bndb parambndb, Float paramFloat)
  {
    bndb.b(parambndb, paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndi
 * JD-Core Version:    0.7.0.1
 */