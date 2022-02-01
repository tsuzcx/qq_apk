import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import mqq.manager.Manager;

public class antp
  implements Manager
{
  private QQAppInterface a;
  
  public antp(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      throw new NullPointerException("RecentManagerFor3rdPart, app is null");
    }
    this.a = paramQQAppInterface;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if ((this.a != null) && (this.a.f()))
    {
      aong localaong = this.a.a().a();
      paramString = (RecentUser)localaong.findRecentUser(paramString, paramInt);
      if (paramString != null)
      {
        localaong.delRecentUser(paramString);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    if ((this.a != null) && (this.a.f()))
    {
      aong localaong = this.a.a().a();
      paramString = (RecentUser)localaong.findRecentUser(paramString, paramInt);
      if (paramString != null)
      {
        paramString.lastmsgtime = paramLong;
        localaong.saveRecentUser(paramString);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if ((this.a != null) && (this.a.f()))
    {
      aong localaong = this.a.a().a();
      RecentUser localRecentUser = (RecentUser)localaong.findRecentUserByUin(paramString1, paramInt);
      localRecentUser.uin = paramString1;
      localRecentUser.setType(paramInt);
      localRecentUser.displayName = paramString2;
      localRecentUser.lastmsgtime = paramLong1;
      localRecentUser.lastmsgdrafttime = paramLong2;
      localaong.saveRecentUser(localRecentUser);
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     antp
 * JD-Core Version:    0.7.0.1
 */