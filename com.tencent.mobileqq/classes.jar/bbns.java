import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class bbns
  extends aocj
{
  bbns(bbnr parambbnr) {}
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramList != null) && (!paramList.isEmpty()) && ((paramList.get(0) instanceof MessageForShortVideo))) {
      aibo.a((MessageRecord)paramList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbns
 * JD-Core Version:    0.7.0.1
 */