import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bgmw
  extends aptq<bgmv>
{
  @NonNull
  public bgmv a(int paramInt)
  {
    return new bgmv();
  }
  
  @Nullable
  public bgmv a(aptx[] paramArrayOfaptx)
  {
    String str = null;
    Object localObject2 = null;
    Object localObject1 = str;
    if (paramArrayOfaptx != null)
    {
      localObject1 = str;
      if (paramArrayOfaptx.length > 0)
      {
        str = paramArrayOfaptx[0].a;
        localObject1 = localObject2;
        if (str != null) {
          localObject1 = new bgmv();
        }
      }
    }
    try
    {
      localObject2 = new JSONObject(str);
      boolean bool = "1".equals(((JSONObject)localObject2).optString("is_redirect_aio_to_main_page"));
      localObject2 = ((JSONObject)localObject2).optString("main_page_url");
      ((bgmv)localObject1).a(bool);
      ((bgmv)localObject1).a((String)localObject2);
      a((bgmv)localObject1);
      QLog.e("VSHealthConfigProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
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
  
  public void a(bgmv parambgmv)
  {
    QLog.i("VSHealthConfigProcessor", 2, "onUpdate ");
    if (parambgmv != null)
    {
      QLog.d("VSHealthConfigProcessor", 2, "onUpdate " + parambgmv.toString());
      VSConfigManager.getInstance().setValue("is_redirect_aio_to_main_page", Boolean.valueOf(parambgmv.a()));
      VSConfigManager.getInstance().setValue("main_page_jump_url", parambgmv.a());
    }
  }
  
  public Class<bgmv> clazz()
  {
    return bgmv.class;
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
 * Qualified Name:     bgmw
 * JD-Core Version:    0.7.0.1
 */