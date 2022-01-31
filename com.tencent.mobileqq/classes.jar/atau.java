import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor.1;
import com.tencent.mobileqq.nearby.NearbyReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;

public class atau
{
  public static int a;
  static aqyf[] jdField_a_of_type_ArrayOfAqyf = new aqyf[3];
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "nearby_leba", "nearby_msgbox", "nearby_guide" };
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      atbr.a("preloadNearbyProcess", new Object[0]);
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), NearbyReceiver.class);
    localIntent.putExtra("nearby_preload_from", 1);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {
      try
      {
        if (jdField_a_of_type_ArrayOfAqyf[paramInt] == null) {
          jdField_a_of_type_ArrayOfAqyf[paramInt] = new aqyf(jdField_a_of_type_ArrayOfJavaLangString[paramInt], "com.tencent.mobileqq:tool");
        }
        for (;;)
        {
          jdField_a_of_type_ArrayOfAqyf[paramInt].a();
          return;
          jdField_a_of_type_ArrayOfAqyf[paramInt].d();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isDevelopLevel()) {
          atbr.a("NearbyProcessMonitor", "preloadHitSession", new Object[] { localThrowable.toString() });
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject5 = null;
    if (QLog.isColorLevel()) {
      atbr.a("NearbyProcessMonitor", new Object[] { "dataUpgrade" });
    }
    if (((Boolean)atbi.a(paramString, "nearby_sp_upgrade_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (;;)
    {
      return;
      try
      {
        localObject1 = BaseApplicationImpl.getApplication().getAppRuntime(paramString);
      }
      catch (AccountNotMatchException localException1)
      {
        try
        {
          Object localObject1;
          if ((localObject1 instanceof QQAppInterface))
          {
            Object localObject2 = (QQAppInterface)localObject1;
            Object localObject4 = localObject1;
            localObject1 = localObject2;
            while (localObject1 != null)
            {
              if (!atbi.a(paramString, "self_gender"))
              {
                localObject2 = ((ajxl)((QQAppInterface)localObject4).getManager(51)).b(paramString);
                if (localObject2 != null)
                {
                  localObject4 = (aszf)((QQAppInterface)localObject1).getManager(106);
                  if (QLog.isColorLevel()) {
                    atbr.a("NearbyProcessMonitor", new Object[] { "gender", Short.valueOf(((Card)localObject2).shGender) });
                  }
                  if (localObject4 != null) {
                    ((aszf)localObject4).b(((Card)localObject2).shGender);
                  }
                }
              }
              if (!atbi.a(paramString, "hotchat_tab_switch")) {}
              try
              {
                i = ((QQAppInterface)localObject1).getPreferences().getInt("hotchat_tab_switch", 0);
                if (QLog.isColorLevel())
                {
                  if (i == 0)
                  {
                    bool = true;
                    atbr.a("NearbyProcessMonitor", new Object[] { "hotchat_tab_swtich", Boolean.valueOf(bool) });
                  }
                }
                else
                {
                  if (i != 0) {
                    break label644;
                  }
                  bool = true;
                  atbi.a(paramString, "hotchat_tab_switch", Boolean.valueOf(bool));
                  if (atbi.a(paramString, "supportHotChatDemo")) {}
                }
              }
              catch (Exception localException1)
              {
                try
                {
                  for (;;)
                  {
                    i = ((QQAppInterface)localObject1).getPreferences().getInt("supportHotChatDemo", 0);
                    if (QLog.isColorLevel())
                    {
                      if (i != 1) {
                        break label661;
                      }
                      bool = true;
                      atbr.a("NearbyProcessMonitor", new Object[] { "hotchat_demo_switch", Boolean.valueOf(bool) });
                    }
                    if (i != 1) {
                      break label666;
                    }
                    bool = true;
                    atbi.a(paramString, "supportHotChatDemo", Boolean.valueOf(bool));
                    if (!atbi.a(paramString, "ShowFreshNews"))
                    {
                      bool = BaseApplicationImpl.getApplication().getSharedPreferences("FRESHNEWS_SP", 0).getBoolean(paramString + "ShowFreshNews", true);
                      if (QLog.isColorLevel()) {
                        atbr.a("NearbyProcessMonitor", new Object[] { "freshnews_tab_switch", Boolean.valueOf(bool) });
                      }
                      atbi.a(paramString, "ShowFreshNews", Boolean.valueOf(bool));
                    }
                    if (!atbi.a(paramString, "nearby_enter_time"))
                    {
                      long l = BaseApplicationImpl.getApplication().getSharedPreferences("sp_nearbyrecommender", 0).getLong(paramString + "_key_enter_nearby_time", 0L);
                      if (QLog.isColorLevel()) {
                        atbr.a("NearbyProcessMonitor", new Object[] { "entry_time", Long.valueOf(l) });
                      }
                      atbi.a(paramString, "nearby_enter_time", Long.valueOf(l));
                    }
                    if (!atbi.a(paramString, "self_god_flag"))
                    {
                      bool = ((QQAppInterface)localObject1).getApp().getSharedPreferences("dating_pref" + paramString, 0).getBoolean("toplist_self_is_god", false);
                      if (QLog.isColorLevel()) {
                        atbr.a("NearbyProcessMonitor", new Object[] { "god", Boolean.valueOf(bool) });
                      }
                      atbi.a(paramString, "self_god_flag", Boolean.valueOf(bool));
                    }
                    if (!atbi.a(paramString, "nearby_people_disclaimer_ok_5.8.0")) {
                      atbi.a(paramString, "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(((QQAppInterface)localObject1).getPreferences().getBoolean("nearby_people_disclaimer_ok_5.8.0", false)));
                    }
                    atbi.a(paramString, "nearby_sp_upgrade_flag", Boolean.valueOf(true));
                    return;
                    localAccountNotMatchException1 = localAccountNotMatchException1;
                    localObject1 = null;
                    localAccountNotMatchException1.printStackTrace();
                    localObject4 = localObject1;
                    localObject1 = localObject5;
                    break;
                    localException1 = localException1;
                    i = 0;
                    continue;
                    bool = false;
                  }
                  label644:
                  bool = false;
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    localException2.printStackTrace();
                    int i = 0;
                    continue;
                    label661:
                    boolean bool = false;
                    continue;
                    label666:
                    bool = false;
                  }
                }
              }
            }
          }
        }
        catch (AccountNotMatchException localAccountNotMatchException2)
        {
          for (;;)
          {
            continue;
            Object localObject3 = null;
          }
        }
      }
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      atbr.a("startNearbyProcess", new Object[] { Integer.valueOf(paramInt) });
    }
    a(paramInt);
    if (aqyf.a("com.tencent.mobileqq:tool")) {
      if (QLog.isColorLevel()) {
        atbr.a("NearbyProcess is exist", new Object[0]);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt < 0) || (paramInt >= 3)) {
            break label140;
          }
          if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.disable_preload_nearby_process.name(), "0"))) {
            break;
          }
        } while (!QLog.isColorLevel());
        atbr.a("dpc disable preload nearby process", new Object[0]);
        return;
      } while (!atbi.e(paramString));
      if (jdField_a_of_type_Int <= 10) {
        break;
      }
    } while (!QLog.isColorLevel());
    atbr.a("cation: preload  to much times, ", new Object[] { Integer.valueOf(jdField_a_of_type_Int) });
    return;
    label140:
    ThreadManager.post(new NearbyProcessMonitor.1(paramString), 10, null, false);
  }
  
  public static void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {}
    try
    {
      if (jdField_a_of_type_ArrayOfAqyf[paramInt] != null) {
        jdField_a_of_type_ArrayOfAqyf[paramInt].b();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isDevelopLevel()) {}
      atbr.a("NearbyProcessMonitor", "reportSessionHit", new Object[] { localThrowable.toString() });
    }
  }
  
  public static void b(String paramString)
  {
    if (!atbi.a(paramString, "self_school_name")) {
      for (;;)
      {
        try
        {
          Object localObject1 = BaseApplicationImpl.getApplication().getAppRuntime(paramString);
          if (!(localObject1 instanceof QQAppInterface)) {
            break label147;
          }
          localObject1 = (QQAppInterface)localObject1;
          localObject2 = ((ajxl)((QQAppInterface)localObject1).getManager(51)).c(paramString);
          if (localObject2 != null)
          {
            localObject1 = ((Card)localObject2).strSchool;
            localObject2 = localObject1;
            if (localObject1 != null)
            {
              atbi.a(paramString, "self_school_name", localObject1);
              localObject2 = localObject1;
            }
            if (!atbr.b()) {
              break;
            }
            atbr.a("NearbyProcessMonitor", new Object[] { "checkSchoolName", localObject2 });
            return;
          }
          localObject1 = (NearbyPeopleCard)((QQAppInterface)localObject1).getEntityManagerFactory().createEntityManager().a(NearbyPeopleCard.class, "uin=?", new String[] { paramString });
          if (localObject1 != null)
          {
            localObject1 = ((NearbyPeopleCard)localObject1).college;
            continue;
          }
          localObject1 = null;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
          return;
        }
        continue;
        label147:
        Object localObject2 = null;
      }
    }
  }
  
  public static void b(String paramString, int paramInt)
  {
    axrn localaxrn = axrn.a(BaseApplicationImpl.getContext());
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localaxrn.a(paramString, "actCheckHasUnreadMsg", bool, paramInt, 0L, null, "");
      return;
    }
  }
  
  public static void c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {}
    try
    {
      if (jdField_a_of_type_ArrayOfAqyf[paramInt] != null) {
        jdField_a_of_type_ArrayOfAqyf[paramInt].d();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isDevelopLevel()) {}
      atbr.a("NearbyProcessMonitor", "reportSessionEnd", new Object[] { localThrowable.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atau
 * JD-Core Version:    0.7.0.1
 */