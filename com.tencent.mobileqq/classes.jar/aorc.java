import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class aorc
  implements View.OnClickListener
{
  aorc(String paramString, aotc paramaotc) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new aord(this);
      apbf localapbf = apbf.a(this.jdField_a_of_type_JavaLangString);
      if (localapbf == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
      else if (localapbf.a(false))
      {
        if (!badq.e(BaseApplicationImpl.getContext()))
        {
          apcb.a(2131627672);
          return;
        }
        if (bbrm.a(this.jdField_a_of_type_Aotc.getActivity(), 5, new aore(this, paramView))) {
          apbx.a(this.jdField_a_of_type_Aotc.getActivity(), 2131627035, 2131627038, paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aorc
 * JD-Core Version:    0.7.0.1
 */