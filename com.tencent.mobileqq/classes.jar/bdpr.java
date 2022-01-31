import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class bdpr
{
  private static int a;
  public static boolean a;
  private static int jdField_b_of_type_Int;
  private static boolean jdField_b_of_type_Boolean;
  private static int c;
  private static int d;
  private static int e;
  private static int f;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = -1;
    jdField_e_of_type_Int = -1;
    jdField_f_of_type_Int = -1;
  }
  
  private static int a(Context paramContext)
  {
    int i = 0;
    paramContext = (Activity)paramContext;
    if ((paramContext instanceof FTSEntitySearchActivity)) {
      i = 2;
    }
    while (!(paramContext instanceof FTSEntitySearchDetailActivity)) {
      return i;
    }
    return 3;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("support_fts4_flag" + paramQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putInt("fts_upgrade_tables" + paramQQAppInterface.getCurrentAccountUin(), paramInt1 + paramInt2);
    int i = paramInt1;
    if (localEditor.commit()) {
      i = paramInt1 + paramInt2;
    }
    return i;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      paramString = paramString.split(" ");
    } while (paramString == null);
    return paramString.length;
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getLong("fts_upgrade_cost" + paramQQAppInterface.getCurrentAccountUin(), 0L);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putLong("fts_upgrade_cost" + paramQQAppInterface.getCurrentAccountUin(), paramLong1 + paramLong2);
    long l = paramLong1;
    if (localEditor.commit()) {
      l = paramLong1 + paramLong2;
    }
    return l;
  }
  
  public static Pair<CharSequence, CharSequence> a(aynq paramaynq)
  {
    if ((paramaynq instanceof aymf)) {
      return ((aymf)paramaynq).a();
    }
    if ((paramaynq instanceof ayme)) {
      return ((ayme)paramaynq).a();
    }
    return null;
  }
  
  public static FTSMessage a(ContentValues paramContentValues, MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      try
      {
        if (paramContentValues.containsKey("msgData"))
        {
          arrayOfByte = paramContentValues.getAsByteArray("msgData");
          if (arrayOfByte != null) {
            continue;
          }
          paramMessageRecord.msg = null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        byte[] arrayOfByte;
        localUnsupportedEncodingException.printStackTrace();
        paramMessageRecord.msg = null;
        continue;
      }
      if (paramContentValues.containsKey("time")) {
        paramMessageRecord.time = paramContentValues.getAsLong("time").longValue();
      }
      if (paramContentValues.containsKey("shmsgseq")) {
        paramMessageRecord.shmsgseq = paramContentValues.getAsLong("shmsgseq").longValue();
      }
      return FTSMessageCodec.a(paramMessageRecord);
      paramMessageRecord.msg = new String(arrayOfByte, "UTF-8");
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    do
    {
      return paramString1;
      switch (paramInt)
      {
      default: 
        return bdgc.a(paramQQAppInterface, paramString1, paramInt);
      }
      if (alof.G.equals(paramString1)) {
        return paramContext.getString(2131720532);
      }
      if (alof.J.equals(paramString1)) {
        return paramContext.getString(2131720531);
      }
      if (alof.E.equals(paramString1)) {
        return paramContext.getString(2131720599);
      }
      if (paramInt != 1000) {
        break;
      }
      paramContext = (TroopManager)paramQQAppInterface.getManager(52);
    } while (paramContext == null);
    return bdgc.a(paramQQAppInterface, paramString1, paramContext.b(paramString2), paramString2, true, null);
    if (paramInt == 1004)
    {
      paramContext = bdgc.c(paramQQAppInterface, paramString2, paramString1);
      if ((paramContext != null) && (paramContext.equals(paramString1))) {
        return bdgc.b(paramQQAppInterface, paramString1, true);
      }
    }
    else
    {
      return bdgc.a(paramQQAppInterface, paramString1, paramInt);
    }
    return paramContext;
  }
  
  public static String a(String paramString)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder(64);
        localasji = new asji(new StringReader(paramString), paramString.length());
        paramString = null;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder;
        asji localasji;
        asjf localasjf;
        localThrowable.printStackTrace();
        paramString = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.fts.utils", 2, "tokenSegment: failure", localThrowable);
      }
      try
      {
        localasjf = localasji.a();
        if (localasjf != null) {
          continue;
        }
        if ((paramString != null) && (TextUtils.equals(paramString.b(), "double")) && (!TextUtils.isEmpty(paramString.a())))
        {
          localStringBuilder.append(paramString.a().charAt(paramString.a().length() - 1));
          localStringBuilder.append("*");
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.fts.utils", 2, "tokenSegment: failure", paramString);
        continue;
      }
      paramString = localStringBuilder.toString();
      return paramString;
      if ((paramString != null) && (TextUtils.equals(paramString.b(), "double")) && ((!TextUtils.equals(localasjf.b(), "double")) || (paramString.b() < localasjf.a())) && (!TextUtils.isEmpty(paramString.a())))
      {
        localStringBuilder.append(paramString.a().charAt(paramString.a().length() - 1));
        localStringBuilder.append("*");
        localStringBuilder.append(' ');
      }
      if ((!TextUtils.isEmpty(localasjf.a())) && ((!TextUtils.equals(localasjf.b(), "double")) || (localasjf.a().length() != 1)))
      {
        localStringBuilder.append(localasjf.a());
        localStringBuilder.append(' ');
      }
      paramString = localasjf;
    }
    return null;
  }
  
  public static ArrayList<bdpt> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l1 = System.nanoTime();
    int m = paramString.length();
    int j = 0;
    int k = 0;
    int i;
    if (k < m)
    {
      if (paramString.charAt(k) < '') {}
      for (i = j + 1;; i = j + 2)
      {
        k += 1;
        j = i;
        break;
      }
    }
    m = j / 2 + 2;
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    if (j >= 3)
    {
      k = j * 2;
      localArrayList = new ArrayList();
      i = m;
      if (j >= 3)
      {
        localObject1 = paramQQAppInterface.getCurrentAccountUin();
        localObject2 = bdgc.b(paramQQAppInterface, (String)localObject1, true);
        if (!((String)localObject2).toLowerCase().startsWith(paramString.toLowerCase())) {
          break label429;
        }
        localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
        ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131167040)), 0, paramString.length(), 17);
        localArrayList.add(new bdpt((String)localObject1, 0, new Pair(localObject2, null)));
        i = m + 1;
      }
      label193:
      paramQQAppInterface = new aytg(paramQQAppInterface, 10001, 29, null);
      paramQQAppInterface.a();
      paramQQAppInterface = paramQQAppInterface.a(new ayuu(paramString));
      if ((paramQQAppInterface == null) || (paramQQAppInterface.isEmpty())) {
        break label923;
      }
      j = 0;
      localObject1 = paramQQAppInterface.iterator();
    }
    label349:
    label369:
    for (;;)
    {
      label248:
      if (((Iterator)localObject1).hasNext())
      {
        paramString = (aynq)((Iterator)localObject1).next();
        if ((paramString.b() & 0xFFFFFFFF & 0xFF000000) >> 24 != 2L) {
          if (localArrayList.size() < i)
          {
            if ((paramString.d() == 0) || (paramString.d() == 1004))
            {
              m = j + 1;
              paramQQAppInterface = a(paramString);
              localArrayList.add(new bdpt(paramString.b(), paramString.d(), paramQQAppInterface));
              j = m;
              if (!QLog.isColorLevel()) {
                continue;
              }
              if (paramString.b() != null) {
                break label767;
              }
              paramQQAppInterface = "null";
              j = paramString.d();
              if (paramString.a() != null) {
                break label775;
              }
            }
            for (paramString = "null";; paramString = paramString.a())
            {
              QLog.d("Q.fts.utils", 2, String.format("contactSearchForTopN, contact uin: %s, uinType: %d, matchTitle: %s", new Object[] { paramQQAppInterface, Integer.valueOf(j), paramString }));
              j = m;
              break label248;
              k = -1;
              break;
              if (((String)localObject1).toLowerCase().startsWith(paramString.toLowerCase()))
              {
                localObject3 = new SpannableStringBuilder("(" + (String)localObject1 + ")");
                ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131167040)), 1, paramString.length() + 1, 17);
                localArrayList.add(new bdpt((String)localObject1, 0, new Pair(localObject2, localObject3)));
                i = m + 1;
                break label193;
              }
              Object localObject3 = ayvm.a((String)localObject2, paramString, 1);
              if (localObject3[0] == 0)
              {
                i = localObject3[1];
                localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
                ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131167040)), 0, i, 17);
                localArrayList.add(new bdpt((String)localObject1, 0, new Pair(localObject2, null)));
                i = m + 1;
                break label193;
              }
              localObject3 = ayvm.a((String)localObject2, paramString, 2);
              i = m;
              if (localObject3[0] != 0) {
                break label193;
              }
              i = localObject3[1];
              localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
              ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131167040)), 0, i, 17);
              localArrayList.add(new bdpt((String)localObject1, 0, new Pair(localObject2, null)));
              i = m + 1;
              break label193;
              localArrayList.add(new bdpt(paramString.b(), paramString.d(), null));
              m = j;
              break label349;
              label767:
              paramQQAppInterface = paramString.b();
              break label369;
            }
          }
          else if (j < k)
          {
            if ((paramString.d() == 0) || (paramString.d() == 1004))
            {
              paramQQAppInterface = a(paramString);
              localArrayList.add(new bdpt(paramString.b(), paramString.d(), paramQQAppInterface));
              if (QLog.isColorLevel())
              {
                if (paramString.b() != null) {
                  break label907;
                }
                paramQQAppInterface = "null";
                m = paramString.d();
                if (paramString.a() != null) {
                  break label915;
                }
              }
              for (paramString = "null";; paramString = paramString.a())
              {
                QLog.d("Q.fts.utils", 2, String.format("contactSearchForTopN, contact uin: %s, uinType: %d, matchTitle: %s", new Object[] { paramQQAppInterface, Integer.valueOf(m), paramString }));
                j += 1;
                break;
                paramQQAppInterface = paramString.b();
                break label850;
              }
            }
          }
        }
      }
    }
    label429:
    label850:
    long l2 = System.nanoTime();
    label775:
    label907:
    label915:
    label923:
    if (QLog.isColorLevel())
    {
      QLog.d("Q.fts.utils", 2, "contactSearchForTopN, cost: " + (l2 - l1) / 1000000L + "ms size: " + localArrayList.size() + " contactNum: " + i + " friendNum: " + k);
      i = 0;
      while (i < localArrayList.size())
      {
        QLog.i("Q.fts.utils", 2, "index = " + i + ", contactInfo = " + localArrayList.get(i));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<String> a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.replaceAll("[^A-Za-z0-9\\u4e00-\\u9fa5]", " ").split("\\s");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      String str = paramString[i].trim();
      if ((str != null) && (!TextUtils.isEmpty(str))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(View paramView)
  {
    HashMap localHashMap = new HashMap();
    bdps.jdField_c_of_type_Int = a(paramView.getContext());
    paramView = (Integer)paramView.getTag(2131379972);
    if (paramView != null) {}
    for (int i = paramView.intValue();; i = -1)
    {
      bdps.jdField_e_of_type_Int = i + 1;
      if (bdps.jdField_f_of_type_Int == 1)
      {
        bdps.jdField_a_of_type_Long = bdps.jdField_d_of_type_Long + (System.nanoTime() - bdps.jdField_c_of_type_Long) / 1000000L;
        bdps.jdField_b_of_type_Long = bdps.jdField_f_of_type_Long + (System.nanoTime() - bdps.jdField_e_of_type_Long) / 1000000L;
      }
      if (bdps.jdField_d_of_type_Int == 1)
      {
        bdps.h = -1;
        bdps.i = -1;
        bdps.j = -1;
      }
      localHashMap.put("keyNum", String.valueOf(bdps.jdField_a_of_type_Int));
      localHashMap.put("firstKeyLen", String.valueOf(bdps.jdField_b_of_type_Int));
      localHashMap.put("itemPage", String.valueOf(bdps.jdField_c_of_type_Int));
      localHashMap.put("itemSearchStrategy", String.valueOf(bdps.jdField_d_of_type_Int));
      localHashMap.put("itemPosition", String.valueOf(bdps.jdField_e_of_type_Int));
      localHashMap.put("itemType", String.valueOf(bdps.jdField_f_of_type_Int));
      localHashMap.put("itemUinType", String.valueOf(bdps.g));
      if (bdps.jdField_f_of_type_Int == 1)
      {
        localHashMap.put("totalCost", String.valueOf(bdps.jdField_a_of_type_Long));
        localHashMap.put("searchCost", String.valueOf(bdps.jdField_b_of_type_Long));
      }
      localHashMap.put("senderNum", String.valueOf(bdps.h));
      localHashMap.put("friendNum", String.valueOf(bdps.i));
      localHashMap.put("friendIndex", String.valueOf(bdps.j));
      azri.a(BaseApplicationImpl.getApplication()).a(null, "actFtsItemClickEvent", true, bdps.jdField_a_of_type_Long, bdps.jdField_b_of_type_Long, localHashMap, "", false);
      if ((bdps.jdField_f_of_type_Int == 1) && (QLog.isColorLevel())) {
        QLog.d("Q.fts.utils", 2, "actFtsItemClickEvent: totalCost = " + bdps.jdField_a_of_type_Long + ", searchCost = " + bdps.jdField_b_of_type_Long);
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putInt("support_fts4_flag" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0);
    paramQQAppInterface = ((SharedPreferences)localObject).edit();
    localObject = ((SharedPreferences)localObject).getAll().keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (str.endsWith(paramString)) {
        paramQQAppInterface.remove(str);
      }
    }
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("fts_upgrade_log_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a()
  {
    boolean bool = false;
    PackageManager localPackageManager = BaseApplicationImpl.getApplication().getPackageManager();
    try
    {
      int i = localPackageManager.getApplicationInfo(BaseApplicationImpl.getApplication().getPackageName(), 0).flags;
      if ((i & 0x40000) != 0) {
        bool = true;
      }
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("Q.fts.utils", 2, "isInstallOnSDCard: failure", localException);
    }
    return bool;
    return false;
  }
  
  public static boolean a(ContentValues paramContentValues)
  {
    if ((paramContentValues.containsKey("msgtype")) && (paramContentValues.getAsInteger("msgtype").intValue() == -2006)) {}
    while ((paramContentValues.containsKey("isValid")) && (!paramContentValues.getAsBoolean("isValid").booleanValue())) {
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return (b(paramQQAppInterface) == 1) && (!b());
  }
  
  public static String[] a(String paramString)
  {
    int j = 0;
    Object localObject = a(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      String str = a((String)((ArrayList)localObject).get(i));
      if (!TextUtils.isEmpty(str)) {
        paramString.add(str.trim());
      }
      i += 1;
    }
    if (paramString.size() == 0) {
      return null;
    }
    localObject = new String[paramString.size()];
    i = j;
    while (i < paramString.size())
    {
      localObject[i] = ((String)paramString.get(i));
      i += 1;
    }
    return localObject;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    int i = a(paramQQAppInterface);
    if (i == -1)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        a(paramQQAppInterface, 1);
        return 1;
      }
      a(paramQQAppInterface, 0);
      return 0;
    }
    return i;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putInt("fts_upgrade_msgs" + paramQQAppInterface.getCurrentAccountUin(), paramInt1 + paramInt2);
    int i = paramInt1;
    if (localEditor.commit()) {
      i = paramInt1 + paramInt2;
    }
    return i;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSystemSharedPreferences("fts_sp_file", 0).edit();
    paramQQAppInterface.putInt("fts_crash_count_by_hook", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("fts_upgrade_table_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b()
  {
    if (jdField_a_of_type_Boolean) {
      return jdField_b_of_type_Boolean;
    }
    jdField_a_of_type_Boolean = true;
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "QQ install on SDCard");
      }
      if (!e((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_ROM", bdgk.j());
        azri.a(BaseApplication.getContext()).a(null, "actQQInstallExternal", true, -1L, 0L, (HashMap)localObject1, null, false);
        c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true);
      }
    }
    Object localObject1 = bdgk.a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.utils", 2, "Rom total size: " + localObject1[0] + " MB, Rom available size: " + localObject1[1] + " MB");
    }
    if (localObject1[0] == -1L)
    {
      jdField_b_of_type_Boolean = true;
      return true;
    }
    try
    {
      Object localObject2 = BaseApplicationImpl.getApplication().getFilesDir().getPath();
      long l = Math.ceil(new File(((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("/")) + "/databases", BaseApplicationImpl.getApplication().getRuntime().getAccount() + ".db").length() / 1048576.0D);
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.utils", 2, "uin.db size: " + l + " MB");
      }
      if (localObject1[1] > 5L * l)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.utils", 2, "NOT Low Rom For FTS");
        }
        jdField_b_of_type_Boolean = false;
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.utils", 2, "IS Low Rom For FTS");
      }
      if (!f((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("param_ROM", bdgk.j());
        ((HashMap)localObject2).put("param_totalrom", String.valueOf(localObject1[0]));
        ((HashMap)localObject2).put("param_availrom", String.valueOf(localObject1[1]));
        ((HashMap)localObject2).put("param_dbsize", String.valueOf(l));
        azri.a(BaseApplication.getContext()).a(null, "actLowRomForFTS", true, -1L, 0L, (HashMap)localObject2, null, false);
        d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true);
      }
      jdField_b_of_type_Boolean = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "isLowRomForFTS: failure", localException);
      }
      jdField_b_of_type_Boolean = true;
    }
    return true;
  }
  
  public static boolean b(ContentValues paramContentValues)
  {
    if (paramContentValues.containsKey("msgData")) {}
    while ((paramContentValues.containsKey("time")) || (paramContentValues.containsKey("shmsgseq"))) {
      return true;
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("fts_upgrade_log_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static String[] b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localObject = new StringBuilder(32);
    paramString = new asjj(new StringReader(paramString));
    try
    {
      for (;;)
      {
        asjf localasjf = paramString.a();
        if (localasjf == null) {
          break;
        }
        if (!TextUtils.isEmpty(localasjf.a()))
        {
          ((StringBuilder)localObject).append(localasjf.a());
          ((StringBuilder)localObject).append(' ');
        }
      }
      int i;
      return localObject;
    }
    catch (IOException paramString)
    {
      ((StringBuilder)localObject).setLength(0);
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "keywordSegment: failure", paramString);
      }
      paramString = new ArrayList();
      if (((StringBuilder)localObject).length() > 0) {
        paramString.add(((StringBuilder)localObject).toString().trim());
      }
      if (paramString.size() == 0) {
        return null;
      }
      localObject = new String[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        localObject[i] = ((String)paramString.get(i));
        i += 1;
      }
    }
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_upgrade_tables" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("install_external_report_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("fts_upgrade_table_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static int d(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_upgrade_msgs" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("low_rom_for_fts_report_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    return (b(paramQQAppInterface)) && (c(paramQQAppInterface));
  }
  
  public static int e(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Int == -1) {
      jdField_a_of_type_Int = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_compare_flag" + paramQQAppInterface.getCurrentAccountUin(), 0);
    }
    return jdField_a_of_type_Int;
  }
  
  public static void e(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("hardware_support_fts_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("install_external_report_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static int f(QQAppInterface paramQQAppInterface)
  {
    return BaseApplicationImpl.sApplication.getSystemSharedPreferences("fts_sp_file", 0).getInt("fts_crash_count_by_hook", 0);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("fts_first_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("low_rom_for_fts_report_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static int g(QQAppInterface paramQQAppInterface)
  {
    if (jdField_b_of_type_Int == -1) {
      jdField_b_of_type_Int = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_extension_flag" + paramQQAppInterface.getCurrentAccountUin(), 1);
    }
    return jdField_b_of_type_Int;
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("hardware_support_fts_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static int h(QQAppInterface paramQQAppInterface)
  {
    if (jdField_c_of_type_Int == -1) {
      jdField_c_of_type_Int = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_extension_conversation_flag" + paramQQAppInterface.getCurrentAccountUin(), 0);
    }
    return jdField_c_of_type_Int;
  }
  
  public static boolean h(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("fts_first_flag" + paramQQAppInterface.getCurrentAccountUin(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpr
 * JD-Core Version:    0.7.0.1
 */