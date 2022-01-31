import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class aslk
  implements aslb
{
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "MsgBackup_MsgBackupMultiMsgProcessor";
  }
  
  public aslk(QQAppInterface paramQQAppInterface) {}
  
  public static String a(String paramString, MessageRecord paramMessageRecord)
  {
    String str = ((MessageForStructing)paramMessageRecord).structingMsg.mFileName;
    paramMessageRecord = new JSONObject();
    try
    {
      paramMessageRecord.put("selfuin", paramString);
      paramMessageRecord.put("uuid", str);
      paramMessageRecord.put("msgType", 4);
      paramMessageRecord.put("msgSubType", 10);
      return paramMessageRecord.toString();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static List<MessageRecord> a(HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll((Collection)paramHashMap.get((String)localIterator.next()));
    }
    return localArrayList;
  }
  
  public static String b(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((paramMsgBackupResEntity != null) && (!TextUtils.isEmpty(paramMsgBackupResEntity.extraDataStr))) {
      try
      {
        paramMessageRecord = asoi.b(new JSONObject(paramMsgBackupResEntity.extraDataStr).optString("uuid"));
        return paramMessageRecord;
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return "";
  }
  
  public aslo a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    aslo localaslo = new aslo();
    localaslo.jdField_a_of_type_JavaLangString = a(paramMessageRecord, paramMsgBackupResEntity);
    localaslo.jdField_a_of_type_Boolean = true;
    return localaslo;
  }
  
  public String a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((paramMsgBackupResEntity != null) && (!TextUtils.isEmpty(paramMsgBackupResEntity.extraDataStr))) {
      try
      {
        paramMessageRecord = asoi.b(new JSONObject(paramMsgBackupResEntity.extraDataStr).optString("uuid"));
        return paramMessageRecord;
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return "";
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList) {}
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof ChatMessage)) {
      return asuh.a((ChatMessage)paramMessageRecord);
    }
    return false;
  }
  
  public boolean a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    return paramMsgBackupResEntity.msgType == 4;
  }
  
  public void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aslk
 * JD-Core Version:    0.7.0.1
 */