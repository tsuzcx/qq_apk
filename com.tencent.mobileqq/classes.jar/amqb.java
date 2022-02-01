import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class amqb
  extends anvi
{
  public amqb(HotChatCenterFragment paramHotChatCenterFragment) {}
  
  public void a(String paramString)
  {
    if (!paramString.equals(HotChatCenterFragment.a(this.a).getAccount())) {}
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    while ((HotChatCenterFragment.a(this.a).getCurrentAccountUin() == null) || (!HotChatCenterFragment.a(this.a).getCurrentAccountUin().equals(paramString))) {
      return;
    }
    ThreadManager.post(new HotChatCenterFragment.1.1(this, paramString), 8, null, true);
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void onUpdateRecentList()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqb
 * JD-Core Version:    0.7.0.1
 */