import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

final class aorn
  implements View.OnClickListener
{
  aorn(aotc paramaotc, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = azjg.a(this.jdField_a_of_type_Aotc.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (paramView.e == null) {
        return;
      }
      if (badq.a(this.jdField_a_of_type_Aotc.getActivity()) == 0)
      {
        azic.a(this.jdField_a_of_type_Aotc.getActivity(), this.jdField_a_of_type_Aotc.getActivity().getString(2131632133));
        return;
      }
      azic.a(this.jdField_a_of_type_Aotc.getActivity(), this.jdField_a_of_type_Aotc.getActivity().getString(2131627191), 0);
      TroopFileTransferManager.a(this.jdField_a_of_type_Aotc.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin).a(paramView.e, paramView.g, paramView.c, paramView.h);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aorn
 * JD-Core Version:    0.7.0.1
 */