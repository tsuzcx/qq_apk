import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ardx
  extends arac<ardy>
{
  public static int a = 16777216;
  public static int b = 10240;
  
  @NonNull
  public ardy a(int paramInt)
  {
    ardy localardy = new ardy();
    localardy.a = a;
    localardy.b = b;
    return localardy;
  }
  
  @Nullable
  public ardy a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0)) {
      return new ardy();
    }
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onParsed, content:" + paramArrayOfaraj);
    }
    ardy localardy = new ardy();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfaraj);
      localardy.a = Integer.valueOf(localJSONObject.getString("maxPicSize")).intValue();
      localardy.b = Integer.valueOf(localJSONObject.getString("maxLongSideLen")).intValue();
      return localardy;
    }
    catch (Exception localException)
    {
      QLog.d("FavLocalEmoticonsProcessor", 1, "onParsed error, content:" + paramArrayOfaraj);
      localardy.a = a;
      localardy.b = b;
    }
    return localardy;
  }
  
  public void a(ardy paramardy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onUpdate");
    }
  }
  
  public Class clazz()
  {
    return ardy.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 561;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardx
 * JD-Core Version:    0.7.0.1
 */