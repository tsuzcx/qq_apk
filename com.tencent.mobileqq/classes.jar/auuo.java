import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class auuo
{
  DatingConfig a;
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    for (;;)
    {
      try
      {
        QLog.d("nearby.redpoint", 1, "clearRedDotInNearbyEnter: redDotType=" + paramInt);
        paramQQAppInterface = (nan)paramQQAppInterface.getManager(70);
        if ((paramInt != 56) && (paramInt != 61)) {
          break label102;
        }
        paramQQAppInterface.a(56);
        paramQQAppInterface.a(61);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("nearby.redpoint", 2, "clearRedDotInNearbyEnter, exp=" + paramQQAppInterface.toString());
        return;
      }
      paramQQAppInterface.a(paramInt);
      return;
      label102:
      if (paramInt != 60) {
        if (paramInt != 57) {}
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    boolean bool2 = false;
    paramAppInterface = (String)auwq.a(paramAppInterface.getAccount(), "key_tabs_array", "");
    for (;;)
    {
      try
      {
        paramAppInterface = new JSONArray(paramAppInterface);
        int i = 0;
        bool1 = false;
        int j;
        bool4 = bool1;
      }
      catch (Exception paramAppInterface)
      {
        try
        {
          if (i < paramAppInterface.length())
          {
            j = paramAppInterface.optJSONObject(i).optInt("tabType");
            if (j == 1) {
              bool2 = true;
            }
            if (j == 5) {
              bool1 = true;
            }
            i += 1;
            continue;
          }
          bool3 = bool2;
          bool4 = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("NearbyConfigUtil", 2, "isNewNearbyTab: hasOldTab=" + bool3 + ", hasNewTab=" + bool4);
          }
          return bool4;
        }
        catch (Exception paramAppInterface)
        {
          boolean bool1;
          boolean bool3;
          boolean bool4;
          break label130;
        }
        paramAppInterface = paramAppInterface;
        bool2 = false;
        bool1 = false;
      }
      label130:
      bool3 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("NearbyConfigUtil", 2, "isNewNearbyTab:" + paramAppInterface.toString());
        bool4 = bool1;
        bool3 = bool2;
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, int paramInt)
  {
    bool2 = false;
    paramAppInterface = (String)auwq.a(paramAppInterface.getCurrentAccountUin(), "key_banner_enter_items", "");
    for (;;)
    {
      try
      {
        paramAppInterface = new JSONArray(paramAppInterface);
        i = 0;
        if (i >= paramAppInterface.length()) {
          continue;
        }
        JSONObject localJSONObject = paramAppInterface.optJSONObject(i);
        if (!localJSONObject.has("id")) {
          continue;
        }
        int j = localJSONObject.getInt("id");
        if (j != paramInt) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramAppInterface)
      {
        int i;
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NearbyConfigUtil", 2, "hasEnterItem:" + paramAppInterface.toString());
        bool1 = bool2;
        continue;
        bool1 = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NearbyConfigUtil", 2, "hasEnterItem: itemId=" + paramInt + ", ret=" + bool1);
      }
      return bool1;
      i += 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4);
    int i;
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("charm_level", 0);
    }
    for (;;)
    {
      if (i == 0) {}
      for (;;)
      {
        return false;
        paramQQAppInterface = BaseApplicationImpl.getContext().getSharedPreferences("nearby_enters", 4).getString("config_content", null);
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          try
          {
            paramQQAppInterface = new JSONObject(paramQQAppInterface).optJSONArray("nearby_list_entrance");
            if (paramQQAppInterface != null)
            {
              int j = 0;
              while (j < paramQQAppInterface.length())
              {
                JSONObject localJSONObject = paramQQAppInterface.optJSONObject(j);
                int k = localJSONObject.optInt("id");
                int m = localJSONObject.optInt("lv_limit");
                if ((k == paramInt) && (i >= m)) {
                  return true;
                }
                j += 1;
              }
              i = 0;
            }
          }
          catch (JSONException paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            return false;
          }
        }
      }
    }
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    int i = 0;
    paramAppInterface = (String)auwq.a(paramAppInterface.getAccount(), "key_tabs_array", "");
    try
    {
      paramAppInterface = new JSONArray(paramAppInterface);
      bool1 = false;
    }
    catch (Exception paramAppInterface)
    {
      try
      {
        if (i >= paramAppInterface.length()) {
          break label108;
        }
        int j = paramAppInterface.optJSONObject(i).optInt("tabType");
        if (j == 6) {
          bool1 = true;
        }
        i += 1;
      }
      catch (Exception paramAppInterface)
      {
        boolean bool1;
        boolean bool2;
        break label68;
      }
      paramAppInterface = paramAppInterface;
      bool1 = false;
    }
    bool2 = bool1;
    label68:
    bool2 = bool1;
    if (QLog.isColorLevel())
    {
      QLog.e("NearbyConfigUtil", 2, "hasNearbyMsgTab:" + paramAppInterface.toString());
      bool2 = bool1;
    }
    label108:
    if (QLog.isColorLevel()) {
      QLog.d("NearbyConfigUtil", 2, "isNewNearbyTab: hasMsgTab=" + bool2);
    }
    return bool2;
  }
  
  /* Error */
  public DatingConfig a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 193	auuo:a	Lcom/tencent/mobileqq/data/DatingConfig;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 193	auuo:a	Lcom/tencent/mobileqq/data/DatingConfig;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aconst_null
    //   19: astore_2
    //   20: iconst_1
    //   21: anewarray 195	java/lang/Class
    //   24: astore_3
    //   25: aload_3
    //   26: iconst_0
    //   27: ldc 4
    //   29: aastore
    //   30: ldc 197
    //   32: aload_3
    //   33: invokestatic 202	bdhb:a	(Ljava/lang/String;[Ljava/lang/Class;)[Ljava/lang/Object;
    //   36: astore 4
    //   38: aload_2
    //   39: astore_1
    //   40: aload 4
    //   42: ifnull -28 -> 14
    //   45: aload_2
    //   46: astore_1
    //   47: aload 4
    //   49: arraylength
    //   50: aload_3
    //   51: arraylength
    //   52: if_icmpne -38 -> 14
    //   55: aload 4
    //   57: iconst_0
    //   58: aaload
    //   59: checkcast 204	com/tencent/mobileqq/data/DatingConfig
    //   62: astore_1
    //   63: aload_0
    //   64: aload_1
    //   65: putfield 193	auuo:a	Lcom/tencent/mobileqq/data/DatingConfig;
    //   68: goto -54 -> 14
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	auuo
    //   13	52	1	localObject1	Object
    //   71	4	1	localObject2	Object
    //   19	27	2	localObject3	Object
    //   24	27	3	arrayOfClass	java.lang.Class[]
    //   36	20	4	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   2	14	71	finally
    //   20	25	71	finally
    //   30	38	71	finally
    //   47	68	71	finally
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 193	auuo:a	Lcom/tencent/mobileqq/data/DatingConfig;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 193	auuo:a	Lcom/tencent/mobileqq/data/DatingConfig;
    //   19: goto -8 -> 11
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	auuo
    //   6	2	1	localDatingConfig	DatingConfig
    //   22	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
    //   14	19	22	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auuo
 * JD-Core Version:    0.7.0.1
 */