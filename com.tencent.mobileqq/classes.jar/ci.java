import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;

public class ci
  implements CompoundButton.OnCheckedChangeListener
{
  public ci(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LiteAdvanceActivity.d(this.a, paramBoolean);
    LiteAdvanceActivity.b(this.a, LiteAdvanceActivity.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ci
 * JD-Core Version:    0.7.0.1
 */