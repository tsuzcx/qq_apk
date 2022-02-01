package com.tencent.biz.qqstory.newshare.mode.base;

import android.app.Activity;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.callback.OnPrepareShareListener;
import com.tencent.biz.qqstory.newshare.job.DownloadPic2FileJob;
import com.tencent.biz.qqstory.newshare.model.JobExecutor;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.OnJobExecuteResultCallback;
import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.newshare.model.ShareQZoneData;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public abstract class ShareModeBase
{
  public static Map<String, String> t = new ConcurrentHashMap();
  private int a = 0;
  public OnPrepareShareListener q;
  public JobExecutor r = new JobExecutor();
  public WeakReference<Activity> s;
  public Map<String, String> u = new ConcurrentHashMap();
  
  public static String a(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    String str1 = "?";
    if (paramString.contains("?")) {
      if ((!paramString.endsWith("?")) && (!paramString.endsWith("&"))) {
        str1 = "&";
      } else {
        str1 = "";
      }
    }
    int i = 1;
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        Object localObject2 = (String)paramMap.get(str2);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (i != 0) {
          localStringBuilder.append(str1);
        } else {
          localStringBuilder.append("&");
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append("=");
        ((StringBuilder)localObject2).append(URLEncoder.encode((String)localObject1, "utf-8"));
        localStringBuilder.append(((StringBuilder)localObject2).toString());
        i = 0;
      }
      paramMap = localStringBuilder.toString();
      return paramMap;
    }
    catch (UnsupportedEncodingException paramMap)
    {
      SLog.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
    }
    return paramString;
  }
  
  private void d(int paramInt)
  {
    SLog.b("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      localObject = new ShareData();
      ((ShareData)localObject).c = paramInt;
      new JobExecutor.OnJobExecuteResultCallback(this, (ShareData)localObject).a();
      return;
    case 6: 
      localObject = new ShareCopyLinkData();
      ((ShareCopyLinkData)localObject).c = paramInt;
      a_((ShareData)localObject);
      a((ShareCopyLinkData)localObject);
      b((ShareData)localObject);
      b((ShareCopyLinkData)localObject);
      return;
    case 5: 
      localObject = new ShareSinaData();
      ((ShareSinaData)localObject).c = paramInt;
      a_((ShareData)localObject);
      a((ShareSinaData)localObject);
      b((ShareData)localObject);
      b((ShareSinaData)localObject);
      return;
    case 4: 
      localObject = new ShareWeChatData();
      ((ShareWeChatData)localObject).c = paramInt;
      ((ShareWeChatData)localObject).j = true;
      a_((ShareData)localObject);
      b((ShareWeChatData)localObject);
      b((ShareData)localObject);
      c((ShareWeChatData)localObject);
      return;
    case 3: 
      localObject = new ShareWeChatData();
      ((ShareWeChatData)localObject).c = paramInt;
      a_((ShareData)localObject);
      a((ShareWeChatData)localObject);
      b((ShareData)localObject);
      c((ShareWeChatData)localObject);
      return;
    case 2: 
      localObject = new ShareQZoneData();
      ((ShareQZoneData)localObject).c = paramInt;
      a_((ShareData)localObject);
      a((ShareQZoneData)localObject);
      b((ShareData)localObject);
      b((ShareQZoneData)localObject);
      return;
    }
    Object localObject = new ShareQQData();
    ((ShareQQData)localObject).c = paramInt;
    a_((ShareData)localObject);
    a((ShareQQData)localObject);
    b((ShareData)localObject);
    b((ShareQQData)localObject);
  }
  
  protected abstract String a(int paramInt);
  
  protected String a(String paramString, ShareData paramShareData)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(t);
    if (paramShareData != null) {
      localHashMap.putAll(paramShareData.d);
    }
    localHashMap.putAll(this.u);
    return a(paramString, localHashMap);
  }
  
  protected void a()
  {
    a(true);
  }
  
  public void a(@NonNull Activity paramActivity)
  {
    AssertUtils.checkNotNull(paramActivity);
    this.s = new WeakReference(paramActivity);
  }
  
  public void a(ShareCopyLinkData paramShareCopyLinkData) {}
  
  public void a(ShareQQData paramShareQQData) {}
  
  public void a(ShareQZoneData paramShareQZoneData) {}
  
  public void a(ShareSinaData paramShareSinaData) {}
  
  public void a(ShareWeChatData paramShareWeChatData)
  {
    paramShareWeChatData.j = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.r.a(new ShareModeBase.16(this));
      return;
    }
    ShareData localShareData = new ShareData();
    localShareData.c = this.a;
    d(localShareData);
  }
  
  protected void a_(ShareData paramShareData) {}
  
  protected String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 6: 
      return "copy_link";
    case 5: 
      return "weibo";
    case 3: 
    case 4: 
      return "wechat";
    case 2: 
      return "qzone";
    }
    return "qq";
  }
  
  protected void b(ShareCopyLinkData paramShareCopyLinkData)
  {
    String str = paramShareCopyLinkData.a;
    this.r.a(new ShareModeBase.11(this, str, null, false, paramShareCopyLinkData)).a(new ShareModeBase.10(this, paramShareCopyLinkData)).a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareCopyLinkData));
  }
  
  protected final void b(ShareData paramShareData)
  {
    SLog.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramShareData);
    Object localObject;
    if ((paramShareData instanceof ShareWeChatData))
    {
      localObject = (ShareWeChatData)paramShareData;
      ((ShareWeChatData)localObject).h = a(((ShareWeChatData)localObject).h, paramShareData);
      return;
    }
    if ((paramShareData instanceof ShareCopyLinkData))
    {
      localObject = (ShareCopyLinkData)paramShareData;
      ((ShareCopyLinkData)localObject).a = a(((ShareCopyLinkData)localObject).a, paramShareData);
      return;
    }
    if ((paramShareData instanceof ShareSinaData))
    {
      localObject = (ShareSinaData)paramShareData;
      ((ShareSinaData)localObject).f = a(((ShareSinaData)localObject).f, paramShareData);
      return;
    }
    if ((paramShareData instanceof ShareQZoneData))
    {
      localObject = (ShareQZoneData)paramShareData;
      ((ShareQZoneData)localObject).h = a(((ShareQZoneData)localObject).h, paramShareData);
      return;
    }
    if ((paramShareData instanceof ShareQQData))
    {
      localObject = (ShareQQData)paramShareData;
      ((ShareQQData)localObject).m = a(((ShareQQData)localObject).m, paramShareData);
    }
  }
  
  protected void b(ShareQQData paramShareQQData)
  {
    if ((paramShareQQData.e != null) && (paramShareQQData.e.isPollVideo())) {
      this.r.a(new ShareModeBase.1(this, paramShareQQData.e, paramShareQQData));
    }
    String str = paramShareQQData.m;
    this.r.a(new ShareModeBase.2(this, str, null, true, paramShareQQData)).a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareQQData));
  }
  
  protected void b(ShareQZoneData paramShareQZoneData)
  {
    String str = paramShareQZoneData.h;
    this.r.a(new ShareModeBase.7(this, str, null, false, paramShareQZoneData));
    if ((paramShareQZoneData.e != null) && (paramShareQZoneData.e.isPollVideo())) {
      this.r.a(new ShareModeBase.9(this, paramShareQZoneData.e)).a(new ShareModeBase.8(this, paramShareQZoneData));
    }
    this.r.a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareQZoneData));
  }
  
  protected void b(ShareSinaData paramShareSinaData)
  {
    String str = paramShareSinaData.f;
    this.r.a(new ShareModeBase.12(this, str, null, false, paramShareSinaData));
    if ((paramShareSinaData.e != null) && (paramShareSinaData.e.isPollVideo())) {
      this.r.a(new ShareModeBase.15(this, paramShareSinaData.e, paramShareSinaData)).a(new ShareModeBase.14(this, paramShareSinaData)).a(new ShareModeBase.13(this, paramShareSinaData));
    } else {
      this.r.a(new DownloadPic2FileJob(paramShareSinaData.h, paramShareSinaData.g, paramShareSinaData.i));
    }
    this.r.a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareSinaData));
  }
  
  public void b(ShareWeChatData paramShareWeChatData)
  {
    paramShareWeChatData.j = true;
  }
  
  public final void c(int paramInt)
  {
    this.a = paramInt;
    a();
  }
  
  public void c(ShareData paramShareData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    if (this.q != null)
    {
      ShareData localShareData = paramShareData;
      if (paramShareData == null)
      {
        localShareData = new ShareData();
        localShareData.c = this.a;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        this.q.a(localShareData);
        return;
      }
      ThreadManager.getUIHandler().post(new ShareModeBase.17(this, localShareData));
    }
  }
  
  protected void c(ShareWeChatData paramShareWeChatData)
  {
    String str = paramShareWeChatData.h;
    SLog.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.r.a(new ShareModeBase.3(this, str, null, false, paramShareWeChatData));
    if ((paramShareWeChatData.e != null) && (paramShareWeChatData.e.isPollVideo())) {
      this.r.a(new ShareModeBase.4(this, paramShareWeChatData.e, paramShareWeChatData));
    }
    this.r.a(new ShareModeBase.6(this, paramShareWeChatData.i)).a(new ShareModeBase.5(this, paramShareWeChatData.k, paramShareWeChatData.l, paramShareWeChatData)).a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareWeChatData));
  }
  
  public void d(ShareData paramShareData)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    if (this.q != null)
    {
      ShareData localShareData = paramShareData;
      if (paramShareData == null)
      {
        localShareData = new ShareData();
        localShareData.c = this.a;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        this.q.b(localShareData);
        return;
      }
      ThreadManager.getUIHandler().post(new ShareModeBase.18(this, localShareData));
    }
  }
  
  public void e(ShareData paramShareData)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    if (this.q != null)
    {
      ShareData localShareData = paramShareData;
      if (paramShareData == null)
      {
        localShareData = new ShareData();
        localShareData.c = this.a;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        this.q.c(localShareData);
        return;
      }
      ThreadManager.getUIHandler().post(new ShareModeBase.19(this, localShareData));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase
 * JD-Core Version:    0.7.0.1
 */