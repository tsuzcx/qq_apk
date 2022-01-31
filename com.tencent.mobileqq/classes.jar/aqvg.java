import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.bigbrother.JumpConfirmFragment;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.haoliyou.JefsClass.CancelableRunnable;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class aqvg
  implements amal
{
  public aqvg(JefsClass paramJefsClass, WeakReference paramWeakReference, JefsClass.CancelableRunnable paramCancelableRunnable, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, String.format(Locale.CHINA, "onReceive: success: %b, jump: %d, err_code: %d, err_msg: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$CancelableRunnable == null) {
      return;
    }
    if (localObject == null)
    {
      amav.a().a(this.jdField_a_of_type_Int, -3);
      QLog.i("TeleScreen|JefsClass", 1, "context is null");
      if (this.jdField_a_of_type_JavaLangString == null) {}
      for (paramString = "";; paramString = this.jdField_a_of_type_JavaLangString)
      {
        axqw.b(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "", "1", paramString, "");
        return;
      }
    }
    if ((paramBoolean) && (paramInt1 == 1))
    {
      JefsClass.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass, this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$CancelableRunnable);
      return;
    }
    if ((!paramBoolean) || (paramInt1 == 0)) {}
    for (;;)
    {
      try
      {
        if (!(localObject instanceof Activity)) {
          break label491;
        }
        paramString = (Activity)localObject;
        if ((paramString == null) || (paramString.isFinishing())) {
          break label317;
        }
        QLog.i("TeleScreen|JefsClass", 1, "leave QQ jump other app , act.isFinishing() == false");
        localObject = bbcv.a(paramString, 0, null, "即将离开QQ\n打开其他应用", paramString.getString(2131690596), paramString.getString(2131720885), new aqvh(this), new aqvi(this));
        if ((paramString instanceof BaseActivity))
        {
          ((BaseActivity)paramString).setJumpDialog((Dialog)localObject);
          ((bbgg)localObject).show();
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("TeleScreen|JefsClass", 1, paramString, new Object[0]);
        JefsClass.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass, this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$CancelableRunnable);
        return;
      }
      if ((paramString instanceof BasePluginActivity))
      {
        ((BasePluginActivity)paramString).setJumpDialog((Dialog)localObject);
        continue;
        label317:
        if (BaseApplicationImpl.sProcessId != 1)
        {
          if (JefsClass.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass) == null) {
            JefsClass.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass, new aqvp(this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass, null));
          }
          paramString = new IntentFilter("com.tencent.mobileqq.telescreen.action_run");
          paramString.addAction("com.tencent.mobileqq.telescreen.action_remove");
          BaseApplicationImpl.context.registerReceiver(JefsClass.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass), paramString);
        }
        paramString = new Intent();
        paramString.putExtra("big_brother_source_key", this.jdField_a_of_type_JavaLangString);
        paramString.putExtra("key_id", JefsClass.a(this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass, this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$CancelableRunnable));
        paramString.putExtra("key_process_id", BaseApplicationImpl.processName);
        paramString.putExtra("key_callback_id", this.jdField_a_of_type_Int);
        paramString.putExtra("public_fragment_window_feature", 1);
        abtu.a(paramString, PublicTransFragmentActivity.class, JumpConfirmFragment.class);
        QLog.i("TeleScreen|JefsClass", 1, "leave QQ jump other app , act == null && act.isFinishing() == true");
        return;
        amav.a().a(this.jdField_a_of_type_Int, -2);
        return;
        label491:
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqvg
 * JD-Core Version:    0.7.0.1
 */