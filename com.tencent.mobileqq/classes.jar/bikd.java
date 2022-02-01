import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.1;
import com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

public class bikd
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<bike> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  private String b;
  private String c = "android";
  private String d = "8.4.5";
  private final String e = "d4e1f57bb381ec80e480aa10c65d05d1";
  private final String f = "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi";
  
  public bikd(String paramString, int paramInt, bike parambike)
  {
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambike);
  }
  
  private bijv a()
  {
    try
    {
      Object localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      localObject = new Request.Builder().url((String)localObject).build();
      localObject = a().newCall((Request)localObject).execute();
      int i = ((Response)localObject).code();
      if (i == 200)
      {
        localObject = ((Response)localObject).body().string();
        if (QLog.isDevelopLevel()) {
          QLog.d("GetRegisterLiangHaoList", 4, "json " + (String)localObject);
        }
        localObject = new JSONObject((String)localObject).optJSONObject("12162");
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optJSONObject("data");
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optJSONObject("rsp");
            if (localObject != null) {
              return new bijv((JSONObject)localObject);
            }
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("GetRegisterLiangHaoList", 2, "sendRequest errorCode" + i);
        }
        localObject = new bijv();
        ((bijv)localObject).jdField_a_of_type_Int = i;
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GetRegisterLiangHaoList", 2, localThrowable.toString());
      }
    }
    return null;
  }
  
  private String a()
  {
    return "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi?ts=" + System.currentTimeMillis() + "&data=" + a();
  }
  
  private OkHttpClient a()
  {
    return new OkHttpClient().newBuilder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).build();
  }
  
  private JSONObject a()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("imei", b());
      localJSONObject3.put("page", String.valueOf(this.jdField_a_of_type_Int));
      localJSONObject3.put("phone", this.b);
      localJSONObject3.put("plat", this.c);
      localJSONObject3.put("version", this.d);
      localJSONObject3.put("sign", c());
      localJSONObject2.put("req", localJSONObject3);
      localJSONObject1.put("12162", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GetRegisterLiangHaoList", 2, "buildRequestJson " + localJSONException);
      }
    }
    return null;
  }
  
  private void a(bijv parambijv)
  {
    if ((parambijv != null) && (QLog.isColorLevel())) {
      QLog.i("GetRegisterLiangHaoList", 2, "onResponse " + parambijv);
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.jdField_a_of_type_Long;
    int i;
    Object localObject;
    bdmc localbdmc;
    if (parambijv != null)
    {
      i = parambijv.jdField_a_of_type_Int;
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      localbdmc = bdmc.a(BaseApplicationImpl.getApplication());
      if (i != 0) {
        break label137;
      }
    }
    label137:
    for (boolean bool = true;; bool = false)
    {
      localbdmc.a(null, "reg_lh_get_list", bool, l1 - l2, 0L, (HashMap)localObject, "", true);
      localObject = (bike)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        break label143;
      }
      return;
      i = -30009;
      break;
    }
    label143:
    ThreadManagerV2.getUIHandlerV2().post(new GetRegisterLiangHaoList.2(this, parambijv, (bike)localObject));
  }
  
  private String b()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    try
    {
      this.jdField_a_of_type_JavaLangString = blhc.a("ecd027");
      return this.jdField_a_of_type_JavaLangString;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GetRegisterLiangHaoList", 2, "get imei error" + localThrowable.toString());
        }
        this.jdField_a_of_type_JavaLangString = "000000000000001";
      }
    }
  }
  
  private String c()
  {
    return MD5.toMD5(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Int + this.b + this.c + this.d + "d4e1f57bb381ec80e480aa10c65d05d1").toUpperCase();
  }
  
  public void a()
  {
    ThreadManagerV2.excute(new GetRegisterLiangHaoList.1(this), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bikd
 * JD-Core Version:    0.7.0.1
 */