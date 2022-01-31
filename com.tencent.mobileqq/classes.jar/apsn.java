import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class apsn
{
  private apsp jdField_a_of_type_Apsp;
  private apsq jdField_a_of_type_Apsq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatMessage a;
  
  public apsn(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Apsp = apsp.a(paramQQAppInterface, paramChatMessage);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Apsp != null) {
      return this.jdField_a_of_type_Apsp.a();
    }
    return 0L;
  }
  
  public apsm a()
  {
    if (this.jdField_a_of_type_Apsp != null) {
      return this.jdField_a_of_type_Apsp.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Apsp != null) {
      return this.jdField_a_of_type_Apsp.b();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apsp != null) {}
    for (boolean bool = this.jdField_a_of_type_Apsp.a();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
        if (this.jdField_a_of_type_Apsq != null) {
          this.jdField_a_of_type_Apsq.a(false);
        }
      }
      return;
    }
  }
  
  public void a(apsq paramapsq)
  {
    this.jdField_a_of_type_Apsq = paramapsq;
    if (this.jdField_a_of_type_Apsp != null) {
      this.jdField_a_of_type_Apsp.a(this.jdField_a_of_type_Apsq);
    }
  }
  
  public void a(String paramString, apso paramapso)
  {
    if (!bbdx.b(paramString))
    {
      if (paramapso != null) {
        paramapso.a(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, paramapso));
  }
  
  public boolean a()
  {
    return bbdx.b(b());
  }
  
  public String b()
  {
    String str = "";
    if (this.jdField_a_of_type_Apsp != null) {
      str = this.jdField_a_of_type_Apsp.a();
    }
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Apsp != null) {}
    for (boolean bool = this.jdField_a_of_type_Apsp.b();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
        if (this.jdField_a_of_type_Apsq != null) {
          this.jdField_a_of_type_Apsq.b(false);
        }
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Apsp != null) {
      this.jdField_a_of_type_Apsp.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apsn
 * JD-Core Version:    0.7.0.1
 */