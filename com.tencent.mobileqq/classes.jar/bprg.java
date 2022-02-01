import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import dov.com.qq.im.capture.poi.FacePoiUI.3.1;
import dov.com.qq.im.capture.poi.FacePoiUI.3.2;

public class bprg
  implements blnt
{
  bprg(bpre parambpre) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.a == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.a)
    {
      paramView.c(l);
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramListView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.a == 0L)
    {
      l = System.currentTimeMillis();
      paramListView.a(l);
      if (!bhnv.g(this.a.e.getContext())) {
        break label114;
      }
      bpre.a(this.a).d();
      bpre.a(this.a).a();
      new Handler(Looper.getMainLooper()).postDelayed(new FacePoiUI.3.1(this), 300L);
    }
    for (;;)
    {
      ((ajss)paramView.getTag()).a = true;
      return true;
      l = this.a.a;
      break;
      label114:
      new Handler(Looper.getMainLooper()).postDelayed(new FacePoiUI.3.2(this), 300L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.a == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.a)
    {
      paramView.b(l);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bprg
 * JD-Core Version:    0.7.0.1
 */