import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class baiu
  extends baht
{
  public baiu(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.stopTitleProgress();
    if (!paramBoolean) {
      arri.a(alud.a(2131715195));
    }
    while ((this.a.jdField_a_of_type_Int != paramInt) && (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if ((0 == 0) && (QLog.isDevelopLevel())) {
      QLog.i("TeamWorkAuthorizeSettingFragment", 1, "padInfo is null, maybe is newpad");
    }
    this.a.jdField_a_of_type_JavaUtilList.clear();
    if (0 != 0) {
      throw new NullPointerException();
    }
    for (;;)
    {
      TeamWorkAuthorizeSettingFragment.a(this.a, this.a.b);
      TeamWorkAuthorizeSettingFragment.a(this.a);
      TeamWorkAuthorizeSettingFragment.a(this.a, true);
      return;
      this.a.b = 2;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, List<TimDocSSOMsg.UinRightInfo> paramList)
  {
    this.a.stopTitleProgress();
    if (!paramBoolean) {
      arri.a(alud.a(2131715183));
    }
    while (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.jdField_a_of_type_JavaUtilList.clear();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (TimDocSSOMsg.UinRightInfo)paramString.next();
      bagi localbagi = new bagi();
      localbagi.jdField_a_of_type_JavaLangString = String.valueOf(paramList.uint64_uin.get());
      localbagi.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = paramList;
      this.a.jdField_a_of_type_Bagg.a(localbagi);
    }
    this.a.b = paramInt;
    TeamWorkAuthorizeSettingFragment.a(this.a, this.a.b);
    TeamWorkAuthorizeSettingFragment.a(this.a);
    TeamWorkAuthorizeSettingFragment.a(this.a, true);
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    TeamWorkAuthorizeSettingFragment.a(this.a, true);
    this.a.getRightTextView().setEnabled(true);
    this.a.stopTitleProgress();
    if (!paramBoolean) {
      arri.a(alud.a(2131715138));
    }
    Intent localIntent;
    do
    {
      return;
      arri.b(alud.a(2131715140));
      this.a.stopTitleProgress();
      localIntent = new Intent();
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("type", paramInt);
    } while (!this.a.isAdded());
    this.a.getActivity().setResult(1122, localIntent);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baiu
 * JD-Core Version:    0.7.0.1
 */