import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew.1;
import com.tencent.qphone.base.util.QLog;

public class aqiz
  implements View.OnClickListener
{
  public aqiz(HorseRaceLampVew.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.this$0.b) {
      QLog.e("HorseRaceLampVew + horserace", 2, "CLICK WITH TOUCH SCROLL THROW IT");
    }
    do
    {
      return;
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof aqjc)) || (HorseRaceLampVew.a(this.a.this$0) == null));
    paramView = (aqjc)paramView;
    HorseRaceLampVew.a(this.a.this$0).a(paramView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqiz
 * JD-Core Version:    0.7.0.1
 */