import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class arnj
  extends WebViewPlugin
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new arnk(this);
  private volatile boolean jdField_a_of_type_Boolean;
  
  public arnj()
  {
    this.mPluginNameSpace = "story";
  }
  
  public static final void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, StoryTransitionActivity.class);
    localIntent.putExtra("jump_action", 1);
    paramContext.startActivity(localIntent);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"story".equals(paramString2)) {
      return false;
    }
    Activity localActivity = this.mRuntime.a();
    if (paramString3.equals("openIndex"))
    {
      StoryTransitionActivity.b(localActivity);
      return true;
    }
    if (paramString3.equals("newStory"))
    {
      paramJsBridgeListener = new Intent(localActivity, StoryTransitionActivity.class);
      paramJsBridgeListener.putExtra("jump_action", 1);
      paramJsBridgeListener.putExtra("video_tag", paramVarArgs[0]);
      localActivity.startActivity(paramJsBridgeListener);
      return true;
    }
    long l;
    if (paramString3.equals("playStory"))
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString1.optString("vid", "");
        l = paramString1.optLong("uin", 0L);
        if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (l > 0L))
        {
          paramString1 = new Intent(localActivity, JumpActivity.class);
          paramString1.setData(Uri.parse("mqqapi://qstory/openVideo?videoOwnerUin=" + l + "&videoId=" + paramJsBridgeListener));
          localActivity.startActivity(paramString1);
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQStoryApiPlugin", 2, "StoryApi Exception: " + paramJsBridgeListener.getMessage());
          }
        }
      }
      return true;
    }
    if (paramString3.equals("openTopic")) {
      return false;
    }
    int i;
    if (paramString3.equals("openLive"))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        i = paramJsBridgeListener.optInt("type", 0);
        l = paramJsBridgeListener.optLong("roomId", 0L);
        int j = paramJsBridgeListener.optInt("fromId", 0);
        paramJsBridgeListener = paramJsBridgeListener.optJSONObject("extras");
        if (i != 1) {
          break label782;
        }
        paramString1 = new Intent(localActivity, JumpActivity.class);
        paramString2 = new StringBuilder().append("mqqapi://qstory/openNow?roomid=").append(l).append("&fromid=").append(j).append("&extras=");
        if (paramJsBridgeListener == null) {}
        for (paramJsBridgeListener = "";; paramJsBridgeListener = paramJsBridgeListener.toString())
        {
          paramString1.setData(Uri.parse(paramJsBridgeListener));
          localActivity.startActivity(paramString1);
          break;
        }
        QLog.w("QQStoryApiPlugin", 2, "StoryApi Exception: " + paramJsBridgeListener.getMessage());
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (!QLog.isColorLevel()) {
          break label782;
        }
      }
    }
    else
    {
      if (("openInfoCard".equals(paramString3)) || ("openMiniSummary".equals(paramString3))) {
        try
        {
          QQStoryMemoriesActivity.a(localActivity, 23, new JSONObject(paramVarArgs[0]).optLong("uin", 0L));
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("QQStoryApiPlugin", 2, "StoryApi Exception: " + paramJsBridgeListener.getMessage());
            }
          }
        }
      }
      if (paramString3.equals("playVideos")) {}
      for (;;)
      {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString1.optString("videolist", "");
          paramJsBridgeListener = paramString1.optString("feedlist", "");
          i = paramString1.optInt("index", 0);
          paramString3 = paramString1.optString("play_scence", "");
          if ((TextUtils.isEmpty(paramString3)) || (!"videoLabelDetail".equals(paramString3))) {
            break;
          }
          paramString1.optInt("tagid");
          paramString1.optInt("tagtype");
          if (TextUtils.isEmpty(paramString2)) {
            break;
          }
          paramString3 = new ArrayList(Arrays.asList(paramString2.split(",")));
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramJsBridgeListener = new ArrayList(Arrays.asList(paramJsBridgeListener.split(",")));
            if (paramString3.size() <= i) {
              break label776;
            }
            paramString1 = (String)paramString3.get(i);
            if (paramJsBridgeListener.size() <= i) {
              break label770;
            }
            paramString2 = (String)paramJsBridgeListener.get(i);
            tvc.a(localActivity, new VidListPlayInfo(paramJsBridgeListener, paramString3, paramString2, paramString1), 105, null);
            break;
          }
          paramJsBridgeListener = new ArrayList();
          continue;
          QLog.w("QQStoryApiPlugin", 2, "StoryApi Exception: " + paramJsBridgeListener.getMessage());
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        break;
        return false;
        label770:
        paramString2 = "";
        continue;
        label776:
        paramString1 = "";
      }
    }
    label782:
    return true;
    return true;
  }
  
  public void onActivityReady()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_do_like");
    localIntentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_comment");
    localIntentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_subscribe");
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (!this.jdField_a_of_type_Boolean)) {}
    try
    {
      localActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQStoryApiPlugin", 2, "regist receiver error:" + localException.toString());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (this.jdField_a_of_type_Boolean))
    {
      localActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arnj
 * JD-Core Version:    0.7.0.1
 */