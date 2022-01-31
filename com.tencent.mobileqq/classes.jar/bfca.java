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

public class bfca
  implements bfic
{
  protected final WeakReference<bfbz> a;
  
  public bfca(bfbw parambfbw, bfbz parambfbz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambfbz);
  }
  
  public void a(Exception paramException)
  {
    bfhg.c("OpenSdkFriendService", "GetFriendListCallback exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", bfik.e);
    }
    for (;;)
    {
      paramException = (bfbz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramException != null) {
        paramException.a(localIntent);
      }
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", bfik.f);
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
        localIntent.putExtra("key_error_msg", bfik.g);
      }
      else if ((paramException instanceof JSONException))
      {
        localIntent.putExtra("key_error_code", -4);
        localIntent.putExtra("key_error_msg", bfik.b);
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", bfik.jdField_a_of_type_JavaLangString);
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", bfik.d);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    bfdl localbfdl = new bfdl();
    for (;;)
    {
      Object localObject;
      try
      {
        localbfdl.jdField_a_of_type_Int = paramJSONObject.getInt("ret");
        localbfdl.jdField_a_of_type_JavaLangString = paramJSONObject.getString("msg");
        if (localbfdl.jdField_a_of_type_Int != 0) {
          break label486;
        }
        if (paramJSONObject.has("conc_max")) {
          localbfdl.d = paramJSONObject.getInt("conc_max");
        }
        if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
        {
          localbfdl.b = paramJSONObject.getInt("inv_max");
          localbfdl.c = paramJSONObject.getInt("inv_count");
        }
        if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
        {
          localbfdl.b = paramJSONObject.getInt("fgmax");
          localbfdl.c = paramJSONObject.getInt("fgcur");
        }
        bfhg.c("OpenSdkFriendService", "-->result = " + paramJSONObject);
        localbfdl.e = paramJSONObject.optInt("app_rid", -1);
        localbfdl.f = paramJSONObject.optInt("app_tid", -1);
        if ("action_invite".equals(this.jdField_a_of_type_Bfbw.d))
        {
          if (!paramJSONObject.has("md5str")) {
            break label559;
          }
          localObject = paramJSONObject.getString("md5str");
          if (!bfmy.a(bexd.a().a(), "invite_friend_list_md5").getString(this.jdField_a_of_type_Bfbw.b, "").equals(localObject))
          {
            paramJSONObject = (ArrayList)bfdj.c(paramJSONObject);
            localbfdl.jdField_a_of_type_JavaUtilArrayList = paramJSONObject;
            ThreadManager.executeOnSubThread(new OpenSdkFriendService.GetFriendListCallback.1(this, paramJSONObject, (String)localObject));
            paramJSONObject = (bfbz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramJSONObject == null) {
              break label558;
            }
            paramJSONObject.a(localbfdl);
            return;
          }
          localbfdl.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Bfbw.a();
          if (localbfdl.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            continue;
          }
          this.jdField_a_of_type_Bfbw.a.putString("md5str", "0");
          this.jdField_a_of_type_Bfbw.a("0");
          paramJSONObject = (bfbz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramJSONObject == null) {
            break label558;
          }
          new bfib(this.jdField_a_of_type_Bfbw.c, "GET", new bfca(this.jdField_a_of_type_Bfbw, paramJSONObject)).a(this.jdField_a_of_type_Bfbw.a);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      if (("action_gift".equals(this.jdField_a_of_type_Bfbw.d)) || ("action_ask".equals(this.jdField_a_of_type_Bfbw.d)) || ("action_voice".equals(this.jdField_a_of_type_Bfbw.d)) || ("action_reactive".equals(this.jdField_a_of_type_Bfbw.d)))
      {
        localbfdl.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bfdj.b(paramJSONObject));
      }
      else
      {
        localbfdl.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bfdj.a(paramJSONObject));
        continue;
        label486:
        localbfdl.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", localbfdl.jdField_a_of_type_Int);
        paramJSONObject.putExtra("key_error_msg", localbfdl.jdField_a_of_type_JavaLangString);
        paramJSONObject.putExtra("key_error_detail", localbfdl.jdField_a_of_type_OrgJsonJSONObject.toString());
        localObject = (bfbz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((bfbz)localObject).a(paramJSONObject);
        }
        label558:
        return;
        label559:
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfca
 * JD-Core Version:    0.7.0.1
 */