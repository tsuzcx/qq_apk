import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aulq
{
  private auls jdField_a_of_type_Auls;
  private ault jdField_a_of_type_Ault;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatMessage a;
  
  public aulq(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Auls = auls.a(paramQQAppInterface, paramChatMessage);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Auls != null) {
      return this.jdField_a_of_type_Auls.a();
    }
    return 0L;
  }
  
  public aulp a()
  {
    if (this.jdField_a_of_type_Auls != null) {
      return this.jdField_a_of_type_Auls.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Auls != null) {
      return this.jdField_a_of_type_Auls.b();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Auls != null) {}
    for (boolean bool = this.jdField_a_of_type_Auls.a();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
        if (this.jdField_a_of_type_Ault != null) {
          this.jdField_a_of_type_Ault.a(false);
        }
      }
      return;
    }
  }
  
  public void a(ault paramault)
  {
    this.jdField_a_of_type_Ault = paramault;
    if (this.jdField_a_of_type_Auls != null) {
      this.jdField_a_of_type_Auls.a(this.jdField_a_of_type_Ault);
    }
  }
  
  public void a(String paramString, aulr paramaulr)
  {
    if (!bhmi.b(paramString))
    {
      if (paramaulr != null) {
        paramaulr.a(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, paramaulr));
  }
  
  public boolean a()
  {
    return bhmi.b(b());
  }
  
  public String b()
  {
    String str = "";
    if (this.jdField_a_of_type_Auls != null) {
      str = this.jdField_a_of_type_Auls.a();
    }
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Auls != null) {}
    for (boolean bool = this.jdField_a_of_type_Auls.b();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
        if (this.jdField_a_of_type_Ault != null) {
          this.jdField_a_of_type_Ault.b(false);
        }
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Auls != null) {
      this.jdField_a_of_type_Auls.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aulq
 * JD-Core Version:    0.7.0.1
 */