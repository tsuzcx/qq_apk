import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class awug
  extends anvi
{
  public awug(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  protected void onUpdateApolloHead(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.a.getCurrentAccountUin())) && (this.a.isAdded()) && (this.a.b != null))
    {
      this.a.b.removeMessages(1);
      this.a.b.sendEmptyMessage(1);
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a(paramString))) {
      this.a.a();
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MatchChatMsgListFragment", 2, "onUpdateFriendInfo uin =" + paramString);
      }
      int i = 0;
      if (this.a.a(paramString)) {
        i = 1;
      }
      if (i != 0) {
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awug
 * JD-Core Version:    0.7.0.1
 */