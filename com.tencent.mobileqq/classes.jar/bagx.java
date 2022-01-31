import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import java.util.Comparator;

class bagx
  implements Comparator<bahf>
{
  bagx(bagr parambagr) {}
  
  public int a(bahf parambahf1, bahf parambahf2)
  {
    int j = -1;
    if (((parambahf1 instanceof MessageForDeliverGiftTips)) && ((parambahf2 instanceof MessageForDeliverGiftTips)))
    {
      parambahf1 = (MessageForDeliverGiftTips)parambahf1;
      parambahf2 = (MessageForDeliverGiftTips)parambahf2;
      int i;
      if ((parambahf1.isToAll()) && (parambahf2.isToAll())) {
        i = (int)(parambahf1.time - parambahf2.time);
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (parambahf1.isToAll());
        if (parambahf2.isToAll()) {
          return 1;
        }
        if ((parambahf1.receiverUin == this.a.a.getLongAccountUin()) && (parambahf2.receiverUin == this.a.a.getLongAccountUin())) {
          return (int)(parambahf1.time - parambahf2.time);
        }
        i = j;
      } while (parambahf1.receiverUin == this.a.a.getLongAccountUin());
      if (parambahf2.receiverUin == this.a.a.getLongAccountUin()) {
        return 1;
      }
      return (int)(parambahf1.time - parambahf2.time);
    }
    return (int)(parambahf1.getShmsgseq() - parambahf2.getShmsgseq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bagx
 * JD-Core Version:    0.7.0.1
 */