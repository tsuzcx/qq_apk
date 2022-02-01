import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class aozk
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<BaseActivity> jdField_a_of_type_MqqUtilWeakReference;
  
  public aozk(String paramString, WeakReference<BaseActivity> paramWeakReference, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "ExpendClickableSpan param error: mActivity == null");
      return;
    }
    paramView = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramView == null)
    {
      QLog.e("FrozenNotifyDlgHelper", 1, "ExpendClickableSpan param error: context == null");
      return;
    }
    int j = 0;
    int i = j;
    if ("https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027".equals(this.jdField_a_of_type_JavaLangString)) {
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains("accounts.qq.com")) && (this.jdField_a_of_type_Int == 1)) {
        bdla.a(null, "dc00898", "", "", "0X800B428", "0X800B428", 0, 0, "", "", "", "");
      }
      Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      paramView.startActivity(localIntent);
      if ((i == 0) || (!(paramView instanceof NotificationActivity)) || (paramView.isFinishing())) {
        break;
      }
      ((NotificationActivity)paramView).a();
      return;
      bdla.a(null, "dc00898", "", "", "0X800B429", "0X800B429", 0, 0, "", "", "", "");
      i = 1;
      continue;
      bdla.a(null, "dc00898", "", "", "0X800B42E", "0X800B42E", 0, 0, "", "", "", "");
      i = j;
      continue;
      bdla.a(null, "dc00898", "", "", "0X800B434", "0X800B434", 0, 0, "", "", "", "");
      i = j;
    }
    paramView.finish();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aozk
 * JD-Core Version:    0.7.0.1
 */