import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import java.util.Comparator;

class bcfx
  implements Comparator<bcgf>
{
  bcfx(bcfr parambcfr) {}
  
  public int a(bcgf parambcgf1, bcgf parambcgf2)
  {
    int j = -1;
    if (((parambcgf1 instanceof MessageForDeliverGiftTips)) && ((parambcgf2 instanceof MessageForDeliverGiftTips)))
    {
      parambcgf1 = (MessageForDeliverGiftTips)parambcgf1;
      parambcgf2 = (MessageForDeliverGiftTips)parambcgf2;
      int i;
      if ((parambcgf1.isToAll()) && (parambcgf2.isToAll())) {
        i = (int)(parambcgf1.time - parambcgf2.time);
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (parambcgf1.isToAll());
        if (parambcgf2.isToAll()) {
          return 1;
        }
        if ((parambcgf1.receiverUin == this.a.a.getLongAccountUin()) && (parambcgf2.receiverUin == this.a.a.getLongAccountUin())) {
          return (int)(parambcgf1.time - parambcgf2.time);
        }
        i = j;
      } while (parambcgf1.receiverUin == this.a.a.getLongAccountUin());
      if (parambcgf2.receiverUin == this.a.a.getLongAccountUin()) {
        return 1;
      }
      return (int)(parambcgf1.time - parambcgf2.time);
    }
    return (int)(parambcgf1.getShmsgseq() - parambcgf2.getShmsgseq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfx
 * JD-Core Version:    0.7.0.1
 */