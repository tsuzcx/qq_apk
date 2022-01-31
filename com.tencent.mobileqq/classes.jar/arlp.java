import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class arlp
{
  private arlr jdField_a_of_type_Arlr;
  private arls jdField_a_of_type_Arls;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatMessage a;
  
  public arlp(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Arlr = arlr.a(paramQQAppInterface, paramChatMessage);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Arlr != null) {
      return this.jdField_a_of_type_Arlr.a();
    }
    return 0L;
  }
  
  public arlo a()
  {
    if (this.jdField_a_of_type_Arlr != null) {
      return this.jdField_a_of_type_Arlr.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Arlr != null) {
      return this.jdField_a_of_type_Arlr.b();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arlr != null) {}
    for (boolean bool = this.jdField_a_of_type_Arlr.a();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
        if (this.jdField_a_of_type_Arls != null) {
          this.jdField_a_of_type_Arls.a(false);
        }
      }
      return;
    }
  }
  
  public void a(arls paramarls)
  {
    this.jdField_a_of_type_Arls = paramarls;
    if (this.jdField_a_of_type_Arlr != null) {
      this.jdField_a_of_type_Arlr.a(this.jdField_a_of_type_Arls);
    }
  }
  
  public void a(String paramString, arlq paramarlq)
  {
    if (!bdcs.b(paramString))
    {
      if (paramarlq != null) {
        paramarlq.a(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, paramarlq));
  }
  
  public boolean a()
  {
    return bdcs.b(b());
  }
  
  public String b()
  {
    String str = "";
    if (this.jdField_a_of_type_Arlr != null) {
      str = this.jdField_a_of_type_Arlr.a();
    }
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Arlr != null) {}
    for (boolean bool = this.jdField_a_of_type_Arlr.b();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
        if (this.jdField_a_of_type_Arls != null) {
          this.jdField_a_of_type_Arls.b(false);
        }
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Arlr != null) {
      this.jdField_a_of_type_Arlr.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arlp
 * JD-Core Version:    0.7.0.1
 */