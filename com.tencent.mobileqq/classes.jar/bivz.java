import android.util.Property;

class bivz
  extends Property<bivy, Integer>
{
  bivz(bivy parambivy, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bivy parambivy)
  {
    if (parambivy != null) {
      return Integer.valueOf(bivy.a(parambivy));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bivy parambivy, Integer paramInteger)
  {
    if (parambivy != null) {
      bivy.a(parambivy, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivz
 * JD-Core Version:    0.7.0.1
 */