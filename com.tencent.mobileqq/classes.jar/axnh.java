import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import javax.annotation.Nullable;

public class axnh
  implements axni
{
  aqqi jdField_a_of_type_Aqqi;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public axnh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aqqi = ((aqqi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(338));
  }
  
  public int a()
  {
    return 7;
  }
  
  public bafb a()
  {
    return null;
  }
  
  public String a()
  {
    return axms.b;
  }
  
  public void a() {}
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, axnf> paramMap, @Nullable Bundle paramBundle)
  {
    QLog.i("WatchTogetherManager", 1, "notifySessionChange  serviceType = " + paramInt1 + " from = " + paramInt3);
  }
  
  public void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    if (paramInt == 4) {
      this.jdField_a_of_type_Aqqi.a();
    }
  }
  
  public void a(axnf paramaxnf, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    QLog.i("WatchTogetherManager", 1, "onPushMessageReceive");
    this.jdField_a_of_type_Aqqi.a((WatchTogetherSession)paramaxnf, paramInt);
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, Map<String, axnf> paramMap, @Nullable Bundle paramBundle)
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
        paramMap = (WatchTogetherSession)axng.a(2, 1, paramString);
        this.jdField_a_of_type_Aqqi.a(paramContext, paramMap, paramBundle);
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
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Map<String, axnf> paramMap, @Nullable Bundle paramBundle)
  {
    return true;
  }
  
  public boolean b(Context paramContext, String paramString, int paramInt1, int paramInt2, Map<String, axnf> paramMap, @Nullable Bundle paramBundle)
  {
    paramContext = (WatchTogetherSession)paramMap.get("2_1_" + paramString);
    QLog.i("WatchTogetherManager", 1, "join  groupuin = " + paramString + " from = " + paramInt2);
    if (paramInt2 == 2) {
      this.jdField_a_of_type_Aqqi.a("4", paramContext, paramBundle);
    }
    while ((paramInt2 != 1) || (paramContext == null)) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramContext.a)) && (!paramContext.a.contains("fromid"))) {
      paramContext.a = (paramContext.a + "&fromid=" + "10011");
    }
    this.jdField_a_of_type_Aqqi.a(paramContext, paramBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnh
 * JD-Core Version:    0.7.0.1
 */