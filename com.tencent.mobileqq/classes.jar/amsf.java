import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amsf
  extends ampb<amsg>
{
  public static int a = 16777216;
  public static int b = 10240;
  
  public int a()
  {
    return 561;
  }
  
  @NonNull
  public amsg a(int paramInt)
  {
    amsg localamsg = new amsg();
    localamsg.a = a;
    localamsg.b = b;
    return localamsg;
  }
  
  @Nullable
  public amsg a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length == 0)) {
      return new amsg();
    }
    paramArrayOfampi = paramArrayOfampi[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onParsed, content:" + paramArrayOfampi);
    }
    amsg localamsg = new amsg();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfampi);
      localamsg.a = Integer.valueOf(localJSONObject.getString("maxPicSize")).intValue();
      localamsg.b = Integer.valueOf(localJSONObject.getString("maxLongSideLen")).intValue();
      return localamsg;
    }
    catch (Exception localException)
    {
      QLog.d("FavLocalEmoticonsProcessor", 1, "onParsed error, content:" + paramArrayOfampi);
      localamsg.a = a;
      localamsg.b = b;
    }
    return localamsg;
  }
  
  public Class a()
  {
    return amsg.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(amsg paramamsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onUpdate");
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amsf
 * JD-Core Version:    0.7.0.1
 */