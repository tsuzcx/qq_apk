import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import mqq.app.QQPermissionCallback;

public class atan
  implements QQPermissionCallback
{
  public atan(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((ExtendFriendLimitChatMatchFragment.a(this.a) != null) && (!ExtendFriendLimitChatMatchFragment.a(this.a).isFinishing())) {
      bhlq.a(ExtendFriendLimitChatMatchFragment.a(this.a), paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ExtendFriendLimitChatMatchFragment.g(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atan
 * JD-Core Version:    0.7.0.1
 */