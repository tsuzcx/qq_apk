import android.os.Bundle;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.NewFileUploader.1;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;

public class aqtu
  implements aqxg, ared
{
  private long jdField_a_of_type_Long;
  private aqtv jdField_a_of_type_Aqtv;
  private aqxe jdField_a_of_type_Aqxe;
  private final VFSFile jdField_a_of_type_ComTencentMmVfsVFSFile;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = "NewFileUploader";
  private boolean jdField_a_of_type_Boolean = true;
  private long b = arrr.a().longValue();
  
  public aqtu(QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, aqtv paramaqtv)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMmVfsVFSFile = new VFSFile(paramString1);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Aqxe = aqxe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, 0, 0, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5);
    if (this.jdField_a_of_type_Aqxe != null) {
      this.jdField_a_of_type_Aqxe.a(this);
    }
    this.jdField_a_of_type_Aqtv = paramaqtv;
  }
  
  public int a()
  {
    return 41;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public FileManagerEntity a()
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(long paramLong) {}
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.i("FileMultiMsg", 1, "sendBuddyFile NotifyUIError:" + paramInt);
    this.jdField_a_of_type_Aqtv.a(false);
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    QLog.i("FileMultiMsg", 1, "sendBuddyFile onError bFinished[" + paramBoolean + "], errCode[" + paramInt + "], errMsg[" + paramString1 + "]");
    this.jdField_a_of_type_Aqtv.a(false);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a(Bundle paramBundle)
  {
    return null;
  }
  
  public void aA_()
  {
    this.jdField_a_of_type_Boolean = false;
    arsd.a().execute(new NewFileUploader.1(this));
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int c()
  {
    return 0;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.i("FileMultiMsg", 1, "sendBuddyFile networkBroken");
    this.jdField_a_of_type_Aqtv.a(false);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.i("FileMultiMsg", 1, "sendBuddyFile userCancel");
    this.jdField_a_of_type_Aqtv.a(false);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.i("FileMultiMsg", 1, "sendBuddyFile exceptBroken");
    this.jdField_a_of_type_Aqtv.a(false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aqtv.a(true);
    QLog.i("FileMultiMsg", 1, "sendBuddyFile upload onHit");
  }
  
  public void g()
  {
    this.jdField_a_of_type_Aqtv.a(true);
    QLog.i("FileMultiMsg", 1, "sendBuddyFile upload success");
  }
  
  public void h() {}
  
  public void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtu
 * JD-Core Version:    0.7.0.1
 */