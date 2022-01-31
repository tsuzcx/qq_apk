import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.1;
import com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.2;
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
import org.json.JSONObject;

public class bdyb
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<bdyc> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  private final String b = "a4d7xwsbelhregistercard";
  private final String c = "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi";
  
  public bdyb(String paramString, bdyc parambdyc)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambdyc);
  }
  
  private bdxw a()
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
        if (QLog.isColorLevel()) {
          QLog.i("CheckRegisterLiangHao", 2, "json " + (String)localObject);
        }
        localObject = new JSONObject((String)localObject).optJSONObject("12196");
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optJSONObject("data");
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optJSONObject("mOut");
            if (localObject != null) {
              return new bdxw((JSONObject)localObject);
            }
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("CheckRegisterLiangHao", 2, "sendRequest errorCode" + i);
        }
        localObject = new bdxw();
        ((bdxw)localObject).a = i;
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CheckRegisterLiangHao", 2, localThrowable.toString());
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
      localJSONObject3.put("uin", this.jdField_a_of_type_JavaLangString);
      localJSONObject3.put("sign", b());
      localJSONObject2.put("mIn", localJSONObject3);
      localJSONObject1.put("12196", localJSONObject2);
      return localJSONObject1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private void a(bdxw parambdxw)
  {
    Object localObject2;
    Object localObject1;
    long l1;
    long l2;
    int i;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("onResponse ");
      if (parambdxw == null)
      {
        localObject1 = "";
        QLog.i("CheckRegisterLiangHao", 2, (String)localObject1);
      }
    }
    else
    {
      l1 = SystemClock.elapsedRealtime();
      l2 = this.jdField_a_of_type_Long;
      if (parambdxw == null) {
        break label146;
      }
      i = parambdxw.a;
      label63:
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("param_FailCode", String.valueOf(i));
      localObject2 = azmz.a(BaseApplicationImpl.getApplication());
      if (i != 0) {
        break label153;
      }
    }
    label146:
    label153:
    for (boolean bool = true;; bool = false)
    {
      ((azmz)localObject2).a(null, "reg_lh_check_uin", bool, l1 - l2, 0L, (HashMap)localObject1, "", true);
      localObject1 = (bdyc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 != null) {
        break label159;
      }
      return;
      localObject1 = parambdxw.toString();
      break;
      i = -30009;
      break label63;
    }
    label159:
    ThreadManagerV2.getUIHandlerV2().post(new CheckRegisterLiangHao.2(this, (bdyc)localObject1, parambdxw));
  }
  
  private String b()
  {
    return MD5.toMD5("uin=" + this.jdField_a_of_type_JavaLangString + "&key=" + "a4d7xwsbelhregistercard").toUpperCase();
  }
  
  public void a()
  {
    ThreadManagerV2.excute(new CheckRegisterLiangHao.1(this), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyb
 * JD-Core Version:    0.7.0.1
 */