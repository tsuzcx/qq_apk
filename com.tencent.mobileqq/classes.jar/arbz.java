import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

final class arbz
  implements View.OnClickListener
{
  arbz(ardn paramardn, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = bcjk.a(this.jdField_a_of_type_Ardn.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (paramView.e == null) {
        return;
      }
      if (bdee.a(this.jdField_a_of_type_Ardn.getActivity()) == 0)
      {
        bcig.a(this.jdField_a_of_type_Ardn.getActivity(), this.jdField_a_of_type_Ardn.getActivity().getString(2131698040));
        return;
      }
      bcig.a(this.jdField_a_of_type_Ardn.getActivity(), this.jdField_a_of_type_Ardn.getActivity().getString(2131692912), 0);
      TroopFileTransferManager.a(this.jdField_a_of_type_Ardn.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin).a(paramView.e, paramView.g, paramView.c, paramView.h);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbz
 * JD-Core Version:    0.7.0.1
 */