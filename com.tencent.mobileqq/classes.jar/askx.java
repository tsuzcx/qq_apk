import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class askx
{
  public static int a()
  {
    int j = asky.a().a(2).b();
    int i = j;
    if (j < begd.d.length) {
      i = begd.d.length;
    }
    return i;
  }
  
  public static int a(int paramInt)
  {
    int j = asky.a().a(2).a(paramInt);
    int i = j;
    if (j == -1)
    {
      if ((paramInt >= 0) && (paramInt < begd.d.length)) {
        i = begd.d[paramInt];
      }
    }
    else {
      return i;
    }
    QLog.d("EmojiUtil", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
    return j;
  }
  
  public static int a(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = asky.a().a(2);
    if ((localQQSysAndEmojiResInfo instanceof askw)) {
      return ((askw)localQQSysAndEmojiResInfo).a(paramString);
    }
    return -1;
  }
  
  public static Drawable a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji static index: " + paramInt);
    }
    Object localObject = BaseApplicationImpl.getContext().getResources();
    if (paramInt >= 1000) {
      localObject = behh.b((Resources)localObject, paramInt);
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      if (paramInt < begd.jdField_b_of_type_Int)
      {
        paramInt = 2130839808 + paramInt;
        if (BaseApplicationImpl.sImageCache != null) {
          return behh.a((Resources)localObject, paramInt);
        }
        return ((Resources)localObject).getDrawable(paramInt);
      }
      localDrawable = asky.a().a(2).a(paramInt);
      localObject = localDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("EmojiUtil", 2, "getEmojiDrawable in new way");
    return localDrawable;
  }
  
  public static String a(int paramInt)
  {
    String str2 = asky.a().a(2).a(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if ((paramInt >= 0) && (paramInt < begd.jdField_b_of_type_ArrayOfJavaLangString.length)) {
        str1 = begd.jdField_b_of_type_ArrayOfJavaLangString[paramInt];
      }
    }
    else {
      return str1;
    }
    return "未知";
  }
  
  public static ArrayList<Integer> a()
  {
    ArrayList localArrayList = asky.a().a(2).a();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return localArrayList;
    }
    localArrayList = new ArrayList(asmq.jdField_b_of_type_Int);
    int i = 0;
    while (i < asmq.jdField_b_of_type_Int)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean a(int paramInt)
  {
    int j = asky.a().a(2).a();
    int i = j;
    if (j <= 0) {
      i = begd.d.length - 1;
    }
    return (paramInt >= 0) && (paramInt <= i);
  }
  
  public static int b(int paramInt)
  {
    int j = asky.a().a(2).b(paramInt);
    int i = j;
    if (j == -1) {
      i = begd.a.get(paramInt, -1);
    }
    return i;
  }
  
  public static boolean b(int paramInt)
  {
    return asky.a().a(2).a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askx
 * JD-Core Version:    0.7.0.1
 */