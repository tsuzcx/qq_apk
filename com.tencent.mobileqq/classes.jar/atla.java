import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class atla
  implements View.OnClickListener
{
  atla(atkz paramatkz) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    aozs localaozs = (aozs)atkz.a(this.a).getItem(i);
    if (localaozs == null) {
      QLog.i("Q.lebatab.LebaListController", 1, "item == null ");
    }
    Map localMap;
    do
    {
      return;
      localMap = atkz.a(this.a).a();
    } while (atkz.a(this.a) == null);
    atli localatli = new atli();
    localatli.jdField_a_of_type_Boolean = false;
    localatli.jdField_a_of_type_Long = localaozs.jdField_a_of_type_Long;
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(Long.valueOf(localaozs.jdField_a_of_type_Long));
    }
    if (localInteger == null) {}
    for (i = 0;; i = localInteger.intValue())
    {
      localatli.jdField_a_of_type_Int = i;
      if ((paramView instanceof RedTouch)) {
        localatli.b = atlk.a((RedTouch)paramView);
      }
      atkz.a(this.a).a(paramView, localaozs, localatli);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atla
 * JD-Core Version:    0.7.0.1
 */