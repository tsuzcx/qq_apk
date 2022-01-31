import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class atgr
  implements View.OnClickListener
{
  atgr(atgq paramatgq) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    aovj localaovj = (aovj)atgq.a(this.a).getItem(i);
    if (localaovj == null) {
      QLog.i("Q.lebatab.LebaListController", 1, "item == null ");
    }
    Map localMap;
    do
    {
      return;
      localMap = atgq.a(this.a).a();
    } while (atgq.a(this.a) == null);
    atgz localatgz = new atgz();
    localatgz.jdField_a_of_type_Boolean = false;
    localatgz.jdField_a_of_type_Long = localaovj.jdField_a_of_type_Long;
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(Long.valueOf(localaovj.jdField_a_of_type_Long));
    }
    if (localInteger == null) {}
    for (i = 0;; i = localInteger.intValue())
    {
      localatgz.jdField_a_of_type_Int = i;
      if ((paramView instanceof RedTouch)) {
        localatgz.b = athb.a((RedTouch)paramView);
      }
      atgq.a(this.a).a(paramView, localaovj, localatgz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgr
 * JD-Core Version:    0.7.0.1
 */