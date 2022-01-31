import android.util.Property;

class bnde
  extends Property<bndb, Integer>
{
  bnde(bndb parambndb, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bndb parambndb)
  {
    if (parambndb != null) {
      return Integer.valueOf(bndb.a(parambndb));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bndb parambndb, Integer paramInteger)
  {
    if (parambndb != null) {
      bndb.a(parambndb, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnde
 * JD-Core Version:    0.7.0.1
 */