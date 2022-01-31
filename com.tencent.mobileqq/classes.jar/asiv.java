import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class asiv
  implements View.OnClickListener
{
  public asiv(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ChooseInterestTagActivity.a(this.a) == 3) || (ChooseInterestTagActivity.a(this.a) == 2) || (ChooseInterestTagActivity.a(this.a) == 1) || (ChooseInterestTagActivity.a(this.a) == 4))
    {
      paramView = (InterestTagInfo)paramView.getTag();
      if (paramView != null)
      {
        ChooseInterestTagActivity.a(this.a).remove(paramView);
        ChooseInterestTagActivity.a(this.a, paramView);
        ChooseInterestTagActivity.b(this.a, paramView);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          int[] arrayOfInt = new int[2];
          paramView.getLocationInWindow(arrayOfInt);
          if (arrayOfInt[0] > 0)
          {
            InterestTagInfo localInterestTagInfo = (InterestTagInfo)paramView.getTag();
            if (localInterestTagInfo != null)
            {
              Paint localPaint = new Paint();
              localPaint.setTextSize((float)(ChooseInterestTagActivity.a(this.a) * 14.0F + 0.5D));
              localPaint.setColor(this.a.getResources().getColor(2131101317));
              localPaint.setFakeBoldText(false);
              localPaint.setAntiAlias(true);
              Object localObject2 = localInterestTagInfo.tagName;
              Object localObject1 = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = " ";
              }
              localObject2 = localObject1;
              if (((String)localObject1).length() > 8) {
                localObject2 = ((String)localObject1).substring(0, 8) + "...";
              }
              float f = localPaint.measureText((String)localObject2);
              int i = (int)(ChooseInterestTagActivity.a(this.a) * 64.0F + 0.5D + f);
              localObject1 = new asjl(this.a, arrayOfInt[0], i);
              ((asjl)localObject1).a(ChooseInterestTagActivity.a(this.a));
              ((asjl)localObject1).a(localInterestTagInfo);
              ((asjl)localObject1).showAsDropDown(paramView, -(int)((i - 40.0F * ChooseInterestTagActivity.a(this.a)) / 2.0F), 10);
              return;
            }
          }
        }
        catch (Exception paramView) {}
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("choose_interest_tag", 4, paramView.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asiv
 * JD-Core Version:    0.7.0.1
 */