import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class arpy
{
  private arqa jdField_a_of_type_Arqa;
  private arqb jdField_a_of_type_Arqb;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatMessage a;
  
  public arpy(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Arqa = arqa.a(paramQQAppInterface, paramChatMessage);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Arqa != null) {
      return this.jdField_a_of_type_Arqa.a();
    }
    return 0L;
  }
  
  public arpx a()
  {
    if (this.jdField_a_of_type_Arqa != null) {
      return this.jdField_a_of_type_Arqa.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Arqa != null) {
      return this.jdField_a_of_type_Arqa.b();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arqa != null) {}
    for (boolean bool = this.jdField_a_of_type_Arqa.a();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
        if (this.jdField_a_of_type_Arqb != null) {
          this.jdField_a_of_type_Arqb.a(false);
        }
      }
      return;
    }
  }
  
  public void a(arqb paramarqb)
  {
    this.jdField_a_of_type_Arqb = paramarqb;
    if (this.jdField_a_of_type_Arqa != null) {
      this.jdField_a_of_type_Arqa.a(this.jdField_a_of_type_Arqb);
    }
  }
  
  public void a(String paramString, arpz paramarpz)
  {
    if (!bdhb.b(paramString))
    {
      if (paramarpz != null) {
        paramarpz.a(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, paramarpz));
  }
  
  public boolean a()
  {
    return bdhb.b(b());
  }
  
  public String b()
  {
    String str = "";
    if (this.jdField_a_of_type_Arqa != null) {
      str = this.jdField_a_of_type_Arqa.a();
    }
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Arqa != null) {}
    for (boolean bool = this.jdField_a_of_type_Arqa.b();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
        if (this.jdField_a_of_type_Arqb != null) {
          this.jdField_a_of_type_Arqb.b(false);
        }
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Arqa != null) {
      this.jdField_a_of_type_Arqa.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arpy
 * JD-Core Version:    0.7.0.1
 */