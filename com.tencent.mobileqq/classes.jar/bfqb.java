import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class bfqb
  implements Comparator<MessageRecord>
{
  bfqb(bfqa parambfqa) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    int j = 0;
    long l3 = 1L;
    long l1 = paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq;
    int i;
    label87:
    long l2;
    boolean bool2;
    if (l1 == 0L) {
      if ((paramMessageRecord1.msgtype == -1012) || (adak.j(paramMessageRecord1.msgtype)))
      {
        i = 1;
        if ((paramMessageRecord2.msgtype == -1012) || (adak.j(paramMessageRecord2.msgtype))) {
          j = 1;
        }
        if (!avpe.a(paramMessageRecord1)) {
          break label157;
        }
        l1 = paramMessageRecord1.time - paramMessageRecord2.time;
        l2 = l1;
        if (l1 == 0L)
        {
          boolean bool1 = adak.r(paramMessageRecord1.msgtype);
          bool2 = adak.r(paramMessageRecord2.msgtype);
          if (!bool1) {
            break label208;
          }
          if (!bool2) {
            break label202;
          }
          l2 = paramMessageRecord1.time - paramMessageRecord2.time;
        }
      }
    }
    for (;;)
    {
      label137:
      if (l2 > 0L) {
        l1 = l3;
      }
      for (;;)
      {
        return (int)l1;
        i = 0;
        break;
        label157:
        if (i != 0)
        {
          if (j != 0)
          {
            l1 = paramMessageRecord1.time - paramMessageRecord2.time;
            break label87;
          }
          l1 = 1L;
          break label87;
        }
        if (j != 0)
        {
          l1 = -1L;
          break label87;
        }
        break label87;
        label202:
        l2 = 1L;
        break label137;
        label208:
        l2 = l1;
        if (!bool2) {
          break label137;
        }
        l2 = -1L;
        break label137;
        if (l2 < 0L) {
          l1 = -1L;
        } else {
          l1 = l2;
        }
      }
      l2 = l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqb
 * JD-Core Version:    0.7.0.1
 */