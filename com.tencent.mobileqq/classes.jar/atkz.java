import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class atkz
  implements View.OnClickListener
{
  atkz(String paramString, atmk paramatmk) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localatla = new atla(this);
        localatul = atul.a(this.jdField_a_of_type_JavaLangString);
        if (localatul != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
      catch (Exception localException)
      {
        atla localatla;
        atul localatul;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localatul.a(false))
      {
        if (!bgnt.e(BaseApplicationImpl.getContext())) {
          atvf.a(2131692897);
        } else if (bigl.a(this.jdField_a_of_type_Atmk.getActivity(), 5, new atlb(this, localatla))) {
          atvb.a(this.jdField_a_of_type_Atmk.getActivity(), 2131692321, 2131692324, localatla);
        }
      }
      else {
        localatla.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkz
 * JD-Core Version:    0.7.0.1
 */