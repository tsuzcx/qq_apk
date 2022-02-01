import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class arvq
{
  public static int a;
  public static int b = 100;
  private static int c = -1;
  
  static
  {
    jdField_a_of_type_Int = 10;
  }
  
  public static int a()
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arvk.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof arvp))
    {
      int j = ((arvp)localQQSysAndEmojiResInfo).c();
      int i = j;
      if (j == 0) {
        i = bbzj.b.length;
      }
      return i;
    }
    return 0;
  }
  
  public static int a(int paramInt)
  {
    int i = arvk.a().a(1).a(paramInt);
    if (i == -1)
    {
      if (paramInt < bbzj.a.length) {
        return bbzj.a[paramInt];
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
      return paramInt;
    }
    return i;
  }
  
  public static int a(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arvk.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof arvp)) {
      return ((arvp)localQQSysAndEmojiResInfo).a(paramString);
    }
    return -1;
  }
  
  protected static int a(String paramString, int paramInt)
  {
    int i = 0;
    int k = 10;
    for (;;)
    {
      try
      {
        paramString = paramString.split("\\|");
        int m = paramString.length;
        int j = k;
        if (i < m)
        {
          String[] arrayOfString1 = paramString[i].split(":");
          if (arrayOfString1.length == 2)
          {
            String[] arrayOfString2 = arrayOfString1[0].split("-");
            if (((TextUtils.isEmpty(arrayOfString2[0])) || (paramInt >= Integer.parseInt(arrayOfString2[0]))) && ((arrayOfString2.length <= 1) || (TextUtils.isEmpty(arrayOfString2[1])) || (paramInt < Integer.parseInt(arrayOfString2[1])))) {
              j = Integer.parseInt(arrayOfString1[1]);
            }
          }
        }
        else
        {
          return j;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("SysFaceUtil", 1, "parseAnimCountByVersion error!", paramString);
        return 10;
      }
      i += 1;
    }
  }
  
  protected static int a(String paramString1, String paramString2)
  {
    int i = 0;
    int k = -1;
    try
    {
      paramString1 = paramString1.split("\\|");
      int m = paramString1.length;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          String[] arrayOfString = paramString1[i].split(":");
          if ((arrayOfString.length == 2) && (paramString2.equalsIgnoreCase(arrayOfString[0]))) {
            j = Integer.parseInt(arrayOfString[1]);
          }
        }
        else
        {
          return j;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramString1)
    {
      QLog.e("SysFaceUtil", 1, "parseAnimCountByModel error!", paramString1);
    }
  }
  
  public static Drawable a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid sysface static index: " + paramInt);
    }
    Object localObject;
    if (paramInt < bdnh.jdField_a_of_type_Int)
    {
      localObject = BaseApplicationImpl.getContext().getResources();
      paramInt = bdnh.b[paramInt];
      if (BaseApplicationImpl.sImageCache != null) {
        localObject = bdol.a((Resources)localObject, paramInt);
      }
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      return ((Resources)localObject).getDrawable(paramInt);
      localDrawable = arvk.a().a(1).a(paramInt);
      localObject = localDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("SysFaceUtil", 2, "getFaceDrawable in new way");
    return localDrawable;
  }
  
  public static String a(int paramInt)
  {
    String str2 = arvk.a().a(1).a(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (paramInt < bdnh.jdField_a_of_type_ArrayOfJavaLangString.length) {
        str1 = bdnh.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
      }
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arvk.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof arvp)) {
      return ((arvp)localQQSysAndEmojiResInfo).a(paramString);
    }
    return null;
  }
  
  public static ArrayList<Integer> a()
  {
    Object localObject = arvk.a().a(1).a();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      return localObject;
    }
    localObject = asdb.a();
    ArrayList localArrayList = new ArrayList(localObject.length);
    int i = 0;
    while (i < localObject.length)
    {
      localArrayList.add(Integer.valueOf(localObject[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a()
  {
    arvk.a().a(1).c();
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = arvk.a().a(1);
    if ((localObject instanceof arvp))
    {
      localObject = (arvp)localObject;
      try
      {
        boolean bool = ((arvp)localObject).c(paramInt);
        return bool;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        return false;
      }
    }
    return false;
  }
  
  public static int b()
  {
    if (c == -1)
    {
      long l = System.currentTimeMillis();
      aqsp localaqsp = (aqsp)aqlk.a().a(545);
      if (!TextUtils.isEmpty(localaqsp.a.a)) {
        c = a(localaqsp.a.a, Build.MODEL);
      }
      if ((c == -1) && (!TextUtils.isEmpty(localaqsp.a.b))) {
        c = a(localaqsp.a.b, Build.VERSION.SDK_INT);
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "animCount:", Integer.valueOf(c), ", parseCost:", Long.valueOf(System.currentTimeMillis() - l) });
    }
    if (c < jdField_a_of_type_Int) {
      c = jdField_a_of_type_Int;
    }
    for (;;)
    {
      return c;
      if (c > b) {
        c = b;
      } else if (c == -1) {
        c = jdField_a_of_type_Int;
      }
    }
  }
  
  public static int b(int paramInt)
  {
    int i = arvk.a().a(1).b(paramInt);
    if (i == -1)
    {
      if (paramInt < bbzj.b.length) {
        return bbzj.b[paramInt];
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "unrecognized serverId:", Integer.valueOf(paramInt) });
      return paramInt;
    }
    return i;
  }
  
  public static Drawable b(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid sysface gif index: " + paramInt);
    }
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arvk.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof arvp)) {
      return ((arvp)localQQSysAndEmojiResInfo).b(paramInt);
    }
    return null;
  }
  
  public static final String b(int paramInt)
  {
    return String.valueOf(new char[] { '\024', (char)paramInt });
  }
  
  public static boolean b(int paramInt)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arvk.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof arvp)) {
      return ((arvp)localQQSysAndEmojiResInfo).d(paramInt);
    }
    return false;
  }
  
  public static boolean c(int paramInt)
  {
    if ((paramInt == 255) || (paramInt == 511) || (paramInt == 250)) {}
    while ((paramInt < 0) || (paramInt > 65535)) {
      return false;
    }
    return true;
  }
  
  public static boolean d(int paramInt)
  {
    return arvk.a().a(1).a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvq
 * JD-Core Version:    0.7.0.1
 */