package com.tencent.mobileqq.apollo.statistics.product;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/product/ApolloDtReportUtil;", "", "()V", "APOLLO_DEBUG_KEY", "", "APOLLO_KEY", "TAG", "sApolloTagSelectedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "apolloCmEmojiSendReport", "", "apolloEmojiList", "Ljava/util/ArrayList;", "mAppInterface", "Lcom/tencent/common/app/AppInterface;", "mCurType", "getApolloMode", "app", "getFeeTypeByActionId", "actionId", "getFriendUin", "getPersonNum", "personNum", "actionType", "getReportModeByPackageId", "packageId", "getReportSessionType", "type", "getSessionType", "getUserStatus", "report", "pageCode", "modeCode", "eventCode", "params", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloDtReportUtil
{
  @JvmField
  @NotNull
  public static final HashMap<Integer, String> a;
  public static final ApolloDtReportUtil b = new ApolloDtReportUtil();
  
  static
  {
    a = new HashMap();
    UserAction.registerTunnel(new TunnelInfo("0AND0FB8I14UU93I", AppSetting.h(), "1000"));
  }
  
  @JvmStatic
  public static final int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 1000) && (paramInt != 1045))
        {
          if (paramInt != 3000) {
            return paramInt;
          }
          return 2;
        }
        return 3;
      }
      return 1;
    }
    return 0;
  }
  
  @JvmStatic
  public static final int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5) {
      paramInt1 = 3;
    }
    return paramInt1;
  }
  
  @JvmStatic
  public static final int a(@NotNull AppInterface paramAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    int i = ((IApolloManagerService)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus();
    if (i != 1)
    {
      if (i != 2) {
        return i;
      }
      return 1;
    }
    return 0;
  }
  
  @JvmStatic
  @Nullable
  public static final String a()
  {
    boolean bool = BaseActivity.sTopActivity instanceof BaseActivity;
    Object localObject2 = null;
    if (bool)
    {
      Object localObject1 = BaseActivity.sTopActivity;
      if (localObject1 != null)
      {
        if (((BaseActivity)localObject1).getChatFragment() != null)
        {
          localObject1 = ((BaseActivity)localObject1).getChatFragment();
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.chatFragment!!");
          Object localObject3 = ((ChatFragment)localObject1).k();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject3 = ((BaseChatPie)localObject3).ah;
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((SessionInfo)localObject3).b;
            }
          }
          return localObject1;
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
      }
    }
    return null;
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "pageCode");
    Intrinsics.checkParameterIsNotNull(paramString2, "modeCode");
    Intrinsics.checkParameterIsNotNull(paramString3, "eventCode");
    ThreadManager.getSubThreadHandler().post((Runnable)new ApolloDtReportUtil.report.1(paramString1, paramString2, paramString3, paramMap));
  }
  
  @JvmStatic
  public static final void a(@NotNull ArrayList<Integer> paramArrayList, @NotNull AppInterface paramAppInterface, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "apolloEmojiList");
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "mAppInterface");
    if (paramArrayList.size() > 0)
    {
      String[] arrayOfString = new String[5];
      Object localObject3 = null;
      Object localObject1 = (String)null;
      arrayOfString[0] = localObject1;
      arrayOfString[1] = localObject1;
      arrayOfString[2] = localObject1;
      arrayOfString[3] = localObject1;
      arrayOfString[4] = localObject1;
      localObject1 = (StringBuilder)null;
      int j = ((Collection)paramArrayList).size();
      int i = 0;
      while (i < j)
      {
        if (i <= 4)
        {
          arrayOfString[i] = String.valueOf(((Number)paramArrayList.get(i)).intValue());
        }
        else
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder();
          }
          localObject1 = paramArrayList.get(i);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "apolloEmojiList[k]");
          ((StringBuilder)localObject2).append(((Number)localObject1).intValue());
          localObject1 = localObject2;
          if (i != paramArrayList.size())
          {
            ((StringBuilder)localObject2).append(",");
            localObject1 = localObject2;
          }
        }
        i += 1;
      }
      Object localObject2 = new DtReportParamsBuilder().a(a(paramAppInterface)).b(a(paramInt)).f(arrayOfString[0]).g(arrayOfString[1]).h(arrayOfString[2]).i(arrayOfString[3]).j(arrayOfString[4]);
      paramArrayList = localObject3;
      if (localObject1 != null) {
        paramArrayList = ((StringBuilder)localObject1).toString();
      }
      a("aio", "cm_emoji", "send", (Map)((DtReportParamsBuilder)localObject2).l(paramArrayList).f(b(paramAppInterface)).c(a()).a());
    }
  }
  
  @JvmStatic
  public static final int b()
  {
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      Object localObject = BaseActivity.sTopActivity;
      if (localObject != null)
      {
        if (((BaseActivity)localObject).getChatFragment() != null)
        {
          localObject = ((BaseActivity)localObject).getChatFragment();
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.chatFragment!!");
          localObject = ((ChatFragment)localObject).k();
          if (localObject != null) {
            return ((BaseChatPie)localObject).ah.a;
          }
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
      }
    }
    return -1;
  }
  
  @JvmStatic
  public static final int b(@NotNull AppInterface paramAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    IRuntimeService localIRuntimeService = paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
    return ((IApolloManagerService)localIRuntimeService).getApolloStatus(paramAppInterface.getCurrentUin());
  }
  
  @JvmStatic
  @NotNull
  public static final String b(int paramInt)
  {
    if (paramInt != 0)
    {
      String str = "package_double";
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 300)
            {
              if (paramInt != 301)
              {
                str = "package_gif";
                if (paramInt != 303)
                {
                  switch (paramInt)
                  {
                  default: 
                    return "package_single";
                  case 10: 
                    return "package_game";
                  case 9: 
                    return "package_gif";
                  case 8: 
                    return "package_recommend";
                  case 7: 
                    return "package_vip";
                  }
                  return "package_slave";
                }
              }
              return str;
            }
            return "package_single";
          }
          return "package_collect";
        }
        return "package_text";
      }
      return "package_double";
    }
    return "package_single";
  }
  
  @JvmStatic
  public static final int c(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = ((IApolloDaoManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt);
      if (localObject != null) {
        return ((ApolloActionData)localObject).feeType;
      }
      return 0;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil
 * JD-Core Version:    0.7.0.1
 */