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

public class aqdz
  extends aqbl
{
  public aqdz(ExtendFriendFragment paramExtendFriendFragment) {}
  
  protected void a(int paramInt)
  {
    auau.a(ExtendFriendFragment.a(this.a), ExtendFriendFragment.a(this.a).app);
    Intent localIntent = new Intent("match_chat_notify_update");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    int i = ExtendFriendFragment.a(this.a).c();
    String str1 = ExtendFriendFragment.a(this.a).f();
    String str2 = ExtendFriendFragment.a(this.a).g();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateCampusCertificateStatus,isSuccess + " + paramBoolean + ",scene + " + paramInt + ",verifyStatus + " + i + ",serverSuggestSchoolName + " + str1);
    }
    if ((paramBoolean) && (paramInt == 1))
    {
      if (((i == 0) || (i == 3)) && (!aqgz.a(ExtendFriendFragment.a(this.a))) && (TextUtils.isEmpty(str2)))
      {
        aqgz.a(ExtendFriendFragment.a(this.a), str1);
        aqgz.a(ExtendFriendFragment.a(this.a));
      }
      Object localObject = ExtendFriendFragment.a(this.a).a();
      str2 = ExtendFriendFragment.a(this.a).g();
      if ((!TextUtils.isEmpty(str2)) && (localObject != null) && (!ExtendFriendFragment.a(this.a).isFinishing()))
      {
        if (!((oidb_0xdb1.SchoolInfo)localObject).str_school_name.has()) {
          break label307;
        }
        str1 = ((oidb_0xdb1.SchoolInfo)localObject).str_school_name.get();
        aqbe localaqbe = (aqbe)ExtendFriendFragment.a(this.a).a(127);
        localObject = aqgz.a((oidb_0xdb1.SchoolInfo)localObject);
        aqgz.a(ExtendFriendFragment.a(this.a), localaqbe, str1, (EditExtendFriendInfo.SchoolInfo)localObject);
      }
      if (TextUtils.isEmpty(str2)) {
        break label314;
      }
      paramInt = 1;
      label276:
      if (paramInt == 0) {
        break label319;
      }
    }
    label307:
    label314:
    label319:
    for (paramInt = 1;; paramInt = 2)
    {
      azqs.b(null, "dc00898", "", "", "0X800ADD7", "0X800ADD7", paramInt, 0, "", "", "", "");
      return;
      str1 = "";
      break;
      paramInt = 0;
      break label276;
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateExtendFriendCampusSchoolInfo isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      QQToast.a(ExtendFriendFragment.a(this.a), 2, 2131699265, 0).b(ExtendFriendFragment.a(this.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdz
 * JD-Core Version:    0.7.0.1
 */