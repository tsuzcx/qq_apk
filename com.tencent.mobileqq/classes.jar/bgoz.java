import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import java.util.Comparator;

class bgoz
  implements Comparator<bgph>
{
  bgoz(bgot parambgot) {}
  
  public int a(bgph parambgph1, bgph parambgph2)
  {
    int j = -1;
    if (((parambgph1 instanceof MessageForDeliverGiftTips)) && ((parambgph2 instanceof MessageForDeliverGiftTips)))
    {
      parambgph1 = (MessageForDeliverGiftTips)parambgph1;
      parambgph2 = (MessageForDeliverGiftTips)parambgph2;
      int i;
      if ((parambgph1.isToAll()) && (parambgph2.isToAll())) {
        i = (int)(parambgph1.time - parambgph2.time);
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (parambgph1.isToAll());
        if (parambgph2.isToAll()) {
          return 1;
        }
        if ((parambgph1.receiverUin == this.a.a.getLongAccountUin()) && (parambgph2.receiverUin == this.a.a.getLongAccountUin())) {
          return (int)(parambgph1.time - parambgph2.time);
        }
        i = j;
      } while (parambgph1.receiverUin == this.a.a.getLongAccountUin());
      if (parambgph2.receiverUin == this.a.a.getLongAccountUin()) {
        return 1;
      }
      return (int)(parambgph1.time - parambgph2.time);
    }
    return (int)(parambgph1.getShmsgseq() - parambgph2.getShmsgseq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgoz
 * JD-Core Version:    0.7.0.1
 */