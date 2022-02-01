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

public class bjex
  implements bjlh
{
  protected final WeakReference<bjew> a;
  
  public bjex(bjet parambjet, bjew parambjew)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjew);
  }
  
  public void a(Exception paramException)
  {
    bjko.c("OpenSdkFriendService", "GetFriendListCallback exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", bjlp.e);
    }
    for (;;)
    {
      paramException = (bjew)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramException != null) {
        paramException.a(localIntent);
      }
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", bjlp.f);
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
        localIntent.putExtra("key_error_msg", bjlp.g);
      }
      else if ((paramException instanceof JSONException))
      {
        localIntent.putExtra("key_error_code", -4);
        localIntent.putExtra("key_error_msg", bjlp.b);
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", bjlp.jdField_a_of_type_JavaLangString);
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", bjlp.d);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    bjgs localbjgs = new bjgs();
    for (;;)
    {
      Object localObject;
      try
      {
        localbjgs.jdField_a_of_type_Int = paramJSONObject.getInt("ret");
        localbjgs.jdField_a_of_type_JavaLangString = paramJSONObject.getString("msg");
        if (localbjgs.jdField_a_of_type_Int != 0) {
          break label487;
        }
        if (paramJSONObject.has("conc_max")) {
          localbjgs.d = paramJSONObject.getInt("conc_max");
        }
        if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
        {
          localbjgs.b = paramJSONObject.getInt("inv_max");
          localbjgs.c = paramJSONObject.getInt("inv_count");
        }
        if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
        {
          localbjgs.b = paramJSONObject.getInt("fgmax");
          localbjgs.c = paramJSONObject.getInt("fgcur");
        }
        bjko.c("OpenSdkFriendService", "-->result = " + paramJSONObject);
        localbjgs.e = paramJSONObject.optInt("app_rid", -1);
        localbjgs.f = paramJSONObject.optInt("app_tid", -1);
        if ("action_invite".equals(this.jdField_a_of_type_Bjet.d))
        {
          if (!paramJSONObject.has("md5str")) {
            break label560;
          }
          localObject = paramJSONObject.getString("md5str");
          if (!bjpy.a(bizw.a().a(), "invite_friend_list_md5").getString(this.jdField_a_of_type_Bjet.b, "").equals(localObject))
          {
            paramJSONObject = (ArrayList)bjgq.c(paramJSONObject);
            localbjgs.jdField_a_of_type_JavaUtilArrayList = paramJSONObject;
            ThreadManager.executeOnSubThread(new OpenSdkFriendService.GetFriendListCallback.1(this, paramJSONObject, (String)localObject));
            paramJSONObject = (bjew)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramJSONObject == null) {
              break label559;
            }
            paramJSONObject.a(localbjgs);
            return;
          }
          localbjgs.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Bjet.a();
          if (localbjgs.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            continue;
          }
          this.jdField_a_of_type_Bjet.a.putString("md5str", "0");
          this.jdField_a_of_type_Bjet.a("0");
          paramJSONObject = (bjew)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramJSONObject == null) {
            break label559;
          }
          new bjlg(this.jdField_a_of_type_Bjet.c, "GET", new bjex(this.jdField_a_of_type_Bjet, paramJSONObject), true).a(this.jdField_a_of_type_Bjet.a);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      if (("action_gift".equals(this.jdField_a_of_type_Bjet.d)) || ("action_ask".equals(this.jdField_a_of_type_Bjet.d)) || ("action_voice".equals(this.jdField_a_of_type_Bjet.d)) || ("action_reactive".equals(this.jdField_a_of_type_Bjet.d)))
      {
        localbjgs.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bjgq.b(paramJSONObject));
      }
      else
      {
        localbjgs.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bjgq.a(paramJSONObject));
        continue;
        label487:
        localbjgs.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", localbjgs.jdField_a_of_type_Int);
        paramJSONObject.putExtra("key_error_msg", localbjgs.jdField_a_of_type_JavaLangString);
        paramJSONObject.putExtra("key_error_detail", localbjgs.jdField_a_of_type_OrgJsonJSONObject.toString());
        localObject = (bjew)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((bjew)localObject).a(paramJSONObject);
        }
        label559:
        return;
        label560:
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjex
 * JD-Core Version:    0.7.0.1
 */