import android.text.TextUtils;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.qphone.base.util.QLog;

public class asfj
  extends ajxj
{
  public asfj(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a(paramString))) {
      this.a.b();
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
        this.a.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asfj
 * JD-Core Version:    0.7.0.1
 */