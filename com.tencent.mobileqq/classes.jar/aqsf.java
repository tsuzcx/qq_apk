import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.2;
import com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.3;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class aqsf
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, aqtb> jdField_a_of_type_JavaUtilHashMap;
  
  private aqsz a(String paramString, int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    if (paramLong <= 0L)
    {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "createUploadTask: multiMrUniseq is null");
      return null;
    }
    if (paramMessageRecord == null)
    {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "createUploadTask: file message record is null");
      return null;
    }
    aqsz localaqsz = new aqsz(this, paramLong, paramString, paramInt, paramMessageRecord);
    paramString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    if (a(paramString)) {
      if (paramInt == 0) {
        paramString = new aqsn(this, paramMessageRecord);
      }
    }
    for (;;)
    {
      label76:
      localaqsz.a = paramString;
      return localaqsz;
      if (paramInt == 3000)
      {
        paramString = new aqsw(this, paramMessageRecord);
      }
      else if (paramInt == 1)
      {
        paramString = new aqtg(this, paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName"), paramString, null);
      }
      else
      {
        do
        {
          try
          {
            i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType"));
            switch (i)
            {
            default: 
              paramString = null;
            }
          }
          catch (NumberFormatException paramString)
          {
            do
            {
              for (;;)
              {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
                int i = -1;
              }
              if (paramInt == 0)
              {
                paramString = new aqsh(this, paramMessageRecord);
                break;
              }
              if (paramInt == 3000)
              {
                paramString = new aqsj(this, paramMessageRecord);
                break;
              }
            } while (paramInt != 1);
            paramString = new aqsl(this, paramMessageRecord);
          }
          break;
          if (paramInt == 0)
          {
            paramString = new aqsq(this, paramMessageRecord);
            break;
          }
          if (paramInt == 3000)
          {
            paramString = new aqss(this, paramMessageRecord);
            break;
          }
        } while (paramInt != 1);
        paramString = new aqsu(this, paramMessageRecord);
      }
    }
    if (paramInt == 0) {
      paramInt = 3;
    }
    for (;;)
    {
      paramString = new aqte(this, paramMessageRecord, paramInt, null);
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
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new FileMultiMsgManager.2(this, paramLong));
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
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt, Bundle paramBundle)
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
    if (paramString == null)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, "filePath is null");
        bool2 = bool1;
      }
    }
    do
    {
      do
      {
        return bool2;
        if (arrr.b(paramString)) {
          break;
        }
        bool2 = bool1;
      } while (!QLog.isColorLevel());
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "file is not existed");
      return false;
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
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new FileMultiMsgManager.3(this, paramLong));
  }
  
  private static void b(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, String paramString, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, Bundle paramBundle, aqtc paramaqtc)
  {
    if (paramaqtc == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "sendFeeds but callback is null fileid " + paramString);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "sendFeeds will call reqFeeds fileid " + paramString);
    ytu.a(paramQQAppInterface, paramLong1, paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, paramBundle, new aqsg(paramString, paramaqtc, paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsf
 * JD-Core Version:    0.7.0.1
 */