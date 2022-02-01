import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class attv
{
  private attx jdField_a_of_type_Attx;
  private atty jdField_a_of_type_Atty;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatMessage a;
  
  public attv(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Attx = attx.a(paramQQAppInterface, paramChatMessage);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Attx != null) {
      return this.jdField_a_of_type_Attx.a();
    }
    return 0L;
  }
  
  public attu a()
  {
    if (this.jdField_a_of_type_Attx != null) {
      return this.jdField_a_of_type_Attx.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Attx != null) {
      return this.jdField_a_of_type_Attx.b();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Attx != null) {}
    for (boolean bool = this.jdField_a_of_type_Attx.a();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
        if (this.jdField_a_of_type_Atty != null) {
          this.jdField_a_of_type_Atty.a(false);
        }
      }
      return;
    }
  }
  
  public void a(atty paramatty)
  {
    this.jdField_a_of_type_Atty = paramatty;
    if (this.jdField_a_of_type_Attx != null) {
      this.jdField_a_of_type_Attx.a(this.jdField_a_of_type_Atty);
    }
  }
  
  public void a(String paramString, attw paramattw)
  {
    if (!bgmg.b(paramString))
    {
      if (paramattw != null) {
        paramattw.a(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, paramattw));
  }
  
  public boolean a()
  {
    return bgmg.b(b());
  }
  
  public String b()
  {
    String str = "";
    if (this.jdField_a_of_type_Attx != null) {
      str = this.jdField_a_of_type_Attx.a();
    }
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Attx != null) {}
    for (boolean bool = this.jdField_a_of_type_Attx.b();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
        if (this.jdField_a_of_type_Atty != null) {
          this.jdField_a_of_type_Atty.b(false);
        }
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Attx != null) {
      this.jdField_a_of_type_Attx.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attv
 * JD-Core Version:    0.7.0.1
 */