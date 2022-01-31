import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class arfv
  implements View.OnClickListener
{
  arfv(String paramString, arhw paramarhw) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new arfw(this);
      arqo localarqo = arqo.a(this.jdField_a_of_type_JavaLangString);
      if (localarqo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
      else if (localarqo.a(false))
      {
        if (!bdin.e(BaseApplicationImpl.getContext()))
        {
          arri.a(2131693417);
          return;
        }
        if (bezm.a(this.jdField_a_of_type_Arhw.getActivity(), 5, new arfx(this, paramView))) {
          arre.a(this.jdField_a_of_type_Arhw.getActivity(), 2131692754, 2131692757, paramView);
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
 * Qualified Name:     arfv
 * JD-Core Version:    0.7.0.1
 */