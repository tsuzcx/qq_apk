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

public class bjom
  implements bjut
{
  protected final WeakReference<bjol> a;
  
  public bjom(bjoi parambjoi, bjol parambjol)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjol);
  }
  
  public void a(Exception paramException)
  {
    bjtx.c("OpenSdkFriendService", "GetFriendListCallback exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", bjvb.e);
    }
    for (;;)
    {
      paramException = (bjol)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramException != null) {
        paramException.a(localIntent);
      }
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", bjvb.f);
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
        localIntent.putExtra("key_error_msg", bjvb.g);
      }
      else if ((paramException instanceof JSONException))
      {
        localIntent.putExtra("key_error_code", -4);
        localIntent.putExtra("key_error_msg", bjvb.b);
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", bjvb.jdField_a_of_type_JavaLangString);
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", bjvb.d);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    bjqc localbjqc = new bjqc();
    for (;;)
    {
      Object localObject;
      try
      {
        localbjqc.jdField_a_of_type_Int = paramJSONObject.getInt("ret");
        localbjqc.jdField_a_of_type_JavaLangString = paramJSONObject.getString("msg");
        if (localbjqc.jdField_a_of_type_Int != 0) {
          break label486;
        }
        if (paramJSONObject.has("conc_max")) {
          localbjqc.d = paramJSONObject.getInt("conc_max");
        }
        if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
        {
          localbjqc.b = paramJSONObject.getInt("inv_max");
          localbjqc.c = paramJSONObject.getInt("inv_count");
        }
        if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
        {
          localbjqc.b = paramJSONObject.getInt("fgmax");
          localbjqc.c = paramJSONObject.getInt("fgcur");
        }
        bjtx.c("OpenSdkFriendService", "-->result = " + paramJSONObject);
        localbjqc.e = paramJSONObject.optInt("app_rid", -1);
        localbjqc.f = paramJSONObject.optInt("app_tid", -1);
        if ("action_invite".equals(this.jdField_a_of_type_Bjoi.d))
        {
          if (!paramJSONObject.has("md5str")) {
            break label559;
          }
          localObject = paramJSONObject.getString("md5str");
          if (!bjzm.a(bjjo.a().a(), "invite_friend_list_md5").getString(this.jdField_a_of_type_Bjoi.b, "").equals(localObject))
          {
            paramJSONObject = (ArrayList)bjqa.c(paramJSONObject);
            localbjqc.jdField_a_of_type_JavaUtilArrayList = paramJSONObject;
            ThreadManager.executeOnSubThread(new OpenSdkFriendService.GetFriendListCallback.1(this, paramJSONObject, (String)localObject));
            paramJSONObject = (bjol)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramJSONObject == null) {
              break label558;
            }
            paramJSONObject.a(localbjqc);
            return;
          }
          localbjqc.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Bjoi.a();
          if (localbjqc.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            continue;
          }
          this.jdField_a_of_type_Bjoi.a.putString("md5str", "0");
          this.jdField_a_of_type_Bjoi.a("0");
          paramJSONObject = (bjol)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramJSONObject == null) {
            break label558;
          }
          new bjus(this.jdField_a_of_type_Bjoi.c, "GET", new bjom(this.jdField_a_of_type_Bjoi, paramJSONObject)).a(this.jdField_a_of_type_Bjoi.a);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      if (("action_gift".equals(this.jdField_a_of_type_Bjoi.d)) || ("action_ask".equals(this.jdField_a_of_type_Bjoi.d)) || ("action_voice".equals(this.jdField_a_of_type_Bjoi.d)) || ("action_reactive".equals(this.jdField_a_of_type_Bjoi.d)))
      {
        localbjqc.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bjqa.b(paramJSONObject));
      }
      else
      {
        localbjqc.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bjqa.a(paramJSONObject));
        continue;
        label486:
        localbjqc.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", localbjqc.jdField_a_of_type_Int);
        paramJSONObject.putExtra("key_error_msg", localbjqc.jdField_a_of_type_JavaLangString);
        paramJSONObject.putExtra("key_error_detail", localbjqc.jdField_a_of_type_OrgJsonJSONObject.toString());
        localObject = (bjol)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((bjol)localObject).a(paramJSONObject);
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
 * Qualified Name:     bjom
 * JD-Core Version:    0.7.0.1
 */