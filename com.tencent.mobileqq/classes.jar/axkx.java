import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class axkx
  implements Comparator<ReceiptMessageReadMemberListFragment.MemberInfo>
{
  public axkx(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public int a(ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo1, ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo2)
  {
    return ChnToSpell.a(paramMemberInfo1.b, 1).compareTo(ChnToSpell.a(paramMemberInfo2.b, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axkx
 * JD-Core Version:    0.7.0.1
 */