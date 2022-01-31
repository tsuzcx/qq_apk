import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;

public class bcdb
  implements bbav<String>
{
  public bcdb(WebViewFragment paramWebViewFragment) {}
  
  public String a(Bitmap paramBitmap)
  {
    String str = WebViewFragment.d + System.currentTimeMillis() + ".jpg";
    asjo.a(paramBitmap, str, Bitmap.CompressFormat.JPEG, 100, true);
    return str;
  }
  
  public void a(Exception paramException)
  {
    QLog.e("WebLog_WebViewFragment", 1, "onScreenShotError, error is " + paramException.getMessage());
    if (this.a.getActivity() == null)
    {
      QLog.e("WebLog_WebViewFragment", 1, "screen long shot onScreenShotError, activity is null");
      return;
    }
    bcql.a(this.a.getActivity(), 2131719049, 0).a();
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.a.getActivity() == null)
    {
      QLog.e("WebLog_WebViewFragment", 1, "screen long shot error, activity is null");
      return;
    }
    paramBitmap = new Intent();
    paramBitmap.putExtra("public_fragment_window_feature", 1);
    paramBitmap.putExtra("screen_path", paramString);
    paramBitmap.putExtra("is_web_screen_long_shot", true);
    abtq.a(this.a.getActivity(), paramBitmap, PublicTransFragmentActivity.class, ScreenShotFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcdb
 * JD-Core Version:    0.7.0.1
 */