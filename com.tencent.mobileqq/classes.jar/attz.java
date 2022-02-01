import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class attz
  implements View.OnClickListener
{
  attz(atuw paramatuw, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localbfjs = bgke.a(this.jdField_a_of_type_Atuw.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        String str = localbfjs.e;
        if (str != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        bfjs localbfjs;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.getSystemNetwork(this.jdField_a_of_type_Atuw.getActivity()) == 0)
      {
        bgjc.a(this.jdField_a_of_type_Atuw.getActivity(), this.jdField_a_of_type_Atuw.getActivity().getString(2131697356));
      }
      else
      {
        bgjc.a(this.jdField_a_of_type_Atuw.getActivity(), this.jdField_a_of_type_Atuw.getActivity().getString(2131692595), 0);
        TroopFileTransferManager.a(this.jdField_a_of_type_Atuw.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin).a(localbfjs.e, localbfjs.g, localbfjs.c, localbfjs.h);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attz
 * JD-Core Version:    0.7.0.1
 */