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

public class asyl
  extends asvt
{
  public asyl(ExtendFriendFragment paramExtendFriendFragment) {}
  
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
        asvg localasvg = (asvg)ExtendFriendFragment.a(this.a).a(127);
        localObject = atcb.a((oidb_0xdb1.SchoolInfo)localObject);
        atcb.a(ExtendFriendFragment.a(this.a), localasvg, str1, (EditExtendFriendInfo.SchoolInfo)localObject);
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
      bdll.b(null, "dc00898", "", "", "0X800ADD7", "0X800ADD7", paramInt, 0, "", "", "", "");
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
      QQToast.a(ExtendFriendFragment.a(this.a), 2, 2131697980, 0).b(ExtendFriendFragment.a(this.a).getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
    if ((ExtendFriendFragment.a(this.a) != null) && (ExtendFriendFragment.a(this.a).isResume()) && (((atag)ExtendFriendFragment.a(this.a).app.getManager(292)).a() != 2) && (!ExtendFriendFragment.a(this.a))) {
      ExtendFriendFragment.a(this.a, atbg.a(ExtendFriendFragment.a(this.a), ExtendFriendFragment.a(this.a).app, ExtendFriendFragment.a(this.a)));
    }
  }
  
  protected void g(boolean paramBoolean)
  {
    atce localatce;
    if ((paramBoolean) && (ExtendFriendFragment.a(this.a) != null) && (ExtendFriendFragment.a(this.a) != null) && (!ExtendFriendFragment.a(this.a).isFinishing()))
    {
      localatce = atce.a(ExtendFriendFragment.a(this.a));
      if (!localatce.c()) {
        break label63;
      }
      this.a.c();
    }
    label63:
    while (!localatce.b()) {
      return;
    }
    this.a.b();
  }
  
  protected void l_(int paramInt)
  {
    axaw.a(ExtendFriendFragment.a(this.a), ExtendFriendFragment.a(this.a).app);
    Intent localIntent = new Intent("match_chat_notify_update");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyl
 * JD-Core Version:    0.7.0.1
 */