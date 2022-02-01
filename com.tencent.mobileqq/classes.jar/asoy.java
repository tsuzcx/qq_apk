import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.profilecard.EditExtendFriendInfo.SchoolInfo;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SchoolInfo;

public class asoy
  extends aslz
{
  public asoy(ExtendFriendFragment paramExtendFriendFragment) {}
  
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
          break label286;
        }
        str1 = ((oidb_0xdb1.SchoolInfo)localObject).str_school_name.get();
        aslm localaslm = (aslm)ExtendFriendFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        localObject = assp.a((oidb_0xdb1.SchoolInfo)localObject);
        assp.a(ExtendFriendFragment.a(this.a), localaslm, str1, (EditExtendFriendInfo.SchoolInfo)localObject);
      }
      if (TextUtils.isEmpty(str2)) {
        break label293;
      }
      paramInt = 1;
      label255:
      if (paramInt == 0) {
        break label298;
      }
    }
    label286:
    label293:
    label298:
    for (paramInt = 1;; paramInt = 2)
    {
      bdla.b(null, "dc00898", "", "", "0X800ADD7", "0X800ADD7", paramInt, 0, "", "", "", "");
      return;
      str1 = "";
      break;
      paramInt = 0;
      break label255;
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateExtendFriendCampusSchoolInfo isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      QQToast.a(ExtendFriendFragment.a(this.a), 2, 2131698423, 0).b(ExtendFriendFragment.a(this.a).getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
    if ((ExtendFriendFragment.a(this.a) != null) && (ExtendFriendFragment.a(this.a).isResume()) && (((asqt)ExtendFriendFragment.a(this.a).app.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a() != 2) && (!ExtendFriendFragment.a(this.a))) {
      ExtendFriendFragment.a(this.a, asru.a(ExtendFriendFragment.a(this.a), ExtendFriendFragment.a(this.a).app, ExtendFriendFragment.a(this.a)));
    }
  }
  
  protected void g(boolean paramBoolean)
  {
    asss localasss;
    if ((paramBoolean) && (ExtendFriendFragment.a(this.a) != null) && (ExtendFriendFragment.a(this.a) != null) && (!ExtendFriendFragment.a(this.a).isFinishing()))
    {
      localasss = asss.a(ExtendFriendFragment.a(this.a));
      if (!localasss.c()) {
        break label63;
      }
      this.a.c();
    }
    label63:
    while (!localasss.b()) {
      return;
    }
    this.a.b();
  }
  
  protected void m_(int paramInt)
  {
    awui.a(ExtendFriendFragment.a(this.a), ExtendFriendFragment.a(this.a).app);
    Intent localIntent = new Intent("match_chat_notify_update");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoy
 * JD-Core Version:    0.7.0.1
 */