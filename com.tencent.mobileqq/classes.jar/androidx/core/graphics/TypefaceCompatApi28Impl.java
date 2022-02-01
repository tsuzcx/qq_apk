package androidx.core.graphics;

import android.graphics.Typeface;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(28)
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatApi28Impl
  extends TypefaceCompatApi26Impl
{
  private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
  private static final String DEFAULT_FAMILY = "sans-serif";
  private static final int RESOLVE_BY_FONT_TABLE = -1;
  
  protected Typeface createFromFamiliesWithDefault(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.mFontFamily, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.mCreateFromFamiliesWithDefault.invoke(null, new Object[] { localObject, "sans-serif", Integer.valueOf(-1), Integer.valueOf(-1) });
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label57:
      break label57;
    }
  }
  
  protected Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> paramClass)
  {
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(paramClass, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE });
    paramClass.setAccessible(true);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.graphics.TypefaceCompatApi28Impl
 * JD-Core Version:    0.7.0.1
 */