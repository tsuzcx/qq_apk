import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import java.util.Comparator;

class beyn
  implements Comparator<beyv>
{
  beyn(beyh parambeyh) {}
  
  public int a(beyv parambeyv1, beyv parambeyv2)
  {
    int j = -1;
    if (((parambeyv1 instanceof MessageForDeliverGiftTips)) && ((parambeyv2 instanceof MessageForDeliverGiftTips)))
    {
      parambeyv1 = (MessageForDeliverGiftTips)parambeyv1;
      parambeyv2 = (MessageForDeliverGiftTips)parambeyv2;
      int i;
      if ((parambeyv1.isToAll()) && (parambeyv2.isToAll())) {
        i = (int)(parambeyv1.time - parambeyv2.time);
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (parambeyv1.isToAll());
        if (parambeyv2.isToAll()) {
          return 1;
        }
        if ((parambeyv1.receiverUin == this.a.a.getLongAccountUin()) && (parambeyv2.receiverUin == this.a.a.getLongAccountUin())) {
          return (int)(parambeyv1.time - parambeyv2.time);
        }
        i = j;
      } while (parambeyv1.receiverUin == this.a.a.getLongAccountUin());
      if (parambeyv2.receiverUin == this.a.a.getLongAccountUin()) {
        return 1;
      }
      return (int)(parambeyv1.time - parambeyv2.time);
    }
    return (int)(parambeyv1.getShmsgseq() - parambeyv2.getShmsgseq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyn
 * JD-Core Version:    0.7.0.1
 */