import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;

public class atax
{
  public static final Set<String> a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "coverVertical.png", "coverVerticalSmall.png", "coverHorizontal.png", "expend_match_ellipisis.json", "expand_voice_animation2.json", "fire/fire_00.png", "bomb/bomb_00.png" };
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
    bhsi.u(BaseApplicationImpl.getApplication().getBaseContext(), str, paramString);
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
  
  public static boolean a(asvr paramasvr)
  {
    boolean bool = false;
    if ((paramasvr != null) && (paramasvr.a != null))
    {
      String str = a();
      paramasvr = (asvs)paramasvr.a.get(str);
      if (paramasvr != null)
      {
        paramasvr = paramasvr.c;
        str = b();
        if (TextUtils.isEmpty(str))
        {
          bool = true;
          if ((!TextUtils.isEmpty(paramasvr)) && (!paramasvr.equalsIgnoreCase(str))) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      if ((bool) && (paramasvr != null)) {
        a(paramasvr);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "checkBgPicMd5 " + bool);
      }
      return bool;
      continue;
      bool = false;
      break;
      paramasvr = null;
    }
  }
  
  private static boolean a(String[] paramArrayOfString)
  {
    return atcj.a(a(paramArrayOfString));
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
    str = bhsi.t(BaseApplicationImpl.getApplication().getBaseContext(), str);
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
  
  public static boolean b()
  {
    int i;
    if (new File(a("bomb/bomb_00.png")).exists())
    {
      i = 1;
      if (!new File(a("fire/fire_00.png")).exists()) {
        break label63;
      }
    }
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label76;
      }
      return true;
      QLog.e("ExtendFriendResourceDownloaderLimitChat", 2, "bBombExist signal bomb no");
      i = 0;
      break;
      label63:
      QLog.e("ExtendFriendResourceDownloaderLimitChat", 2, "bFireExist signal bomb no");
    }
    label76:
    return false;
  }
  
  public static String c()
  {
    return String.format("%s/matchChat", new Object[] { asvu.a() });
  }
  
  public static String d()
  {
    return a("fire/");
  }
  
  public static String e()
  {
    return a("bomb/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atax
 * JD-Core Version:    0.7.0.1
 */