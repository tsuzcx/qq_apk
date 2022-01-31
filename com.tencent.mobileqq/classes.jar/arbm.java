import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class arbm
  implements View.OnClickListener
{
  arbm(String paramString, ardn paramardn) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new arbn(this);
      armf localarmf = armf.a(this.jdField_a_of_type_JavaLangString);
      if (localarmf == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
      else if (localarmf.a(false))
      {
        if (!bdee.e(BaseApplicationImpl.getContext()))
        {
          armz.a(2131693415);
          return;
        }
        if (bevd.a(this.jdField_a_of_type_Ardn.getActivity(), 5, new arbo(this, paramView))) {
          armv.a(this.jdField_a_of_type_Ardn.getActivity(), 2131692752, 2131692755, paramView);
        }
      }
      else
      {
        paramView.a();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbm
 * JD-Core Version:    0.7.0.1
 */