import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class awcz
  extends altm
{
  awcz(awcx paramawcx) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (awcx.a(this.a) == null) || (awcx.a(this.a).isFinishing()) || (awcx.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      return;
      awdm localawdm = awcx.a(this.a, paramString);
      if (localawdm != null) {
        localawdm.a(bdbk.a(awcx.a(this.a), 1, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (awcx.a(this.a) == null) || (awcx.a(this.a).isFinishing()) || (awcx.a(this.a) == null))
    {
      QLog.d("AccountPanel", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    awdm localawdm = awcx.a(this.a, paramString);
    Object localObject;
    if (localawdm != null)
    {
      if (localawdm.jdField_a_of_type_Int != 2) {
        break label147;
      }
      localObject = bdgc.b(awcx.a(this.a), paramString, false);
    }
    for (;;)
    {
      localawdm.a((CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountPanel", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
      label147:
      localObject = (SimpleAccount)localawdm.jdField_a_of_type_AndroidViewView.getTag(2131361860);
      if (localObject != null) {
        localObject = bacu.a(awcx.a(this.a), (SimpleAccount)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awcz
 * JD-Core Version:    0.7.0.1
 */