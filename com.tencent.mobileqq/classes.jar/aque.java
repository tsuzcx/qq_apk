import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.1;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.2;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class aque
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, aqvb> jdField_a_of_type_JavaUtilHashMap;
  
  public aque(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private aquy a(String paramString1, int paramInt, String paramString2, MessageRecord paramMessageRecord)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "createUploadTask: forwardRequestSeq is null");
      return null;
    }
    if (paramMessageRecord == null)
    {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "createUploadTask: file message record is null");
      return null;
    }
    paramString2 = new aquy(this, paramString2, paramString1, paramInt, paramMessageRecord);
    paramString1 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    if (a(paramString1)) {
      if (paramInt == 0) {
        paramString1 = new aqum(this, paramMessageRecord);
      }
    }
    for (;;)
    {
      label76:
      paramString2.a = paramString1;
      return paramString2;
      if (paramInt == 3000)
      {
        paramString1 = new aquv(this, paramMessageRecord);
      }
      else if (paramInt == 1)
      {
        paramString1 = new aqvf(this, paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName"), paramString1, null);
      }
      else
      {
        do
        {
          do
          {
            try
            {
              int i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType"));
              switch (i)
              {
              default: 
                paramString1 = null;
              }
            }
            catch (NumberFormatException paramString1)
            {
              QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString1.toString());
              return null;
            }
            if (paramInt == 0)
            {
              paramString1 = new aqug(this, paramMessageRecord);
              break;
            }
            if (paramInt == 3000)
            {
              paramString1 = new aqui(this, paramMessageRecord);
              break;
            }
          } while (paramInt != 1);
          paramString1 = new aquk(this, paramMessageRecord);
          break;
          if (paramInt == 0)
          {
            paramString1 = new aqup(this, paramMessageRecord);
            break;
          }
          if (paramInt == 3000)
          {
            paramString1 = new aqur(this, paramMessageRecord);
            break;
          }
        } while (paramInt != 1);
        paramString1 = new aqut(this, paramMessageRecord);
      }
    }
    if (paramInt == 0) {
      paramInt = 3;
    }
    for (;;)
    {
      paramString1 = new aqvd(this, paramMessageRecord, paramInt, null);
      break label76;
      if (paramInt == 3000)
      {
        paramInt = 106;
      }
      else
      {
        if (paramInt != 1) {
          break;
        }
        paramInt = 102;
      }
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramMessageRecord.saveExtInfoToExtStr(str, paramBundle.getString(str));
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QFileMsgForwardManager.2(this, paramString));
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardLasSuccess");
    if (!TextUtils.isEmpty(paramMessageRecord))
    {
      long l = Long.parseLong(paramMessageRecord);
      if (ayzl.a() - l < 86400L) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bdhb.b(paramString))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, "filePath[" + paramString + "] file is not existed");
        bool2 = bool1;
      }
    }
    do
    {
      return bool2;
      bool1 = bool2;
      if (arrr.a(paramString) <= 10485760L) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "file is isSmall:" + bool1);
    return bool1;
  }
  
  private static String b(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      return BaseActivity.sTopActivity.app.getApplication().getResources().getString(2131692615);
    }
    if (paramLong > 10485760L) {
      return BaseActivity.sTopActivity.app.getApplication().getResources().getString(2131692617);
    }
    return BaseActivity.sTopActivity.app.getApplication().getResources().getString(2131692654);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, String paramString, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, Bundle paramBundle, aqva paramaqva)
  {
    if (paramaqva == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "sendFeeds but callback is null fileid " + paramString);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "sendFeeds will call reqFeeds fileid " + paramString);
    ytu.a(paramQQAppInterface, paramLong1, paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, paramBundle, new aquf(paramString, paramaqva, paramLong2));
  }
  
  private void b(MessageRecord paramMessageRecord, Bundle paramBundle)
  {
    if (paramMessageRecord == null)
    {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "updateFileMessageRecordWithUuid: MessageRecord is null.");
      return;
    }
    a(paramMessageRecord, paramBundle);
    paramMessageRecord.saveExtInfoToExtStr("_m_ForwardFileStatus", "1");
    paramMessageRecord.saveExtInfoToExtStr("_m_ForwardLasSuccess", String.valueOf(ayzl.a()));
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QFileMsgForwardManager.3(this, paramString));
  }
  
  public void a(arcj paramarcj, HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "addMultiFileUploadRequest: file message record list is null");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new QFileMsgForwardManager.1(this, paramarcj));
  }
  
  public void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (arsx.a(paramMessageRecord1)) {
      paramMessageRecord2.extStr = paramMessageRecord1.extStr;
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramMessageRecord1.getExtInfoFromExtStr("_m_ForwardFileType"));
        switch (i)
        {
        default: 
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardSenderUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileStatus", "4");
          paramMessageRecord2.removeExtInfoToExtStr("_m_ForwardFaildReason");
          paramMessageRecord2.removeExtInfoToExtStr("_m_ForwardLasSuccess");
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, localNumberFormatException.toString());
        int i = -1;
        continue;
        paramMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord1.uniseq, paramMessageRecord1.frienduin, paramMessageRecord1.istroop);
        if (paramMessageRecord1 == null) {
          continue;
        }
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", paramMessageRecord1.getFilePath());
        continue;
        paramMessageRecord1 = (MessageForTroopFile)arrr.a((ChatMessage)paramMessageRecord1);
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord1).a);
        continue;
      }
      Object localObject;
      if ((paramMessageRecord1 instanceof MessageForFile))
      {
        long l = paramMessageRecord1.uniseq;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, paramMessageRecord1.frienduin, paramMessageRecord1.istroop);
        if (localObject != null)
        {
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileName", ((FileManagerEntity)localObject).fileName);
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardSize", String.valueOf(((FileManagerEntity)localObject).fileSize));
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardUuid", ((FileManagerEntity)localObject).Uuid);
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardMd5", ((FileManagerEntity)localObject).strFileMd5);
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", ((FileManagerEntity)localObject).getFilePath());
          paramMessageRecord2.saveExtInfoToExtStr("_f_thumb_path_750_", ((FileManagerEntity)localObject).strLargeThumPath);
          paramMessageRecord2.saveExtInfoToExtStr("_f_thumb_path_384_", ((FileManagerEntity)localObject).strMiddleThumPath);
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(((FileManagerEntity)localObject).imgWidth));
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(((FileManagerEntity)localObject).imgHeight));
          if (((FileManagerEntity)localObject).peerType == 0)
          {
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardReceiverUin", ((FileManagerEntity)localObject).peerUin);
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "1");
          }
          for (;;)
          {
            if (((FileManagerEntity)localObject).status != 3) {
              break label439;
            }
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardStatusPaused", "1");
            break;
            if (((FileManagerEntity)localObject).peerType == 3000)
            {
              paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardReceiverUin", ((FileManagerEntity)localObject).peerUin);
              paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "2");
            }
            else if (((FileManagerEntity)localObject).peerType == 1)
            {
              paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "3");
            }
          }
        }
        else
        {
          label439:
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "cann't find Entity by msg:" + paramMessageRecord1.uniseq);
        }
      }
      else if ((paramMessageRecord1 instanceof MessageForTroopFile))
      {
        paramMessageRecord1 = (MessageForTroopFile)paramMessageRecord1;
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "3");
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardReceiverUin", paramMessageRecord1.frienduin);
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardSha", paramMessageRecord1.sha1);
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardSize", String.valueOf(paramMessageRecord1.fileSize));
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(paramMessageRecord1.width));
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(paramMessageRecord1.height));
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardDuration", String.valueOf(paramMessageRecord1.duration));
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardBusType", String.valueOf(paramMessageRecord1.bisID));
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardUuid", paramMessageRecord1.url);
        paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFileName", paramMessageRecord1.fileName);
        localObject = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord1);
        if (localObject != null)
        {
          paramMessageRecord2.saveExtInfoToExtStr("_f_thumb_path_750_", ((bbtn)localObject).c);
          paramMessageRecord2.saveExtInfoToExtStr("_f_thumb_path_384_", ((bbtn)localObject).d);
          if (((paramMessageRecord1.width == 0) || (paramMessageRecord1.height == 0)) && (((bbtn)localObject).e > 0) && (((bbtn)localObject).f > 0))
          {
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(paramMessageRecord1.width));
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(paramMessageRecord1.height));
          }
          paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", ((bbtn)localObject).a);
          if ((((bbtn)localObject).b == 2) || (((bbtn)localObject).b == 3)) {
            paramMessageRecord2.saveExtInfoToExtStr("_m_ForwardStatusPaused", "1");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aque
 * JD-Core Version:    0.7.0.1
 */