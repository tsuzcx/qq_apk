import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class ayxs
  implements Manager
{
  private ayxw jdField_a_of_type_Ayxw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public ayxs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("serializePreDownload", true);
    this.jdField_a_of_type_Ayxw = ((ayxw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(233));
    this.jdField_a_of_type_Ayxw.b(this.jdField_a_of_type_Boolean);
  }
  
  public static String a(int paramInt, String paramString, boolean paramBoolean)
  {
    return ayxw.a(paramInt, paramString, paramBoolean);
  }
  
  public static ArrayList<String> a(int paramInt1, int paramInt2)
  {
    return new ArrayList(5);
  }
  
  public ayxp a(String paramString)
  {
    return this.jdField_a_of_type_Ayxw.a(paramString);
  }
  
  void a(ayxp paramayxp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Controller", 2, "onTaskEnd: " + paramayxp);
    }
    this.jdField_a_of_type_Ayxw.a(paramayxp);
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_Ayxw.a(paramString, paramLong);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, ayxp paramayxp)
  {
    return this.jdField_a_of_type_Ayxw.a(paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4, paramInt3, paramInt4, paramBoolean, paramayxp);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxs
 * JD-Core Version:    0.7.0.1
 */