import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew;
import com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew.1;
import com.tencent.qphone.base.util.QLog;

public class aols
  implements View.OnClickListener
{
  public aols(HorseRaceLampVew.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.this$0.b) {
      QLog.e("HorseRaceLampVew + horserace", 2, "CLICK WITH TOUCH SCROLL THROW IT");
    }
    do
    {
      return;
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof aolv)) || (HorseRaceLampVew.a(this.a.this$0) == null));
    paramView = (aolv)paramView;
    HorseRaceLampVew.a(this.a.this$0).a(paramView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aols
 * JD-Core Version:    0.7.0.1
 */