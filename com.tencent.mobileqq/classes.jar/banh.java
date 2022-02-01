import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

public class banh
  implements Observer
{
  public banh(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!SignTextEditFragment.a(this.a).get()) {}
    do
    {
      return;
      SignTextEditFragment.a(this.a).set(false);
    } while (!(paramObject instanceof Integer));
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 3: 
      paramObservable = baos.a().a(this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      if ((paramObservable != null) && (!TextUtils.isEmpty(paramObservable.a)) && (Integer.parseInt(paramObservable.a) > 0) && (paramObservable.f < 2)) {
        if (BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "new_signature_version_826", true)) {
          bgae.a(this.a.getActivity(), this.a.getActivity().app, 0, "signature_chouti");
        }
      }
      for (;;)
      {
        baos.a().deleteObserver(this.a.jdField_a_of_type_JavaUtilObserver);
        return;
        this.a.a(100, SignTextEditFragment.a(this.a));
      }
    }
    if (BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "new_signature_version_826", true)) {
      bgae.a(this.a.getActivity(), this.a.getActivity().app, 0, "signature_chouti");
    }
    for (;;)
    {
      baos.a().deleteObserver(this.a.jdField_a_of_type_JavaUtilObserver);
      return;
      this.a.a(100, SignTextEditFragment.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banh
 * JD-Core Version:    0.7.0.1
 */