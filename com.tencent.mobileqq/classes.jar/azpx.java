import SummaryCardTaf.SSummaryCardRsp;
import android.util.Pair;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.4.1;

public class azpx
  extends aniz
{
  azpx(azpu paramazpu) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (!azpu.e(this.a).isFinishing())
      {
        azpu.a(this.a).removeCallbacks(azpu.a(this.a));
        azpu.a(this.a);
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
              azpu.a(this.a, 1);
            }
            for (;;)
            {
              azpu.b(this.a);
              return;
              if (((Integer)paramObject.first).intValue() == 101108)
              {
                azpu.a(this.a, 2);
              }
              else if (((Integer)paramObject.first).intValue() == 101111)
              {
                azpu.a(this.a, 3);
              }
              else
              {
                if (((Integer)paramObject.first).intValue() != 12002) {
                  break;
                }
                azpu.a(this.a, 4);
              }
            }
            azpu.a(this.a, 5);
            azpu.a(this.a, (SSummaryCardRsp)paramObject.second);
          }
        }
      }
      return;
    }
    catch (Exception paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpx
 * JD-Core Version:    0.7.0.1
 */