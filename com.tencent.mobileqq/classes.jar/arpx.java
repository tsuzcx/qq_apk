import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class arpx
  implements View.OnClickListener
{
  arpx(arpw paramarpw) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    anec localanec = (anec)arpw.a(this.a).getItem(i);
    if (localanec == null) {
      QLog.i("Q.lebatab.LebaListController", 1, "item == null ");
    }
    Map localMap;
    do
    {
      return;
      localMap = arpw.a(this.a).a();
    } while (arpw.a(this.a) == null);
    arqf localarqf = new arqf();
    localarqf.jdField_a_of_type_Boolean = false;
    localarqf.jdField_a_of_type_Long = localanec.jdField_a_of_type_Long;
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(Long.valueOf(localanec.jdField_a_of_type_Long));
    }
    if (localInteger == null) {}
    for (i = 0;; i = localInteger.intValue())
    {
      localarqf.jdField_a_of_type_Int = i;
      if ((paramView instanceof RedTouch)) {
        localarqf.b = arqg.a((RedTouch)paramView);
      }
      arpw.a(this.a).a(paramView, localanec, localarqf);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arpx
 * JD-Core Version:    0.7.0.1
 */