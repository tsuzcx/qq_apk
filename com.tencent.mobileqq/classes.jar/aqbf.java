import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqbf
  extends aptq<aqbg>
{
  private boolean a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        String str;
        if (paramJSONObject.has("manufacturer"))
        {
          str = paramJSONObject.getString("manufacturer");
          if ((str != null) && (!"".equals(str)) && (!Build.MANUFACTURER.equals(str))) {}
        }
        else if (paramJSONObject.has("brand"))
        {
          str = paramJSONObject.getString("brand");
          if ((str != null) && (!"".equals(str)) && (!Build.BRAND.equals(str))) {}
        }
        else if (paramJSONObject.has("model"))
        {
          str = paramJSONObject.getString("model");
          if ((str != null) && (!"".equals(str)) && (!Build.MODEL.equals(str))) {}
        }
        else if (paramJSONObject.has("fingerprint"))
        {
          str = paramJSONObject.getString("fingerprint");
          if ((str != null) && (!"".equals(str)) && (!Build.FINGERPRINT.equals(str))) {}
        }
        else
        {
          if (paramJSONObject.has("androidId"))
          {
            paramJSONObject = paramJSONObject.getString("androidId");
            if ((paramJSONObject != null) && (!"".equals(paramJSONObject)) && (!"".equals(paramString)))
            {
              boolean bool = paramString.equals(paramJSONObject);
              if (!bool) {
                continue;
              }
            }
          }
          return true;
        }
      }
      catch (Exception paramJSONObject) {}
    }
    return false;
  }
  
  @NonNull
  public aqbg a(int paramInt)
  {
    return new aqbg();
  }
  
  @Nullable
  public aqbg a(aptx[] paramArrayOfaptx)
  {
    aqbg localaqbg = new aqbg();
    if (QLog.isColorLevel()) {
      QLog.d("QQAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaptx.length);
    }
    if (paramArrayOfaptx.length > 0)
    {
      paramArrayOfaptx = paramArrayOfaptx[0];
      localaqbg.jdField_a_of_type_Int = paramArrayOfaptx.jdField_a_of_type_Int;
      localaqbg.jdField_a_of_type_JavaLangString = paramArrayOfaptx.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAssistantConfigProcessor", 2, "onParsed taskId = " + localaqbg.jdField_a_of_type_Int + " | content = " + localaqbg.jdField_a_of_type_JavaLangString);
    }
    return localaqbg;
  }
  
  public void a(aqbg paramaqbg)
  {
    if ((paramaqbg != null) && (paramaqbg.jdField_a_of_type_JavaLangString != null)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = paramaqbg.jdField_a_of_type_JavaLangString;
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QQAssistantConfigProcessor", 2, "onUpdate content = " + paramaqbg.jdField_a_of_type_JavaLangString);
        }
        try
        {
          localObject1 = new JSONObject(paramaqbg.jdField_a_of_type_JavaLangString);
          paramaqbg = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 4).edit();
          Object localObject2 = DeviceInfoUtil.getAndroidID();
          azeu.a("HelloQQWake", "parseJson MANUFACTURER:" + Build.MANUFACTURER + ",BRAND:" + Build.BRAND + ",MODEL:" + Build.MODEL + ",FINGERPRINT:" + Build.FINGERPRINT + ",ANDROID_ID:" + (String)localObject2);
          JSONArray localJSONArray;
          if (((JSONObject)localObject1).has("ban"))
          {
            localJSONArray = ((JSONObject)localObject1).getJSONArray("ban");
            i = 0;
          }
          try
          {
            if (i >= localJSONArray.length()) {
              continue;
            }
            bool = a(localJSONArray.getJSONObject(i), (String)localObject2);
            if (!bool) {
              break label692;
            }
            bool = true;
          }
          catch (Exception localException)
          {
            azeu.a("HelloQQWake", "parseJson needBan error " + localException.getMessage());
            boolean bool = false;
            continue;
          }
          azeu.a("HelloQQWake", "parseJson needBan  " + bool);
          paramaqbg.putBoolean("ban", bool);
          azhh.a().e = bool;
          if (((JSONObject)localObject1).has("enable"))
          {
            bool = ((JSONObject)localObject1).getBoolean("enable");
            azeu.a("HelloQQWake", "parseJson enable  " + bool);
            paramaqbg.putBoolean(azhh.a(), bool);
            azhh.a().d = bool;
            if (azhh.a().b())
            {
              localObject2 = azeu.a();
              if (localObject2 != null) {
                ((azfg)localObject2).a();
              }
              azhh.a().a("manager enable");
            }
          }
          if (((JSONObject)localObject1).has("resModel"))
          {
            localObject2 = ((JSONObject)localObject1).getString("resModel");
            azeu.a("HelloQQWake", "parseJson resModel  " + (String)localObject2);
            paramaqbg.putString("resModel", (String)localObject2);
          }
          if (((JSONObject)localObject1).has("resVoice"))
          {
            localObject2 = ((JSONObject)localObject1).getString("resVoice");
            azeu.a("HelloQQWake", "parseJson resVoice  " + (String)localObject2);
            paramaqbg.putString("resVoice", (String)localObject2);
          }
          if (((JSONObject)localObject1).has("resAnimation"))
          {
            localObject2 = ((JSONObject)localObject1).getString("resAnimation");
            azeu.a("HelloQQWake", "parseJson resAnimation  " + (String)localObject2);
            paramaqbg.putString("resAnimation", (String)localObject2);
          }
          if (((JSONObject)localObject1).has("FriendSort"))
          {
            localObject1 = ((JSONObject)localObject1).getString("FriendSort");
            azeu.a("HelloQQWake", "parseJson FriendSort  " + (String)localObject1);
            azez.a((String)localObject1);
            paramaqbg.putString("FriendSort", (String)localObject1);
          }
          paramaqbg.apply();
          return;
        }
        catch (JSONException paramaqbg)
        {
          paramaqbg.printStackTrace();
          QLog.e("QQAssistantConfigProcessor", 2, "parseJson has exception  " + paramaqbg.getMessage());
          return;
        }
        QLog.e("QQAssistantConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
      }
      catch (Exception paramaqbg)
      {
        paramaqbg.printStackTrace();
        QLog.e("QQAssistantConfigProcessor", 2, "onUpdate has exception", paramaqbg);
        return;
      }
      return;
      label692:
      i += 1;
    }
  }
  
  public Class<aqbg> clazz()
  {
    return aqbg.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("QQAssistantConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAssistantConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 679;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbf
 * JD-Core Version:    0.7.0.1
 */