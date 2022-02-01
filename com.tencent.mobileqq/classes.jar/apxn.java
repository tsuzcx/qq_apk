import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class apxn
  extends aptq<apxo>
{
  public static int a = 16777216;
  public static int b = 10240;
  
  @NonNull
  public apxo a(int paramInt)
  {
    apxo localapxo = new apxo();
    localapxo.a = a;
    localapxo.b = b;
    return localapxo;
  }
  
  @Nullable
  public apxo a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length == 0)) {
      return new apxo();
    }
    paramArrayOfaptx = paramArrayOfaptx[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onParsed, content:" + paramArrayOfaptx);
    }
    apxo localapxo = new apxo();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfaptx);
      localapxo.a = Integer.valueOf(localJSONObject.getString("maxPicSize")).intValue();
      localapxo.b = Integer.valueOf(localJSONObject.getString("maxLongSideLen")).intValue();
      return localapxo;
    }
    catch (Exception localException)
    {
      QLog.d("FavLocalEmoticonsProcessor", 1, "onParsed error, content:" + paramArrayOfaptx);
      localapxo.a = a;
      localapxo.b = b;
    }
    return localapxo;
  }
  
  public void a(apxo paramapxo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onUpdate");
    }
  }
  
  public Class clazz()
  {
    return apxo.class;
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
 * Qualified Name:     apxn
 * JD-Core Version:    0.7.0.1
 */