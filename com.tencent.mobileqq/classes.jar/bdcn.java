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

public class bdcn
  implements bdip
{
  protected final WeakReference<bdcm> a;
  
  public bdcn(bdcj parambdcj, bdcm parambdcm)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambdcm);
  }
  
  public void a(Exception paramException)
  {
    bdht.c("OpenSdkFriendService", "GetFriendListCallback exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", bdix.e);
    }
    for (;;)
    {
      paramException = (bdcm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramException != null) {
        paramException.a(localIntent);
      }
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", bdix.f);
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
        localIntent.putExtra("key_error_msg", bdix.g);
      }
      else if ((paramException instanceof JSONException))
      {
        localIntent.putExtra("key_error_code", -4);
        localIntent.putExtra("key_error_msg", bdix.b);
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", bdix.jdField_a_of_type_JavaLangString);
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", bdix.d);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    bddy localbddy = new bddy();
    for (;;)
    {
      Object localObject;
      try
      {
        localbddy.jdField_a_of_type_Int = paramJSONObject.getInt("ret");
        localbddy.jdField_a_of_type_JavaLangString = paramJSONObject.getString("msg");
        if (localbddy.jdField_a_of_type_Int != 0) {
          break label486;
        }
        if (paramJSONObject.has("conc_max")) {
          localbddy.d = paramJSONObject.getInt("conc_max");
        }
        if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
        {
          localbddy.b = paramJSONObject.getInt("inv_max");
          localbddy.c = paramJSONObject.getInt("inv_count");
        }
        if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
        {
          localbddy.b = paramJSONObject.getInt("fgmax");
          localbddy.c = paramJSONObject.getInt("fgcur");
        }
        bdht.c("OpenSdkFriendService", "-->result = " + paramJSONObject);
        localbddy.e = paramJSONObject.optInt("app_rid", -1);
        localbddy.f = paramJSONObject.optInt("app_tid", -1);
        if ("action_invite".equals(this.jdField_a_of_type_Bdcj.d))
        {
          if (!paramJSONObject.has("md5str")) {
            break label559;
          }
          localObject = paramJSONObject.getString("md5str");
          if (!bdnm.a(bcxm.a().a(), "invite_friend_list_md5").getString(this.jdField_a_of_type_Bdcj.b, "").equals(localObject))
          {
            paramJSONObject = (ArrayList)bddw.c(paramJSONObject);
            localbddy.jdField_a_of_type_JavaUtilArrayList = paramJSONObject;
            ThreadManager.executeOnSubThread(new OpenSdkFriendService.GetFriendListCallback.1(this, paramJSONObject, (String)localObject));
            paramJSONObject = (bdcm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramJSONObject == null) {
              break label558;
            }
            paramJSONObject.a(localbddy);
            return;
          }
          localbddy.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Bdcj.a();
          if (localbddy.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            continue;
          }
          this.jdField_a_of_type_Bdcj.a.putString("md5str", "0");
          this.jdField_a_of_type_Bdcj.a("0");
          paramJSONObject = (bdcm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramJSONObject == null) {
            break label558;
          }
          new bdio(this.jdField_a_of_type_Bdcj.c, "GET", new bdcn(this.jdField_a_of_type_Bdcj, paramJSONObject)).a(this.jdField_a_of_type_Bdcj.a);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      if (("action_gift".equals(this.jdField_a_of_type_Bdcj.d)) || ("action_ask".equals(this.jdField_a_of_type_Bdcj.d)) || ("action_voice".equals(this.jdField_a_of_type_Bdcj.d)) || ("action_reactive".equals(this.jdField_a_of_type_Bdcj.d)))
      {
        localbddy.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bddw.b(paramJSONObject));
      }
      else
      {
        localbddy.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bddw.a(paramJSONObject));
        continue;
        label486:
        localbddy.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", localbddy.jdField_a_of_type_Int);
        paramJSONObject.putExtra("key_error_msg", localbddy.jdField_a_of_type_JavaLangString);
        paramJSONObject.putExtra("key_error_detail", localbddy.jdField_a_of_type_OrgJsonJSONObject.toString());
        localObject = (bdcm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((bdcm)localObject).a(paramJSONObject);
        }
        label558:
        return;
        label559:
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdcn
 * JD-Core Version:    0.7.0.1
 */