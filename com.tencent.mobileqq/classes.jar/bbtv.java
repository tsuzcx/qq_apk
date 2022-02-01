import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureEditFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class bbtv
  implements Observer
{
  public bbtv(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "mSignatureObserver type = " + paramObject);
    }
    if ((paramObject instanceof ArrayList))
    {
      paramObject = (ArrayList)paramObject;
      switch (((Integer)paramObject.get(0)).intValue())
      {
      }
    }
    label395:
    while (SignatureEditFragment.a(this.a) == null)
    {
      return;
      paramObservable = (RichStatus)paramObject.get(1);
      this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramObservable;
      this.a.jdField_b_of_type_Boolean = false;
      if (this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText != null)
      {
        paramObject = bbux.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics);
        }
      }
      if (paramObservable != null)
      {
        this.a.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom(paramObservable);
        bbux.a().a(this.a.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      }
      this.a.jdField_a_of_type_Boolean = false;
      if (SignatureEditFragment.a(this.a) != null) {
        SignatureEditFragment.a(this.a).sendEmptyMessage(257);
      }
      SignatureEditFragment.b(this.a);
      return;
      int i = ((Integer)paramObject.get(1)).intValue();
      paramObservable = (HashMap)paramObject.get(2);
      if ((i == 100) || (i == 0))
      {
        this.a.jdField_a_of_type_Boolean = false;
        SignatureEditFragment.a(this.a, true);
        this.a.jdField_b_of_type_Boolean = false;
        if ((this.a.mApp.getAccount() == null) && (((Integer)paramObject.get(3)).intValue() != 1)) {
          break label395;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = RichStatus.getEmptyStatus();
        bbux.a().b(this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
      }
      for (;;)
      {
        paramObject = new Message();
        paramObject.what = 259;
        paramObject.obj = paramObservable;
        SignatureEditFragment.a(this.a).sendMessage(paramObject);
        return;
        bbux.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
        bbux.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = null;
        SignatureEditFragment.c(this.a);
        this.a.c();
      }
      ((Integer)paramObject.get(1)).intValue();
      return;
      i = ((Integer)paramObject.get(1)).intValue();
      paramObservable = SignatureEditFragment.a(this.a).obtainMessage();
      paramObservable.what = 262;
      paramObservable.arg1 = i;
      SignatureEditFragment.a(this.a).sendMessage(paramObservable);
      return;
    }
    SignatureEditFragment.a(this.a).sendEmptyMessage(257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtv
 * JD-Core Version:    0.7.0.1
 */