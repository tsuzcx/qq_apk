import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.scribble.ScribbleDownloader.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public class aygj
  implements Handler.Callback, Manager
{
  protected Handler a;
  public aygk a;
  public QQAppInterface a;
  public String a;
  AtomicBoolean a;
  
  public aygj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "ScribbleDownloader";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_Aygk = new aygk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(aygi paramaygi)
  {
    int i = this.jdField_a_of_type_Aygk.a(paramaygi);
    a("addDownload", "result is " + i);
    d();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      paramString1 = new StringBuilder().append(paramString1).append("(): ").append(str);
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramString1.toString());
    }
  }
  
  private boolean a()
  {
    int i = awji.a();
    if (i != 0)
    {
      a("isNeedPreDownload", "Not Wifi, networkType=" + i + ", no need to predownload");
      return false;
    }
    return true;
  }
  
  private void b(aygi paramaygi)
  {
    ThreadManager.post(new ScribbleDownloader.1(this, paramaygi), 5, null, false);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Aygk.a() < 2)
    {
      aygi localaygi = this.jdField_a_of_type_Aygk.a();
      if (localaygi == null)
      {
        a("consumeDownload", "removeOneFromWaitToDowning is null");
        return;
      }
      b(localaygi);
      return;
    }
    a("consumeDownload", "donwloading is max threads");
  }
  
  public int a(MessageForScribble paramMessageForScribble)
  {
    int i = this.jdField_a_of_type_Aygk.a(paramMessageForScribble);
    a("removeDownloadedMsg", " result is " + i);
    d();
    return i;
  }
  
  public void a()
  {
    int i = 0;
    try
    {
      if (SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()).getHttpconn_sig_session() != null) {
        i = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()).getHttpconn_sig_session().length;
      }
      if (i == 0) {
        HwServlet.getConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      }
      return;
    }
    finally {}
  }
  
  public void a(MessageForScribble paramMessageForScribble)
  {
    a("PreDownloadFromMsg", "uniseq=" + paramMessageForScribble.uniseq);
    if (a())
    {
      a(new aygi(paramMessageForScribble, 200));
      return;
    }
    a("PreDownloadFromMsg", "no NeedPreDownload uniseq=" + paramMessageForScribble.uniseq);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    a("off", "mIsPreDownloaderOpen=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(111, 60000L);
  }
  
  public void b(MessageForScribble paramMessageForScribble)
  {
    a("DownloadFromAio", "uniseq=" + paramMessageForScribble.uniseq);
    a(new aygi(paramMessageForScribble, 201));
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    a("on", " mIsPreDownloaderOpen=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 111)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        a("handleMessage", "MSG_OPEN_PRE_DOWNLOADING, mIsPreDownloaderOpen=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    a("onDestroy", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygj
 * JD-Core Version:    0.7.0.1
 */