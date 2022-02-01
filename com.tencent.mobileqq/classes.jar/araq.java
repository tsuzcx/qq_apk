import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class araq
  extends aqwt<arar>
{
  public static int a = 16777216;
  public static int b = 10240;
  
  @NonNull
  public arar a(int paramInt)
  {
    arar localarar = new arar();
    localarar.a = a;
    localarar.b = b;
    return localarar;
  }
  
  @Nullable
  public arar a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0)) {
      return new arar();
    }
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onParsed, content:" + paramArrayOfaqxa);
    }
    arar localarar = new arar();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfaqxa);
      localarar.a = Integer.valueOf(localJSONObject.getString("maxPicSize")).intValue();
      localarar.b = Integer.valueOf(localJSONObject.getString("maxLongSideLen")).intValue();
      return localarar;
    }
    catch (Exception localException)
    {
      QLog.d("FavLocalEmoticonsProcessor", 1, "onParsed error, content:" + paramArrayOfaqxa);
      localarar.a = a;
      localarar.b = b;
    }
    return localarar;
  }
  
  public void a(arar paramarar)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onUpdate");
    }
  }
  
  public Class clazz()
  {
    return arar.class;
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
 * Qualified Name:     araq
 * JD-Core Version:    0.7.0.1
 */