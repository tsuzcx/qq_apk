import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aspd
  implements View.OnClickListener
{
  aspd(String paramString, asqp paramasqp) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localaspe = new aspe(this);
        localasyq = asyq.a(this.jdField_a_of_type_JavaLangString);
        if (localasyq != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
      catch (Exception localException)
      {
        aspe localaspe;
        asyq localasyq;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localasyq.a(false))
      {
        if (!NetworkUtil.isNetSupportHw(BaseApplicationImpl.getContext())) {
          aszk.a(2131692955);
        } else if (bhnb.a(this.jdField_a_of_type_Asqp.getActivity(), 5, new aspf(this, localaspe))) {
          aszg.a(this.jdField_a_of_type_Asqp.getActivity(), 2131692374, 2131692377, localaspe);
        }
      }
      else {
        localaspe.onYes();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspd
 * JD-Core Version:    0.7.0.1
 */