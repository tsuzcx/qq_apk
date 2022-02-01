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
    if (paramVideoAppInterface == null) {}
    do
    {
      return;
      QLog.w("NewTipsManager", 1, "hideAllTips, seq[" + paramLong + "]");
      paramVideoAppInterface = (TipsManager)paramVideoAppInterface.a(11);
    } while (paramVideoAppInterface == null);
    paramVideoAppInterface.b();
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((TipsManager)paramVideoAppInterface.a(11)).c();
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((TipsManager)paramVideoAppInterface.a(11)).a(paramInt);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((TipsManager)paramVideoAppInterface.a(11)).a(paramBoolean);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.a(11)).a(paramInt);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return a(paramVideoAppInterface, paramInt1, paramVideoAppInterface.getApp().getString(paramInt2));
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, long paramLong)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.a(11)).a(paramInt, paramLong);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.a(11)).a(paramInt, paramLong, paramBoolean);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, String paramString)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.a(11)).a(paramInt, paramString);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.a(11)).a(paramInt1, paramString, paramDrawable, paramInt2, paramOnClickListener);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.a(11)).a(paramInt, paramString, null, -1, paramOnClickListener);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((TipsManager)paramVideoAppInterface.a(11)).a(paramString, paramLong, paramBoolean);
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((TipsManager)paramVideoAppInterface.a(11)).d();
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.tips.TipsUtil
 * JD-Core Version:    0.7.0.1
 */