import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;

class bjsp
  implements View.OnClickListener
{
  bjsp(bjso parambjso) {}
  
  public void onClick(View paramView)
  {
    if (bjso.a(this.a) == -1) {
      bjso.a(this.a, "Clk_add_topic");
    }
    TroopBarPublishUtils.a((Activity)this.a.a(), 1001, bjso.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsp
 * JD-Core Version:    0.7.0.1
 */