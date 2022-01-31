import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class avyq
  extends alox
{
  avyq(avyo paramavyo) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (avyo.a(this.a) == null) || (avyo.a(this.a).isFinishing()) || (avyo.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      return;
      avzd localavzd = avyo.a(this.a, paramString);
      if (localavzd != null) {
        localavzd.a(bcxb.a(avyo.a(this.a), 1, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (avyo.a(this.a) == null) || (avyo.a(this.a).isFinishing()) || (avyo.a(this.a) == null))
    {
      QLog.d("AccountPanel", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    avzd localavzd = avyo.a(this.a, paramString);
    Object localObject;
    if (localavzd != null)
    {
      if (localavzd.jdField_a_of_type_Int != 2) {
        break label147;
      }
      localObject = bdbt.b(avyo.a(this.a), paramString, false);
    }
    for (;;)
    {
      localavzd.a((CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountPanel", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
      label147:
      localObject = (SimpleAccount)localavzd.jdField_a_of_type_AndroidViewView.getTag(2131361860);
      if (localObject != null) {
        localObject = azyl.a(avyo.a(this.a), (SimpleAccount)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avyq
 * JD-Core Version:    0.7.0.1
 */