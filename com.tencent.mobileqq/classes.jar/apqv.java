import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qphone.base.util.QLog;

class apqv
  extends apkn<CustomEmotionData>
{
  apqv(apqu paramapqu) {}
  
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
    azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a, "CliOper", "", "", "0X8005CEE", "0X8005CEE", 0, 0, paramInt + "", "", "", "");
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
      ((apkf)this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a.getManager(103)).b(this.a.jdField_a_of_type_Apkn);
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqv
 * JD-Core Version:    0.7.0.1
 */