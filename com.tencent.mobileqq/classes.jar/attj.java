import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class attj
  implements View.OnClickListener
{
  attj(String paramString, atuw paramatuw) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localattk = new attk(this);
        localaucx = aucx.a(this.jdField_a_of_type_JavaLangString);
        if (localaucx != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
      catch (Exception localException)
      {
        attk localattk;
        aucx localaucx;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localaucx.a(false))
      {
        if (!NetworkUtil.isNetSupportHw(BaseApplicationImpl.getContext())) {
          audr.a(2131693091);
        } else if (bixr.a(this.jdField_a_of_type_Atuw.getActivity(), 5, new attl(this, localattk))) {
          audn.a(this.jdField_a_of_type_Atuw.getActivity(), 2131692476, 2131692479, localattk);
        }
      }
      else {
        localattk.onYes();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attj
 * JD-Core Version:    0.7.0.1
 */