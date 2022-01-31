import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class apil
  implements View.OnClickListener
{
  apil(String paramString, apkm paramapkm) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new apim(this);
      apsz localapsz = apsz.a(this.jdField_a_of_type_JavaLangString);
      if (localapsz == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
      else if (localapsz.a(false))
      {
        if (!bbev.e(BaseApplicationImpl.getContext()))
        {
          aptv.a(2131693313);
          return;
        }
        if (bcvm.a(this.jdField_a_of_type_Apkm.getActivity(), 5, new apin(this, paramView))) {
          aptr.a(this.jdField_a_of_type_Apkm.getActivity(), 2131692672, 2131692675, paramView);
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
 * Qualified Name:     apil
 * JD-Core Version:    0.7.0.1
 */