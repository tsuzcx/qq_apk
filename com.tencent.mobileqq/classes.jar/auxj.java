import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

class auxj
  implements View.OnClickListener
{
  auxj(auxi paramauxi) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    aqmf localaqmf = (aqmf)auxi.a(this.a).getItem(i);
    if (localaqmf == null) {
      QLog.i("Q.lebatab.LebaListController", 1, "item == null ");
    }
    Map localMap;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localMap = auxi.a(this.a).a();
    } while (auxi.a(this.a) == null);
    auxr localauxr = new auxr();
    localauxr.jdField_a_of_type_Boolean = false;
    localauxr.jdField_a_of_type_Long = localaqmf.jdField_a_of_type_Long;
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(Long.valueOf(localaqmf.jdField_a_of_type_Long));
    }
    if (localInteger == null) {}
    for (i = 0;; i = localInteger.intValue())
    {
      localauxr.jdField_a_of_type_Int = i;
      if ((paramView instanceof RedTouch)) {
        localauxr.b = auxt.a((RedTouch)paramView);
      }
      auxi.a(this.a).a(paramView, localaqmf, localauxr);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxj
 * JD-Core Version:    0.7.0.1
 */