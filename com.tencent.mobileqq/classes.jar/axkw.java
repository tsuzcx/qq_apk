import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo;
import java.util.Comparator;

public class axkw
  implements Comparator<ReceiptMessageReadMemberListFragment.MemberInfo>
{
  public axkw(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public int a(ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo1, ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo2)
  {
    if (paramMemberInfo1.a == paramMemberInfo2.a) {
      return 0;
    }
    if (paramMemberInfo1.a < paramMemberInfo2.a) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axkw
 * JD-Core Version:    0.7.0.1
 */