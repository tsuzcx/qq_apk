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

public class bbyn
  implements bceo
{
  protected final WeakReference<bbym> a;
  
  public bbyn(bbyj parambbyj, bbym parambbym)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambbym);
  }
  
  public void a(Exception paramException)
  {
    bcds.c("OpenSdkFriendService", "GetFriendListCallback exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", bcew.e);
    }
    for (;;)
    {
      paramException = (bbym)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramException != null) {
        paramException.a(localIntent);
      }
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", bcew.f);
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
        localIntent.putExtra("key_error_msg", bcew.g);
      }
      else if ((paramException instanceof JSONException))
      {
        localIntent.putExtra("key_error_code", -4);
        localIntent.putExtra("key_error_msg", bcew.b);
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", bcew.jdField_a_of_type_JavaLangString);
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", bcew.d);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    bbzy localbbzy = new bbzy();
    for (;;)
    {
      Object localObject;
      try
      {
        localbbzy.jdField_a_of_type_Int = paramJSONObject.getInt("ret");
        localbbzy.jdField_a_of_type_JavaLangString = paramJSONObject.getString("msg");
        if (localbbzy.jdField_a_of_type_Int != 0) {
          break label486;
        }
        if (paramJSONObject.has("conc_max")) {
          localbbzy.d = paramJSONObject.getInt("conc_max");
        }
        if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
        {
          localbbzy.b = paramJSONObject.getInt("inv_max");
          localbbzy.c = paramJSONObject.getInt("inv_count");
        }
        if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
        {
          localbbzy.b = paramJSONObject.getInt("fgmax");
          localbbzy.c = paramJSONObject.getInt("fgcur");
        }
        bcds.c("OpenSdkFriendService", "-->result = " + paramJSONObject);
        localbbzy.e = paramJSONObject.optInt("app_rid", -1);
        localbbzy.f = paramJSONObject.optInt("app_tid", -1);
        if ("action_invite".equals(this.jdField_a_of_type_Bbyj.d))
        {
          if (!paramJSONObject.has("md5str")) {
            break label559;
          }
          localObject = paramJSONObject.getString("md5str");
          if (!bcjl.a(bbtm.a().a(), "invite_friend_list_md5").getString(this.jdField_a_of_type_Bbyj.b, "").equals(localObject))
          {
            paramJSONObject = (ArrayList)bbzw.c(paramJSONObject);
            localbbzy.jdField_a_of_type_JavaUtilArrayList = paramJSONObject;
            ThreadManager.executeOnSubThread(new OpenSdkFriendService.GetFriendListCallback.1(this, paramJSONObject, (String)localObject));
            paramJSONObject = (bbym)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramJSONObject == null) {
              break label558;
            }
            paramJSONObject.a(localbbzy);
            return;
          }
          localbbzy.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Bbyj.a();
          if (localbbzy.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            continue;
          }
          this.jdField_a_of_type_Bbyj.a.putString("md5str", "0");
          this.jdField_a_of_type_Bbyj.a("0");
          paramJSONObject = (bbym)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramJSONObject == null) {
            break label558;
          }
          new bcen(this.jdField_a_of_type_Bbyj.c, "GET", new bbyn(this.jdField_a_of_type_Bbyj, paramJSONObject)).a(this.jdField_a_of_type_Bbyj.a);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      if (("action_gift".equals(this.jdField_a_of_type_Bbyj.d)) || ("action_ask".equals(this.jdField_a_of_type_Bbyj.d)) || ("action_voice".equals(this.jdField_a_of_type_Bbyj.d)) || ("action_reactive".equals(this.jdField_a_of_type_Bbyj.d)))
      {
        localbbzy.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bbzw.b(paramJSONObject));
      }
      else
      {
        localbbzy.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bbzw.a(paramJSONObject));
        continue;
        label486:
        localbbzy.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", localbbzy.jdField_a_of_type_Int);
        paramJSONObject.putExtra("key_error_msg", localbbzy.jdField_a_of_type_JavaLangString);
        paramJSONObject.putExtra("key_error_detail", localbbzy.jdField_a_of_type_OrgJsonJSONObject.toString());
        localObject = (bbym)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((bbym)localObject).a(paramJSONObject);
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
 * Qualified Name:     bbyn
 * JD-Core Version:    0.7.0.1
 */