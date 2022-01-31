import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;

class bjry
  implements View.OnClickListener
{
  bjry(bjrx parambjrx) {}
  
  public void onClick(View paramView)
  {
    if (bjrx.a(this.a) == -1) {
      bjrx.a(this.a, "Clk_add_topic");
    }
    TroopBarPublishUtils.a((Activity)this.a.a(), 1001, bjrx.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjry
 * JD-Core Version:    0.7.0.1
 */