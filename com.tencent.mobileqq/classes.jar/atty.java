import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class atty
  implements View.OnClickListener
{
  atty(atuw paramatuw, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      audz localaudz = new audz();
      localaudz.b = "file_forward";
      localaudz.a = 9;
      audy.a(this.jdField_a_of_type_Atuw.a().getCurrentAccountUin(), localaudz);
      aufd.a(this.jdField_a_of_type_Atuw.a(), this.jdField_a_of_type_Atuw.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      label61:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atty
 * JD-Core Version:    0.7.0.1
 */