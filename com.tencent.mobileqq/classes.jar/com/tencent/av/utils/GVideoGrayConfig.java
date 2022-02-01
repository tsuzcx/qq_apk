package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GVideoHandler;
import com.tencent.mobileqq.app.GVideoObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import java.util.HashMap;
import java.util.Map;

public class GVideoGrayConfig
{
  private static GVideoGrayConfig b = new GVideoGrayConfig();
  public int a = -1;
  private Map<String, GVideoGrayConfig.Record> c = new HashMap();
  private GVideoGrayConfig.GVideoPreDownloadListener d;
  private long e;
  private LongSparseArray<GVideoGrayConfig.GVideoGrayConfigListener> f = new LongSparseArray();
  private GVideoObserver g = new GVideoGrayConfig.1(this);
  
  public static GVideoGrayConfig a()
  {
    return b;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131893370, 2131893372, new GVideoGrayConfig.2(paramContext), paramOnClickListener).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("GroupId");
    a().a(paramQQAppInterface, str, new GVideoGrayConfig.3(paramQQAppInterface, paramContext, paramIntent, str));
  }
  
  private static void b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AboutActivity.class);
    if ((paramContext instanceof Activity))
    {
      if (!((Activity)paramContext).isFinishing()) {}
    }
    else {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, GVideoGrayConfig.GVideoGrayConfigListener paramGVideoGrayConfigListener)
  {
    Object localObject = (GVideoGrayConfig.Record)this.c.get(paramString);
    if ((localObject != null) && (SystemClock.elapsedRealtime() - ((GVideoGrayConfig.Record)localObject).a < 60000L))
    {
      paramGVideoGrayConfigListener.a(((GVideoGrayConfig.Record)localObject).b, (GVideoGrayConfig.Record)localObject, 1000);
      return;
    }
    localObject = (GVideoHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
    if (localObject != null)
    {
      paramAppInterface.addObserver(this.g);
      long l = ((GVideoHandler)localObject).a(TroopMemberUtil.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
      this.f.b(l, paramGVideoGrayConfigListener);
      return;
    }
    paramGVideoGrayConfigListener.a(-1, null, -1);
    if (QLog.isColorLevel()) {
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "requestGVideoGrayConfig troopHandler is null!!");
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString, GVideoGrayConfig.GVideoPreDownloadListener paramGVideoPreDownloadListener)
  {
    this.d = paramGVideoPreDownloadListener;
    if ((this.a != -1) && (SystemClock.elapsedRealtime() - this.e < 7200000L))
    {
      paramGVideoPreDownloadListener.a(this.a);
      return;
    }
    paramGVideoPreDownloadListener = (GVideoHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
    if (paramGVideoPreDownloadListener != null)
    {
      paramAppInterface.addObserver(this.g);
      paramGVideoPreDownloadListener.a(TroopMemberUtil.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
    }
  }
  
  public void b()
  {
    this.d = null;
  }
  
  public void c()
  {
    this.d = null;
    this.f.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.GVideoGrayConfig
 * JD-Core Version:    0.7.0.1
 */