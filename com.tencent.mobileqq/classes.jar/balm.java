import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import javax.annotation.Nullable;

public class balm
  implements baln
{
  atbq jdField_a_of_type_Atbq;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public balm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    return 7;
  }
  
  public atbq a()
  {
    if (this.jdField_a_of_type_Atbq == null) {
      this.jdField_a_of_type_Atbq = ((atbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(338));
    }
    return this.jdField_a_of_type_Atbq;
  }
  
  public bdfq a()
  {
    return null;
  }
  
  public String a()
  {
    return bakx.b;
  }
  
  public void a() {}
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, balk> paramMap, @Nullable Bundle paramBundle)
  {
    QLog.i("WatchTogetherManager", 1, "notifySessionChange  serviceType = " + paramInt1 + " from = " + paramInt3);
  }
  
  public void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    if (paramInt == 4) {
      a().a();
    }
  }
  
  public void a(balk parambalk, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    QLog.i("WatchTogetherManager", 1, "onPushMessageReceive");
    a().a((WatchTogetherSession)parambalk, paramInt);
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, Map<String, balk> paramMap, @Nullable Bundle paramBundle)
  {
    if (paramInt2 == 0) {}
    for (paramContext = "2";; paramContext = "")
    {
      QLog.i("WatchTogetherManager", 1, "start  groupuin = " + paramString + " miniapp_from = " + paramContext);
      WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)paramMap.get("2_1_" + paramString);
      paramMap = localWatchTogetherSession;
      if (localWatchTogetherSession == null) {}
      try
      {
        paramMap = (WatchTogetherSession)ball.a(2, 1, paramString);
        a().a(paramContext, paramMap, paramBundle);
        return false;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramMap = localWatchTogetherSession;
        }
      }
    }
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Map<String, balk> paramMap, @Nullable Bundle paramBundle)
  {
    return true;
  }
  
  public boolean b(Context paramContext, String paramString, int paramInt1, int paramInt2, Map<String, balk> paramMap, @Nullable Bundle paramBundle)
  {
    paramContext = (WatchTogetherSession)paramMap.get("2_1_" + paramString);
    QLog.i("WatchTogetherManager", 1, "join  groupuin = " + paramString + " from = " + paramInt2);
    if (paramInt2 == 2) {
      a().a("4", paramContext, paramBundle);
    }
    while (((paramInt2 != 1) && (paramInt2 != 8)) || (paramContext == null)) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramContext.a)) && (!paramContext.a.contains("fromid"))) {
      paramContext.a = (paramContext.a + "&fromid=" + "10011");
    }
    a().a(paramContext, paramBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     balm
 * JD-Core Version:    0.7.0.1
 */