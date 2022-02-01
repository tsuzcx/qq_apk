import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class ayzj
  extends anvi
{
  ayzj(ayzg paramayzg) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (ayzg.a(this.a) == null) || (ayzg.a(this.a).isFinishing()) || (ayzg.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      return;
      ayzz localayzz = ayzg.a(this.a, paramString);
      if (localayzz != null) {
        localayzz.a(FaceDrawable.getFaceDrawable(ayzg.a(this.a), 1, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (ayzg.a(this.a) == null) || (ayzg.a(this.a).isFinishing()) || (ayzg.a(this.a) == null))
    {
      QLog.d("AccountPanel", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    ayzz localayzz = ayzg.a(this.a, paramString);
    Object localObject;
    if (localayzz != null)
    {
      if (localayzz.jdField_a_of_type_Int != 2) {
        break label147;
      }
      localObject = ContactUtils.getBuddyName(ayzg.a(this.a), paramString, false);
    }
    for (;;)
    {
      localayzz.a((CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountPanel", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
      label147:
      localObject = (SimpleAccount)localayzz.jdField_a_of_type_AndroidViewView.getTag(2131361897);
      if (localObject != null) {
        localObject = bdxj.a(ayzg.a(this.a), (SimpleAccount)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzj
 * JD-Core Version:    0.7.0.1
 */