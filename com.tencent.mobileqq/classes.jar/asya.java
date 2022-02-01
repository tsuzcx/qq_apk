import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class asya
{
  private asyc jdField_a_of_type_Asyc;
  private asyd jdField_a_of_type_Asyd;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatMessage a;
  
  public asya(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_Asyc = asyc.a(paramQQAppInterface, paramChatMessage);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Asyc != null) {
      return this.jdField_a_of_type_Asyc.a();
    }
    return 0L;
  }
  
  public asxz a()
  {
    if (this.jdField_a_of_type_Asyc != null) {
      return this.jdField_a_of_type_Asyc.a();
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Asyc != null) {
      return this.jdField_a_of_type_Asyc.b();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asyc != null) {}
    for (boolean bool = this.jdField_a_of_type_Asyc.a();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileDownload: start fail");
        if (this.jdField_a_of_type_Asyd != null) {
          this.jdField_a_of_type_Asyd.a(false);
        }
      }
      return;
    }
  }
  
  public void a(asyd paramasyd)
  {
    this.jdField_a_of_type_Asyd = paramasyd;
    if (this.jdField_a_of_type_Asyc != null) {
      this.jdField_a_of_type_Asyc.a(this.jdField_a_of_type_Asyd);
    }
  }
  
  public void a(String paramString, asyb paramasyb)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      if (paramasyb != null) {
        paramasyb.a(-1, "file is not exist");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QFileMultiSaveReq.1(this, paramString, paramasyb));
  }
  
  public boolean a()
  {
    return FileUtils.fileExistsAndNotEmpty(b());
  }
  
  public String b()
  {
    String str = "";
    if (this.jdField_a_of_type_Asyc != null) {
      str = this.jdField_a_of_type_Asyc.a();
    }
    return str;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Asyc != null) {}
    for (boolean bool = this.jdField_a_of_type_Asyc.b();; bool = false)
    {
      if (!bool)
      {
        QLog.i("QFileMultiSaveReq<QFile>", 1, "doFileStopDownload: pause fail");
        if (this.jdField_a_of_type_Asyd != null) {
          this.jdField_a_of_type_Asyd.b(false);
        }
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Asyc != null) {
      this.jdField_a_of_type_Asyc.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asya
 * JD-Core Version:    0.7.0.1
 */