import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class aznp
  implements Comparator<MessageRecord>
{
  aznp(azno paramazno) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    int j = 0;
    long l1 = paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq;
    int i;
    if (l1 == 0L) {
      if ((paramMessageRecord1.msgtype == -1012) || (paramMessageRecord1.msgtype == -5021))
      {
        i = 1;
        if ((paramMessageRecord2.msgtype == -1012) || (paramMessageRecord2.msgtype == -5021)) {
          j = 1;
        }
        if (i == 0) {
          break label111;
        }
        if (j == 0) {
          break label105;
        }
        l1 = paramMessageRecord1.time - paramMessageRecord2.time;
      }
    }
    for (;;)
    {
      label86:
      long l2;
      if (l1 > 0L) {
        l2 = 1L;
      }
      for (;;)
      {
        return (int)l2;
        i = 0;
        break;
        label105:
        l1 = 1L;
        break label86;
        label111:
        if (j != 0)
        {
          l1 = -1L;
          break label86;
        }
        break label86;
        l2 = l1;
        if (l1 < 0L) {
          l2 = -1L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aznp
 * JD-Core Version:    0.7.0.1
 */