import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

class awdi
  implements View.OnClickListener
{
  awdi(awdh paramawdh) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    arpq localarpq = (arpq)awdh.a(this.a).getItem(i);
    if (localarpq == null) {
      QLog.i("Q.lebatab.LebaListController", 1, "item == null ");
    }
    Map localMap;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localMap = awdh.a(this.a).a();
    } while (awdh.a(this.a) == null);
    awdq localawdq = new awdq();
    localawdq.jdField_a_of_type_Boolean = false;
    localawdq.jdField_a_of_type_Long = localarpq.jdField_a_of_type_Long;
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(Long.valueOf(localarpq.jdField_a_of_type_Long));
    }
    if (localInteger == null) {}
    for (i = 0;; i = localInteger.intValue())
    {
      localawdq.jdField_a_of_type_Int = i;
      if ((paramView instanceof RedTouch)) {
        localawdq.b = awds.a((RedTouch)paramView);
      }
      awdh.a(this.a).a(paramView, localarpq, localawdq);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdi
 * JD-Core Version:    0.7.0.1
 */