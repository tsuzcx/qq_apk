import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.quic.internal.Utils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqbq
{
  public int a;
  public String a;
  public String b = "";
  
  public aqbq()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aqbq a(aptx[] paramArrayOfaptx)
  {
    aqbq localaqbq = new aqbq();
    int j;
    int i;
    try
    {
      j = paramArrayOfaptx.length;
      i = 0;
    }
    catch (Throwable paramArrayOfaptx)
    {
      boolean bool;
      QLog.d("QQShortVideoQuicNetProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaptx);
    }
    Object localObject = ((aptx)localObject).jdField_a_of_type_JavaLangString;
    bool = TextUtils.isEmpty((CharSequence)localObject);
    if (!bool)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("quic_url")) {
          localaqbq.jdField_a_of_type_JavaLangString = localJSONObject.optString("quic_url");
        }
        if (localJSONObject.has("quic_md5")) {
          localaqbq.b = localJSONObject.optString("quic_md5");
        }
        if (localJSONObject.has("quic_open")) {
          localaqbq.jdField_a_of_type_Int = localJSONObject.optInt("quic_open");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQShortVideoQuicNetProcessor", 2, "parse S$EConfBean: " + (String)localObject);
      }
    }
    label189:
    for (;;)
    {
      return localaqbq;
      for (;;)
      {
        if (i >= j) {
          break label189;
        }
        localObject = paramArrayOfaptx[i];
        if (localObject != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21) && (!Utils.checkIfCPUx86());
  }
  
  public String toString()
  {
    return "ShortVideoQuicNetConfBean{mQuicUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mQuicMD5='" + this.b + '\'' + ", mQuicOpen=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbq
 * JD-Core Version:    0.7.0.1
 */