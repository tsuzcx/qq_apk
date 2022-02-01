import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

class becq
  implements ShareActionSheet.OnItemClickListener
{
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  private ShareActionSheet.OnItemClickListener jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener;
  private WeakReference<QQBrowserActivity> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<WebView> b;
  
  becq(QQBrowserActivity paramQQBrowserActivity, WebView paramWebView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQBrowserActivity);
    this.b = new WeakReference(paramWebView);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    QLog.w("TeamWorkShareActionSheetBuilder", 1, "inner on item click");
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener.onItemClick(paramActionSheetItem, paramShareActionSheet);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo == null) {}
    do
    {
      return;
      QLog.w("TeamWorkShareActionSheetBuilder", 1, "info exist");
    } while (!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d());
    QLog.w("TeamWorkShareActionSheetBuilder", 1, "from online preview");
    int i = paramActionSheetItem.action;
    if ((i == 1) || (i == 2) || (i == 9) || (i == 10))
    {
      paramActionSheetItem = (WebView)this.b.get();
      if (paramActionSheetItem == null) {
        break label216;
      }
    }
    label216:
    for (paramActionSheetItem = paramActionSheetItem.getUrl();; paramActionSheetItem = "")
    {
      becr.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, paramActionSheetItem, "0X8009F34");
      paramActionSheetItem = (QQBrowserActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramActionSheetItem == null) {
        break;
      }
      if (i == 1)
      {
        becr.a(paramActionSheetItem.getIntent(), "0X800A16F");
        return;
      }
      if ((i == 2) || (i == 9) || (i == 10) || (i == 3) || (i == 12))
      {
        becr.a(paramActionSheetItem.getIntent(), "0X800A16E");
        return;
      }
      if (i == 6)
      {
        becr.a(paramActionSheetItem.getIntent(), "0X800A170");
        return;
      }
      if (i != 5) {
        break;
      }
      becr.a(paramActionSheetItem.getIntent(), "0X800A171");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becq
 * JD-Core Version:    0.7.0.1
 */