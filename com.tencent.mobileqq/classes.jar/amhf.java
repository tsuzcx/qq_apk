import android.annotation.TargetApi;
import android.view.VelocityTracker;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.OverScroller;

class amhf
  implements Runnable
{
  amhf(amhe paramamhe) {}
  
  @TargetApi(8)
  public void run()
  {
    int i = AbsListView.access$1200(this.a.a);
    VelocityTracker localVelocityTracker = AbsListView.access$1300(this.a.a);
    OverScroller localOverScroller = amhe.a(this.a);
    if ((localVelocityTracker == null) || (i == -1)) {
      return;
    }
    localVelocityTracker.computeCurrentVelocity(1000, AbsListView.access$1400(this.a.a));
    if (VersionUtils.b()) {}
    for (float f = -localVelocityTracker.getYVelocity(i); (Math.abs(f) >= AbsListView.access$1500(this.a.a)) && (localOverScroller.a(0.0F, f)); f = -localVelocityTracker.getYVelocity())
    {
      this.a.a.postDelayed(this, 40L);
      return;
    }
    this.a.a();
    this.a.a.mTouchMode = 3;
    this.a.a.reportScrollStateChange(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhf
 * JD-Core Version:    0.7.0.1
 */