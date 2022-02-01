import android.os.Bundle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class amtf
  extends biht
{
  amtf(amsx paramamsx) {}
  
  public void onDone(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + parambihu.f + ", status: " + parambihu.a());
    }
  }
  
  public void onDoneFile(bihu parambihu)
  {
    if (parambihu == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = parambihu.a();
    } while (localBundle == null);
    int i = localBundle.getInt(parambihu.c);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + i + ",httpCode: " + parambihu.f + ", status: " + parambihu.a() + ",task.currUrl:" + parambihu.c);
    }
    if (1 == i) {}
    try
    {
      super.onDone(parambihu);
      if (parambihu.a() != 3) {
        this.a.jdField_a_of_type_Anpo.a(Boolean.valueOf(false));
      }
      this.a.b();
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception parambihu)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", parambihu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtf
 * JD-Core Version:    0.7.0.1
 */