package com.tencent.biz.pubaccount.weishi_new.verticalvideo.guide;

import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/guide/WSCommentAtHelper;", "", "()V", "KEY_AT_GUIDE_SHOWED_TIME", "", "KEY_EXP_AT_GUIDE_SHOW_TIME", "TAG", "atGuideShowedTime", "", "getAtGuideShowedTime", "()I", "setAtGuideShowedTime", "(I)V", "currentUin", "getCurrentUin", "()Ljava/lang/String;", "setCurrentUin", "(Ljava/lang/String;)V", "checkExpAtGuideShowTimeChanged", "", "getAtGuideAutoDismissTime", "getAtGuideDelayPlayProcess", "getAtGuideDelayPlayTime", "", "getAtGuideShowTime", "getAtIconUrl", "getCommentPolicyValue", "key", "isCommentAtFeatureOpen", "", "isInShowTime", "isShowAtGuide", "process", "", "playTime", "refreshCommentAtGuideData", "saveCommentAtGuideShowTime", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSCommentAtHelper
{
  public static final WSCommentAtHelper a = new WSCommentAtHelper();
  @NotNull
  private static String b = "";
  private static int c;
  
  private final String a(String paramString)
  {
    Object localObject = WSExpABTestManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "WSExpABTestManager.getInstance()");
    localObject = ((WSExpABTestManager)localObject).y();
    if (localObject != null)
    {
      paramString = (String)((Map)localObject).get(paramString);
      if (paramString != null) {
        return paramString;
      }
      return "";
    }
    return "";
  }
  
  private final void e()
  {
    Object localObject = WSExpABTestManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "WSExpABTestManager.getInstance()");
    localObject = ((WSExpABTestManager)localObject).c();
    if ((Intrinsics.areEqual(b, localObject) ^ true))
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "uin");
      b = (String)localObject;
      f();
      c = WSSharePreferencesUtil.d("key_at_guide_showed_time", 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSCommentAtHelper.kt][refreshCommentAtGuideData] atGuideShowedTime:");
      ((StringBuilder)localObject).append(c);
      WSLog.d("WSCommentAtHelperLog", ((StringBuilder)localObject).toString());
    }
  }
  
  private final void f()
  {
    int i = h();
    int j = WSSharePreferencesUtil.d("key_exp_at_guide_show_time", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSCommentAtHelper.kt][checkExpAtGuideShowTimeChanged] expAtGuideShowTime:");
    localStringBuilder.append(i);
    localStringBuilder.append(", expAtGuideShowTimeFromSp:");
    localStringBuilder.append(j);
    WSLog.d("WSCommentAtHelperLog", localStringBuilder.toString());
    if (i != j)
    {
      WSSharePreferencesUtil.c("key_exp_at_guide_show_time", i);
      WSSharePreferencesUtil.c("key_at_guide_showed_time", 0);
    }
  }
  
  private final boolean g()
  {
    int i = h();
    if (i < 0) {
      return true;
    }
    return c < i;
  }
  
  private final int h()
  {
    return WeishiUtils.a(a("show_time"), 0);
  }
  
  private final long i()
  {
    return WeishiUtils.a(a("delay_play_time"), 0L);
  }
  
  private final int j()
  {
    int j = WeishiUtils.a(a("delay_play_process"), 110);
    int i = j;
    if (j == 100) {
      i = 99;
    }
    return i;
  }
  
  public final void a()
  {
    c += 1;
    WSSharePreferencesUtil.c("key_at_guide_showed_time", c);
  }
  
  public final boolean a(float paramFloat, long paramLong)
  {
    boolean bool1 = b();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    e();
    bool1 = bool2;
    if (g())
    {
      bool1 = bool2;
      if (paramFloat * 100 >= j())
      {
        bool1 = bool2;
        if (paramLong >= i() * 1000) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final boolean b()
  {
    return Intrinsics.areEqual("1", a("switch"));
  }
  
  @NotNull
  public final String c()
  {
    return a("image");
  }
  
  public final int d()
  {
    return WeishiUtils.a(a("auto_dismiss_time"), -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.guide.WSCommentAtHelper
 * JD-Core Version:    0.7.0.1
 */