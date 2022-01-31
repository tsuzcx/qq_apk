import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amcf
  extends alzl<amcg>
{
  public static int a = 16777216;
  public static int b = 10240;
  
  public int a()
  {
    return 561;
  }
  
  @NonNull
  public amcg a(int paramInt)
  {
    amcg localamcg = new amcg();
    localamcg.a = a;
    localamcg.b = b;
    return localamcg;
  }
  
  @Nullable
  public amcg a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length == 0)) {
      return new amcg();
    }
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onParsed, content:" + paramArrayOfalzs);
    }
    amcg localamcg = new amcg();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfalzs);
      localamcg.a = Integer.valueOf(localJSONObject.getString("maxPicSize")).intValue();
      localamcg.b = Integer.valueOf(localJSONObject.getString("maxLongSideLen")).intValue();
      return localamcg;
    }
    catch (Exception localException)
    {
      QLog.d("FavLocalEmoticonsProcessor", 1, "onParsed error, content:" + paramArrayOfalzs);
      localamcg.a = a;
      localamcg.b = b;
    }
    return localamcg;
  }
  
  public Class a()
  {
    return amcg.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(amcg paramamcg)
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
 * Qualified Name:     amcf
 * JD-Core Version:    0.7.0.1
 */