import android.content.Context;
import android.text.TextUtils;
import com.tencent.wifisdk.TMSDKCustomConfig.IToast;

final class bcwl
  implements TMSDKCustomConfig.IToast
{
  public void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      bcql.a(paramContext, paramCharSequence, paramInt).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcwl
 * JD-Core Version:    0.7.0.1
 */