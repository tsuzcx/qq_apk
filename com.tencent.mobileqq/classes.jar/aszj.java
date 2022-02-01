import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aszj
  implements View.OnClickListener
{
  public aszj(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.setResult(-1, localIntent);
    TroopFileZipPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityTroopFileZipPreviewActivity.app, "dc00899", "Grp_files", null, "oper", "pre_arc_close", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, "", "", "1");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszj
 * JD-Core Version:    0.7.0.1
 */