import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.OpenSdkFriendService.GetFriendListCallback.1;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class bhua
  implements biaf
{
  protected final WeakReference<bhtz> a;
  
  public bhua(bhtw parambhtw, bhtz parambhtz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambhtz);
  }
  
  public void a(Exception paramException)
  {
    bhzm.c("OpenSdkFriendService", "GetFriendListCallback exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", bian.e);
    }
    for (;;)
    {
      paramException = (bhtz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramException != null) {
        paramException.a(localIntent);
      }
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", bian.f);
      }
      else if ((paramException instanceof MalformedURLException))
      {
        localIntent.putExtra("key_error_code", -3);
        localIntent.putExtra("key_error_msg", "访问url有误!");
      }
      else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
      {
        localIntent.putExtra("key_error_code", -10);
        localIntent.putExtra("key_error_msg", "Http返回码异常!");
      }
      else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
      {
        localIntent.putExtra("key_error_code", -9);
        localIntent.putExtra("key_error_msg", bian.g);
      }
      else if ((paramException instanceof JSONException))
      {
        localIntent.putExtra("key_error_code", -4);
        localIntent.putExtra("key_error_msg", bian.b);
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", bian.jdField_a_of_type_JavaLangString);
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", bian.d);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    bhvr localbhvr = new bhvr();
    for (;;)
    {
      Object localObject;
      try
      {
        localbhvr.jdField_a_of_type_Int = paramJSONObject.getInt("ret");
        localbhvr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("msg");
        if (localbhvr.jdField_a_of_type_Int != 0) {
          break label486;
        }
        if (paramJSONObject.has("conc_max")) {
          localbhvr.d = paramJSONObject.getInt("conc_max");
        }
        if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
        {
          localbhvr.b = paramJSONObject.getInt("inv_max");
          localbhvr.c = paramJSONObject.getInt("inv_count");
        }
        if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
        {
          localbhvr.b = paramJSONObject.getInt("fgmax");
          localbhvr.c = paramJSONObject.getInt("fgcur");
        }
        bhzm.c("OpenSdkFriendService", "-->result = " + paramJSONObject);
        localbhvr.e = paramJSONObject.optInt("app_rid", -1);
        localbhvr.f = paramJSONObject.optInt("app_tid", -1);
        if ("action_invite".equals(this.jdField_a_of_type_Bhtw.d))
        {
          if (!paramJSONObject.has("md5str")) {
            break label559;
          }
          localObject = paramJSONObject.getString("md5str");
          if (!biew.a(bhpc.a().a(), "invite_friend_list_md5").getString(this.jdField_a_of_type_Bhtw.b, "").equals(localObject))
          {
            paramJSONObject = (ArrayList)bhvp.c(paramJSONObject);
            localbhvr.jdField_a_of_type_JavaUtilArrayList = paramJSONObject;
            ThreadManager.executeOnSubThread(new OpenSdkFriendService.GetFriendListCallback.1(this, paramJSONObject, (String)localObject));
            paramJSONObject = (bhtz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramJSONObject == null) {
              break label558;
            }
            paramJSONObject.a(localbhvr);
            return;
          }
          localbhvr.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Bhtw.a();
          if (localbhvr.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            continue;
          }
          this.jdField_a_of_type_Bhtw.a.putString("md5str", "0");
          this.jdField_a_of_type_Bhtw.a("0");
          paramJSONObject = (bhtz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramJSONObject == null) {
            break label558;
          }
          new biae(this.jdField_a_of_type_Bhtw.c, "GET", new bhua(this.jdField_a_of_type_Bhtw, paramJSONObject)).a(this.jdField_a_of_type_Bhtw.a);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      if (("action_gift".equals(this.jdField_a_of_type_Bhtw.d)) || ("action_ask".equals(this.jdField_a_of_type_Bhtw.d)) || ("action_voice".equals(this.jdField_a_of_type_Bhtw.d)) || ("action_reactive".equals(this.jdField_a_of_type_Bhtw.d)))
      {
        localbhvr.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bhvp.b(paramJSONObject));
      }
      else
      {
        localbhvr.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bhvp.a(paramJSONObject));
        continue;
        label486:
        localbhvr.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", localbhvr.jdField_a_of_type_Int);
        paramJSONObject.putExtra("key_error_msg", localbhvr.jdField_a_of_type_JavaLangString);
        paramJSONObject.putExtra("key_error_detail", localbhvr.jdField_a_of_type_OrgJsonJSONObject.toString());
        localObject = (bhtz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((bhtz)localObject).a(paramJSONObject);
        }
        label558:
        return;
        label559:
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhua
 * JD-Core Version:    0.7.0.1
 */