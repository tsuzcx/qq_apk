import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;

public class azgm
{
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131719583)));
  }
  
  public static boolean a(List<azfv> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        azfv localazfv = (azfv)paramList.next();
        if ((localazfv.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(localazfv.jdField_a_of_type_JavaLangString)) && (localazfv.jdField_a_of_type_JavaLangString.equals(BaseApplicationImpl.getContext().getString(2131718126)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131719584)));
  }
  
  public static boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131719587)));
  }
  
  public static boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131719581)));
  }
  
  public static boolean e(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131719580)));
  }
  
  public static boolean f(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131718126)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgm
 * JD-Core Version:    0.7.0.1
 */