import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;

public class bhjq
  implements View.OnLongClickListener
{
  public bhjq(InnerWebView paramInnerWebView) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = InnerWebView.a(this.a).getHitTestResult();
    if ((paramView.getType() == 5) || (paramView.getType() == 8))
    {
      paramView = paramView.getExtra();
      if (QMLog.isColorLevel()) {
        QMLog.e("ProgressWebView", "onLongClick : " + paramView);
      }
      bgsi localbgsi = bgsi.a(InnerWebView.a(this.a).getContext());
      localbgsi.a("发送给朋友", 7);
      localbgsi.a("保存到手机", 7);
      localbgsi.a("取消");
      localbgsi.a(true);
      localbgsi.a(new bhjr(this, localbgsi, paramView));
      localbgsi.show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjq
 * JD-Core Version:    0.7.0.1
 */