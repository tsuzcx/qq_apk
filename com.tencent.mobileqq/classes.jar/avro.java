import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

class avro
  implements View.OnClickListener
{
  avro(avrn paramavrn) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    arcs localarcs = (arcs)avrn.a(this.a).getItem(i);
    if (localarcs == null) {
      QLog.i("Q.lebatab.LebaListController", 1, "item == null ");
    }
    Map localMap;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localMap = avrn.a(this.a).a();
    } while (avrn.a(this.a) == null);
    avrw localavrw = new avrw();
    localavrw.jdField_a_of_type_Boolean = false;
    localavrw.jdField_a_of_type_Long = localarcs.jdField_a_of_type_Long;
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(Long.valueOf(localarcs.jdField_a_of_type_Long));
    }
    if (localInteger == null) {}
    for (i = 0;; i = localInteger.intValue())
    {
      localavrw.jdField_a_of_type_Int = i;
      if ((paramView instanceof RedTouch)) {
        localavrw.b = avry.a((RedTouch)paramView);
      }
      avrn.a(this.a).a(paramView, localarcs, localavrw);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avro
 * JD-Core Version:    0.7.0.1
 */