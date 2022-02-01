import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class axtv
  implements View.OnClickListener
{
  public axtv(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if ((ChooseInterestTagActivity.a(this.a) == 3) || (ChooseInterestTagActivity.a(this.a) == 2) || (ChooseInterestTagActivity.a(this.a) == 1) || (ChooseInterestTagActivity.a(this.a) == 4))
    {
      localObject1 = (InterestTagInfo)paramView.getTag();
      if (localObject1 != null)
      {
        ChooseInterestTagActivity.a(this.a).remove(localObject1);
        ChooseInterestTagActivity.a(this.a, (InterestTagInfo)localObject1);
        ChooseInterestTagActivity.b(this.a, (InterestTagInfo)localObject1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      try
      {
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        if (arrayOfInt[0] <= 0) {
          continue;
        }
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)paramView.getTag();
        if (localInterestTagInfo == null) {
          continue;
        }
        Paint localPaint = new Paint();
        localPaint.setTextSize((float)(ChooseInterestTagActivity.a(this.a) * 14.0F + 0.5D));
        localPaint.setColor(this.a.getResources().getColor(2131167086));
        localPaint.setFakeBoldText(false);
        localPaint.setAntiAlias(true);
        Object localObject2 = localInterestTagInfo.tagName;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = " ";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 8) {
          localObject2 = ((String)localObject1).substring(0, 8) + "...";
        }
        float f = localPaint.measureText((String)localObject2);
        int i = (int)(ChooseInterestTagActivity.a(this.a) * 64.0F + 0.5D + f);
        localObject1 = new axul(this.a, arrayOfInt[0], i);
        ((axul)localObject1).a(ChooseInterestTagActivity.a(this.a));
        ((axul)localObject1).a(localInterestTagInfo);
        ((axul)localObject1).showAsDropDown(paramView, -(int)((i - 40.0F * ChooseInterestTagActivity.a(this.a)) / 2.0F), 10);
      }
      catch (Exception localException) {}
      if (QLog.isDevelopLevel()) {
        QLog.i("choose_interest_tag", 4, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtv
 * JD-Core Version:    0.7.0.1
 */