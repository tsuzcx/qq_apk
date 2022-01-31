import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class axsp
  extends alsi
{
  axsp(axso paramaxso) {}
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramList != null) && (!paramList.isEmpty()) && ((paramList.get(0) instanceof MessageForShortVideo))) {
      agdf.a((MessageRecord)paramList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axsp
 * JD-Core Version:    0.7.0.1
 */