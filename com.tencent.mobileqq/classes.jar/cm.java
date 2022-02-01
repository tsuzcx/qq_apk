import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class cm
  implements CompoundButton.OnCheckedChangeListener
{
  public cm(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LiteAdvanceActivity.c(this.a, paramBoolean);
    LiteAdvanceActivity.a(this.a, LiteAdvanceActivity.a(this.a));
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     cm
 * JD-Core Version:    0.7.0.1
 */