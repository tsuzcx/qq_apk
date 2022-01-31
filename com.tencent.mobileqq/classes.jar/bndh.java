import android.util.Property;

class bndh
  extends Property<bndb, Float>
{
  bndh(bndb parambndb, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bndb parambndb)
  {
    return Float.valueOf(bndb.b(parambndb));
  }
  
  public void a(bndb parambndb, Float paramFloat)
  {
    bndb.a(parambndb, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndh
 * JD-Core Version:    0.7.0.1
 */