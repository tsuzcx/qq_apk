import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;

public class aowg
  extends aouc
{
  public aowg(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = h();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneFriendFeedsV1AndV2Action", 1, "doAction error: " + localException.getMessage());
      a("QzoneFriendFeedsV1AndV2Action");
    }
    return false;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Object localObject = (bcvr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    if ((localObject != null) && ((((bcvr)localObject).a(2) > 0) || (((bcvr)localObject).a(1) > 0))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("newflag", bool);
      ((Intent)localObject).putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((Intent)localObject).addFlags(805306368);
      String str = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("push_trans_channel");
      QZoneHelper.forwardToFriendFeed((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (Intent)localObject, str, -1);
      LpReportInfo_dc02880.report(this.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowg
 * JD-Core Version:    0.7.0.1
 */