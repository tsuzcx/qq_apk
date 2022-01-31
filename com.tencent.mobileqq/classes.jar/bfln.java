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
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class bfln
  extends RemoteCommand
{
  public bfln()
  {
    super("qqreader_plugin_cmd");
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    Object localObject1 = null;
    Object localObject2 = new Bundle();
    Object localObject3 = (ajoy)a().getManager(56);
    int i = paramBundle.getInt("CommondType");
    paramOnInvokeFinishLinstener = a();
    if (paramOnInvokeFinishLinstener != null) {}
    for (paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.getApp();; paramOnInvokeFinishLinstener = null) {
      switch (i)
      {
      default: 
        return null;
      }
    }
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("uin"); localObject3 != null; paramBundle = null)
    {
      for (;;)
      {
        if (((ajoy)localObject3).b(paramBundle) != null) {
          ((Bundle)localObject2).putBoolean("get_publicaccountinfo", true);
        }
        for (;;)
        {
          return localObject2;
          ((Bundle)localObject2).putBoolean("get_publicaccountinfo", false);
        }
        ((Bundle)localObject2).putInt("qq_vip_level", bflo.a(a(), null));
        return localObject2;
        ((Bundle)localObject2).putShort("qq_vip_info", bflo.a(a(), null));
        return localObject2;
        if (a() == null) {
          break;
        }
        paramBundle = paramBundle.getString("publicaccount_uin");
        ((Bundle)localObject2).putBoolean("publicaccount_is_follow", rtr.a(a(), paramBundle));
        return localObject2;
        if (a() == null) {
          break;
        }
        paramOnInvokeFinishLinstener = paramBundle.getString("publicaccount_uin");
        localObject3 = (ajoy)a().getManager(56);
        paramBundle = (Bundle)localObject1;
        if (localObject3 != null) {
          paramBundle = ((ajoy)localObject3).b(paramOnInvokeFinishLinstener);
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
        i = paramBundle.getInt("sharetype");
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
            bfqn.a(a(), a().getApplication().getApplicationContext(), paramBundle, null);
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
          paramOnInvokeFinishLinstener = (auqh)paramOnInvokeFinishLinstener.getManager(36);
          if (paramOnInvokeFinishLinstener != null)
          {
            paramBundle = paramOnInvokeFinishLinstener.a(paramBundle.getString("path"));
            if (paramBundle != null) {
              ((Bundle)localObject2).putParcelable("redTouchInfo", auqk.a(paramBundle));
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
          break label1070;
        }
        paramOnInvokeFinishLinstener = (auqh)paramOnInvokeFinishLinstener.getManager(36);
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
      label1070:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QRRemoteCommond", 2, "clickRedTouch app = null");
      break;
      paramOnInvokeFinishLinstener = a();
      if (paramOnInvokeFinishLinstener == null) {
        break;
      }
      paramOnInvokeFinishLinstener = (auqh)paramOnInvokeFinishLinstener.getManager(36);
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
          paramBundle.add(auqk.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
        }
      }
      paramOnInvokeFinishLinstener = new Bundle();
      paramOnInvokeFinishLinstener.putParcelableArrayList("redTouchInfoList", paramBundle);
      return paramOnInvokeFinishLinstener;
      localObject1 = paramBundle.getString("KEY_QR_SP");
      boolean bool2 = paramBundle.getBoolean("VALUE_QR_SP_DEFAULT", false);
      boolean bool1 = bool2;
      if (paramOnInvokeFinishLinstener != null) {
        bool1 = bflo.a(paramOnInvokeFinishLinstener, (String)localObject1, bool2);
      }
      paramBundle = new Bundle();
      paramBundle.putBoolean("VALUE_QR_SP", bool1);
      return paramBundle;
      localObject1 = paramBundle.getString("KEY_QR_SP");
      i = paramBundle.getInt("VALUE_QR_SP_DEFAULT", 0);
      if (paramOnInvokeFinishLinstener != null) {}
      for (i = bflo.a(paramOnInvokeFinishLinstener, (String)localObject1, i);; i = 0)
      {
        paramBundle = new Bundle();
        paramBundle.putInt("VALUE_QR_SP", i);
        return paramBundle;
        localObject1 = paramBundle.getString("KEY_QR_SP");
        bool1 = paramBundle.getBoolean("VALUE_QR_SP");
        if (paramOnInvokeFinishLinstener != null) {
          bflo.a(paramOnInvokeFinishLinstener, (String)localObject1, bool1);
        }
        return null;
        localObject1 = paramBundle.getString("KEY_QR_SP");
        i = paramBundle.getInt("VALUE_QR_SP");
        if (paramOnInvokeFinishLinstener != null) {
          bflo.a(paramOnInvokeFinishLinstener, (String)localObject1, i);
        }
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfln
 * JD-Core Version:    0.7.0.1
 */