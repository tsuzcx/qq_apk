import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class avai
  implements View.OnClickListener
{
  public avai(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == ChooseInterestTagActivity.b(this.a)) {
      if (TextUtils.isEmpty(ChooseInterestTagActivity.a(this.a)))
      {
        ChooseInterestTagActivity.a(this.a).a(ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.b(this.a), 30, 0, 0);
        ChooseInterestTagActivity.a(this.a, true, true);
      }
    }
    label371:
    do
    {
      do
      {
        return;
        ChooseInterestTagActivity.a(this.a).a(ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.c(this.a), 30, 0, 0);
        break;
        if (paramView == this.a.leftView)
        {
          bhsj.b(ChooseInterestTagActivity.a(this.a));
          if (ChooseInterestTagActivity.a(this.a))
          {
            this.a.finish();
            return;
          }
          localObject = this.a.getIntent();
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = new Intent();
          }
          Collections.reverse(ChooseInterestTagActivity.a(this.a));
          paramView.putParcelableArrayListExtra("choosed_interest_tags", ChooseInterestTagActivity.a(this.a));
          paramView.putExtra("interest_tag_type", ChooseInterestTagActivity.a(this.a));
          this.a.setResult(-1, paramView);
          this.a.finish();
          return;
        }
        if (paramView != this.a.rightViewText) {
          break label371;
        }
        bhsj.b(ChooseInterestTagActivity.a(this.a));
      } while (!ChooseInterestTagActivity.a(this.a));
      if (ChooseInterestTagActivity.a(this.a).isEmpty())
      {
        ChooseInterestTagActivity.a(this.a, alud.a(2131702189));
        return;
      }
      ChooseInterestTagActivity.a(this.a, 0, alud.a(2131702183), 0);
      Collections.reverse(ChooseInterestTagActivity.a(this.a));
      paramView = new avau(ChooseInterestTagActivity.a(this.a));
      paramView.a.addAll(ChooseInterestTagActivity.a(this.a));
      Object localObject = new ArrayList(1);
      ((List)localObject).add(paramView);
      ChooseInterestTagActivity.a(this.a).a((List)localObject, 0, 1);
      return;
    } while (paramView != ChooseInterestTagActivity.a(this.a));
    ChooseInterestTagActivity.a(this.a).setText(alud.a(2131702206));
    paramView = ChooseInterestTagActivity.a(this.a);
    int j = ChooseInterestTagActivity.a(this.a);
    int k = ChooseInterestTagActivity.b(this.a);
    if (ChooseInterestTagActivity.a(this.a)) {}
    for (int i = 1;; i = 0)
    {
      paramView.a("", j, k, 30, 0, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avai
 * JD-Core Version:    0.7.0.1
 */