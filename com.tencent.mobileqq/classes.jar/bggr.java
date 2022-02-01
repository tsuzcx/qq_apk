import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import java.util.Comparator;

class bggr
  implements Comparator<bggz>
{
  bggr(bggl parambggl) {}
  
  public int a(bggz parambggz1, bggz parambggz2)
  {
    int j = -1;
    if (((parambggz1 instanceof MessageForDeliverGiftTips)) && ((parambggz2 instanceof MessageForDeliverGiftTips)))
    {
      parambggz1 = (MessageForDeliverGiftTips)parambggz1;
      parambggz2 = (MessageForDeliverGiftTips)parambggz2;
      int i;
      if ((parambggz1.isToAll()) && (parambggz2.isToAll())) {
        i = (int)(parambggz1.time - parambggz2.time);
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (parambggz1.isToAll());
        if (parambggz2.isToAll()) {
          return 1;
        }
        if ((parambggz1.receiverUin == this.a.a.getLongAccountUin()) && (parambggz2.receiverUin == this.a.a.getLongAccountUin())) {
          return (int)(parambggz1.time - parambggz2.time);
        }
        i = j;
      } while (parambggz1.receiverUin == this.a.a.getLongAccountUin());
      if (parambggz2.receiverUin == this.a.a.getLongAccountUin()) {
        return 1;
      }
      return (int)(parambggz1.time - parambggz2.time);
    }
    return (int)(parambggz1.getShmsgseq() - parambggz2.getShmsgseq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggr
 * JD-Core Version:    0.7.0.1
 */