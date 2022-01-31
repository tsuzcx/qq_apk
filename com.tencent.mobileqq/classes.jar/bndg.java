import android.util.Property;

class bndg
  extends Property<bndb, Integer>
{
  bndg(bndb parambndb, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bndb parambndb)
  {
    if (parambndb != null) {
      return Integer.valueOf(bndb.c(parambndb));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bndb parambndb, Integer paramInteger)
  {
    if (parambndb != null) {
      bndb.c(parambndb, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndg
 * JD-Core Version:    0.7.0.1
 */