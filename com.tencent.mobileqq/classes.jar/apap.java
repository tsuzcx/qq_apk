import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class apap
{
  private apar jdField_a_of_type_Apar;
  private apas jdField_a_of_type_Apas;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatMessage a;
  
  public apap(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Apar = apar.a(paramQQAppInterface, paramChatMessage);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Apar != null) {
      return this.jdField_a_of_type_Apar.a();
    }
    return 0L;
  }
  
  public apao a()
  {
    if (this.jdField_a_of_type_Apar != null) {
      return this.jdField_a_of_type_Apar.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Apar != null) {
      return this.jdField_a_of_type_Apar.b();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apar != null) {}
    for (boolean bool = this.jdField_a_of_type_Apar.a();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
        if (this.jdField_a_of_type_Apas != null) {
          this.jdField_a_of_type_Apas.a(false);
        }
      }
      return;
    }
  }
  
  public void a(apas paramapas)
  {
    this.jdField_a_of_type_Apas = paramapas;
    if (this.jdField_a_of_type_Apar != null) {
      this.jdField_a_of_type_Apar.a(this.jdField_a_of_type_Apas);
    }
  }
  
  public void a(String paramString, apaq paramapaq)
  {
    if (!bace.b(paramString))
    {
      if (paramapaq != null) {
        paramapaq.a(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, paramapaq));
  }
  
  public boolean a()
  {
    return bace.b(b());
  }
  
  public String b()
  {
    String str = "";
    if (this.jdField_a_of_type_Apar != null) {
      str = this.jdField_a_of_type_Apar.a();
    }
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apar != null) {}
    for (boolean bool = this.jdField_a_of_type_Apar.b();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
        if (this.jdField_a_of_type_Apas != null) {
          this.jdField_a_of_type_Apas.b(false);
        }
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Apar != null) {
      this.jdField_a_of_type_Apar.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apap
 * JD-Core Version:    0.7.0.1
 */