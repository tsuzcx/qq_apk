import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import mqq.app.AppRuntime;

public class aqmx
{
  public SQLiteDatabase a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAppRuntime != null)
    {
      localObject1 = localObject2;
      if ((paramAppRuntime instanceof QQAppInterface))
      {
        paramAppRuntime = (QQAppInterface)paramAppRuntime;
        if (!paramBoolean) {
          break label41;
        }
        localObject1 = paramAppRuntime.getReadableDatabase(paramString);
      }
    }
    return localObject1;
    label41:
    return paramAppRuntime.getWritableDatabase(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmx
 * JD-Core Version:    0.7.0.1
 */