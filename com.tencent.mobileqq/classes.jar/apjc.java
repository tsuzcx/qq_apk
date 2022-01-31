import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

final class apjc
  implements View.OnClickListener
{
  apjc(apkq paramapkq, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = bakx.a(this.jdField_a_of_type_Apkq.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (paramView.e == null) {
        return;
      }
      if (bbfj.a(this.jdField_a_of_type_Apkq.getActivity()) == 0)
      {
        bajt.a(this.jdField_a_of_type_Apkq.getActivity(), this.jdField_a_of_type_Apkq.getActivity().getString(2131697863));
        return;
      }
      bajt.a(this.jdField_a_of_type_Apkq.getActivity(), this.jdField_a_of_type_Apkq.getActivity().getString(2131692830), 0);
      TroopFileTransferManager.a(this.jdField_a_of_type_Apkq.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin).a(paramView.e, paramView.g, paramView.c, paramView.h);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apjc
 * JD-Core Version:    0.7.0.1
 */