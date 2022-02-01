package com.tencent.av.tips;

import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class TipsUtil
{
  public static void a(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hideAllNormalTips, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("NewTipsManager", 1, localStringBuilder.toString());
    paramVideoAppInterface = (TipsManager)paramVideoAppInterface.c(11);
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.b();
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((TipsManager)paramVideoAppInterface.c(11)).d();
  }
  
  @Deprecated
  public static void a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((TipsManager)paramVideoAppInterface.c(11)).a(paramBoolean);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.c(11)).a(paramInt);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return a(paramVideoAppInterface, paramInt1, paramVideoAppInterface.getApp().getString(paramInt2));
  }
  
  @Deprecated
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, long paramLong)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.c(11)).a(paramInt, paramLong);
  }
  
  @Deprecated
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.c(11)).a(paramInt, paramLong, paramBoolean);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, String paramString)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.c(11)).a(paramInt, paramString);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.c(11)).a(paramInt1, paramString, paramDrawable, paramInt2, paramOnClickListener);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.c(11)).a(paramInt, paramString, null, -1, paramOnClickListener);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.c(11)).a(paramInt, paramString1, paramString2, null, -1, paramOnClickListener);
  }
  
  @Deprecated
  public static boolean a(VideoAppInterface paramVideoAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.c(11)).a(paramString, paramLong, paramBoolean);
  }
  
  @Deprecated
  public static boolean a(VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, View.OnClickListener paramOnClickListener, long paramLong, boolean paramBoolean)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.c(11)).a(paramString1, paramString2, paramOnClickListener, paramLong, paramBoolean);
  }
  
  public static void b(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hideAllTips, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("NewTipsManager", 1, localStringBuilder.toString());
    paramVideoAppInterface = (TipsManager)paramVideoAppInterface.c(11);
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.c();
    }
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((TipsManager)paramVideoAppInterface.c(11)).e();
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((TipsManager)paramVideoAppInterface.c(11)).b(paramInt);
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.TipsUtil
 * JD-Core Version:    0.7.0.1
 */