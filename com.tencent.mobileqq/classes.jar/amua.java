import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class amua
  implements ansz
{
  int jdField_a_of_type_Int = 0;
  final long jdField_a_of_type_Long = AudioHelper.b();
  long jdField_b_of_type_Long = System.currentTimeMillis();
  
  amua(amtz paramamtz, AppInterface paramAppInterface, String paramString, int paramInt) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    if ((paramInt == 100) || (paramInt == 0) || (Math.abs(paramInt - this.jdField_a_of_type_Int) >= 10)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_b_of_type_Long >= 1000L) {
        bool2 = true;
      }
      if ((QLog.isDevelopLevel()) && ((bool2) || (bool1))) {
        QLog.w(this.jdField_a_of_type_Amtz.jdField_a_of_type_JavaLangString, 1, "onDownloadUpdate, md5[" + paramString2 + "], activityid[" + this.jdField_a_of_type_JavaLangString + "], index[" + this.jdField_b_of_type_Int + "], curPercent[" + paramInt + "], lastPercent[" + this.jdField_a_of_type_Int + "], needNotify[" + bool1 + "], needNotify2[" + bool2 + "]");
      }
      if (bool1) {
        this.jdField_a_of_type_Int = paramInt;
      }
      if (bool2) {
        this.jdField_b_of_type_Long = l;
      }
      if ((bool1) || (bool2)) {
        this.jdField_a_of_type_Amtz.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, paramInt);
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    int i;
    if ((paramObject instanceof amtt))
    {
      paramString1 = (amtt)paramObject;
      paramString1.c = System.currentTimeMillis();
      paramObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      boolean bool = false;
      if (paramInt == 0) {
        bool = amtz.a(paramString1);
      }
      QLog.w(this.jdField_a_of_type_Amtz.jdField_a_of_type_JavaLangString, 1, "onDownloadFinish, md5[" + paramString2 + "], errCode[" + paramInt + "], check[" + bool + "], path[" + paramString3 + "], id[" + paramString1.e + "], request[" + paramString1.jdField_a_of_type_Long + "], Begin[" + paramString1.jdField_b_of_type_Long + "], End[" + paramString1.c + "], 调度耗时[" + (paramString1.jdField_b_of_type_Long - paramString1.jdField_a_of_type_Long) + "], 下载耗时[" + (paramString1.c - paramString1.jdField_b_of_type_Long) + "], fromPreCover[" + paramString1.d + "], seq[" + this.jdField_a_of_type_Long + "], Uin[" + paramObject + "], zipItem[" + paramString1 + "]");
      if (paramString1.jdField_a_of_type_Ansz == this) {
        paramString1.jdField_a_of_type_Ansz = null;
      }
      i = paramInt;
      if (paramInt == 0)
      {
        i = paramInt;
        if (!bool) {
          i = -5;
        }
      }
      if (i != 0) {
        break label339;
      }
      paramString1.a(2);
      bdpg.a(paramObject, paramString1.e, paramString1.jdField_a_of_type_Int, paramString1.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Amtz.a(paramString1.e, paramString1.jdField_a_of_type_Int, 100);
      paramString1.d = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_Amtz.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString1.jdField_a_of_type_Boolean, paramString1.e, paramString1.jdField_a_of_type_Int + 1);
      return;
      label339:
      if (i == 100)
      {
        paramString1.a(2);
        this.jdField_a_of_type_Amtz.a(paramString1.e, paramString1.jdField_a_of_type_Int, 100);
      }
      else
      {
        paramString1.a(-1);
        this.jdField_a_of_type_Amtz.a(paramString1.e, paramString1.jdField_a_of_type_Int, -1);
      }
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    QLog.w(this.jdField_a_of_type_Amtz.jdField_a_of_type_JavaLangString, 1, "ZipItem.finalize, activityid[" + this.jdField_a_of_type_JavaLangString + "], index[" + this.jdField_b_of_type_Int + "], seq[" + this.jdField_a_of_type_Long + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amua
 * JD-Core Version:    0.7.0.1
 */