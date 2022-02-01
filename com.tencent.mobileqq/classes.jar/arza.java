import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class arza
{
  public static long a;
  public int a;
  public boolean a;
  public long b;
  
  static
  {
    jdField_a_of_type_Long = 86400000L;
  }
  
  public static arza a(String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    paramString = localBaseApplicationImpl.getSharedPreferences("emosm_sp_is_recommend", 4).getString(localBaseApplicationImpl.getRuntime().getAccount() + "_" + paramString, null);
    if (paramString != null) {}
    do
    {
      try
      {
        paramString = new arza().a(new JSONObject(paramString));
        return paramString;
      }
      catch (JSONException paramString)
      {
        QLog.e("EmoticonRecDressup", 1, "getEmotionRecommend failed", paramString);
      }
      paramString = localObject;
    } while (!paramBoolean);
    paramString = new arza();
    paramString.jdField_a_of_type_Boolean = true;
    return paramString;
  }
  
  private arza a(JSONObject paramJSONObject)
  {
    this.b = paramJSONObject.optLong("0");
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("1");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("2");
    return this;
  }
  
  public static void a(long paramLong)
  {
    jdField_a_of_type_Long = 1000L * paramLong;
    QLog.i("EmoticonRecDressup", 1, "EmotionPanelViewPagerAdapter.RECOMMEND_EXPIRED_TIME update to " + jdField_a_of_type_Long);
  }
  
  public void a(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = localBaseApplicationImpl.getSharedPreferences("emosm_sp_is_recommend", 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    long l1 = localSharedPreferences.getLong("createTime", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 2592000000L)
    {
      localEditor.clear();
      localEditor.putLong("createTime", l2);
    }
    this.b = l2;
    localEditor.putString(localBaseApplicationImpl.getRuntime().getAccount() + "_" + paramInt, toString());
    localEditor.commit();
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("0", this.b);
      localJSONObject.put("1", this.jdField_a_of_type_Boolean);
      localJSONObject.put("2", this.jdField_a_of_type_Int);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("EmoticonRecDressup", 1, "toString failed", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arza
 * JD-Core Version:    0.7.0.1
 */