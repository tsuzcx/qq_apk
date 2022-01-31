import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import java.util.Comparator;

class azfu
  implements Comparator<azgc>
{
  azfu(azfo paramazfo) {}
  
  public int a(azgc paramazgc1, azgc paramazgc2)
  {
    int j = -1;
    if (((paramazgc1 instanceof MessageForDeliverGiftTips)) && ((paramazgc2 instanceof MessageForDeliverGiftTips)))
    {
      paramazgc1 = (MessageForDeliverGiftTips)paramazgc1;
      paramazgc2 = (MessageForDeliverGiftTips)paramazgc2;
      int i;
      if ((paramazgc1.isToAll()) && (paramazgc2.isToAll())) {
        i = (int)(paramazgc1.time - paramazgc2.time);
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramazgc1.isToAll());
        if (paramazgc2.isToAll()) {
          return 1;
        }
        if ((paramazgc1.receiverUin == this.a.a.getLongAccountUin()) && (paramazgc2.receiverUin == this.a.a.getLongAccountUin())) {
          return (int)(paramazgc1.time - paramazgc2.time);
        }
        i = j;
      } while (paramazgc1.receiverUin == this.a.a.getLongAccountUin());
      if (paramazgc2.receiverUin == this.a.a.getLongAccountUin()) {
        return 1;
      }
      return (int)(paramazgc1.time - paramazgc2.time);
    }
    return (int)(paramazgc1.getShmsgseq() - paramazgc2.getShmsgseq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azfu
 * JD-Core Version:    0.7.0.1
 */