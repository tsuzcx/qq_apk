import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.qphone.base.util.QLog;

public class asoa
  implements axfu<EmoticonPackage>
{
  public asoa(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout, Emoticon paramEmoticon, asmu paramasmu, asre paramasre) {}
  
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
      asmr localasmr = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_Asmr;
      if (localasmr != null) {
        localasmr.a(this.jdField_a_of_type_Asmu);
      }
    } while (this.jdField_a_of_type_Asre.d != 2);
    if ((paramEmoticonPackage.jobType == 0) && (paramEmoticonPackage.subType == 4))
    {
      bdll.b(((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "3", "");
      return;
    }
    bdll.b(((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "2", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoa
 * JD-Core Version:    0.7.0.1
 */