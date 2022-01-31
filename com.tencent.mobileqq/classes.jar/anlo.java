import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class anlo
  extends VasQuickUpdateManager.CallBacker
{
  anlo(anlk paramanlk) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((1003L != paramLong) || (!"emotionRecommendEffect".equals(paramString1))) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((VasQuickUpdateManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184)).removeCallBacker(this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect callBacker errorCode:" + paramInt1 + ", httpCode:" + paramInt2 + ", apngSoLoaded:" + baon.a().isLoaded());
    }
    paramString1 = this.a.jdField_a_of_type_JavaLangObject;
    if (paramInt1 == 0) {}
    try
    {
      if ((this.a.b != null) && (this.a.b.size() > 0))
      {
        paramString2 = VasQuickUpdateManager.getFileFromLocal(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1003L, "emotionRecommendEffect", null, false, null);
        if (paramString2 != null)
        {
          paramInt1 = 0;
          while ((paramInt1 < this.a.b.size()) && (paramInt1 < 2))
          {
            paramString3 = (anlp)this.a.b.get(paramInt1);
            paramString3.a = paramString2;
            this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102, paramString3));
            paramInt1 += 1;
          }
          this.a.b.clear();
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anlo
 * JD-Core Version:    0.7.0.1
 */