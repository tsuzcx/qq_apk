import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.qq.im.poi.LbsPackPoiListActivity;

public class anm
  implements View.OnClickListener
{
  public anm(LbsPackPoiListActivity paramLbsPackPoiListActivity) {}
  
  public void onClick(View paramView)
  {
    LbsPackPoiListActivity.a(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     anm
 * JD-Core Version:    0.7.0.1
 */