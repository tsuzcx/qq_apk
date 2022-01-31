import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class avor
  implements Comparator<ReceiptMessageReadMemberListFragment.MemberInfo>
{
  public avor(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public int a(ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo1, ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo2)
  {
    return ChnToSpell.a(paramMemberInfo1.b, 1).compareTo(ChnToSpell.a(paramMemberInfo2.b, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avor
 * JD-Core Version:    0.7.0.1
 */