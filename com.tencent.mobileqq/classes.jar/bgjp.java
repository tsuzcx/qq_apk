import android.content.Context;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.vas.qvip.view.QQVipArkHeaderView;
import com.tencent.mobileqq.vas.qvip.view.QvipArkView;

public class bgjp
  implements View.OnLayoutChangeListener
{
  public bgjp(QQVipArkHeaderView paramQQVipArkHeaderView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (QQVipArkHeaderView.a(this.a).getHeight() > 0)
    {
      float f = (this.a.getHeight() * 1.0F - AIOUtils.dp2px(54.0F, this.a.getContext().getResources())) / QQVipArkHeaderView.a(this.a).getHeight();
      QQVipArkHeaderView.a(this.a).setScaleY(f);
      QQVipArkHeaderView.a(this.a).setScaleX(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjp
 * JD-Core Version:    0.7.0.1
 */