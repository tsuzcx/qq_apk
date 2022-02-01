import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class audh
  implements View.OnClickListener
{
  audh(auef paramauef, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      auni localauni = new auni();
      localauni.b = "file_forward";
      localauni.a = 9;
      aunh.a(this.jdField_a_of_type_Auef.a().getCurrentAccountUin(), localauni);
      auoo.a(this.jdField_a_of_type_Auef.a(), this.jdField_a_of_type_Auef.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
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
 * Qualified Name:     audh
 * JD-Core Version:    0.7.0.1
 */