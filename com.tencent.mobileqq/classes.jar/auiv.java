import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.util.List;

public class auiv
  extends aujd<MessageRecord>
{
  public auiv(MessageRecord paramMessageRecord)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auiv
 * JD-Core Version:    0.7.0.1
 */