import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;>;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class aprq
  extends apro
{
  public aprq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "";
    }
    do
    {
      return paramString1;
      paramString2 = ajsf.bo + apvk.a(paramLong, paramInt, paramString2);
      if (!a(paramString1, paramString2)) {
        break;
      }
      paramString1 = paramString2;
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileMsgBackupHandler<QFile>", 4, "getThumbSavePath. thumbPath[" + paramString2 + "]");
    return paramString2;
    QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "getThumbSavePath. move file failed.");
    return "";
  }
  
  private boolean a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (paramMessageRecord.isMultiMsg) {}
    for (Object localObject1 = (MessageForTroopFile)apue.a((ChatMessage)paramMessageRecord); localObject1 == null; localObject1 = (MessageForTroopFile)paramMessageRecord)
    {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "onImport: get updateTroopFileRecord failed. get troop file msg is null. isMulti[" + paramMessageRecord.isMultiMsg + "]");
      return false;
    }
    long l = Long.parseLong(((MessageForTroopFile)localObject1).frienduin);
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l);
    localObject1 = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject1);
    if ((localTroopFileTransferManager == null) || (localObject1 == null))
    {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "onImport: get troopFileTransferManager failed.");
      return false;
    }
    if (((azqt)localObject1).jdField_a_of_type_JavaUtilUUID == null)
    {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "onImport: updateTroopFileRecord failed. troop file status info uuid is null");
      return false;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.a(((azqt)localObject1).jdField_a_of_type_JavaUtilUUID);
    Object localObject2;
    String str;
    if (localItem != null) {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        localObject1 = "";
        localObject2 = "";
        Iterator localIterator = paramList.iterator();
        paramList = (List<MsgBackupResEntity>)localObject2;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject2 = (MsgBackupResEntity)localIterator.next();
            if ((a((MsgBackupResEntity)localObject2)) && (b(paramMessageRecord, (MsgBackupResEntity)localObject2)))
            {
              str = a((MsgBackupResEntity)localObject2);
              if (TextUtils.isEmpty(str)) {
                break label381;
              }
              if (((MsgBackupResEntity)localObject2).msgSubType == 12)
              {
                if (bbdj.b(localItem.largeThumbnailFile)) {
                  continue;
                }
                localObject1 = a(l, str, localItem.Id.toString(), 640);
              }
            }
          }
        }
      }
    }
    label381:
    for (;;)
    {
      break;
      if (((MsgBackupResEntity)localObject2).msgSubType == 11)
      {
        if (bbdj.b(localItem.LocalFile)) {
          break;
        }
        paramList = a(str, localItem.FileName);
        continue;
        if (bbdj.b(paramList))
        {
          localItem.LocalFile = paramList;
          localItem.Status = 11;
          localTroopFileTransferManager.b(localItem);
        }
        if (bbdj.b((String)localObject1))
        {
          localItem.largeThumbnailFile = ((String)localObject1);
          localItem.HasThumbnailFile_Large = true;
          localTroopFileTransferManager.b(localItem);
        }
        return true;
        return false;
      }
    }
  }
  
  private void c(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (paramMessageRecord.isMultiMsg) {}
    for (Object localObject1 = (MessageForTroopFile)apue.a((ChatMessage)paramMessageRecord); localObject1 == null; localObject1 = (MessageForTroopFile)paramMessageRecord)
    {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "onImport: createTroopFileRecord failed. get troop file msg is null. isMulti[" + paramMessageRecord.isMultiMsg + "]");
      return;
    }
    long l = Long.parseLong(((MessageForTroopFile)localObject1).frienduin);
    if (baje.a(l) == null) {
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "createTroopFileRecord: get TroopFileDataManager failed.");
    }
    azpg localazpg = bajk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l).b(((MessageForTroopFile)localObject1).url, ((MessageForTroopFile)localObject1).fileName, ((MessageForTroopFile)localObject1).fileSize, ((MessageForTroopFile)localObject1).bisID);
    Object localObject2;
    String str;
    if ((localazpg != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      localObject1 = "";
      localObject2 = "";
      Iterator localIterator = paramList.iterator();
      paramList = (List<MsgBackupResEntity>)localObject2;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (MsgBackupResEntity)localIterator.next();
          if ((a((MsgBackupResEntity)localObject2)) && (b(paramMessageRecord, (MsgBackupResEntity)localObject2)))
          {
            str = a((MsgBackupResEntity)localObject2);
            if (TextUtils.isEmpty(str)) {
              break label412;
            }
            if (((MsgBackupResEntity)localObject2).msgSubType == 12) {
              localObject1 = a(l, str, UUID.nameUUIDFromBytes(localazpg.b.getBytes()).toString(), 640);
            }
          }
        }
      }
    }
    label412:
    for (;;)
    {
      break;
      if (((MsgBackupResEntity)localObject2).msgSubType == 11)
      {
        paramList = a(str, localazpg.c);
        continue;
        if (bbdj.b(paramList))
        {
          localazpg.h = paramList;
          localazpg.e = 11;
          a("TroopFileMsgBackupHandler<QFile>", "createTroopFileRecord", String.valueOf(paramMessageRecord.msgseq), "save origin path. path[" + paramList + "]");
        }
        if (bbdj.b((String)localObject1))
        {
          localazpg.j = ((String)localObject1);
          a("TroopFileMsgBackupHandler<QFile>", "createTroopFileRecord", String.valueOf(paramMessageRecord.msgseq), "save large thumb path. path[" + (String)localObject1 + "]");
        }
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l).a(localazpg);
        return;
      }
    }
  }
  
  protected String a(MessageRecord paramMessageRecord, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msgType", 5);
      localJSONObject.put("msgSubType", paramInt);
      MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramMessageRecord;
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileType[" + 3 + "]");
      }
      localJSONObject.put("uint32_file_type", 3);
      localJSONObject.put("uint64_sender_uin", paramMessageRecord.senderuin);
      localJSONObject.put("uint64_receiver_uin", paramMessageRecord.frienduin);
      Object localObject = localMessageForTroopFile.url;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileUuid[" + (String)localObject + "]");
        }
        localJSONObject.put("bytes_file_uuid", localObject);
      }
      localObject = localMessageForTroopFile.fileName;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileName[" + (String)localObject + "]");
        }
        localJSONObject.put("str_file_name", localObject);
      }
      long l = localMessageForTroopFile.fileSize;
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo fileSize[" + l + "]");
      }
      localJSONObject.put("uint64_file_size", l);
      localObject = localMessageForTroopFile.sha1;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo strSHA1[" + (String)localObject + "]");
        }
        localJSONObject.put("sha", localObject);
      }
      paramInt = localMessageForTroopFile.width;
      if (paramInt != 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo imgWidth[" + paramInt + "]");
        }
        localJSONObject.put("uint32_img_width", paramInt);
      }
      paramInt = localMessageForTroopFile.height;
      if (paramInt != 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo imgHeight[" + paramInt + "]");
        }
        localJSONObject.put("uint32_img_height", paramInt);
      }
      localObject = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
      if ((localObject != null) && (((azqt)localObject).e > 0) && (((azqt)localObject).f > 0))
      {
        localJSONObject.put("uint32_img_width", ((azqt)localObject).e);
        localJSONObject.put("uint32_img_height", ((azqt)localObject).f);
      }
      l = localMessageForTroopFile.lastTime;
      if (l != 0L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo deadTime[" + l + "]");
        }
        localJSONObject.put("int64_dead_time", l);
      }
      l = localMessageForTroopFile.duration;
      if (l != 0L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo videoDur[" + l + "]");
        }
        localJSONObject.put("uint64_video_duration", l);
      }
      paramInt = localMessageForTroopFile.bisID;
      if (paramInt != 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileMsgBackupHandler<QFile>", 1, "buildResourceInfo bizId[" + paramInt + "]");
        }
        localJSONObject.put("uint32_bus_id", paramInt);
      }
      if (paramMessageRecord.isMultiMsg) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localJSONObject.put("nest_forward", paramInt);
        paramMessageRecord = localJSONObject.toString();
        return paramMessageRecord;
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
      str1 = (String)localHashMap.get("uint64_receiver_uin");
      long l = 0L;
      if (!TextUtils.isEmpty(str1))
      {
        l = Long.parseLong(str1);
        str2 = (String)localHashMap.get("bytes_file_uuid");
        if (QLog.isDebugVersion()) {
          QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop file uin[" + str1 + "] fileId[" + str2 + "]");
        }
        str2 = apvk.a(l, 640, str2);
        str1 = jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      a("TroopFileMsgBackupHandler<QFile>", "getTempFilePath", "", "resType[" + paramMsgBackupResEntity.msgType + "] tempPath[" + str1 + str2 + "]");
      return str1 + str2;
      QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop file uin is null");
      break;
      if (paramMsgBackupResEntity.msgSubType == 11)
      {
        str1 = (String)localHashMap.get("str_file_name");
        if (QLog.isDebugVersion()) {
          QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop fileName[" + str1 + "]");
        }
        str2 = (String)localHashMap.get("bytes_file_uuid");
        str2 = MD5.toMD5(str1 + str2);
        if (QLog.isDebugVersion()) {
          QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop temp msg backup fileName[" + str2 + "]");
        }
        str1 = b;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("<QFile_Backup>", 1, "Export: type[troop] contactUin[" + paramMessageRecord.frienduin + "] senderUin[" + paramMessageRecord.senderuin + "] uniSeq[" + paramMessageRecord.uniseq + "] msgSeq[" + paramMessageRecord.msgseq + "]");
    }
    Object localObject1;
    if (paramMessageRecord.isMultiMsg)
    {
      localObject1 = (MessageForTroopFile)apue.a((ChatMessage)paramMessageRecord);
      localObject1 = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject1);
      if (localObject1 != null) {
        break label145;
      }
      QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "handleExport: get TroopFileStatusInfo failed.");
    }
    for (;;)
    {
      return;
      localObject1 = (MessageForTroopFile)paramMessageRecord;
      localObject1 = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject1);
      break;
      label145:
      int i = apue.a(((azqt)localObject1).g);
      if ((i == 0) || (i == 2))
      {
        Object localObject2 = ((azqt)localObject1).c;
        if (bbdj.b((String)localObject2))
        {
          localObject2 = a(paramMessageRecord, 12, (String)localObject2);
          paramList.add(localObject2);
          a("TroopFileMsgBackupHandler<QFile>", "handleExport", String.valueOf(paramMessageRecord.msgseq), "add resource. resType[" + ((MsgBackupResEntity)localObject2).msgType + "]");
        }
      }
      localObject1 = ((azqt)localObject1).jdField_a_of_type_JavaLangString;
      if (bbdj.b((String)localObject1))
      {
        localObject1 = a(paramMessageRecord, 11, (String)localObject1);
        paramList.add(localObject1);
        a("TroopFileMsgBackupHandler<QFile>", "handleExport", String.valueOf(paramMessageRecord.msgseq), "add resource. resType[" + ((MsgBackupResEntity)localObject1).msgType + "]");
      }
      if ((QLog.isDebugVersion()) && (paramList != null))
      {
        QLog.i("<QFile_Backup>", 1, "Export --step: msgSeq[" + paramMessageRecord.msgseq + "resourceSize[" + paramList.size() + "]");
        paramMessageRecord = paramList.iterator();
        while (paramMessageRecord.hasNext())
        {
          paramList = (MsgBackupResEntity)paramMessageRecord.next();
          QLog.i("<QFile_Backup>", 1, "Export --step: backup entity [" + paramList.toLogString() + "]");
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
      paramMessageRecord = a(paramMsgBackupResEntity.extraDataStr);
      String str = (String)paramMessageRecord.get("bytes_file_uuid");
      paramMessageRecord = (String)paramMessageRecord.get("uint64_receiver_uin");
      if (TextUtils.isEmpty(str))
      {
        QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: troop fileId is null");
        return false;
      }
      if (TextUtils.isEmpty(paramMessageRecord))
      {
        QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: troop uin is null");
        return false;
      }
      TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramMessageRecord));
      paramMessageRecord = null;
      if (localTroopFileTransferManager != null) {
        paramMessageRecord = localTroopFileTransferManager.a(str);
      }
      if (paramMessageRecord == null)
      {
        QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "checkNeedDownloadRes: get troopStatusInfo failed.");
        return true;
      }
      QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: troop fileId[" + str + "]");
      if (paramMsgBackupResEntity.msgSubType == 12)
      {
        bool1 = bbdj.b(paramMessageRecord.c);
        QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: offline large thumb exist[" + bool1 + "]");
        if (!bool1) {}
        for (bool1 = true;; bool1 = false) {
          return bool1;
        }
      }
    } while (paramMsgBackupResEntity.msgSubType != 11);
    boolean bool2 = bbdj.b(paramMessageRecord.jdField_a_of_type_JavaLangString);
    QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: troop origin file exist[" + bool2 + "]");
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
      QLog.i("<QFile_Backup>", 1, "Import: type[troop] contactUin[" + paramMessageRecord.frienduin + "] senderUin[" + paramMessageRecord.senderuin + "] uniSeq[" + paramMessageRecord.uniseq + "] msgSeq[" + paramMessageRecord.msgseq + "]");
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
      a("TroopFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(paramMessageRecord.msgseq), "update troop file record.");
    }
    for (;;)
    {
      a(paramMessageRecord);
      return;
      c(paramMessageRecord, paramList);
      a("TroopFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(paramMessageRecord.msgseq), "create troop file record.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprq
 * JD-Core Version:    0.7.0.1
 */