import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OCRHandler.BaseOCRReqBigDataListener.1;
import com.tencent.qphone.base.util.QLog;

public class atzs
  implements aysa
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public atzs(atzr paramatzr, Intent paramIntent, byte[] paramArrayOfByte, String paramString)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onResp(aysx paramaysx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp()");
    }
    ThreadManager.post(new OCRHandler.BaseOCRReqBigDataListener.1(this, paramaysx), 8, null, true);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzs
 * JD-Core Version:    0.7.0.1
 */