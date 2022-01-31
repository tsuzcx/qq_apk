import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;

public class by
  implements CompoundButton.OnCheckedChangeListener
{
  public by(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LiteAdvanceActivity.b(this.a, paramBoolean);
    LiteAdvanceActivity.b(this.a, LiteAdvanceActivity.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     by
 * JD-Core Version:    0.7.0.1
 */