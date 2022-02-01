package com.tencent.biz.pubaccount.weishi_new.push;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/push/WSPushUtil;", "", "()V", "isPushToDrama", "", "pushMsgData", "Lcom/tencent/biz/pubaccount/weishi_new/push/WSRedDotPushMsg;", "isPushToFollow", "isPushToOpenHomeThenVideo", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSPushUtil
{
  public static final WSPushUtil a = new WSPushUtil();
  
  @JvmStatic
  public static final boolean a(@Nullable WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if (paramWSRedDotPushMsg != null)
    {
      paramWSRedDotPushMsg = paramWSRedDotPushMsg.mStrategyInfo;
      if (paramWSRedDotPushMsg != null)
      {
        paramWSRedDotPushMsg = Integer.valueOf(paramWSRedDotPushMsg.getType());
        break label28;
      }
    }
    paramWSRedDotPushMsg = null;
    label28:
    return ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.intValue() == 6)) || ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.intValue() == 7));
  }
  
  @JvmStatic
  public static final boolean b(@Nullable WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if (paramWSRedDotPushMsg != null)
    {
      paramWSRedDotPushMsg = paramWSRedDotPushMsg.mStrategyInfo;
      if ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.getType() == 8)) {
        return true;
      }
    }
    return false;
  }
  
  @JvmStatic
  public static final boolean c(@Nullable WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if (paramWSRedDotPushMsg != null)
    {
      paramWSRedDotPushMsg = paramWSRedDotPushMsg.mStrategyInfo;
      if ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.getType() == 5)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushUtil
 * JD-Core Version:    0.7.0.1
 */