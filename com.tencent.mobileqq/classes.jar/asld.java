import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class asld
  implements askz
{
  private aprp jdField_a_of_type_Aprp;
  private aprq jdField_a_of_type_Aprq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public asld(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private apro a(int paramInt)
  {
    QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: chatTYpe[" + paramInt + "]");
    Object localObject1 = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Aprp == null) {
        this.jdField_a_of_type_Aprp = new aprp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localObject1 = this.jdField_a_of_type_Aprp;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: target backup handle is null");
        if (this.jdField_a_of_type_Aprp == null) {
          this.jdField_a_of_type_Aprp = new aprp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject2 = this.jdField_a_of_type_Aprp;
      }
      return localObject2;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_Aprp == null) {
          this.jdField_a_of_type_Aprp = new aprp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_Aprp;
      }
      else if (paramInt == 3)
      {
        if (this.jdField_a_of_type_Aprq == null) {
          this.jdField_a_of_type_Aprq = new aprq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject1 = this.jdField_a_of_type_Aprq;
      }
    }
  }
  
  private apro a(MessageRecord paramMessageRecord)
  {
    Object localObject = null;
    if (paramMessageRecord.isMultiMsg)
    {
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
      if (!TextUtils.isEmpty(paramMessageRecord))
      {
        if (Integer.parseInt(paramMessageRecord) != 3) {
          break label72;
        }
        if (this.jdField_a_of_type_Aprq == null) {
          this.jdField_a_of_type_Aprq = new aprq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject = this.jdField_a_of_type_Aprq;
      }
    }
    for (;;)
    {
      if (localObject == null) {
        QLog.i("MsgBackupFileProcessor<QFile>", 1, "getMsgBackupHandler: target backup handle is null");
      }
      return localObject;
      label72:
      if (this.jdField_a_of_type_Aprp == null) {
        this.jdField_a_of_type_Aprp = new aprp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localObject = this.jdField_a_of_type_Aprp;
      continue;
      if ((paramMessageRecord instanceof MessageForFile))
      {
        if (this.jdField_a_of_type_Aprp == null) {
          this.jdField_a_of_type_Aprp = new aprp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject = this.jdField_a_of_type_Aprp;
      }
      else if ((paramMessageRecord instanceof MessageForTroopFile))
      {
        if (this.jdField_a_of_type_Aprq == null) {
          this.jdField_a_of_type_Aprq = new aprq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        localObject = this.jdField_a_of_type_Aprq;
      }
    }
  }
  
  private HashMap<String, String> a(String paramString)
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
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo senderUin[" + str + "]");
          }
          localHashMap.put("uint64_sender_uin", str);
        }
        if (paramString.has("uint64_receiver_uin"))
        {
          str = paramString.getString("uint64_receiver_uin");
          if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo recvUin[" + str + "]");
          }
          localHashMap.put("uint64_receiver_uin", str);
        }
        int i;
        if (paramString.has("uint32_file_type"))
        {
          i = paramString.getInt("uint32_file_type");
          if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo peerType[" + i + "]");
          }
          localHashMap.put("uint32_file_type", String.valueOf(i));
        }
        if (paramString.has("bytes_file_uuid"))
        {
          str = paramString.getString("bytes_file_uuid");
          if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo fileUuid[" + str + "]");
          }
          localHashMap.put("bytes_file_uuid", str);
        }
        if (paramString.has("str_file_name"))
        {
          str = paramString.getString("str_file_name");
          if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo fileName[" + str + "]");
          }
          localHashMap.put("str_file_name", str);
        }
        if (paramString.has("uint64_file_size"))
        {
          long l = paramString.getLong("uint64_file_size");
          if (QLog.isDevelopLevel()) {
            QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo fileSize[" + l + "]");
          }
          localHashMap.put("uint64_file_size", String.valueOf(l));
        }
        if (paramString.has("md5"))
        {
          str = paramString.getString("md5");
          if (!TextUtils.isEmpty(str))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo fileMd5[" + str + "]");
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
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo file10Md5[" + str + "]");
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
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo sha[" + str + "]");
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
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo sha3[" + str + "]");
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
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo imgWidth[" + i + "]");
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
              QLog.i("MsgBackupFileProcessor<QFile>", 1, "decodeResExtInfo imgWidth[" + i + "]");
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
  
  public aslm a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    aslm localaslm = new aslm();
    if (paramMsgBackupResEntity == null)
    {
      QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: res entity is null.");
      localaslm.a = false;
      return localaslm;
    }
    if (paramMsgBackupResEntity.msgType != 5)
    {
      QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: res entity is null.");
      localaslm.a = false;
      return localaslm;
    }
    String str = (String)a(paramMsgBackupResEntity.extraDataStr).get("uint32_file_type");
    if (TextUtils.isEmpty(str))
    {
      QLog.i("MsgBackupFileProcessor<QFile>", 1, "isNeedDownloadRes: can not find chatType from extInfo. resInfo[" + paramMsgBackupResEntity.toLogString() + "]");
      localaslm.a = false;
      return localaslm;
    }
    localaslm.a = a(Integer.parseInt(str)).a(paramMessageRecord, paramMsgBackupResEntity);
    return localaslm;
  }
  
  public String a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    paramMessageRecord = new File(apro.b);
    if (!paramMessageRecord.exists()) {
      paramMessageRecord.mkdirs();
    }
    paramMessageRecord = new File(apro.a);
    if (!paramMessageRecord.exists()) {
      paramMessageRecord.mkdirs();
    }
    return a(Integer.parseInt((String)a(paramMsgBackupResEntity.extraDataStr).get("uint32_file_type"))).a(paramMsgBackupResEntity);
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    apro localapro = a(paramMessageRecord);
    if (localapro != null) {
      localapro.a(paramMessageRecord, paramList);
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForTroopFile)) {}
    while ((paramMessageRecord instanceof MessageForFile)) {
      return true;
    }
    return false;
  }
  
  public boolean a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    return (paramMsgBackupResEntity != null) && (paramMsgBackupResEntity.msgType == 5);
  }
  
  public void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList)
  {
    apro localapro = a(paramMessageRecord);
    if (localapro != null) {
      localapro.b(paramMessageRecord, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asld
 * JD-Core Version:    0.7.0.1
 */