import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class arpv
  implements View.OnClickListener
{
  arpv(arpu paramarpu) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    andx localandx = (andx)arpu.a(this.a).getItem(i);
    if (localandx == null) {
      QLog.i("Q.lebatab.LebaListController", 1, "item == null ");
    }
    Map localMap;
    do
    {
      return;
      localMap = arpu.a(this.a).a();
    } while (arpu.a(this.a) == null);
    arqd localarqd = new arqd();
    localarqd.jdField_a_of_type_Boolean = false;
    localarqd.jdField_a_of_type_Long = localandx.jdField_a_of_type_Long;
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(Long.valueOf(localandx.jdField_a_of_type_Long));
    }
    if (localInteger == null) {}
    for (i = 0;; i = localInteger.intValue())
    {
      localarqd.jdField_a_of_type_Int = i;
      if ((paramView instanceof RedTouch)) {
        localarqd.b = arqe.a((RedTouch)paramView);
      }
      arpu.a(this.a).a(paramView, localandx, localarqd);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arpv
 * JD-Core Version:    0.7.0.1
 */