import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.util.List;

public abstract interface avtl
{
  public abstract avty a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity);
  
  public abstract String a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity);
  
  public abstract void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList);
  
  public abstract boolean a(MessageRecord paramMessageRecord);
  
  public abstract boolean a(MsgBackupResEntity paramMsgBackupResEntity);
  
  public abstract void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avtl
 * JD-Core Version:    0.7.0.1
 */