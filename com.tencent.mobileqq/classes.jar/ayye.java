import SummaryCardTaf.SSummaryCardRsp;
import android.util.Pair;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.4.1;

public class ayye
  extends CardObserver
{
  ayye(ayyb paramayyb) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (!ayyb.e(this.a).isFinishing())
      {
        ayyb.a(this.a).removeCallbacks(ayyb.a(this.a));
        ayyb.a(this.a);
        if ((paramBoolean) && (paramObject != null))
        {
          if ((paramObject instanceof Card))
          {
            ThreadManager.post(new AbsVasProfileHeaderComponent.4.1(this, (Card)paramObject), 5, null, true);
            return;
          }
          if ((paramObject instanceof Pair))
          {
            paramObject = (Pair)paramObject;
            if (((Integer)paramObject.first).intValue() == 101107) {
              ayyb.a(this.a, 1);
            }
            for (;;)
            {
              ayyb.b(this.a);
              return;
              if (((Integer)paramObject.first).intValue() == 101108)
              {
                ayyb.a(this.a, 2);
              }
              else if (((Integer)paramObject.first).intValue() == 101111)
              {
                ayyb.a(this.a, 3);
              }
              else
              {
                if (((Integer)paramObject.first).intValue() != 12002) {
                  break;
                }
                ayyb.a(this.a, 4);
              }
            }
            ayyb.a(this.a, 5);
            ayyb.a(this.a, (SSummaryCardRsp)paramObject.second);
          }
        }
      }
      return;
    }
    catch (Exception paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayye
 * JD-Core Version:    0.7.0.1
 */