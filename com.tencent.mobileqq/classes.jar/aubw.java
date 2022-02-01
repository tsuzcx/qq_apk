import com.tencent.mobileqq.data.MessageForGrayTips.HighlightItem;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import java.util.Comparator;

public class aubw
  implements Comparator<MessageForGrayTips.HighlightItem>
{
  public aubw(MessageForUniteGrayTip paramMessageForUniteGrayTip) {}
  
  public int a(MessageForGrayTips.HighlightItem paramHighlightItem1, MessageForGrayTips.HighlightItem paramHighlightItem2)
  {
    return paramHighlightItem1.start - paramHighlightItem2.start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubw
 * JD-Core Version:    0.7.0.1
 */