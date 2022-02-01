import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.qphone.base.util.QLog;

class arfg
  implements avtb<EmoticonPackage>
{
  arfg(arfd paramarfd, PicEmoticonInfo paramPicEmoticonInfo) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.imageType = paramEmoticonPackage.type;
      PicEmoticonInfo localPicEmoticonInfo = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        bool = true;
        localPicEmoticonInfo.isAPNG = bool;
      }
    }
    for (;;)
    {
      arfd.a(this.jdField_a_of_type_Arfd).send(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func sendEmoji ends, type:" + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.imageType);
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.imageType = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfg
 * JD-Core Version:    0.7.0.1
 */