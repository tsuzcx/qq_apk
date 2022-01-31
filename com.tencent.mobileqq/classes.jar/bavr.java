import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class bavr
  implements Manager
{
  private bavv jdField_a_of_type_Bavv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public bavr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("serializePreDownload", true);
    this.jdField_a_of_type_Bavv = ((bavv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(233));
    this.jdField_a_of_type_Bavv.b(this.jdField_a_of_type_Boolean);
  }
  
  public static String a(int paramInt, String paramString, boolean paramBoolean)
  {
    return bavv.a(paramInt, paramString, paramBoolean);
  }
  
  public static ArrayList<String> a(int paramInt1, int paramInt2)
  {
    return new ArrayList(5);
  }
  
  public bavo a(String paramString)
  {
    return this.jdField_a_of_type_Bavv.a(paramString);
  }
  
  void a(bavo parambavo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Controller", 2, "onTaskEnd: " + parambavo);
    }
    this.jdField_a_of_type_Bavv.a(parambavo);
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_Bavv.a(paramString, paramLong);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, bavo parambavo)
  {
    return this.jdField_a_of_type_Bavv.a(paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4, paramInt3, paramInt4, paramBoolean, parambavo);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavr
 * JD-Core Version:    0.7.0.1
 */