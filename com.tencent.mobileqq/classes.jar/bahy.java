import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloadStrategy;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PttDownExtraInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public final class bahy
  implements Handler.Callback, Manager
{
  private final bahz jdField_a_of_type_Bahz = new bahz();
  private baia jdField_a_of_type_Baia;
  private final bkys jdField_a_of_type_Bkys;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private final bahz jdField_b_of_type_Bahz = new bahz();
  private boolean jdField_b_of_type_Boolean;
  private final bahz c = new bahz();
  
  public bahy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bkys = new bkys(ThreadManager.getSubThreadLooper(), this);
    a(new PTTPreDownloadStrategy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bkys));
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt.url == null) {}
    int i;
    do
    {
      return 2005;
      if ((paramMessageForPtt.url.startsWith(AppConstants.SDCARD_ROOT)) && (FileUtils.fileExists(paramMessageForPtt.getLocalFilePath()))) {
        return 2003;
      }
      i = paramQQAppInterface.getTransFileController().findProcessorFileStatus(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
    } while ((i == -1) && (paramMessageForPtt.fileSize == -4L));
    return i;
  }
  
  public static bahy a(QQAppInterface paramQQAppInterface)
  {
    return (bahy)paramQQAppInterface.getManager(QQManagerFactory.PTT_PRE_DOWNLOAD_MANAGER);
  }
  
  private bahz a(MessageForPtt paramMessageForPtt)
  {
    bahz localbahz = null;
    if (paramMessageForPtt.istroop == 0) {
      localbahz = this.jdField_a_of_type_Bahz;
    }
    do
    {
      return localbahz;
      if (paramMessageForPtt.istroop == 1) {
        return this.jdField_b_of_type_Bahz;
      }
    } while (paramMessageForPtt.istroop != 3000);
    return this.c;
  }
  
  private void a(bahz parambahz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "cancelCache");
    }
    int i = 0;
    if (i < parambahz.jdField_a_of_type_JavaUtilArrayList.size())
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)parambahz.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_a_of_type_Baia.b(localMessageForPtt)) {
        if (localMessageForPtt.extFlag != -1L) {
          break label120;
        }
      }
      label120:
      for (long l = localMessageForPtt.extFlag;; l = (0x3 ^ 0xFFFFFFFF) & localMessageForPtt.extFlag)
      {
        localMessageForPtt.extFlag = l;
        localMessageForPtt.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
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
      a(this.jdField_a_of_type_Bahz);
      a(this.jdField_b_of_type_Bahz);
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
      this.jdField_a_of_type_Baia.b(paramMessageForPtt);
    }
    label129:
    while (((paramMessageForPtt.extFlag & 0x2) != 0L) || (!this.jdField_a_of_type_Baia.a(paramMessageForPtt, 3)))
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      break;
    }
  }
  
  private boolean a(bahz parambahz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTTPreDownloader", 2, "startDownloadCache");
    }
    boolean bool = false;
    for (;;)
    {
      if ((parambahz.jdField_a_of_type_Int < 3) && (parambahz.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        MessageForPtt localMessageForPtt = (MessageForPtt)parambahz.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (this.jdField_a_of_type_Baia.a(localMessageForPtt))
        {
          long l;
          if (!g(localMessageForPtt)) {
            if (this.jdField_a_of_type_Baia.b(localMessageForPtt))
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
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
            parambahz.jdField_a_of_type_JavaUtilArrayList.remove(0);
            for (bool = false;; bool = true)
            {
              break;
              label157:
              l = (0x3 ^ 0xFFFFFFFF) & localMessageForPtt.extFlag;
              break label102;
              parambahz.jdField_a_of_type_Int += 1;
              parambahz.jdField_a_of_type_JavaUtilArrayList.remove(0);
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
    if ((paramMessageForPtt.istroop == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramMessageForPtt.frienduin) != 1)) {}
    int i;
    bahz localbahz;
    label300:
    label365:
    do
    {
      for (;;)
      {
        return true;
        if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramMessageForPtt.frienduin))
        {
          i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
          if (QLog.isColorLevel()) {
            QLog.d("PTTPreDownloader", 2, "handleReceivedPTT uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq + ", status:" + i);
          }
          if ((i == 0) || (i == -1))
          {
            localbahz = a(paramMessageForPtt);
            if (localbahz != null)
            {
              if (!this.jdField_b_of_type_Boolean) {
                break;
              }
              long l;
              if ((localbahz.jdField_a_of_type_Int < 3) && (this.jdField_a_of_type_Baia.a(paramMessageForPtt))) {
                if (!g(paramMessageForPtt)) {
                  if (this.jdField_a_of_type_Baia.b(paramMessageForPtt))
                  {
                    if (paramMessageForPtt.extFlag != -1L) {
                      break label300;
                    }
                    l = paramMessageForPtt.extFlag;
                    paramMessageForPtt.extFlag = l;
                    paramMessageForPtt.serial();
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
                  }
                }
              }
              for (;;)
              {
                if (paramMessageForPtt.voiceChangeFlag != 1) {
                  break label365;
                }
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7D", 0, 0, "" + paramMessageForPtt.istroop, "", "", "");
                return true;
                l = (0x3 ^ 0xFFFFFFFF) & paramMessageForPtt.extFlag;
                break;
                localbahz.jdField_a_of_type_Int += 1;
                continue;
                i = localbahz.jdField_a_of_type_JavaUtilArrayList.size();
                localbahz.getClass();
                if (i + 1 < 99) {
                  localbahz.jdField_a_of_type_JavaUtilArrayList.add(paramMessageForPtt);
                }
              }
            }
          }
        }
      }
      i = localbahz.jdField_a_of_type_JavaUtilArrayList.size();
      localbahz.getClass();
    } while (i + 1 >= 99);
    localbahz.jdField_a_of_type_JavaUtilArrayList.add(paramMessageForPtt);
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
    if (this.jdField_a_of_type_Baia.a(paramMessageForPtt, 1)) {
      if (paramMessageForPtt.extFlag != -1L) {
        break label113;
      }
    }
    for (;;)
    {
      paramMessageForPtt.extFlag = l;
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
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
    TransferRequest localTransferRequest;
    if (i != 0)
    {
      bool1 = bool2;
      if (i != -1) {}
    }
    else
    {
      localTransferRequest = new TransferRequest();
      localTransferRequest.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localTransferRequest.mPeerUin = paramMessageForPtt.frienduin;
      localTransferRequest.mUinType = paramMessageForPtt.istroop;
      localTransferRequest.mFileType = 2;
      localTransferRequest.mUniseq = paramMessageForPtt.uniseq;
      localTransferRequest.mIsUp = false;
      localTransferRequest.mServerPath = paramMessageForPtt.urlAtServer;
      localTransferRequest.mOutFilePath = paramMessageForPtt.getLocalFilePath();
      if ((!paramMessageForPtt.isSendFromOtherTerminal()) && (!paramMessageForPtt.isSend())) {
        break label259;
      }
      bool1 = true;
    }
    for (;;)
    {
      localTransferRequest.mIsSelfSend = bool1;
      localTransferRequest.mMd5 = paramMessageForPtt.md5;
      localTransferRequest.mGroupFileID = paramMessageForPtt.groupFileID;
      localTransferRequest.mGroupFileKeyStr = paramMessageForPtt.groupFileKeyStr;
      localTransferRequest.mDbRecVersion = paramMessageForPtt.subVersion;
      localTransferRequest.mRec = paramMessageForPtt;
      localTransferRequest.mDownMode = 1;
      localTransferRequest.mExtraObj = new TransferRequest.PttDownExtraInfo(6, 0);
      try
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
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
  
  public void a(baia parambaia)
  {
    this.jdField_a_of_type_Baia = parambaia;
  }
  
  public void a(boolean paramBoolean, int paramInt, TransferRequest.PttDownExtraInfo paramPttDownExtraInfo, MessageForPtt paramMessageForPtt)
  {
    paramPttDownExtraInfo = this.jdField_a_of_type_Bkys;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramPttDownExtraInfo.obtainMessage(2, i, paramInt, paramMessageForPtt).sendToTarget();
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
      localObject = this.jdField_a_of_type_Bkys;
      if (paramBoolean1) {}
      for (;;)
      {
        localObject = ((bkys)localObject).obtainMessage(3, i, 0);
        this.jdField_a_of_type_Bkys.sendMessageDelayed((Message)localObject, 30000L);
        return;
        i = 0;
      }
    }
    this.jdField_a_of_type_Bkys.removeMessages(3);
    Object localObject = this.jdField_a_of_type_Bkys;
    if (paramBoolean1) {}
    for (i = j;; i = 0)
    {
      ((bkys)localObject).obtainMessage(3, i, 0).sendToTarget();
      return;
    }
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_Bkys.obtainMessage(0, paramMessageForPtt).sendToTarget();
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
      this.jdField_a_of_type_Bkys.obtainMessage(4, paramMessageForPtt).sendToTarget();
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
    this.jdField_a_of_type_Bkys.removeMessages(0);
    this.jdField_a_of_type_Bkys.removeMessages(1);
    this.jdField_a_of_type_Bkys.removeMessages(2);
    this.jdField_a_of_type_Bkys.removeMessages(3);
    this.jdField_a_of_type_Bkys.removeMessages(4);
    a(this.jdField_a_of_type_Bahz);
    a(this.jdField_b_of_type_Bahz);
    a(this.c);
    this.jdField_a_of_type_Baia.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahy
 * JD-Core Version:    0.7.0.1
 */