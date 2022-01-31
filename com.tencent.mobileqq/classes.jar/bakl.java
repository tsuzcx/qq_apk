import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;

public final class bakl
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("themePath");
    String str3 = paramIntent.getStringExtra("themeId");
    String str1 = paramIntent.getStringExtra("bg3D");
    String str4 = paramIntent.getStringExtra("aio");
    String str5 = paramIntent.getStringExtra("playerSkin");
    if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3))) {
      ThemeUtil.validLocalTheme(paramContext, str2, str3);
    }
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        paramIntent = (QQAppInterface)ThemeUtil.weakApp.get();
      } while (paramIntent == null);
      ThemeUtil.access$000(paramContext, paramIntent, paramIntent.getCurrentAccountUin(), str1);
      return;
      if (!TextUtils.isEmpty(str4))
      {
        ThemeUtil.previewAIOTheme(paramContext, str4);
        return;
      }
      if (!TextUtils.isEmpty(str5))
      {
        ThemeUtil.previewPlayerSkin(paramContext, str5);
        return;
      }
    } while (!ThemeUtil.themeFont(paramIntent, "themeFont"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakl
 * JD-Core Version:    0.7.0.1
 */