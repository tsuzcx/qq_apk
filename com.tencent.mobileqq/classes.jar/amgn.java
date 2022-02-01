import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.Comparator;

public class amgn
  implements Comparator<TroopMemberInfo>
{
  private amgn(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public int a(TroopMemberInfo paramTroopMemberInfo1, TroopMemberInfo paramTroopMemberInfo2)
  {
    if ((paramTroopMemberInfo1 != null) && (paramTroopMemberInfo1.displayedNamePinyinFirst != null) && (paramTroopMemberInfo2 != null)) {
      return paramTroopMemberInfo1.displayedNamePinyinFirst.compareToIgnoreCase(paramTroopMemberInfo2.displayedNamePinyinFirst);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgn
 * JD-Core Version:    0.7.0.1
 */