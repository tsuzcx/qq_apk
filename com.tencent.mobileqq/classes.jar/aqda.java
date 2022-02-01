import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

class aqda
  extends aocj
{
  aqda(aqcz paramaqcz) {}
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((aqcz.a(this.a) != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord != null) && (localMessageRecord.uniseq == aqcz.a(this.a).b)) {
          this.a.a(localMessageRecord.uniseq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqda
 * JD-Core Version:    0.7.0.1
 */