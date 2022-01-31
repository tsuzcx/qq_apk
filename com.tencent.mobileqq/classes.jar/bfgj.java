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

public class bfgj
  implements bfml
{
  protected final WeakReference<bfgi> a;
  
  public bfgj(bfgf parambfgf, bfgi parambfgi)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambfgi);
  }
  
  public void a(Exception paramException)
  {
    bflp.c("OpenSdkFriendService", "GetFriendListCallback exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", bfmt.e);
    }
    for (;;)
    {
      paramException = (bfgi)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramException != null) {
        paramException.a(localIntent);
      }
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", bfmt.f);
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
        localIntent.putExtra("key_error_msg", bfmt.g);
      }
      else if ((paramException instanceof JSONException))
      {
        localIntent.putExtra("key_error_code", -4);
        localIntent.putExtra("key_error_msg", bfmt.b);
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", bfmt.jdField_a_of_type_JavaLangString);
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", bfmt.d);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    bfhu localbfhu = new bfhu();
    for (;;)
    {
      Object localObject;
      try
      {
        localbfhu.jdField_a_of_type_Int = paramJSONObject.getInt("ret");
        localbfhu.jdField_a_of_type_JavaLangString = paramJSONObject.getString("msg");
        if (localbfhu.jdField_a_of_type_Int != 0) {
          break label486;
        }
        if (paramJSONObject.has("conc_max")) {
          localbfhu.d = paramJSONObject.getInt("conc_max");
        }
        if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
        {
          localbfhu.b = paramJSONObject.getInt("inv_max");
          localbfhu.c = paramJSONObject.getInt("inv_count");
        }
        if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
        {
          localbfhu.b = paramJSONObject.getInt("fgmax");
          localbfhu.c = paramJSONObject.getInt("fgcur");
        }
        bflp.c("OpenSdkFriendService", "-->result = " + paramJSONObject);
        localbfhu.e = paramJSONObject.optInt("app_rid", -1);
        localbfhu.f = paramJSONObject.optInt("app_tid", -1);
        if ("action_invite".equals(this.jdField_a_of_type_Bfgf.d))
        {
          if (!paramJSONObject.has("md5str")) {
            break label559;
          }
          localObject = paramJSONObject.getString("md5str");
          if (!bfrh.a(bfbm.a().a(), "invite_friend_list_md5").getString(this.jdField_a_of_type_Bfgf.b, "").equals(localObject))
          {
            paramJSONObject = (ArrayList)bfhs.c(paramJSONObject);
            localbfhu.jdField_a_of_type_JavaUtilArrayList = paramJSONObject;
            ThreadManager.executeOnSubThread(new OpenSdkFriendService.GetFriendListCallback.1(this, paramJSONObject, (String)localObject));
            paramJSONObject = (bfgi)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramJSONObject == null) {
              break label558;
            }
            paramJSONObject.a(localbfhu);
            return;
          }
          localbfhu.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Bfgf.a();
          if (localbfhu.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            continue;
          }
          this.jdField_a_of_type_Bfgf.a.putString("md5str", "0");
          this.jdField_a_of_type_Bfgf.a("0");
          paramJSONObject = (bfgi)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramJSONObject == null) {
            break label558;
          }
          new bfmk(this.jdField_a_of_type_Bfgf.c, "GET", new bfgj(this.jdField_a_of_type_Bfgf, paramJSONObject)).a(this.jdField_a_of_type_Bfgf.a);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      if (("action_gift".equals(this.jdField_a_of_type_Bfgf.d)) || ("action_ask".equals(this.jdField_a_of_type_Bfgf.d)) || ("action_voice".equals(this.jdField_a_of_type_Bfgf.d)) || ("action_reactive".equals(this.jdField_a_of_type_Bfgf.d)))
      {
        localbfhu.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bfhs.b(paramJSONObject));
      }
      else
      {
        localbfhu.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)bfhs.a(paramJSONObject));
        continue;
        label486:
        localbfhu.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", localbfhu.jdField_a_of_type_Int);
        paramJSONObject.putExtra("key_error_msg", localbfhu.jdField_a_of_type_JavaLangString);
        paramJSONObject.putExtra("key_error_detail", localbfhu.jdField_a_of_type_OrgJsonJSONObject.toString());
        localObject = (bfgi)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((bfgi)localObject).a(paramJSONObject);
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
 * Qualified Name:     bfgj
 * JD-Core Version:    0.7.0.1
 */