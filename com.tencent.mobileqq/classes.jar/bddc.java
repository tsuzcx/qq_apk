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

public class bddc
  implements bdje
{
  protected final WeakReference<bddb> a;
  
  public bddc(bdcy parambdcy, bddb parambddb)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambddb);
  }
  
  public void a(Exception paramException)
  {
    bdii.c("OpenSdkFriendService", "GetFriendListCallback exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", bdjm.e);
    }
    for (;;)
    {
      paramException = (bddb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramException != null) {
        paramException.a(localIntent);
      }
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", bdjm.f);
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
        localIntent.putExtra("key_error_msg", bdjm.g);
      }
      else if ((paramException instanceof JSONException))
      {
        localIntent.putExtra("key_error_code", -4);
        localIntent.putExtra("key_error_msg", bdjm.b);
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", bdjm.jdField_a_of_type_JavaLangString);
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", bdjm.d);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    bden localbden = new bden();
    for (;;)
    {
      Object localObject;
      try
      {
        localbden.jdField_a_of_type_Int = paramJSONObject.getInt("ret");
        localbden.jdField_a_of_type_JavaLangString = paramJSONObject.getString("msg");
        if (localbden.jdField_a_of_type_Int != 0) {
          break label486;
        }
        if (paramJSONObject.has("conc_max")) {
          localbden.d = paramJSONObject.getInt("conc_max");
        }
        if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
        {
          localbden.b = paramJSONObject.getInt("inv_max");
          localbden.c = paramJSONObject.getInt("inv_count");
        }
        if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
        {
          localbden.b = paramJSONObject.getInt("fgmax");
          localbden.c = paramJSONObject.getInt("fgcur");
        }
        bdii.c("OpenSdkFriendService", "-->result = " + paramJSONObject);
        localbden.e = paramJSONObject.optInt("app_rid", -1);
        localbden.f = paramJSONObject.optInt("app_tid", -1);
        if ("action_invite".equals(this.jdField_a_of_type_Bdcy.d))
        {
          if (!paramJSONObject.has("md5str")) {
            break label559;
          }
          localObject = paramJSONObject.getString("md5str");
          if (!bdob.a(bcyb.a().a(), "invite_friend_list_md5").getString(this.jdField_a_of_type_Bdcy.b, "").equals(localObject))
          {
            paramJSONObject = (ArrayList)bdel.c(paramJSONObject);
            localbden.jdField_a_of_type_JavaUtilArrayList = paramJSONObject;
            ThreadManager.executeOnSubThread(new OpenSdkFriendService.GetFriendListCallback.1(this, paramJSONObject, (String)localObject));
            paramJSONObject = (bddb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramJSONObject == null) {
              break label558;
            }
            paramJSONObject.a(localbden);
            return;
          }
          localbden.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Bdcy.a();
          if (localbden.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            continue;
          }
          this.jdField_a_of_type_Bdcy.a.putString("md5str", "0");
          this.jdField_a_of_type_Bdcy.a("0");
          paramJSONObject = (bddb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramJSONObject == null) {
            break label558;
          }
          new bdjd(this.jdField_a_of_type_Bdcy.c, "GET", new bddc(this.jdField_a_of_type_Bdcy, paramJSONObject)).a(this.jdField_a_of_type_Bdcy.a);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      if (("action_gift".equals(this.jdField_a_of_type_Bdcy.d)) || ("action_ask".equals(this.jdField_a_of_type_Bdcy.d)) || ("action_voice".equals(this.jdField_a_of_type_Bdcy.d)) || ("action_reactive".equals(this.jdField_a_of_type_Bdcy.d)))
      {
        localbden.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bdel.b(paramJSONObject));
      }
      else
      {
        localbden.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bdel.a(paramJSONObject));
        continue;
        label486:
        localbden.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", localbden.jdField_a_of_type_Int);
        paramJSONObject.putExtra("key_error_msg", localbden.jdField_a_of_type_JavaLangString);
        paramJSONObject.putExtra("key_error_detail", localbden.jdField_a_of_type_OrgJsonJSONObject.toString());
        localObject = (bddb)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((bddb)localObject).a(paramJSONObject);
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
 * Qualified Name:     bddc
 * JD-Core Version:    0.7.0.1
 */