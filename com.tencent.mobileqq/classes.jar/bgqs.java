import android.util.AndroidRuntimeException;
import com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bgqs
{
  private final List<bgqt> a = new ArrayList();
  
  public bgqs(AppRuntimeLoaderManager paramAppRuntimeLoaderManager)
  {
    paramAppRuntimeLoaderManager = (bghj)paramAppRuntimeLoaderManager.getClass().getAnnotation(bghj.class);
    if (paramAppRuntimeLoaderManager == null) {}
    do
    {
      return;
      paramAppRuntimeLoaderManager = paramAppRuntimeLoaderManager.a();
    } while (paramAppRuntimeLoaderManager == null);
    int j = paramAppRuntimeLoaderManager.length;
    int i = 0;
    label49:
    bgqt localbgqt;
    Object localObject2;
    if (i < j)
    {
      Object localObject1 = paramAppRuntimeLoaderManager[i];
      try
      {
        localbgqt = new bgqt();
        localObject2 = Class.forName(localObject1.className());
        if (!bgqg.class.isAssignableFrom((Class)localObject2)) {
          throw new AndroidRuntimeException("RuntimeLoaderConfig requires child class of BaseAppRuntimeLoader, current class is " + localObject1.className());
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.w("RuntimeLoaderConfiguration", "", localThrowable);
      }
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      localbgqt.jdField_a_of_type_JavaLangClass = ((Class)localObject2);
      localbgqt.jdField_a_of_type_Int = localThrowable.type();
      localObject2 = localbgqt.jdField_a_of_type_JavaLangClass.getField("CREATOR");
      if ((((Field)localObject2).getModifiers() & 0x8) == 0) {
        throw new AndroidRuntimeException("RuntimeLoader protocol requires the CREATOR object to be static on class " + localThrowable.className());
      }
      if (!bgqh.class.isAssignableFrom(((Field)localObject2).getType())) {
        throw new AndroidRuntimeException("RuntimeLoader requires a BaseAppRuntimeLoader.Creator object called CREATOR on class " + localThrowable.className());
      }
      localbgqt.jdField_a_of_type_Bgqh = ((bgqh)((Field)localObject2).get(null));
      this.a.add(localbgqt);
    }
  }
  
  public List<bgqt> a()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bgqt localbgqt = (bgqt)localIterator.next();
      if (localbgqt != null) {
        localStringBuilder.append("***Loader:").append(localbgqt.jdField_a_of_type_JavaLangClass.getName()).append(", Creator:").append(localbgqt.jdField_a_of_type_Bgqh.getClass().getName()).append("***");
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqs
 * JD-Core Version:    0.7.0.1
 */