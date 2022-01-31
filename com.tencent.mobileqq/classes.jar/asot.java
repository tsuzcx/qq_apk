import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.LinearLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.smtt.sdk.WebView;

public class asot
  extends aspb
{
  public asot(QQGameFeedWebFragment paramQQGameFeedWebFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.a.g = System.currentTimeMillis();
    super.onPageFinished(paramWebView, paramString);
    QQGameFeedWebFragment.a(this.a).setVisibility(0);
    QQGameFeedWebFragment.a(this.a).setVisibility(8);
    if ((this.a.isAdded()) && (QQGameFeedWebFragment.a(this.a) != null)) {
      QQGameFeedWebFragment.a(this.a).a(true);
    }
    QQGameFeedWebFragment.b(this.a);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.a.e = System.currentTimeMillis();
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asot
 * JD-Core Version:    0.7.0.1
 */