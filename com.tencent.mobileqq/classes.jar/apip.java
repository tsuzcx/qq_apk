import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class apip
  implements View.OnClickListener
{
  apip(String paramString, apkq paramapkq) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new apiq(this);
      aptd localaptd = aptd.a(this.jdField_a_of_type_JavaLangString);
      if (localaptd == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
      else if (localaptd.a(false))
      {
        if (!bbfj.e(BaseApplicationImpl.getContext()))
        {
          aptx.a(2131693314);
          return;
        }
        if (bcwb.a(this.jdField_a_of_type_Apkq.getActivity(), 5, new apir(this, paramView))) {
          aptt.a(this.jdField_a_of_type_Apkq.getActivity(), 2131692673, 2131692676, paramView);
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
 * Qualified Name:     apip
 * JD-Core Version:    0.7.0.1
 */