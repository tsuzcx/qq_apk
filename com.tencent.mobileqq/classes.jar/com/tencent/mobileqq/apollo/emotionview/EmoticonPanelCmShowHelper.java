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
  private static String jdField_a_of_type_JavaLangString = "2";
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  
  public EmoticonPanelCmShowHelper(int paramInt)
  {
    super(paramInt);
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Int != 1)
    {
      ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("aio", "emojicmtab", "bigexpose", new DtReportParamsBuilder().h(a()).a());
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
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
  
  private void b()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("aio", "emojicmtab", "smallexpose", new DtReportParamsBuilder().h(a()).a());
      this.jdField_a_of_type_Int = 0;
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
      localIApolloCmEmojiReportHelper.report(MobileQQ.sMobileQQ.waitAppRuntime(null), this.mPanelController.getAIOContext().a().jdField_a_of_type_Int, this.mPanelController.getAIOContext().a().jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onHide(boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaLangString = "2";
  }
  
  public void onPageSelected(int paramInt)
  {
    try
    {
      if (this.mPanelController != null)
      {
        EmotionInjectionInfo localEmotionInjectionInfo = this.mPanelController.getEmotionInjectionInfo(15);
        if ((localEmotionInjectionInfo != null) && ((localEmotionInjectionInfo.emotionTabListener instanceof EmoticonTabCmshowListener))) {
          ((EmoticonTabCmshowListener)localEmotionInjectionInfo.emotionTabListener).a(paramInt);
        }
        if (this.mPanelController.isEmoticonOnShow(15))
        {
          if (this.mPanelController.isPanelOpen())
          {
            a();
            return;
          }
          b();
          return;
        }
        this.jdField_a_of_type_Int = -1;
        return;
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
        b();
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
        a();
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
          if (l - this.jdField_a_of_type_Long > 2000L)
          {
            ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("aio", "emojicmtab", "expose", new DtReportParamsBuilder().h(a()).a());
            this.jdField_a_of_type_Long = l;
          }
        }
        Object localObject = this.mPanelController.getEmotionInjectionInfo(15);
        if ((localObject != null) && ((((EmotionInjectionInfo)localObject).emotionTabListener instanceof EmoticonTabCmshowListener))) {
          ((EmoticonTabCmshowListener)((EmotionInjectionInfo)localObject).emotionTabListener).a();
        }
        if (this.mPanelController.isEmoticonOnShow(15)) {
          if (this.mPanelController.isPanelOpen()) {
            a();
          } else {
            b();
          }
        }
        if (localObject != null)
        {
          localObject = ((EmotionInjectionInfo)localObject).emotionPanelBuilder;
          if ((localObject instanceof CmShowEmotionPanelBuilderImpl))
          {
            localObject = ((CmShowEmotionPanelBuilderImpl)localObject).getAdapter();
            if (localObject != null)
            {
              ((CmShowEmotionAdapter)localObject).a();
              return;
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]EmoticonPanelCmShowHelper", 1, "onShow error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.EmoticonPanelCmShowHelper
 * JD-Core Version:    0.7.0.1
 */