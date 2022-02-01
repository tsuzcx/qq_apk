import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atlt
  implements View.OnClickListener
{
  public atlt(QfileFavFileTabView paramQfileFavFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (!QfileFavFileTabView.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QfileFavFileTabView.a(this.a);
      this.a.a();
      if (this.a.jdField_a_of_type_Atjm.getGroupCount() > 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(this.a.jdField_a_of_type_Atjm.getGroupCount() - 1);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getAdapter().getCount() - 1);
      QfileFavFileTabView.a(this.a, false);
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atlt
 * JD-Core Version:    0.7.0.1
 */