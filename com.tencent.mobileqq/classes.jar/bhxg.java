import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bhxg
  extends aqwt<bhxf>
{
  @NonNull
  public bhxf a(int paramInt)
  {
    return new bhxf();
  }
  
  @Nullable
  public bhxf a(aqxa[] paramArrayOfaqxa)
  {
    String str = null;
    Object localObject2 = null;
    Object localObject1 = str;
    if (paramArrayOfaqxa != null)
    {
      localObject1 = str;
      if (paramArrayOfaqxa.length > 0)
      {
        str = paramArrayOfaqxa[0].a;
        localObject1 = localObject2;
        if (str != null) {
          localObject1 = new bhxf();
        }
      }
    }
    try
    {
      localObject2 = new JSONObject(str);
      boolean bool = "1".equals(((JSONObject)localObject2).optString("is_redirect_aio_to_main_page"));
      localObject2 = ((JSONObject)localObject2).optString("main_page_url");
      ((bhxf)localObject1).a(bool);
      ((bhxf)localObject1).a((String)localObject2);
      a((bhxf)localObject1);
      QLog.e("VSHealthConfigProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
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
  
  public void a(bhxf parambhxf)
  {
    QLog.i("VSHealthConfigProcessor", 2, "onUpdate ");
    if (parambhxf != null)
    {
      QLog.d("VSHealthConfigProcessor", 2, "onUpdate " + parambhxf.toString());
      VSConfigManager.getInstance().setValue("is_redirect_aio_to_main_page", Boolean.valueOf(parambhxf.a()));
      VSConfigManager.getInstance().setValue("main_page_jump_url", parambhxf.a());
    }
  }
  
  public Class<bhxf> clazz()
  {
    return bhxf.class;
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
 * Qualified Name:     bhxg
 * JD-Core Version:    0.7.0.1
 */