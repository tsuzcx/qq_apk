import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.qphone.base.util.QLog;

public class awtd
  implements View.OnLayoutChangeListener
{
  public awtd(StuffContainerView paramStuffContainerView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    long l1 = System.currentTimeMillis();
    long l2 = StuffContainerView.a(this.a);
    if ((StuffContainerView.a(this.a) > 0L) && (l1 - l2 < 500L)) {}
    do
    {
      return;
      StuffContainerView.a(this.a, l1);
      if (QLog.isColorLevel()) {
        QLog.d("StuffContainerView", 2, "VideoInfoListenerImpl onLayoutChange");
      }
    } while (this.a.a == null);
    this.a.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtd
 * JD-Core Version:    0.7.0.1
 */