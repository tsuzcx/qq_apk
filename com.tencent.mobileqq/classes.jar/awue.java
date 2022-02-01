import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class awue
  extends aslz
{
  public awue(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatMsgListFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
    if ((this.a.a != null) && (this.a.a.isResume()) && (!MatchChatMsgListFragment.a(this.a))) {
      MatchChatMsgListFragment.a(this.a, asru.a(this.a.a, this.a.a.app, MatchChatMsgListFragment.a(this.a)));
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatMsgListFragment", 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    MatchChatMsgListFragment.a(this.a, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awue
 * JD-Core Version:    0.7.0.1
 */