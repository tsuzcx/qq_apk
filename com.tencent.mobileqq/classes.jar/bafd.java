import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class bafd
  implements Handler.Callback
{
  public bafd(AbsProfileHeaderView paramAbsProfileHeaderView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AbsProfileHeaderView.jdField_a_of_type_JavaLangString, 2, String.format("handleMessage msg.what=%s", new Object[] { Integer.valueOf(paramMessage.what) }));
    }
    if (1000 == paramMessage.what) {
      if (AbsProfileHeaderView.a(this.a).get()) {
        this.a.h(this.a.jdField_a_of_type_Azxr);
      }
    }
    do
    {
      do
      {
        return true;
      } while (1003 != paramMessage.what);
      localObject = (View)this.a.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    } while (!(localObject instanceof ImageView));
    Object localObject = (ImageView)localObject;
    paramMessage = (ExtensionInfo)paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.isPendantValid()))
    {
      this.a.jdField_a_of_type_Long = paramMessage.pendantId;
      ((ImageView)localObject).setVisibility(0);
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      if (bhkt.a(this.a.jdField_a_of_type_Long))
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
 * Qualified Name:     bafd
 * JD-Core Version:    0.7.0.1
 */