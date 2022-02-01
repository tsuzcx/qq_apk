import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.profilecard.EditExtendFriendInfo.SchoolInfo;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SchoolInfo;

public class asiw
  extends asgf
{
  public asiw(ExtendFriendFragment paramExtendFriendFragment) {}
  
  protected void a(int paramInt)
  {
    awie.a(ExtendFriendFragment.a(this.a), ExtendFriendFragment.a(this.a).app);
    Intent localIntent = new Intent("match_chat_notify_update");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    int i = ExtendFriendFragment.a(this.a).e();
    String str1 = ExtendFriendFragment.a(this.a).f();
    ExtendFriendFragment.a(this.a).g();
    int j = ExtendFriendFragment.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateCampusCertificateStatus,isSuccess + " + paramBoolean + ",birthday + " + j + ",scene + " + paramInt + ",verifyStatus + " + i + ",serverSuggestSchoolName + " + str1);
    }
    if ((paramBoolean) && (paramInt == 1))
    {
      ExtendFriendFragment.a(this.a, j);
      Object localObject = ExtendFriendFragment.a(this.a).a();
      String str2 = ExtendFriendFragment.a(this.a).g();
      if ((!TextUtils.isEmpty(str2)) && (localObject != null) && (!ExtendFriendFragment.a(this.a).isFinishing()))
      {
        if (!((oidb_0xdb1.SchoolInfo)localObject).str_school_name.has()) {
          break label285;
        }
        str1 = ((oidb_0xdb1.SchoolInfo)localObject).str_school_name.get();
        asfs localasfs = (asfs)ExtendFriendFragment.a(this.a).a(127);
        localObject = asme.a((oidb_0xdb1.SchoolInfo)localObject);
        asme.a(ExtendFriendFragment.a(this.a), localasfs, str1, (EditExtendFriendInfo.SchoolInfo)localObject);
      }
      if (TextUtils.isEmpty(str2)) {
        break label292;
      }
      paramInt = 1;
      label254:
      if (paramInt == 0) {
        break label297;
      }
    }
    label285:
    label292:
    label297:
    for (paramInt = 1;; paramInt = 2)
    {
      bcst.b(null, "dc00898", "", "", "0X800ADD7", "0X800ADD7", paramInt, 0, "", "", "", "");
      return;
      str1 = "";
      break;
      paramInt = 0;
      break label254;
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateExtendFriendCampusSchoolInfo isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      QQToast.a(ExtendFriendFragment.a(this.a), 2, 2131697892, 0).b(ExtendFriendFragment.a(this.a).getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
    if ((ExtendFriendFragment.a(this.a) != null) && (ExtendFriendFragment.a(this.a).isResume()) && (((askk)ExtendFriendFragment.a(this.a).app.getManager(292)).a() != 2) && (!ExtendFriendFragment.a(this.a))) {
      ExtendFriendFragment.a(this.a, aslj.a(ExtendFriendFragment.a(this.a), ExtendFriendFragment.a(this.a).app, ExtendFriendFragment.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asiw
 * JD-Core Version:    0.7.0.1
 */