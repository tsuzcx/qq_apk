import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloadStrategy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public final class awyf
  implements Handler.Callback, Manager
{
  private final awyg jdField_a_of_type_Awyg = new awyg();
  private awyh jdField_a_of_type_Awyh;
  private final bhtd jdField_a_of_type_Bhtd;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private final awyg jdField_b_of_type_Awyg = new awyg();
  private boolean jdField_b_of_type_Boolean;
  private final awyg c = new awyg();
  
  public awyf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bhtd = new bhtd(ThreadManager.getSubThreadLooper(), this);
    a(new PTTPreDownloadStrategy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bhtd));
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt.url == null) {}
    int i;
    do
    {
      return 2005;
      if ((paramMessageForPtt.url.startsWith(alof.aW)) && (bdhb.a(paramMessageForPtt.getLocalFilePath()))) {
        return 2003;
      }
      i = paramQQAppInterface.a().b(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
    } while ((i == -1) && (paramMessageForPtt.fileSize == -4L));
    return i;
  }
  
  public static awyf a(QQAppInterface paramQQAppInterface)
  {
    return (awyf)paramQQAppInterface.getManager(127);
  }
  
  private awyg a(MessageForPtt paramMessageForPtt)
  {
    awyg localawyg = null;
    if (paramMessageForPtt.istroop == 0) {
      localawyg = this.jdField_a_of_type_Awyg;
    }
    do
    {
      return localawyg;
      if (paramMessageForPtt.istroop == 1) {
        return this.jdField_b_of_type_Awyg;
      }
    } while (paramMessageForPtt.istroop != 3000);
    return this.c;
  }
  
  private void a(awyg paramawyg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "cancelCache");
    }
    int i = 0;
    if (i < paramawyg.jdField_a_of_type_JavaUtilArrayList.size())
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)paramawyg.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_a_of_type_Awyh.b(localMessageForPtt)) {
        if (localMessageForPtt.extFlag != -1L) {
          break label120;
        }
      }
      label120:
      for (long l = localMessageForPtt.extFlag;; l = (0x3 ^ 0xFFFFFFFF) & localMessageForPtt.extFlag)
      {
        localMessageForPtt.extFlag = l;
        localMessageForPtt.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
        i += 1;
        break;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "handleAddrReady:" + paramBoolean);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      a(this.jdField_a_of_type_Awyg);
      a(this.jdField_b_of_type_Awyg);
      a(this.c);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, MessageForPtt paramMessageForPtt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "handleDownloadFinish uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq + ", sucess:" + paramBoolean);
    }
    if ((paramMessageForPtt.extFlag > 0L) && ((paramMessageForPtt.extFlag & 1L) > 0L))
    {
      if (!paramBoolean) {
        break label129;
      }
      this.jdField_a_of_type_Awyh.b(paramMessageForPtt);
    }
    label129:
    while (((paramMessageForPtt.extFlag & 0x2) != 0L) || (!this.jdField_a_of_type_Awyh.a(paramMessageForPtt, 3)))
    {
      paramMessageForPtt = a(paramMessageForPtt);
      if (paramMessageForPtt != null)
      {
        paramMessageForPtt.jdField_a_of_type_Int -= 1;
        if (paramMessageForPtt.jdField_a_of_type_Int < 0) {
          paramMessageForPtt.jdField_a_of_type_Int = 0;
        }
        a(paramMessageForPtt);
      }
      return;
    }
    if (paramMessageForPtt.extFlag == -1L) {}
    for (long l = paramMessageForPtt.extFlag;; l = (0x3 ^ 0xFFFFFFFF) & paramMessageForPtt.extFlag)
    {
      paramMessageForPtt.extFlag = l;
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      break;
    }
  }
  
  private boolean a(awyg paramawyg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "startDownloadCache");
    }
    boolean bool = false;
    for (;;)
    {
      if ((paramawyg.jdField_a_of_type_Int < 3) && (paramawyg.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        MessageForPtt localMessageForPtt = (MessageForPtt)paramawyg.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (this.jdField_a_of_type_Awyh.a(localMessageForPtt))
        {
          long l;
          if (!g(localMessageForPtt)) {
            if (this.jdField_a_of_type_Awyh.b(localMessageForPtt))
            {
              if (localMessageForPtt.extFlag != -1L) {
                break label157;
              }
              l = localMessageForPtt.extFlag;
              label102:
              localMessageForPtt.extFlag = l;
            }
          }
          try
          {
            localMessageForPtt.serial();
            label113:
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
            paramawyg.jdField_a_of_type_JavaUtilArrayList.remove(0);
            for (bool = false;; bool = true)
            {
              break;
              label157:
              l = (0x3 ^ 0xFFFFFFFF) & localMessageForPtt.extFlag;
              break label102;
              paramawyg.jdField_a_of_type_Int += 1;
              paramawyg.jdField_a_of_type_JavaUtilArrayList.remove(0);
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            break label113;
          }
        }
      }
    }
    return bool;
  }
  
  private boolean d(MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt.istroop == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramMessageForPtt.frienduin) != 1)) {}
    int i;
    awyg localawyg;
    label290:
    label355:
    do
    {
      for (;;)
      {
        return true;
        if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(paramMessageForPtt.frienduin))
        {
          i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
          if (QLog.isColorLevel()) {
            QLog.d("PTTPreDownloader", 2, "handleReceivedPTT uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq + ", status:" + i);
          }
          if ((i == 0) || (i == -1))
          {
            localawyg = a(paramMessageForPtt);
            if (localawyg != null)
            {
              if (!this.jdField_b_of_type_Boolean) {
                break;
              }
              long l;
              if ((localawyg.jdField_a_of_type_Int < 3) && (this.jdField_a_of_type_Awyh.a(paramMessageForPtt))) {
                if (!g(paramMessageForPtt)) {
                  if (this.jdField_a_of_type_Awyh.b(paramMessageForPtt))
                  {
                    if (paramMessageForPtt.extFlag != -1L) {
                      break label290;
                    }
                    l = paramMessageForPtt.extFlag;
                    paramMessageForPtt.extFlag = l;
                    paramMessageForPtt.serial();
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
                  }
                }
              }
              for (;;)
              {
                if (paramMessageForPtt.voiceChangeFlag != 1) {
                  break label355;
                }
                azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7D", 0, 0, "" + paramMessageForPtt.istroop, "", "", "");
                return true;
                l = (0x3 ^ 0xFFFFFFFF) & paramMessageForPtt.extFlag;
                break;
                localawyg.jdField_a_of_type_Int += 1;
                continue;
                i = localawyg.jdField_a_of_type_JavaUtilArrayList.size();
                localawyg.getClass();
                if (i + 1 < 99) {
                  localawyg.jdField_a_of_type_JavaUtilArrayList.add(paramMessageForPtt);
                }
              }
            }
          }
        }
      }
      i = localawyg.jdField_a_of_type_JavaUtilArrayList.size();
      localawyg.getClass();
    } while (i + 1 >= 99);
    localawyg.jdField_a_of_type_JavaUtilArrayList.add(paramMessageForPtt);
    return true;
  }
  
  private boolean e(MessageForPtt paramMessageForPtt)
  {
    return true;
  }
  
  private boolean f(MessageForPtt paramMessageForPtt)
  {
    long l = 2L;
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "handleViewPTT uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq);
    }
    if (this.jdField_a_of_type_Awyh.a(paramMessageForPtt, 1)) {
      if (paramMessageForPtt.extFlag != -1L) {
        break label113;
      }
    }
    for (;;)
    {
      paramMessageForPtt.extFlag = l;
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      return true;
      label113:
      l = 0x2 | paramMessageForPtt.extFlag;
    }
  }
  
  private boolean g(MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = false;
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
    boolean bool1;
    bayk localbayk;
    if (i != 0)
    {
      bool1 = bool2;
      if (i != -1) {}
    }
    else
    {
      localbayk = new bayk();
      localbayk.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localbayk.jdField_c_of_type_JavaLangString = paramMessageForPtt.frienduin;
      localbayk.jdField_a_of_type_Int = paramMessageForPtt.istroop;
      localbayk.jdField_b_of_type_Int = 2;
      localbayk.jdField_a_of_type_Long = paramMessageForPtt.uniseq;
      localbayk.jdField_a_of_type_Boolean = false;
      localbayk.e = paramMessageForPtt.urlAtServer;
      localbayk.h = paramMessageForPtt.getLocalFilePath();
      if ((!paramMessageForPtt.isSendFromOtherTerminal()) && (!paramMessageForPtt.isSend())) {
        break label259;
      }
      bool1 = true;
    }
    for (;;)
    {
      localbayk.jdField_b_of_type_Boolean = bool1;
      localbayk.f = paramMessageForPtt.md5;
      localbayk.jdField_c_of_type_Long = paramMessageForPtt.groupFileID;
      localbayk.jdField_g_of_type_JavaLangString = paramMessageForPtt.groupFileKeyStr;
      localbayk.d = paramMessageForPtt.subVersion;
      localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForPtt;
      localbayk.jdField_g_of_type_Int = 1;
      localbayk.jdField_a_of_type_JavaLangObject = new bayp(6, 0);
      try
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbayk);
        if (QLog.isDevelopLevel()) {
          QLog.d("PTTPreDownloader", 4, "startDownload uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq + ", doIt:" + bool1);
        }
        return bool1;
        label259:
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("PTTPreDownloader", 2, "startDownload  exception=" + localException.getMessage());
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  public void a(awyh paramawyh)
  {
    this.jdField_a_of_type_Awyh = paramawyh;
  }
  
  public void a(boolean paramBoolean, int paramInt, bayp parambayp, MessageForPtt paramMessageForPtt)
  {
    parambayp = this.jdField_a_of_type_Bhtd;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      parambayp.obtainMessage(2, i, paramInt, paramMessageForPtt).sendToTarget();
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    if (!paramBoolean1) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "onAddrProviderReady delay:" + paramBoolean2);
    }
    if (paramBoolean2)
    {
      localObject = this.jdField_a_of_type_Bhtd;
      if (paramBoolean1) {}
      for (;;)
      {
        localObject = ((bhtd)localObject).obtainMessage(3, i, 0);
        this.jdField_a_of_type_Bhtd.sendMessageDelayed((Message)localObject, 30000L);
        return;
        i = 0;
      }
    }
    this.jdField_a_of_type_Bhtd.removeMessages(3);
    Object localObject = this.jdField_a_of_type_Bhtd;
    if (paramBoolean1) {}
    for (i = j;; i = 0)
    {
      ((bhtd)localObject).obtainMessage(3, i, 0).sendToTarget();
      return;
    }
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_Bhtd.obtainMessage(0, paramMessageForPtt).sendToTarget();
    return true;
  }
  
  public boolean b(MessageForPtt paramMessageForPtt)
  {
    long l = 2L;
    int j = 0;
    int i;
    if (paramMessageForPtt.isSendFromLocal()) {
      i = j;
    }
    while (i == 0)
    {
      return true;
      i = j;
      if (paramMessageForPtt.getPttStreamFlag() != 10001)
      {
        i = j;
        if (paramMessageForPtt.extFlag != -1L)
        {
          i = j;
          if ((paramMessageForPtt.extFlag & 0x2) <= 0L)
          {
            i = j;
            if (paramMessageForPtt.fileSize > 0L) {
              i = 1;
            }
          }
        }
      }
    }
    if (paramMessageForPtt.extFlag == -1L) {}
    for (;;)
    {
      paramMessageForPtt.extFlag = l;
      this.jdField_a_of_type_Bhtd.obtainMessage(4, paramMessageForPtt).sendToTarget();
      return true;
      l = 0x2 | paramMessageForPtt.extFlag;
    }
  }
  
  public boolean c(MessageForPtt paramMessageForPtt)
  {
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      d((MessageForPtt)paramMessage.obj);
      return true;
    case 1: 
      e((MessageForPtt)paramMessage.obj);
      return true;
    case 3: 
      if (paramMessage.arg1 != 0) {
        bool = true;
      }
      a(bool);
      return true;
    case 2: 
      if (paramMessage.arg1 != 0) {}
      for (bool = true;; bool = false)
      {
        a(bool, paramMessage.arg2, (MessageForPtt)paramMessage.obj);
        return true;
      }
    }
    f((MessageForPtt)paramMessage.obj);
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bhtd.removeMessages(0);
    this.jdField_a_of_type_Bhtd.removeMessages(1);
    this.jdField_a_of_type_Bhtd.removeMessages(2);
    this.jdField_a_of_type_Bhtd.removeMessages(3);
    this.jdField_a_of_type_Bhtd.removeMessages(4);
    a(this.jdField_a_of_type_Awyg);
    a(this.jdField_b_of_type_Awyg);
    a(this.c);
    this.jdField_a_of_type_Awyh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awyf
 * JD-Core Version:    0.7.0.1
 */