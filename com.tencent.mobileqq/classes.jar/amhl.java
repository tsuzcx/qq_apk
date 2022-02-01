import android.os.Bundle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class amhl
  extends bhhe
{
  amhl(amhd paramamhd) {}
  
  public void onDone(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + parambhhf.f + ", status: " + parambhhf.a());
    }
  }
  
  public void onDoneFile(bhhf parambhhf)
  {
    if (parambhhf == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = parambhhf.a();
    } while (localBundle == null);
    int i = localBundle.getInt(parambhhf.c);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + i + ",httpCode: " + parambhhf.f + ", status: " + parambhhf.a() + ",task.currUrl:" + parambhhf.c);
    }
    if (1 == i) {}
    try
    {
      super.onDone(parambhhf);
      if (parambhhf.a() != 3) {
        this.a.jdField_a_of_type_Andu.a(Boolean.valueOf(false));
      }
      this.a.b();
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception parambhhf)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", parambhhf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhl
 * JD-Core Version:    0.7.0.1
 */