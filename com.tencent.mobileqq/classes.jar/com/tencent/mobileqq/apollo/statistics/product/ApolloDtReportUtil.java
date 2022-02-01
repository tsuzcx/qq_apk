package com.tencent.mobileqq.apollo.statistics.product;

import android.support.v4.app.FragmentActivity;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
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
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/product/ApolloDtReportUtil;", "", "()V", "APOLLO_DEBUG_KEY", "", "APOLLO_EVEMT_ROTATE", "APOLLO_EVENT_BIG_EXPOSE", "APOLLO_EVENT_CANCEL_TAG_CLICK", "APOLLO_EVENT_CHANGE_DRESS", "APOLLO_EVENT_CLICK", "APOLLO_EVENT_CLICK_FLOWER", "APOLLO_EVENT_CLICK_STICKER", "APOLLO_EVENT_CLICK_STORE", "APOLLO_EVENT_CLICK_TAG_ACTION", "APOLLO_EVENT_CLOSE", "APOLLO_EVENT_DOWNLOAD", "APOLLO_EVENT_EXPOSE", "APOLLO_EVENT_FAIL", "APOLLO_EVENT_LONG_CLICK", "APOLLO_EVENT_MOVE", "APOLLO_EVENT_OPEN", "APOLLO_EVENT_OPEN_SHOP", "APOLLO_EVENT_PLAY", "APOLLO_EVENT_SAVE", "APOLLO_EVENT_SEND", "APOLLO_EVENT_SEND_FAIL", "APOLLO_EVENT_SEND_SUCCESS", "APOLLO_EVENT_SMALL_EXPOSE", "APOLLO_EVENT_SPRITE_JUMP", "APOLLO_EVENT_SPRITE_OPEN", "APOLLO_EVENT_STAY", "APOLLO_EVENT_SUCCESS", "APOLLO_EVENT_TAG_CLICK", "APOLLO_EVENT_TAG_EXPOSE", "APOLLO_KEY", "APOLLO_MODE_AIO_KEYWORDS", "APOLLO_MODE_APOLLO_MSG", "APOLLO_MODE_APOLLO_MSG_ONE_MORE", "APOLLO_MODE_APOLLO_TIPS", "APOLLO_MODE_BIG_PANEL", "APOLLO_MODE_CHANGE2D", "APOLLO_MODE_CHANGE3D", "APOLLO_MODE_CMSHOW_AVATAR", "APOLLO_MODE_CM_EMOJI", "APOLLO_MODE_EMOJI_CMTAB", "APOLLO_MODE_EMOJI_CMTAB_2D", "APOLLO_MODE_EMOJI_COLLECT", "APOLLO_MODE_HPME_PAGE", "APOLLO_MODE_KAPU_ICON", "APOLLO_MODE_MODEL", "APOLLO_MODE_NEW_USER_PANEL", "APOLLO_MODE_NEW_USER_V2", "APOLLO_MODE_OPEN_BTN", "APOLLO_MODE_PACKAGE_COLLECT", "APOLLO_MODE_PACKAGE_DOUBLE", "APOLLO_MODE_PACKAGE_GAME", "APOLLO_MODE_PACKAGE_GIF", "APOLLO_MODE_PACKAGE_RECOMMEND", "APOLLO_MODE_PACKAGE_SINGLE", "APOLLO_MODE_PACKAGE_SLAVE", "APOLLO_MODE_PACKAGE_TEXT", "APOLLO_MODE_PACKAGE_VIP", "APOLLO_MODE_PANEL_STORE", "APOLLO_MODE_PANEL_TIPS", "APOLLO_MODE_PLUS_PANEL", "APOLLO_MODE_SET_BTN", "APOLLO_MODE_SHOW_MORE", "APOLLO_MODE_SMALL_PANEL", "APOLLO_MODE_SPRITE", "APOLLO_MODE_SPRITE_FLOWER", "APOLLO_MODE_STICKER", "APOLLO_MODE_STICKER_TAB", "APOLLO_MODE_SUCCESS_SET", "APOLLO_MODE_TAG_PAGE", "APOLLO_PAGE_AIO", "APOLLO_PAGE_AIO_BUBBLE", "APOLLO_PAGE_AVATAR_QQ_PAGE", "APOLLO_PAGE_CODE", "APOLLO_PAGE_FRIEND_CARD", "APOLLO_PAGE_PANEL", "APOLLO_PAGE_SETTING_ME", "APOLLO_PARAMS_KEY_ACTIONID", "APOLLO_PARAMS_KEY_DURATION", "APOLLO_PARAMS_KEY_ENTRY", "APOLLO_PARAMS_KEY_EXTEND1", "APOLLO_PARAMS_KEY_EXTEND2", "APOLLO_PARAMS_KEY_EXTEND3", "APOLLO_PARAMS_KEY_EXTEND4", "APOLLO_PARAMS_KEY_EXTEND5", "APOLLO_PARAMS_KEY_EXTEND_MORE", "APOLLO_PARAMS_KEY_GUEST", "APOLLO_PARAMS_KEY_ITEMIDS", "APOLLO_PARAMS_KEY_KEY_TEXT", "APOLLO_PARAMS_KEY_MODE", "APOLLO_PARAMS_KEY_OWNER_STATUS", "APOLLO_PARAMS_KEY_PEER_STATUS", "APOLLO_PARAMS_KEY_PEER_UIN", "APOLLO_PARAMS_KEY_PERSON_NUM", "APOLLO_PARAMS_KEY_QQ_UIN", "APOLLO_PARAMS_KEY_TIMESTAMP", "APOLLO_PARAMS_KEY_TYPE", "APOLLO_PARAMS_KEY_VIP", "TAG", "sApolloTagSelectedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "apolloCmEmojiSendReport", "", "apolloEmojiList", "Ljava/util/ArrayList;", "mAppInterface", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mCurType", "getApolloMode", "app", "getFeeTypeByActionId", "actionId", "getFriendUin", "getPersonNum", "personNum", "actionType", "getReportModeByPackageId", "packageId", "getReportSessionType", "type", "getSessionType", "getUserStatus", "report", "pageCode", "modeCode", "eventCode", "params", "", "DtReportParamsBuilder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloDtReportUtil
{
  public static final ApolloDtReportUtil a;
  @JvmField
  @NotNull
  public static final HashMap<Integer, String> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloStatisticsProductApolloDtReportUtil = new ApolloDtReportUtil();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    UserAction.registerTunnel(new TunnelInfo("0AND0FB8I14UU93I", AppSetting.f(), "1000"));
  }
  
  @JvmStatic
  public static final int a()
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      Object localObject = BaseActivity.sTopActivity;
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      }
      localObject = (FragmentActivity)localObject;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        localObject = ((FragmentActivity)localObject).getChatFragment();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.chatFragment!!");
        localObject = ((ChatFragment)localObject).a();
        if (localObject != null) {
          return ((BaseChatPie)localObject).a.jdField_a_of_type_Int;
        }
      }
    }
    return -1;
  }
  
  @JvmStatic
  public static final int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 3000: 
      return 2;
    case 1000: 
      return 3;
    }
    return 3;
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
  public static final int a(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    switch (((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus((AppRuntime)paramQQAppInterface))
    {
    default: 
      return 0;
    case 1: 
      return 0;
    }
    return 1;
  }
  
  @JvmStatic
  @Nullable
  public static final String a()
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      Object localObject = BaseActivity.sTopActivity;
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      }
      localObject = (FragmentActivity)localObject;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        localObject = ((FragmentActivity)localObject).getChatFragment();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.chatFragment!!");
        localObject = ((ChatFragment)localObject).a();
        if (localObject != null)
        {
          localObject = ((BaseChatPie)localObject).a;
          if (localObject != null) {
            return ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
          }
        }
        return null;
      }
    }
    return null;
  }
  
  @JvmStatic
  @NotNull
  public static final String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "package_single";
    case 0: 
      return "package_single";
    case 1: 
      return "package_double";
    case 8: 
      return "package_recommend";
    case 3: 
      return "package_collect";
    case 9: 
      return "package_gif";
    case 7: 
      return "package_vip";
    case 6: 
      return "package_slave";
    case 2: 
      return "package_text";
    case 10: 
      return "package_game";
    case 300: 
      return "package_single";
    }
    return "package_double";
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
  public static final void a(@NotNull ArrayList<Integer> paramArrayList, @NotNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject3 = null;
    Intrinsics.checkParameterIsNotNull(paramArrayList, "apolloEmojiList");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "mAppInterface");
    if (paramArrayList.size() > 0)
    {
      String[] arrayOfString = new String[5];
      arrayOfString[0] = ((String)null);
      arrayOfString[1] = ((String)null);
      arrayOfString[2] = ((String)null);
      arrayOfString[3] = ((String)null);
      arrayOfString[4] = ((String)null);
      Object localObject1 = (StringBuilder)null;
      int j = ((Collection)paramArrayList).size();
      int i = 0;
      if (i < j)
      {
        if (i <= 4) {
          arrayOfString[i] = String.valueOf(((Number)paramArrayList.get(i)).intValue());
        }
        for (;;)
        {
          i += 1;
          break;
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
      }
      Object localObject2 = new ApolloDtReportUtil.DtReportParamsBuilder().a(a(paramQQAppInterface)).b(a(paramInt)).c(arrayOfString[0]).d(arrayOfString[1]).e(arrayOfString[2]).f(arrayOfString[3]).g(arrayOfString[4]);
      paramArrayList = localObject3;
      if (localObject1 != null) {
        paramArrayList = ((StringBuilder)localObject1).toString();
      }
      a("aio", "cm_emoji", "send", (Map)((ApolloDtReportUtil.DtReportParamsBuilder)localObject2).h(paramArrayList).f(b(paramQQAppInterface)).b(a()).a());
    }
  }
  
  @JvmStatic
  public static final int b(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = ((IApolloDaoManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt);
    if (localObject != null) {
      return ((ApolloActionData)localObject).feeType;
    }
    return 0;
  }
  
  @JvmStatic
  public static final int b(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    IRuntimeService localIRuntimeService = paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
    return ((IApolloManagerService)localIRuntimeService).getApolloStatus(paramQQAppInterface.getCurrentUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil
 * JD-Core Version:    0.7.0.1
 */