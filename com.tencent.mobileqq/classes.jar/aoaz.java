import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.PluginConfig.PluginConfig.GetResourceReq;
import tencent.im.PluginConfig.PluginConfig.GetResourceReqInfo;

public class aoaz
{
  public static int a(int paramInt)
  {
    return paramInt / 1000;
  }
  
  public static int a(aoax paramaoax)
  {
    if (paramaoax == null) {
      return 0;
    }
    return paramaoax.jdField_a_of_type_Int * 1000 + paramaoax.b;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int i;
    if (paramQQAppInterface == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = paramQQAppInterface.getPreferences().getInt("sp_key_leba_group_seq", 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("LebaHelper", 2, "getLebaGroup, seq=" + j);
    return j;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramQQAppInterface.getPreferences().getLong("sp_key_leba_plugin_user_sort_time" + paramInt, 0L);
  }
  
  /* Error */
  public static List<aoax> a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 39
    //   8: iconst_2
    //   9: ldc 76
    //   11: invokestatic 79	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 81	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 82	java/util/ArrayList:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 23	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   26: ldc 84
    //   28: ldc 86
    //   30: invokeinterface 90 3 0
    //   35: astore_0
    //   36: new 92	org/json/JSONArray
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 95	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   44: astore_0
    //   45: iconst_0
    //   46: istore_1
    //   47: iload_1
    //   48: aload_0
    //   49: invokevirtual 99	org/json/JSONArray:length	()I
    //   52: if_icmpge +126 -> 178
    //   55: aload_0
    //   56: iload_1
    //   57: invokevirtual 103	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   60: astore 4
    //   62: aload 4
    //   64: invokevirtual 109	org/json/JSONObject:names	()Lorg/json/JSONArray;
    //   67: astore 5
    //   69: aload 5
    //   71: ifnull +150 -> 221
    //   74: new 10	aoax
    //   77: dup
    //   78: invokespecial 110	aoax:<init>	()V
    //   81: astore 6
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_2
    //   86: aload 5
    //   88: invokevirtual 99	org/json/JSONArray:length	()I
    //   91: if_icmpge +89 -> 180
    //   94: aload 5
    //   96: iload_2
    //   97: invokevirtual 113	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   100: astore 7
    //   102: ldc 115
    //   104: aload 7
    //   106: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   109: ifeq +18 -> 127
    //   112: aload 6
    //   114: aload 4
    //   116: aload 7
    //   118: invokevirtual 124	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   121: putfield 127	aoax:jdField_a_of_type_Long	J
    //   124: goto +104 -> 228
    //   127: ldc 129
    //   129: aload 7
    //   131: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +18 -> 152
    //   137: aload 6
    //   139: aload 4
    //   141: aload 7
    //   143: invokevirtual 132	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   146: putfield 13	aoax:jdField_a_of_type_Int	I
    //   149: goto +79 -> 228
    //   152: ldc 134
    //   154: aload 7
    //   156: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   159: ifeq +69 -> 228
    //   162: aload 6
    //   164: aload 4
    //   166: aload 7
    //   168: invokevirtual 132	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   171: putfield 16	aoax:b	I
    //   174: goto +54 -> 228
    //   177: astore_0
    //   178: aload_3
    //   179: areturn
    //   180: aload_3
    //   181: aload 6
    //   183: invokeinterface 139 2 0
    //   188: pop
    //   189: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +29 -> 221
    //   195: ldc 39
    //   197: iconst_2
    //   198: new 41	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   205: ldc 86
    //   207: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 6
    //   212: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 79	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: iload_1
    //   222: iconst_1
    //   223: iadd
    //   224: istore_1
    //   225: goto -178 -> 47
    //   228: iload_2
    //   229: iconst_1
    //   230: iadd
    //   231: istore_2
    //   232: goto -147 -> 85
    //   235: astore 7
    //   237: goto -9 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramQQAppInterface	QQAppInterface
    //   46	179	1	i	int
    //   84	148	2	j	int
    //   21	160	3	localArrayList	ArrayList
    //   60	105	4	localJSONObject	JSONObject
    //   67	28	5	localJSONArray	JSONArray
    //   81	130	6	localaoax	aoax
    //   100	67	7	str	String
    //   235	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   36	45	177	org/json/JSONException
    //   47	69	177	org/json/JSONException
    //   74	83	177	org/json/JSONException
    //   85	102	177	org/json/JSONException
    //   102	124	177	org/json/JSONException
    //   127	149	177	org/json/JSONException
    //   152	174	177	org/json/JSONException
    //   180	221	177	org/json/JSONException
    //   102	124	235	java/lang/Exception
    //   127	149	235	java/lang/Exception
    //   152	174	235	java/lang/Exception
  }
  
  public static List<Integer> a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    localArrayList = new ArrayList();
    QQAppInterface localQQAppInterface = null;
    try
    {
      paramQQAppInterface = paramQQAppInterface.getPreferences().getString("sp_key_leba_plugin_user_sort_list" + paramInt, "");
      localQQAppInterface = paramQQAppInterface;
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        localQQAppInterface = paramQQAppInterface;
        JSONArray localJSONArray = new JSONArray(paramQQAppInterface);
        paramInt = 0;
        for (;;)
        {
          localQQAppInterface = paramQQAppInterface;
          if (paramInt >= localJSONArray.length()) {
            break;
          }
          localQQAppInterface = paramQQAppInterface;
          localArrayList.add(Integer.valueOf(localJSONArray.getInt(paramInt)));
          paramInt += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.i("leba_sort", 1, "getSortInfo " + localQQAppInterface, paramQQAppInterface);
    }
  }
  
  public static Map<Long, aoax> a(List<aoax> paramList)
  {
    if (paramList == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aoax localaoax = (aoax)paramList.next();
      if (localaoax != null) {
        localHashMap.put(Long.valueOf(localaoax.jdField_a_of_type_Long), localaoax);
      }
    }
    return localHashMap;
  }
  
  public static PluginConfig.GetResourceReq a(int paramInt, List<LebaPluginInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)paramList.next();
        if (localLebaPluginInfo != null)
        {
          PluginConfig.GetResourceReqInfo localGetResourceReqInfo = new PluginConfig.GetResourceReqInfo();
          localGetResourceReqInfo.res_id.set((int)localLebaPluginInfo.uiResId);
          localGetResourceReqInfo.res_seq.set(localLebaPluginInfo.sResSeq);
          localArrayList.add(localGetResourceReqInfo);
        }
      }
    }
    if (bduy.a()) {}
    for (int i = 4026;; i = 4000)
    {
      QLog.i("LebaHelper", 1, "getLebaPluginListReq pluginType = " + i);
      paramList = new PluginConfig.GetResourceReq();
      paramList.plugin_type.set(i);
      paramList.plugin_layout_seq.set(paramInt);
      paramList.reqinfo_list.set(localArrayList);
      return paramList;
    }
  }
  
  public static void a(SharedPreferences paramSharedPreferences, List<Integer> paramList, Long paramLong, int paramInt)
  {
    try
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      JSONArray localJSONArray = new JSONArray();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Integer localInteger = (Integer)paramList.next();
          if (localInteger != null) {
            localJSONArray.put(localInteger);
          }
        }
        paramSharedPreferences.putString("sp_key_leba_plugin_user_sort_list" + paramInt, localJSONArray.toString());
      }
    }
    catch (Exception paramSharedPreferences)
    {
      QLog.i("leba_sort", 1, "saveSortInfo", paramSharedPreferences);
      return;
    }
    if (paramLong != null) {
      paramSharedPreferences.putLong("sp_key_leba_plugin_user_sort_time" + paramInt, paramLong.longValue());
    }
    paramSharedPreferences.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putString("sp_key_leba_upgrade_info", "4745");
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, String.format("update version, buildNum[%s]", new Object[] { "4745" }));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "saveLebaGroupSeq，seq=" + paramInt);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("sp_key_leba_group_seq", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    QLog.i("LebaHelper", 1, "saveLebaInfo,layoutType = " + paramInt1 + ",pluginType" + paramInt2);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("sp_key_leba_layout_type", paramInt1);
    paramQQAppInterface.putInt("sp_key_leba_plugin_type", paramInt2);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<aoax> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "saveGroupInfo");
    }
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          aoax localaoax = (aoax)paramList.next();
          if (localaoax == null) {
            continue;
          }
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("uiResId", localaoax.jdField_a_of_type_Long);
            localJSONObject.put("groudId", localaoax.jdField_a_of_type_Int);
            localJSONObject.put("index", localaoax.b);
            localJSONArray.put(localJSONObject);
            if (QLog.isColorLevel()) {
              QLog.i("LebaHelper", 2, "" + localaoax);
            }
          }
          catch (JSONException paramList)
          {
            QLog.e("LebaHelper", 1, "saveGroupInfo, exp=", paramList);
          }
        }
      }
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putString("sp_key_leba_group_info", localJSONArray.toString());
      paramQQAppInterface.commit();
    } while (!QLog.isColorLevel());
    QLog.i("LebaHelper", 2, "saveGroupInfo, result=" + true);
  }
  
  public static void a(List<arsh> paramList)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(paramList.size());
    localLinkedHashSet.addAll(paramList);
    paramList.clear();
    paramList.addAll(localLinkedHashSet);
  }
  
  public static void a(List<arsh> paramList1, List<arsh> paramList2)
  {
    Collections.sort(paramList2, new aoba());
    paramList2 = paramList2.iterator();
    int i = 0;
    int j = -1;
    if (paramList2.hasNext())
    {
      arsh localarsh1 = (arsh)paramList2.next();
      arsh localarsh2;
      if (a(localarsh1.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority) != j)
      {
        localarsh2 = new arsh();
        if (paramList1.size() > 0) {
          if (i < 2)
          {
            ((arsh)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
            label101:
            localarsh2.jdField_a_of_type_JavaLangString = "empty_normal";
            label109:
            paramList1.add(localarsh2);
            j = a(localarsh1.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority);
            localarsh1.jdField_a_of_type_Int = 1;
            i = 1;
          }
        }
      }
      for (;;)
      {
        paramList1.add(localarsh1);
        break;
        ((arsh)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
        break label101;
        localarsh2.jdField_a_of_type_JavaLangString = "empty_normal";
        break label109;
        i += 1;
        localarsh1.jdField_a_of_type_Int = 3;
      }
    }
    if (paramList1.size() > 0)
    {
      if (i < 2) {
        ((arsh)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    ((arsh)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  public static boolean a(arsh paramarsh)
  {
    if ((paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cDataType == 1) && (!TextUtils.isEmpty(paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))) {
      return "qzone_feedlist".equals(paramarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (bduy.a()) {}
    for (int i = 4026; i != b(paramQQAppInterface); i = 4000) {
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return true;
      if (7720L == paramLong)
      {
        int i = bhsi.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
        asvi localasvi = (asvi)paramQQAppInterface.getManager(264);
        boolean bool = atbf.a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("LebaUtil", 2, "filterPlugin kuolie showEntry = " + bool);
        }
        if ((i == 1) && (localasvi.d()) && (bool)) {}
        for (bool = false;; bool = true) {
          return bool;
        }
      }
      if (7759L != paramLong) {
        break;
      }
      paramQQAppInterface = ((aqyp)paramQQAppInterface.getManager(269)).a();
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.i < 1));
    return false;
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean, Map<Long, LebaPluginInfo> paramMap)
  {
    if (paramLong == 100000L) {
      return (!paramBoolean) && (paramQQAppInterface.a() != null) && (paramQQAppInterface.a().a());
    }
    boolean bool;
    if (paramBoolean)
    {
      paramQQAppInterface = (LebaPluginInfo)paramMap.get(Long.valueOf(paramLong));
      if ((paramQQAppInterface != null) && ((paramQQAppInterface == null) || (paramQQAppInterface.showInSimpleMode != 0))) {
        break label144;
      }
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "needShowRedDot, id=" + paramLong + ", isSimpleMode=" + paramBoolean + ", needShow=" + bool);
      }
      return bool;
      if (!akgr.a().a(paramQQAppInterface, paramLong)) {
        bool = false;
      } else {
        label144:
        bool = true;
      }
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return -1;
    }
    int i = paramQQAppInterface.getPreferences().getInt("sp_key_leba_plugin_type", 0);
    QLog.i("LebaHelper", 1, "getLebaPluginType =" + i);
    return i;
  }
  
  public static void b(List<arsh> paramList, List<Integer> paramList1)
  {
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        QLog.i("leba_sort", 1, "userSortList == null || userSortList.isEmpty()");
        Collections.sort(paramList, new aoba());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("sortTableItem");
      localStringBuilder.append(" us=").append(paramList1);
      ArrayList localArrayList = new ArrayList();
      Collections.sort(paramList, new aoba());
      Iterator localIterator = paramList.iterator();
      arsh localarsh;
      while (localIterator.hasNext())
      {
        localarsh = (arsh)localIterator.next();
        for (;;)
        {
          try
          {
            j = paramList1.indexOf(Integer.valueOf((int)localarsh.jdField_a_of_type_Long));
            if (j < 0) {
              continue;
            }
            localarsh.b = j;
          }
          catch (Exception localException)
          {
            QLog.i("leba_sort", 1, "sortTableItem", localException);
            continue;
            localStringBuilder.append(",fix ").append(localarsh.jdField_a_of_type_Long);
          }
          if (localarsh.c()) {
            continue;
          }
          localArrayList.add(localarsh);
          break;
          localarsh.b = 2147483647;
        }
      }
      QLog.i("leba_sort", 1, localStringBuilder.toString());
      Collections.sort(localArrayList, new aobb());
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        k = j;
        if (!((arsh)paramList.get(i)).c())
        {
          k = j;
          if (j < localArrayList.size())
          {
            paramList.set(i, localArrayList.get(j));
            k = j + 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().getString("sp_key_leba_upgrade_info", "");
    if (!"4745".equals(paramQQAppInterface)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaHelper", 2, String.format("update version isAppUpgrade[%b], preBuildNum[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), paramQQAppInterface, "4745" }));
      }
      return bool;
    }
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return -1;
    }
    int i = paramQQAppInterface.getPreferences().getInt("sp_key_leba_layout_type", 0);
    QLog.d("LebaHelper", 1, "getLebaLayoutType =" + i);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoaz
 * JD-Core Version:    0.7.0.1
 */