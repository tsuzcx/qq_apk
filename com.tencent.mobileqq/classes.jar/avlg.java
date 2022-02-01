import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;

public class avlg
{
  public static String a(MessageRecord paramMessageRecord)
  {
    TinyInfo localTinyInfo = new TinyInfo();
    localTinyInfo.parseFromMessageRecord(paramMessageRecord);
    if (paramMessageRecord.isSend()) {
      return localTinyInfo.fromRoleId;
    }
    return localTinyInfo.toRoleId;
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    TinyInfo localTinyInfo = new TinyInfo();
    localTinyInfo.parseFromMessageRecord(paramMessageRecord);
    if (paramMessageRecord.isSend()) {
      return localTinyInfo.toRoleId;
    }
    return localTinyInfo.fromRoleId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avlg
 * JD-Core Version:    0.7.0.1
 */