import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.Nullable;

public class bixf
{
  @Nullable
  public static Activity a(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper))
    {
      paramContext = (ContextWrapper)paramContext;
      if ((paramContext.getBaseContext() instanceof Activity)) {
        return (Activity)paramContext.getBaseContext();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bixf
 * JD-Core Version:    0.7.0.1
 */