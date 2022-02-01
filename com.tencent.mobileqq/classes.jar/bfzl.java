import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import java.util.Comparator;

class bfzl
  implements Comparator<TroopMessageNavigateInfo>
{
  public int a(TroopMessageNavigateInfo paramTroopMessageNavigateInfo1, TroopMessageNavigateInfo paramTroopMessageNavigateInfo2)
  {
    if (paramTroopMessageNavigateInfo1.type == paramTroopMessageNavigateInfo2.type)
    {
      int i = 0;
      if (paramTroopMessageNavigateInfo1.msgseq > paramTroopMessageNavigateInfo2.msgseq) {
        i = -1;
      }
      while (paramTroopMessageNavigateInfo1.msgseq >= paramTroopMessageNavigateInfo2.msgseq) {
        return i;
      }
      return 1;
    }
    return -(bfyj.a(paramTroopMessageNavigateInfo1.type) - bfyj.a(paramTroopMessageNavigateInfo2.type));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzl
 * JD-Core Version:    0.7.0.1
 */