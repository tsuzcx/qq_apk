import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class auch
{
  private aucj jdField_a_of_type_Aucj;
  private auck jdField_a_of_type_Auck;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatMessage a;
  
  public auch(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Aucj = aucj.a(paramQQAppInterface, paramChatMessage);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Aucj != null) {
      return this.jdField_a_of_type_Aucj.a();
    }
    return 0L;
  }
  
  public aucg a()
  {
    if (this.jdField_a_of_type_Aucj != null) {
      return this.jdField_a_of_type_Aucj.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Aucj != null) {
      return this.jdField_a_of_type_Aucj.b();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aucj != null) {}
    for (boolean bool = this.jdField_a_of_type_Aucj.a();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
        if (this.jdField_a_of_type_Auck != null) {
          this.jdField_a_of_type_Auck.a(false);
        }
      }
      return;
    }
  }
  
  public void a(auck paramauck)
  {
    this.jdField_a_of_type_Auck = paramauck;
    if (this.jdField_a_of_type_Aucj != null) {
      this.jdField_a_of_type_Aucj.a(this.jdField_a_of_type_Auck);
    }
  }
  
  public void a(String paramString, auci paramauci)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      if (paramauci != null) {
        paramauci.a(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, paramauci));
  }
  
  public boolean a()
  {
    return FileUtils.fileExistsAndNotEmpty(b());
  }
  
  public String b()
  {
    String str = "";
    if (this.jdField_a_of_type_Aucj != null) {
      str = this.jdField_a_of_type_Aucj.a();
    }
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aucj != null) {}
    for (boolean bool = this.jdField_a_of_type_Aucj.b();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
        if (this.jdField_a_of_type_Auck != null) {
          this.jdField_a_of_type_Auck.b(false);
        }
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aucj != null) {
      this.jdField_a_of_type_Aucj.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auch
 * JD-Core Version:    0.7.0.1
 */