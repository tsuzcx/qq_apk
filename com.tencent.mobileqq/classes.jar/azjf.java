import android.annotation.TargetApi;
import android.support.annotation.Nullable;
import java.util.Collection;

@TargetApi(9)
public class azjf
{
  public static boolean a(@Nullable Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Collection)) {
        break label25;
      }
      if (!((Collection)paramObject).isEmpty()) {
        break label35;
      }
    }
    label25:
    while (paramObject.toString().isEmpty()) {
      return true;
    }
    label35:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjf
 * JD-Core Version:    0.7.0.1
 */