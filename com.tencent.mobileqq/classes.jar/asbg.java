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

public class asbg
{
  public static HashMap<String, Integer> a;
  public static HashMap<String, Integer> b;
  private static HashMap<String, Integer> c = new HashMap();
  
  static
  {
    c.put("hot_reactive_gray_intimate_lover_1_icon", Integer.valueOf(2130848874));
    c.put("hot_reactive_gray_intimate_lover_2_icon", Integer.valueOf(2130848875));
    c.put("hot_reactive_gray_intimate_lover_3_icon", Integer.valueOf(2130848876));
    c.put("hot_reactive_gray_intimate_guimi_1_icon", Integer.valueOf(2130848868));
    c.put("hot_reactive_gray_intimate_guimi_2_icon", Integer.valueOf(2130848869));
    c.put("hot_reactive_gray_intimate_guimi_3_icon", Integer.valueOf(2130848870));
    c.put("hot_reactive_gray_intimate_jiyou_1_icon", Integer.valueOf(2130848871));
    c.put("hot_reactive_gray_intimate_jiyou_2_icon", Integer.valueOf(2130848872));
    c.put("hot_reactive_gray_intimate_jiyou_3_icon", Integer.valueOf(2130848873));
    c.put("hot_reactive_gray_friendship_1_icon", Integer.valueOf(2130848865));
    c.put("hot_reactive_gray_friendship_2_icon", Integer.valueOf(2130848866));
    c.put("hot_reactive_gray_friendship_3_icon", Integer.valueOf(2130848867));
    c.put("gray_small_fire", Integer.valueOf(2130848892));
    c.put("gray_big_fire", Integer.valueOf(2130848854));
    c.put("gray_small_zan", Integer.valueOf(2130848896));
    c.put("gray_big_zan", Integer.valueOf(2130848858));
    c.put("gray_small_lover", Integer.valueOf(2130848884));
    c.put("gray_big_lover", Integer.valueOf(2130848883));
    c.put("qzone_gray_qzone_visit_normal", Integer.valueOf(2130848890));
    c.put("qzone_gray_qzone_visit_super", Integer.valueOf(2130848891));
    c.put("gray_small_ship", Integer.valueOf(2130848895));
    c.put("gray_big_ship", Integer.valueOf(2130848857));
    a = new HashMap();
    a.put("skin_icon_small_fire", Integer.valueOf(2130848892));
    a.put("skin_icon_big_fire", Integer.valueOf(2130848854));
    a.put("skin_icon_small_flower", Integer.valueOf(2130848895));
    a.put("skin_icon_big_flower", Integer.valueOf(2130848857));
    a.put("skin_icon_small_praise", Integer.valueOf(2130848896));
    a.put("skin_icon_big_praise", Integer.valueOf(2130848858));
    a.put("skin_icon_lover_small", Integer.valueOf(2130848884));
    a.put("skin_icon_lover_big", Integer.valueOf(2130848883));
    a.put("skin_icon_qzone_visit_normal", Integer.valueOf(2130848890));
    a.put("skin_icon_qzone_visit_super", Integer.valueOf(2130848891));
    a.put("skin_icon_frdship_1", Integer.valueOf(2130848865));
    a.put("skin_icon_frdship_2", Integer.valueOf(2130848866));
    a.put("skin_icon_frdship_3", Integer.valueOf(2130848867));
    a.put("skin_icon_intimate_lover_1", Integer.valueOf(2130848874));
    a.put("skin_icon_intimate_lover_2", Integer.valueOf(2130848875));
    a.put("skin_icon_intimate_lover_3", Integer.valueOf(2130848876));
    a.put("skin_icon_intimate_guimi_1", Integer.valueOf(2130848868));
    a.put("skin_icon_intimate_guimi_2", Integer.valueOf(2130848869));
    a.put("skin_icon_intimate_guimi_3", Integer.valueOf(2130848870));
    a.put("skin_icon_intimate_jiyou_1", Integer.valueOf(2130848871));
    a.put("skin_icon_intimate_jiyou_2", Integer.valueOf(2130848872));
    a.put("skin_icon_intimate_jiyou_3", Integer.valueOf(2130848873));
    a.put("skin_icon_mutual_x_character_1", Integer.valueOf(2130848889));
    a.put("skin_icon_mentorship", Integer.valueOf(2130848887));
    a.put("skin_icon_mentorship_svip", Integer.valueOf(2130848886));
    a.put("skin_icon_mentorship_yellowvip", Integer.valueOf(2130848888));
    a.put("skin_icon_mentorship_newyear", Integer.valueOf(2130848885));
    a.put("skin_icon_kapu_1", Integer.valueOf(2130848880));
    a.put("skin_icon_kapu_2", Integer.valueOf(2130848881));
    a.put("skin_icon_kapu_3", Integer.valueOf(2130848882));
    b = new HashMap();
    b.putAll(c);
    b.putAll(a);
    b.putAll(asbs.a);
  }
  
