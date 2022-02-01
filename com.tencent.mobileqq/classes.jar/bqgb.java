import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMBeautyItem;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class bqgb
{
  private static bqgb jdField_a_of_type_Bqgb;
  public static String a;
  private List<QIMBeautyItem> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "QIMBeautyManager";
  }
  
  private bqgb()
  {
    a();
  }
  
  public static bqgb a()
  {
    if (jdField_a_of_type_Bqgb == null) {}
    try
    {
      if (jdField_a_of_type_Bqgb == null) {
        jdField_a_of_type_Bqgb = new bqgb();
      }
      return jdField_a_of_type_Bqgb;
    }
    finally {}
  }
  
  private String a()
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_beauty_config", 0).getString("short_video_beauty_content", "");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "take  config content= " + str);
    }
    return str;
  }
  
  public int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("short_video_beauty_config", 0).getInt("short_video_beauty_version", 0);
  }
  
  public List<QIMBeautyItem> a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      a();
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    try
    {
      Object localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("category"))
      {
        localObject = ((JSONObject)localObject).getJSONArray("category");
        if (localObject != null)
        {
          int k = ((JSONArray)localObject).length();
          if (k > 0)
          {
            int i = 0;
            while (i < k)
            {
              JSONObject localJSONObject1 = ((JSONArray)localObject).getJSONObject(i);
              if (localJSONObject1.has("content"))
              {
                JSONArray localJSONArray = localJSONObject1.getJSONArray("content");
                if (localJSONArray == null) {
                  break;
                }
                int m = localJSONArray.length();
                if (m <= 0) {
                  break;
                }
                int j = 0;
                while (j < m)
                {
                  QIMBeautyItem localQIMBeautyItem = new QIMBeautyItem();
                  JSONObject localJSONObject2 = localJSONArray.getJSONObject(j);
                  if (localJSONObject2.has("iconUrl")) {
                    localQIMBeautyItem.c = localJSONObject2.getString("iconUrl");
                  }
                  if (localJSONObject2.has("id")) {
                    localQIMBeautyItem.jdField_a_of_type_JavaLangString = localJSONObject2.getString("id");
                  }
                  if (localJSONObject2.has("name")) {
                    localQIMBeautyItem.b = localJSONObject2.getString("name");
                  }
                  if (localJSONObject2.has("jump_app")) {
                    localQIMBeautyItem.d = localJSONObject2.getString("jump_app");
                  }
                  this.jdField_a_of_type_JavaUtilList.add(localQIMBeautyItem);
                  j += 1;
                }
              }
              if (localJSONObject1.has("downloadInfo"))
              {
                zmi.jdField_a_of_type_JavaLangString = localJSONObject1.getString("downloadInfo");
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "QIMBeautyManager WeishiGuideUtils.DOWNLOAD_JSON=  " + zmi.jdField_a_of_type_JavaLangString);
                }
              }
              i += 1;
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "parse sv config error, stacktrace :  " + QLog.getStackTraceString(localException));
      }
    }
  }
  
  public boolean a(String paramString, int paramInt, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "savebeautyConfig :  " + paramString);
    }
    paramContext = paramContext.getSharedPreferences("short_video_beauty_config", 0).edit();
    paramContext.putString("short_video_beauty_content", paramString);
    paramContext.putInt("short_video_beauty_version", paramInt);
    paramContext.commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqgb
 * JD-Core Version:    0.7.0.1
 */