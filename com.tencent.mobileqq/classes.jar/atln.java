import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class atln
  implements View.OnClickListener
{
  atln(atmk paramatmk, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      atvn localatvn = new atvn();
      localatvn.b = "file_forward";
      localatvn.a = 9;
      atvm.a(this.jdField_a_of_type_Atmk.a().getCurrentAccountUin(), localatvn);
      atwt.a(this.jdField_a_of_type_Atmk.a(), this.jdField_a_of_type_Atmk.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atln
 * JD-Core Version:    0.7.0.1
 */