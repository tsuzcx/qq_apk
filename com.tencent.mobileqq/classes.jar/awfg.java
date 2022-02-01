import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class awfg
  extends anvi
{
  public awfg(ListenTogetherManager paramListenTogetherManager) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("ListenTogether.Manager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if (paramBoolean)
    {
      String str = awfq.a(2, String.valueOf(paramObject));
      if (ListenTogetherManager.a(this.a).equals(str))
      {
        ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).h = 3;
        ((ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a))).i = 3;
        aweq.b(ListenTogetherManager.a(this.a), String.valueOf(paramObject), false);
        this.a.a(true, (ListenTogetherSession)ListenTogetherManager.a(this.a).get(ListenTogetherManager.a(this.a)), 1007);
        this.a.a(2, String.valueOf(paramObject), false);
      }
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    ListenTogetherSession localListenTogetherSession = this.a.a(2, paramString);
    if ((paramBoolean) && (localListenTogetherSession != null) && (localListenTogetherSession.e.equals(paramString)) && (ListenTogetherManager.a(this.a, localListenTogetherSession)))
    {
      QLog.d("ListenTogether.Manager", 1, String.format("onUpdateFriendInfo uin=%s mutual level changed", new Object[] { localListenTogetherSession.e }));
      ListenTogetherManager.a(this.a, localListenTogetherSession);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfg
 * JD-Core Version:    0.7.0.1
 */