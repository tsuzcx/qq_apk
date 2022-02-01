import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class auct
  implements View.OnClickListener
{
  auct(String paramString, auef paramauef) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localaucu = new aucu(this);
        localaumg = aumg.a(this.jdField_a_of_type_JavaLangString);
        if (localaumg != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
      catch (Exception localException)
      {
        aucu localaucu;
        aumg localaumg;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localaumg.a(false))
      {
        if (!bhnv.e(BaseApplicationImpl.getContext())) {
          auna.a(2131692905);
        } else if (bjhk.a(this.jdField_a_of_type_Auef.getActivity(), 5, new aucv(this, localaucu))) {
          aumw.a(this.jdField_a_of_type_Auef.getActivity(), 2131692326, 2131692329, localaucu);
        }
      }
      else {
        localaucu.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auct
 * JD-Core Version:    0.7.0.1
 */