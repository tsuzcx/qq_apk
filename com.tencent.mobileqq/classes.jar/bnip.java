import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import dov.com.qq.im.ae.cmshow.AECMShowLoadingView;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

public class bnip
  implements PAGView.PAGViewListener
{
  public bnip(AECMShowLoadingView paramAECMShowLoadingView) {}
  
  private String a()
  {
    if (!TextUtils.isEmpty(AECMShowLoadingView.a(this.a))) {
      return AECMShowLoadingView.a(this.a);
    }
    return this.a.getContext().getString(2131690863);
  }
  
  public void onAnimationCancel(PAGView paramPAGView)
  {
    if (AECMShowLoadingView.a(this.a) != null) {
      AECMShowLoadingView.a(this.a).setText(a());
    }
    AECMShowLoadingView.a(this.a).removeListener(this);
  }
  
  public void onAnimationEnd(PAGView paramPAGView)
  {
    if (AECMShowLoadingView.a(this.a) != null) {
      AECMShowLoadingView.a(this.a).setText(a());
    }
    AECMShowLoadingView.a(this.a).removeListener(this);
  }
  
  public void onAnimationRepeat(PAGView paramPAGView) {}
  
  public void onAnimationStart(PAGView paramPAGView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnip
 * JD-Core Version:    0.7.0.1
 */