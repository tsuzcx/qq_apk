import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class bgtm
  extends RemoteCommand
{
  public bgtm()
  {
    super("qqreader_plugin_cmd");
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null)) {}
    while (paramFileManagerEntity == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = apue.a().longValue();
    paramQQAppInterface.a().d(localFileManagerEntity);
    int i = aqce.a(paramFileManagerEntity);
    paramFileManagerEntity = aqce.a(localFileManagerEntity);
    paramFileManagerEntity.b(i);
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("forward_type", 0);
    paramQQAppInterface.putParcelable("fileinfo", paramFileManagerEntity);
    paramQQAppInterface.putBoolean("not_forward", true);
    paramFileManagerEntity = new Intent();
    paramFileManagerEntity.putExtras(paramQQAppInterface);
    paramFileManagerEntity.putExtra("destroy_last_activity", false);
    paramFileManagerEntity.putExtra("forward_type", 0);
    paramFileManagerEntity.putExtra("forward_filepath", localFileManagerEntity.getFilePath());
    paramFileManagerEntity.putExtra("forward_text", ajyc.a(2131709711) + apue.d(localFileManagerEntity.fileName) + ajyc.a(2131709723) + apvb.a(localFileManagerEntity.fileSize) + "。");
    paramFileManagerEntity.putExtra("k_favorites", apue.c(localFileManagerEntity));
    if ((!apvb.b(localFileManagerEntity.getFilePath())) && ((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7)) && (localFileManagerEntity.nFileType == 0)) {
      paramFileManagerEntity.putExtra("forward_type", 0);
    }
    if ((localFileManagerEntity.getCloudType() == 8) && (localFileManagerEntity.nFileType == 0)) {
      paramFileManagerEntity.putExtra("forward_type", 1);
    }
    if (!bbev.d(BaseApplication.getContext()))
    {
      aptv.a(2131692665);
      return;
    }
    if (apsz.a(localFileManagerEntity).a(false))
    {
      aptr.a(paramActivity, 2131692672, 2131692677, new bgtn(this, paramActivity, paramFileManagerEntity));
      return;
    }
    aqbc.a(paramActivity, paramFileManagerEntity, 103);
  }
  
  private void a(String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    try
    {
      int i = BaseApplicationImpl.getApplication().appActivities.size();
      if (i > 0)
      {
        Activity localActivity = (Activity)((WeakReference)BaseApplicationImpl.getApplication().appActivities.get(i - 1)).get();
        if (localActivity != null)
        {
          a(localQQAppInterface, localActivity, apue.a(new FileInfo(paramString)));
          return;
        }
        bgvo.a("QRRemoteCommond", "No Activity to use to forward file");
        return;
      }
    }
    catch (FileNotFoundException paramString)
    {
      bgvo.a("QRRemoteCommond", "file not found", paramString);
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = null;
    Object localObject2 = new Bundle();
    Object localObject1 = (akdi)a().getManager(56);
    switch (paramBundle.getInt("CommondType"))
    {
    default: 
    case 13: 
      for (;;)
      {
        return null;
        a(paramBundle.getString("KEY_FILE_PATH"));
      }
    case 1: 
      if (paramBundle == null) {
        break;
      }
    }
    for (paramBundle = paramBundle.getString("uin"); localObject1 != null; paramBundle = null)
    {
      for (;;)
      {
        if (((akdi)localObject1).b(paramBundle) != null) {
          ((Bundle)localObject2).putBoolean("get_publicaccountinfo", true);
        }
        for (;;)
        {
          return localObject2;
          ((Bundle)localObject2).putBoolean("get_publicaccountinfo", false);
        }
        ((Bundle)localObject2).putInt("qq_vip_level", bgto.a(a(), null));
        return localObject2;
        ((Bundle)localObject2).putShort("qq_vip_info", bgto.a(a(), null));
        return localObject2;
        if (a() == null) {
          break;
        }
        paramBundle = paramBundle.getString("publicaccount_uin");
        ((Bundle)localObject2).putBoolean("publicaccount_is_follow", sgj.a(a(), paramBundle));
        return localObject2;
        if (a() == null) {
          break;
        }
        localObject1 = paramBundle.getString("publicaccount_uin");
        Object localObject3 = (akdi)a().getManager(56);
        paramBundle = paramOnInvokeFinishLinstener;
        if (localObject3 != null) {
          paramBundle = ((akdi)localObject3).b((String)localObject1);
        }
        if (paramBundle != null)
        {
          ((Bundle)localObject2).putBoolean("isFollow", true);
          ((Bundle)localObject2).putString("paName", paramBundle.name);
        }
        for (;;)
        {
          return localObject2;
          ((Bundle)localObject2).putBoolean("isFollow", false);
        }
        int i = paramBundle.getInt("sharetype");
        paramOnInvokeFinishLinstener = paramBundle.getString("url");
        localObject3 = (Bitmap)paramBundle.getParcelable("cover");
        Object localObject5 = paramBundle.getString("title");
        localObject1 = paramBundle.getString("detail");
        Object localObject4 = paramBundle.getString("imgUrl");
        switch (i)
        {
        default: 
        case 1: 
        case 2: 
          for (;;)
          {
            return localObject2;
            paramBundle = new Bundle();
            paramBundle.putString("title", (String)localObject5);
            paramBundle.putString("desc", (String)localObject1);
            paramBundle.putString("detail_url", paramOnInvokeFinishLinstener);
            paramOnInvokeFinishLinstener = new ArrayList(1);
            paramOnInvokeFinishLinstener.add(localObject4);
            paramBundle.putStringArrayList("image_url", paramOnInvokeFinishLinstener);
            bgyu.a(a(), a().getApplication().getApplicationContext(), paramBundle, null);
            continue;
            localObject4 = WXShareHelper.a();
            l = System.currentTimeMillis();
            if (TextUtils.isEmpty(paramBundle.getString("detail"))) {
              localObject1 = paramOnInvokeFinishLinstener;
            }
            ((WXShareHelper)localObject4).d(String.valueOf(l), (String)localObject5, (Bitmap)localObject3, (String)localObject1, paramOnInvokeFinishLinstener);
          }
        }
        localObject4 = WXShareHelper.a();
        long l = System.currentTimeMillis();
        localObject5 = new StringBuilder().append((String)localObject5).append(":");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (paramBundle = paramOnInvokeFinishLinstener;; paramBundle = (Bundle)localObject1)
        {
          localObject5 = paramBundle;
          paramBundle = (Bundle)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramBundle = paramOnInvokeFinishLinstener;
          }
          ((WXShareHelper)localObject4).c(String.valueOf(l), (String)localObject5, (Bitmap)localObject3, paramBundle, paramOnInvokeFinishLinstener);
          break;
        }
        if ((WXShareHelper.a().a()) && (WXShareHelper.a().b())) {
          ((Bundle)localObject2).putBoolean("is_wx_supported", true);
        }
        for (;;)
        {
          return localObject2;
          ((Bundle)localObject2).putBoolean("is_wx_supported", false);
        }
        paramBundle = paramBundle.getString("url");
        paramBundle = new Intent(a().getApplication().getApplicationContext(), QQBrowserActivity.class).putExtra("url", paramBundle);
        paramBundle.putExtra("uin", a().getCurrentAccountUin());
        paramBundle.putExtra("vkey", a().a());
        paramBundle.setFlags(268435456);
        a().getApplication().getApplicationContext().startActivity(paramBundle);
        break;
        paramOnInvokeFinishLinstener = a();
        if (paramOnInvokeFinishLinstener != null)
        {
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.getHandler(Conversation.class);
          if (paramOnInvokeFinishLinstener == null) {
            break;
          }
          localObject1 = paramOnInvokeFinishLinstener.obtainMessage(1134027);
          localObject2 = paramBundle.getString("bookName");
          l = paramBundle.getLong("bookId");
          paramBundle = paramBundle.getString("chapterId");
          paramBundle = (String)localObject2 + "@#" + l + "@#" + paramBundle;
          if (QLog.isColorLevel()) {
            QLog.e("QRRemoteCommond", 2, "bookInfo : " + paramBundle);
          }
          ((Message)localObject1).obj = paramBundle;
          paramOnInvokeFinishLinstener.sendMessage((Message)localObject1);
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("QRRemoteCommond", 2, "showReaderBar app = null");
        break;
        paramOnInvokeFinishLinstener = a();
        if (paramOnInvokeFinishLinstener != null)
        {
          paramOnInvokeFinishLinstener = (avpq)paramOnInvokeFinishLinstener.getManager(36);
          if (paramOnInvokeFinishLinstener != null)
          {
            paramBundle = paramOnInvokeFinishLinstener.a(paramBundle.getString("path"));
            if (paramBundle != null) {
              ((Bundle)localObject2).putParcelable("redTouchInfo", avpt.a(paramBundle));
            }
          }
        }
        for (;;)
        {
          return localObject2;
          if (QLog.isColorLevel()) {
            QLog.e("QRRemoteCommond", 2, "getRedTouch app = null");
          }
        }
        paramOnInvokeFinishLinstener = a();
        if (paramOnInvokeFinishLinstener == null) {
          break label1079;
        }
        paramOnInvokeFinishLinstener = (avpq)paramOnInvokeFinishLinstener.getManager(36);
        if (paramOnInvokeFinishLinstener == null) {
          break;
        }
        paramBundle = paramBundle.getString("path");
        paramOnInvokeFinishLinstener.b(paramBundle);
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("service_type", 2);
          ((JSONObject)localObject1).put("act_id", 1002);
          paramOnInvokeFinishLinstener.c(paramOnInvokeFinishLinstener.a(paramBundle), ((JSONObject)localObject1).toString());
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
      break;
      label1079:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QRRemoteCommond", 2, "clickRedTouch app = null");
      break;
      paramOnInvokeFinishLinstener = a();
      if (paramOnInvokeFinishLinstener == null) {
        break;
      }
      paramOnInvokeFinishLinstener = (avpq)paramOnInvokeFinishLinstener.getManager(36);
      localObject1 = paramBundle.getStringArrayList("pathList");
      if ((paramOnInvokeFinishLinstener == null) || (localObject1 == null)) {
        break;
      }
      paramBundle = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = paramOnInvokeFinishLinstener.a((String)((Iterator)localObject1).next());
        if (localObject2 != null) {
          paramBundle.add(avpt.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
        }
      }
      paramOnInvokeFinishLinstener = new Bundle();
      paramOnInvokeFinishLinstener.putParcelableArrayList("redTouchInfoList", paramBundle);
      return paramOnInvokeFinishLinstener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtm
 * JD-Core Version:    0.7.0.1
 */