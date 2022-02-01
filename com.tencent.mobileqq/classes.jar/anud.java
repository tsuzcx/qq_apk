import android.text.TextUtils;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class anud
{
  public static void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord.saveExtInfoToExtStr("commen_flash_pic", "true");
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.msgtype == -2000) {
      paramMessageRecord.saveExtInfoToExtStr("commen_flash_pic", paramBoolean + "");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("FlashPicHelper", 4, "setFlashPicFlag,troopUin:" + paramMessageRecord.frienduin + ",isReaded:" + paramBoolean + ",msgType:" + paramMessageRecord.msgtype);
    }
  }
  
  public static boolean a(int paramInt, HotChatManager paramHotChatManager, String paramString)
  {
    return ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000)) && (!paramHotChatManager.b(paramString));
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null) {
      if (paramMessageRecord.msgtype != -2000)
      {
        bool1 = bool2;
        if (paramMessageRecord.msgtype != -2006) {}
      }
      else
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("commen_flash_pic"))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = Boolean.valueOf(paramMessageRecord.getExtInfoFromExtStr("commen_flash_pic")).booleanValue();
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anud
 * JD-Core Version:    0.7.0.1
 */