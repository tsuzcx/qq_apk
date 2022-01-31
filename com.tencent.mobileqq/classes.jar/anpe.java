import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

class anpe
  extends alwx
{
  anpe(anpd paramanpd) {}
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((anpd.a(this.a) != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord != null) && (localMessageRecord.uniseq == anpd.a(this.a).b)) {
          this.a.a(localMessageRecord.uniseq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpe
 * JD-Core Version:    0.7.0.1
 */