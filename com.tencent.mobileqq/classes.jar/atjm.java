import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class atjm
  extends ajjh
{
  atjm(atjj paramatjj) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (atjj.a(this.a) == null) || (atjj.a(this.a).isFinishing()) || (atjj.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      return;
      atjz localatjz = atjj.a(this.a, paramString);
      if (localatjz != null) {
        localatjz.a(azwp.a(atjj.a(this.a), 1, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (atjj.a(this.a) == null) || (atjj.a(this.a).isFinishing()) || (atjj.a(this.a) == null))
    {
      QLog.d("AccountPanel", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    atjz localatjz = atjj.a(this.a, paramString);
    Object localObject;
    if (localatjz != null)
    {
      if (localatjz.jdField_a_of_type_Int != 2) {
        break label147;
      }
      localObject = babh.b(atjj.a(this.a), paramString, false);
    }
    for (;;)
    {
      localatjz.a((CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountPanel", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
      label147:
      localObject = (SimpleAccount)localatjz.jdField_a_of_type_AndroidViewView.getTag(2131296325);
      if (localObject != null) {
        localObject = axam.a(atjj.a(this.a), (SimpleAccount)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atjm
 * JD-Core Version:    0.7.0.1
 */