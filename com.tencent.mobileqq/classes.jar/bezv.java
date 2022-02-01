import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class bezv
  implements Manager
{
  private bezz jdField_a_of_type_Bezz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = true;
  
  public bezv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
    this.jdField_a_of_type_Bezz = ((bezz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(233));
    this.jdField_a_of_type_Bezz.b(this.jdField_a_of_type_Boolean);
  }
  
  public static String a(int paramInt, String paramString, boolean paramBoolean)
  {
    return bezz.a(paramInt, paramString, paramBoolean);
  }
  
  public static ArrayList<String> a(int paramInt1, int paramInt2)
  {
    return new ArrayList(5);
  }
  
  public bezs a(String paramString)
  {
    return this.jdField_a_of_type_Bezz.a(paramString);
  }
  
  void a(bezs parambezs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Controller", 2, "onTaskEnd: " + parambezs);
    }
    this.jdField_a_of_type_Bezz.a(parambezs);
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_Bezz.a(paramString, paramLong);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, bezs parambezs)
  {
    return this.jdField_a_of_type_Bezz.a(paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4, paramInt3, paramInt4, paramBoolean, parambezs);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bezv
 * JD-Core Version:    0.7.0.1
 */