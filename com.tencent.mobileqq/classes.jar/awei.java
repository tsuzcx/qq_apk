import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class awei
  implements View.OnClickListener
{
  WeakReference<aweh> a;
  
  public awei(aweh paramaweh)
  {
    this.a = new WeakReference(paramaweh);
  }
  
  public void onClick(View paramView)
  {
    aweh localaweh = (aweh)this.a.get();
    if (localaweh == null) {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "logic == null");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aweh.a(localaweh) != null)
      {
        arpq localarpq = localaweh.a(paramView);
        if ((localarpq != null) && (localaweh.a != null))
        {
          awdq localawdq = new awdq();
          localawdq.jdField_a_of_type_Boolean = true;
          localawdq.jdField_a_of_type_Long = localarpq.jdField_a_of_type_Long;
          localawdq.jdField_a_of_type_Int = (paramView.getId() + 1);
          if ((paramView instanceof RedTouch))
          {
            localawdq.b = awds.a((RedTouch)paramView);
            localawdq.c = awds.b((RedTouch)paramView);
          }
          localaweh.a.a(paramView, localarpq, localawdq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awei
 * JD-Core Version:    0.7.0.1
 */