  public static int a()
  {
    return baiu.a(NetConnInfoCenter.getServerTimeMillis());
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
    //   4: ldc 241
    //   6: astore_3
    //   7: invokestatic 247	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 253	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   13: ldc 255
    //   15: invokevirtual 261	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_2
    //   19: aload_2
    //   20: astore_0
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: invokestatic 266	mpw:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   27: astore 4
    //   29: aload 4
    //   31: astore_0
    //   32: aload_0
    //   33: astore_1
    //   34: aload_2
    //   35: ifnull +9 -> 44
    //   38: aload_2
    //   39: invokevirtual 271	java/io/InputStream:close	()V
    //   42: aload_0
    //   43: astore_1
    //   44: aload_1
    //   45: areturn
    //   46: astore_2
    //   47: aload_0
    //   48: astore_1
    //   49: aload_2
    //   50: invokevirtual 274	java/lang/Throwable:printStackTrace	()V
    //   53: aload_3
    //   54: astore_1
    //   55: aload_0
    //   56: ifnull -12 -> 44
    //   59: aload_0
    //   60: invokevirtual 271	java/io/InputStream:close	()V
    //   63: ldc 241
    //   65: areturn
    //   66: astore_0
    //   67: ldc 241
    //   69: areturn
    //   70: astore_0
    //   71: aload_1
    //   72: ifnull +7 -> 79
    //   75: aload_1
    //   76: invokevirtual 271	java/io/InputStream:close	()V
    //   79: aload_0
    //   80: athrow
    //   81: astore_1
    //   82: aload_0
    //   83: areturn
    //   84: astore_1
    //   85: goto -6 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	57	0	localObject1	Object
    //   66	1	0	localIOException1	java.io.IOException
    //   70	13	0	str1	String
    //   1	75	1	localObject2	Object
    //   81	1	1	localIOException2	java.io.IOException
    //   84	1	1	localIOException3	java.io.IOException
    //   18	21	2	localInputStream	java.io.InputStream
    //   46	4	2	localThrowable	java.lang.Throwable
    //   6	48	3	str2	String
    //   27	3	4	str3	String
    // Exception table:
    //   from	to	target	type
    //   7	19	46	java/lang/Throwable
    //   23	29	46	java/lang/Throwable
    //   59	63	66	java/io/IOException
    //   7	19	70	finally
    //   23	29	70	finally
    //   49	53	70	finally
    //   38	42	81	java/io/IOException
    //   75	79	84	java/io/IOException
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
    localIterator = asbs.a.entrySet().iterator();
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
    return new String(baaw.decode(paramString, 0));
  }
  
  public static ArrayList<asbi> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString);
    while (paramString.find())
    {
      asbi localasbi = new asbi();
      localasbi.jdField_a_of_type_JavaLangString = paramString.group();
      localasbi.jdField_a_of_type_Int = paramString.start();
      localasbi.jdField_b_of_type_Int = (localasbi.jdField_a_of_type_Int + localasbi.jdField_a_of_type_JavaLangString.length());
      localasbi.jdField_b_of_type_JavaLangString = paramString.group(1);
      if ((!TextUtils.isEmpty(localasbi.jdField_b_of_type_JavaLangString)) && (localasbi.jdField_b_of_type_JavaLangString.contains("client/42px-")))
      {
        Matcher localMatcher = Pattern.compile("x_character/([^\\)]+?)/client").matcher(localasbi.jdField_b_of_type_JavaLangString);
        if (localMatcher.find()) {
          localasbi.c = localMatcher.group(1);
        }
      }
      localArrayList.add(localasbi);
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkUtils", 2, "getMutualMarkImageUrlTemplateInfos. url:" + localasbi.jdField_b_of_type_JavaLangString + " template:" + localasbi.jdField_a_of_type_JavaLangString);
      }
    }
    return localArrayList;
  }
  
  public static List<String> a()
  {
    ArrayList localArrayList = new ArrayList(b.keySet());
    Collections.sort(localArrayList, new asbh());
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
    } while ((i < 18) || (i >= 24) || (baiu.c(paramLong) == 2131654440));
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
    long[] arrayOfLong = asaw.b;
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
      arrayOfLong = asaw.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asbg
 * JD-Core Version:    0.7.0.1
 */