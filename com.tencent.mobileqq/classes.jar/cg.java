import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;

public class cg
  implements CompoundButton.OnCheckedChangeListener
{
  public cg(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!LiteAdvanceActivity.a(this.a, paramBoolean))
    {
      paramCompoundButton = LiteAdvanceActivity.a(this.a);
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        QQToast.a(this.a, 1, alpo.a(2131706566), 0).b(this.a.getTitleBarHeight());
        return;
      }
    }
    LiteAdvanceActivity.b(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cg
 * JD-Core Version:    0.7.0.1
 */