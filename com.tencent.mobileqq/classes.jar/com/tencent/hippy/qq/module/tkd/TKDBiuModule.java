package com.tencent.hippy.qq.module.tkd;

import android.app.Activity;
import com.tencent.hippy.qq.module.QQBaseLifecycleModule;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@HippyNativeModule(name="TKDBiuModule")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/hippy/qq/module/tkd/TKDBiuModule;", "Lcom/tencent/hippy/qq/module/QQBaseLifecycleModule;", "context", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "openBiuEditor", "", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "activity", "Landroid/app/Activity;", "openCommentPublisher", "Companion", "ParamsFetcher", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TKDBiuModule
  extends QQBaseLifecycleModule
{
  private static final String ARG_BIU_TIME = "biuTime";
  private static final String ARG_COMMENT = "comment";
  private static final String ARG_NICK_NAME = "nick";
  private static final String ARG_ROW_KEY = "rowKey";
  private static final String ARG_UIN = "uin";
  public static final TKDBiuModule.Companion Companion = new TKDBiuModule.Companion(null);
  private static final int REQ_CODE_BIU_EDITOR_NATIVE = 113;
  private static final String TAG = "TKDBiuModule";
  
  public TKDBiuModule(@Nullable HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private final void openBiuEditor(HippyMap paramHippyMap, Activity paramActivity)
  {
    paramHippyMap.getString("rowKey");
    long l = paramHippyMap.getLong("uin");
    Object localObject = paramHippyMap.getString("comment");
    if (localObject != null)
    {
      localObject = Base64Util.decode((String)localObject, 0);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Base64Util.decode(params…: \"\", Base64Util.DEFAULT)");
      localObject = new String((byte[])localObject, Charsets.UTF_8);
      paramHippyMap.getInt("biuTime");
      paramHippyMap = paramHippyMap.getString("nick");
      if (paramHippyMap == null) {
        break label132;
      }
    }
    for (;;)
    {
      paramHippyMap = Base64Util.decode(paramHippyMap, 0);
      Intrinsics.checkExpressionValueIsNotNull(paramHippyMap, "Base64Util.decode(params…: \"\", Base64Util.DEFAULT)");
      paramHippyMap = new String(paramHippyMap, Charsets.UTF_8);
      TKDCommentDispatcher.INSTANCE.getEvent().biuComment((TKDBiuModule.ParamsFetcher)new TKDBiuModule.openBiuEditor.1(paramActivity, (String)localObject, l, paramHippyMap));
      return;
      localObject = "";
      break;
      label132:
      paramHippyMap = "";
    }
  }
  
  @HippyMethod(name="openBiuPublisher")
  public final void openCommentPublisher(@NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    UIThreadUtils.runOnUiThread((Runnable)new TKDBiuModule.openCommentPublisher.1(this, paramHippyMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDBiuModule
 * JD-Core Version:    0.7.0.1
 */