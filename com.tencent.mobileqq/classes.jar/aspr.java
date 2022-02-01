import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aspr
  implements View.OnClickListener
{
  aspr(asqp paramasqp, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      aszs localaszs = new aszs();
      localaszs.b = "file_forward";
      localaszs.a = 9;
      aszr.a(this.jdField_a_of_type_Asqp.a().getCurrentAccountUin(), localaszs);
      ataw.a(this.jdField_a_of_type_Asqp.a(), this.jdField_a_of_type_Asqp.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
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
 * Qualified Name:     aspr
 * JD-Core Version:    0.7.0.1
 */