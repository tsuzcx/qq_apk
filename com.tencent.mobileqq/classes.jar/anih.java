import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;

public class anih
  extends ancp<CustomEmotionData>
{
  public anih(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "upload_finish");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "download_finish");
    }
    this.a.p();
    awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CEE", "0X8005CEE", 0, 0, paramInt + "", "", "", "");
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, int paramInt1, int paramInt2)
  {
    this.a.p();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "roaming_finish");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((anch)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).b(this.a.jdField_a_of_type_Ancp);
    }
    this.a.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anih
 * JD-Core Version:    0.7.0.1
 */