import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class bnna
  extends bnnn
{
  private static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bnna.class.getSimpleName();
  }
  
  private void a(bioy parambioy, String[] paramArrayOfString)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      String str;
      do
      {
        return;
        try
        {
          paramArrayOfString = new JSONObject(paramArrayOfString[0]);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_item_id", paramArrayOfString.optInt("item_id"));
          ((Intent)localObject2).putExtra("key_thumb_url", paramArrayOfString.optString("thumb"));
          ((Intent)localObject2).putExtra("key_item_type", paramArrayOfString.optInt("item_type"));
          ((Intent)localObject2).setAction("action_album_skin_js_to_qzone");
          str = paramArrayOfString.optString("callback");
          localObject1 = paramArrayOfString.optString("entry");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { "{\"result\":\"false\"}" });
            return;
          }
        }
        catch (JSONException parambioy)
        {
          parambioy.printStackTrace();
          return;
        }
      } while ((!"createAlbum".equals(localObject1)) && (!"editAlbum".equals(localObject1)) && (!"personal".equals(localObject1)) && (!"photolist".equals(localObject1)));
      if (parambioy.a() != null) {
        parambioy.a().sendBroadcast((Intent)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { "{\"result\":\"true\"}" });
      parambioy = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    } while ((!"personal".equals(localObject1)) || (parambioy == null));
    Object localObject1 = bmtk.a();
    ((bmtk)localObject1).jdField_a_of_type_JavaLangString = parambioy.getCurrentAccountUin();
    Object localObject2 = new BaseBusinessAlbumInfo();
    ((BaseBusinessAlbumInfo)localObject2).jdField_a_of_type_JavaLangString = paramArrayOfString.optString("albumid");
    ((BaseBusinessAlbumInfo)localObject2).jdField_a_of_type_Long = parambioy.getLongAccountUin();
    ((BaseBusinessAlbumInfo)localObject2).c = 0;
    ((BaseBusinessAlbumInfo)localObject2).jdField_a_of_type_Boolean = true;
    bmtd.a(localActivity, (bmtk)localObject1, (BaseBusinessAlbumInfo)localObject2, -1);
  }
  
  private void a(bioy parambioy, String[] paramArrayOfString, String paramString)
  {
    try
    {
      paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if ((paramArrayOfString != null) && (!paramArrayOfString.isFinishing()))
      {
        paramArrayOfString = new Intent();
        paramArrayOfString.setAction(paramString);
        if (parambioy.a() != null) {
          parambioy.a().sendBroadcast(paramArrayOfString);
        }
      }
      return;
    }
    catch (Exception parambioy)
    {
      parambioy.printStackTrace();
    }
  }
  
  private void b(bioy parambioy, String[] paramArrayOfString)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_album_comment_list_count", paramArrayOfString.optInt("count"));
        ((Intent)localObject).setAction("broadcastActionUpdateAlbumCommentList");
        if (parambioy.a() != null) {
          parambioy.a().sendBroadcast((Intent)localObject);
        }
      }
      return;
    }
    catch (Exception parambioy)
    {
      parambioy.printStackTrace();
    }
  }
  
  private void c(bioy parambioy, String[] paramArrayOfString)
  {
    a(parambioy, paramArrayOfString, "broadcastActionRefreshPhotoList");
  }
  
  private void d(bioy parambioy, String[] paramArrayOfString)
  {
    a(parambioy, paramArrayOfString, "broadcastActionRefreshAlbumList");
  }
  
  private void e(bioy parambioy, String[] paramArrayOfString)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("broadcastActionBlogShareData");
        if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
          ((Intent)localObject).putExtra("share_data", paramArrayOfString[0]);
        }
        if (parambioy.a() != null) {
          parambioy.a().sendBroadcast((Intent)localObject);
        }
      }
      return;
    }
    catch (Exception parambioy)
    {
      parambioy.printStackTrace();
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ((paramString3.equalsIgnoreCase("SetAlbumSkin")) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ((paramString3.equalsIgnoreCase("UpdateAlbumCommentList")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("refreshPhotoList".equalsIgnoreCase(paramString3))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("RefreshAlbumList".equalsIgnoreCase(paramString3))
    {
      d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("getBlogArkShareData".equalsIgnoreCase(paramString3))
    {
      e(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnna
 * JD-Core Version:    0.7.0.1
 */