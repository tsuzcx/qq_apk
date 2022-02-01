import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import java.util.Comparator;

class asmo
  implements Comparator<EmosmPb.SmallYellowItem>
{
  asmo(asmn paramasmn) {}
  
  public int a(EmosmPb.SmallYellowItem paramSmallYellowItem1, EmosmPb.SmallYellowItem paramSmallYellowItem2)
  {
    if (paramSmallYellowItem2.ts.get() > paramSmallYellowItem1.ts.get()) {
      return 1;
    }
    if (paramSmallYellowItem2.ts.get() == paramSmallYellowItem1.ts.get()) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmo
 * JD-Core Version:    0.7.0.1
 */