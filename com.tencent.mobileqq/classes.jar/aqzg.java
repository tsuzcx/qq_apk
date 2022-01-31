import android.support.v7.widget.StaggeredGridLayoutManager.ExceptionListener;
import android.view.View;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.qphone.base.util.QLog;

public class aqzg
  implements StaggeredGridLayoutManager.ExceptionListener
{
  public aqzg(HotPicPageView paramHotPicPageView) {}
  
  public void onGetPositionErr(View paramView, boolean paramBoolean, int paramInt, Exception paramException)
  {
    QLog.e("HotPicManagerHotPicPageView", 1, "onGetPositionErr 1  final p:" + paramInt + " rescue:" + paramBoolean + " v:" + paramView + " error: " + paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqzg
 * JD-Core Version:    0.7.0.1
 */