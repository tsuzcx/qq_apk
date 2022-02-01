import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class atlo
  implements View.OnClickListener
{
  atlo(atmk paramatmk, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localbety = bfsj.a(this.jdField_a_of_type_Atmk.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        String str = localbety.e;
        if (str != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        bety localbety;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bgnt.a(this.jdField_a_of_type_Atmk.getActivity()) == 0)
      {
        bfrh.a(this.jdField_a_of_type_Atmk.getActivity(), this.jdField_a_of_type_Atmk.getActivity().getString(2131696888));
      }
      else
      {
        bfrh.a(this.jdField_a_of_type_Atmk.getActivity(), this.jdField_a_of_type_Atmk.getActivity().getString(2131692439), 0);
        TroopFileTransferManager.a(this.jdField_a_of_type_Atmk.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin).a(localbety.e, localbety.g, localbety.c, localbety.h);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atlo
 * JD-Core Version:    0.7.0.1
 */