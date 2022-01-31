import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class aprp
  extends apro
{
  public aprp(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramFileManagerEntity = "";
    }
    String str;
    do
    {
      return paramFileManagerEntity;
      str = apti.a().d();
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      str = str + a(paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, paramInt);
      if (!a(paramString, str)) {
        break;
      }
      paramFileManagerEntity = str;
    } while (!QLog.isColorLevel());
    QLog.i("OfflineFileMsgBackupHandler<QFile>", 4, "getThumbSavePath. thumbPath[" + str + "]");
    return str;
    QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "getThumbSavePath. move file failed.");
    return "";
  }
  
  private String a(String paramString1, String paramString2, int paramInt)
  {
    String str2 = apti.a().d();
    String str1 = apvk.a(paramInt, bfkp.a(paramString1));
    paramString1 = str1;
    if (!apvb.b(str2 + str1))
    {
      paramString1 = str1;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = apvk.a(paramInt, bfkp.a(paramString2));
      }
    }
    return paramString1;
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("md5"))
        {
          paramFileManagerEntity.strFileMd5 = paramString.getString("md5");
          return;
        }
        if (paramString.has("md510"))
        {
          paramFileManagerEntity.str10Md5 = paramString.getString("md510");
          return;
        }
      }
      catch (JSONException paramFileManagerEntity) {}
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    Object localObject1 = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardUuid");
    if (paramMessageRecord.isMultiMsg) {
      localObject1 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      a("OfflineFileMsgBackupHandler<QFile>", "updateOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "error. file id is null.");
      return false;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e((String)localObject1);
    if (localObject2 == null) {}
    for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1);; localObject1 = localObject2)
    {
      if (localObject1 != null)
      {
        if (paramMessageRecord.isMultiMsg)
        {
          ((FileManagerEntity)localObject1).uniseq = paramMessageRecord.uniseq;
          ((FileManagerEntity)localObject1).status = -1;
          if ((paramList != null) && (!paramList.isEmpty())) {
            paramList = paramList.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!paramList.hasNext()) {
              break label492;
            }
            localObject2 = (MsgBackupResEntity)paramList.next();
            if ((a((MsgBackupResEntity)localObject2)) && (b(paramMessageRecord, (MsgBackupResEntity)localObject2)))
            {
              String str = a((MsgBackupResEntity)localObject2);
              if (!TextUtils.isEmpty(str))
              {
                if (((MsgBackupResEntity)localObject2).msgSubType == 12)
                {
                  if (bbdj.b(((FileManagerEntity)localObject1).strLargeThumPath)) {
                    continue;
                  }
                  localObject2 = a((FileManagerEntity)localObject1, 7, str);
                  if ((bbdj.b(((FileManagerEntity)localObject1).strLargeThumPath)) || (!bbdj.b((String)localObject2))) {
                    continue;
                  }
                  ((FileManagerEntity)localObject1).strLargeThumPath = ((String)localObject2);
                  a("OfflineFileMsgBackupHandler<QFile>", "updateOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "update large thumb path. path[" + (String)localObject2 + "]");
                  continue;
                  if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.shmsgseq, paramMessageRecord.msgtype) != null) {
                    break;
                  }
                  a("OfflineFileMsgBackupHandler<QFile>", "updateOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "old msg is not exist create bind. uniseq[" + paramMessageRecord.uniseq + "]");
                  ((FileManagerEntity)localObject1).uniseq = paramMessageRecord.uniseq;
                  break;
                }
                if ((((MsgBackupResEntity)localObject2).msgSubType == 11) && (!bbdj.b(((FileManagerEntity)localObject1).strFilePath)))
                {
                  str = a(str, ((FileManagerEntity)localObject1).fileName);
                  if (bbdj.b(str))
                  {
                    ((FileManagerEntity)localObject1).setFilePath(str);
                    ((FileManagerEntity)localObject1).status = 1;
                    a((FileManagerEntity)localObject1, ((MsgBackupResEntity)localObject2).extraDataStr);
                    b((FileManagerEntity)localObject1, ((MsgBackupResEntity)localObject2).extraDataStr);
                    a("OfflineFileMsgBackupHandler<QFile>", "updateOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "update origin file path. path[" + str + "]");
                  }
                  else
                  {
                    a("OfflineFileMsgBackupHandler<QFile>", "updateOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "recover origin file path error. back up file path is null");
                  }
                }
              }
            }
          }
        }
        label492:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((FileManagerEntity)localObject1);
        return true;
      }
      return false;
    }
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("sha"))
        {
          paramFileManagerEntity.strFileSHA = paramString.getString("sha");
          return;
        }
        if (paramString.has("sha3"))
        {
          paramFileManagerEntity.strFileSha3 = paramString.getString("sha3");
          return;
        }
      }
      catch (JSONException paramFileManagerEntity) {}
    }
  }
  
  private void c(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    a("OfflineFileMsgBackupHandler<QFile>", "createOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "fileInfo[" + paramMessageRecord.getExtInfoString() + "]");
    FileManagerEntity localFileManagerEntity;
    if (paramMessageRecord.isMultiMsg)
    {
      a("OfflineFileMsgBackupHandler<QFile>", "createOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "create multi file info.");
      localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)paramMessageRecord);
    }
    for (;;)
    {
      label139:
      Object localObject;
      String str;
      if (localFileManagerEntity != null)
      {
        localFileManagerEntity.status = -1;
        if (TextUtils.isEmpty(localFileManagerEntity.Uuid)) {
          localFileManagerEntity.status = 16;
        }
        localFileManagerEntity.srvTime = (paramMessageRecord.time * 1000L);
        if ((paramList != null) && (!paramList.isEmpty()))
        {
          paramList = paramList.iterator();
          for (;;)
          {
            if (paramList.hasNext())
            {
              localObject = (MsgBackupResEntity)paramList.next();
              if ((a((MsgBackupResEntity)localObject)) && (b(paramMessageRecord, (MsgBackupResEntity)localObject)))
              {
                str = a((MsgBackupResEntity)localObject);
                if (!TextUtils.isEmpty(str)) {
                  if (((MsgBackupResEntity)localObject).msgSubType == 12)
                  {
                    localObject = a(localFileManagerEntity, 7, str);
                    if (!bbdj.b((String)localObject)) {
                      continue;
                    }
                    localFileManagerEntity.strLargeThumPath = ((String)localObject);
                    a("OfflineFileMsgBackupHandler<QFile>", "createOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "save large thumb path. path[" + (String)localObject + "]");
                    continue;
                    a("OfflineFileMsgBackupHandler<QFile>", "createOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "create normal file info.");
                    localFileManagerEntity = new FileManagerEntity();
                    localFileManagerEntity.nSessionId = apue.a().longValue();
                    localFileManagerEntity.uniseq = paramMessageRecord.uniseq;
                    localFileManagerEntity.selfUin = paramMessageRecord.selfuin;
                    localFileManagerEntity.isReaded = false;
                    localFileManagerEntity.peerUin = paramMessageRecord.frienduin;
                    localFileManagerEntity.peerType = paramMessageRecord.istroop;
                    localFileManagerEntity.peerNick = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.peerUin, null, localFileManagerEntity.peerType);
                    localFileManagerEntity.Uuid = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardUuid");
                    localFileManagerEntity.fileName = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardFileName");
                    localObject = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardSize");
                    if (!TextUtils.isEmpty((CharSequence)localObject)) {
                      localFileManagerEntity.fileSize = Long.parseLong((String)localObject);
                    }
                    if (paramMessageRecord.isSend())
                    {
                      localFileManagerEntity.nOpType = 0;
                      localFileManagerEntity.bSend = true;
                      label432:
                      localObject = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardFilePath");
                      if (!bbdj.b((String)localObject)) {
                        break label534;
                      }
                      localFileManagerEntity.setFilePath((String)localObject);
                      localFileManagerEntity.setCloudType(3);
                      label460:
                      localFileManagerEntity.strFileMd5 = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardMd5");
                      localFileManagerEntity.strFileSHA = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardSha");
                      localObject = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardImgWidth");
                    }
                  }
                }
              }
            }
          }
        }
      }
      try
      {
        localFileManagerEntity.imgWidth = Integer.parseInt((String)localObject);
        label500:
        localObject = paramMessageRecord.getExtInfoFromExtStr("_backup_ForwardImgHeight");
        try
        {
          localFileManagerEntity.imgHeight = Integer.parseInt((String)localObject);
        }
        catch (NumberFormatException localNumberFormatException1) {}
        localFileManagerEntity.nOpType = 1;
        localFileManagerEntity.bSend = false;
        break label432;
        label534:
        localFileManagerEntity.setCloudType(1);
        break label460;
        continue;
        if (localNumberFormatException1.msgSubType != 11) {
          break label139;
        }
        str = a(str, localFileManagerEntity.fileName);
        if (!bbdj.b(str)) {
          break label139;
        }
        localFileManagerEntity.setFilePath(str);
        localFileManagerEntity.status = 1;
        a(localFileManagerEntity, localNumberFormatException1.extraDataStr);
        b(localFileManagerEntity, localNumberFormatException1.extraDataStr);
        a("OfflineFileMsgBackupHandler<QFile>", "createOfflineFileRecord", String.valueOf(paramMessageRecord.msgseq), "save origin path. path[" + str + "]");
        break label139;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
        return;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        break label500;
      }
    }
  }
  
  protected String a(MessageRecord paramMessageRecord, int paramInt)
  {
    int i = 1;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgType", 5);
      localJSONObject.put("msgSubType", paramInt);
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (localFileManagerEntity == null)
      {
        a("OfflineFileMsgBackupHandler<QFile>", "buildResourceInfo", String.valueOf(paramMessageRecord.msgseq), "file entity is null.");
        return "{}";
      }
      if (localFileManagerEntity.peerType == 0)
      {
        localJSONObject.put("uint32_file_type", "1");
        localJSONObject.put("uint64_sender_uin", paramMessageRecord.senderuin);
        localJSONObject.put("uint64_receiver_uin", paramMessageRecord.frienduin);
        String str = localFileManagerEntity.Uuid;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileUuid[" + str + "]");
          }
          localJSONObject.put("bytes_file_uuid", str);
        }
        str = localFileManagerEntity.fileName;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileName[" + str + "]");
          }
          localJSONObject.put("str_file_name", str);
        }
        long l = localFileManagerEntity.fileSize;
        if (QLog.isDevelopLevel()) {
          QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileSize[" + l + "]");
        }
        localJSONObject.put("uint64_file_size", l);
        str = localFileManagerEntity.strFileMd5;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileMd5[" + str + "]");
          }
          localJSONObject.put("md5", str);
        }
        str = localFileManagerEntity.str10Md5;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "buildResourceInfo file10Md5[" + str + "]");
          }
          localJSONObject.put("md510", str);
        }
        str = localFileManagerEntity.strFileSHA;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "buildResourceInfo sha[" + str + "]");
          }
          localJSONObject.put("sha", str);
        }
        str = localFileManagerEntity.strFileSha3;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "buildResourceInfo sha3[" + str + "]");
          }
          localJSONObject.put("sha3", str);
        }
        paramInt = localFileManagerEntity.imgWidth;
        if (paramInt != 0)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "buildResourceInfo imgWidth[" + paramInt + "]");
          }
          localJSONObject.put("uint32_img_width", paramInt);
        }
        paramInt = localFileManagerEntity.imgHeight;
        if (paramInt != 0)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "buildResourceInfo imgWidth[" + paramInt + "]");
          }
          localJSONObject.put("uint32_img_height", paramInt);
        }
        if (!paramMessageRecord.isMultiMsg) {
          break label811;
        }
      }
      label811:
      for (paramInt = i;; paramInt = 0)
      {
        localJSONObject.put("nest_forward", paramInt);
        return localJSONObject.toString();
        if (localFileManagerEntity.peerType == 3000)
        {
          localJSONObject.put("uint32_file_type", "2");
          break;
        }
        if (localFileManagerEntity.peerType == 1)
        {
          localJSONObject.put("uint32_file_type", "3");
          break;
        }
        QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "buildResourceInfo: can not handle peerType[" + localFileManagerEntity.peerType + "] msgInfo[" + apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord) + "]");
        break;
      }
      return "{}";
    }
    catch (JSONException paramMessageRecord) {}
  }
  
  public String a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    HashMap localHashMap = a(paramMsgBackupResEntity.extraDataStr);
    String str2 = "";
    String str1 = "";
    if (paramMsgBackupResEntity.msgSubType == 12)
    {
      str1 = (String)localHashMap.get("md5");
      if (!TextUtils.isEmpty(str1)) {
        break label337;
      }
      str1 = (String)localHashMap.get("md510");
    }
    label337:
    for (;;)
    {
      str2 = (String)localHashMap.get("bytes_file_uuid");
      if (QLog.isDebugVersion()) {
        QLog.i("<QFile_Backup>", 1, "getTempFilePath: md5[" + str1 + "] fileId[" + str2 + "]");
      }
      str2 = a(str2, str1, 7);
      str1 = jdField_a_of_type_JavaLangString;
      for (;;)
      {
        a("OfflineFileMsgBackupHandler<QFile>", "getTempFilePath", "", "resType[" + paramMsgBackupResEntity.msgType + "] tempPath[" + str1 + str2 + "]");
        return str1 + str2;
        if (paramMsgBackupResEntity.msgSubType == 11)
        {
          str1 = (String)localHashMap.get("str_file_name");
          if (QLog.isDebugVersion()) {
            QLog.i("<QFile_Backup>", 1, "getTempFilePath: offline fileName[" + str1 + "]");
          }
          str2 = (String)localHashMap.get("bytes_file_uuid");
          str2 = MD5.toMD5(str1 + str2);
          if (QLog.isDebugVersion()) {
            QLog.i("<QFile_Backup>", 1, "getTempFilePath: offline temp msg backup fileName[" + str2 + "]");
          }
          str1 = b;
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("<QFile_Backup>", 1, "Export: type[offline] contactUin[" + paramMessageRecord.frienduin + "] senderUin[" + paramMessageRecord.senderuin + "] uniSeq[" + paramMessageRecord.uniseq + "] msgSeq[" + paramMessageRecord.msgseq + "]");
    }
    if (paramMessageRecord.isMultiMsg) {
      QLog.i("<QFile_Backup>", 1, "Export: handle a multi mr. msgSeq[" + paramMessageRecord.msgseq + "]");
    }
    for (Object localObject1 = apue.a((ChatMessage)paramMessageRecord);; localObject1 = paramMessageRecord)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
      if (localObject2 == null) {
        QLog.i("OfflineFileMsgBackupHandler<QFile>", 1, "handleExport: get offline file entity null. " + apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1, false));
      }
      for (;;)
      {
        return;
        int i = apue.a(((FileManagerEntity)localObject2).fileName);
        if ((i == 0) || (i == 2))
        {
          Object localObject3 = ((FileManagerEntity)localObject2).strLargeThumPath;
          if (bbdj.b((String)localObject3))
          {
            localObject3 = a(paramMessageRecord, 12, (String)localObject3);
            paramList.add(localObject3);
            a("OfflineFileMsgBackupHandler<QFile>", "handleExport", String.valueOf(paramMessageRecord.msgseq), "add resource. resType[" + ((MsgBackupResEntity)localObject3).msgType + "]");
          }
        }
        localObject2 = ((FileManagerEntity)localObject2).getFilePath();
        if (bbdj.b((String)localObject2))
        {
          localObject2 = a(paramMessageRecord, 11, (String)localObject2);
          paramList.add(localObject2);
          a("OfflineFileMsgBackupHandler<QFile>", "handleExport", String.valueOf(paramMessageRecord.msgseq), "add resource. resType[" + ((MsgBackupResEntity)localObject2).msgType + "]");
        }
        if ((QLog.isDebugVersion()) && (paramList != null))
        {
          QLog.i("<QFile_Backup>", 1, "Export --step: msgSeq[" + ((MessageRecord)localObject1).msgseq + "resourceSize[" + paramList.size() + "]");
          paramMessageRecord = paramList.iterator();
          while (paramMessageRecord.hasNext())
          {
            paramList = (MsgBackupResEntity)paramMessageRecord.next();
            QLog.i("<QFile_Backup>", 1, "Export --step: backup entity [" + paramList.toLogString() + "]");
          }
        }
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    boolean bool1 = true;
    if (paramMsgBackupResEntity == null) {}
    do
    {
      return false;
      paramMessageRecord = (String)a(paramMsgBackupResEntity.extraDataStr).get("bytes_file_uuid");
      if (TextUtils.isEmpty(paramMessageRecord))
      {
        QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: offline fileId is null");
        return false;
      }
      QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: offline fileId[" + paramMessageRecord + "]");
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord);
      if (paramMessageRecord == null) {
        return true;
      }
      if (paramMsgBackupResEntity.msgSubType == 12)
      {
        bool1 = bbdj.b(paramMessageRecord.strLargeThumPath);
        QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: offline large thumb exist[" + bool1 + "]");
        if (!bool1) {}
        for (bool1 = true;; bool1 = false) {
          return bool1;
        }
      }
    } while (paramMsgBackupResEntity.msgSubType != 11);
    boolean bool2 = bbdj.b(paramMessageRecord.strFilePath);
    QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: offline origin file exist[" + bool2 + "]");
    if (!bool2) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (QLog.isDebugVersion())
    {
      QLog.i("<QFile_Backup>", 1, "Import: type[offline]" + apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord));
      if (paramList != null)
      {
        QLog.i("<QFile_Backup>", 1, "Import --step: msgSeq[" + paramMessageRecord.msgseq + "resourceSize[" + paramList.size() + "]");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)localIterator.next();
          QLog.i("<QFile_Backup>", 1, "Import --step: backup entity [" + localMsgBackupResEntity.toLogString() + "]");
        }
      }
    }
    if (a(paramMessageRecord, paramList)) {
      a("OfflineFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(paramMessageRecord.msgseq), "update offline file record.");
    }
    for (;;)
    {
      a(paramMessageRecord);
      return;
      c(paramMessageRecord, paramList);
      a("OfflineFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(paramMessageRecord.msgseq), "create offline file record.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprp
 * JD-Core Version:    0.7.0.1
 */