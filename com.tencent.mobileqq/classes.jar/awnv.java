import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.utils.NetworkUtil;

public class awnv
  implements TextWatcher
{
  public awnv(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    ChooseInterestTagActivity.a(this.a).removeMessages(4097);
    ChooseInterestTagActivity.b(this.a, 0);
    String str;
    if (ChooseInterestTagActivity.a(this.a).getText() == null)
    {
      paramEditable = "";
      str = awkj.a(paramEditable);
      if (ChooseInterestTagActivity.a(this.a).getText() != null) {
        break label163;
      }
      paramEditable = "";
      label59:
      if (!TextUtils.isEmpty(paramEditable)) {
        break label185;
      }
      if (ChooseInterestTagActivity.b(this.a).getVisibility() != 8) {
        ChooseInterestTagActivity.b(this.a).setVisibility(8);
      }
      ChooseInterestTagActivity.a(this.a).a(ChooseInterestTagActivity.a(this.a), true);
      paramEditable = this.a;
      if (ChooseInterestTagActivity.b(this.a) == -1) {
        break label180;
      }
    }
    label163:
    label180:
    for (boolean bool = true;; bool = false)
    {
      ChooseInterestTagActivity.a(paramEditable, false, bool);
      ChooseInterestTagActivity.a(this.a, "");
      return;
      paramEditable = ChooseInterestTagActivity.a(this.a).getText().toString();
      break;
      paramEditable = ChooseInterestTagActivity.a(this.a).getText().toString();
      break label59;
    }
    label185:
    if (TextUtils.isEmpty(str))
    {
      if (ChooseInterestTagActivity.b(this.a).getVisibility() != 0) {
        ChooseInterestTagActivity.b(this.a).setVisibility(0);
      }
      ChooseInterestTagActivity.b(this.a).setText(amtj.a(2131700962));
      ChooseInterestTagActivity.c(this.a).setVisibility(8);
      ChooseInterestTagActivity.a(this.a, "");
      return;
    }
    if (ChooseInterestTagActivity.b(this.a).getVisibility() != 0) {
      ChooseInterestTagActivity.b(this.a).setVisibility(0);
    }
    if (NetworkUtil.isNetSupport(this.a))
    {
      ChooseInterestTagActivity.b(this.a).setText(amtj.a(2131700967));
      ChooseInterestTagActivity.c(this.a).setVisibility(8);
      ChooseInterestTagActivity.a(this.a, str);
      ChooseInterestTagActivity.a(this.a).sendEmptyMessageDelayed(4097, 400L);
      return;
    }
    if (!ChooseInterestTagActivity.c(this.a))
    {
      ChooseInterestTagActivity.a(this.a, amtj.a(2131700942));
      ChooseInterestTagActivity.a(this.a, true);
      ChooseInterestTagActivity.a(this.a).sendEmptyMessageDelayed(4100, 3000L);
    }
    ChooseInterestTagActivity.b(this.a).setText("");
    ChooseInterestTagActivity.b(this.a).setOnClickListener(null);
    ChooseInterestTagActivity.c(this.a).setVisibility(8);
    ChooseInterestTagActivity.a(this.a, "");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    ChooseInterestTagActivity.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnv
 * JD-Core Version:    0.7.0.1
 */