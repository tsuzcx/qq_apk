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

public class axma
{
  public static HashMap<String, Integer> a;
  public static HashMap<String, Integer> b;
  private static HashMap<String, Integer> c = new HashMap();
  
  static
  {
    c.put("hot_reactive_gray_intimate_lover_1_icon", Integer.valueOf(2130850192));
    c.put("hot_reactive_gray_intimate_lover_2_icon", Integer.valueOf(2130850193));
    c.put("hot_reactive_gray_intimate_lover_3_icon", Integer.valueOf(2130850194));
    c.put("hot_reactive_gray_intimate_guimi_1_icon", Integer.valueOf(2130850186));
    c.put("hot_reactive_gray_intimate_guimi_2_icon", Integer.valueOf(2130850187));
    c.put("hot_reactive_gray_intimate_guimi_3_icon", Integer.valueOf(2130850188));
    c.put("hot_reactive_gray_intimate_jiyou_1_icon", Integer.valueOf(2130850189));
    c.put("hot_reactive_gray_intimate_jiyou_2_icon", Integer.valueOf(2130850190));
    c.put("hot_reactive_gray_intimate_jiyou_3_icon", Integer.valueOf(2130850191));
    c.put("hot_reactive_gray_friendship_1_icon", Integer.valueOf(2130850183));
    c.put("hot_reactive_gray_friendship_2_icon", Integer.valueOf(2130850184));
    c.put("hot_reactive_gray_friendship_3_icon", Integer.valueOf(2130850185));
    c.put("gray_small_fire", Integer.valueOf(2130850216));
    c.put("gray_big_fire", Integer.valueOf(2130850163));
    c.put("gray_small_zan", Integer.valueOf(2130850220));
    c.put("gray_big_zan", Integer.valueOf(2130850167));
    c.put("gray_small_lover", Integer.valueOf(2130850208));
    c.put("gray_big_lover", Integer.valueOf(2130850207));
    c.put("qzone_gray_qzone_visit_normal", Integer.valueOf(2130850214));
    c.put("qzone_gray_qzone_visit_super", Integer.valueOf(2130850215));
    c.put("gray_small_ship", Integer.valueOf(2130850219));
    c.put("gray_big_ship", Integer.valueOf(2130850166));
    a = new HashMap();
    a.put("skin_icon_small_fire", Integer.valueOf(2130850216));
    a.put("skin_icon_big_fire", Integer.valueOf(2130850163));
    a.put("skin_icon_fire_1", Integer.valueOf(2130850174));
    a.put("skin_icon_fire_2", Integer.valueOf(2130850175));
    a.put("skin_icon_fire_3", Integer.valueOf(2130850176));
    a.put("skin_icon_fire_4", Integer.valueOf(2130850177));
    a.put("skin_icon_fire_5", Integer.valueOf(2130850178));
    a.put("skin_icon_fire_6", Integer.valueOf(2130850179));
    a.put("skin_icon_small_flower", Integer.valueOf(2130850219));
    a.put("skin_icon_big_flower", Integer.valueOf(2130850166));
    a.put("skin_icon_small_praise", Integer.valueOf(2130850220));
    a.put("skin_icon_big_praise", Integer.valueOf(2130850167));
    a.put("skin_icon_lover_small", Integer.valueOf(2130850208));
    a.put("skin_icon_lover_big", Integer.valueOf(2130850207));
    a.put("skin_icon_qzone_visit_normal", Integer.valueOf(2130850214));
    a.put("skin_icon_qzone_visit_super", Integer.valueOf(2130850215));
    a.put("skin_icon_frdship_1", Integer.valueOf(2130850183));
    a.put("skin_icon_frdship_2", Integer.valueOf(2130850184));
    a.put("skin_icon_frdship_3", Integer.valueOf(2130850185));
    a.put("skin_icon_intimate_lover_1", Integer.valueOf(2130850192));
    a.put("skin_icon_intimate_lover_2", Integer.valueOf(2130850193));
    a.put("skin_icon_intimate_lover_3", Integer.valueOf(2130850194));
    a.put("skin_icon_intimate_guimi_1", Integer.valueOf(2130850186));
    a.put("skin_icon_intimate_guimi_2", Integer.valueOf(2130850187));
    a.put("skin_icon_intimate_guimi_3", Integer.valueOf(2130850188));
    a.put("skin_icon_intimate_sidang_1", Integer.valueOf(2130850198));
    a.put("skin_icon_intimate_sidang_2", Integer.valueOf(2130850199));
    a.put("skin_icon_intimate_sidang_3", Integer.valueOf(2130850200));
    a.put("skin_icon_intimate_jiyou_1", Integer.valueOf(2130850189));
    a.put("skin_icon_intimate_jiyou_2", Integer.valueOf(2130850190));
    a.put("skin_icon_intimate_jiyou_3", Integer.valueOf(2130850191));
    a.put("skin_icon_mutual_x_character_1", Integer.valueOf(2130850213));
    a.put("skin_icon_mentorship", Integer.valueOf(2130850211));
    a.put("skin_icon_mentorship_svip", Integer.valueOf(2130850210));
    a.put("skin_icon_mentorship_yellowvip", Integer.valueOf(2130850212));
    a.put("skin_icon_mentorship_newyear", Integer.valueOf(2130850209));
    a.put("skin_icon_kapu_1", Integer.valueOf(2130850201));
    a.put("skin_icon_kapu_2", Integer.valueOf(2130850202));
    a.put("skin_icon_kapu_3", Integer.valueOf(2130850203));
    a.put("skin_icon_forget_me_not_1", Integer.valueOf(2130850180));
    a.put("skin_icon_forget_me_not_2", Integer.valueOf(2130850181));
    a.put("skin_icon_forget_me_not_3", Integer.valueOf(2130850182));
    a.put("skin_icon_listen_together_1", Integer.valueOf(2130850204));
    a.put("skin_icon_listen_together_2", Integer.valueOf(2130850205));
    a.put("skin_icon_listen_together_3", Integer.valueOf(2130850206));
    b = new HashMap();
    b.putAll(c);
    b.putAll(a);
    b.putAll(axmm.a);
  }
  
