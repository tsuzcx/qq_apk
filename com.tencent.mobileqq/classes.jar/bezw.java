import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.wifisdk.TMSDKCustomConfig.IToast;

final class bezw
  implements TMSDKCustomConfig.IToast
{
  public void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      QQToast.a(paramContext, paramCharSequence, paramInt).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezw
 * JD-Core Version:    0.7.0.1
 */