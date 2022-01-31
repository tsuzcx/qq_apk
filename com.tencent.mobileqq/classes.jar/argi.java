import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

final class argi
  implements View.OnClickListener
{
  argi(arhw paramarhw, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = bcnt.a(this.jdField_a_of_type_Arhw.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (paramView.e == null) {
        return;
      }
      if (bdin.a(this.jdField_a_of_type_Arhw.getActivity()) == 0)
      {
        bcmp.a(this.jdField_a_of_type_Arhw.getActivity(), this.jdField_a_of_type_Arhw.getActivity().getString(2131698042));
        return;
      }
      bcmp.a(this.jdField_a_of_type_Arhw.getActivity(), this.jdField_a_of_type_Arhw.getActivity().getString(2131692914), 0);
      TroopFileTransferManager.a(this.jdField_a_of_type_Arhw.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin).a(paramView.e, paramView.g, paramView.c, paramView.h);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argi
 * JD-Core Version:    0.7.0.1
 */