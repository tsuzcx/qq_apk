import android.widget.RelativeLayout;
import com.qq.im.poi.LbsPackListActivity;
import com.qq.im.poi.LbsPackMapPoiPackServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import com.tencent.widget.LbsPackHorizontalListView;

public class anl
  implements HorizontalListView.OnScrollStateChangedListener
{
  public anl(LbsPackListActivity paramLbsPackListActivity) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 4097)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "LbsPackListActivity SCROLL_STATE_IDLE checkRightBorder=" + LbsPackListActivity.a(this.a).b());
      }
      if ((!LbsPackListActivity.a(this.a)) && (LbsPackListActivity.a(this.a) != null) && (LbsPackListActivity.a(this.a).b()))
      {
        LbsPackListActivity.a(this.a, true);
        if (LbsPackListActivity.a(this.a) != null) {
          LbsPackListActivity.a(this.a).setVisibility(0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "LbsPackListActivity onScrollStateChanged sendLbsPackPageRequest false");
        }
        LbsPackMapPoiPackServlet.a(this.a.a, LbsPackListActivity.a(this.a), false, LbsPackListActivity.b(this.a));
      }
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     anl
 * JD-Core Version:    0.7.0.1
 */