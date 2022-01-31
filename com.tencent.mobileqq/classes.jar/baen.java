import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class baen
{
  public static void a()
  {
    a("0X8008CC3");
  }
  
  public static void a(int paramInt)
  {
    if (paramInt == 4) {
      a("0X8009187");
    }
    while (paramInt != 2) {
      return;
    }
    a("0X8009188");
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVGroupConfig", 1, "reportAVGroupNum, num[" + paramInt + "], isVideo[" + paramBoolean + "]");
    }
    HashMap localHashMap;
    if (paramBoolean)
    {
      localHashMap = new HashMap();
      localHashMap.put("num", String.valueOf(paramInt));
      UserAction.onUserAction("reportAVGroupNum_video", true, -1L, -1L, localHashMap, true);
    }
    for (;;)
    {
      localHashMap = new HashMap();
      localHashMap.put("isVideo", String.valueOf(paramBoolean));
      localHashMap.put("num", String.valueOf(paramInt));
      UserAction.onUserAction("reportAVGroupNum", true, -1L, -1L, localHashMap, true);
      return;
      localHashMap = new HashMap();
      localHashMap.put("num", String.valueOf(paramInt));
      UserAction.onUserAction("reportAVGroupNum_audio", true, -1L, -1L, localHashMap, true);
    }
  }
  
  public static void a(String paramString)
  {
    if (!QLog.isDevelopLevel()) {}
    for (;;)
    {
      awqx.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
      return;
      QLog.w("QAVGroupConfig", 1, "reportClickEvent, key[" + paramString + "]");
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("0X8008CC7");
      return;
    }
    a("0X8008CC8");
  }
  
  public static void b()
  {
    a("0X8008CC4");
  }
  
  public static void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("0X8008CBA");
      return;
    }
    a("0X8008CB5");
  }
  
  public static void c()
  {
    a("0X8008CC5");
  }
  
  public static void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("0X8008E7D");
      return;
    }
    a("0X8008E7E");
  }
  
  public static void d()
  {
    a("0X8008CC6");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baen
 * JD-Core Version:    0.7.0.1
 */