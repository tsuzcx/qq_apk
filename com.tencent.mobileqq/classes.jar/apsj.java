import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class apsj
{
  private apsl jdField_a_of_type_Apsl;
  private apsm jdField_a_of_type_Apsm;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatMessage a;
  
  public apsj(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Apsl = apsl.a(paramQQAppInterface, paramChatMessage);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Apsl != null) {
      return this.jdField_a_of_type_Apsl.a();
    }
    return 0L;
  }
  
  public apsi a()
  {
    if (this.jdField_a_of_type_Apsl != null) {
      return this.jdField_a_of_type_Apsl.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Apsl != null) {
      return this.jdField_a_of_type_Apsl.b();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apsl != null) {}
    for (boolean bool = this.jdField_a_of_type_Apsl.a();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
        if (this.jdField_a_of_type_Apsm != null) {
          this.jdField_a_of_type_Apsm.a(false);
        }
      }
      return;
    }
  }
  
  public void a(apsm paramapsm)
  {
    this.jdField_a_of_type_Apsm = paramapsm;
    if (this.jdField_a_of_type_Apsl != null) {
      this.jdField_a_of_type_Apsl.a(this.jdField_a_of_type_Apsm);
    }
  }
  
  public void a(String paramString, apsk paramapsk)
  {
    if (!bbdj.b(paramString))
    {
      if (paramapsk != null) {
        paramapsk.a(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, paramapsk));
  }
  
  public boolean a()
  {
    return bbdj.b(b());
  }
  
  public String b()
  {
    String str = "";
    if (this.jdField_a_of_type_Apsl != null) {
      str = this.jdField_a_of_type_Apsl.a();
    }
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apsl != null) {}
    for (boolean bool = this.jdField_a_of_type_Apsl.b();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
        if (this.jdField_a_of_type_Apsm != null) {
          this.jdField_a_of_type_Apsm.b(false);
        }
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Apsl != null) {
      this.jdField_a_of_type_Apsl.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apsj
 * JD-Core Version:    0.7.0.1
 */