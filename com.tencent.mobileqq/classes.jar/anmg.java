import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import appoint.define.appoint_define.AppointID;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NearByMessageType;

public class anmg
{
  public static String a = "";
  public static String b = "";
  
  public static String a(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = Long.valueOf(NetConnInfoCenter.getServerTimeMillis());
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(((Long)localObject1).longValue());
    Long localLong = Long.valueOf(1000L * paramLong);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(localLong.longValue());
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1970, 0, 1, 0, 0, 0);
    long l = localCalendar2.getTime().getTime() - 1000L;
    paramLong = (((Long)localObject1).longValue() - l) / 1000L / 86400L;
    l = (localLong.longValue() - l) / 1000L / 86400L;
    int i = -1;
    int j = 0;
    if (l == paramLong) {
      i = 2131720335;
    }
    while (paramInt == 5) {
      if (i != -1)
      {
        return BaseApplication.getContext().getResources().getString(i);
        if (l == 1L + paramLong) {
          i = 2131720336;
        } else if (l == 2L + paramLong) {
          i = 2131689858;
        } else if (l == paramLong - 1L) {
          i = 2131720919;
        } else if (l == paramLong - 2L) {
          i = 2131690456;
        } else if (localCalendar1.get(1) == ((Calendar)localObject2).get(1)) {
          j = 1;
        } else {
          j = 0;
        }
      }
      else
      {
        if (j == 0)
        {
          if (paramBoolean) {}
          for (localObject1 = "yyyy年M月d日";; localObject1 = "yyyy-MM-dd")
          {
            localObject1 = new SimpleDateFormat((String)localObject1);
            return ((SimpleDateFormat)localObject1).format(localCalendar1.getTime());
          }
        }
        if (paramBoolean) {}
        for (localObject1 = "M月d日";; localObject1 = "MM-dd")
        {
          localObject1 = new SimpleDateFormat((String)localObject1);
          break;
        }
      }
    }
    if (i != -1)
    {
      localObject2 = BaseApplication.getContext();
      if (paramBoolean) {}
      for (localObject1 = ",H点m分";; localObject1 = " HH:mm")
      {
        localObject1 = new SimpleDateFormat((String)localObject1);
        return ((Context)localObject2).getResources().getString(i) + ((SimpleDateFormat)localObject1).format(localCalendar1.getTime());
      }
    }
    if (j == 0)
    {
      if (paramBoolean) {}
      for (localObject1 = "yyyy年M月d日,HH点mm分";; localObject1 = "yyyy-MM-dd HH:mm")
      {
        localObject1 = new SimpleDateFormat((String)localObject1);
        return ((SimpleDateFormat)localObject1).format(localCalendar1.getTime());
      }
    }
    if (paramBoolean) {}
    for (localObject1 = "M月d日,H点m分";; localObject1 = "MM-dd HH:mm")
    {
      localObject1 = new SimpleDateFormat((String)localObject1);
      break;
    }
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    paramLong = 1000L * paramLong;
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i = (int)(l / 86400000L);
    int j = (int)(paramLong / 86400000L);
    int k = (int)(l - paramLong) / 86400000;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    if (k < 0)
    {
      if (paramBoolean) {}
      for (localObject = "yyyy年M月d日 H点m分";; localObject = "yyyy-MM-dd HH:mm") {
        return new SimpleDateFormat((String)localObject).format(localCalendar.getTime());
      }
    }
    if (k == 0)
    {
      i = (int)((l - paramLong) / 3600000L);
      if (i <= 0) {
        return ajyc.a(2131702854);
      }
      return String.format("%d小时前", new Object[] { Integer.valueOf(i) });
    }
    if (i == j + 1)
    {
      if (paramBoolean) {}
      for (localObject = "H点m分";; localObject = "HH:mm")
      {
        localObject = new SimpleDateFormat((String)localObject).format(localCalendar.getTime());
        return String.format(ajyc.a(2131702855), new Object[] { localObject });
      }
    }
    if (i == j + 2)
    {
      if (paramBoolean) {}
      for (localObject = "H点m分";; localObject = "HH:mm")
      {
        localObject = new SimpleDateFormat((String)localObject).format(localCalendar.getTime());
        return String.format(ajyc.a(2131702856), new Object[] { localObject });
      }
    }
    if (localCalendar.get(1) == ((Calendar)localObject).get(1))
    {
      if (paramBoolean) {}
      for (localObject = "M月d日 H点m分";; localObject = "MM-dd HH:mm") {
        return new SimpleDateFormat((String)localObject).format(localCalendar.getTime());
      }
    }
    if (paramBoolean) {}
    for (localObject = "yyyy年M月d日 H点m分";; localObject = "yyyy-MM-dd HH:mm") {
      return new SimpleDateFormat((String)localObject).format(localCalendar.getTime());
    }
  }
  
  public static String a(appoint_define.AppointID paramAppointID)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAppointID != null)
    {
      localObject1 = localObject2;
      if (paramAppointID.str_request_id != null)
      {
        localObject1 = localObject2;
        if (paramAppointID.str_request_id.has()) {
          localObject1 = paramAppointID.str_request_id.get();
        }
      }
    }
    return localObject1;
  }
  
  public static im_msg_body.Elem a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1;
    im_msg_body.NearByMessageType localNearByMessageType;
    if (paramMessageRecord.istroop != 1010)
    {
      localObject1 = localObject2;
      if (paramMessageRecord.istroop != 1001) {}
    }
    else if (paramMessageRecord.msgtype != -1000)
    {
      localObject1 = localObject2;
      if (paramMessageRecord.msgtype != -2000) {}
    }
    else
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("nearby_clearing_msg")))
      {
        localNearByMessageType = new im_msg_body.NearByMessageType();
        if (paramMessageRecord.msgtype != -1000) {
          break label104;
        }
        localNearByMessageType.uint32_type.set(1);
      }
    }
    for (;;)
    {
      localObject1 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject1).near_by_msg.set(localNearByMessageType);
      label104:
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (paramMessageRecord.msgtype != -2000);
      localNearByMessageType.uint32_type.set(2);
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    paramActivity.runOnUiThread(new DatingUtil.1(paramActivity, paramString));
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 1001)) && ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -2000)))
    {
      paramMessageRecord.saveExtInfoToExtStr("nearby_clearing_msg", "true");
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_bank", 2, "setClearingMessage|istroop:" + paramMessageRecord.istroop + ",msgType:" + paramMessageRecord.msgtype);
      }
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs) {}
  
  public static boolean a()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)localBaseApplication.getSystemService("phone");
    if (localTelephonyManager != null) {}
    try
    {
      CellLocation localCellLocation = localTelephonyManager.getCellLocation();
      int i = localTelephonyManager.getSimState();
      int j;
      if (i == 5) {
        j = 1;
      }
      for (;;)
      {
        try
        {
          bool = TextUtils.isEmpty(bbct.b());
          if (bool) {
            continue;
          }
          i = 1;
        }
        catch (Exception localException2)
        {
          boolean bool;
          i = 1;
          continue;
        }
        if ((j == 0) || (i == 0) || (localCellLocation != null)) {
          break label95;
        }
        bool = a(localBaseApplication);
        if (bool) {
          break label95;
        }
        return true;
        j = 0;
        continue;
        i = 0;
      }
      label95:
      return false;
    }
    catch (Exception localException1) {}
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    try
    {
      int i = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on");
      return i == 1;
    }
    catch (Settings.SettingNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    boolean bool3 = false;
    if (paramMessage.extStr != null) {}
    for (;;)
    {
      try
      {
        bool1 = new JSONObject(paramMessage.extStr).optBoolean("one_way");
        paramQQAppInterface = paramQQAppInterface.a();
        boolean bool2 = bool3;
        if (paramQQAppInterface != null)
        {
          bool2 = bool3;
          if (paramQQAppInterface.a(paramMessage.istroop) > 0)
          {
            bool2 = bool3;
            if (bool1) {
              bool2 = true;
            }
          }
        }
        return bool2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      boolean bool1 = false;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    return paramQQAppInterface.a().a(paramString, 1010).hasReply;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramQQAppInterface = paramQQAppInterface.a();
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.e(paramString, paramInt) <= 0));
    return true;
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString).append(", [");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]).append(",");
        i += 1;
      }
      localStringBuilder.append("]");
      QLog.i("Q.dating", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = paramQQAppInterface.a(true).a(paramString);
    if (paramString != null)
    {
      paramQQAppInterface = ((bcic)paramQQAppInterface.a(107)).a("");
      if ((paramString.isGameRoom) || (paramString.troopUin.equals(paramQQAppInterface.a))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramQQAppInterface = paramQQAppInterface.a();
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.d(paramString, paramInt) <= 0));
    return true;
  }
  
  public static void c(String paramString, Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anmg
 * JD-Core Version:    0.7.0.1
 */