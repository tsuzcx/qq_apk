import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

class ayfw
  implements AdapterView.OnItemClickListener
{
  private bcvg jdField_a_of_type_Bcvg;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  private WeakReference<QQBrowserActivity> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<WebView> b;
  
  ayfw(QQBrowserActivity paramQQBrowserActivity, WebView paramWebView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, bcvg parambcvg)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQBrowserActivity);
    this.b = new WeakReference(paramWebView);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    this.jdField_a_of_type_Bcvg = parambcvg;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QLog.w("TeamWorkShareActionSheetBuilder", 1, "inner on item click");
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {}
    do
    {
      do
      {
        return;
        paramAdapterView = ((bbjv)paramAdapterView).a;
        if (this.jdField_a_of_type_Bcvg != null) {
          this.jdField_a_of_type_Bcvg.a(paramAdapterView, null);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo == null);
      QLog.w("TeamWorkShareActionSheetBuilder", 1, "info exist");
    } while (!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d());
    QLog.w("TeamWorkShareActionSheetBuilder", 1, "from online preview");
    paramInt = paramAdapterView.c;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 9) || (paramInt == 10))
    {
      paramAdapterView = (WebView)this.b.get();
      if (paramAdapterView == null) {
        break label233;
      }
    }
    label233:
    for (paramAdapterView = paramAdapterView.getUrl();; paramAdapterView = "")
    {
      ayfx.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, paramAdapterView, "0X8009F34");
      paramAdapterView = (QQBrowserActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramAdapterView == null) {
        break;
      }
      if (paramInt == 1)
      {
        ayfx.a(paramAdapterView.getIntent(), "0X800A16F");
        return;
      }
      if ((paramInt == 2) || (paramInt == 9) || (paramInt == 10) || (paramInt == 3) || (paramInt == 12))
      {
        ayfx.a(paramAdapterView.getIntent(), "0X800A16E");
        return;
      }
      if (paramInt == 6)
      {
        ayfx.a(paramAdapterView.getIntent(), "0X800A170");
        return;
      }
      if (paramInt != 5) {
        break;
      }
      ayfx.a(paramAdapterView.getIntent(), "0X800A171");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayfw
 * JD-Core Version:    0.7.0.1
 */