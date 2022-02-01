import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.minicode.Utils;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class biqs
  implements bhis<String>
{
  biqs(biqq parambiqq) {}
  
  public String a(Bitmap paramBitmap)
  {
    String str = bhin.a() + System.currentTimeMillis() + ".jpg";
    Utils.saveBitmapToFile(paramBitmap, str, Bitmap.CompressFormat.JPEG, 100, true);
    return str;
  }
  
  public void a(Exception paramException)
  {
    QLog.e("SwiftBrowserShareMenuHandler", 1, "onScreenShotError , error is " + paramException.getMessage());
    if (this.a.a.a() == null)
    {
      QLog.e("SwiftBrowserShareMenuHandler", 1, "screen long shot onScreenShotError, activity is null");
      return;
    }
    QQToast.a(this.a.a.a(), 2131717711, 0).a();
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.a.a.a() == null)
    {
      QLog.e("SwiftBrowserShareMenuHandler", 1, "screen long shot error, activity is null");
      return;
    }
    paramBitmap = new Intent();
    paramBitmap.putExtra("public_fragment_window_feature", 1);
    paramBitmap.putExtra("screen_path", paramString);
    paramBitmap.putExtra("is_web_screen_long_shot", true);
    afez.a(this.a.a.a(), paramBitmap, PublicTransFragmentActivity.class, ScreenShotFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biqs
 * JD-Core Version:    0.7.0.1
 */