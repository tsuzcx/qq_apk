import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout;

public class aqid
  implements TouchWebView.OnScrollChangedListener
{
  public aqid(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (paramInt4 > paramInt2) {
      if (paramInt2 == 0) {
        this.a.a.b();
      }
    }
    while ((paramInt4 >= paramInt2) || (paramInt2 < this.a.c.getHeight())) {
      return;
    }
    this.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqid
 * JD-Core Version:    0.7.0.1
 */