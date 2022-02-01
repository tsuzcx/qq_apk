import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class bboc
  extends anyz
{
  bboc(bbob parambbob) {}
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramList != null) && (!paramList.isEmpty()) && ((paramList.get(0) instanceof MessageForShortVideo))) {
      ahrf.a((MessageRecord)paramList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboc
 * JD-Core Version:    0.7.0.1
 */