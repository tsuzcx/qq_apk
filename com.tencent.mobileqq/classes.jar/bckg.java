import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import java.util.Comparator;

class bckg
  implements Comparator<bcko>
{
  bckg(bcka parambcka) {}
  
  public int a(bcko parambcko1, bcko parambcko2)
  {
    int j = -1;
    if (((parambcko1 instanceof MessageForDeliverGiftTips)) && ((parambcko2 instanceof MessageForDeliverGiftTips)))
    {
      parambcko1 = (MessageForDeliverGiftTips)parambcko1;
      parambcko2 = (MessageForDeliverGiftTips)parambcko2;
      int i;
      if ((parambcko1.isToAll()) && (parambcko2.isToAll())) {
        i = (int)(parambcko1.time - parambcko2.time);
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (parambcko1.isToAll());
        if (parambcko2.isToAll()) {
          return 1;
        }
        if ((parambcko1.receiverUin == this.a.a.getLongAccountUin()) && (parambcko2.receiverUin == this.a.a.getLongAccountUin())) {
          return (int)(parambcko1.time - parambcko2.time);
        }
        i = j;
      } while (parambcko1.receiverUin == this.a.a.getLongAccountUin());
      if (parambcko2.receiverUin == this.a.a.getLongAccountUin()) {
        return 1;
      }
      return (int)(parambcko1.time - parambcko2.time);
    }
    return (int)(parambcko1.getShmsgseq() - parambcko2.getShmsgseq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckg
 * JD-Core Version:    0.7.0.1
 */