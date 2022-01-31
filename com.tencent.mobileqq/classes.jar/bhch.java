import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

final class bhch
  implements bhcp
{
  public Collection<bhci> a()
  {
    synchronized ()
    {
      if (bhcg.a().size() <= 0)
      {
        localObject1 = null;
        return localObject1;
      }
      Object localObject1 = new ArrayList(bhcg.a().values());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhch
 * JD-Core Version:    0.7.0.1
 */