import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class axsy
  extends amsu
{
  axsy(axsv paramaxsv) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (axsv.a(this.a) == null) || (axsv.a(this.a).isFinishing()) || (axsv.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      return;
      axto localaxto = axsv.a(this.a, paramString);
      if (localaxto != null) {
        localaxto.a(FaceDrawable.getFaceDrawable(axsv.a(this.a), 1, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (axsv.a(this.a) == null) || (axsv.a(this.a).isFinishing()) || (axsv.a(this.a) == null))
    {
      QLog.d("AccountPanel", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    axto localaxto = axsv.a(this.a, paramString);
    Object localObject;
    if (localaxto != null)
    {
      if (localaxto.jdField_a_of_type_Int != 2) {
        break label147;
      }
      localObject = ContactUtils.getBuddyName(axsv.a(this.a), paramString, false);
    }
    for (;;)
    {
      localaxto.a((CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountPanel", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
      label147:
      localObject = (SimpleAccount)localaxto.jdField_a_of_type_AndroidViewView.getTag(2131361895);
      if (localObject != null) {
        localObject = bcqk.a(axsv.a(this.a), (SimpleAccount)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsy
 * JD-Core Version:    0.7.0.1
 */