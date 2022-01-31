import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class auhn
  extends ajxj
{
  auhn(auhk paramauhk) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (auhk.a(this.a) == null) || (auhk.a(this.a).isFinishing()) || (auhk.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      return;
      auia localauia = auhk.a(this.a, paramString);
      if (localauia != null) {
        localauia.a(bayh.a(auhk.a(this.a), 1, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (auhk.a(this.a) == null) || (auhk.a(this.a).isFinishing()) || (auhk.a(this.a) == null))
    {
      QLog.d("AccountPanel", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    auia localauia = auhk.a(this.a, paramString);
    Object localObject;
    if (localauia != null)
    {
      if (localauia.jdField_a_of_type_Int != 2) {
        break label147;
      }
      localObject = bbcz.b(auhk.a(this.a), paramString, false);
    }
    for (;;)
    {
      localauia.a((CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountPanel", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
      label147:
      localObject = (SimpleAccount)localauia.jdField_a_of_type_AndroidViewView.getTag(2131361860);
      if (localObject != null) {
        localObject = ayaq.a(auhk.a(this.a), (SimpleAccount)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auhn
 * JD-Core Version:    0.7.0.1
 */