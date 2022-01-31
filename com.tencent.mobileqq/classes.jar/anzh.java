import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.qphone.base.util.QLog;

public class anzh
  implements askq<EmoticonPackage>
{
  public anzh(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout, Emoticon paramEmoticon, anyh paramanyh, aobp paramaobp) {}
  
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
      anyg localanyg = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_Anyg;
      if (localanyg != null) {
        localanyg.a(this.jdField_a_of_type_Anyh);
      }
    } while (this.jdField_a_of_type_Aobp.d != 2);
    if ((paramEmoticonPackage.jobType == 0) && (paramEmoticonPackage.subType == 4))
    {
      axqy.b(((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "3", "");
      return;
    }
    axqy.b(((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "2", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anzh
 * JD-Core Version:    0.7.0.1
 */