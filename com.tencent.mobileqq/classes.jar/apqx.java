import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.qphone.base.util.QLog;

public class apqx
  implements aubp<EmoticonPackage>
{
  public apqx(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout, Emoticon paramEmoticon, appw paramappw, aptm paramaptm) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelLinearLayout", 2, "package is null, epId: " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    do
    {
      return;
      appt localappt = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_Appt;
      if (localappt != null) {
        localappt.a(this.jdField_a_of_type_Appw);
      }
    } while (this.jdField_a_of_type_Aptm.d != 2);
    if ((paramEmoticonPackage.jobType == 0) && (paramEmoticonPackage.subType == 4))
    {
      azmj.b(((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "3", "");
      return;
    }
    azmj.b(((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "2", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqx
 * JD-Core Version:    0.7.0.1
 */