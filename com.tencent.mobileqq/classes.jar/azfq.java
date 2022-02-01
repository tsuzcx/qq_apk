import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class azfq
  extends anyu
{
  azfq(azfn paramazfn) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (azfn.a(this.a) == null) || (azfn.a(this.a).isFinishing()) || (azfn.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      return;
      azgg localazgg = azfn.a(this.a, paramString);
      if (localazgg != null) {
        localazgg.a(aoot.a(azfn.a(this.a), 1, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (azfn.a(this.a) == null) || (azfn.a(this.a).isFinishing()) || (azfn.a(this.a) == null))
    {
      QLog.d("AccountPanel", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    azgg localazgg = azfn.a(this.a, paramString);
    Object localObject;
    if (localazgg != null)
    {
      if (localazgg.jdField_a_of_type_Int != 2) {
        break label147;
      }
      localObject = bhlg.b(azfn.a(this.a), paramString, false);
    }
    for (;;)
    {
      localazgg.a((CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountPanel", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
      label147:
      localObject = (SimpleAccount)localazgg.jdField_a_of_type_AndroidViewView.getTag(2131361895);
      if (localObject != null) {
        localObject = bdwt.a(azfn.a(this.a), (SimpleAccount)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfq
 * JD-Core Version:    0.7.0.1
 */