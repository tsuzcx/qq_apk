import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bghm
  implements Manager
{
  int jdField_a_of_type_Int;
  bghn jdField_a_of_type_Bghn;
  bgho jdField_a_of_type_Bgho;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public String a;
  @NonNull
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList(5);
  boolean jdField_a_of_type_Boolean = false;
  int b;
  public String b;
  public String c = "banner_show_num";
  public String d = "dialog_show_num";
  String e;
  String f;
  public String g = anvx.a(2131706870);
  public String h = anvx.a(2131706864);
  String i = "";
  String j;
  String k;
  
  public bghm(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "banner_config";
    this.jdField_b_of_type_JavaLangString = "dialog_config";
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaLangString += paramAppInterface;
    this.c += paramAppInterface;
    this.jdField_b_of_type_JavaLangString += paramAppInterface;
    this.d += paramAppInterface;
    paramAppInterface = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
    this.i = paramAppInterface.getString("config", "");
    if (!TextUtils.isEmpty(this.i)) {
      a(this.i);
    }
    this.jdField_a_of_type_Boolean = paramAppInterface.getBoolean("enter_guide", true);
    String str = paramAppInterface.getString(this.jdField_a_of_type_JavaLangString, "");
    if (!TextUtils.isEmpty(str))
    {
      a(str, true);
      if ((this.jdField_a_of_type_Bghn != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bghn.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_Int = a(paramAppInterface.getString(this.c, ""), this.jdField_a_of_type_Bghn.jdField_a_of_type_JavaLangString);
        this.k = this.jdField_a_of_type_Bghn.jdField_a_of_type_JavaLangString;
      }
    }
    str = paramAppInterface.getString(this.jdField_b_of_type_JavaLangString, "");
    if (!TextUtils.isEmpty(str))
    {
      b(str, true);
      if ((this.jdField_a_of_type_Bgho != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bgho.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Int = a(paramAppInterface.getString(this.d, ""), this.jdField_a_of_type_Bgho.jdField_a_of_type_JavaLangString);
        this.j = this.jdField_a_of_type_Bgho.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("Q.nearby.video_chat", 2, "parseBannerJson json is null");
        return;
      }
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Bghn = new bghn();
      this.jdField_a_of_type_Bghn.jdField_a_of_type_JavaLangString = paramString.optString("unique_key");
      this.jdField_a_of_type_Bghn.jdField_a_of_type_Int = paramString.optInt("display_times");
      this.jdField_a_of_type_Bghn.jdField_a_of_type_Long = paramString.optLong("start_timestamp", 0L);
      this.jdField_a_of_type_Bghn.jdField_b_of_type_Long = paramString.optLong("end_timestamp", 0L);
      this.jdField_a_of_type_Bghn.jdField_b_of_type_Int = paramString.optInt("target_group");
      Object localObject = paramString.optJSONObject("content");
      if (localObject != null)
      {
        this.jdField_a_of_type_Bghn.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("image_url");
        this.jdField_a_of_type_Bghn.c = ((JSONObject)localObject).optString("jump_url");
      }
      if (!paramBoolean)
      {
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
        ((SharedPreferences)localObject).edit().putString(this.jdField_a_of_type_JavaLangString, paramString.toString()).commit();
        if ((this.jdField_a_of_type_Bghn.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_Bghn.jdField_a_of_type_JavaLangString.equals(this.k)))
        {
          this.k = this.jdField_a_of_type_Bghn.jdField_a_of_type_JavaLangString;
          paramString = new JSONObject();
          paramString.put(this.k, 0);
          ((SharedPreferences)localObject).edit().putString(this.c, paramString.toString()).commit();
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseBannerJson JSONException", paramString);
      }
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("Q.nearby.video_chat", 2, "parseDialogJson json is null");
        return;
      }
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Bgho = new bgho();
      this.jdField_a_of_type_Bgho.jdField_a_of_type_JavaLangString = paramString.optString("unique_key");
      this.jdField_a_of_type_Bgho.jdField_a_of_type_Int = paramString.optInt("display_times");
      this.jdField_a_of_type_Bgho.jdField_a_of_type_Long = paramString.optLong("start_timestamp", 0L);
      this.jdField_a_of_type_Bgho.jdField_b_of_type_Long = paramString.optLong("end_timestamp", 0L);
      this.jdField_a_of_type_Bgho.jdField_b_of_type_Int = paramString.optInt("target_group");
      Object localObject = paramString.optJSONObject("content");
      if (localObject != null)
      {
        this.jdField_a_of_type_Bgho.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("header_url");
        this.jdField_a_of_type_Bgho.c = ((JSONObject)localObject).optString("title");
        this.jdField_a_of_type_Bgho.d = ((JSONObject)localObject).optString("content");
        this.jdField_a_of_type_Bgho.e = ((JSONObject)localObject).optString("button_text");
        this.jdField_a_of_type_Bgho.f = ((JSONObject)localObject).optString("jump_url");
        this.jdField_a_of_type_Bgho.g = ((JSONObject)localObject).optString("button_text_color");
        this.jdField_a_of_type_Bgho.h = ((JSONObject)localObject).optString("button_background_color");
      }
      if (!paramBoolean)
      {
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
        ((SharedPreferences)localObject).edit().putString(this.jdField_b_of_type_JavaLangString, paramString.toString()).commit();
        if ((this.jdField_a_of_type_Bgho.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_Bgho.jdField_a_of_type_JavaLangString.equals(this.j)))
        {
          this.j = this.jdField_a_of_type_Bgho.jdField_a_of_type_JavaLangString;
          paramString = new JSONObject();
          paramString.put(this.j, 0);
          ((SharedPreferences)localObject).edit().putString(this.d, paramString.toString()).commit();
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseDialogJson JSONException", paramString);
      }
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return 0;
      }
      int m = new JSONObject(paramString1).optInt(paramString2);
      return m;
    }
    catch (JSONException paramString2)
    {
      QLog.e("Q.nearby.video_chat", 2, "getNumFromJson json:" + paramString1);
    }
    return 0;
  }
  
  public String a()
  {
    return this.i;
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (TextUtils.isEmpty(paramString))
      {
        this.e = null;
        this.f = null;
        BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 4).edit().putString("config", paramString).commit();
        return;
      }
      this.i = paramString;
      Object localObject = new JSONObject(paramString);
      this.g = ((JSONObject)localObject).optString("detail_default");
      this.h = ((JSONObject)localObject).optString("detail_num");
      this.e = ((JSONObject)localObject).optString("guide");
      this.f = ((JSONObject)localObject).optString("title");
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 4);
      localSharedPreferences.edit().putString("detail_default", this.g).commit();
      localSharedPreferences.edit().putString("detail_num", this.h).commit();
      if (TextUtils.isEmpty(this.f)) {
        localSharedPreferences.edit().putString("title", anvx.a(2131706869)).commit();
      }
      for (;;)
      {
        localObject = ((JSONObject)localObject).optJSONArray("tips");
        int m = 0;
        while (m < ((JSONArray)localObject).length())
        {
          this.jdField_a_of_type_JavaUtilList.add(((JSONArray)localObject).optString(m));
          m += 1;
        }
        break;
        localSharedPreferences.edit().putString("title", this.f).commit();
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseJson JSONException", paramString);
      }
    }
  }
  
  public String b()
  {
    return this.f;
  }
  
  public void b(String paramString)
  {
    a(paramString, false);
  }
  
  public void c(String paramString)
  {
    b(paramString, false);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghm
 * JD-Core Version:    0.7.0.1
 */