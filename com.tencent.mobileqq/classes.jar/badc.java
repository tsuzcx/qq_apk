import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.AudioUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.AudioUploadCallback.2;
import com.tencent.qphone.base.util.QLog;

public final class badc
  implements bhxi
{
  public babi a;
  
  public badc(HWReciteItem paramHWReciteItem, babi parambabi)
  {
    this.jdField_a_of_type_Babi = parambabi;
  }
  
  public void a(int paramInt)
  {
    HWReciteItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteHWReciteItem).post(new HWReciteItem.AudioUploadCallback.1(this));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HWReciteItem", 2, "upload onComplete " + this.jdField_a_of_type_Babi.b);
    }
    this.jdField_a_of_type_Babi.b(paramString);
    this.jdField_a_of_type_Babi.g = 3;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("HWReciteItem", 2, "onError errorCode = " + paramInt);
    }
    this.jdField_a_of_type_Babi.g = 2;
    HWReciteItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteHWReciteItem).post(new HWReciteItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     badc
 * JD-Core Version:    0.7.0.1
 */