import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import java.util.Comparator;

class bfoy
  implements Comparator<bfpg>
{
  bfoy(bfos parambfos) {}
  
  public int a(bfpg parambfpg1, bfpg parambfpg2)
  {
    int j = -1;
    if (((parambfpg1 instanceof MessageForDeliverGiftTips)) && ((parambfpg2 instanceof MessageForDeliverGiftTips)))
    {
      parambfpg1 = (MessageForDeliverGiftTips)parambfpg1;
      parambfpg2 = (MessageForDeliverGiftTips)parambfpg2;
      int i;
      if ((parambfpg1.isToAll()) && (parambfpg2.isToAll())) {
        i = (int)(parambfpg1.time - parambfpg2.time);
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (parambfpg1.isToAll());
        if (parambfpg2.isToAll()) {
          return 1;
        }
        if ((parambfpg1.receiverUin == this.a.a.getLongAccountUin()) && (parambfpg2.receiverUin == this.a.a.getLongAccountUin())) {
          return (int)(parambfpg1.time - parambfpg2.time);
        }
        i = j;
      } while (parambfpg1.receiverUin == this.a.a.getLongAccountUin());
      if (parambfpg2.receiverUin == this.a.a.getLongAccountUin()) {
        return 1;
      }
      return (int)(parambfpg1.time - parambfpg2.time);
    }
    return (int)(parambfpg1.getShmsgseq() - parambfpg2.getShmsgseq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfoy
 * JD-Core Version:    0.7.0.1
 */