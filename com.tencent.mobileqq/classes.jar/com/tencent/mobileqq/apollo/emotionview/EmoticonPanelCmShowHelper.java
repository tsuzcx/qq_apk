package com.tencent.mobileqq.apollo.emotionview;

import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter;
import com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionPanelBuilderImpl;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloCmEmojiReportHelper;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class EmoticonPanelCmShowHelper
  extends AbsEmoticonPanelLifecycleObserver
  implements IEmoticonPanelCmShowHelper
{
  private static String c = "2";
  private static int d;
  private long a;
  private int b = -1;
  
  public EmoticonPanelCmShowHelper(int paramInt)
  {
    super(paramInt);
  }
  
  public static String a()
  {
    return c;
  }
  
  public static void a(int paramInt)
  {
    d = paramInt;
  }
  
  public static void a(String paramString)
  {
    c = paramString;
  }
  
  private boolean a(List<EmotionPanelInfo> paramList)
  {
    if (paramList == null) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)paramList.next();
      if ((localEmotionPanelInfo != null) && (localEmotionPanelInfo.type == 15)) {
        return true;
      }
    }
    return false;
  }
  
  public static int b()
  {
    return d;
  }
  
  private CmShowEmotionAdapter c()
  {
    if (this.mPanelController == null) {
      return null;
    }
    Object localObject = this.mPanelController.getEmotionInjectionInfo(15);
    if (localObject == null) {
      return null;
    }
    localObject = ((EmotionInjectionInfo)localObject).emotionPanelBuilder;
    if (!(localObject instanceof CmShowEmotionPanelBuilderImpl)) {
      return null;
    }
    return ((CmShowEmotionPanelBuilderImpl)localObject).getAdapter();
  }
  
  private void d()
  {
    if (this.b != 1)
    {
      ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("aio", "emojicmtab", "bigexpose", new DtReportParamsBuilder().k(a()).b(Integer.valueOf(b())).a());
      this.b = 1;
    }
  }
  
  private void e()
  {
    if (this.b != 0)
    {
      ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("aio", "emojicmtab", "smallexpose", new DtReportParamsBuilder().k(a()).b(Integer.valueOf(b())).a());
      this.b = 0;
    }
  }
  
  public String getTag()
  {
    return "[cmshow]EmoticonPanelCmShowHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 5, 3, 4, 11, 12, 8 };
  }
  
  public void onDestory()
  {
    IApolloCmEmojiReportHelper localIApolloCmEmojiReportHelper = (IApolloCmEmojiReportHelper)QRoute.api(IApolloCmEmojiReportHelper.class);
    if ((localIApolloCmEmojiReportHelper.needReport()) && (this.mPanelController.getAIOContext() != null)) {
      localIApolloCmEmojiReportHelper.report(MobileQQ.sMobileQQ.waitAppRuntime(null), this.mPanelController.getAIOContext().O().a, this.mPanelController.getAIOContext().O().b);
    }
  }
  
  public void onHide(boolean paramBoolean)
  {
    this.b = -1;
    this.a = 0L;
    c = "2";
    CmShowEmotionAdapter localCmShowEmotionAdapter = c();
    if (localCmShowEmotionAdapter != null) {
      localCmShowEmotionAdapter.b();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    try
    {
      if (this.mPanelController != null)
      {
        Object localObject = this.mPanelController.getEmotionInjectionInfo(15);
        if ((localObject != null) && ((((EmotionInjectionInfo)localObject).emotionTabListener instanceof EmoticonTabCmshowListener))) {
          ((EmoticonTabCmshowListener)((EmotionInjectionInfo)localObject).emotionTabListener).a(paramInt);
        }
        localObject = c();
        if (this.mPanelController.isEmoticonOnShow(15))
        {
          if (this.mPanelController.isPanelOpen()) {
            d();
          } else {
            e();
          }
          if (localObject != null) {
            ((CmShowEmotionAdapter)localObject).a(true);
          }
        }
        else
        {
          this.b = -1;
          if (localObject != null)
          {
            ((CmShowEmotionAdapter)localObject).a(false);
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]EmoticonPanelCmShowHelper", 1, "onPageSelected error", localThrowable);
    }
  }
  
  public void onPullDown()
  {
    try
    {
      if ((this.mPanelController != null) && (this.mPanelController.isEmoticonOnShow(15)))
      {
        e();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]EmoticonPanelCmShowHelper", 1, "onPullDown error", localThrowable);
    }
  }
  
  public void onPullUp()
  {
    try
    {
      if ((this.mPanelController != null) && (this.mPanelController.isEmoticonOnShow(15)))
      {
        d();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]EmoticonPanelCmShowHelper", 1, "onPullUp error", localThrowable);
    }
  }
  
  public void onShow()
  {
    try
    {
      if (this.mPanelController != null)
      {
        if (a(this.mPanelController.getPanelDataList()))
        {
          long l = SystemClock.elapsedRealtime();
          if (l - this.a > 2000L)
          {
            ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("aio", "emojicmtab", "expose", new DtReportParamsBuilder().k(a()).b(Integer.valueOf(b())).a());
            this.a = l;
          }
        }
        Object localObject = this.mPanelController.getEmotionInjectionInfo(15);
        if ((localObject != null) && ((((EmotionInjectionInfo)localObject).emotionTabListener instanceof EmoticonTabCmshowListener))) {
          ((EmoticonTabCmshowListener)((EmotionInjectionInfo)localObject).emotionTabListener).a();
        }
        if (this.mPanelController.isEmoticonOnShow(15)) {
          if (this.mPanelController.isPanelOpen()) {
            d();
          } else {
            e();
          }
        }
        localObject = c();
        if (localObject != null)
        {
          ((CmShowEmotionAdapter)localObject).a();
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]EmoticonPanelCmShowHelper", 1, "onShow error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.EmoticonPanelCmShowHelper
 * JD-Core Version:    0.7.0.1
 */