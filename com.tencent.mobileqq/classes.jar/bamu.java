import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;

public class bamu
{
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131720036)));
  }
  
  public static boolean a(List<balm> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        balm localbalm = (balm)paramList.next();
        if ((localbalm.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(localbalm.jdField_a_of_type_JavaLangString)) && (localbalm.jdField_a_of_type_JavaLangString.equals(BaseApplicationImpl.getContext().getString(2131718511)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131720037)));
  }
  
  public static boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131720040)));
  }
  
  public static boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131720034)));
  }
  
  public static boolean e(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131720033)));
  }
  
  public static boolean f(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131718511)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamu
 * JD-Core Version:    0.7.0.1
 */