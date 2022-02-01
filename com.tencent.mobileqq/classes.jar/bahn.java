import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class bahn
  extends amwl
{
  bahn(bahm parambahm) {}
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramList != null) && (!paramList.isEmpty()) && ((paramList.get(0) instanceof MessageForShortVideo))) {
      agye.a((MessageRecord)paramList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahn
 * JD-Core Version:    0.7.0.1
 */