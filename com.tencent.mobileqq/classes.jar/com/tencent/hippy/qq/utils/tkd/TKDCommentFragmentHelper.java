package com.tencent.hippy.qq.utils.tkd;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.hippy.qq.view.tkd.fragment.TKDCommentFragment;
import com.tencent.qphone.base.util.QLog;

public class TKDCommentFragmentHelper
{
  private static final String TAG = "HippyNestHelper";
  private static AladdinConfig hippyCommentConfig;
  
  public static void clearHippyCommentConfig()
  {
    try
    {
      hippyCommentConfig = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static boolean enableHippyComment()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 18	com/tencent/hippy/qq/utils/tkd/TKDCommentFragmentHelper:hippyCommentConfig	Lcom/tencent/aladdin/config/AladdinConfig;
    //   8: ifnonnull +12 -> 20
    //   11: sipush 383
    //   14: invokestatic 26	com/tencent/aladdin/config/Aladdin:get	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   17: putstatic 18	com/tencent/hippy/qq/utils/tkd/TKDCommentFragmentHelper:hippyCommentConfig	Lcom/tencent/aladdin/config/AladdinConfig;
    //   20: getstatic 18	com/tencent/hippy/qq/utils/tkd/TKDCommentFragmentHelper:hippyCommentConfig	Lcom/tencent/aladdin/config/AladdinConfig;
    //   23: ldc 28
    //   25: iconst_0
    //   26: invokevirtual 34	com/tencent/aladdin/config/AladdinConfig:getIntegerFromString	(Ljava/lang/String;I)I
    //   29: istore_0
    //   30: iload_0
    //   31: iconst_1
    //   32: if_icmpne +8 -> 40
    //   35: ldc 2
    //   37: monitorexit
    //   38: iload_1
    //   39: ireturn
    //   40: iconst_0
    //   41: istore_1
    //   42: goto -7 -> 35
    //   45: astore_2
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	4	0	i	int
    //   1	41	1	bool	boolean
    //   45	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	20	45	finally
    //   20	30	45	finally
  }
  
  @Nullable
  public static TKDCommentFragment nestHippyCommentFragment(int paramInt, FragmentManager paramFragmentManager)
  {
    TKDCommentFragment localTKDCommentFragment = null;
    if (paramFragmentManager != null) {
      localTKDCommentFragment = nestHippyFragment(paramInt, "https://viola.qq.com/js/TKDComment.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDComment&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react", paramFragmentManager);
    }
    return localTKDCommentFragment;
  }
  
  @Nullable
  public static TKDCommentFragment nestHippyFragment(int paramInt, String paramString, FragmentManager paramFragmentManager)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    QLog.d("HippyNestHelper", 1, "[nestHippyFragment]hippyUrl: " + paramString + " fragmentManager: " + paramFragmentManager);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (paramFragmentManager != null) {
        localObject1 = localObject3;
      }
    }
    try
    {
      paramString = TKDCommentFragment.create(paramString, null, true);
      localObject1 = paramString;
      paramFragmentManager = paramFragmentManager.beginTransaction();
      localObject1 = paramString;
      paramFragmentManager.replace(paramInt, paramString);
      localObject1 = paramString;
      paramFragmentManager.commit();
      localObject1 = paramString;
      return localObject1;
    }
    catch (Error paramString)
    {
      QLog.e("HippyNestHelper", 1, paramString.getMessage());
    }
    return localObject1;
  }
  
  public static void removeHippyFragment(Fragment paramFragment, FragmentActivity paramFragmentActivity)
  {
    QLog.d("HippyNestHelper", 1, "[removeHippyFragment] parentActivity: " + paramFragmentActivity);
    try
    {
      paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
      if (paramFragmentActivity != null)
      {
        paramFragmentActivity = paramFragmentActivity.beginTransaction();
        paramFragmentActivity.hide(paramFragment);
        paramFragmentActivity.commit();
      }
      return;
    }
    catch (Error paramFragment)
    {
      QLog.e("HippyNestHelper", 1, paramFragment.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.tkd.TKDCommentFragmentHelper
 * JD-Core Version:    0.7.0.1
 */