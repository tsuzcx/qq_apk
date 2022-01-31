import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class axxj
  implements Manager
{
  private axxn jdField_a_of_type_Axxn;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public axxj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("serializePreDownload", true);
    this.jdField_a_of_type_Axxn = ((axxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(233));
    this.jdField_a_of_type_Axxn.b(this.jdField_a_of_type_Boolean);
  }
  
  public static String a(int paramInt, String paramString, boolean paramBoolean)
  {
    return axxn.a(paramInt, paramString, paramBoolean);
  }
  
  public static ArrayList<String> a(int paramInt1, int paramInt2)
  {
    return new ArrayList(5);
  }
  
  public axxg a(String paramString)
  {
    return this.jdField_a_of_type_Axxn.a(paramString);
  }
  
  void a(axxg paramaxxg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Controller", 2, "onTaskEnd: " + paramaxxg);
    }
    this.jdField_a_of_type_Axxn.a(paramaxxg);
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_Axxn.a(paramString, paramLong);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, axxg paramaxxg)
  {
    return this.jdField_a_of_type_Axxn.a(paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4, paramInt3, paramInt4, paramBoolean, paramaxxg);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxj
 * JD-Core Version:    0.7.0.1
 */