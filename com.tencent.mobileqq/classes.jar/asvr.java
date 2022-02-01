import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asvr
  implements View.OnClickListener
{
  public asvr(HorseRaceLampVew.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.this$0.b) {
      QLog.e("HorseRaceLampVew + horserace", 2, "CLICK WITH TOUCH SCROLL THROW IT");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof asvu)) && (HorseRaceLampVew.a(this.a.this$0) != null))
      {
        localObject = (asvu)localObject;
        HorseRaceLampVew.a(this.a.this$0).a(((asvu)localObject).a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvr
 * JD-Core Version:    0.7.0.1
 */