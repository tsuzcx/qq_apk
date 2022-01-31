import android.util.Property;

class bndk
  extends Property<bndb, Integer>
{
  bndk(bndb parambndb, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bndb parambndb)
  {
    if (parambndb != null) {
      return Integer.valueOf(bndb.d(parambndb));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bndb parambndb, Integer paramInteger)
  {
    if (parambndb != null) {
      bndb.d(parambndb, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndk
 * JD-Core Version:    0.7.0.1
 */