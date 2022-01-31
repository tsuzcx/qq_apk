import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.qq.im.poi.LbsPackPoiListActivity;

public class aoc
  implements View.OnClickListener
{
  public aoc(LbsPackPoiListActivity paramLbsPackPoiListActivity) {}
  
  public void onClick(View paramView)
  {
    LbsPackPoiListActivity.a(this.a).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aoc
 * JD-Core Version:    0.7.0.1
 */