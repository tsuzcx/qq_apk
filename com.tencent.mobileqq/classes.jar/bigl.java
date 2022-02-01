import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bigl
  extends arac<bigk>
{
  @NonNull
  public bigk a(int paramInt)
  {
    return new bigk();
  }
  
  @Nullable
  public bigk a(araj[] paramArrayOfaraj)
  {
    String str = null;
    Object localObject2 = null;
    Object localObject1 = str;
    if (paramArrayOfaraj != null)
    {
      localObject1 = str;
      if (paramArrayOfaraj.length > 0)
      {
        str = paramArrayOfaraj[0].a;
        localObject1 = localObject2;
        if (str != null) {
          localObject1 = new bigk();
        }
      }
    }
    try
    {
      localObject2 = new JSONObject(str);
      boolean bool = "1".equals(((JSONObject)localObject2).optString("is_redirect_aio_to_main_page"));
      localObject2 = ((JSONObject)localObject2).optString("main_page_url");
      ((bigk)localObject1).a(bool);
      ((bigk)localObject1).a((String)localObject2);
      a((bigk)localObject1);
      QLog.e("VSHealthConfigProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("VSHealthConfigProcessor", 1, "[onParsed] parseConfig error! ", localJSONException);
      }
    }
  }
  
  public void a(bigk parambigk)
  {
    QLog.i("VSHealthConfigProcessor", 2, "onUpdate ");
    if (parambigk != null)
    {
      QLog.d("VSHealthConfigProcessor", 2, "onUpdate " + parambigk.toString());
      abac.a().a("is_redirect_aio_to_main_page", Boolean.valueOf(parambigk.a()));
      abac.a().a("main_page_jump_url", parambigk.a());
    }
  }
  
  public Class<bigk> clazz()
  {
    return bigk.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 671;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigl
 * JD-Core Version:    0.7.0.1
 */