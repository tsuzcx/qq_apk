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
  static String c = "qav_guide_gesture/data.json";
  static String d = "qav_guide_gesture/images/";
  private static long i = -1L;
  private static long j = -1L;
  GuideHelper.DelayTryShowRunnable a;
  GuideHelper.ViewInfo b = new GuideHelper.ViewInfo();
  private Context e;
  private final int f = 2;
  private boolean g = false;
  private boolean h = false;
  
  private int a(long paramLong, Context paramContext)
  {
    boolean bool1 = b(paramLong, paramContext);
    boolean bool2 = c(paramContext);
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
  
  static void a(Context paramContext, long paramLong)
  {
    i = System.currentTimeMillis();
    paramContext = SharedPreUtils.B(paramContext).edit();
    paramContext.putLong("qav_UserGuide_gesture_had_show", i);
    paramContext.apply();
    paramContext = new StringBuilder();
    paramContext.append("qav_UserGuide_gesture, save, time[");
    paramContext.append(i);
    paramContext.append("], seq[");
    paramContext.append(paramLong);
    paramContext.append("]");
    QLog.w("AVActivity", 1, paramContext.toString());
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
    int k;
    if (paramInt == 0) {
      k = 1;
    } else {
      k = 0;
    }
    if (this.b.b == null)
    {
      if (this.b.a == null)
      {
        this.b.a = ((ViewStub)((AVActivity)localObject).findViewById(2131441070));
        if (this.b.a != null) {
          this.b.a.inflate();
        }
      }
      this.b.c = ((AVActivity)localObject).findViewById(2131441230);
      GuideHelper.ViewInfo localViewInfo = this.b;
      localViewInfo.b = localViewInfo.c.findViewById(2131441288);
    }
    this.b.c.setOnTouchListener(new GuideHelper.1(this, paramLong));
    if (k != 0)
    {
      if (this.b.d == null) {
        new GuideHelper.LottieDrawableHelper().a(paramLong, paramContext, c, new GuideHelper.2(this, paramLong, paramContext, paramInt));
      }
    }
    else
    {
      paramContext = this.b.b.getLayoutParams();
      paramContext.width = -2;
      paramContext.height = -2;
      this.b.b.setBackgroundDrawable(((AVActivity)localObject).getResources().getDrawable(2130843061));
    }
    if ((localObject != null) && (((AVActivity)localObject).K != null)) {
      return ((AVActivity)localObject).K.al() != null;
    }
    return false;
  }
  
  static long b(Context paramContext)
  {
    if (i == -1L) {
      i = SharedPreUtils.B(paramContext).getLong("qav_UserGuide_gesture_had_show", 0L);
    }
    return i;
  }
  
  private void b(long paramLong)
  {
    this.b.a(false);
  }
  
  private void b(long paramLong, Context paramContext, int paramInt)
  {
    int m = a(paramLong, paramContext);
    if ((m != -1) && ((paramInt == 2) || ((m != 2) && (paramInt == m)) || (m == 2))) {
      k = 1;
    } else {
      k = 0;
    }
    if (k == 0)
    {
      if (AudioHelper.a())
      {
        paramContext = new StringBuilder();
        paramContext.append("tryShow, checkCondition false, had_show[");
        paramContext.append(i);
        paramContext.append("], seq[");
        paramContext.append(paramLong);
        paramContext.append("]canShowTarget[");
        paramContext.append(m);
        paramContext.append("]");
        QLog.w("GuideHelper", 1, paramContext.toString());
      }
      return;
    }
    if (this.h)
    {
      paramContext = new StringBuilder();
      paramContext.append("tryShow, mIsDestroyed[");
      paramContext.append(this.h);
      paramContext.append("], seq[");
      paramContext.append(paramLong);
      paramContext.append("]");
      QLog.w("GuideHelper", 1, paramContext.toString());
      return;
    }
    int k = paramInt;
    if (paramInt == 2) {
      if (m == 2) {
        k = 0;
      } else {
        k = m;
      }
    }
    if (!a(paramLong, paramContext, k))
    {
      paramContext = new StringBuilder();
      paramContext.append("tryShow, initTipsView false, had_show[");
      paramContext.append(i);
      paramContext.append("], seq[");
      paramContext.append(paramLong);
      paramContext.append("]");
      QLog.w("GuideHelper", 1, paramContext.toString());
      return;
    }
    if ((this.b.d == null) && (k == 0))
    {
      paramContext = new StringBuilder();
      paramContext.append("tryShow, loadedLottieDrawable, seq[");
      paramContext.append(paramLong);
      paramContext.append("]");
      QLog.w("GuideHelper", 1, paramContext.toString());
      return;
    }
    if (this.g)
    {
      QLog.w("GuideHelper", 1, "not support show double times guider under one-time talk");
      return;
    }
    this.g = true;
    this.b.a(true);
    DataReport.ShortCut_For_Effect.a();
    ThreadManager.a().postDelayed(new GuideHelper.3(this, paramLong), 5000L);
    if (k == 0)
    {
      a(paramContext, paramLong);
      return;
    }
    b(paramContext, paramLong);
  }
  
  private static void b(Context paramContext, long paramLong)
  {
    j = System.currentTimeMillis();
    paramContext = SharedPreUtils.B(paramContext).edit();
    paramContext.putLong("qav_UserGuide_textchat_had_show2", j);
    paramContext.apply();
    paramContext = new StringBuilder();
    paramContext.append("qav_UserGuide_gesture, save, time[");
    paramContext.append(i);
    paramContext.append("], seq[");
    paramContext.append(paramLong);
    paramContext.append("]");
    QLog.w("AVActivity", 1, paramContext.toString());
  }
  
  private boolean b(long paramLong, Context paramContext)
  {
    long l = b(paramContext);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (l == 0L)
    {
      paramContext = (AVActivity)paramContext;
      SessionInfo localSessionInfo = VideoController.f().k();
      bool1 = bool2;
      if (localSessionInfo != null)
      {
        if (paramContext.K == null) {
          return true;
        }
        boolean bool3 = localSessionInfo.t();
        boolean bool4 = paramContext.K.ab();
        boolean bool5 = paramContext.K.al().i(0);
        boolean bool6 = paramContext.K.o(paramLong);
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
  
  private boolean c(Context paramContext)
  {
    boolean bool1;
    if (d(paramContext) != 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (!bool1)
    {
      paramContext = (AVActivity)paramContext;
      SessionInfo localSessionInfo = VideoController.f().k();
      if (localSessionInfo != null)
      {
        if (paramContext.K == null) {
          return true;
        }
        bool1 = localSessionInfo.d();
        boolean bool2 = paramContext.K.ab();
        boolean bool3 = paramContext.K.al().i(0);
        return (!bool2) || (!bool3) || (!(bool1 ^ true));
      }
      return true;
    }
    return bool1;
  }
  
  private static long d(Context paramContext)
  {
    if (j == -1L) {
      j = SharedPreUtils.B(paramContext).getLong("qav_UserGuide_textchat_had_show2", 0L);
    }
    return j;
  }
  
  public void a()
  {
    this.g = false;
    b(-1L, this.e, 1);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
    if (this.b.d != null)
    {
      this.b.d.cancelAnimation();
      this.b.d.recycleBitmaps();
      this.b.d.clearComposition();
      this.b.d.setImageAssetDelegate(null);
    }
    this.b.a();
    this.h = true;
    this.g = false;
  }
  
  public void a(long paramLong, Context paramContext, int paramInt1, int paramInt2)
  {
    GuideHelper.DelayTryShowRunnable localDelayTryShowRunnable;
    if (4 == paramInt1)
    {
      if (this.a == null) {
        this.a = new GuideHelper.DelayTryShowRunnable();
      }
      localDelayTryShowRunnable = this.a;
      localDelayTryShowRunnable.a = paramInt2;
      localDelayTryShowRunnable.a(paramLong, paramContext, this, 2000L);
    }
    else if (3 == paramInt1)
    {
      localDelayTryShowRunnable = this.a;
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
      b(paramLong, paramContext, paramInt2);
    }
  }
  
  public void a(Context paramContext)
  {
    this.h = false;
    this.g = false;
    this.e = paramContext;
  }
  
  public boolean a(int paramInt)
  {
    return c(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper
 * JD-Core Version:    0.7.0.1
 */