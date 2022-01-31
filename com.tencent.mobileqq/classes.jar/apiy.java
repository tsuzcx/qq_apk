import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

final class apiy
  implements View.OnClickListener
{
  apiy(apkm paramapkm, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = bakj.a(this.jdField_a_of_type_Apkm.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (paramView.e == null) {
        return;
      }
      if (bbev.a(this.jdField_a_of_type_Apkm.getActivity()) == 0)
      {
        bajf.a(this.jdField_a_of_type_Apkm.getActivity(), this.jdField_a_of_type_Apkm.getActivity().getString(2131697853));
        return;
      }
      bajf.a(this.jdField_a_of_type_Apkm.getActivity(), this.jdField_a_of_type_Apkm.getActivity().getString(2131692829), 0);
      TroopFileTransferManager.a(this.jdField_a_of_type_Apkm.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin).a(paramView.e, paramView.g, paramView.c, paramView.h);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apiy
 * JD-Core Version:    0.7.0.1
 */