import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.NewDiscFileUploader.2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;

public class aqtr
  implements ared
{
  long jdField_a_of_type_Long = arrr.a().longValue();
  aqtt jdField_a_of_type_Aqtt;
  ardy jdField_a_of_type_Ardy = new ardy();
  public ardz a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = true;
  long b;
  
  public aqtr(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, int paramInt2, String paramString5, String paramString6, aqtt paramaqtt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aqtt = paramaqtt;
    this.b = paramLong;
    paramQQAppInterface = new areb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actDiscussFileUp");
    this.jdField_a_of_type_Ardy.a(paramString1, paramString2, paramLong, new aqts(this, paramaqtt));
    this.jdField_a_of_type_Ardz = new ardz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramQQAppInterface, paramString3, paramInt1, paramString5, this.jdField_a_of_type_Long, this.jdField_a_of_type_Ardy, paramBoolean, paramString4, paramString6);
  }
  
  public int a()
  {
    return 41;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public FileManagerEntity a()
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild errCode" + paramInt);
    this.jdField_a_of_type_Aqtt.a(false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void aA_()
  {
    this.jdField_a_of_type_Boolean = false;
    arsd.a().execute(new NewDiscFileUploader.2(this));
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.e("FileMultiMsg", 1, "sendDiscFile faild:clearTask");
      this.jdField_a_of_type_Aqtt.a(false);
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild:networkBroken");
    this.jdField_a_of_type_Aqtt.a(false);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild:userCancel");
    this.jdField_a_of_type_Aqtt.a(false);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild:exceptBroken");
    this.jdField_a_of_type_Aqtt.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtr
 * JD-Core Version:    0.7.0.1
 */