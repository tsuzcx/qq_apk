import android.text.TextUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

public class bdwj
{
  public static Map<String, Long> a;
  private int jdField_a_of_type_Int = -1;
  private final String jdField_a_of_type_JavaLangString = "LhHelper";
  private int jdField_b_of_type_Int = -1;
  private final String jdField_b_of_type_JavaLangString = "a4d7ea5belhtimecard";
  private final String c = "cmd=rsp&key=a4d7ea5belhtimecard";
  private final String d = "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi";
  private String e;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap(10);
  }
  
  public bdwj(String paramString)
  {
    this.e = paramString;
  }
  
  private String a()
  {
    return MD5.toMD5("cmd=rsp&key=a4d7ea5belhtimecard&uin=" + this.e);
  }
  
  private String a(int paramInt)
  {
    return MD5.toMD5("cmd=" + paramInt + "&key=" + "a4d7ea5belhtimecard" + "&uin=" + this.e);
  }
  
  private OkHttpClient a()
  {
    return new OkHttpClient().newBuilder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).build();
  }
  
  private JSONObject a(int paramInt)
  {
    int i;
    try
    {
      Object localObject = b(paramInt);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      QLog.d("LhHelper", 1, "reqCgi cmd = " + paramInt);
      localObject = new Request.Builder().url((String)localObject).build();
      localObject = a().newCall((Request)localObject).execute();
      i = ((Response)localObject).code();
      if (i == 200)
      {
        localObject = new JSONObject(((Response)localObject).body().string()).optJSONObject("12042");
        if (localObject == null) {
          break label280;
        }
        localObject = ((JSONObject)localObject).optJSONObject("data");
        if (localObject == null) {
          break label280;
        }
        localObject = ((JSONObject)localObject).optJSONObject("rsp");
        if (localObject == null) {
          break label280;
        }
        i = ((JSONObject)localObject).optInt("ret");
        String str = ((JSONObject)localObject).optString("sign");
        QLog.d("LhHelper", 1, "reqCgi retCode = " + i);
        if ((i == 0) && (a().equalsIgnoreCase(str))) {
          return localObject;
        }
        QLog.e("LhHelper", 1, "reqCgi rsp sign error, cmd = " + paramInt);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LhHelper", 1, "reqCgi exception cmd =" + paramInt + ", e = ", localThrowable);
      return null;
    }
    QLog.e("LhHelper", 1, "reqCgi http errorCode = " + i + " ,cmd = " + paramInt);
    label280:
    return null;
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("req", paramJSONObject);
      localJSONObject1.put("12042", localJSONObject2);
      return localJSONObject1;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("LhHelper", 1, "buildReqData exception e = ", paramJSONObject);
    }
    return null;
  }
  
  private String b(int paramInt)
  {
    try
    {
      String str = a(paramInt);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", paramInt);
      localJSONObject.put("sign", str);
      localJSONObject.put("uin", this.e);
      str = "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi?data=" + a(localJSONObject);
      return str;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LhHelper", 1, "buildReqUrl cmd = " + paramInt + "exception e = ", localThrowable);
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean a()
  {
    try
    {
      if (a(2) != null) {
        return true;
      }
      QLog.e("LhHelper", 1, "receiveReq rsp data is error");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("LhHelper", 1, "receiveReq exception e = ", localThrowable);
      }
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean b()
  {
    try
    {
      JSONObject localJSONObject = a(3);
      if (localJSONObject != null)
      {
        int i = localJSONObject.optInt("lhState", -1);
        QLog.d("LhHelper", 1, "reqLhStatus lhState = " + i);
        if (i == 2) {
          return true;
        }
      }
      else
      {
        QLog.e("LhHelper", 1, "reqLhStatus rsp data is error");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("LhHelper", 1, "reqLhStatus exception e = ", localThrowable);
      }
    }
    return false;
  }
  
  public int c()
  {
    try
    {
      JSONObject localJSONObject = a(1);
      if (localJSONObject != null)
      {
        this.jdField_a_of_type_Int = localJSONObject.optInt("buyoutMonth", -1);
        this.jdField_b_of_type_Int = localJSONObject.optInt("buyoutType", -1);
        int i = localJSONObject.optInt("cardState", -1);
        if ((this.jdField_a_of_type_Int != -1) && (this.jdField_b_of_type_Int != -1))
        {
          if (i == 0) {
            return 1;
          }
        }
        else
        {
          QLog.e("LhHelper", 1, "checkUserStatus buyoutData is error");
          break label105;
        }
      }
      else
      {
        QLog.e("LhHelper", 1, "checkUserStatus rsp data is empty");
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LhHelper", 1, "checkUserStatus exception e = ", localThrowable);
    }
    return 2;
    label105:
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdwj
 * JD-Core Version:    0.7.0.1
 */