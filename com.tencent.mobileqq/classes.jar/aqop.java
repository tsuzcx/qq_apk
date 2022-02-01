import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqop
  extends aqkz<aqoq>
{
  public static int a = 16777216;
  public static int b = 10240;
  
  @NonNull
  public aqoq a(int paramInt)
  {
    aqoq localaqoq = new aqoq();
    localaqoq.a = a;
    localaqoq.b = b;
    return localaqoq;
  }
  
  @Nullable
  public aqoq a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length == 0)) {
      return new aqoq();
    }
    paramArrayOfaqlg = paramArrayOfaqlg[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onParsed, content:" + paramArrayOfaqlg);
    }
    aqoq localaqoq = new aqoq();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfaqlg);
      localaqoq.a = Integer.valueOf(localJSONObject.getString("maxPicSize")).intValue();
      localaqoq.b = Integer.valueOf(localJSONObject.getString("maxLongSideLen")).intValue();
      return localaqoq;
    }
    catch (Exception localException)
    {
      QLog.d("FavLocalEmoticonsProcessor", 1, "onParsed error, content:" + paramArrayOfaqlg);
      localaqoq.a = a;
      localaqoq.b = b;
    }
    return localaqoq;
  }
  
  public void a(aqoq paramaqoq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onUpdate");
    }
  }
  
  public Class clazz()
  {
    return aqoq.class;
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
 * Qualified Name:     aqop
 * JD-Core Version:    0.7.0.1
 */