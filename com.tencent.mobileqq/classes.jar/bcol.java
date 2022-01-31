import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import java.util.Comparator;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.TopicItem;

public class bcol
  implements Comparator<oidb_0xd9f.TopicItem>
{
  public bcol(ProfileCardMoreInfoView paramProfileCardMoreInfoView) {}
  
  public int a(oidb_0xd9f.TopicItem paramTopicItem1, oidb_0xd9f.TopicItem paramTopicItem2)
  {
    if (paramTopicItem1 == null) {}
    do
    {
      return 1;
      if (paramTopicItem2 == null) {
        return -1;
      }
    } while (paramTopicItem1.uint32_frd_num.get() <= paramTopicItem2.uint32_frd_num.get());
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcol
 * JD-Core Version:    0.7.0.1
 */