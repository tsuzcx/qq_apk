import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
import java.util.Comparator;

class awmb
  implements Comparator<FTSEntity>
{
  awmb(awlz paramawlz) {}
  
  public int a(FTSEntity paramFTSEntity1, FTSEntity paramFTSEntity2)
  {
    paramFTSEntity1 = (FTSMessageCodec.TextMsgExts)((FTSMessage)paramFTSEntity1).msgExts;
    paramFTSEntity2 = (FTSMessageCodec.TextMsgExts)((FTSMessage)paramFTSEntity2).msgExts;
    long l1;
    if (paramFTSEntity1 != null)
    {
      l1 = paramFTSEntity1.time;
      if (paramFTSEntity2 == null) {
        break label54;
      }
    }
    label54:
    for (long l2 = paramFTSEntity2.time;; l2 = 0L)
    {
      return Long.signum(l2 - l1);
      l1 = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmb
 * JD-Core Version:    0.7.0.1
 */