  public static int a()
  {
    return bhid.a(NetConnInfoCenter.getServerTimeMillis());
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
    //   4: ldc_w 286
    //   7: astore_3
    //   8: invokestatic 292	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokevirtual 298	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   14: ldc_w 300
    //   17: invokevirtual 306	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_0
    //   23: aload_2
    //   24: astore_1
    //   25: aload_2
    //   26: invokestatic 311	nwo:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   29: astore 4
    //   31: aload 4
    //   33: astore_0
    //   34: aload_0
    //   35: astore_1
    //   36: aload_2
    //   37: ifnull +9 -> 46
    //   40: aload_2
    //   41: invokevirtual 316	java/io/InputStream:close	()V
    //   44: aload_0
    //   45: astore_1
    //   46: aload_1
    //   47: areturn
    //   48: astore_2
    //   49: aload_0
    //   50: astore_1
    //   51: aload_2
    //   52: invokevirtual 319	java/lang/Throwable:printStackTrace	()V
    //   55: aload_3
    //   56: astore_1
    //   57: aload_0
    //   58: ifnull -12 -> 46
    //   61: aload_0
    //   62: invokevirtual 316	java/io/InputStream:close	()V
    //   65: ldc_w 286
    //   68: areturn
    //   69: astore_0
    //   70: ldc_w 286
    //   73: areturn
    //   74: astore_0
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokevirtual 316	java/io/InputStream:close	()V
    //   83: aload_0
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: areturn
    //   88: astore_1
    //   89: goto -6 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	59	0	localObject1	Object
    //   69	1	0	localIOException1	java.io.IOException
    //   74	13	0	str1	String
    //   1	79	1	localObject2	Object
    //   85	1	1	localIOException2	java.io.IOException
    //   88	1	1	localIOException3	java.io.IOException
    //   20	21	2	localInputStream	java.io.InputStream
    //   48	4	2	localThrowable	java.lang.Throwable
    //   7	49	3	str2	String
    //   29	3	4	str3	String
    // Exception table:
    //   from	to	target	type
    //   8	21	48	java/lang/Throwable
    //   25	31	48	java/lang/Throwable
    //   61	65	69	java/io/IOException
    //   8	21	74	finally
    //   25	31	74	finally
    //   51	55	74	finally
    //   40	44	85	java/io/IOException
    //   79	83	88	java/io/IOException
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
    localIterator = axmm.a.entrySet().iterator();
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
    try
    {
      String str = new String(bhcu.decode(paramString, 0));
      return str;
    }
    catch (Exception localException)
    {
      QLog.d("MutualMarkUtils", 1, "transformBase64ToRealString exception,base64String = " + paramString, localException);
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString2;
        if (!b(paramString2))
        {
          if ((!paramString1.endsWith("/")) || (!paramString2.startsWith("/"))) {
            break label72;
          }
          str = paramString1 + paramString2.substring(1);
        }
      }
    }
    label72:
    do
    {
      do
      {
        return str;
        if ((paramString1.endsWith("/")) && (!paramString2.startsWith("/"))) {
          return paramString1 + paramString2;
        }
        if ((!paramString1.endsWith("/")) && (paramString2.startsWith("/"))) {
          return paramString1 + paramString2;
        }
        str = paramString2;
      } while (paramString1.endsWith("/"));
      str = paramString2;
    } while (paramString2.startsWith("/"));
    return paramString1 + "/" + paramString2;
  }
  
  public static ArrayList<axmc> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString);
    while (paramString.find())
    {
      axmc localaxmc = new axmc();
      localaxmc.jdField_a_of_type_JavaLangString = paramString.group();
      localaxmc.jdField_a_of_type_Int = paramString.start();
      localaxmc.jdField_b_of_type_Int = (localaxmc.jdField_a_of_type_Int + localaxmc.jdField_a_of_type_JavaLangString.length());
      localaxmc.jdField_b_of_type_JavaLangString = paramString.group(1);
      if ((!TextUtils.isEmpty(localaxmc.jdField_b_of_type_JavaLangString)) && (localaxmc.jdField_b_of_type_JavaLangString.contains("client/42px-")))
      {
        Matcher localMatcher = Pattern.compile("x_character/([^\\)]+?)/client").matcher(localaxmc.jdField_b_of_type_JavaLangString);
        if (localMatcher.find()) {
          localaxmc.c = localMatcher.group(1);
        }
      }
      localArrayList.add(localaxmc);
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkUtils", 2, "getMutualMarkImageUrlTemplateInfos. url:" + localaxmc.jdField_b_of_type_JavaLangString + " template:" + localaxmc.jdField_a_of_type_JavaLangString);
      }
    }
    return localArrayList;
  }
  
  public static List<String> a()
  {
    ArrayList localArrayList = new ArrayList(b.keySet());
    Collections.sort(localArrayList, new axmb());
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
    } while ((i < 18) || (i >= 24) || (bhid.c(paramLong) == 2131719421));
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
    long[] arrayOfLong = axlq.b;
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
  
  public static boolean b(String paramString)
  {
    return paramString.contains("://");
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!b(paramString)) {
        str = a(arcc.a().h, paramString);
      }
    }
    return str;
  }
  
  public static boolean c(long paramLong)
  {
    long[] arrayOfLong;
    int j;
    int i;
    if (b(paramLong))
    {
      arrayOfLong = axlq.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axma
 * JD-Core Version:    0.7.0.1
 */