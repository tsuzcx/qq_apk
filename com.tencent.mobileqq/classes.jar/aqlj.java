import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.Iterator;
import java.util.Set;

public class aqlj
{
  private static SharedPreferences a(long paramLong, BaseApplicationImpl paramBaseApplicationImpl)
  {
    return paramBaseApplicationImpl.getSystemSharedPreferences("conf_" + paramLong + "_sharepref", 4);
  }
  
  public static aqrq a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    aqlh.a().a(419, 0L, false);
    aqrr localaqrr = new aqrr();
    paramBaseApplicationImpl = a(419, paramBaseApplicationImpl);
    if (paramBaseApplicationImpl != null) {
      try
      {
        paramBaseApplicationImpl = localaqrr.a(paramBaseApplicationImpl);
        if (paramBaseApplicationImpl != null) {
          return paramBaseApplicationImpl;
        }
      }
      catch (Exception paramBaseApplicationImpl) {}
    }
    return new aqrq();
  }
  
  private static aqlg[] a(int paramInt, BaseApplicationImpl paramBaseApplicationImpl)
  {
    Object localObject1 = a(0L, paramBaseApplicationImpl);
    paramBaseApplicationImpl = b(0L, paramBaseApplicationImpl);
    Object localObject2 = ((SharedPreferences)localObject1).getStringSet(paramInt + "_ids", null);
    if ((localObject2 == null) || (((Set)localObject2).isEmpty())) {
      return null;
    }
    localObject1 = new aqlg[((Set)localObject2).size()];
    localObject2 = ((Set)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      localObject1[i] = new aqlg(Integer.valueOf(str).intValue(), paramBaseApplicationImpl.getString(paramInt + "_" + str, null));
      i += 1;
    }
    return localObject1;
  }
  
  private static SharedPreferences b(long paramLong, BaseApplicationImpl paramBaseApplicationImpl)
  {
    return paramBaseApplicationImpl.getSystemSharedPreferences("conf_" + paramLong + "_content_sharepref", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqlj
 * JD-Core Version:    0.7.0.1
 */