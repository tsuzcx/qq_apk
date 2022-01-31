import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qphone.base.util.QLog;

class apve
  extends apow<CustomEmotionData>
{
  apve(apvd paramapvd) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "upload_finish");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "download_finish");
    }
    this.a.j();
    azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a, "CliOper", "", "", "0X8005CEE", "0X8005CEE", 0, 0, paramInt + "", "", "", "");
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, int paramInt1, int paramInt2)
  {
    this.a.j();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "roaming_finish");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a != null) {
      ((apoo)this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a.getManager(103)).b(this.a.jdField_a_of_type_Apow);
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apve
 * JD-Core Version:    0.7.0.1
 */