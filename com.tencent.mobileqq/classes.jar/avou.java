import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import java.util.Comparator;

public class avou
  implements Comparator<MessageForGrayTips.HightlightItem>
{
  public avou(MessageForUniteGrayTip paramMessageForUniteGrayTip) {}
  
  public int a(MessageForGrayTips.HightlightItem paramHightlightItem1, MessageForGrayTips.HightlightItem paramHightlightItem2)
  {
    return paramHightlightItem1.start - paramHightlightItem2.start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avou
 * JD-Core Version:    0.7.0.1
 */