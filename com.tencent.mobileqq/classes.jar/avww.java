import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x87a.RspBody;

final class avww
  extends ayxn
{
  avww(Activity paramActivity, String paramString, Runnable paramRunnable) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("FaceLoginHelper", 1, new Object[] { "cmd : ", paramString1, " code : ", Integer.valueOf(paramInt), " message : ", paramString2 });
    if (paramInt == 89) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131698101), 0).a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      return;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramString2, 0).a();
    }
  }
  
  public void a(oidb_0x87a.RspBody paramRspBody)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, AuthDevVerifyCodeActivity.class);
    localIntent.putExtra("k_from", "f_SetFaceData");
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (paramRspBody = "";; paramRspBody = this.jdField_a_of_type_JavaLangString)
    {
      localIntent.putExtra("phone_num", paramRspBody);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 11);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avww
 * JD-Core Version:    0.7.0.1
 */