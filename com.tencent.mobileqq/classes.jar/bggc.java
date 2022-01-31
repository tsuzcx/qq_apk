import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginRemoteCommand.1;
import mqq.app.AppRuntime;

public class bggc
  extends RemoteCommand
{
  boolean a = true;
  
  public bggc(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.a = paramBoolean;
  }
  
  public static Bitmap a(String paramString, Resources paramResources, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = wim.a(paramString, -1);
    int m = ((ij)localObject).a();
    paramString = new int[m * m];
    int i = 0;
    while (i < m)
    {
      int j = 0;
      if (j < m)
      {
        if (((ij)localObject).a(j, i)) {}
        for (int k = -16777216;; k = 16777215)
        {
          paramString[(i * m + j)] = k;
          j += 1;
          break;
        }
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, m);
    try
    {
      paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
      if (paramString == null)
      {
        ((Bitmap)localObject).recycle();
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        System.gc();
        try
        {
          paramString = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.w("com.tencent.nfc.buscard.remotecommand", 2, paramString.getMessage());
          }
          return null;
        }
      }
      Canvas localCanvas = new Canvas(paramString);
      localCanvas.drawBitmap((Bitmap)localObject, null, new Rect(paramInt2, paramInt2, paramInt1 - paramInt2, paramInt1 - paramInt2), null);
      if (paramBoolean)
      {
        paramInt1 = (paramInt1 - 60) / 2;
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        Rect localRect = new Rect(paramInt1, paramInt1, paramInt1 + 60, 60 + paramInt1);
        paramResources = bawu.a(paramResources, 2130842967);
        if (paramResources != null)
        {
          localCanvas.drawBitmap(paramResources, null, localRect, localPaint);
          paramResources.recycle();
        }
      }
      ((Bitmap)localObject).recycle();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.nfc.buscard.remotecommand", 2, "getQrCode cost time:" + (l2 - l1));
      }
    }
    return paramString;
  }
  
  private Bundle a(Bundle paramBundle1, Bundle paramBundle2, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle1 == null) {
      return paramBundle2;
    }
    if (paramBundle2 == null) {}
    label179:
    label227:
    label742:
    for (Bundle localBundle = new Bundle();; localBundle = paramBundle2)
    {
      paramBundle2 = paramBundle1.getString("cmd");
      int i;
      int j;
      Object localObject1;
      if (!TextUtils.isEmpty(paramBundle2))
      {
        if (!paramBundle2.equals("getQrCode")) {
          break label227;
        }
        paramBundle2 = paramBundle1.getString("sharelink");
        i = paramBundle1.getInt("imgsize");
        j = paramBundle1.getInt("margin");
        bool1 = paramBundle1.getBoolean("showlogo");
        if (!TextUtils.isEmpty(paramBundle2))
        {
          localObject1 = batu.a(paramBundle2, BaseApplicationImpl.getContext().getResources(), i, j, bool1);
          if (localObject1 != null) {
            localBundle.putString("path", wim.a(BaseApplicationImpl.getContext(), paramBundle2.hashCode() + "", (Bitmap)localObject1));
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramBundle2 = new StringBuilder().append("dispatchRemoteCmd,req=").append(paramBundle1).append("; rsp=");
        if (localBundle == null) {
          break label755;
        }
        paramBundle1 = localBundle.toString();
        paramBundle1 = paramBundle2.append(paramBundle1).append(";mIsSynchronized=").append(this.a).append("; linstener is null=");
        if (paramOnInvokeFinishLinstener == null) {
          break label762;
        }
      }
      label619:
      label748:
      label755:
      label762:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.d("BuscardPluginRemoteCommand", 2, bool1);
        return localBundle;
        if (paramBundle2.equals("genQrCode"))
        {
          paramBundle2 = paramBundle1.getString("qrcontent");
          i = paramBundle1.getInt("imgsize");
          j = paramBundle1.getInt("margin");
          bool1 = paramBundle1.getBoolean("showlogo");
          if (TextUtils.isEmpty(paramBundle2)) {
            break;
          }
          localBundle.putParcelable("qrcode", a(paramBundle2, BaseApplicationImpl.getContext().getResources(), i, j, bool1));
          break;
        }
        if (paramBundle2.equals("location"))
        {
          SosoInterface.a(new bggd(this, 3, true, true, 300000L, false, false, "buscardLocation", localBundle, paramOnInvokeFinishLinstener));
          break;
        }
        Object localObject2;
        if (paramBundle2.equals("publicAccount"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BuscardPluginRemoteCommand", 2, "publicAccount.");
          }
          if (a() == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BuscardPluginRemoteCommand", 2, "publicAccount.enter");
          }
          localObject1 = paramBundle1.getString("publicAccount_uin");
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("publicAccount.enter, publicAccount_uin=");
            if (localObject1 == null) {
              break label461;
            }
          }
          for (paramBundle2 = (Bundle)localObject1;; paramBundle2 = "null")
          {
            QLog.d("BuscardPluginRemoteCommand", 2, paramBundle2);
            sgj.a(a(), a().getApp(), (String)localObject1, new bgge(this, localBundle, paramOnInvokeFinishLinstener));
            break;
          }
        }
        if (!paramBundle2.equals("queryPublicAccount")) {
          break;
        }
        paramBundle2 = paramBundle1.getString("publicAccount_uin");
        boolean bool2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("publicAccount.queryPublicAccount, publicAccount_uin=");
          if (paramBundle2 != null)
          {
            localObject1 = paramBundle2;
            QLog.d("BuscardPluginRemoteCommand", 2, (String)localObject1);
          }
        }
        else
        {
          boolean bool3 = false;
          bool1 = false;
          bool2 = bool3;
          if (a() != null)
          {
            bool2 = bool3;
            if (!TextUtils.isEmpty(paramBundle2))
            {
              localObject2 = (akdi)a().getManager(56);
              if (localObject2 != null) {
                bool1 = ((akdi)localObject2).a(Long.valueOf(paramBundle2));
              }
              bool2 = bool1;
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder().append("publicAccount.queryPublicAccount, publicAccount_uin=");
                if (paramBundle2 == null) {
                  break label734;
                }
                localObject1 = paramBundle2;
                localObject1 = localStringBuilder.append((String)localObject1).append(";PublicAccountDataManager not null=");
                if (localObject2 == null) {
                  break label742;
                }
                bool2 = true;
                QLog.d("BuscardPluginRemoteCommand", 2, bool2);
                bool2 = bool1;
              }
            }
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder().append("publicAccount.queryPublicAccount, publicAccount_uin=");
            if (paramBundle2 == null) {
              break label748;
            }
          }
        }
        for (;;)
        {
          QLog.d("BuscardPluginRemoteCommand", 2, paramBundle2 + ";isFlow=" + bool2);
          localBundle.putBoolean("isFollowed", bool2);
          break;
          localObject1 = "null";
          break label513;
          localObject1 = "null";
          break label619;
          bool2 = false;
          break label642;
          paramBundle2 = "null";
        }
        paramBundle1 = "null";
        break label179;
      }
    }
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static void a()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if ((localPluginCommunicationHandler != null) && (!localPluginCommunicationHandler.containsCmd("com.tencent.nfc.buscard.remotecommand"))) {
      localPluginCommunicationHandler.register(new bggc("com.tencent.nfc.buscard.remotecommand", true));
    }
    if ((localPluginCommunicationHandler != null) && (!localPluginCommunicationHandler.containsCmd("com.tencent.nfc.buscard.remotecommand.async"))) {
      localPluginCommunicationHandler.register(new bggc("com.tencent.nfc.buscard.remotecommand.async", false));
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("ipc_async_req_seq", paramBundle.getLong("ipc_async_req_seq"));
    try
    {
      if ((!this.a) && (Thread.currentThread() != Looper.getMainLooper().getThread()))
      {
        new Handler(Looper.getMainLooper()).post(new BuscardPluginRemoteCommand.1(this, paramBundle, localBundle, paramOnInvokeFinishLinstener));
        return localBundle;
      }
      paramOnInvokeFinishLinstener = a(paramBundle, localBundle, paramOnInvokeFinishLinstener);
      return paramOnInvokeFinishLinstener;
    }
    catch (Exception paramOnInvokeFinishLinstener)
    {
      if (!QLog.isColorLevel()) {
        break label128;
      }
    }
    paramOnInvokeFinishLinstener = new StringBuilder().append("params=");
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.toString();; paramBundle = "null")
    {
      QLog.d("BuscardPluginRemoteCommand", 2, paramBundle);
      label128:
      return localBundle;
    }
  }
  
  public boolean isSynchronized()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bggc
 * JD-Core Version:    0.7.0.1
 */