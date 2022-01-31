import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;

public class bx
  implements CompoundButton.OnCheckedChangeListener
{
  public bx(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LiteAdvanceActivity.a(this.a, paramBoolean);
    LiteAdvanceActivity.a(this.a, LiteAdvanceActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bx
 * JD-Core Version:    0.7.0.1
 */