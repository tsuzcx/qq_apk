import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awot
  extends VasWebviewJsPlugin
{
  protected String a;
  private boolean a;
  protected String b;
  
  public awot()
  {
    this.mPluginNameSpace = "historyhead";
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, ArrayList<PicInfo> paramArrayList, ArrayList<String> paramArrayList1, boolean paramBoolean, String paramString, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfilePicBrowserActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putInt("fromType", paramInt2);
    if (paramArrayList != null) {
      localBundle.putParcelableArrayList("picInfos", paramArrayList);
    }
    if (paramArrayList1 != null) {
      localBundle.putStringArrayList("fileIdList", paramArrayList1);
    }
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", paramBoolean);
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("src_id", paramString);
    }
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt3);
  }
  
  protected void a(String paramString)
  {
    int k = 0;
    int j = 100;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = paramString.optString("setName");
      this.b = paramString.optString("delName");
      Object localObject3 = paramString.optJSONArray("imageIDs");
      Object localObject2 = paramString.optJSONArray("str_fileids");
      int m = paramString.optInt("index");
      String str = paramString.optString("srcID");
      int n = paramString.optInt("fromType");
      boolean bool = paramString.optBoolean("isNotShowIndex", true);
      if (this.mRuntime.a() == null) {
        return;
      }
      if (this.mRuntime.a() != null)
      {
        Object localObject1 = this.mRuntime.a();
        if (localObject1 != null)
        {
          paramString = (String)localObject1;
          if ((localObject1 instanceof BasePluginActivity)) {
            paramString = ((BasePluginActivity)localObject1).getOutActivity();
          }
          localObject1 = new ArrayList();
          int i1;
          int i;
          if (localObject3 != null)
          {
            i1 = ((JSONArray)localObject3).length();
            i = 0;
            while (i < i1)
            {
              PicInfo localPicInfo = new PicInfo();
              localPicInfo.jdField_a_of_type_JavaLangString = ((JSONArray)localObject3).get(i).toString();
              localPicInfo.g = "type_history_head_pic";
              ((ArrayList)localObject1).add(localPicInfo);
              i += 1;
            }
          }
          localObject3 = new ArrayList();
          if (localObject2 != null)
          {
            i1 = ((JSONArray)localObject2).length();
            i = k;
            while (i < i1)
            {
              ((ArrayList)localObject3).add(((JSONArray)localObject2).get(i).toString());
              i += 1;
            }
          }
          localObject2 = this.mRuntime.a();
          if ((paramString instanceof beha)) {
            i = ((beha)paramString).switchRequestCode(this, (byte)100);
          }
          for (;;)
          {
            a(paramString, m, n, (ArrayList)localObject1, (ArrayList)localObject3, bool, str, i);
            return;
            i = j;
            if (localObject2 != null) {
              i = ((WebViewFragment)localObject2).switchRequestCode(this, (byte)100);
            }
          }
        }
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("historyhead".equals(paramString2)) && ("showPicture".equals(paramString3)) && (paramVarArgs.length == 1)) {
      a(paramVarArgs[0]);
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if ((paramByte != 100) || (paramInt != -1) || (this.mRuntime.a() == null)) {}
    label21:
    do
    {
      do
      {
        do
        {
          break label21;
          do
          {
            return;
          } while (paramIntent == null);
          if ((!paramIntent.hasExtra("setHead_fileid")) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
            break;
          }
          paramIntent = paramIntent.getStringExtra("setHead_fileid");
        } while (TextUtils.isEmpty(paramIntent));
        callJs(this.jdField_a_of_type_JavaLangString, new String[] { ndq.a(paramIntent) });
        return;
      } while ((!paramIntent.hasExtra("delHead_fileid")) || (TextUtils.isEmpty(this.b)));
      paramIntent = paramIntent.getStringExtra("delHead_fileid");
    } while (TextUtils.isEmpty(paramIntent));
    callJs(this.b, new String[] { ndq.a(paramIntent) });
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("hasHistoryHeadDel", this.jdField_a_of_type_Boolean);
      super.sendRemoteReq(apml.a("ipc_cmd_historyhead_refresh_numflag", "", 0, localBundle), false, true);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awot
 * JD-Core Version:    0.7.0.1
 */