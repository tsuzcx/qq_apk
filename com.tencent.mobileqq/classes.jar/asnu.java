import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qphone.base.util.QLog;

class asnu
  extends ashl<CustomEmotionData>
{
  asnu(asnt paramasnt) {}
  
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
    this.a.b();
    bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a, "CliOper", "", "", "0X8005CEE", "0X8005CEE", 0, 0, paramInt + "", "", "", "");
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, int paramInt1, int paramInt2)
  {
    this.a.b();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "roaming_finish");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a != null) {
      ((ashd)this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a.getManager(103)).b(this.a.jdField_a_of_type_Ashl);
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnu
 * JD-Core Version:    0.7.0.1
 */