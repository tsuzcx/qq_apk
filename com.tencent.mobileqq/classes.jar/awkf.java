import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

class awkf
  implements View.OnClickListener
{
  awkf(awke paramawke) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    arsh localarsh = (arsh)awke.a(this.a).getItem(i);
    if (localarsh == null) {
      QLog.i("Q.lebatab.LebaListController", 1, "item == null ");
    }
    Map localMap;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localMap = awke.a(this.a).a();
    } while (awke.a(this.a) == null);
    awkn localawkn = new awkn();
    localawkn.jdField_a_of_type_Boolean = false;
    localawkn.jdField_a_of_type_Long = localarsh.jdField_a_of_type_Long;
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(Long.valueOf(localarsh.jdField_a_of_type_Long));
    }
    if (localInteger == null) {}
    for (i = 0;; i = localInteger.intValue())
    {
      localawkn.jdField_a_of_type_Int = i;
      if ((paramView instanceof RedTouch)) {
        localawkn.b = awkp.a((RedTouch)paramView);
      }
      awke.a(this.a).a(paramView, localarsh, localawkn);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkf
 * JD-Core Version:    0.7.0.1
 */