import com.tencent.mobileqq.data.DiscussionMemberInfo;
import java.util.Comparator;

public class anju
  implements Comparator<DiscussionMemberInfo>
{
  public int a(DiscussionMemberInfo paramDiscussionMemberInfo1, DiscussionMemberInfo paramDiscussionMemberInfo2)
  {
    if ((paramDiscussionMemberInfo1 != null) && (paramDiscussionMemberInfo2 != null))
    {
      paramDiscussionMemberInfo1 = Long.valueOf(Long.parseLong(paramDiscussionMemberInfo1.memberUin));
      paramDiscussionMemberInfo2 = Long.valueOf(Long.parseLong(paramDiscussionMemberInfo2.memberUin));
      if (paramDiscussionMemberInfo1.longValue() <= paramDiscussionMemberInfo2.longValue()) {}
    }
    while (paramDiscussionMemberInfo1 != null)
    {
      return 1;
      if (paramDiscussionMemberInfo1.longValue() < paramDiscussionMemberInfo2.longValue()) {
        return -1;
      }
      return 0;
    }
    if (paramDiscussionMemberInfo2 != null) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anju
 * JD-Core Version:    0.7.0.1
 */