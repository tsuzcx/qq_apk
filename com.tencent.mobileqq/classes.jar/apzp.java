import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

class apzp
  extends anyz
{
  apzp(apzo paramapzo) {}
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((apzo.a(this.a) != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord != null) && (localMessageRecord.uniseq == apzo.a(this.a).b)) {
          this.a.a(localMessageRecord.uniseq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzp
 * JD-Core Version:    0.7.0.1
 */