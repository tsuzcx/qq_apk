import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class bgkg
{
  @TargetApi(14)
  public static void a(View paramView, CharSequence paramCharSequence, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      paramView.setAccessibilityDelegate(new bgkh(paramCharSequence, paramString));
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    a(paramView, null, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgkg
 * JD-Core Version:    0.7.0.1
 */