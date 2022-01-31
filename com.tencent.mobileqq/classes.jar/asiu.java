import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class asiu
  implements View.OnClickListener
{
  public asiu(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
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
          beex.b(ChooseInterestTagActivity.a(this.a));
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
        beex.b(ChooseInterestTagActivity.a(this.a));
      } while (!ChooseInterestTagActivity.a(this.a));
      if (ChooseInterestTagActivity.a(this.a).isEmpty())
      {
        ChooseInterestTagActivity.a(this.a, ajjy.a(2131636010));
        return;
      }
      ChooseInterestTagActivity.a(this.a, 0, ajjy.a(2131636004), 0);
      Collections.reverse(ChooseInterestTagActivity.a(this.a));
      paramView = new asjg(ChooseInterestTagActivity.a(this.a));
      paramView.a.addAll(ChooseInterestTagActivity.a(this.a));
      Object localObject = new ArrayList(1);
      ((List)localObject).add(paramView);
      ChooseInterestTagActivity.a(this.a).a((List)localObject, 0, 1);
      return;
    } while (paramView != ChooseInterestTagActivity.a(this.a));
    ChooseInterestTagActivity.a(this.a).setText(ajjy.a(2131636027));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asiu
 * JD-Core Version:    0.7.0.1
 */