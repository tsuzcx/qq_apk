import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.util.List;

public class asnn
  extends asnv<MessageRecord>
{
  public asnn(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
    this.a = (this.a + "." + paramMessageRecord.getClass().getSimpleName());
  }
  
  protected int a()
  {
    return 0;
  }
  
  public List<MsgBackupResEntity> a()
  {
    return null;
  }
  
  public void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asnn
 * JD-Core Version:    0.7.0.1
 */