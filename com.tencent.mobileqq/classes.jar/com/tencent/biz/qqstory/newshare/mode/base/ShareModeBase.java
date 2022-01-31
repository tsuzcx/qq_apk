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
import ngi;
import ngj;
import ngk;
import ngl;
import ngm;
import ngn;
import ngo;
import ngp;
import ngq;
import ngr;
import ngs;
import ngt;
import ngu;
import ngv;
import ngw;
import ngx;
import ngy;
import ngz;
import nha;
import nhb;
import nhc;
import nhd;
import nhe;
import nhf;
import nhg;
import nhh;

public abstract class ShareModeBase
{
  public static Map a;
  private int a;
  public OnPrepareShareListener a;
  public JobExecutor a;
  public WeakReference a;
  public Map b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public ShareModeBase()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor = new JobExecutor();
  }
  
  public static String a(String paramString, Map paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (!paramString.contains("?")) {}
    label37:
    label192:
    for (String str1 = "?";; str1 = "")
    {
      try
      {
        Iterator localIterator = paramMap.keySet().iterator();
        int i = 1;
        if (localIterator.hasNext())
        {
          String str4 = (String)localIterator.next();
          String str3 = (String)paramMap.get(str4);
          String str2 = str3;
          if (str3 == null) {
            str2 = "";
          }
          if (i != 0) {
            localStringBuilder.append(str1);
          }
          for (;;)
          {
            localStringBuilder.append(str4 + "=" + URLEncoder.encode(str2, "utf-8"));
            i = 0;
            break label37;
            if ((paramString.endsWith("?")) || (paramString.endsWith("&"))) {
              break label192;
            }
            str1 = "&";
            break;
            localStringBuilder.append("&");
          }
        }
        paramMap = localStringBuilder.toString();
      }
      catch (UnsupportedEncodingException paramMap)
      {
        SLog.e("Q.qqstory.share.ShareModeBase", paramMap.getMessage());
        return paramString;
      }
      return paramMap;
    }
  }
  
  private void b(int paramInt)
  {
    SLog.b("Q.qqstory.share.ShareModeBase", "handlePrepareShareData() action=%d", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      localObject = new ShareQQData();
      ((ShareQQData)localObject).jdField_a_of_type_Int = paramInt;
      a_((ShareData)localObject);
      a((ShareQQData)localObject);
      b((ShareData)localObject);
      b((ShareQQData)localObject);
      return;
    case 2: 
      localObject = new ShareQZoneData();
      ((ShareQZoneData)localObject).jdField_a_of_type_Int = paramInt;
      a_((ShareData)localObject);
      a((ShareQZoneData)localObject);
      b((ShareData)localObject);
      b((ShareQZoneData)localObject);
      return;
    case 3: 
      localObject = new ShareWeChatData();
      ((ShareWeChatData)localObject).jdField_a_of_type_Int = paramInt;
      a_((ShareData)localObject);
      a((ShareWeChatData)localObject);
      b((ShareData)localObject);
      c((ShareWeChatData)localObject);
      return;
    case 4: 
      localObject = new ShareWeChatData();
      ((ShareWeChatData)localObject).jdField_a_of_type_Int = paramInt;
      ((ShareWeChatData)localObject).jdField_a_of_type_Boolean = true;
      a_((ShareData)localObject);
      b((ShareWeChatData)localObject);
      b((ShareData)localObject);
      c((ShareWeChatData)localObject);
      return;
    case 5: 
      localObject = new ShareSinaData();
      ((ShareSinaData)localObject).jdField_a_of_type_Int = paramInt;
      a_((ShareData)localObject);
      a((ShareSinaData)localObject);
      b((ShareData)localObject);
      b((ShareSinaData)localObject);
      return;
    }
    Object localObject = new ShareCopyLinkData();
    ((ShareCopyLinkData)localObject).jdField_a_of_type_Int = paramInt;
    a_((ShareData)localObject);
    a((ShareCopyLinkData)localObject);
    b((ShareData)localObject);
    b((ShareCopyLinkData)localObject);
  }
  
  public abstract String a(int paramInt);
  
  protected String a(String paramString, ShareData paramShareData)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(jdField_a_of_type_JavaUtilMap);
    if (paramShareData != null) {
      localHashMap.putAll(paramShareData.jdField_a_of_type_JavaUtilMap);
    }
    localHashMap.putAll(this.b);
    return a(paramString, localHashMap);
  }
  
  public void a()
  {
    a(true);
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  public void a(@NonNull Activity paramActivity)
  {
    AssertUtils.a(paramActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(ShareCopyLinkData paramShareCopyLinkData) {}
  
  public void a(ShareQQData paramShareQQData) {}
  
  public void a(ShareQZoneData paramShareQZoneData) {}
  
  public void a(ShareSinaData paramShareSinaData) {}
  
  public void a(ShareWeChatData paramShareWeChatData)
  {
    paramShareWeChatData.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ngx(this));
      return;
    }
    ShareData localShareData = new ShareData();
    localShareData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    d(localShareData);
  }
  
  protected void a_(ShareData paramShareData) {}
  
  public String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "qq";
    case 2: 
      return "qzone";
    case 3: 
      return "wechat";
    case 4: 
      return "wechat";
    case 5: 
      return "weibo";
    }
    return "copy_link";
  }
  
  protected void b(ShareCopyLinkData paramShareCopyLinkData)
  {
    String str = paramShareCopyLinkData.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ngo(this, str, null, false, paramShareCopyLinkData)).a(new ngn(this, paramShareCopyLinkData)).a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareCopyLinkData));
  }
  
  protected final void b(ShareData paramShareData)
  {
    SLog.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramShareData);
    if ((paramShareData instanceof ShareWeChatData)) {
      ((ShareWeChatData)paramShareData).d = a(((ShareWeChatData)paramShareData).d, paramShareData);
    }
    do
    {
      return;
      if ((paramShareData instanceof ShareCopyLinkData))
      {
        ((ShareCopyLinkData)paramShareData).jdField_a_of_type_JavaLangString = a(((ShareCopyLinkData)paramShareData).jdField_a_of_type_JavaLangString, paramShareData);
        return;
      }
      if ((paramShareData instanceof ShareSinaData))
      {
        ((ShareSinaData)paramShareData).c = a(((ShareSinaData)paramShareData).c, paramShareData);
        return;
      }
      if ((paramShareData instanceof ShareQZoneData))
      {
        ((ShareQZoneData)paramShareData).e = a(((ShareQZoneData)paramShareData).e, paramShareData);
        return;
      }
    } while (!(paramShareData instanceof ShareQQData));
    ((ShareQQData)paramShareData).h = a(((ShareQQData)paramShareData).h, paramShareData);
  }
  
  protected void b(ShareQQData paramShareQQData)
  {
    if ((paramShareQQData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareQQData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ngi(this, paramShareQQData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramShareQQData));
    }
    for (;;)
    {
      String str = paramShareQQData.h;
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new nhb(this, str, null, true, paramShareQQData)).a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareQQData));
      return;
      if ((paramShareQQData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareQQData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ngt(this, paramShareQQData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramShareQQData));
      }
    }
  }
  
  protected void b(ShareQZoneData paramShareQZoneData)
  {
    String str = paramShareQZoneData.e;
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new nhh(this, str, null, false, paramShareQZoneData));
    if ((paramShareQZoneData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareQZoneData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ngk(this, paramShareQZoneData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new ngj(this, paramShareQZoneData));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareQZoneData));
      return;
      if ((paramShareQZoneData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareQZoneData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ngm(this, paramShareQZoneData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new ngl(this, paramShareQZoneData));
      }
    }
  }
  
  protected void b(ShareSinaData paramShareSinaData)
  {
    String str = paramShareSinaData.c;
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ngp(this, str, null, false, paramShareSinaData));
    if ((paramShareSinaData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareSinaData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ngs(this, paramShareSinaData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramShareSinaData)).a(new ngr(this, paramShareSinaData)).a(new ngq(this, paramShareSinaData));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareSinaData));
      return;
      if ((paramShareSinaData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareSinaData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ngw(this, paramShareSinaData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramShareSinaData)).a(new ngv(this, paramShareSinaData)).a(new ngu(this, paramShareSinaData));
      } else {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new DownloadPic2FileJob(paramShareSinaData.e, paramShareSinaData.d, paramShareSinaData.jdField_a_of_type_Boolean));
      }
    }
  }
  
  public void b(ShareWeChatData paramShareWeChatData)
  {
    paramShareWeChatData.jdField_a_of_type_Boolean = true;
  }
  
  public void c(ShareData paramShareData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.share.ShareModeBase", 2, "notifyResult");
    }
    ShareData localShareData;
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener != null)
    {
      localShareData = paramShareData;
      if (paramShareData == null)
      {
        localShareData = new ShareData();
        localShareData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener.a(localShareData);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ngy(this, localShareData));
  }
  
  protected void c(ShareWeChatData paramShareWeChatData)
  {
    String str = paramShareWeChatData.d;
    SLog.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new nhc(this, str, null, false, paramShareWeChatData));
    if ((paramShareWeChatData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareWeChatData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new nhd(this, paramShareWeChatData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramShareWeChatData));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new nhg(this, paramShareWeChatData.e)).a(new nhf(this, paramShareWeChatData.b, paramShareWeChatData.c, paramShareWeChatData)).a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareWeChatData));
      return;
      if ((paramShareWeChatData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareWeChatData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isInteractVideo())) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new nhe(this, paramShareWeChatData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramShareWeChatData));
      }
    }
  }
  
  public void d(ShareData paramShareData)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    ShareData localShareData;
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener != null)
    {
      localShareData = paramShareData;
      if (paramShareData == null)
      {
        localShareData = new ShareData();
        localShareData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener.b(localShareData);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ngz(this, localShareData));
  }
  
  public void e(ShareData paramShareData)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyCancel");
    }
    ShareData localShareData;
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener != null)
    {
      localShareData = paramShareData;
      if (paramShareData == null)
      {
        localShareData = new ShareData();
        localShareData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener.c(localShareData);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new nha(this, localShareData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase
 * JD-Core Version:    0.7.0.1
 */