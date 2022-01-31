import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import java.util.Comparator;

class bahl
  implements Comparator<baht>
{
  bahl(bahf parambahf) {}
  
  public int a(baht parambaht1, baht parambaht2)
  {
    int j = -1;
    if (((parambaht1 instanceof MessageForDeliverGiftTips)) && ((parambaht2 instanceof MessageForDeliverGiftTips)))
    {
      parambaht1 = (MessageForDeliverGiftTips)parambaht1;
      parambaht2 = (MessageForDeliverGiftTips)parambaht2;
      int i;
      if ((parambaht1.isToAll()) && (parambaht2.isToAll())) {
        i = (int)(parambaht1.time - parambaht2.time);
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (parambaht1.isToAll());
        if (parambaht2.isToAll()) {
          return 1;
        }
        if ((parambaht1.receiverUin == this.a.a.getLongAccountUin()) && (parambaht2.receiverUin == this.a.a.getLongAccountUin())) {
          return (int)(parambaht1.time - parambaht2.time);
        }
        i = j;
      } while (parambaht1.receiverUin == this.a.a.getLongAccountUin());
      if (parambaht2.receiverUin == this.a.a.getLongAccountUin()) {
        return 1;
      }
      return (int)(parambaht1.time - parambaht2.time);
    }
    return (int)(parambaht1.getShmsgseq() - parambaht2.getShmsgseq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bahl
 * JD-Core Version:    0.7.0.1
 */