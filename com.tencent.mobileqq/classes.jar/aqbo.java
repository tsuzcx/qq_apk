import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;

public class aqbo
{
  public static final Set<String> a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "coverVertical.png", "coverVerticalSmall.png", "coverHorizontal.png", "expend_match_ellipisis.json", "expand_voice_animation2.json" };
    jdField_a_of_type_JavaUtilSet = new HashSet(1);
    jdField_a_of_type_JavaUtilSet.add("matchAndAIOPageForNewVersion");
  }
  
  public static String a()
  {
    return "matchAndAIOPageForNewVersion";
  }
  
  public static String a(int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = "coverVertical.png";
    }
    for (;;)
    {
      return a(str);
      if (paramInt == 2) {
        str = "coverVerticalSmall.png";
      } else {
        str = "coverHorizontal.png";
      }
    }
  }
  
  public static String a(String paramString)
  {
    return String.format("%s/%s", new Object[] { c(), paramString });
  }
  
  public static void a()
  {
    a(jdField_a_of_type_ArrayOfJavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "delBgPicFiles ");
    }
  }
  
  public static void a(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bdiv.u(BaseApplicationImpl.getApplication().getBaseContext(), str, paramString);
    if (QLog.isColorLevel())
    {
      if (paramString != null) {
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "setBgPicResMd5 " + paramString);
      }
    }
    else {
      return;
    }
    QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "setBgPicResMd5 null");
  }
  
  private static void a(String[] paramArrayOfString)
  {
    paramArrayOfString = a(paramArrayOfString);
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        File localFile = new File(paramArrayOfString[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public static boolean a()
  {
    return a(jdField_a_of_type_ArrayOfJavaLangString);
  }
  
  public static boolean a(apxa paramapxa)
  {
    boolean bool = false;
    if ((paramapxa != null) && (paramapxa.a != null))
    {
      String str = a();
      paramapxa = (apxb)paramapxa.a.get(str);
      if (paramapxa != null)
      {
        paramapxa = paramapxa.c;
        str = b();
        if (TextUtils.isEmpty(str))
        {
          bool = true;
          if ((!TextUtils.isEmpty(paramapxa)) && (!paramapxa.equalsIgnoreCase(str))) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      if ((bool) && (paramapxa != null)) {
        a(paramapxa);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "checkBgPicMd5 " + bool);
      }
      return bool;
      continue;
      bool = false;
      break;
      paramapxa = null;
    }
  }
  
  private static boolean a(String[] paramArrayOfString)
  {
    return aqcy.a(a(paramArrayOfString));
  }
  
  public static String[] a(String[] paramArrayOfString)
  {
    Object localObject = null;
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      String[] arrayOfString = new String[j];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfString;
        if (i >= j) {
          break;
        }
        arrayOfString[i] = a(paramArrayOfString[i]);
        i += 1;
      }
    }
    return localObject;
  }
  
  public static String b()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = bdiv.t(BaseApplicationImpl.getApplication().getBaseContext(), str);
    if (QLog.isColorLevel())
    {
      if (str != null) {
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "getBgPicResMd5 " + str);
      }
    }
    else {
      return str;
    }
    QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "getBgPicResMd5 null");
    return str;
  }
  
  public static String c()
  {
    return String.format("%s/matchChat", new Object[] { apxd.a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbo
 * JD-Core Version:    0.7.0.1
 */