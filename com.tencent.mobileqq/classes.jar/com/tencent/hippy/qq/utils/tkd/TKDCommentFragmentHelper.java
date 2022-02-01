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
  private static final String TKD_COMMENT = "TKDComment";
  private static final String TKD_COMMENT_SWITCH = "comment_hippy_switch";
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
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 24	com/tencent/hippy/qq/utils/tkd/TKDCommentFragmentHelper:hippyCommentConfig	Lcom/tencent/aladdin/config/AladdinConfig;
    //   8: ifnonnull +12 -> 20
    //   11: sipush 383
    //   14: invokestatic 32	com/tencent/aladdin/config/Aladdin:get	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   17: putstatic 24	com/tencent/hippy/qq/utils/tkd/TKDCommentFragmentHelper:hippyCommentConfig	Lcom/tencent/aladdin/config/AladdinConfig;
    //   20: ldc 11
    //   22: invokestatic 38	com/tencent/hippy/qq/app/HippyQQEngine:getModuleOnlineConfig	(Ljava/lang/String;)I
    //   25: istore_0
    //   26: getstatic 24	com/tencent/hippy/qq/utils/tkd/TKDCommentFragmentHelper:hippyCommentConfig	Lcom/tencent/aladdin/config/AladdinConfig;
    //   29: ldc 14
    //   31: iconst_0
    //   32: invokevirtual 44	com/tencent/aladdin/config/AladdinConfig:getIntegerFromString	(Ljava/lang/String;I)I
    //   35: istore_1
    //   36: ldc 8
    //   38: iconst_1
    //   39: new 46	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   46: ldc 49
    //   48: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_1
    //   52: invokevirtual 56	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc 58
    //   57: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_0
    //   61: invokevirtual 56	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: iload_0
    //   71: iconst_1
    //   72: if_icmpne +13 -> 85
    //   75: iload_1
    //   76: iconst_1
    //   77: if_icmpne +8 -> 85
    //   80: ldc 2
    //   82: monitorexit
    //   83: iload_2
    //   84: ireturn
    //   85: iconst_0
    //   86: istore_2
    //   87: goto -7 -> 80
    //   90: astore_3
    //   91: ldc 2
    //   93: monitorexit
    //   94: aload_3
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   25	48	0	i	int
    //   35	43	1	j	int
    //   1	86	2	bool	boolean
    //   90	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	20	90	finally
    //   20	70	90	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.tkd.TKDCommentFragmentHelper
 * JD-Core Version:    0.7.0.1
 */