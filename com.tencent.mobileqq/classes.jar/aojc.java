import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aojc
  extends aofy<aojd>
{
  public static int a = 16777216;
  public static int b = 10240;
  
  public int a()
  {
    return 561;
  }
  
  @NonNull
  public aojd a(int paramInt)
  {
    aojd localaojd = new aojd();
    localaojd.a = a;
    localaojd.b = b;
    return localaojd;
  }
  
  @Nullable
  public aojd a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length == 0)) {
      return new aojd();
    }
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onParsed, content:" + paramArrayOfaogf);
    }
    aojd localaojd = new aojd();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfaogf);
      localaojd.a = Integer.valueOf(localJSONObject.getString("maxPicSize")).intValue();
      localaojd.b = Integer.valueOf(localJSONObject.getString("maxLongSideLen")).intValue();
      return localaojd;
    }
    catch (Exception localException)
    {
      QLog.d("FavLocalEmoticonsProcessor", 1, "onParsed error, content:" + paramArrayOfaogf);
      localaojd.a = a;
      localaojd.b = b;
    }
    return localaojd;
  }
  
  public Class a()
  {
    return aojd.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavLocalEmoticonsProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(aojd paramaojd)
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
 * Qualified Name:     aojc
 * JD-Core Version:    0.7.0.1
 */