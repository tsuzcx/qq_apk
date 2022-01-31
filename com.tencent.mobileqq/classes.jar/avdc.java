import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.richstatus.SignTextEditFragment.7.1;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class avdc
  implements avcn
{
  public avdc(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onChangeStatus reslut=%d status=%s", new Object[] { Integer.valueOf(paramInt), paramRichStatus }));
    }
    if ((paramRichStatus == null) || (paramRichStatus == RichStatus.getEmptyStatus())) {
      if (paramInt == 100) {
        bbmy.a(BaseApplication.context, 2, ajjy.a(2131648358), 0).a();
      }
    }
    for (int i = 0;; i = 1)
    {
      if ((paramObject instanceof TipsInfo))
      {
        paramRichStatus = (TipsInfo)paramObject;
        SignTextEditFragment.b(this.a, paramRichStatus.errorDesc);
        if (TextUtils.isEmpty(SignTextEditFragment.a(this.a))) {
          SignTextEditFragment.b(this.a, paramRichStatus.wording);
        }
      }
      if (paramInt == 100)
      {
        SignTextEditFragment.a(this.a, false);
        this.a.jdField_a_of_type_Boolean = true;
        this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
        this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom(SignTextEditFragment.a(this.a).a(true));
        paramObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        paramRichStatus = paramObject;
        if (paramObject == null) {
          paramRichStatus = "noLogin";
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(paramRichStatus, 4).edit().putString("sign_location_id_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), SignTextEditFragment.b(this.a)).commit();
        if (this.a.isAdded()) {
          SignTextEditFragment.a(this.a, false);
        }
        paramRichStatus = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        paramRichStatus.edit().putBoolean(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "edit_signature_version_826", true);
        j = i;
        if (3 == this.a.jdField_a_of_type_Int)
        {
          avep.a().addObserver(this.a.jdField_a_of_type_JavaUtilObserver);
          paramObject = avep.a().a(this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
          if ((Integer.parseInt(paramObject.jdField_a_of_type_JavaLangString) != this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId) && (paramObject.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
          {
            SignTextEditFragment.a(this.a).set(true);
            this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new SignTextEditFragment.7.1(this), 1500L);
          }
        }
      }
      while (i == 0)
      {
        return;
        bbmy.a(BaseApplication.context, 1, ajjy.a(2131648350), 0).a();
        break;
        int j = i;
        if (Integer.parseInt(paramObject.jdField_a_of_type_JavaLangString) > 0)
        {
          j = i;
          if (paramObject.f < 2)
          {
            j = i;
            if (paramRichStatus.getBoolean(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "new_signature_version_826", true))
            {
              bajo.a(this.a.getActivity(), this.a.getActivity().app, 0, "signature_chouti");
              j = 0;
            }
          }
        }
        if (j != 0) {
          this.a.a(paramInt, SignTextEditFragment.a(this.a));
        }
        this.a.onBackEvent();
        return;
      }
      this.a.a(paramInt, SignTextEditFragment.a(this.a));
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avdc
 * JD-Core Version:    0.7.0.1
 */