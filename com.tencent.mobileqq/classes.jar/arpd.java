import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public abstract class arpd
{
  public static final String a;
  public static final String b = aujk.jdField_a_of_type_JavaLangString + "file/";
  protected QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = aujk.jdField_a_of_type_JavaLangString + "fileThumb/";
  }
  
  public arpd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected MsgBackupResEntity a(MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    MsgBackupResEntity localMsgBackupResEntity = new MsgBackupResEntity();
    aujq.a(paramMessageRecord, localMsgBackupResEntity);
    localMsgBackupResEntity.extraDataStr = a(arrr.a((ChatMessage)paramMessageRecord), paramInt);
    localMsgBackupResEntity.filePath = paramString;
    localMsgBackupResEntity.msgType = 5;
    localMsgBackupResEntity.msgSubType = paramInt;
    if (bdhb.b(paramString)) {
      localMsgBackupResEntity.fileSize = bdhb.a(paramString);
    }
    return localMsgBackupResEntity;
  }
  
  protected String a(MessageRecord paramMessageRecord, int paramInt)
  {
    return "";
  }
  
  public abstract String a(MsgBackupResEntity paramMsgBackupResEntity);
  
  protected String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "";
    }
    do
    {
      return paramString1;
      String str = arrr.b();
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      str = str + paramString2;
      paramString2 = str;
      if (bdhb.b(str)) {
        paramString2 = arrr.b(str);
      }
      if (!a(paramString1, paramString2)) {
        break;
      }
      paramString1 = paramString2;
    } while (!QLog.isColorLevel());
    QLog.i("FileMsgBackupHandler<QFile>", 4, "getRawFileSavePath. rawPath[" + paramString2 + "]");
    return paramString2;
    QLog.i("FileMsgBackupHandler<QFile>", 1, "getRawFileSavePath. move file failed.");
    return "";
  }
  
  protected HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localHashMap;
      try
      {
        paramString = new JSONObject(paramString);
        String str;
        if (paramString.has("uint64_sender_uin"))
        {
          str = paramString.getString("uint64_sender_uin");
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo senderUin[" + str + "]");
          }
          localHashMap.put("uint64_sender_uin", str);
        }
        if (paramString.has("uint64_receiver_uin"))
        {
          str = paramString.getString("uint64_receiver_uin");
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo recvUin[" + str + "]");
          }
          localHashMap.put("uint64_receiver_uin", str);
        }
        int i;
        if (paramString.has("uint32_file_type"))
        {
          i = paramString.getInt("uint32_file_type");
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo peerType[" + i + "]");
          }
          localHashMap.put("uint32_file_type", String.valueOf(i));
        }
        if (paramString.has("bytes_file_uuid"))
        {
          str = paramString.getString("bytes_file_uuid");
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo fileUuid[" + str + "]");
          }
          localHashMap.put("bytes_file_uuid", str);
        }
        if (paramString.has("str_file_name"))
        {
          str = paramString.getString("str_file_name");
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo fileName[" + str + "]");
          }
          localHashMap.put("str_file_name", str);
        }
        if (paramString.has("uint64_file_size"))
        {
          long l = paramString.getLong("uint64_file_size");
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo fileSize[" + l + "]");
          }
          localHashMap.put("uint64_file_size", String.valueOf(l));
        }
        if (paramString.has("md5"))
        {
          str = paramString.getString("md5");
          if (!TextUtils.isEmpty(str))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo fileMd5[" + str + "]");
            }
            localHashMap.put("md5", str);
          }
        }
        if (paramString.has("md510"))
        {
          str = paramString.getString("md510");
          if (!TextUtils.isEmpty(str))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo file10Md5[" + str + "]");
            }
            localHashMap.put("md510", str);
          }
        }
        if (paramString.has("sha"))
        {
          str = paramString.getString("sha");
          if (!TextUtils.isEmpty(str))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo sha[" + str + "]");
            }
            localHashMap.put("sha", str);
          }
        }
        if (paramString.has("sha3"))
        {
          str = paramString.getString("sha3");
          if (!TextUtils.isEmpty(str))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo sha3[" + str + "]");
            }
            localHashMap.put("sha3", str);
          }
        }
        if (paramString.has("uint32_img_width"))
        {
          i = paramString.getInt("uint32_img_width");
          if (i != 0)
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo imgWidth[" + i + "]");
            }
            localHashMap.put("uint32_img_width", String.valueOf(i));
          }
        }
        if (paramString.has("uint32_img_height"))
        {
          i = paramString.getInt("uint32_img_height");
          if (i != 0)
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("FileMsgBackupHandler<QFile>", 1, "decodeResExtInfo imgWidth[" + i + "]");
            }
            localHashMap.put("uint32_img_height", String.valueOf(i));
            return localHashMap;
          }
        }
      }
      catch (Exception paramString) {}
    }
    return localHashMap;
  }
  
  protected void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardFileType");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardSenderUin");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardReceiverUin");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardUuid");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardFileName");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardSize");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardSha");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardMd5");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardDeadTime");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardImgWidth");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardImgHeight");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardDuration");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardBusType");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardFilePath");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardFileStatus");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardFaildReason");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardLasSuccess");
    paramMessageRecord.removeExtInfoToExtStr("_backup_ForwardStatusPaused");
  }
  
  public abstract void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList);
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2 + ": ");
      if (!TextUtils.isEmpty(paramString3))
      {
        localStringBuilder.append("msg[");
        localStringBuilder.append(paramString3);
        localStringBuilder.append("] ");
      }
      localStringBuilder.append(paramString4);
      QLog.i(paramString1, 4, localStringBuilder.toString());
    }
  }
  
  public abstract boolean a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity);
  
  protected boolean a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    if (paramMsgBackupResEntity == null) {}
    while ((paramMsgBackupResEntity.msgType != 5) || ((paramMsgBackupResEntity.msgSubType != 12) && (paramMsgBackupResEntity.msgSubType != 11))) {
      return false;
    }
    return true;
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if (!bdhb.b(paramString1))
    {
      QLog.i("FileMsgBackupHandler<QFile>", 1, "moveFileSavePath. tempPath is null");
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.i("FileMsgBackupHandler<QFile>", 1, "moveFileSavePath. targetPath is null");
      return false;
    }
    return bdhb.b(paramString1, paramString2);
  }
  
  public abstract void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList);
  
  protected boolean b(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if (paramMessageRecord.isMultiMsg)
    {
      paramMsgBackupResEntity = (String)a(paramMsgBackupResEntity.extraDataStr).get("bytes_file_uuid");
      String str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
      if ((!TextUtils.isEmpty(paramMsgBackupResEntity)) && (!TextUtils.isEmpty(str)) && (paramMsgBackupResEntity.equals(str)))
      {
        if (QLog.isDebugVersion()) {
          QLog.i("FileMsgBackupHandler<QFile>", 1, "isResourceRelateToMsg: multi msg match res. fileId[" + str + "] " + arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord));
        }
        return true;
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arpd
 * JD-Core Version:    0.7.0.1
 */