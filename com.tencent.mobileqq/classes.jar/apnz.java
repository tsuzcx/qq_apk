import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apnz
{
  public static int a()
  {
    int j = apoa.a().a(2).b();
    int i = j;
    if (j < bahu.d.length) {
      i = bahu.d.length;
    }
    return i;
  }
  
  public static int a(int paramInt)
  {
    int j = apoa.a().a(2).a(paramInt);
    int i = j;
    if (j == -1)
    {
      if ((paramInt >= 0) && (paramInt < bahu.d.length)) {
        i = bahu.d[paramInt];
      }
    }
    else {
      return i;
    }
    QLog.d("EmojiUtil", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
    return j;
  }
  
  public static Drawable a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji static index: " + paramInt);
    }
    Object localObject = BaseApplicationImpl.getContext().getResources();
    if (paramInt >= 1000) {
      localObject = baiy.b((Resources)localObject, paramInt);
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      if (paramInt < bahu.jdField_b_of_type_Int)
      {
        paramInt = 2130839808 + paramInt;
        if (BaseApplicationImpl.sImageCache != null) {
          return baiy.a((Resources)localObject, paramInt);
        }
        return ((Resources)localObject).getDrawable(paramInt);
      }
      localDrawable = apoa.a().a(2).a(paramInt);
      localObject = localDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("EmojiUtil", 2, "getEmojiDrawable in new way");
    return localDrawable;
  }
  
  public static String a(int paramInt)
  {
    String str2 = apoa.a().a(2).a(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if ((paramInt >= 0) && (paramInt < bahu.jdField_b_of_type_ArrayOfJavaLangString.length)) {
        str1 = bahu.jdField_b_of_type_ArrayOfJavaLangString[paramInt];
      }
    }
    else {
      return str1;
    }
    return "未知";
  }
  
  public static ArrayList<Integer> a()
  {
    ArrayList localArrayList = apoa.a().a(2).a();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return localArrayList;
    }
    localArrayList = new ArrayList(apps.jdField_b_of_type_Int);
    int i = 0;
    while (i < apps.jdField_b_of_type_Int)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean a(int paramInt)
  {
    int j = apoa.a().a(2).a();
    int i = j;
    if (j <= 0) {
      i = bahu.d.length - 1;
    }
    return (paramInt >= 0) && (paramInt <= i);
  }
  
  public static int b(int paramInt)
  {
    int j = apoa.a().a(2).b(paramInt);
    int i = j;
    if (j == -1) {
      i = bahu.a.get(paramInt, -1);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnz
 * JD-Core Version:    0.7.0.1
 */