import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

class axfr
  implements AdapterView.OnItemClickListener
{
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  private WeakReference<QQBrowserActivity> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<WebView> b;
  
  axfr(QQBrowserActivity paramQQBrowserActivity, WebView paramWebView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQBrowserActivity);
    this.b = new WeakReference(paramWebView);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener != null) {
      this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    QLog.w("TeamWorkShareActionSheetBuilder", 1, "inner on item click");
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo == null) {}
    do
    {
      do
      {
        return;
        QLog.w("TeamWorkShareActionSheetBuilder", 1, "info exist");
      } while (!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c());
      QLog.w("TeamWorkShareActionSheetBuilder", 1, "from online preview");
      paramAdapterView = paramView.getTag();
    } while (paramAdapterView == null);
    paramInt = ((baia)paramAdapterView).a.c;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 9) || (paramInt == 10))
    {
      paramAdapterView = (WebView)this.b.get();
      if (paramAdapterView == null) {
        break label234;
      }
    }
    label234:
    for (paramAdapterView = paramAdapterView.getUrl();; paramAdapterView = "")
    {
      axfs.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, paramAdapterView, "0X8009F34");
      paramAdapterView = (QQBrowserActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramAdapterView == null) {
        break;
      }
      if (paramInt == 1)
      {
        axfs.a(paramAdapterView.getIntent(), "0X800A16F");
        return;
      }
      if ((paramInt == 2) || (paramInt == 9) || (paramInt == 10) || (paramInt == 3) || (paramInt == 12))
      {
        axfs.a(paramAdapterView.getIntent(), "0X800A16E");
        return;
      }
      if (paramInt == 6)
      {
        axfs.a(paramAdapterView.getIntent(), "0X800A170");
        return;
      }
      if (paramInt != 5) {
        break;
      }
      axfs.a(paramAdapterView.getIntent(), "0X800A171");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axfr
 * JD-Core Version:    0.7.0.1
 */