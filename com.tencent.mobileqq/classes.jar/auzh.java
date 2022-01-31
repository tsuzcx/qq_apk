import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class auzh
  implements Handler.Callback
{
  public auzh(ProfileHeaderView paramProfileHeaderView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(ProfileHeaderView.jdField_a_of_type_JavaLangString, 4, String.format(Locale.getDefault(), "mUICallback [%d]", new Object[] { Integer.valueOf(paramMessage.what) }));
    }
    if (ProfileHeaderView.jdField_b_of_type_Int == paramMessage.what)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ProfileHeaderView.jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView handleMessage msg what is check tips time=" + this.a.jdField_a_of_type_Int);
      }
      if ((this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        this.a.k(this.a.jdField_a_of_type_Auuy);
      }
    }
    do
    {
      do
      {
        return true;
      } while (ProfileHeaderView.c != paramMessage.what);
      localObject = (View)this.a.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    } while (!(localObject instanceof ImageView));
    Object localObject = (ImageView)localObject;
    paramMessage = (ExtensionInfo)paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.isPendantValid()))
    {
      this.a.jdField_a_of_type_Long = paramMessage.pendantId;
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      ((ImageView)localObject).setVisibility(0);
      if (bbcm.a(this.a.jdField_a_of_type_Long))
      {
        localAvatarPendantManager.a(this.a.jdField_a_of_type_Long).a((View)localObject, 2, PendantInfo.c, paramMessage.uin, paramMessage.pendantDiyId);
        return true;
      }
      localAvatarPendantManager.a(this.a.jdField_a_of_type_Long).a((View)localObject, 1, PendantInfo.c, paramMessage.uin, paramMessage.pendantDiyId);
      return true;
    }
    ((ImageView)localObject).setVisibility(4);
    this.a.jdField_a_of_type_Long = 0L;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzh
 * JD-Core Version:    0.7.0.1
 */