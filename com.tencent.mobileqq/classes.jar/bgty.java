import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

class bgty
  implements TouchWebView.OnScrollChangedListener
{
  bgty(bgtw parambgtw) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.a.mScrollPos = paramInt2;
    this.a.updateTitleBar(this.a.mScrollPos, this.a.mIsShade);
    paramView = this.a.mUIStyleHandler.getWebView();
    if ((paramView != null) && (!TextUtils.isEmpty(this.a.mWebViewScrollChangeCb))) {
      paramView.callJs(this.a.mWebViewScrollChangeCb, new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(paramInt3), String.valueOf(paramInt4) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgty
 * JD-Core Version:    0.7.0.1
 */