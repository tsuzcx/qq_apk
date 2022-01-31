import com.tencent.mobileqq.data.TroopAssistantData;
import java.util.Comparator;

class arja
  implements Comparator<TroopAssistantData>
{
  arja(ariz paramariz) {}
  
  public int a(TroopAssistantData paramTroopAssistantData1, TroopAssistantData paramTroopAssistantData2)
  {
    long l1 = Math.max(paramTroopAssistantData1.lastmsgtime, paramTroopAssistantData1.lastdrafttime);
    long l2 = Math.max(paramTroopAssistantData2.lastmsgtime, paramTroopAssistantData2.lastdrafttime);
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arja
 * JD-Core Version:    0.7.0.1
 */