import android.os.Bundle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class ammn
  extends bhyn
{
  ammn(amme paramamme) {}
  
  public void onDone(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + parambhyo.f + ", status: " + parambhyo.a());
    }
  }
  
  public void onDoneFile(bhyo parambhyo)
  {
    if (parambhyo == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = parambhyo.a();
    } while (localBundle == null);
    int i = localBundle.getInt(parambhyo.c);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + i + ",httpCode: " + parambhyo.f + ", status: " + parambhyo.a() + ",task.currUrl:" + parambhyo.c);
    }
    if (1 == i) {}
    try
    {
      super.onDone(parambhyo);
      if (parambhyo.a() != 3) {
        this.a.jdField_a_of_type_Anlu.a(Boolean.valueOf(false));
      }
      this.a.b();
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception parambhyo)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", parambhyo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammn
 * JD-Core Version:    0.7.0.1
 */