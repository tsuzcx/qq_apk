import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class auss
{
  public static HashMap<String, Integer> a;
  public static HashMap<String, Integer> b;
  private static HashMap<String, Integer> c = new HashMap();
  
  static
  {
    c.put("hot_reactive_gray_intimate_lover_1_icon", Integer.valueOf(2130849612));
    c.put("hot_reactive_gray_intimate_lover_2_icon", Integer.valueOf(2130849613));
    c.put("hot_reactive_gray_intimate_lover_3_icon", Integer.valueOf(2130849614));
    c.put("hot_reactive_gray_intimate_guimi_1_icon", Integer.valueOf(2130849606));
    c.put("hot_reactive_gray_intimate_guimi_2_icon", Integer.valueOf(2130849607));
    c.put("hot_reactive_gray_intimate_guimi_3_icon", Integer.valueOf(2130849608));
    c.put("hot_reactive_gray_intimate_jiyou_1_icon", Integer.valueOf(2130849609));
    c.put("hot_reactive_gray_intimate_jiyou_2_icon", Integer.valueOf(2130849610));
    c.put("hot_reactive_gray_intimate_jiyou_3_icon", Integer.valueOf(2130849611));
    c.put("hot_reactive_gray_friendship_1_icon", Integer.valueOf(2130849603));
    c.put("hot_reactive_gray_friendship_2_icon", Integer.valueOf(2130849604));
    c.put("hot_reactive_gray_friendship_3_icon", Integer.valueOf(2130849605));
    c.put("gray_small_fire", Integer.valueOf(2130849630));
    c.put("gray_big_fire", Integer.valueOf(2130849589));
    c.put("gray_small_zan", Integer.valueOf(2130849634));
    c.put("gray_big_zan", Integer.valueOf(2130849593));
    c.put("gray_small_lover", Integer.valueOf(2130849622));
    c.put("gray_big_lover", Integer.valueOf(2130849621));
    c.put("qzone_gray_qzone_visit_normal", Integer.valueOf(2130849628));
    c.put("qzone_gray_qzone_visit_super", Integer.valueOf(2130849629));
    c.put("gray_small_ship", Integer.valueOf(2130849633));
    c.put("gray_big_ship", Integer.valueOf(2130849592));
    a = new HashMap();
    a.put("skin_icon_small_fire", Integer.valueOf(2130849630));
    a.put("skin_icon_big_fire", Integer.valueOf(2130849589));
    a.put("skin_icon_small_flower", Integer.valueOf(2130849633));
    a.put("skin_icon_big_flower", Integer.valueOf(2130849592));
    a.put("skin_icon_small_praise", Integer.valueOf(2130849634));
    a.put("skin_icon_big_praise", Integer.valueOf(2130849593));
    a.put("skin_icon_lover_small", Integer.valueOf(2130849622));
    a.put("skin_icon_lover_big", Integer.valueOf(2130849621));
    a.put("skin_icon_qzone_visit_normal", Integer.valueOf(2130849628));
    a.put("skin_icon_qzone_visit_super", Integer.valueOf(2130849629));
    a.put("skin_icon_frdship_1", Integer.valueOf(2130849603));
    a.put("skin_icon_frdship_2", Integer.valueOf(2130849604));
    a.put("skin_icon_frdship_3", Integer.valueOf(2130849605));
    a.put("skin_icon_intimate_lover_1", Integer.valueOf(2130849612));
    a.put("skin_icon_intimate_lover_2", Integer.valueOf(2130849613));
    a.put("skin_icon_intimate_lover_3", Integer.valueOf(2130849614));
    a.put("skin_icon_intimate_guimi_1", Integer.valueOf(2130849606));
    a.put("skin_icon_intimate_guimi_2", Integer.valueOf(2130849607));
    a.put("skin_icon_intimate_guimi_3", Integer.valueOf(2130849608));
    a.put("skin_icon_intimate_jiyou_1", Integer.valueOf(2130849609));
    a.put("skin_icon_intimate_jiyou_2", Integer.valueOf(2130849610));
    a.put("skin_icon_intimate_jiyou_3", Integer.valueOf(2130849611));
    a.put("skin_icon_mutual_x_character_1", Integer.valueOf(2130849627));
    a.put("skin_icon_mentorship", Integer.valueOf(2130849625));
    a.put("skin_icon_mentorship_svip", Integer.valueOf(2130849624));
    a.put("skin_icon_mentorship_yellowvip", Integer.valueOf(2130849626));
    a.put("skin_icon_mentorship_newyear", Integer.valueOf(2130849623));
    a.put("skin_icon_kapu_1", Integer.valueOf(2130849618));
    a.put("skin_icon_kapu_2", Integer.valueOf(2130849619));
    a.put("skin_icon_kapu_3", Integer.valueOf(2130849620));
    a.put("skin_icon_forget_me_not_1", Integer.valueOf(2130849600));
    a.put("skin_icon_forget_me_not_2", Integer.valueOf(2130849601));
    a.put("skin_icon_forget_me_not_3", Integer.valueOf(2130849602));
    b = new HashMap();
    b.putAll(c);
    b.putAll(a);
    b.putAll(aute.a);
  }
  
  public static int a()
  {
    return bdns.a(NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    return (int)(100000L + 10L * paramLong1 + paramLong2);
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      l = Long.valueOf(Long.parseLong(paramString)).longValue() % 10L;
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("MutualMarkUtils", 1, "getTypeLevel error:" + paramString.getMessage());
    }
    return 0L;
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_0
    //   4: ldc 250
    //   6: astore_3
    //   7: invokestatic 256	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 262	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   13: ldc_w 264
    //   16: invokevirtual 270	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_0
    //   22: aload_2
    //   23: astore_1
    //   24: aload_2
    //   25: invokestatic 275	ndq:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   28: astore 4
    //   30: aload 4
    //   32: astore_0
    //   33: aload_0
    //   34: astore_1
    //   35: aload_2
    //   36: ifnull +9 -> 45
    //   39: aload_2
    //   40: invokevirtual 280	java/io/InputStream:close	()V
    //   43: aload_0
    //   44: astore_1
    //   45: aload_1
    //   46: areturn
    //   47: astore_2
    //   48: aload_0
    //   49: astore_1
    //   50: aload_2
    //   51: invokevirtual 283	java/lang/Throwable:printStackTrace	()V
    //   54: aload_3
    //   55: astore_1
    //   56: aload_0
    //   57: ifnull -12 -> 45
    //   60: aload_0
    //   61: invokevirtual 280	java/io/InputStream:close	()V
    //   64: ldc 250
    //   66: areturn
    //   67: astore_0
    //   68: ldc 250
    //   70: areturn
    //   71: astore_0
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 280	java/io/InputStream:close	()V
    //   80: aload_0
    //   81: athrow
    //   82: astore_1
    //   83: aload_0
    //   84: areturn
    //   85: astore_1
    //   86: goto -6 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	58	0	localObject1	Object
    //   67	1	0	localIOException1	java.io.IOException
    //   71	13	0	str1	String
    //   1	76	1	localObject2	Object
    //   82	1	1	localIOException2	java.io.IOException
    //   85	1	1	localIOException3	java.io.IOException
    //   19	21	2	localInputStream	java.io.InputStream
    //   47	4	2	localThrowable	java.lang.Throwable
    //   6	49	3	str2	String
    //   28	3	4	str3	String
    // Exception table:
    //   from	to	target	type
    //   7	20	47	java/lang/Throwable
    //   24	30	47	java/lang/Throwable
    //   60	64	67	java/io/IOException
    //   7	20	71	finally
    //   24	30	71	finally
    //   50	54	71	finally
    //   39	43	82	java/io/IOException
    //   76	80	85	java/io/IOException
  }
  
  public static String a(int paramInt)
  {
    Iterator localIterator = a.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return (String)localEntry.getKey();
      }
    }
    localIterator = aute.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return (String)localEntry.getKey();
      }
    }
    return "";
  }
  
  public static String a(long paramLong1, long paramLong2)
  {
    return String.valueOf(100000L + 10L * paramLong1 + paramLong2);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return new String(bdfr.decode(paramString, 0));
  }
  
  public static ArrayList<ausu> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString);
    while (paramString.find())
    {
      ausu localausu = new ausu();
      localausu.jdField_a_of_type_JavaLangString = paramString.group();
      localausu.jdField_a_of_type_Int = paramString.start();
      localausu.jdField_b_of_type_Int = (localausu.jdField_a_of_type_Int + localausu.jdField_a_of_type_JavaLangString.length());
      localausu.jdField_b_of_type_JavaLangString = paramString.group(1);
      if ((!TextUtils.isEmpty(localausu.jdField_b_of_type_JavaLangString)) && (localausu.jdField_b_of_type_JavaLangString.contains("client/42px-")))
      {
        Matcher localMatcher = Pattern.compile("x_character/([^\\)]+?)/client").matcher(localausu.jdField_b_of_type_JavaLangString);
        if (localMatcher.find()) {
          localausu.c = localMatcher.group(1);
        }
      }
      localArrayList.add(localausu);
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkUtils", 2, "getMutualMarkImageUrlTemplateInfos. url:" + localausu.jdField_b_of_type_JavaLangString + " template:" + localausu.jdField_a_of_type_JavaLangString);
      }
    }
    return localArrayList;
  }
  
  public static List<String> a()
  {
    ArrayList localArrayList = new ArrayList(b.keySet());
    Collections.sort(localArrayList, new aust());
    return localArrayList;
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt <= 100000) || (paramInt >= 200000)) {}
    while (b(String.valueOf(paramInt)) <= 0L) {
      return false;
    }
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    if (paramLong <= 0L) {}
    int i;
    do
    {
      return false;
      i = a();
    } while ((i < 18) || (i >= 24) || (bdns.c(paramLong) == 2131720894));
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null)) {
      return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("hotDisableInteractive", 0) == 1;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.startsWith("#image_url"))
      {
        bool1 = bool2;
        if (Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString).matches()) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkUtils", 2, "isMutualMarkImageUrlTemplate. res:" + bool1 + " template:" + paramString);
    }
    return bool1;
  }
  
  public static long b(String paramString)
  {
    long l = 0L;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = Long.valueOf(Long.parseLong(paramString));
      l = (paramString.longValue() - 100000L - paramString.longValue() % 10L) / 10L;
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("MutualMarkUtils", 1, "getType error:" + paramString.getMessage());
    }
    return 0L;
  }
  
  public static String b(String paramString)
  {
    Object localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString);
    if (((Matcher)localObject).matches())
    {
      localObject = ((Matcher)localObject).group(1);
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkUtils", 2, "getMutualMarkImageUrlTemplateUrl. url:" + (String)localObject + " template:" + paramString);
      }
      return localObject;
    }
    return null;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 2097153) || (paramInt == 2097154) || (paramInt == 2097155);
  }
  
  public static boolean b(long paramLong)
  {
    boolean bool2 = false;
    long[] arrayOfLong = ausi.b;
    int j = arrayOfLong.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfLong[i] == paramLong) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean c(long paramLong)
  {
    long[] arrayOfLong;
    int j;
    int i;
    if (b(paramLong))
    {
      arrayOfLong = ausi.a;
      j = arrayOfLong.length;
      i = 0;
    }
    while (i < j)
    {
      if (arrayOfLong[i] == paramLong) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auss
 * JD-Core Version:    0.7.0.1
 */