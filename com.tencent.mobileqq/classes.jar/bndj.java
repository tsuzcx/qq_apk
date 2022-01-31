import android.util.Property;

class bndj
  extends Property<bndb, Float>
{
  bndj(bndb parambndb, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bndb parambndb)
  {
    if (parambndb != null) {
      return Float.valueOf(bndb.d(parambndb));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bndb parambndb, Float paramFloat)
  {
    if (parambndb != null) {
      bndb.c(parambndb, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndj
 * JD-Core Version:    0.7.0.1
 */