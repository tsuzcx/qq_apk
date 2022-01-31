import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apsp
{
  public static int a()
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = apsj.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof apso))
    {
      int j = ((apso)localQQSysAndEmojiResInfo).c();
      int i = j;
      if (j == 0) {
        i = azah.b.length;
      }
      return i;
    }
    return 0;
  }
  
  public static int a(int paramInt)
  {
    int i = apsj.a().a(1).a(paramInt);
    if (i == -1)
    {
      if (paramInt < azah.a.length) {
        return azah.a[paramInt];
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
      return paramInt;
    }
    return i;
  }
  
  public static Drawable a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid sysface static index: " + paramInt);
    }
    Object localObject;
    if (paramInt < bamd.jdField_a_of_type_Int)
    {
      localObject = BaseApplicationImpl.getContext().getResources();
      paramInt = bamd.b[paramInt];
      if (BaseApplicationImpl.sImageCache != null) {
        localObject = banh.a((Resources)localObject, paramInt);
      }
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      return ((Resources)localObject).getDrawable(paramInt);
      localDrawable = apsj.a().a(1).a(paramInt);
      localObject = localDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("SysFaceUtil", 2, "getFaceDrawable in new way");
    return localDrawable;
  }
  
  public static String a(int paramInt)
  {
    String str2 = apsj.a().a(1).a(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (paramInt < bamd.jdField_a_of_type_ArrayOfJavaLangString.length) {
        str1 = bamd.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
      }
    }
    return str1;
  }
  
  public static ArrayList<Integer> a()
  {
    Object localObject = apsj.a().a(1).a();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      return localObject;
    }
    localObject = apzf.a();
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
    apsj.a().a(1).c();
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = apsj.a().a(1);
    if ((localObject instanceof apso))
    {
      localObject = (apso)localObject;
      try
      {
        boolean bool = ((apso)localObject).b(paramInt);
        return bool;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        return false;
      }
    }
    return false;
  }
  
  public static int b(int paramInt)
  {
    int i = apsj.a().a(1).b(paramInt);
    if (i == -1)
    {
      if (paramInt < azah.b.length) {
        return azah.b[paramInt];
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
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = apsj.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof apso)) {
      return ((apso)localQQSysAndEmojiResInfo).b(paramInt);
    }
    return null;
  }
  
  public static final String b(int paramInt)
  {
    return String.valueOf(new char[] { '\024', (char)paramInt });
  }
  
  public static boolean b(int paramInt)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = apsj.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof apso)) {
      return ((apso)localQQSysAndEmojiResInfo).c(paramInt);
    }
    return false;
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 255) || (paramInt == 511) || (paramInt == 250)) {
      bool = false;
    }
    int i;
    do
    {
      return bool;
      int j = apsj.a().a(1).a();
      i = j;
      if (j <= 0) {
        i = 65535;
      }
    } while ((paramInt >= 0) && (paramInt <= i));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsp
 * JD-Core Version:    0.7.0.1
 */