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
  public static Map<String, String> a;
  private int a;
  public OnPrepareShareListener a;
  public JobExecutor a;
  public WeakReference<Activity> a;
  public Map<String, String> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public ShareModeBase()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor = new JobExecutor();
    this.jdField_a_of_type_Int = 0;
  }
  
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
  
  private void b(int paramInt)
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
      ((ShareData)localObject).jdField_a_of_type_Int = paramInt;
      new JobExecutor.OnJobExecuteResultCallback(this, (ShareData)localObject).a();
      return;
    case 6: 
      localObject = new ShareCopyLinkData();
      ((ShareCopyLinkData)localObject).jdField_a_of_type_Int = paramInt;
      a_((ShareData)localObject);
      a((ShareCopyLinkData)localObject);
      b((ShareData)localObject);
      b((ShareCopyLinkData)localObject);
      return;
    case 5: 
      localObject = new ShareSinaData();
      ((ShareSinaData)localObject).jdField_a_of_type_Int = paramInt;
      a_((ShareData)localObject);
      a((ShareSinaData)localObject);
      b((ShareData)localObject);
      b((ShareSinaData)localObject);
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
    case 3: 
      localObject = new ShareWeChatData();
      ((ShareWeChatData)localObject).jdField_a_of_type_Int = paramInt;
      a_((ShareData)localObject);
      a((ShareWeChatData)localObject);
      b((ShareData)localObject);
      c((ShareWeChatData)localObject);
      return;
    case 2: 
      localObject = new ShareQZoneData();
      ((ShareQZoneData)localObject).jdField_a_of_type_Int = paramInt;
      a_((ShareData)localObject);
      a((ShareQZoneData)localObject);
      b((ShareData)localObject);
      b((ShareQZoneData)localObject);
      return;
    }
    Object localObject = new ShareQQData();
    ((ShareQQData)localObject).jdField_a_of_type_Int = paramInt;
    a_((ShareData)localObject);
    a((ShareQQData)localObject);
    b((ShareData)localObject);
    b((ShareQQData)localObject);
  }
  
  protected abstract String a(int paramInt);
  
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
  
  protected void a()
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
    AssertUtils.checkNotNull(paramActivity);
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
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareModeBase.16(this));
      return;
    }
    ShareData localShareData = new ShareData();
    localShareData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
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
    String str = paramShareCopyLinkData.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareModeBase.11(this, str, null, false, paramShareCopyLinkData)).a(new ShareModeBase.10(this, paramShareCopyLinkData)).a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareCopyLinkData));
  }
  
  protected final void b(ShareData paramShareData)
  {
    SLog.a("Q.qqstory.share.ShareModeBase", "prepareCommonShareData %s", paramShareData);
    Object localObject;
    if ((paramShareData instanceof ShareWeChatData))
    {
      localObject = (ShareWeChatData)paramShareData;
      ((ShareWeChatData)localObject).d = a(((ShareWeChatData)localObject).d, paramShareData);
      return;
    }
    if ((paramShareData instanceof ShareCopyLinkData))
    {
      localObject = (ShareCopyLinkData)paramShareData;
      ((ShareCopyLinkData)localObject).jdField_a_of_type_JavaLangString = a(((ShareCopyLinkData)localObject).jdField_a_of_type_JavaLangString, paramShareData);
      return;
    }
    if ((paramShareData instanceof ShareSinaData))
    {
      localObject = (ShareSinaData)paramShareData;
      ((ShareSinaData)localObject).c = a(((ShareSinaData)localObject).c, paramShareData);
      return;
    }
    if ((paramShareData instanceof ShareQZoneData))
    {
      localObject = (ShareQZoneData)paramShareData;
      ((ShareQZoneData)localObject).e = a(((ShareQZoneData)localObject).e, paramShareData);
      return;
    }
    if ((paramShareData instanceof ShareQQData))
    {
      localObject = (ShareQQData)paramShareData;
      ((ShareQQData)localObject).h = a(((ShareQQData)localObject).h, paramShareData);
    }
  }
  
  protected void b(ShareQQData paramShareQQData)
  {
    if ((paramShareQQData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareQQData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareModeBase.1(this, paramShareQQData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramShareQQData));
    }
    String str = paramShareQQData.h;
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareModeBase.2(this, str, null, true, paramShareQQData)).a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareQQData));
  }
  
  protected void b(ShareQZoneData paramShareQZoneData)
  {
    String str = paramShareQZoneData.e;
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareModeBase.7(this, str, null, false, paramShareQZoneData));
    if ((paramShareQZoneData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareQZoneData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareModeBase.9(this, paramShareQZoneData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem)).a(new ShareModeBase.8(this, paramShareQZoneData));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareQZoneData));
  }
  
  protected void b(ShareSinaData paramShareSinaData)
  {
    String str = paramShareSinaData.c;
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareModeBase.12(this, str, null, false, paramShareSinaData));
    if ((paramShareSinaData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareSinaData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareModeBase.15(this, paramShareSinaData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramShareSinaData)).a(new ShareModeBase.14(this, paramShareSinaData)).a(new ShareModeBase.13(this, paramShareSinaData));
    } else {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new DownloadPic2FileJob(paramShareSinaData.e, paramShareSinaData.d, paramShareSinaData.jdField_a_of_type_Boolean));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareSinaData));
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener != null)
    {
      ShareData localShareData = paramShareData;
      if (paramShareData == null)
      {
        localShareData = new ShareData();
        localShareData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener.a(localShareData);
        return;
      }
      ThreadManager.getUIHandler().post(new ShareModeBase.17(this, localShareData));
    }
  }
  
  protected void c(ShareWeChatData paramShareWeChatData)
  {
    String str = paramShareWeChatData.d;
    SLog.b("Q.qqstory.share.ShareModeBase", "handleShareToWeChatJob url: %s", str);
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareModeBase.3(this, str, null, false, paramShareWeChatData));
    if ((paramShareWeChatData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) && (paramShareWeChatData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isPollVideo())) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareModeBase.4(this, paramShareWeChatData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramShareWeChatData));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareModeBase.6(this, paramShareWeChatData.e)).a(new ShareModeBase.5(this, paramShareWeChatData.b, paramShareWeChatData.c, paramShareWeChatData)).a(new JobExecutor.OnJobExecuteResultCallback(this, paramShareWeChatData));
  }
  
  public void d(ShareData paramShareData)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.share.ShareModeBase", 2, "notifyError");
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener != null)
    {
      ShareData localShareData = paramShareData;
      if (paramShareData == null)
      {
        localShareData = new ShareData();
        localShareData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener.b(localShareData);
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener != null)
    {
      ShareData localShareData = paramShareData;
      if (paramShareData == null)
      {
        localShareData = new ShareData();
        localShareData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener.c(localShareData);
        return;
      }
      ThreadManager.getUIHandler().post(new ShareModeBase.19(this, localShareData));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase
 * JD-Core Version:    0.7.0.1
 */