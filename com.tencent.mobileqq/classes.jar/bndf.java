import android.util.Property;

class bndf
  extends Property<bndb, Integer>
{
  bndf(bndb parambndb, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bndb parambndb)
  {
    if (parambndb != null) {
      return Integer.valueOf(bndb.b(parambndb));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bndb parambndb, Integer paramInteger)
  {
    if (parambndb != null) {
      bndb.b(parambndb, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndf
 * JD-Core Version:    0.7.0.1
 */