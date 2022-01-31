import android.app.Activity;
import android.content.Intent;
import com.tencent.qqmini.sdk.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.ui.MiniFragmentActivity;

public class bdye
{
  public static void a(Activity paramActivity, Intent paramIntent, Class<? extends MiniFragmentActivity> paramClass, Class<? extends MiniBaseFragment> paramClass1, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramActivity, paramClass);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdye
 * JD-Core Version:    0.7.0.1
 */