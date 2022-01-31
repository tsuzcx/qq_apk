import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aonl
  extends aokh<aonm>
{
  public static int a = 16777216;
  public static int b = 10240;
  
  public int a()
  {
    return 561;
  }
  
  @NonNull
  public aonm a(int paramInt)
  {
    aonm localaonm = new aonm();
    localaonm.a = a;
    localaonm.b = b;
    return localaonm;
  }
  
  @Nullable
  public aonm a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length == 0)) {
      return new aonm();
    }
    paramArrayOfaoko = paramArrayOfaoko[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onParsed, content:" + paramArrayOfaoko);
    }
    aonm localaonm = new aonm();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfaoko);
      localaonm.a = Integer.valueOf(localJSONObject.getString("maxPicSize")).intValue();
      localaonm.b = Integer.valueOf(localJSONObject.getString("maxLongSideLen")).intValue();
      return localaonm;
    }
    catch (Exception localException)
    {
      QLog.d("FavLocalEmoticonsProcessor", 1, "onParsed error, content:" + paramArrayOfaoko);
      localaonm.a = a;
      localaonm.b = b;
    }
    return localaonm;
  }
  
  public Class a()
  {
    return aonm.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(aonm paramaonm)
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
 * Qualified Name:     aonl
 * JD-Core Version:    0.7.0.1
 */