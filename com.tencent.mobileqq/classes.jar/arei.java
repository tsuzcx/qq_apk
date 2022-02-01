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

public class arei
  extends aqwt<arej>
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
  public arej a(int paramInt)
  {
    return new arej();
  }
  
  @Nullable
  public arej a(aqxa[] paramArrayOfaqxa)
  {
    arej localarej = new arej();
    if (QLog.isColorLevel()) {
      QLog.d("QQAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaqxa.length);
    }
    if (paramArrayOfaqxa.length > 0)
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0];
      localarej.jdField_a_of_type_Int = paramArrayOfaqxa.jdField_a_of_type_Int;
      localarej.jdField_a_of_type_JavaLangString = paramArrayOfaqxa.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAssistantConfigProcessor", 2, "onParsed taskId = " + localarej.jdField_a_of_type_Int + " | content = " + localarej.jdField_a_of_type_JavaLangString);
    }
    return localarej;
  }
  
  public void a(arej paramarej)
  {
    if ((paramarej != null) && (paramarej.jdField_a_of_type_JavaLangString != null)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = paramarej.jdField_a_of_type_JavaLangString;
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QQAssistantConfigProcessor", 2, "onUpdate content = " + paramarej.jdField_a_of_type_JavaLangString);
        }
        try
        {
          localObject1 = new JSONObject(paramarej.jdField_a_of_type_JavaLangString);
          paramarej = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 4).edit();
          Object localObject2 = DeviceInfoUtil.getAndroidID();
          bakl.a("HelloQQWake", "parseJson MANUFACTURER:" + Build.MANUFACTURER + ",BRAND:" + Build.BRAND + ",MODEL:" + Build.MODEL + ",FINGERPRINT:" + Build.FINGERPRINT + ",ANDROID_ID:" + (String)localObject2);
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
            bakl.a("HelloQQWake", "parseJson needBan error " + localException.getMessage());
            boolean bool = false;
            continue;
          }
          bakl.a("HelloQQWake", "parseJson needBan  " + bool);
          paramarej.putBoolean("ban", bool);
          banp.a().e = bool;
          if (((JSONObject)localObject1).has("enable"))
          {
            bool = ((JSONObject)localObject1).getBoolean("enable");
            bakl.a("HelloQQWake", "parseJson enable  " + bool);
            paramarej.putBoolean(banp.a(), bool);
            banp.a().d = bool;
            if (banp.a().b())
            {
              localObject2 = bakl.a();
              if (localObject2 != null) {
                ((bakx)localObject2).a();
              }
              banp.a().a("manager enable");
            }
          }
          if (((JSONObject)localObject1).has("resModel"))
          {
            localObject2 = ((JSONObject)localObject1).getString("resModel");
            bakl.a("HelloQQWake", "parseJson resModel  " + (String)localObject2);
            paramarej.putString("resModel", (String)localObject2);
          }
          if (((JSONObject)localObject1).has("resVoice"))
          {
            localObject2 = ((JSONObject)localObject1).getString("resVoice");
            bakl.a("HelloQQWake", "parseJson resVoice  " + (String)localObject2);
            paramarej.putString("resVoice", (String)localObject2);
          }
          if (((JSONObject)localObject1).has("resAnimation"))
          {
            localObject2 = ((JSONObject)localObject1).getString("resAnimation");
            bakl.a("HelloQQWake", "parseJson resAnimation  " + (String)localObject2);
            paramarej.putString("resAnimation", (String)localObject2);
          }
          if (((JSONObject)localObject1).has("FriendSort"))
          {
            localObject1 = ((JSONObject)localObject1).getString("FriendSort");
            bakl.a("HelloQQWake", "parseJson FriendSort  " + (String)localObject1);
            bakq.a((String)localObject1);
            paramarej.putString("FriendSort", (String)localObject1);
          }
          paramarej.apply();
          return;
        }
        catch (JSONException paramarej)
        {
          paramarej.printStackTrace();
          QLog.e("QQAssistantConfigProcessor", 2, "parseJson has exception  " + paramarej.getMessage());
          return;
        }
        QLog.e("QQAssistantConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
      }
      catch (Exception paramarej)
      {
        paramarej.printStackTrace();
        QLog.e("QQAssistantConfigProcessor", 2, "onUpdate has exception", paramarej);
        return;
      }
      return;
      label692:
      i += 1;
    }
  }
  
  public Class<arej> clazz()
  {
    return arej.class;
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
 * Qualified Name:     arei
 * JD-Core Version:    0.7.0.1
 */