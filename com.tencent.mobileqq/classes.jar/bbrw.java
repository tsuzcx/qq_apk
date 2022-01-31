import android.content.Context;
import android.text.TextUtils;
import com.tencent.wifisdk.TMSDKCustomConfig.IToast;

final class bbrw
  implements TMSDKCustomConfig.IToast
{
  public void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      bbmy.a(paramContext, paramCharSequence, paramInt).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbrw
 * JD-Core Version:    0.7.0.1
 */