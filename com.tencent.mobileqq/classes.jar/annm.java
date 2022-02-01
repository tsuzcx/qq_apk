import com.tencent.mobileqq.data.HotChatItemData;
import java.util.Comparator;

class annm
  implements Comparator<HotChatItemData>
{
  annm(annl paramannl) {}
  
  public int a(HotChatItemData paramHotChatItemData1, HotChatItemData paramHotChatItemData2)
  {
    long l1 = paramHotChatItemData1.mMakeTopTime;
    long l2 = paramHotChatItemData2.mMakeTopTime;
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annm
 * JD-Core Version:    0.7.0.1
 */