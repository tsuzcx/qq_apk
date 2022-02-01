import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class asps
  implements View.OnClickListener
{
  asps(asqp paramasqp, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localbecp = bfby.a(this.jdField_a_of_type_Asqp.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        String str = localbecp.e;
        if (str != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        becp localbecp;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.getSystemNetwork(this.jdField_a_of_type_Asqp.getActivity()) == 0)
      {
        bfaw.a(this.jdField_a_of_type_Asqp.getActivity(), this.jdField_a_of_type_Asqp.getActivity().getString(2131697079));
      }
      else
      {
        bfaw.a(this.jdField_a_of_type_Asqp.getActivity(), this.jdField_a_of_type_Asqp.getActivity().getString(2131692493), 0);
        TroopFileTransferManager.a(this.jdField_a_of_type_Asqp.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin).a(localbecp.e, localbecp.g, localbecp.c, localbecp.h);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asps
 * JD-Core Version:    0.7.0.1
 */