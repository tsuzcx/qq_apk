import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class aymx
  extends anmu
{
  aymx(aymu paramaymu) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (aymu.a(this.a) == null) || (aymu.a(this.a).isFinishing()) || (aymu.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      return;
      aynn localaynn = aymu.a(this.a, paramString);
      if (localaynn != null) {
        localaynn.a(aoch.a(aymu.a(this.a), 1, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (aymu.a(this.a) == null) || (aymu.a(this.a).isFinishing()) || (aymu.a(this.a) == null))
    {
      QLog.d("AccountPanel", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    aynn localaynn = aymu.a(this.a, paramString);
    Object localObject;
    if (localaynn != null)
    {
      if (localaynn.jdField_a_of_type_Int != 2) {
        break label147;
      }
      localObject = bglf.b(aymu.a(this.a), paramString, false);
    }
    for (;;)
    {
      localaynn.a((CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountPanel", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
      label147:
      localObject = (SimpleAccount)localaynn.jdField_a_of_type_AndroidViewView.getTag(2131361895);
      if (localObject != null) {
        localObject = bddy.a(aymu.a(this.a), (SimpleAccount)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymx
 * JD-Core Version:    0.7.0.1
 */