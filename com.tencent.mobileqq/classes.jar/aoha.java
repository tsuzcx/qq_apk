import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;

public class aoha
  extends aoeu
{
  public aoha(ExtendFriendFragment paramExtendFriendFragment) {}
  
  protected void a(int paramInt)
  {
    asfj.a(this.a.a, ExtendFriendFragment.a(this.a).app);
    Intent localIntent = new Intent("match_chat_notify_update");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoha
 * JD-Core Version:    0.7.0.1
 */