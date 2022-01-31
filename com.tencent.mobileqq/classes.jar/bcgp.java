import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class bcgp
  extends WebViewPlugin
{
  protected AtomicBoolean a;
  protected yqz a;
  
  public bcgp()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.mPluginNameSpace = "troopAssistantFeeds";
  }
  
  protected void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopFeeds:" + paramString);
      }
      if (TextUtils.isEmpty(new JSONObject(paramString).getString("url"))) {
        return;
      }
      QQToast.a(this.mRuntime.a(), 0, alud.a(2131715600), 0).a();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopFeeds:" + paramString.toString());
      }
    }
  }
  
  protected void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString.getString("guin");
      paramString.getString("gcode");
      c(paramString.getString("videourl"));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideoInBrowserActivity:" + paramString);
      }
      Activity localActivity = this.mRuntime.a();
      paramString = paramString.trim();
      String str = this.mRuntime.a().getCurrentAccountUin();
      Intent localIntent = new Intent(localActivity, QQBrowserDelegationActivity.class);
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      if (paramString.indexOf("?") > 0) {}
      for (paramString = "";; paramString = "?")
      {
        paramString = localStringBuilder.append(paramString).append("&from=androidqq");
        localIntent.putExtra("param_force_internal_browser", true);
        localIntent.putExtra("injectrecommend", false);
        localIntent.putExtra("key_isReadModeEnabled", true);
        localIntent.putExtra("url", paramString.toString().trim());
        localIntent.putExtra("uin", str);
        localIntent.putExtra("friendUin", "");
        localActivity.startActivity(localIntent);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideoInBrowserActivity:" + paramString.toString());
      }
    }
  }
  
  protected void d(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopCard:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("guin");
      localObject = ((JSONObject)localObject).getString("gcode");
      if (!TextUtils.isEmpty(paramString))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        Activity localActivity = this.mRuntime.a();
        Bundle localBundle = TroopInfoActivity.a(String.valueOf(localObject), 6);
        localBundle.putString("troop_code", paramString);
        localBundle.putString("troop_uin", (String)localObject);
        localBundle.putInt("troop_uin", 6);
        bcpx.a(localActivity, localBundle, 2);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopCard:" + paramString.toString());
      }
    }
  }
  
  protected void e(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopMemberCard:" + paramString);
      }
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).getString("guin");
      String str = ((JSONObject)localObject1).getString("gcode");
      localObject1 = ((JSONObject)localObject1).getString("muin");
      Object localObject2 = this.mRuntime.a().getCurrentAccountUin();
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        localObject2 = this.mRuntime.a();
        Intent localIntent = new Intent((Context)localObject2, FriendProfileCardActivity.class);
        localIntent.putExtra("troopUin", str);
        localIntent.putExtra("troopCode", paramString);
        localIntent.putExtra("memberUin", (String)localObject1);
        localIntent.putExtra("fromFlag", 3);
        ((Activity)localObject2).startActivity(localIntent);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopMemberCard:" + paramString.toString());
      }
    }
  }
  
  protected void f(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopAIO:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("guin");
      String str = ((JSONObject)localObject).getString("gcode");
      localObject = ((JSONObject)localObject).getString("gname");
      if (!TextUtils.isEmpty(paramString))
      {
        if (TextUtils.isEmpty(str)) {
          return;
        }
        Activity localActivity = this.mRuntime.a();
        Intent localIntent = aepi.a(new Intent(localActivity, SplashActivity.class), null);
        localIntent.putExtra("uin", str);
        localIntent.putExtra("troop_uin", paramString);
        localIntent.putExtra("uintype", 1);
        localIntent.putExtra("uinname", (String)localObject);
        localActivity.startActivity(localIntent);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopAIO:" + paramString.toString());
      }
    }
  }
  
  protected void g(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openFile:" + paramString);
      }
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).getString("uuid");
      try
      {
        l1 = ((JSONObject)localObject2).getLong("fileSize");
        l2 = ((JSONObject)localObject2).getLong("gcode");
        String str1 = ((JSONObject)localObject2).getString("fileName");
        String str2 = ((JSONObject)localObject2).getString("url");
        int i = ((JSONObject)localObject2).getInt("bisID");
        Object localObject1 = ((JSONObject)localObject2).optString("senderUin");
        long l3 = ((JSONObject)localObject2).optLong("lastTime");
        localObject2 = this.mRuntime.a();
        Intent localIntent = new Intent((Context)localObject2, TroopFileDetailBrowserActivity.class);
        localIntent.putExtra("from_webview", true);
        localIntent.putExtra("bisId", i);
        localIntent.putExtra("sender_uin", (String)localObject1);
        localIntent.putExtra("last_time", l3);
        localObject1 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject1).d(4);
        ((ForwardFileInfo)localObject1).b(10006);
        ((ForwardFileInfo)localObject1).d(str1);
        ((ForwardFileInfo)localObject1).d(l1);
        ((ForwardFileInfo)localObject1).a(l2);
        ((ForwardFileInfo)localObject1).b(paramString);
        ((ForwardFileInfo)localObject1).e(str2);
        localIntent.putExtra("fileinfo", (Parcelable)localObject1);
        ((Activity)localObject2).startActivity(localIntent);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAssistantFeedsJsHandler", 2, "openFile:" + localException.toString());
          }
          long l1 = 0L;
          long l2 = 0L;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openFile:" + paramString.toString());
      }
    }
  }
  
  protected void h(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openQZoneAlbumDetail:" + paramString);
      }
      paramString = new JSONObject(paramString).getString("url");
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      AppInterface localAppInterface = this.mRuntime.a();
      Activity localActivity = this.mRuntime.a();
      bjea localbjea = bjea.a();
      localbjea.a = localAppInterface.getCurrentAccountUin();
      localbjea.b = "";
      bjdt.b(localActivity, localbjea, paramString, "mqqChat.QzoneCard", -1);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openQZoneAlbumDetail:" + paramString.toString());
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("troopAssistantFeeds".equals(paramString2))
    {
      if (("openGroupCard".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        d(paramVarArgs[0]);
        return true;
      }
      if (("openGroupMemCard".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        e(paramVarArgs[0]);
        return true;
      }
      if (("openGroupAIO".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        f(paramVarArgs[0]);
        return true;
      }
      if (("openGroupFileDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        g(paramVarArgs[0]);
        return true;
      }
      if (("openGroupPhotoDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        h(paramVarArgs[0]);
        return true;
      }
      if (("openVideo".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        b(paramVarArgs[0]);
        return true;
      }
      if (("openGroupFeedsDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        a(paramVarArgs[0]);
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 344	com/tencent/mobileqq/webview/swift/WebViewPlugin:onDestroy	()V
    //   4: aload_0
    //   5: getfield 346	bcgp:jdField_a_of_type_Yqz	Lyqz;
    //   8: ifnull +10 -> 18
    //   11: aload_0
    //   12: getfield 346	bcgp:jdField_a_of_type_Yqz	Lyqz;
    //   15: invokevirtual 350	yqz:b	()V
    //   18: aload_0
    //   19: getfield 18	bcgp:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   22: iconst_0
    //   23: invokevirtual 353	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 18	bcgp:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   32: iconst_0
    //   33: invokevirtual 353	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 18	bcgp:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   42: iconst_0
    //   43: invokevirtual 353	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	bcgp
    //   27	1	1	localException	Exception
    //   37	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	18	27	java/lang/Exception
    //   4	18	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgp
 * JD-Core Version:    0.7.0.1
 */