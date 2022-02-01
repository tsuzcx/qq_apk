import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;

public class bfbu
  implements TextWatcher
{
  public bfbu(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a == null) {
      return;
    }
    paramInt1 = paramCharSequence.length();
    paramCharSequence = TroopNickRuleFragment.c - paramInt1 + "/" + TroopNickRuleFragment.c + "字";
    if (paramInt1 >= TroopNickRuleFragment.c) {
      this.a.a.setTextColor(this.a.getResources().getColor(2131166922));
    }
    for (;;)
    {
      this.a.a.setText(paramCharSequence);
      return;
      this.a.a.setTextColor(ColorUtils.parseColor("#878B99"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbu
 * JD-Core Version:    0.7.0.1
 */