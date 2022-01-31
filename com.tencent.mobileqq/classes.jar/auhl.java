import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class auhl
  extends ajxl
{
  auhl(auhi paramauhi) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (auhi.a(this.a) == null) || (auhi.a(this.a).isFinishing()) || (auhi.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      return;
      auhy localauhy = auhi.a(this.a, paramString);
      if (localauhy != null) {
        localauhy.a(baxt.a(auhi.a(this.a), 1, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (auhi.a(this.a) == null) || (auhi.a(this.a).isFinishing()) || (auhi.a(this.a) == null))
    {
      QLog.d("AccountPanel", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    auhy localauhy = auhi.a(this.a, paramString);
    Object localObject;
    if (localauhy != null)
    {
      if (localauhy.jdField_a_of_type_Int != 2) {
        break label147;
      }
      localObject = bbcl.b(auhi.a(this.a), paramString, false);
    }
    for (;;)
    {
      localauhy.a((CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountPanel", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
      label147:
      localObject = (SimpleAccount)localauhy.jdField_a_of_type_AndroidViewView.getTag(2131361861);
      if (localObject != null) {
        localObject = ayao.a(auhi.a(this.a), (SimpleAccount)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auhl
 * JD-Core Version:    0.7.0.1
 */