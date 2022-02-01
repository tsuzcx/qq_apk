import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.minicode.Utils;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class bihq
  implements bhat<String>
{
  bihq(biho parambiho) {}
  
  public String a(Bitmap paramBitmap)
  {
    String str = bhao.a() + System.currentTimeMillis() + ".jpg";
    Utils.saveBitmapToFile(paramBitmap, str, Bitmap.CompressFormat.JPEG, 100, true);
    return str;
  }
  
  public void a(Exception paramException)
  {
    QLog.e("SwiftBrowserShareMenuHandler", 1, "onScreenShotError , error is " + paramException.getMessage());
    if (this.a.mComponentContext.a() == null)
    {
      QLog.e("SwiftBrowserShareMenuHandler", 1, "screen long shot onScreenShotError, activity is null");
      return;
    }
    QQToast.a(this.a.mComponentContext.a(), 2131718330, 0).a();
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.a.mComponentContext.a() == null)
    {
      QLog.e("SwiftBrowserShareMenuHandler", 1, "screen long shot error, activity is null");
      return;
    }
    paramBitmap = new Intent();
    paramBitmap.putExtra("public_fragment_window_feature", 1);
    paramBitmap.putExtra("screen_path", paramString);
    paramBitmap.putExtra("is_web_screen_long_shot", true);
    aeow.a(this.a.mComponentContext.a(), paramBitmap, PublicTransFragmentActivity.class, ScreenShotFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bihq
 * JD-Core Version:    0.7.0.1
 */