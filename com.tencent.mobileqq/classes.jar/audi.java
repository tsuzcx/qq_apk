import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class audi
  implements View.OnClickListener
{
  audi(auef paramauef, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localbftf = bgsk.a(this.jdField_a_of_type_Auef.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        String str = localbftf.e;
        if (str != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        bftf localbftf;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bhnv.a(this.jdField_a_of_type_Auef.getActivity()) == 0)
      {
        bgri.a(this.jdField_a_of_type_Auef.getActivity(), this.jdField_a_of_type_Auef.getActivity().getString(2131696937));
      }
      else
      {
        bgri.a(this.jdField_a_of_type_Auef.getActivity(), this.jdField_a_of_type_Auef.getActivity().getString(2131692445), 0);
        TroopFileTransferManager.a(this.jdField_a_of_type_Auef.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin).a(localbftf.e, localbftf.g, localbftf.c, localbftf.h);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audi
 * JD-Core Version:    0.7.0.1
 */