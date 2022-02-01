package com.tencent.av.ui.guide;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import bhhr;
import bjum;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lfe;
import mpm;
import mpn;
import mpo;
import mps;
import msd;

public class GuideHelper
{
  private static long jdField_a_of_type_Long = -1L;
  static String jdField_a_of_type_JavaLangString;
  private static long jdField_b_of_type_Long = -1L;
  public static String b;
  private final int jdField_a_of_type_Int = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  GuideHelper.DelayTryShowRunnable jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable;
  public mps a;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "qav_guide_gesture/data.json";
    jdField_b_of_type_JavaLangString = "qav_guide_gesture/images/";
  }
  
  public GuideHelper()
  {
    this.jdField_a_of_type_Mps = new mps();
  }
  
  private int a(long paramLong, Context paramContext)
  {
    boolean bool1 = a(paramLong, paramContext);
    boolean bool2 = a(paramContext);
    int i = -1;
    if ((!bool1) && (!bool2)) {
      i = 2;
    }
    do
    {
      return i;
      if (!bool1) {
        return 0;
      }
    } while (bool2);
    return 1;
  }
  
  static long a(Context paramContext)
  {
    if (jdField_a_of_type_Long == -1L) {
      jdField_a_of_type_Long = bhhr.a(paramContext).getLong("qav_UserGuide_gesture_had_show", 0L);
    }
    return jdField_a_of_type_Long;
  }
  
  private void a(long paramLong, Context paramContext, int paramInt)
  {
    int j = a(paramLong, paramContext);
    if ((j != -1) && ((paramInt == 2) || ((j != 2) && (paramInt == j)) || (j == 2))) {}
    for (int i = 1; i == 0; i = 0)
    {
      if (AudioHelper.e()) {
        QLog.w("GuideHelper", 1, "tryShow, checkCondition false, had_show[" + jdField_a_of_type_Long + "], seq[" + paramLong + "]canShowTarget[" + j + "]");
      }
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.w("GuideHelper", 1, "tryShow, mIsDestroyed[" + this.jdField_b_of_type_Boolean + "], seq[" + paramLong + "]");
      return;
    }
    i = paramInt;
    if (paramInt == 2) {
      if (j != 2) {
        break label233;
      }
    }
    label233:
    for (i = 0; !a(paramLong, paramContext, i); i = j)
    {
      QLog.w("GuideHelper", 1, "tryShow, initTipsView false, had_show[" + jdField_a_of_type_Long + "], seq[" + paramLong + "]");
      return;
    }
    if ((this.jdField_a_of_type_Mps.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) && (i == 0))
    {
      QLog.w("GuideHelper", 1, "tryShow, loadedLottieDrawable, seq[" + paramLong + "]");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("GuideHelper", 1, "not support show double times guider under one-time talk");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Mps.a(true);
    msd.a();
    bjum.a().postDelayed(new GuideHelper.3(this, paramLong), 5000L);
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
    paramContext = bhhr.a(paramContext).edit();
    paramContext.putLong("qav_UserGuide_gesture_had_show", jdField_a_of_type_Long);
    paramContext.apply();
    QLog.w("AVActivity", 1, "qav_UserGuide_gesture, save, time[" + jdField_a_of_type_Long + "], seq[" + paramLong + "]");
  }
  
  private boolean a(long paramLong, Context paramContext)
  {
    boolean bool1 = false;
    if (a(paramContext) == 0L)
    {
      paramContext = (AVActivity)paramContext;
      lfe locallfe = VideoController.a().a();
      if ((locallfe == null) || (paramContext.a == null)) {
        return true;
      }
      boolean bool3 = locallfe.t();
      boolean bool4 = paramContext.a.i();
      boolean bool5 = paramContext.a.a().b(0);
      boolean bool2 = paramContext.a.d(paramLong);
      if ((bool3) && (bool4) && (bool5) && (bool2)) {}
    }
    for (bool1 = true;; bool1 = true) {
      return bool1;
    }
  }
  
  private boolean a(long paramLong, Context paramContext, int paramInt)
  {
    if (!(paramContext instanceof AVActivity)) {
      QLog.w("GuideHelper", 1, "initTipsView, fail, context[" + paramContext + "], seq[" + paramLong + "]");
    }
    label291:
    for (;;)
    {
      return false;
      AVActivity localAVActivity = (AVActivity)paramContext;
      int i;
      if (paramInt == 0)
      {
        i = 1;
        if (this.jdField_a_of_type_Mps.jdField_a_of_type_AndroidViewView == null)
        {
          if (this.jdField_a_of_type_Mps.jdField_a_of_type_AndroidViewViewStub == null)
          {
            this.jdField_a_of_type_Mps.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)localAVActivity.findViewById(2131373510));
            if (this.jdField_a_of_type_Mps.jdField_a_of_type_AndroidViewViewStub != null) {
              this.jdField_a_of_type_Mps.jdField_a_of_type_AndroidViewViewStub.inflate();
            }
          }
          this.jdField_a_of_type_Mps.b = localAVActivity.findViewById(2131373671);
          this.jdField_a_of_type_Mps.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Mps.b.findViewById(2131373753);
        }
        this.jdField_a_of_type_Mps.b.setOnTouchListener(new mpm(this, paramLong));
        if (i == 0) {
          break label246;
        }
        if (this.jdField_a_of_type_Mps.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
          new mpo().a(paramLong, paramContext, jdField_a_of_type_JavaLangString, new mpn(this, paramLong, paramContext, paramInt));
        }
      }
      for (;;)
      {
        if ((localAVActivity == null) || (localAVActivity.a == null) || (localAVActivity.a.a() == null)) {
          break label291;
        }
        return true;
        i = 0;
        break;
        label246:
        paramContext = this.jdField_a_of_type_Mps.jdField_a_of_type_AndroidViewView.getLayoutParams();
        paramContext.width = -2;
        paramContext.height = -2;
        this.jdField_a_of_type_Mps.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localAVActivity.getResources().getDrawable(2130842092));
      }
    }
  }
  
  private boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (b(paramContext) != 0L) {
      bool1 = true;
    }
    int i;
    for (;;)
    {
      if (!bool1)
      {
        paramContext = (AVActivity)paramContext;
        lfe locallfe = VideoController.a().a();
        if ((locallfe == null) || (paramContext.a == null))
        {
          return true;
          bool1 = false;
        }
        else if (!locallfe.d())
        {
          i = 1;
          bool1 = paramContext.a.i();
          boolean bool3 = paramContext.a.a().b(0);
          if ((bool1) && (bool3))
          {
            bool1 = bool2;
            if (i != 0) {
              break;
            }
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      return bool1;
      i = 0;
      break;
    }
  }
  
  private static long b(Context paramContext)
  {
    if (jdField_b_of_type_Long == -1L) {
      jdField_b_of_type_Long = bhhr.a(paramContext).getLong("qav_UserGuide_textchat_had_show2", 0L);
    }
    return jdField_b_of_type_Long;
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_Mps.a(false);
  }
  
  private static void b(Context paramContext, long paramLong)
  {
    jdField_b_of_type_Long = System.currentTimeMillis();
    paramContext = bhhr.a(paramContext).edit();
    paramContext.putLong("qav_UserGuide_textchat_had_show2", jdField_b_of_type_Long);
    paramContext.apply();
    QLog.w("AVActivity", 1, "qav_UserGuide_gesture, save, time[" + jdField_a_of_type_Long + "], seq[" + paramLong + "]");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    a(-1L, this.jdField_a_of_type_AndroidContentContext, 1);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
    if (this.jdField_a_of_type_Mps.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_Mps.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
      this.jdField_a_of_type_Mps.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.recycleBitmaps();
      this.jdField_a_of_type_Mps.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.clearComposition();
      this.jdField_a_of_type_Mps.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setImageAssetDelegate(null);
    }
    this.jdField_a_of_type_Mps.a();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(long paramLong, Context paramContext, int paramInt1, int paramInt2)
  {
    if (4 == paramInt1)
    {
      if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable == null) {
        this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable = new GuideHelper.DelayTryShowRunnable();
      }
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable.jdField_a_of_type_Int = paramInt2;
    }
    do
    {
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable.a(paramLong, paramContext, this, 2000L);
      while (paramInt1 == 0)
      {
        b(paramLong);
        return;
        if (3 == paramInt1)
        {
          if (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable != null) {
            this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper$DelayTryShowRunnable.a(paramLong);
          }
          b(paramLong);
        }
      }
    } while (99 != paramInt1);
    a(paramLong, paramContext, paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper
 * JD-Core Version:    0.7.0.1
 */