import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.smtt.sdk.WebView;

public class aqtw
  extends aque
{
  public aqtw(QQGameFeedWebFragment paramQQGameFeedWebFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    QQGameFeedWebFragment.a(this.a).setVisibility(0);
    if ((this.a.isAdded()) && (QQGameFeedWebFragment.a(this.a) != null)) {
      QQGameFeedWebFragment.a(this.a).a(true);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqtw
 * JD-Core Version:    0.7.0.1
 */