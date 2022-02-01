package com.tencent.gamecenter.wadl.biz.service;

import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class WadlJsBridgeService
  extends AppService
  implements Handler.Callback
{
  private static String a = "WadlJsBridgeService";
  private String b = "WadlJsBridgeService.Thread";
  private Looper c;
  private Handler d;
  
  public WadlJsBridgeService()
  {
    QLog.i(a, 1, "WadlJsBridgeService new instance");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    String str1 = (String)paramMessage.obj;
    String str2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage what=");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append(",");
    localStringBuilder.append(paramMessage.obj);
    QLog.i(str2, 1, localStringBuilder.toString());
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 6)
          {
            if (i == 7) {
              WadlProxyServiceUtil.a().b(str1);
            }
          }
          else {
            WadlProxyServiceUtil.a().c(str1);
          }
        }
        else
        {
          WadlProxyServiceUtil.a().a(4, str1);
          return false;
        }
      }
      else {
        WadlProxyServiceUtil.a().b(4, str1);
      }
      stopSelf(paramMessage.arg1);
      return false;
    }
    paramMessage = new WadlParams(str1, "");
    paramMessage.h = 4;
    paramMessage.A = "biz_src_zf_games";
    WadlProxyServiceUtil.a().c(paramMessage);
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    QLog.i(a, 1, "onCreate...");
    HandlerThread localHandlerThread = new HandlerThread(this.b, 10);
    localHandlerThread.start();
    this.c = localHandlerThread.getLooper();
    this.d = new Handler(this.c, this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i(a, 1, "Service is Destroyed");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStartCommand flags=,");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",startId=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",intent=");
    localStringBuilder.append(paramIntent);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("ACTIONNAME", 0);
      paramIntent = paramIntent.getStringExtra("id");
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartCommand action= ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",id=");
      localStringBuilder.append(paramIntent);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      localObject = this.d.obtainMessage();
      ((Message)localObject).what = paramInt1;
      ((Message)localObject).obj = paramIntent;
      this.d.sendMessage((Message)localObject);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.service.WadlJsBridgeService
 * JD-Core Version:    0.7.0.1
 */