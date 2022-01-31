import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;

public class avas
  implements View.OnKeyListener
{
  public avas(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0)) {
      if (ChooseInterestTagActivity.a(this.a).getText() == null)
      {
        paramView = "";
        if (TextUtils.isEmpty(paramView))
        {
          ChooseInterestTagActivity.a(this.a).fullScroll(66);
          ChooseInterestTagActivity.a(this.a, ChooseInterestTagActivity.d(this.a) + 1);
        }
      }
    }
    for (;;)
    {
      return false;
      paramView = ChooseInterestTagActivity.a(this.a).getText().toString();
      break;
      if ((paramInt == 66) && (paramKeyEvent.getAction() == 0)) {
        bhsj.b(ChooseInterestTagActivity.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avas
 * JD-Core Version:    0.7.0.1
 */