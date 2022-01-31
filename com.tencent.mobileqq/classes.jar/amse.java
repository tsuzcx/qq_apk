import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amse
  extends ampa<amsf>
{
  public static int a = 16777216;
  public static int b = 10240;
  
  public int a()
  {
    return 561;
  }
  
  @NonNull
  public amsf a(int paramInt)
  {
    amsf localamsf = new amsf();
    localamsf.a = a;
    localamsf.b = b;
    return localamsf;
  }
  
  @Nullable
  public amsf a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length == 0)) {
      return new amsf();
    }
    paramArrayOfamph = paramArrayOfamph[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onParsed, content:" + paramArrayOfamph);
    }
    amsf localamsf = new amsf();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfamph);
      localamsf.a = Integer.valueOf(localJSONObject.getString("maxPicSize")).intValue();
      localamsf.b = Integer.valueOf(localJSONObject.getString("maxLongSideLen")).intValue();
      return localamsf;
    }
    catch (Exception localException)
    {
      QLog.d("FavLocalEmoticonsProcessor", 1, "onParsed error, content:" + paramArrayOfamph);
      localamsf.a = a;
      localamsf.b = b;
    }
    return localamsf;
  }
  
  public Class a()
  {
    return amsf.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(amsf paramamsf)
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
 * Qualified Name:     amse
 * JD-Core Version:    0.7.0.1
 */