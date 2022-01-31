import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class bekv
{
  @TargetApi(14)
  public static void a(View paramView, CharSequence paramCharSequence, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      paramView.setAccessibilityDelegate(new bekw(paramCharSequence, paramString));
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    a(paramView, null, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekv
 * JD-Core Version:    0.7.0.1
 */