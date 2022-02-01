package com.tencent.av.ui.guide;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DataReport.ShortCut_For_Effect;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class GuideHelper
{
  private static long jdField_a_of_type_Long = -1L;
  static String jdField_a_of_type_JavaLangString = "qav_guide_gesture/data.json";
  private static long jdField_b_of_type_Long = -1L;
  static String jdField_b_of_type_JavaLangString = "qav_guide_gesture/images/";
  private final int jdField_a_of_type_Int = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  GuideHelper.DelayTryShowRunnable jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable;
  GuideHelper.ViewInfo jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo = new GuideHelper.ViewInfo();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean = false;
  
  private int a(long paramLong, Context paramContext)
  {
    boolean bool1 = a(paramLong, paramContext);
    boolean bool2 = a(paramContext);
    if ((!bool1) && (!bool2)) {
      return 2;
    }
    if (!bool1) {
      return 0;
    }
    if (!bool2) {
      return 1;
    }
    return -1;
  }
  
  static long a(Context paramContext)
  {
    if (jdField_a_of_type_Long == -1L) {
      jdField_a_of_type_Long = SharedPreUtils.a(paramContext).getLong("qav_UserGuide_gesture_had_show", 0L);
    }
    return jdField_a_of_type_Long;
  }
  
  private void a(long paramLong, Context paramContext, int paramInt)
  {
    int j = a(paramLong, paramContext);
    if ((j != -1) && ((paramInt == 2) || ((j != 2) && (paramInt == j)) || (j == 2))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (AudioHelper.a())
      {
        paramContext = new StringBuilder();
        paramContext.append("tryShow, checkCondition false, had_show[");
        paramContext.append(jdField_a_of_type_Long);
        paramContext.append("], seq[");
        paramContext.append(paramLong);
        paramContext.append("]canShowTarget[");
        paramContext.append(j);
        paramContext.append("]");
        QLog.w("GuideHelper", 1, paramContext.toString());
      }
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      paramContext = new StringBuilder();
      paramContext.append("tryShow, mIsDestroyed[");
      paramContext.append(this.jdField_b_of_type_Boolean);
      paramContext.append("], seq[");
      paramContext.append(paramLong);
      paramContext.append("]");
      QLog.w("GuideHelper", 1, paramContext.toString());
      return;
    }
    int i = paramInt;
    if (paramInt == 2) {
      if (j == 2) {
        i = 0;
      } else {
        i = j;
      }
    }
    if (!a(paramLong, paramContext, i))
    {
      paramContext = new StringBuilder();
      paramContext.append("tryShow, initTipsView false, had_show[");
      paramContext.append(jdField_a_of_type_Long);
      paramContext.append("], seq[");
      paramContext.append(paramLong);
      paramContext.append("]");
      QLog.w("GuideHelper", 1, paramContext.toString());
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) && (i == 0))
    {
      paramContext = new StringBuilder();
      paramContext.append("tryShow, loadedLottieDrawable, seq[");
      paramContext.append(paramLong);
      paramContext.append("]");
      QLog.w("GuideHelper", 1, paramContext.toString());
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("GuideHelper", 1, "not support show double times guider under one-time talk");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.a(true);
    DataReport.ShortCut_For_Effect.a();
    ThreadManager.a().postDelayed(new GuideHelper.3(this, paramLong), 5000L);
    if (i == 0)
    {
      a(paramContext, paramLong);
      return;
    }
    b(paramContext, paramLong);
  }
  
  static void a(Context paramContext, long paramLong)
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    paramContext = SharedPreUtils.a(paramContext).edit();
    paramContext.putLong("qav_UserGuide_gesture_had_show", jdField_a_of_type_Long);
    paramContext.apply();
    paramContext = new StringBuilder();
    paramContext.append("qav_UserGuide_gesture, save, time[");
    paramContext.append(jdField_a_of_type_Long);
    paramContext.append("], seq[");
    paramContext.append(paramLong);
    paramContext.append("]");
    QLog.w("AVActivity", 1, paramContext.toString());
  }
  
  private boolean a(long paramLong, Context paramContext)
  {
    long l = a(paramContext);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (l == 0L)
    {
      paramContext = (AVActivity)paramContext;
      SessionInfo localSessionInfo = VideoController.a().a();
      bool1 = bool2;
      if (localSessionInfo != null)
      {
        if (paramContext.a == null) {
          return true;
        }
        boolean bool3 = localSessionInfo.t();
        boolean bool4 = paramContext.a.i();
        boolean bool5 = paramContext.a.a().b(0);
        boolean bool6 = paramContext.a.d(paramLong);
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (bool4)
          {
            bool1 = bool2;
            if (bool5)
            {
              if (!bool6) {
                return true;
              }
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(long paramLong, Context paramContext, int paramInt)
  {
    if (!(paramContext instanceof AVActivity))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initTipsView, fail, context[");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("GuideHelper", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    Object localObject = (AVActivity)paramContext;
    int i;
    if (paramInt == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_AndroidViewView == null)
    {
      if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_AndroidViewViewStub == null)
      {
        this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)((AVActivity)localObject).findViewById(2131373396));
        if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_AndroidViewViewStub != null) {
          this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_AndroidViewViewStub.inflate();
        }
      }
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.b = ((AVActivity)localObject).findViewById(2131373557);
      GuideHelper.ViewInfo localViewInfo = this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo;
      localViewInfo.jdField_a_of_type_AndroidViewView = localViewInfo.b.findViewById(2131373622);
    }
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.b.setOnTouchListener(new GuideHelper.1(this, paramLong));
    if (i != 0)
    {
      if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
        new GuideHelper.LottieDrawableHelper().a(paramLong, paramContext, jdField_a_of_type_JavaLangString, new GuideHelper.2(this, paramLong, paramContext, paramInt));
      }
    }
    else
    {
      paramContext = this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramContext.width = -2;
      paramContext.height = -2;
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(((AVActivity)localObject).getResources().getDrawable(2130842133));
    }
    if ((localObject != null) && (((AVActivity)localObject).a != null)) {
      return ((AVActivity)localObject).a.a() != null;
    }
    return false;
  }
  
  private boolean a(Context paramContext)
  {
    boolean bool1;
    if (b(paramContext) != 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (!bool1)
    {
      paramContext = (AVActivity)paramContext;
      SessionInfo localSessionInfo = VideoController.a().a();
      if (localSessionInfo != null)
      {
        if (paramContext.a == null) {
          return true;
        }
        bool1 = localSessionInfo.d();
        boolean bool2 = paramContext.a.i();
        boolean bool3 = paramContext.a.a().b(0);
        return (!bool2) || (!bool3) || (!(bool1 ^ true));
      }
      return true;
    }
    return bool1;
  }
  
  private static long b(Context paramContext)
  {
    if (jdField_b_of_type_Long == -1L) {
      jdField_b_of_type_Long = SharedPreUtils.a(paramContext).getLong("qav_UserGuide_textchat_had_show2", 0L);
    }
    return jdField_b_of_type_Long;
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.a(false);
  }
  
  private static void b(Context paramContext, long paramLong)
  {
    jdField_b_of_type_Long = System.currentTimeMillis();
    paramContext = SharedPreUtils.a(paramContext).edit();
    paramContext.putLong("qav_UserGuide_textchat_had_show2", jdField_b_of_type_Long);
    paramContext.apply();
    paramContext = new StringBuilder();
    paramContext.append("qav_UserGuide_gesture, save, time[");
    paramContext.append(jdField_a_of_type_Long);
    paramContext.append("], seq[");
    paramContext.append(paramLong);
    paramContext.append("]");
    QLog.w("AVActivity", 1, paramContext.toString());
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    a(-1L, this.jdField_a_of_type_AndroidContentContext, 1);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
    if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.recycleBitmaps();
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.clearComposition();
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setImageAssetDelegate(null);
    }
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$ViewInfo.a();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(long paramLong, Context paramContext, int paramInt1, int paramInt2)
  {
    GuideHelper.DelayTryShowRunnable localDelayTryShowRunnable;
    if (4 == paramInt1)
    {
      if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable == null) {
        this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable = new GuideHelper.DelayTryShowRunnable();
      }
      localDelayTryShowRunnable = this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable;
      localDelayTryShowRunnable.jdField_a_of_type_Int = paramInt2;
      localDelayTryShowRunnable.a(paramLong, paramContext, this, 2000L);
    }
    else if (3 == paramInt1)
    {
      localDelayTryShowRunnable = this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable;
      if (localDelayTryShowRunnable != null) {
        localDelayTryShowRunnable.a(paramLong);
      }
      b(paramLong);
    }
    if (paramInt1 == 0)
    {
      b(paramLong);
      return;
    }
    if (99 == paramInt1) {
      a(paramLong, paramContext, paramInt2);
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public boolean a(int paramInt)
  {
    return a(this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper
 * JD-Core Version:    0.7.0.1
 */