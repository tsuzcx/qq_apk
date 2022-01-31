import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class avcp
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  long jdField_b_of_type_Long;
  int[] jdField_b_of_type_ArrayOfInt = new int[2];
  
  public avcp(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_b_of_type_ArrayOfInt[0] = paramInt1;
    this.jdField_b_of_type_ArrayOfInt[1] = paramInt2;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("PttPreSendSp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
    this.jdField_a_of_type_ArrayOfInt[0] = localSharedPreferences.getInt("avaliableflowxg", this.jdField_b_of_type_ArrayOfInt[0]);
    this.jdField_a_of_type_ArrayOfInt[1] = localSharedPreferences.getInt("avaliableflowifi", this.jdField_b_of_type_ArrayOfInt[1]);
    this.jdField_a_of_type_Long = localSharedPreferences.getLong("lastdaymillion", 0L);
    if (QLog.isDevelopLevel()) {
      QLog.d("PttPreSendManager", 4, "PttPreFlowController.loadCfg, lastDayMillion " + this.jdField_a_of_type_Long);
    }
  }
  
  public void a()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("PttPreSendSp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putInt("avaliableflowxg", this.jdField_a_of_type_ArrayOfInt[0]).putInt("avaliableflowifi", this.jdField_a_of_type_ArrayOfInt[1]).commit();
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    int i;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      i = 1;
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] + paramLong));
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (this.jdField_a_of_type_ArrayOfInt[i] <= this.jdField_b_of_type_ArrayOfInt[i]) {
        break label128;
      }
    }
    label128:
    for (int j = this.jdField_b_of_type_ArrayOfInt[i];; j = this.jdField_a_of_type_ArrayOfInt[i])
    {
      arrayOfInt[i] = j;
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, "doOnRealSend : guess hit, give back  " + paramLong + ", avaliableFlow " + this.jdField_a_of_type_ArrayOfInt[i] + ", iswifi " + paramBoolean);
      }
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 1;
      if (!paramBoolean) {
        break label249;
      }
      j = 10000;
      label14:
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Long <= 0L) || (l <= this.jdField_a_of_type_Long) || (l - this.jdField_a_of_type_Long >= this.jdField_b_of_type_Long))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = this.jdField_b_of_type_ArrayOfInt[0];
        this.jdField_a_of_type_ArrayOfInt[1] = this.jdField_b_of_type_ArrayOfInt[1];
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "check flow : refresh flow avalia， limitation xg: " + this.jdField_b_of_type_ArrayOfInt[0] + ", wifi: " + this.jdField_b_of_type_ArrayOfInt[1]);
        }
        this.jdField_a_of_type_Long = l;
        BaseApplicationImpl.sApplication.getSharedPreferences("PttPreSendSp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putLong("lastdaymillion", this.jdField_a_of_type_Long).commit();
      }
      if (this.jdField_a_of_type_ArrayOfInt[i] < j) {
        break label256;
      }
    }
    label256:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PttPreSendManager", 2, "check flow : support ? " + bool + " iswifi : " + paramBoolean);
      }
      return bool;
      i = 0;
      break;
      label249:
      j = 4000;
      break label14;
    }
  }
  
  public boolean a(boolean paramBoolean, long paramLong)
  {
    boolean bool = true;
    int i;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      i = 1;
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] - paramLong));
      if (this.jdField_a_of_type_ArrayOfInt[i] < 0) {
        break label143;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, "flow consume result : " + bool + " flow " + paramLong + ", avaliableFlow " + this.jdField_a_of_type_ArrayOfInt[i] + ", iswifi " + paramBoolean);
      }
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      if (i >= 3)
      {
        a();
        this.jdField_a_of_type_Int = 0;
      }
      return bool;
      i = 0;
      break;
      label143:
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] + paramLong));
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avcp
 * JD-Core Version:    0.7.0.1
 */