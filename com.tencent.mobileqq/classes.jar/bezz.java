import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

public class bezz
  implements Comparator<Friend>
{
  public bezz(FriendChooser paramFriendChooser) {}
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return paramFriend1.g.compareToIgnoreCase(paramFriend2.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezz
 * JD-Core Version:    0.7.0.1
 */