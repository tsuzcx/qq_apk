import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

final class blwg
  implements blwo
{
  public Collection<blwh> a()
  {
    synchronized ()
    {
      if (blwf.a().size() <= 0)
      {
        localObject1 = null;
        return localObject1;
      }
      Object localObject1 = new ArrayList(blwf.a().values());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwg
 * JD-Core Version:    0.7.0.1
 */